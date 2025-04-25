package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.MediaDto;
import com.cms.platform.backend.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/upload")
    public ResponseEntity<MediaDto> uploadMedia(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(mediaService.uploadMedia(file));
    }

    @GetMapping
    public ResponseEntity<List<MediaDto>> getMedia(@RequestParam String siteId) {
        return ResponseEntity.ok(mediaService.getMediaBySite(UUID.fromString(siteId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable String id) {
        mediaService.deleteMedia(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}