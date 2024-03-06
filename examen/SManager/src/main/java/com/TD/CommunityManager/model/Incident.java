package com.TD.CommunityManager.model;

import com.TD.CommunityManager.enums.StatutIncident;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String Description;
    private String location;
    private StatutIncident status; //SEND,  Nouveau, En cours de traitement, Résolu
    private Date dateReported;
    @ManyToOne
    private User reporter;
}
