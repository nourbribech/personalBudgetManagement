package com.example.gestion.budgetisation;

public enum Category {
    // depenses
    HOUSING("Logement"),
    FOOD("Alimentation"),
    TRANSPORT("Transport"),
    ENTERTAINMENT("Loisirs"),
    HEALTH("Santé"),

    // revenu
    SALARY("Salaire"),
    FREELANCE("Freelance"),
    INVESTMENT("Investissement"),

    OTHER("Autre");

    private final String displayName;
    Category(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}
