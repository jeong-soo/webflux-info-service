package dev.jsoo.infoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class InfoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoserviceApplication.class, args);
	}

	@Bean
	public WebClient getLocalwebClient() {
		return WebClient.create("http://localhost:8080");
	}
}
