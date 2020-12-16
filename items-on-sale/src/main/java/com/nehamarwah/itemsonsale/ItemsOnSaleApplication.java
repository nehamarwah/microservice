package com.nehamarwah.itemsonsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.nehamarwah.itemsonsale.dao.UserRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ItemsOnSaleApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ItemsOnSaleApplication.class, args);
	}

}
