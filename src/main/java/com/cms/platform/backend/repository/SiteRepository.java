package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> findByOwnerId(Long ownerId);
}
