package io.github.rodr1gotavares.core.ports;

import java.io.IOException;

public interface ImageProcessor {
	
	String parseToLaTex(byte[] imageBytes) throws IOException, InterruptedException;

}
