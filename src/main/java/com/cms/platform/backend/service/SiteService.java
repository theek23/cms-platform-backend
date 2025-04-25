package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.SiteDto;
import java.util.List;

public interface SiteService {
    SiteDto createSite(SiteDto siteDto);
    List<SiteDto> getSites();
    SiteDto getSiteById(String id);
    SiteDto updateSite(String id, SiteDto siteDto);
    void deleteSite(String id);
}