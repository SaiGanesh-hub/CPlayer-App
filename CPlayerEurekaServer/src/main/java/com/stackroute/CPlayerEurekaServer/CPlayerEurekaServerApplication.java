package com.stackroute.CPlayerEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CPlayerEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CPlayerEurekaServerApplication.class, args);
	}

}
