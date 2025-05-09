package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.MediaDto;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/upload")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MediaDto> uploadMedia(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(mediaService.uploadMedia(file , user));
    }


    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Page<MediaDto>> getMedia(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        System.out.println("Page: " + page + ", Size: " + size);
        return ResponseEntity.ok(mediaService.getMediaByUser(user, page, size));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable String id) {
        mediaService.deleteMedia(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}