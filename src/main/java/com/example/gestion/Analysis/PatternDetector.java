package com.example.gestion.Analysis;
import com.example.gestion.transaction.Transaction;
import java.util.List;
@FunctionalInterface
public interface PatternDetector {
    /**
     * Detects patterns from a list of transactions
     */
    FinancialAnalysis detect(List<Transaction> transactions);
}
