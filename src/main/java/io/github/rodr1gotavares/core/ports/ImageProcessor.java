package io.github.rodr1gotavares.core.ports;

import java.io.IOException;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public interface ImageProcessor {
	
	String parseToLaTex(byte[] imageBytes) throws IOException, InterruptedException;

}
