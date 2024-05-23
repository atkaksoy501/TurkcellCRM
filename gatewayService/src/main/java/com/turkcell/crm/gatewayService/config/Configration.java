package com.turkcell.crm.gatewayService.config;

import com.turkcell.crm.identityService.core.services.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Configration {

    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }


    // Description:
    //
    //Parameter 0 of method restClientProxyExchange in org.springframework.cloud.gateway.server.mvc.GatewayServerMvcAutoConfiguration required a bean of type 'org.springframework.web.client.RestClient$Builder' that could not be found.
    //
    //
    //Action:
    //
    //Consider defining a bean of type 'org.springframework.web.client.RestClient$Builder' in your configuration.
    // yukarıdaki hatadan dolayı bu bean eklendi
    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }
}
