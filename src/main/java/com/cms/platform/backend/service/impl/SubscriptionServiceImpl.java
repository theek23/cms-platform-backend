package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.SubscriptionDto;
import com.cms.platform.backend.entity.Subscription;
import com.cms.platform.backend.repository.SubscriptionRepository;
import com.cms.platform.backend.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public SubscriptionDto getSubscriptionStatus() {
        Subscription sub = subscriptionRepository.findByUserId(1L).orElseThrow(); // mock
        return new SubscriptionDto(sub.getId(), sub.getStripeCustomerId(), sub.getStripeSubscriptionId(), sub.getStatus().toString(), sub.getPlanName(), sub.getSiteLimit());
    }

    @Override
    public String createCheckoutSession() {
        return "mock-checkout-url";
    }

    @Override
    public void handleWebhook(String payload, String sigHeader) {
        // Stripe webhook logic to be added here
    }
}
