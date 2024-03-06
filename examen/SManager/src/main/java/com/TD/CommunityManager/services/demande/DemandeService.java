package com.TD.CommunityManager.services.demande;

import com.TD.CommunityManager.dto.DemandeDTO;
import com.TD.CommunityManager.model.Demande;

import java.util.List;

public interface DemandeService {
    Demande submitDemande(DemandeDTO demandeDTO);
    Demande getDemandeById(Long id);
    List<Demande> getAllDemandes();
    Demande updateDemande(Long id, Demande demande);
    List<Demande> getDemandesByUserId(Long userId);
}
