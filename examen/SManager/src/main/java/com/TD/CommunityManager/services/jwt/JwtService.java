package com.TD.CommunityManager.services.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);

    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
