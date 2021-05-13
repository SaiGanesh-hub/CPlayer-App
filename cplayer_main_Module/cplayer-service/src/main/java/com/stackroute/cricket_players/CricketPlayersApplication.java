package com.stackroute.cricket_players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CricketPlayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketPlayersApplication.class, args);
	}

}
