package com.ppp.patternForge.model;

public sealed interface Result<T> permits Ok, Err {
    boolean isOk();

    default T orElseThrow() {
        return switch (this) {
            case Ok<T> ok -> ok.value();
            case Err<T> err -> throw new RuntimeException(err.message());
        };
    }

    /*record Ok<T>(T value) implements Result<T>{
        @Override
        public boolean isOk() {
            return true;
        }
    }

    record Err<T>(String message, Throwable cause) implements Result<T> {
        public Err(String message) {
            this(message, null);
        }

        @Override
        public boolean isOk() {
            return false;
        }
    }*/
}