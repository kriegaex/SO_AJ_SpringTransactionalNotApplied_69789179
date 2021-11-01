package com.example.aspectj;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.aspectj.services.FooService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class AspectjApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectjApplication.class, args);
	}


	@Bean
	public ApplicationRunner run(FooService fooService) {

		return (args) -> {

			log.info("running ..");
			fooService.m1();
		};
	}


}
