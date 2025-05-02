package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Media;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MediaRepository extends JpaRepository<Media, UUID> {
    Page<Media> findByUserId(UUID userId, Pageable pageable);
}
