package com.ppp.patternForge.service;

import com.ppp.patternForge.http.Get;
import com.ppp.patternForge.http.HttpRequest;
import com.ppp.patternForge.http.Post;
import com.ppp.patternForge.model.Err;
import com.ppp.patternForge.model.Ok;
import com.ppp.patternForge.model.PaymentInitiated;
import com.ppp.patternForge.model.Result;
import org.springframework.stereotype.Service;

@Service
public class RouterService {

    private final PaymentService paymentService;

    public RouterService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String route(HttpRequest req) {
        return switch (req) {
            case Get g when g.path().equals("/health") -> "200 OK - healthy";
            case Get g -> "200 OK - GET " + g.path();
            case Post p when p.path().equals("/payments") -> {
                Result<PaymentInitiated> parsed = paymentService.parsePaymentBody(p.body());
                yield switch (parsed) {
                    case Ok<PaymentInitiated> ok -> "202 Accepted - payment initiated: " + ok.value().transactionId();
                    case Err<PaymentInitiated> err -> "400 Bad Request - " + err.message();
                };
            }
            case Post p -> "404 Not Found - POST " + p.path();
        };
    }
}