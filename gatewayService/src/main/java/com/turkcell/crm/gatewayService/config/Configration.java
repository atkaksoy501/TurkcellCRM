package com.turkcell.crm.gatewayService.config;

import com.turkcell.crm.identityService.core.services.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configration {

    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }
}
