package com.TD.CommunityManager.services.user;

import com.TD.CommunityManager.model.Demande;
import com.TD.CommunityManager.model.Incident;
import com.TD.CommunityManager.model.User;
import com.TD.CommunityManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("user not found"));
            }
        };
    }

    public String getEmailByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(User::getEmail) // Assuming there's a getEmail method in the User class
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<Incident> getIncidentsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        return user.getReportedIncidents();
    }

    @Override
    public List<Demande> getDemandesByUserId(Long userId) {
        // Récupérer l'utilisateur par son ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        // Retourner la liste des demandes signalées par cet utilisateur
        return user.getReportedDemandes();
    }
}
