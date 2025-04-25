package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByUserId(Long userId);
}
