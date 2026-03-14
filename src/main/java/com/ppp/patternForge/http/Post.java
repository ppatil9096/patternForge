package com.ppp.patternForge.http;

public record Post(String path, String body) implements HttpRequest {
    public Post {
        if (path == null || path.isBlank()) throw new IllegalArgumentException("path required");
        if (body == null) throw new IllegalArgumentException("body required");
    }
}
