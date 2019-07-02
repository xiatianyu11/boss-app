package com.app.boss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BossAppRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BossAppRegistryApplication.class, args);
	}

}
