package io.github.rodr1gotavares.core.usecases;

import java.io.IOException;

import io.github.rodr1gotavares.core.ports.ImageProcessor;

public class PorcessImageUseCase {
	
	private final ImageProcessor imageProcessor;
	
	public PorcessImageUseCase(ImageProcessor imageProcessor) {
		this.imageProcessor = imageProcessor;
	}
	
	public String exec(byte[] image) throws IOException, InterruptedException {
		return this.imageProcessor.parseToLaTex(image);
	}
	 
}
