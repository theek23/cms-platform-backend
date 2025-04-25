package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.AnalyticsDto;
import com.cms.platform.backend.entity.Analytics;
import com.cms.platform.backend.repository.AnalyticsRepository;
import com.cms.platform.backend.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {
    private final AnalyticsRepository analyticsRepository;

    @Override
    public List<AnalyticsDto> getAnalyticsByPost(Long postId) {
        return analyticsRepository.findByPostId(postId).stream()
                .map(a -> new AnalyticsDto(a.getId(), a.getPost().getId(), a.getSource(), a.getViews()))
                .collect(Collectors.toList());
    }
}