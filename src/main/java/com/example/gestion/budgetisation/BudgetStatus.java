package com.example.gestion.budgetisation;

public enum BudgetStatus {
    //DRAFT("Brouillon"),
    ACTIVE("Actif"),
    ARCHIVED("Archivé"),
    CANCELLED("Annulé");

    private final String displayName;
    BudgetStatus(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}
