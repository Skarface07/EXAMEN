package com.TD.CommunityManager.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private Long userId;
}
