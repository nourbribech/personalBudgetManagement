package com.example.gestion.budgetisation;
import java.math.BigDecimal;
import java.util.List;
@FunctionalInterface
public interface BudgetComputation {
    /**
     * Computes a numeric value for a budget
     */
    BigDecimal compute(Budget budget);

    /**
     * Default method to compute sum over multiple budgets
     */
    default BigDecimal computeAll(List<Budget> budgets) {
        return budgets.stream()
                .map(this::compute)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
