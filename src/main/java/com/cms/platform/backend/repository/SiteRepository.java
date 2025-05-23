package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface SiteRepository extends JpaRepository<Site, UUID> {
    List<Site> findByUser_Id(UUID userId);
}
