package com.cms.platform.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private Long id;
    private String stripeCustomerId;
    private String stripeSubscriptionId;
    private String status;
    private String planName;
    private Integer siteLimit;
}
