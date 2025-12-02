package com.example.gestion.budgetisation;

public enum BudgetPeriod {
    MONTHLY("Mensuel"),
    QUARTERLY("Trimestriel"),
    YEARLY("Annuel"),
    CUSTOM("Personnalisé");

    private String displayName;
    BudgetPeriod(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}
