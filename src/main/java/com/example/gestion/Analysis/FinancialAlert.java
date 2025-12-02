package com.example.gestion.Analysis;

import java.time.LocalDateTime;

public record FinancialAlert(
        String title,
        String message,
        AlertLevel level,
        LocalDateTime timestamp,
        String suggestedAction
) {
    public enum AlertLevel { INFO, WARNING, CRITICAL }

    public boolean isCritical() {
        return level == AlertLevel.CRITICAL;
    }
}