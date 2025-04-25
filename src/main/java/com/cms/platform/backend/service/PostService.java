package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.PostDto;
import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getPostsBySite(Long siteId);
    PostDto getPostById(Long id);
    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);
}

