package io.github.rodr1gotavares.infra.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Controller
public class UploadPageController {

    @GetMapping("/")
    public String uploadPage(Model model) {
        return "upload";
    }

}
