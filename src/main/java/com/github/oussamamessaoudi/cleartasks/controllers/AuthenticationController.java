package com.github.oussamamessaoudi.cleartasks.controllers;

import com.github.oussamamessaoudi.cleartasks.model.AuthenticationResponse;
import com.github.oussamamessaoudi.cleartasks.model.Credentials;
import com.github.oussamamessaoudi.cleartasks.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Credentials credentials) {
        Optional<AuthenticationResponse> validate = authenticationService.validate(credentials);
        if (validate.isPresent())
            return ResponseEntity.ok(validate);
        else
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
