package com.example.aspectj;

import com.example.aspectj.services.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Slf4j
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class AspectjApplication implements LoadTimeWeavingConfigurer {

	public static void main(String[] args) {
    try (ConfigurableApplicationContext applicationContext = SpringApplication.run(AspectjApplication.class, args)) {
    }
	}


	@Bean
	public ApplicationRunner run(FooService fooService) {

		return (args) -> {

			log.info("running ..");
			fooService.m1();
		};
	}

	@Override
	public LoadTimeWeaver getLoadTimeWeaver() {
		return new InstrumentationLoadTimeWeaver();
	}

}
