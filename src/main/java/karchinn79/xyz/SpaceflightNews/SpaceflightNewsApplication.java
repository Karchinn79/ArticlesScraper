package karchinn79.xyz.SpaceflightNews;

import karchinn79.xyz.SpaceflightNews.entity.Article;
import karchinn79.xyz.SpaceflightNews.service.ArticleService;
import karchinn79.xyz.SpaceflightNews.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SpaceflightNewsApplication implements CommandLineRunner{

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
	public util util(){
		return new util();
	}

	@Autowired
	ArticleService articleService;
	@Autowired
	util util;
	@Override
	public void run(String... args) throws Exception {

		List<Article> ars = communication().getArticles(0,0);
		for(Article a : ars){
			articleService.saveArticle(a);//14907
			//System.out.println(a);
		}
		ExecutorService threadPool = Executors.newFixedThreadPool(8);
	}
}

