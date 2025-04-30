package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.SiteDto;
import com.cms.platform.backend.entity.Site;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.repository.SiteRepository;
import com.cms.platform.backend.repository.UserRepository;
import com.cms.platform.backend.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.cms.platform.backend.utils.UserMapper.toDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {
    private final SiteRepository siteRepository;
    private final UserRepository userRepository;

    @Override
    public SiteDto createSite(SiteDto siteDto) {
        Site site = new Site();
        site.setName(siteDto.getName());
        site.setSlug(siteDto.getSlug());
        site.setCustomDomain(siteDto.getCustomDomain());
        site.setTheme(siteDto.getTheme());
        site.setStatus(siteDto.getStatus());
        site.setCategory(siteDto.getCategory());
        // Fetch User by ID from DB (example)
        User user = userRepository.findById(siteDto.getUserDto().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        site.setUser(user);

        siteRepository.save(site);
        return siteDto;
    }


    @Override
    public List<SiteDto> getSites() {
        return siteRepository.findAll().stream()
                .map(site -> new SiteDto(
                        site.getId(),
                        site.getName(),
                        site.getSlug(),
                        site.getCustomDomain(),
                        site.getTheme(),
                        site.getCategory(),
                        site.getStatus(),
                        toDto(site.getUser()) // <-- use mapper
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<SiteDto> getSitesById(UUID id) {
        return siteRepository.findByUser_Id(id).stream()
                .map(site -> new SiteDto(
                        site.getId(),
                        site.getName(),
                        site.getSlug(),
                        site.getCustomDomain(),
                        site.getTheme(),
                        site.getCategory(),
                        site.getStatus(),
                        toDto(site.getUser()) // <-- use mapper
                ))
                .collect(Collectors.toList());
    }

    @Override
    public SiteDto updateSite(UUID id, SiteDto siteDto) {
        Site site = siteRepository.findById(id).orElseThrow(() -> new RuntimeException("Site not found"));
        site.setName(siteDto.getName());
        site.setCustomDomain(siteDto.getCustomDomain());
        site.setTheme(siteDto.getTheme());
        site.setStatus(siteDto.getStatus());
        siteRepository.save(site);
        return siteDto;
    }

    @Override
    public void deleteSite(UUID id) {
        siteRepository.deleteById(id);
    }
}