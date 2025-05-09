package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.PostDto;
import com.cms.platform.backend.entity.Media;
import com.cms.platform.backend.entity.Post;
import com.cms.platform.backend.entity.Site;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.repository.PostRepository;
import com.cms.platform.backend.repository.SiteRepository;
import com.cms.platform.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final SiteRepository siteRepository;

    @Override
    public PostDto createPost(PostDto dto) {
        Site site = siteRepository.findById(dto.getSiteId()).orElseThrow(() -> new RuntimeException("Site not found"));
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setSeoTitle(dto.getSeoTitle());
        post.setSeoDescription(dto.getSeoDescription());
        post.setStatus(dto.getStatus());
        post.setThumbnail(dto.getThumbnail());
        post.setAuthor(dto.getAuthor());
        post.setTags(dto.getTags());
        post.setViews(dto.getViews());
        post.setSite(site);
        postRepository.save(post);
        return dto;
    }

    @Override
    public Page<PostDto> getPostsBySite(UUID siteId,int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "uploadedAt"));
        Page<Post> postPage = postRepository.findBySiteId(siteId, pageable);
        return postPage.map(post -> new PostDto(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getSeoTitle(),
                        post.getSeoDescription(),
                        post.getStatus(),
                        post.getTags(),
                        post.getViews(),
                        post.getThumbnail(),
                        post.getAuthor(),
                        post.getCreatedAt(),
                        post.getUpdatedAt(),
                        post.getSite().getId()
                ));
    }

    @Override
    public Page<PostDto> getPostsByUser(User user, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "updatedAt"));
        Page<Post> postPage = postRepository.findByUserId(user.getId(), pageable);
        return postPage.map(post -> new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getSeoTitle(),
                post.getSeoDescription(),
                post.getStatus(),
                post.getTags(),
                post.getViews(),
                post.getThumbnail(),
                post.getAuthor(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getSite().getId()
        ));
    }

    @Override
    public PostDto getPostById(UUID id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getSeoTitle(),
                post.getSeoDescription(),
                post.getStatus(),
                post.getTags(),
                post.getViews(),
                post.getThumbnail(),
                post.getAuthor(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getSite().getId()
        );
    }

    @Override
    public PostDto updatePost(UUID id, PostDto dto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setSeoTitle(dto.getSeoTitle());
        post.setSeoDescription(dto.getSeoDescription());
        post.setStatus(dto.getStatus());
        postRepository.save(post);
        return dto;
    }

    @Override
    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }
}