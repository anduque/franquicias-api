package com.anduque.franquiciasapi.dto;

import java.util.Map;

public class ApiResponse<T> {
    private String message;
    private Map<String, String> errors;
    private T data;

    public ApiResponse() {}

    public ApiResponse(String message, Map<String, String> errors, T data) {
        this.message = message;
        this.errors = errors;
        this.data = data;
    }

    // Getters y Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Map<String, String> getErrors() { return errors; }
    public void setErrors(Map<String, String> errors) { this.errors = errors; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
