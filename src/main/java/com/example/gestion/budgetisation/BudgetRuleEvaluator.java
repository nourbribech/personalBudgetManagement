package com.example.gestion.budgetisation;
import com.example.gestion.transaction.Transaction;
@FunctionalInterface
public interface BudgetRuleEvaluator {
    /**
     * Returns true if the transaction respects the budget rules
     */
    boolean evaluate(Budget budget, Transaction transaction);
}
