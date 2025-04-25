package com.cms.platform.backend.repository;

import com.cms.platform.backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findBySiteId(Long siteId);
}