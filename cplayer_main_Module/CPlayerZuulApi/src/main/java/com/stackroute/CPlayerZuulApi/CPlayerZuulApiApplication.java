package com.stackroute.CPlayerZuulApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CPlayerZuulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CPlayerZuulApiApplication.class, args);
	}

}
