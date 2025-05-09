package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.PostDto;
import com.cms.platform.backend.entity.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    Page<PostDto> getPostsBySite(UUID siteId, int page, int size);
    Page<PostDto> getPostsByUser(User user, int page, int size);
    PostDto getPostById(UUID id);
    PostDto updatePost(UUID id, PostDto postDto);
    void deletePost(UUID id);
}

