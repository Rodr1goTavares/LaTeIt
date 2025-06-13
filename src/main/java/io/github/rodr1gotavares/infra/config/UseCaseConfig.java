package io.github.rodr1gotavares.infra.config;


import io.github.rodr1gotavares.core.usecases.ProcessImageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.rodr1gotavares.core.ports.ImageProcessor;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Configuration
public class UseCaseConfig {
	
	@Bean
	ProcessImageUseCase processImageUseCase(ImageProcessor imageProcessor) {
		return new ProcessImageUseCase(imageProcessor);
	}

}
