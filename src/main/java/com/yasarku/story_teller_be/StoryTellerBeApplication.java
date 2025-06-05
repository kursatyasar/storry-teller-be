package com.yasarku.story_teller_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.yasarku")
@EntityScan(basePackages = "com.yasarku.entity")
@EnableJpaRepositories(basePackages = "com.yasarku.repository")
public class StoryTellerBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryTellerBeApplication.class, args);
	}

}
