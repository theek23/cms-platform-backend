package com.cms.platform.backend.entity;

import com.cms.platform.backend.entity.enums.SiteStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sites")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Site {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(name = "custom_domain")
    private String customDomain;

    private String theme;

    private SiteStatus status;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
