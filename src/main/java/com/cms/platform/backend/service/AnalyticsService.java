package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.AnalyticsDto;
import java.util.List;

public interface AnalyticsService {
    List<AnalyticsDto> getAnalyticsByPost(String postId);
}

