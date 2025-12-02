package com.example.gestion.Analysis;
import com.example.gestion.transaction.Transaction;
import com.example.gestion.User.User;
import java.util.List;
@FunctionalInterface
public interface AlertCondition
{
    /**
     * Returns a financial alert if condition is met, else null
     */
    FinancialAlert check(User user, List<Transaction> transactions);
}
