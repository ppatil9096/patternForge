package com.ppp.patternForge.model;

public record PaymentSucceeded(String transactionId, String provider) implements PaymentEvent {

    public PaymentSucceeded {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("transactionId required");
        }
        if (provider == null || provider.isBlank()) {
            throw new IllegalArgumentException("provider required");
        }
    }

}
