package com.example.gestion.transaction;
import java.util.List;
import java.util.stream.Collectors;
@FunctionalInterface
public interface TransactionFilter {
    boolean test(Transaction transaction);

    default List<Transaction> filterTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .filter(this::test)
                .collect(Collectors.toList());
    }

   /* static TransactionFilter getExpenseFilter() {
        return transaction -> transaction instanceof ExpenseTransaction;
    }*/
}
