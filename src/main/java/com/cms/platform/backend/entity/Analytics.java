package com.cms.platform.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "analytics")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Analytics {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    private String source;

    private Integer views;

    @CreationTimestamp
    private LocalDateTime timestamp;
}
