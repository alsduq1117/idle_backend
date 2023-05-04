package com.idle.idle_backend.config.jwt.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/")
public class BasicController {
    @RequestMapping("/")
    public String homeRedirect() {
        return "redirect:/swagger-ui.html";
    }

}
