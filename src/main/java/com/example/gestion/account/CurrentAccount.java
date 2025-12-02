package com.example.gestion.account;
import com.example.gestion.transaction.Transaction;

import java.math.BigDecimal;
import java.util.Currency;
public final class CurrentAccount extends Account {
    private  BigDecimal overdraftLimit; //how much you can withdraw after hitting 0
    private  BigDecimal monthlyFee;
    private  BigDecimal budgetAlertThreshold;

    public CurrentAccount(String accountId, String accountName,
                          Currency currency, BigDecimal balance,
                          BigDecimal overdraftLimit, BigDecimal monthlyFee,
                          BigDecimal budgetAlertThreshold)
    {
        super(accountId, accountName, AccountType.CURRENT, currency, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
        this.budgetAlertThreshold = budgetAlertThreshold;
    }
    public BigDecimal getOverdraftLimit() { return overdraftLimit; }
    public BigDecimal getMonthlyFee() { return monthlyFee; }
    public BigDecimal getBudgetAlertThreshold() { return budgetAlertThreshold; }
    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    public void setBudgetAlertThreshold(BigDecimal budgetAlertThreshold) {
        this.budgetAlertThreshold = budgetAlertThreshold;
    }
    @Override
    public boolean canWithdraw(BigDecimal amount) {
        return getBalance().subtract(amount).compareTo(overdraftLimit.negate()) >= 0;
    }

    /*@Override
    public BigDecimal calculateMonthlyFees() {
        return monthlyFee;
    }

    @Override
    public BigDecimal getAvailableBalance() {
        return getBalance().add(overdraftLimit);
    }*/

    // verification des budgets avant transaction
    /*public boolean isWithinBudgetLimits(Transaction transaction) {
        return getLinkedBudgets().stream()
                .filter(budget -> budget.getCategory() == transaction.getCategory())
                .allMatch(budget -> budget.isWithinLimit(transaction.getAmount()));
    }
*/


    /*public boolean shouldTriggerBudgetAlert() {
        return getBalance().compareTo(budgetAlertThreshold) < 0;
    }*/

}
