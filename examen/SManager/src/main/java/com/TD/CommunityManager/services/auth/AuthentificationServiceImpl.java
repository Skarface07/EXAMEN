package com.TD.CommunityManager.services.auth;

import com.TD.CommunityManager.dto.AuthResponse;
import com.TD.CommunityManager.dto.SignUpRequest;
import com.TD.CommunityManager.dto.SigninRequest;
import com.TD.CommunityManager.enums.UserRole;
import com.TD.CommunityManager.model.User;
import com.TD.CommunityManager.repository.UserRepository;
import com.TD.CommunityManager.services.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImpl implements AuthentificationService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public User signup(SignUpRequest signUpRequest){
        User user = new User();

        user.setNom(signUpRequest.getNom());
        user.setPrenom(signUpRequest.getPrenom());
        user.setEmail(signUpRequest.getEmail());
        user.setAddress(signUpRequest.getAddress());
        user.setTelephone(signUpRequest.getTelephone());
        user.setRole(UserRole.CUSTOMER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public AuthResponse signin(SigninRequest singinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                singinRequest.getEmail(),
                singinRequest.getPassword()));
        var user = userRepository.findByEmail(singinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email ou mot de passe incorrect"));
        var jwt= jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwt);
        authResponse.setUserId(user.getIdUser());

        return authResponse;
    }

}
