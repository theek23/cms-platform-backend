package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.SiteDto;
import java.util.List;
import java.util.UUID;

public interface SiteService {
    SiteDto createSite(SiteDto siteDto);
    List<SiteDto> getSites();
    SiteDto getSiteById(UUID id);
    SiteDto updateSite(UUID id, SiteDto siteDto);
    void deleteSite(UUID id);
}