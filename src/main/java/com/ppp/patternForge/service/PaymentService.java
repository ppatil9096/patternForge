package com.ppp.patternForge.service;

import com.ppp.patternForge.model.Err;
import com.ppp.patternForge.model.Ok;
import com.ppp.patternForge.model.PaymentInitiated;
import com.ppp.patternForge.model.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {

    private final Map<String, Integer> ledger = Map.of(
            "TXN-100", 499_00,
            "TXN-102", 299_00
    );

    public Result<String> capture(String txnId, int amountMinor) {
        // Pattern matching for instanceof, simple branch logic
        if (txnId == null || txnId.isBlank()) {
            return new Err<>("txnId required");
        }

        Integer expected = ledger.get(txnId);
        if (expected == null) {
            return new Err<>("Unknown transaction: " + txnId);
        }

        if (expected != amountMinor) {
            return new Err<>("Amount mismatch: expected=%d got=%d".formatted(expected, amountMinor));
        }

        // Return Ok with message
        return new Ok<>("Captured " + amountMinor + " for " + txnId);
    }

    /**
     * Very tiny parser for a POST /payments demo body:
     * { "txnId": "TXN-777", "amount": 25900 }
     * Just to keep dependencies = 0.
     */
    public Result<PaymentInitiated> parsePaymentBody(String body) {
        try {
            String txnId = extract(body, "txnId");
            int amount = Integer.parseInt(extract(body, "amount"));
            return new Ok<>(new PaymentInitiated(txnId, amount, "INR"));
        } catch (Exception ex) {
            return new Err<>("Invalid JSON body", ex);
        }
    }

    private static String extract(String json, String key) {
        // naive, for demo only
        int k = json.indexOf("\"" + key + "\"");
        if (k < 0) throw new IllegalArgumentException("missing key " + key);
        int colon = json.indexOf(':', k);
        String tail = json.substring(colon + 1).trim();
        if (tail.startsWith("\"")) {
            int end = tail.indexOf('"', 1);
            return tail.substring(1, end);
        } else {
            String digits = tail.split("[^0-9]")[0];
            return digits;
        }
    }
}