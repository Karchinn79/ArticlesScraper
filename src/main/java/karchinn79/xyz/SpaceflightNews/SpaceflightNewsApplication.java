package karchinn79.xyz.SpaceflightNews;

import karchinn79.xyz.SpaceflightNews.logic.Logic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpaceflightNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceflightNewsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public Communication communication(){
		return new Communication();
	}
	@Bean
	public Logic logic(){return new Logic();}
}

