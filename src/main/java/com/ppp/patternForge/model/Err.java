package com.ppp.patternForge.model;

public record Err<T>(String message, Throwable cause) implements Result<T> {
    public Err(String message) {
        this(message, null);
    }

    @Override
    public boolean isOk() {
        return false;
    }
}