package com.TD.CommunityManager.services.admin;

import com.TD.CommunityManager.model.Report;

import java.time.LocalDate;

public interface AdminService {
    Report generateMonthlyIncidentReport(String category, LocalDate from, LocalDate to);
}

