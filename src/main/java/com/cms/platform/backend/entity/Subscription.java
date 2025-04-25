package com.cms.platform.backend.entity;

import com.cms.platform.backend.entity.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String stripeCustomerId;

    @Column(nullable = false)
    private String stripeSubscriptionId;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    private String planName;

    private Integer siteLimit;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}