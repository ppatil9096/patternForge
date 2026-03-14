package com.ppp.patternForge.model;

public record RefundInitiated(String transactionId, int amountMinor, String cause) implements PaymentEvent {
    public RefundInitiated {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("transactionId required");
        }
        if (amountMinor <= 0) {
            throw new IllegalArgumentException("amount must be positive (minor units)");
        }
        if (cause == null || cause.isBlank()) {
            throw new IllegalArgumentException("cause required");
        }
    }
}
