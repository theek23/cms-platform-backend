package com.cms.platform.backend.entity;

import com.cms.platform.backend.entity.enums.MediaType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "media")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Media {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String url;

    @Enumerated(EnumType.STRING)
    private MediaType type;

    private Long size;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @CreationTimestamp
    private LocalDateTime uploadedAt;
}
