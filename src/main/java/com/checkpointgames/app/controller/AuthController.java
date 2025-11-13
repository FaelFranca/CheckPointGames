package com.checkpointgames.app.controller;

import com.checkpointgames.app.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        String token = authService.login(email, password);

        return ResponseEntity.ok(Map.of(
                "token", token,
                "message", "Login efetuado com sucesso",
                "status", 200,
                "timestamp", LocalDateTime.now().toString()
        ));
    }
}
