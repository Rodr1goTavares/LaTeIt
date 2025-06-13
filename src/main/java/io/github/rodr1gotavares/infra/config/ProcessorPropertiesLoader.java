package io.github.rodr1gotavares.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Component
@ConfigurationProperties(prefix = "spring.service")
public class ProcessorPropertiesLoader {

    private String imageProcessorUrl;
    private String imageProcessorKey;

    public String getImageProcessorUrl() {
        return imageProcessorUrl;
    }

    public void setImageProcessorUrl(String imageProcessorUrl) {
        this.imageProcessorUrl = imageProcessorUrl;
    }

    public String getImageProcessorKey() {
        return imageProcessorKey;
    }

    public void setImageProcessorKey(String imageProcessorKey) {
        this.imageProcessorKey = imageProcessorKey;
    }

}
