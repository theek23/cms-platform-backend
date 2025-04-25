package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.SubscriptionDto;

public interface SubscriptionService {
    SubscriptionDto getSubscriptionStatus();
    String createCheckoutSession();
    void handleWebhook(String payload, String sigHeader);
}
