package com.TD.CommunityManager.repository;

import com.TD.CommunityManager.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
}
