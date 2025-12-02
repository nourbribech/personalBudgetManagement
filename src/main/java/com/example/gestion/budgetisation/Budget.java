package com.example.gestion.budgetisation;
import com.example.gestion.transaction.Transaction;
import com.example.gestion.exception.BudgetExceededException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
public class Budget {
    private String budgetId;
    private  String name;
    private  String description;
    private  BudgetPeriod period;
    private  LocalDate startDate;
    private  LocalDate endDate;
    //private  Map<Category, BudgetCategory> categoryBudgets;
    private  BigDecimal totalIncome;
    private  BigDecimal savingsTarget;
    private  BudgetStatus status;
    private  ArrayList<String> linkedAccountIds;
    private  BudgetRules rules;
    private Budget(String budgetId,String name,
     String description,
     BudgetPeriod period,
    LocalDate startDate,
     LocalDate endDate,
    /*Map<Category, BudgetCategory> categoryBudgets,*/
     BigDecimal totalIncome,
    BigDecimal savingsTarget,
      BudgetStatus status,
     ArrayList<String> linkedAccountIds,
      BudgetRules rules) {
        this.budgetId = budgetId;
        this.name = name;
        this.description =description;
        this.period = period;
        this.startDate =startDate;
        this.endDate = endDate;
        //this.categoryBudgets = categoryBudgets;
        this.totalIncome = totalIncome;
        this.savingsTarget = savingsTarget;
        this.status = BudgetStatus.ACTIVE;
        this.linkedAccountIds = new ArrayList<>();
        this.rules = rules;
    }
    public String getBudgetId() { return budgetId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BudgetPeriod getPeriod() { return period; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    //public Map<Category, BudgetCategory> getCategoryBudgets() { return Map.copyOf(categoryBudgets); }
    public BigDecimal getTotalIncome() { return totalIncome; }
    public BigDecimal getSavingsTarget() { return savingsTarget; }
    public BudgetStatus getStatus() { return status; }
    //public ArrayList<String> getLinkedAccountIds() { return Set.copyOf(linkedAccountIds); }
    public BudgetRules getRules() { return rules; }
    public void checkTransactionAgainstBudget(Transaction tx) throws BudgetExceededException {
        if (!rules.isWithinLimit(tx)) {
            throw new BudgetExceededException("Transaction exceeds budget limit");
        }
    }

}
