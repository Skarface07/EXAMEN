package com.TD.CommunityManager.dto;

import com.TD.CommunityManager.enums.StatutIncident;
import lombok.Data;

import java.util.Date;

@Data
public class IncidentDto {

    private Long id;
    private String type;
    private String Description;
    private String location;
    private StatutIncident status;
    private Date dateReported;
    private Long reporterId;
}
