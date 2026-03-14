package com.ppp.patternForge.model;

public record Address(String city, String state) {
    public Address {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("ciy required");
        }
        if (state == null || state.isBlank()) {
            throw new IllegalArgumentException("state required");
        }
    }
}
