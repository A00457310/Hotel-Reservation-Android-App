package com.example.hotel_reservation_system;

public class ApiResponse {
    String message;
    Boolean success;

    public ApiResponse(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
