package com.turkcell.crm.identityService.business.abstracts;

import com.turkcell.crm.identityService.business.dtos.requests.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
}
