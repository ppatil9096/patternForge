package com.ppp.patternForge.model;

public record PaymentInitiated(String transactionId, int amountMinor, String currency
) implements PaymentEvent {
    public PaymentInitiated {

        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("transactionId required");
        }
        if (amountMinor <= 0) {
            throw new IllegalArgumentException("amount must be positive (minor units)");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("currency required");
        }

    }
}
