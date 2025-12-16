package com.cct.calculator_webservice;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    // -----------------------
    // Basic Arithmetic
    // -----------------------

    public double add(double number1, double number2) {
        System.out.println("Service: add(" + number1 + ", " + number2 + ")");
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        System.out.println("Service: subtract(" + number1 + ", " + number2 + ")");
        return number1 - number2;
    }

    public double multiply(double number1, double number2) {
        System.out.println("Service: multiply(" + number1 + ", " + number2 + ")");
        return number1 * number2;
    }

    public double divide(double number1, double number2) {
        System.out.println("Service: divide(" + number1 + ", " + number2 + ")");
        return number1 / number2;
    }


    // -----------------------
    // New Functions for Final Report
    // -----------------------

    // Modulus
    public double modulus(double number1, double number2) {
        System.out.println("Service: modulus(" + number1 + ", " + number2 + ")");
        return number1 % number2;
    }

    // Power
    public double power(double base, double exponent) {
        System.out.println("Service: power(" + base + ", " + exponent + ")");
        return Math.pow(base, exponent);
    }

    // Root
    public double root(double number) {
        System.out.println("Service: root(" + number + ")");
        if (number < 0) {
            return Double.NaN;
        }
        return Math.sqrt(number);
    }

    // Average
    public double average(double number1, double number2) {
        System.out.println("Service: average(" + number1 + ", " + number2 + ")");
        return (number1 + number2) / 2.0;
    }


    // -----------------------
    // Health Calculations
    // -----------------------

    // BMI Formula: weight (kg) / (height (m)²)
    public double bmi(double heightMeters, double weightKg) {
        System.out.println("Service: BMI(height=" + heightMeters + ", weight=" + weightKg + ")");
        if (heightMeters <= 0) {
            return Double.NaN;
        }
        return weightKg / (heightMeters * heightMeters);
    }

    // BMR Formula (Mifflin-St Jeor):
    // Male:   10W + 6.25H - 5A + 5
    // Female: 10W + 6.25H - 5A - 161
    public double bmr(double heightMeters, double weightKg, int age, String gender) {
        System.out.println("Service: BMR(h=" + heightMeters + ", w=" + weightKg + ", age=" + age + ", gender=" + gender + ")");
        gender = gender.trim();

        double heightCm = heightMeters * 100;

        if ("male".equalsIgnoreCase(gender)) {
            return 10 * weightKg + 6.25 * heightCm - 5 * age + 5;
        } else if ("female".equalsIgnoreCase(gender)) {
            return 10 * weightKg + 6.25 * heightCm - 5 * age - 161;
        } else {
            System.out.println("Invalid gender passed to BMR: " + gender);
            return 0;
        }
    }


    // -----------------------
    // Number System Conversions
    // -----------------------

    // Decimal to Binary
    public String decimalToBinary(int decimal) {
        System.out.println("Service: dec2bin(" + decimal + ")");
        return Integer.toBinaryString(decimal);
    }

    // Binary to Decimal
    public int binaryToDecimal(String binary) {
        System.out.println("Service: bin2dec(" + binary + ")");
        binary = binary.trim();

        if (!binary.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid Binary String: " + binary);
        }

        return Integer.parseInt(binary, 2);
    }

    // Decimal to Hex
    public String decimalToHex(int decimal) {
        System.out.println("Service: dec2hex(" + decimal + ")");
        return Integer.toHexString(decimal).toUpperCase();
    }

    // Hex to Decimal
    public int hexToDecimal(String hex) {
        System.out.println("Service: hex2dec(" + hex + ")");
        hex = hex.trim();

        if (!hex.matches("[0-9a-fA-F]+")) {
            throw new IllegalArgumentException("Invalid hex number: " + hex);
        }

        return Integer.parseInt(hex, 16);
    }

    // Binary to Hex
    public String binaryToHex(String binary) {
        System.out.println("Service: bin2hex(" + binary + ")");
        int decimal = binaryToDecimal(binary);
        return Integer.toHexString(decimal).toUpperCase();
    }

    // Hex to Binary
    public String hexToBinary(String hex) {
        System.out.println("Service: hex2bin(" + hex + ")");
        int decimal = hexToDecimal(hex);
        return Integer.toBinaryString(decimal);
    }
}
