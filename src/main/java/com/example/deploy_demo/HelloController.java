package com.example.deploy_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Look for an environment variable named APP_USER_NAME.
    // If it doesn't exist, fall back to "Guest" as the default.
    @Value("${APP_USER_NAME:Guest}")
    private String userName;

    @GetMapping("/")
    public String index() {
        return "Wow! My automated pipeline updated this live! Welcome, "+userName+"!";
    }
}
