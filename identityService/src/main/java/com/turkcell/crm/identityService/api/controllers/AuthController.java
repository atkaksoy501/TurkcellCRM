package com.turkcell.crm.identityService.api.controllers;

import com.turkcell.crm.identityService.business.abstracts.AuthService;
import com.turkcell.crm.identityService.business.dtos.requests.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request)
    {

        return authService.login(request);
    }
}
