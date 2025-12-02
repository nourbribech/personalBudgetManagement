package com.example.gestion.transaction;

public enum TransactionStatus {
    PENDING("En attente"),
    COMPLETED("Complétée"),
    CANCELLED("Annulée"),
    FAILED("Échouée");

    private final String displayName;
    TransactionStatus(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}
