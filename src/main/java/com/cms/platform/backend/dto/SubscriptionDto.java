package com.cms.platform.backend.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private UUID id;
    private String stripeCustomerId;
    private String stripeSubscriptionId;
    private String status;
    private String planName;
    private Integer siteLimit;
}
