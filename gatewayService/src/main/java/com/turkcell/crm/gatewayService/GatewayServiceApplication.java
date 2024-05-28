package com.turkcell.crm.gatewayService;

import com.turkcell.crm.core.annotation.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
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
