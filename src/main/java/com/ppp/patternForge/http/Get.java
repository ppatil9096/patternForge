package com.ppp.patternForge.http;

public record Get(String path) implements HttpRequest {
    public Get {
        if (path == null || path.isBlank()) throw new IllegalArgumentException("path required");
    }
}

