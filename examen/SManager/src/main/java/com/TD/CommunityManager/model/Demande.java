package com.TD.CommunityManager.model;

import com.TD.CommunityManager.enums.StatutDemande;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDemande;
    private String nomD;
    private String description;
    private String location;
    private Date dateSubmitted;
    private StatutDemande statutDemande;

    @ManyToOne
    @JoinColumn(name = "submitUserid")
    private User userD;

}
