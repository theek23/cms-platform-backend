package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.AnalyticsDto;
import java.util.List;
import java.util.UUID;

public interface AnalyticsService {
    List<AnalyticsDto> getAnalyticsByPost(UUID postId);
}

