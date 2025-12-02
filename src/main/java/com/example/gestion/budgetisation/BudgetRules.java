package com.example.gestion.budgetisation;
import com.example.gestion.transaction.Transaction;
import java.math.BigDecimal;

public record BudgetRules( boolean allowOverBudget,
                           boolean autoAdjustCategories,
                           boolean rolloverSurplus,
                           double alertThreshold,
                           int gracePeriodDays,//The number of days you allow yourself to go
                           // over budget before taking corrective action or considering it a
                           // budget violation.
                           BigDecimal categoryLimit // max amount allowed for a category
) {
    public boolean isWithinLimit(Transaction tx) {
        if (allowOverBudget) {
            return true; // any transaction allowed
        }
        // simple check against categoryLimit
        return tx.getAmount().compareTo(categoryLimit) <= 0;
    }
}
