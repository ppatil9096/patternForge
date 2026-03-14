package com.ppp.patternForge.service;

import com.ppp.patternForge.model.*;
import org.springframework.stereotype.Service;

@Service
public class EventProcessor {
    public String process(PaymentEvent event) {
        return switch (event) {
            case PaymentInitiated pi ->
                    "[INIT] txn=%s amount=%d %s".formatted(pi.transactionId(), pi.amountMinor(), pi.currency());
            case PaymentFailed pf when
                    "NETWORK_ERROR".equals(pf.reasonCode()) ->
                    "[RETRYABLE-FAIL] txn=%s reason=%s msg=%s".formatted(pf.transactionId(), pf.reasonCode(), pf.message());
            case PaymentSucceeded ps -> "[SUCCESS] txn=%s via=%s".formatted(ps.transactionId(), ps.provider());
            case RefundInitiated ri ->
                    "[REFUND] txn=%s amount=%d cause=%s".formatted(ri.transactionId(), ri.amountMinor(), ri.cause());
            default -> throw new IllegalStateException("Unexpected value: " + event);
        };
    }
}
