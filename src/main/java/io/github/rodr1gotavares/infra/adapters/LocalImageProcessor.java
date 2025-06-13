package io.github.rodr1gotavares.infra.adapters;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.github.rodr1gotavares.infra.config.ProcessorPropertiesLoader;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import io.github.rodr1gotavares.core.ports.ImageProcessor;

@Service
public class LocalImageProcessor implements ImageProcessor {
	
	private ProcessorPropertiesLoader processorPropertiesLoader;

    public LocalImageProcessor() {}

    public LocalImageProcessor(ProcessorPropertiesLoader processorPropertiesLoader) {
        this.processorPropertiesLoader = processorPropertiesLoader;
    }

	@Override
	public String parseToLaTex(byte[] imageBytes) throws IOException, InterruptedException {
        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(processorPropertiesLoader.getImageProcessorUrl()))
                    .POST(BodyPublishers.ofByteArray(imageBytes))
                    .build();

            response = client.send(request, BodyHandlers.ofString());
        }
        if (response.statusCode() != 200) throw new BadRequestException("Failed to send request to image processor service.");
		return response.body();
	}

}
