package com.cms.platform.backend.entity;

import com.cms.platform.backend.entity.enums.PostStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String seoTitle;

    private String seoDescription;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    private Number views;

    @ElementCollection
    private List<String> tags;

    private String thumbnail;

    private String author;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;
}
