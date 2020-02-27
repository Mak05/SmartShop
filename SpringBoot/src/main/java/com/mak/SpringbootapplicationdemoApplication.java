package com.mak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.mak.configuration")
//@EnableAutoConfiguration
public class SpringbootapplicationdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapplicationdemoApplication.class, args);
		
	}

}
