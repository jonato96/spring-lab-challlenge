package com.kruger.backend.lab.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Jonathan Sanchez
 */

@EnableConfigServer
@SpringBootApplication
public class BackendLabConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLabConfigServerApplication.class, args);
	}

}
