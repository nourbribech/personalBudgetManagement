package com.example.gestion.User;
import java.util.List;
import java.util.ArrayList;
import com.example.gestion.account.Account;
import com.example.gestion.budgetisation.Budget;


import java.time.LocalDateTime;
public abstract class User {
    private  String userId;
    private  String username;
    private  String email;
    private  LocalDateTime registrationDate;
    private UserRole role;
    private List<Account> accounts;
    private List<Budget> budgets;
    public void User(String userId, String username, String email,UserRole role)
    {
        this.userId=userId;
        this.username=username;
        this.email=email;
        this.registrationDate=LocalDateTime.now();
        this.role=role;
        this.accounts = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }


    //getters
    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public LocalDateTime getRegistrationDate() { return registrationDate; }

    public UserRole getRole() {
        return role;
    }
    // Accounts
    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Budgets
    public List<Budget> getBudgets() {
        return budgets;
    }

    public void addBudget(Budget budget) {
        budgets.add(budget);
    }

    //setters
    public void setUserId(String userId) { this.userId=userId; }
    public void setUsername(String username) { this.username=username; }
    public void setEmail(String email) { this.email=email; }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
