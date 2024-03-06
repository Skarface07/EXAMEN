package com.TD.CommunityManager.Controller;

import com.TD.CommunityManager.model.Demande;
import com.TD.CommunityManager.model.Incident;
import com.TD.CommunityManager.services.demande.DemandeService;
import com.TD.CommunityManager.services.incident.IncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agent")
@RequiredArgsConstructor
public class AgentController {

    private final DemandeService demandeService;
    private final IncidentService incidentService;

    @GetMapping("agent")
    public ResponseEntity<String> sayHe(){
        return ResponseEntity.ok("Hi Agent");
    }

    @GetMapping("/allincidents")
    public ResponseEntity<List<Incident>> listerIncidents() {
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }

    @GetMapping("/alldemandes")
    public ResponseEntity<List<Demande>> listerDemandes() {
        return ResponseEntity.ok(demandeService.getAllDemandes());
    }

    @PutMapping("/ustatusdemande/{id}")
    public ResponseEntity<?> updateDemande(@PathVariable Long id, @RequestBody Demande demande) {
        demande.setIdDemande(id);
        Demande updatedDemande = demandeService.updateDemande(id, demande);
        return ResponseEntity.ok(updatedDemande);
    }

    @PutMapping("/ustatusincident/{id}")
    public ResponseEntity<?> updateIncident(@PathVariable Long id, @RequestBody Incident incident) {
        incident.setId(id);
        Incident updatedIncident = incidentService.updateIncident(incident);
        return ResponseEntity.ok(updatedIncident);
    }
}
