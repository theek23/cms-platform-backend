package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.PostDto;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping
    public ResponseEntity<Page<PostDto>> getPostsBySite(
            @RequestParam String siteId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(postService.getPostsBySite(UUID.fromString(siteId), page, size));
    }

    @GetMapping("/current")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Page<PostDto>> getPostsByUser(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        System.out.println("Page: " + page + ", Size: " + size);
        return ResponseEntity.ok(postService.getPostsByUser(user, page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable String id) {
        return ResponseEntity.ok(postService.getPostById(UUID.fromString(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable String id, @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.updatePost(UUID.fromString(id), postDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        postService.deletePost(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}