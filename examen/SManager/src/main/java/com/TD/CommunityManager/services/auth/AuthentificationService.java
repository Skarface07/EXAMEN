package com.TD.CommunityManager.services.auth;

import com.TD.CommunityManager.dto.AuthResponse;
import com.TD.CommunityManager.dto.SignUpRequest;
import com.TD.CommunityManager.dto.SigninRequest;
import com.TD.CommunityManager.model.User;

public interface AuthentificationService {

    User signup(SignUpRequest signUpRequest);
    AuthResponse signin(SigninRequest singinRequest);
}
