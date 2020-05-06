package com.bridgelabz.userapii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bridgelabz.fundoo.model.User;

@SpringBootApplication
@ComponentScan(basePackages={"com.bridgelabz"})
@EnableJpaRepositories(basePackages = {"com.bridgelabz"})
@EntityScan(basePackageClasses=User.class)
public class FundooNotes3Application {

	public static void main(String[] args) {
		SpringApplication.run(FundooNotes3Application.class, args);
		
	}

}
