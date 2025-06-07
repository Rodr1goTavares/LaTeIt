package io.github.rodr1gotavares.infra.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.rodr1gotavares.core.ports.ImageProcessor;
import io.github.rodr1gotavares.core.usecases.PorcessImageUseCase;

@Configuration
public class UseCaseConfig {
	
	@Bean
	PorcessImageUseCase proImageUseCase(ImageProcessor imageProcessor) {
		return new PorcessImageUseCase(imageProcessor);
	}
	
}
