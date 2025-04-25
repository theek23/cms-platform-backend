package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.SiteDto;
import com.cms.platform.backend.entity.Site;
import com.cms.platform.backend.repository.SiteRepository;
import com.cms.platform.backend.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {
    private final SiteRepository siteRepository;

    @Override
    public SiteDto createSite(SiteDto siteDto) {
        Site site = new Site();
        site.setName(siteDto.getName());
        site.setCustomDomain(siteDto.getCustomDomain());
        site.setTheme(siteDto.getTheme());
        site.setStatus(Enum.valueOf(com.cms.platform.backend.entity.enums.SiteStatus.class, siteDto.getStatus()));
        siteRepository.save(site);
        return siteDto;
    }

    @Override
    public List<SiteDto> getSites() {
        return siteRepository.findAll().stream()
                .map(site -> new SiteDto(site.getId(), site.getName(), site.getCustomDomain(), site.getTheme(), site.getStatus().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public SiteDto getSiteById(Long id) {
        Site site = siteRepository.findById(id).orElseThrow(() -> new RuntimeException("Site not found"));
        return new SiteDto(site.getId(), site.getName(), site.getCustomDomain(), site.getTheme(), site.getStatus().toString());
    }

    @Override
    public SiteDto updateSite(Long id, SiteDto siteDto) {
        Site site = siteRepository.findById(id).orElseThrow(() -> new RuntimeException("Site not found"));
        site.setName(siteDto.getName());
        site.setCustomDomain(siteDto.getCustomDomain());
        site.setTheme(siteDto.getTheme());
        site.setStatus(Enum.valueOf(com.cms.platform.backend.entity.enums.SiteStatus.class, siteDto.getStatus()));
        siteRepository.save(site);
        return siteDto;
    }

    @Override
    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }
}