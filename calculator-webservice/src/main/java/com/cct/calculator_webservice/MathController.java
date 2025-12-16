package com.cct.calculator_webservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/math")
public class MathController {

    private final CalculatorService service;

    public MathController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public ApiResponse add(@RequestParam double number1,
                           @RequestParam double number2) {
        System.out.println("API: /api/math/add (" + number1 + ", " + number2 + ")");
        return new ApiResponse("add", service.add(number1, number2));
    }

    @GetMapping("/subtract")
    public ApiResponse subtract(@RequestParam double number1,
                                @RequestParam double number2) {
        System.out.println("API: /api/math/subtract (" + number1 + ", " + number2 + ")");
        return new ApiResponse("subtract", service.subtract(number1, number2));
    }

    @GetMapping("/multiply")
    public ApiResponse multiply(@RequestParam double number1,
                                @RequestParam double number2) {
        System.out.println("API: /api/math/multiply (" + number1 + ", " + number2 + ")");
        return new ApiResponse("multiply", service.multiply(number1, number2));
    }

    @GetMapping("/divide")
    public ApiResponse divide(@RequestParam double number1,
                              @RequestParam double number2) {
        System.out.println("API: /api/math/divide (" + number1 + ", " + number2 + ")");
        return new ApiResponse("divide", service.divide(number1, number2));
    }

    @GetMapping("/modulus")
    public ApiResponse modulus(@RequestParam double number1,
                               @RequestParam double number2) {
        System.out.println("API: /api/math/modulus (" + number1 + ", " + number2 + ")");
        return new ApiResponse("modulus", service.modulus(number1, number2));
    }
}
