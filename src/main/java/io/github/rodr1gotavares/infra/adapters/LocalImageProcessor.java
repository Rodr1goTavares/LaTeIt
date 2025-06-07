package io.github.rodr1gotavares.infra.adapters;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.github.rodr1gotavares.core.ports.ImageProcessor;

@Service
public class LocalImageProcessor implements ImageProcessor {
	
	@Value("${service.image-processor-url}")
	private String url;

	@Override
	public String parseToLaTex(byte[] imageBytes) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(this.url))
				.POST(BodyPublishers.ofByteArray(imageBytes))
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		if (response.statusCode() != 200) throw new BadRequestException("Failed to send request to image processor service.");
		return response.body();
	}

}
