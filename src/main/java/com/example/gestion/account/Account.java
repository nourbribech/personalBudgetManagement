package com.example.gestion.account;
import com.example.gestion.transaction.Transaction;
import com.example.gestion.exception.InsufficientFundsException;
import com.example.gestion.exception.InactiveAccountException;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Currency;
import java.time.LocalDate;
public sealed abstract class Account permits CurrentAccount, SavingsAccount{
    private final String accountId;
    private final String accountName;
    private final AccountType type;
    private final Currency currency;
    private  BigDecimal balance;
    private  AccountStatus status;
    private final LocalDate creationDate;
    private final ArrayList<Transaction> transactions;
    public Account(String accountId, String accountName, AccountType type, Currency currency, BigDecimal balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.type = type;
        this.currency = currency;
        this.balance = balance;
        this.status = AccountStatus.ACTIVE;
        this.creationDate = LocalDate.now();
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public AccountType getType() {
        return type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public void addTransaction(Transaction tx) throws InsufficientFundsException, InactiveAccountException {
        if (status != AccountStatus.ACTIVE) {
            throw new InactiveAccountException("Cannot add transaction: account inactive");
        }
        BigDecimal newBalance = balance.add(tx.getAmount());
        if (!canWithdraw(tx.getAmount())) {
            throw new InsufficientFundsException("Cannot withdraw: exceeds limit");
        }
        transactions.add(tx);
        balance = newBalance;
    }



    public abstract boolean canWithdraw(BigDecimal amount);
}
