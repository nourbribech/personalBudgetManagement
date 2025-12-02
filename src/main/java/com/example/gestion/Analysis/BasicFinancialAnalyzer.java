package com.example.gestion.Analysis;
import com.example.gestion.User.User;
import com.example.gestion.account.Account;
import com.example.gestion.transaction.Transaction;
import com.example.gestion.transaction.TransactionFilter;
import com.example.gestion.transaction.TransactionMapper;
import com.example.gestion.budgetisation.Budget;
import com.example.gestion.budgetisation.BudgetRuleEvaluator;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
public class BasicFinancialAnalyzer implements FinancialAnalyzer {
    private final List<TransactionFilter> filters;
    private final List<TransactionMapper<?>> mappers;
    private final List<MetricCalculator> metrics;
    private final List<BudgetRuleEvaluator> budgetRules;

    /**
     * Constructor: inject filters, mappers, metrics, and budget rules.
     */
    public BasicFinancialAnalyzer(List<TransactionFilter> filters,
                                  List<TransactionMapper<?>> mappers,
                                  List<MetricCalculator> metrics,
                                  List<BudgetRuleEvaluator> budgetRules) {
        this.filters = filters;
        this.mappers = mappers;
        this.metrics = metrics;
        this.budgetRules = budgetRules;
    }

    @Override
    public AnalysisResult analyze(User user) {
        //  Collect all transactions from user's accounts
        List<Transaction> allTransactions = user.getAccounts().stream()
                .flatMap(acc -> acc.getTransactions().stream())
                .collect(Collectors.toList());

        //  Apply filters
        final List<Transaction> filteredTransactions = allTransactions;
        List<Transaction> temp = filteredTransactions;
        for (TransactionFilter filter : filters) {
            temp = filter.filterTransactions(temp);
        }

        //  Compute totals
        BigDecimal totalIncome = filteredTransactions.stream()
                .filter(tx -> tx.getAmount().compareTo(BigDecimal.ZERO) > 0)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = filteredTransactions.stream()
                .filter(tx -> tx.getAmount().compareTo(BigDecimal.ZERO) < 0)
                .map(Transaction::getAmount)
                .map(BigDecimal::abs) // convert negative to positive
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal netBalance = totalIncome.subtract(totalExpense);

        // Compute spending by category
        Map<String, BigDecimal> spendingByCategory = filteredTransactions.stream()
                .filter(tx -> tx.getAmount().compareTo(BigDecimal.ZERO) < 0)
                .collect(Collectors.groupingBy(
                        tx -> tx.getCategory().name(),
                        Collectors.mapping(Transaction::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        //Check budget rules
        List<Budget> budgets = user.getBudgets();
        List<Transaction> violatingTransactions = budgets.stream()
                .flatMap(budget -> filteredTransactions.stream()
                        .filter(tx -> budgetRules.stream()
                                .anyMatch(rule -> !rule.evaluate(budget, tx))))
                .distinct()
                .collect(Collectors.toList());

        //  Assemble AnalysisResult
        return new AnalysisResult(
                user.getUserId(),
                totalIncome,
                totalExpense,
                netBalance,
                violatingTransactions,
                spendingByCategory
        );
    }

}
