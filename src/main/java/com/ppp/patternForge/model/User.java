package com.ppp.patternForge.model;

public record User(String name, Address address) {
    public User {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name required");
        }
        if (address == null) {
            throw new IllegalArgumentException("address required");
        }
    }
}
