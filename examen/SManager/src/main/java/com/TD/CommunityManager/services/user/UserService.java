package com.TD.CommunityManager.services.user;

import com.TD.CommunityManager.model.Demande;
import com.TD.CommunityManager.model.Incident;
import com.TD.CommunityManager.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

    String getEmailByUserId(Long userId);

    Optional<User> findById(Long id);

    List<Incident> getIncidentsByUserId(Long userId);

    List<Demande> getDemandesByUserId(Long userId);

}
