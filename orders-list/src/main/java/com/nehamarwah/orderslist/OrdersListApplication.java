package com.nehamarwah.orderslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrdersListApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersListApplication.class, args);
	}

}
