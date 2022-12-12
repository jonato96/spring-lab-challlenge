package com.kruger.backend.lab.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jonathan Sanchez
 */

@SpringBootApplication
@EnableEurekaServer
public class BackendLabDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLabDiscoveryServerApplication.class, args);
	}

}
