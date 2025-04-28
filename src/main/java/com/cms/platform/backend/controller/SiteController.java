package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.SiteDto;
import com.cms.platform.backend.dto.UserDto;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sites")
@RequiredArgsConstructor
public class SiteController {

    private final SiteService siteService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<SiteDto> createSite(@RequestBody SiteDto siteDto, @AuthenticationPrincipal UserDto user) {
        siteDto.setUserDto(user);
        return ResponseEntity.ok(siteService.createSite(siteDto));
    }

    @GetMapping
    public ResponseEntity<List<SiteDto>> getSites() {
        return ResponseEntity.ok(siteService.getSites());
    }

    @GetMapping("/current")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<SiteDto>> getSitesByUserId(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(siteService.getSitesById((user.getId())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SiteDto> updateSite(@PathVariable String id, @RequestBody SiteDto siteDto) {
        return ResponseEntity.ok(siteService.updateSite(UUID.fromString(id), siteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable String id) {
        siteService.deleteSite(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
