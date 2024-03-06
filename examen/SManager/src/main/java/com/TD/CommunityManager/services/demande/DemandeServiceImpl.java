package com.TD.CommunityManager.services.demande;

import com.TD.CommunityManager.dto.DemandeDTO;
import com.TD.CommunityManager.enums.StatutDemande;
import com.TD.CommunityManager.model.Demande;
import com.TD.CommunityManager.model.User;
import com.TD.CommunityManager.repository.DemandeRepository;
import com.TD.CommunityManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl implements DemandeService {

    private final UserRepository userRepository;
    private final DemandeRepository demandeRepository;
    //private final NotificationService notificationService;


    @Override
    public Demande submitDemande(DemandeDTO demandeDTO) {
        Demande demande = new Demande();
        demande.setNomD(demandeDTO.getNomD());
        demande.setDescription(demandeDTO.getDescription());
        demande.setLocation(demandeDTO.getLocation());
        demande.setDateSubmitted(new Date());
        demande.setStatutDemande(StatutDemande.ENVOYEE);

        User user = userRepository.findById(demandeDTO.getSubmitUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        demande.setUserD(user);

        return demandeRepository.save(demande);
    }

    @Override
    public List<Demande> getDemandesByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(User::getReportedDemandes)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }



    @Override
    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Demande non trouvée"));
    }

    @Override
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @Override
    public Demande updateDemande(Long id, Demande updatedDemandeDetails) {
        return demandeRepository.findById(id).map(demande -> {
            demande.setStatutDemande(updatedDemandeDetails.getStatutDemande());
            Demande updatedDemande = demandeRepository.save(demande);
            // notificationService.envoyerNotificationDeDemande(updatedDemande.getUserD().getIdUser(),
            //        "Le statut de votre demande a été mis à jour à: " + updatedDemande.getStatutDemande());
            return updatedDemande;
        }).orElseThrow(() -> new RuntimeException("Demande non trouvée"));
    }

}
