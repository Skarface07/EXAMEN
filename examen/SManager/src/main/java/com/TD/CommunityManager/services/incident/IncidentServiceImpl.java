package com.TD.CommunityManager.services.incident;

import com.TD.CommunityManager.dto.IncidentDto;
import com.TD.CommunityManager.enums.StatutIncident;
import com.TD.CommunityManager.model.Incident;
import com.TD.CommunityManager.model.User;
import com.TD.CommunityManager.repository.IncidentRepository;
import com.TD.CommunityManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService{

    private final IncidentRepository incidentRepository;
    private final UserRepository userRepository;
   // private final NotificationService notificationService;



    @Override
    public IncidentDto createIncident(IncidentDto incidentDto) {
        Incident incident = new Incident();
        incident.setType(incidentDto.getType());
        incident.setDescription(incidentDto.getDescription());
        incident.setLocation(incidentDto.getLocation());
        incident.setStatus(incidentDto.getStatus());
        incident.setDateReported(incidentDto.getDateReported());

        User reporter = userRepository.findById(incidentDto.getReporterId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        incident.setReporter(reporter);

        incidentRepository.save(incident);
        return convertToDto(incident);
    }

    private IncidentDto convertToDto(Incident incident) {
        IncidentDto incidentDto = new IncidentDto();
        incidentDto.setId(incident.getId());
        incidentDto.setType(incident.getType());
        incidentDto.setDescription(incident.getDescription());
        incidentDto.setLocation(incident.getLocation());
        incidentDto.setStatus(StatutIncident.ENVOYEE);
        incidentDto.setDateReported(incident.getDateReported());

        if (incident.getReporter() != null) {
            incidentDto.setReporterId(incident.getReporter().getIdUser());
        }

        return incidentDto;
    }

    @Override
    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident updateIncident(Incident updatedIncident) {
        Incident existingIncident = incidentRepository.findById(updatedIncident.getId())
                .orElseThrow(() -> new RuntimeException("Incident not found"));

        existingIncident.setStatus(updatedIncident.getStatus());

        Incident savedIncident = incidentRepository.save(existingIncident);
        Long userId = savedIncident.getReporter().getIdUser();
        // notificationService.envoyerNotificationDIncident(userId, "Le status de l'incident a été mise à jour: " + savedIncident.getStatus());
        return savedIncident;
    }


    @Override
    public List<Incident> getIncidentsByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(User::getReportedIncidents)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }

    @Override
    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}
