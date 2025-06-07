package io.github.rodr1gotavares.infra.web.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import io.github.rodr1gotavares.core.usecases.PorcessImageUseCase;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	private final PorcessImageUseCase porcessImageUseCase;
	
	public ImageController(PorcessImageUseCase porcessImageUseCase) {
		this.porcessImageUseCase = porcessImageUseCase;
	}
	
	public ResponseEntity<?> postImage(@RequestParam("file") MultipartFile imageFile) throws IOException, InterruptedException {
		byte[] imageFileInBytes = imageFile.getBytes();
		String latexResult = this.porcessImageUseCase.exec(imageFileInBytes);
		return ResponseEntity.ok().body(latexResult);
	}

}
