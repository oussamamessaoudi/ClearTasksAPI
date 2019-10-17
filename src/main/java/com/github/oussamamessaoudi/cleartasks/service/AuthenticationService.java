package com.github.oussamamessaoudi.cleartasks.service;

import com.github.oussamamessaoudi.cleartasks.model.AuthenticationResponse;
import com.github.oussamamessaoudi.cleartasks.model.Credentials;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {


    public Optional<AuthenticationResponse> validate(Credentials credentials) {
        return credentials.getPassword().equals("pass") && credentials.getUsername().equals("user")
                ? Optional.of(new AuthenticationResponse("token"))
                : Optional.empty();
    }
}
