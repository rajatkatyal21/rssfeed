package com.rssfeed.rsstool;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RsstoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsstoolApplication.class, args);
	}

	@Bean
	Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
		return (mapperBuilder) -> mapperBuilder.modulesToInstall(new JaxbAnnotationModule());
	}
}
