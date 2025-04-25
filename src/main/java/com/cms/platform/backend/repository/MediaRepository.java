package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface MediaRepository extends JpaRepository<Media, UUID> {
    List<Media> findByUserId(UUID userId);
}
