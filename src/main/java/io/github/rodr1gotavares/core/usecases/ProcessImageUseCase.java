package io.github.rodr1gotavares.core.usecases;

import java.io.IOException;

import io.github.rodr1gotavares.core.ports.ImageProcessor;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class ProcessImageUseCase {
	
	private final ImageProcessor imageProcessor;
	
	public ProcessImageUseCase(ImageProcessor imageProcessor) {
		this.imageProcessor = imageProcessor;
	}
	
	public String exec(byte[] image) throws IOException, InterruptedException {
		return this.imageProcessor.parseToLaTex(image);
	}
	 
}
