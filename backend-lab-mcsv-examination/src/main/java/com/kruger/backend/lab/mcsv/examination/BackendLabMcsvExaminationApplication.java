package com.kruger.backend.lab.mcsv.examination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BackendLabMcsvExaminationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLabMcsvExaminationApplication.class, args);
	}

}
