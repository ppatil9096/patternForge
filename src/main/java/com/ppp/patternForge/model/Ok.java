package com.ppp.patternForge.model;

public record Ok<T>(T value) implements Result<T>{
    @Override
    public boolean isOk() {
        return true;
    }
}