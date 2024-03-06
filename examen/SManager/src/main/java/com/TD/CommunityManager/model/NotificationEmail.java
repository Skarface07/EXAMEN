package com.TD.CommunityManager.model;



public class NotificationEmail {
    private String to;
    private String subject;
    private String text;

    public NotificationEmail(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    // Getters et setters
}

