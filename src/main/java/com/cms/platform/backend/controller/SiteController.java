package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.SiteDto;
import com.cms.platform.backend.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sites")
@RequiredArgsConstructor
public class SiteController {

    private final SiteService siteService;

    @PostMapping
    public ResponseEntity<SiteDto> createSite(@RequestBody SiteDto siteDto) {
        return ResponseEntity.ok(siteService.createSite(siteDto));
    }

    @GetMapping
    public ResponseEntity<List<SiteDto>> getSites() {
        return ResponseEntity.ok(siteService.getSites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiteDto> getSite(@PathVariable String id) {
        return ResponseEntity.ok(siteService.getSiteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SiteDto> updateSite(@PathVariable String id, @RequestBody SiteDto siteDto) {
        return ResponseEntity.ok(siteService.updateSite(id, siteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable String id) {
        siteService.deleteSite(id);
        return ResponseEntity.noContent().build();
    }
}
