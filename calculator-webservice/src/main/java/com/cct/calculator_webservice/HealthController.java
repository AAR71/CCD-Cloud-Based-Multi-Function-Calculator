package com.cct.calculator_webservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final CalculatorService service;

    public HealthController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/bmi")
    public ApiResponse bmi(@RequestParam double height,
                           @RequestParam double weight) {
        System.out.println("API: /api/health/bmi (height=" + height + ", weight=" + weight + ")");
        return new ApiResponse("bmi", service.bmi(height, weight));
    }

    @GetMapping("/bmr")
    public ApiResponse bmr(@RequestParam double height,
                           @RequestParam double weight,
                           @RequestParam int age,
                           @RequestParam String gender) {
        System.out.println("API: /api/health/bmr (h=" + height + ", w=" + weight +
                ", age=" + age + ", gender=" + gender + ")");
        return new ApiResponse("bmr", service.bmr(height, weight, age, gender));
    }
}
