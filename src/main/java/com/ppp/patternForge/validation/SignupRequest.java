package com.ppp.patternForge.validation;

import com.ppp.patternForge.model.User;

public record SignupRequest(User user, String email, String password) {
}