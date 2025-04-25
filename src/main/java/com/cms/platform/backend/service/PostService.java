package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.PostDto;
import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getPostsBySite(String siteId);
    PostDto getPostById(String id);
    PostDto updatePost(String id, PostDto postDto);
    void deletePost(String id);
}

