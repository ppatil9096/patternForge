package com.ppp.patternForge.controller;

import com.ppp.patternForge.model.PaymentEvent;
import com.ppp.patternForge.service.EventProcessor;
import com.ppp.patternForge.service.PaymentService;
import com.ppp.patternForge.service.RouterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    private final EventProcessor eventProcessor;
    private final PaymentService paymentService;
    private final RouterService routerService;

    public DemoController(EventProcessor eventProcessor, PaymentService paymentService, RouterService routerService) {
        this.eventProcessor = eventProcessor;
        this.paymentService = paymentService;
        this.routerService = routerService;
    }

    @GetMapping("/events/demo")
    public String demoEvents() {
        PaymentEvent[] paymentEvents = new PaymentEvent[]{
        };
        return "";
    }
}

