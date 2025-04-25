package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.SubscriptionDto;
import com.cms.platform.backend.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping("/status")
    public ResponseEntity<SubscriptionDto> getStatus() {
        return ResponseEntity.ok(subscriptionService.getSubscriptionStatus());
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<String> createCheckoutSession() {
        return ResponseEntity.ok(subscriptionService.createCheckoutSession());
    }

    @PostMapping("/webhook")
    public ResponseEntity<Void> handleWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        subscriptionService.handleWebhook(payload, sigHeader);
        return ResponseEntity.ok().build();
    }
}
