package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.PostDto;
import com.cms.platform.backend.entity.Post;
import com.cms.platform.backend.entity.Site;
import com.cms.platform.backend.repository.PostRepository;
import com.cms.platform.backend.repository.SiteRepository;
import com.cms.platform.backend.service.PostService;
import lombok.RequiredArgsConstructor;
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
        post.setStatus(Enum.valueOf(com.cms.platform.backend.entity.enums.PostStatus.class, dto.getStatus()));
        post.setSite(site);
        postRepository.save(post);
        return dto;
    }

    @Override
    public List<PostDto> getPostsBySite(UUID siteId) {
        return postRepository.findBySiteId(siteId).stream()
                .map(post -> new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getSeoTitle(), post.getSeoDescription(), post.getStatus().toString(), post.getSite().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(UUID id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getSeoTitle(), post.getSeoDescription(), post.getStatus().toString(), post.getSite().getId());
    }

    @Override
    public PostDto updatePost(UUID id, PostDto dto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setSeoTitle(dto.getSeoTitle());
        post.setSeoDescription(dto.getSeoDescription());
        post.setStatus(Enum.valueOf(com.cms.platform.backend.entity.enums.PostStatus.class, dto.getStatus()));
        postRepository.save(post);
        return dto;
    }

    @Override
    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }
}