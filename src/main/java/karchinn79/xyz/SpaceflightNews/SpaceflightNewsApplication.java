package karchinn79.xyz.SpaceflightNews;


import karchinn79.xyz.SpaceflightNews.logic.Logic;
import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;


@SpringBootApplication
@EnableAsync
public class SpaceflightNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceflightNewsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	CurrentSessionContext currentSessionContext;

}

