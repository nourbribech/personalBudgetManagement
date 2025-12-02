package com.example.gestion.account;
import java.util.List;
@FunctionalInterface
public interface AccountOperation {
    /**
     * Performs an operation on the given account.
     * Example: compute fees, check constraints, etc.
     */
    void apply(Account account);

    /**
     * Example default method to apply an operation on multiple accounts using Streams
     */
    default void applyAll(List<Account> accounts) {
        accounts.stream().forEach(this::apply);
    }
}
