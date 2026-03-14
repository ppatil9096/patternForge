package com.ppp.patternForge.controller;

import com.ppp.patternForge.http.HttpRequest;
import com.ppp.patternForge.model.*;
import com.ppp.patternForge.service.EventProcessor;
import com.ppp.patternForge.service.PaymentService;
import com.ppp.patternForge.service.RouterService;
import com.ppp.patternForge.validation.SignupRequest;
import com.ppp.patternForge.validation.SignupValidator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final EventProcessor eventProcessor;
    private final PaymentService paymentService;
    private final RouterService routerService;

    public DemoController(EventProcessor ep, PaymentService ps, RouterService rs) {
        this.eventProcessor = ep;
        this.paymentService = ps;
        this.routerService = rs;
    }

    @GetMapping("/events/demo")
    public String demoEvents() {
        PaymentEvent[] events = {
                new PaymentInitiated("TXN-100", 49900, "INR"),
                new PaymentSucceeded("TXN-100", "PG-RAZORPAY"),
                new PaymentFailed("TXN-101", "NETWORK_ERROR", "Gateway timeout"),
                new RefundInitiated("TXN-102", 29900, "Duplicate")
        };

        StringBuilder out = new StringBuilder();
        for (var e : events) {
            out.append(eventProcessor.process(e)).append("\n");
        }
        return out.toString();
    }

    @PostMapping("/signup")
    public Result<SignupRequest> signup(@RequestBody SignupRequest req) {
        return SignupValidator.validate(req);
    }

    @PostMapping("/router")
    public String route(@RequestBody HttpRequest req) {
        return routerService.route(req);
    }

    @PostMapping("/payments/capture")
    public Result<String> capture(@RequestParam String txnId,
                                  @RequestParam int amount) {
        return paymentService.capture(txnId, amount);
    }
}