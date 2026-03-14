package com.ppp.patternForge.model;

public record PaymentFailed(String transactionId, String reasonCode, String message) implements PaymentEvent {
    public PaymentFailed {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("transactionId required");
        }
        if (reasonCode == null || reasonCode.isBlank()) {
            throw new IllegalArgumentException("reasonCode required");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message required");
        }
    }

}
