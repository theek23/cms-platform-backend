package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findBySiteId(UUID siteId);
}