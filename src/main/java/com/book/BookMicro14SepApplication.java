package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableEurekaClient
//@EnableWebSecurity
public class BookMicro14SepApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMicro14SepApplication.class, args);
	}

}
