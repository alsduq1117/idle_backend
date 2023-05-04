package com.idle.idle_backend.config.jwt.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String home() {
        return "redirect:walkipet.site/swagger-ui/index.html";
    }
}
