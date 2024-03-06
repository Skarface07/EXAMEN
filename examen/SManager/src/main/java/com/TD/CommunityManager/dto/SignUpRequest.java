package com.TD.CommunityManager.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String prenom;
    private String nom;
    private String email;
    private String password;

    private String address;
    private Integer telephone;
}
