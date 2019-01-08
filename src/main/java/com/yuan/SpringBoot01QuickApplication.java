package com.yuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/*
@ImportResource(locations = "classpath:bean.xml")
*/
@SpringBootApplication
public class SpringBoot01QuickApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01QuickApplication.class, args);
	}
}
