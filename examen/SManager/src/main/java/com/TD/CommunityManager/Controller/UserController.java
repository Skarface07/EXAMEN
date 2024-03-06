package com.TD.CommunityManager.Controller;

import com.TD.CommunityManager.dto.DemandeDTO;
import com.TD.CommunityManager.dto.IncidentDto;
import com.TD.CommunityManager.model.Demande;
import com.TD.CommunityManager.model.Incident;
import com.TD.CommunityManager.services.demande.DemandeService;
import com.TD.CommunityManager.services.incident.IncidentService;
import com.TD.CommunityManager.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final DemandeService requestService;
    private final IncidentService incidentService;
    private final UserService userService;

    @PostMapping("/demandes")
    public ResponseEntity<DemandeDTO> submitDemande(@RequestBody DemandeDTO demandeDTO) {
        Demande demande = requestService.submitDemande(demandeDTO);
        DemandeDTO demandeDTOResponse = new DemandeDTO();
        demandeDTOResponse.setNomD(demande.getNomD());
        demandeDTOResponse.setDescription(demande.getDescription());
        demandeDTOResponse.setLocation(demande.getLocation());
        demandeDTOResponse.setDateSubmitted(demande.getDateSubmitted());
        demandeDTOResponse.setSubmitUserId(demande.getUserD().getIdUser());
        demandeDTOResponse.setStatutDemande(demande.getStatutDemande());

        return ResponseEntity.ok(demandeDTOResponse);
    }

    @PostMapping("/incidents")
    public IncidentDto createIncident(@RequestBody IncidentDto incidentDto) {
        return incidentService.createIncident(incidentDto);
    }

    @GetMapping("/{userId}/incidents")
    public List<Incident> getIncidentsByUserId(@PathVariable Long userId) {
        return userService.getIncidentsByUserId(userId);
    }

    @GetMapping("/{userId}/demandes")
    public List<Demande> getDemandesByUserId(@PathVariable Long userId) {
        return userService.getDemandesByUserId(userId);
    }
}
