package com.example.gestion.Analysis;
import com.example.gestion.transaction.Transaction;
import java.math.BigDecimal;
import java.util.Map;
import java.util.List;
public record AnalysisResult(
        String userId,
        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal netBalance,
        List<Transaction> violatingTransactions,
        Map<String, BigDecimal> spendingByCategory
) { }