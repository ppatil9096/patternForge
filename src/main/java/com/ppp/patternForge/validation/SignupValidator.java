package com.ppp.patternForge.validation;

import com.ppp.patternForge.model.*;

import java.util.ArrayList;
import java.util.List;

public class SignupValidator {

    public static Result<SignupRequest> validate(SignupRequest req) {
        // Record pattern deconstruction to access nested fields succinctly
        if (!(req instanceof SignupRequest(User user, String email, String password))) {
            return new Err<>("Invalid request structure");
        }

        // Further deconstruct User -> Address using record patterns
        String name;
        String city;
        String state;
        if (user instanceof User(String n, Address(String c, String s))) {
            name = n;
            city = c;
            state = s;
        } else {
            return new Err<>("Invalid user/address structure");
        }

        List<String> errors = new ArrayList<>();
        if (name == null || name.isBlank()) errors.add("name is blank");
        if (email == null || !email.contains("@")) errors.add("invalid email");
        if (password == null || password.length() < 8) errors.add("password too short");
        if (city == null || city.isBlank()) errors.add("city required");
        if (state == null || state.isBlank()) errors.add("state required");

        if (errors.isEmpty()) return new Ok<>(req);
        return new Err<>("Validation failed: " + String.join(", ", errors));
    }
}