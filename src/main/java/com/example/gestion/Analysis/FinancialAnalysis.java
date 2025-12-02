package com.example.gestion.Analysis;
import com.example.gestion.budgetisation.Budget;
import java.util.List;
public record FinancialAnalysis(AnalysisResult currentPeriod,
                                AnalysisResult previousPeriod,
                                List<FinancialAlert> alerts,
                                String trends
) {
    public boolean hasAlerts() {
        return alerts != null && !alerts.isEmpty();
    }

    public List<FinancialAlert> getCriticalAlerts() {
        return alerts.stream()
                .filter(FinancialAlert::isCritical)
                .toList();
    }
}
