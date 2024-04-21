package com.loinguyen1905.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(EcommerceApplication.class);
        application.setEnvironmentPrefix("prefix");
		SpringApplication.run(EcommerceApplication.class, args);
	}

}