package com.turkcell.crm.identityService.api.controllers;

import com.turkcell.crm.identityService.business.abstracts.AuthService;
import com.turkcell.crm.identityService.business.dtos.requests.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}
