package com.hutech.payrollapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
@EnableSwagger2
@SpringBootConfiguration
public class HutechPayrollAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HutechPayrollAppApplication.class, args);
	}

}
