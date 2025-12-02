package com.example.gestion.Analysis;
import com.example.gestion.transaction.Transaction;
import java.math.BigDecimal;
import java.util.List;
public interface MetricCalculator {
    /**
     * Computes a metric from a list of transactions
     * exple:
     * Total spent:	Sum of all ExpenseTransaction amounts
     * Total income:	Sum of all IncomeTransaction amounts
     */
    BigDecimal calculate(List<Transaction> transactions);
}
