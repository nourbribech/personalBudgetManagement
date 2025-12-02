package com.example.gestion.account;

public enum AccountStatus {
    ACTIVE("Actif"),
    INACTIVE("Inactif"),
    BLOCKED("Bloqué"),
    CLOSED("Fermé");
    private final String displayName;

    AccountStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() { return displayName; }
}
