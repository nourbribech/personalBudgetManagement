package com.example.gestion.account;

public enum AccountType {
    CURRENT("Compte Courant", "CC"),
    SAVINGS("Compte Épargne", "CE");
   // INVESTMENT("Compte Investissement", "CI"),
   // CREDIT("Compte Crédit", "CR");
   private final String displayName;
    private final String code;

    AccountType(String displayName, String code) {
        this.displayName = displayName;
        this.code = code;
    }

    public String getDisplayName() { return displayName; }
    public String getCode() { return code; }
}
