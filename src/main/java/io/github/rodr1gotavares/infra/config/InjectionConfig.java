package io.github.rodr1gotavares.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.rodr1gotavares.core.ports.ImageProcessor;
import io.github.rodr1gotavares.infra.adapters.LocalImageProcessor;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Configuration
public class InjectionConfig {

    @Bean
    ImageProcessor imageProcessor() {
		return new LocalImageProcessor();
	}
	
}
