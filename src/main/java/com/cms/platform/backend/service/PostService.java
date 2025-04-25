package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.PostDto;
import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getPostsBySite(UUID siteId);
    PostDto getPostById(UUID id);
    PostDto updatePost(UUID id, PostDto postDto);
    void deletePost(UUID id);
}

