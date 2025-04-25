package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.SiteDto;
import java.util.List;

public interface SiteService {
    SiteDto createSite(SiteDto siteDto);
    List<SiteDto> getSites();
    SiteDto getSiteById(Long id);
    SiteDto updateSite(Long id, SiteDto siteDto);
    void deleteSite(Long id);
}