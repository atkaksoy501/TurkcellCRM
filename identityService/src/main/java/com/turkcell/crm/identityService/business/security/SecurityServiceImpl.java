package com.turkcell.crm.identityService.business.security;

import com.turkcell.crm.identityService.core.services.SecurityService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    private static final String[] WHITE_LIST_URLS = {
            "/api/v1/auth/login"

    };
    @Override
    public HttpSecurity configureSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(x-> x
                .requestMatchers(WHITE_LIST_URLS).permitAll()
                .anyRequest().authenticated()
        );
        return http;
    }
}
