package com.thms.tenthouse.common.exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "THMS Application is running successfully!";
    }
}
