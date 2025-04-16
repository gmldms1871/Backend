package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.demo", "common"})
@EnableJpaRepositories(basePackages = {"common.repository"})
@EntityScan(basePackages = {"common.domain"}) // <- Company 엔티티도 스캔되게
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
