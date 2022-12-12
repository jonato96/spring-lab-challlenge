package com.kruger.backend.lab.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BackendLabApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLabApiGatewayApplication.class, args);
	}

}
