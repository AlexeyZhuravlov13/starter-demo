package org.example.starterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.example")
public class StarterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterDemoApplication.class, args);
	}

}
