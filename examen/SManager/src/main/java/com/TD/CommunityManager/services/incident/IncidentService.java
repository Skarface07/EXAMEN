package com.TD.CommunityManager.services.incident;

import com.TD.CommunityManager.dto.IncidentDto;
import com.TD.CommunityManager.model.Incident;

import java.util.List;

public interface IncidentService {
    IncidentDto createIncident(IncidentDto incidentDto);
    Incident getIncidentById(Long id);
    List<Incident> getAllIncidents();
    Incident updateIncident(Incident incident);
    void deleteIncident(Long id);
    List<Incident> getIncidentsByUserId(Long userId);
}
