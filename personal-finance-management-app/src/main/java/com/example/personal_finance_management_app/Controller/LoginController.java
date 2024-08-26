package com.example.personal_finance_management_app.Controller;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.personal_finance_management_app.dto.LoginRequest;
import com.example.personal_finance_management_app.dto.SignupRequest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // This should correspond to the view name (e.g., login.html)
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // This should correspond to the view name (e.g., index.html)
    }
    @GetMapping("/signup")
    public String signup() {
    	return "signup";  // This should correspond to the view name(e.g., signup.html)
    }
    @PostMapping("/login")
    public ResponseEntity<String> handleLogin(@RequestBody LoginRequest loginRequest) {
        // Process login
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> handleSignup(@RequestBody SignupRequest signupRequest) {
        // Process signup
        return ResponseEntity.ok("Signup successful");
    }

   
}
