package com.cct.calculator_webservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/convert")
public class ConversionController {

    private final CalculatorService service;

    public ConversionController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/dec2bin")
    public ApiResponse dec2bin(@RequestParam int decimal) {
        System.out.println("API: /api/convert/dec2bin (decimal=" + decimal + ")");
        return new ApiResponse("dec2bin", service.decimalToBinary(decimal));
    }

    @GetMapping("/bin2dec")
    public ApiResponse bin2dec(@RequestParam String binary) {
        System.out.println("API: /api/convert/bin2dec (binary=" + binary + ")");
        try {
            int result = service.binaryToDecimal(binary);
            return new ApiResponse("bin2dec", result);
        } catch (Exception ex) {
            return new ApiResponse("bin2dec", "Invalid binary: " + binary);
        }
    }

    @GetMapping("/dec2hex")
    public ApiResponse dec2hex(@RequestParam int decimal) {
        System.out.println("API: /api/convert/dec2hex (decimal=" + decimal + ")");
        return new ApiResponse("dec2hex", service.decimalToHex(decimal));
    }

    @GetMapping("/hex2dec")
    public ApiResponse hex2dec(@RequestParam String hex) {
        System.out.println("API: /api/convert/hex2dec (hex=" + hex + ")");
        try {
            int result = service.hexToDecimal(hex);
            return new ApiResponse("hex2dec", result);
        } catch (Exception ex) {
            return new ApiResponse("hex2dec", "Invalid hex: " + hex);
        }
    }

    @GetMapping("/bin2hex")
    public ApiResponse bin2hex(@RequestParam String binary) {
        System.out.println("API: /api/convert/bin2hex (binary=" + binary + ")");
        try {
            String result = service.binaryToHex(binary);
            return new ApiResponse("bin2hex", result);
        } catch (Exception ex) {
            return new ApiResponse("bin2hex", "Invalid binary: " + binary);
        }
    }

    @GetMapping("/hex2bin")
    public ApiResponse hex2bin(@RequestParam String hex) {
        System.out.println("API: /api/convert/hex2bin (hex=" + hex + ")");
        try {
            String result = service.hexToBinary(hex);
            return new ApiResponse("hex2bin", result);
        } catch (Exception ex) {
            return new ApiResponse("hex2bin", "Invalid hex: " + hex);
        }
    }
}
