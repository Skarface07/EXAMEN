package com.TD.CommunityManager.Controller;

import com.TD.CommunityManager.dto.AuthResponse;
import com.TD.CommunityManager.dto.SignUpRequest;
import com.TD.CommunityManager.dto.SigninRequest;
import com.TD.CommunityManager.model.User;
import com.TD.CommunityManager.services.auth.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthentificationService authentificationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authentificationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody SigninRequest singinRequest){
        return ResponseEntity.ok(authentificationService.signin(singinRequest));
    }

}
