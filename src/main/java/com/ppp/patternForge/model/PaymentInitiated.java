package com.ppp.patternForge.model;

public record PaymentInitiated(String transactionId, int amountMinor, String currency
) implements PaymentEvent {
}
