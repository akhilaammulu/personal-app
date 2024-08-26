package com.example.personal_finance_management_app.Exceptions;

public class UserNotFoundException extends RuntimeException {
    
    // Constructor with default message
    public UserNotFoundException() {
        super("User not found");
    }
    
    // Constructor with custom message
    public UserNotFoundException(String message) {
        super(message);
    }
}
