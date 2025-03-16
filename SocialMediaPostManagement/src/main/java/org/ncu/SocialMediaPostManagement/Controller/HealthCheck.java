package org.ncu.SocialMediaPostManagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Check API", description = "To check whether the API is running or not")
public class HealthCheck {

    @GetMapping("/health-check")
    @Operation(summary = "Checks the API")
    public String healthCheck(){
        return "Cute";
    }
}
