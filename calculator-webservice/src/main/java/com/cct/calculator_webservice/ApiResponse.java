package com.cct.calculator_webservice;

public class ApiResponse {

    private String operation;
    private Object result;

    public ApiResponse(String operation, Object result) {
        this.operation = operation;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public Object getResult() {
        return result;
    }
}
