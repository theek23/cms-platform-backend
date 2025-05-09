package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, UUID> {
    Page<Post> findBySiteId(UUID siteId, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.site.user.id = :userId")
    Page<Post> findByUserId(@Param("userId") UUID userId, Pageable pageable);
}