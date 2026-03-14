package com.ppp.patternForge.http;

public sealed interface HttpRequest permits Get, Post {
    String path();
}

