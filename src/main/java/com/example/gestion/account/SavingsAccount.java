package com.example.gestion.account;

import java.math.BigDecimal;
import java.util.Currency;
public final class SavingsAccount extends Account {
    private final BigDecimal interestRate; // pourcentage que la banque te paie pour garder ton argent sur ton compte épargne.
    private final BigDecimal minimumBalance;
    private final int withdrawalLimit;
    private final BigDecimal goalContributionRate;  // % automatique vers objectifs
    public SavingsAccount(String accountId, String accountName, Currency currency, BigDecimal balance,
                          BigDecimal interestRate, BigDecimal minimumBalance,
                         int withdrawalLimit, BigDecimal goalContributionRate)
    {
        super(accountId, accountName, AccountType.SAVINGS, currency, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.withdrawalLimit = withdrawalLimit;
        this.goalContributionRate = goalContributionRate;
    }
    @Override
    public boolean canWithdraw(BigDecimal amount) {
        BigDecimal remainingAfterWithdrawal = getBalance().subtract(amount);
        return remainingAfterWithdrawal.compareTo(minimumBalance) >= 0;
    }
}
