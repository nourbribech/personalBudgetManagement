package com.example.gestion.transaction;
import com.example.gestion.budgetisation.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Transaction {

    private  String transactionId;
    private  String accountId;
    private  LocalDateTime date;
    private  BigDecimal amount;
    private  String description;
    private  TransactionStatus status;
    private  Category category;
    private  ArrayList<String> tags;
    private  String notes;

    public Transaction(String transactionId, String accountId, LocalDateTime date,
                          BigDecimal amount, String description, TransactionStatus status,
                          Category category, ArrayList tags, String notes) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.status =status;
        this.category =category;
        this.tags = new ArrayList<>();
        this.notes = notes;
    }
    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public ArrayList<String> getTags() {
        return new ArrayList<>(tags); // Return defensive copy
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags != null ? new ArrayList<>(tags) : new ArrayList<>();
    }

    public void setNotes(String notes) {
        this.notes = notes;}


    }
