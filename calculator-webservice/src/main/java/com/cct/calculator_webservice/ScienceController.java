package com.cct.calculator_webservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/science")
public class ScienceController {

    private final CalculatorService service;

    public ScienceController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/power")
    public ApiResponse power(@RequestParam double base,
                             @RequestParam double exponent) {
        System.out.println("API: /api/science/power (" + base + ", " + exponent + ")");
        return new ApiResponse("power", service.power(base, exponent));
    }

    @GetMapping("/root")
    public ApiResponse root(@RequestParam double number) {
        System.out.println("API: /api/science/root (" + number + ")");
        return new ApiResponse("root", service.root(number));
    }

    @GetMapping("/average")
    public ApiResponse average(@RequestParam double number1,
                               @RequestParam double number2) {
        System.out.println("API: /api/science/average (" + number1 + ", " + number2 + ")");
        return new ApiResponse("average", service.average(number1, number2));
    }
}
