package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnalyticsRepository extends JpaRepository<Analytics, String> {
    List<Analytics> findByPostId(String postId);
}
