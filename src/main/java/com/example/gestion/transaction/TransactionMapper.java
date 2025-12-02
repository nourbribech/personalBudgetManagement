package com.example.gestion.transaction;
import java.util.List;
import java.util.stream.Collectors;
public interface TransactionMapper<R> {
    /**
     * Maps a transaction to another type
     * A mapper is a function that transforms one object into another. In this case, it takes a Transaction and produces something else, which could be:
     *
     * Just the amount: Transaction → BigDecimal
     *
     * A summary DTO: Transaction → TransactionSummary
     *
     * The category: Transaction → Category
     *
     * Or any custom transformation you need in your analysis/reporting
     *
     * Think of it as a converter.
     */
    R map(Transaction transaction);

    /**
     * Maps a list of transactions using Streams
     */
    default List<R> mapAll(List<Transaction> transactions) {
        return transactions.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
