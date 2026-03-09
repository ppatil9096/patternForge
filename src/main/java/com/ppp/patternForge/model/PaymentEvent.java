package com.ppp.patternForge.model;

public sealed interface PaymentEvent permits PaymentInitiated, PaymentFailed, PaymentSucceeded, RefundInitiated {
}
