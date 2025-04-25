package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.AnalyticsDto;
import com.cms.platform.backend.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<AnalyticsDto>> getAnalytics(@PathVariable String postId) {
        return ResponseEntity.ok(analyticsService.getAnalyticsByPost(UUID.fromString(postId)));
    }
}
