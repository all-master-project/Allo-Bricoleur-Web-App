package org.allobricole.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class AlloBricoleWebAppApplication {

	public static void main(String[] args) {
	    SpringApplication.run(AlloBricoleWebAppApplication.class, args);
	} 
	
 
	@Bean
	public SpringApplicationContext springApplicationContext()
	{
		return new SpringApplicationContext();
	}
	
}