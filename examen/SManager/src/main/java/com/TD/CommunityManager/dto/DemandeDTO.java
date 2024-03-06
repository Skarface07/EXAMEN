package com.TD.CommunityManager.dto;

import com.TD.CommunityManager.enums.StatutDemande;
import lombok.Data;

import java.util.Date;

@Data
public class DemandeDTO {
    private String nomD;
    private String description;
    private String location;
    private Date dateSubmitted;
    private Long submitUserId;

    private StatutDemande statutDemande;
}
