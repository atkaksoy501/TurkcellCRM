package com.turkcell.crm.identityService.api.controllers;

import com.turkcell.crm.identityService.business.abstracts.AuthService;
import com.turkcell.crm.identityService.business.abstracts.UserService;
import com.turkcell.crm.identityService.business.dtos.requests.LoginRequest;
import com.turkcell.crm.identityService.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody User user){
        userService.register(user);
    }
}
