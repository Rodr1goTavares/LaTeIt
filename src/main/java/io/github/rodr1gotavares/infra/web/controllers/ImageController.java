package io.github.rodr1gotavares.infra.web.controllers;

import java.io.IOException;

import io.github.rodr1gotavares.core.usecases.ProcessImageUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@RestController
@RequestMapping("/image")
public class ImageController {
	
	private final ProcessImageUseCase processImageUseCase;
	
	public ImageController(ProcessImageUseCase processImageUseCase) {
		this.processImageUseCase = processImageUseCase;
	}

	@PostMapping("/upload")
	public ResponseEntity<?> postImage(@RequestParam("file") MultipartFile imageFile) throws IOException, InterruptedException {
		byte[] imageFileInBytes = imageFile.getBytes();
		String latexResult = this.processImageUseCase.exec(imageFileInBytes);
		return ResponseEntity.ok().body(latexResult);
	}

}
