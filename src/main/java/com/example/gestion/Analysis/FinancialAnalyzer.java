package com.example.gestion.Analysis;
import com.example.gestion.User.User;
@FunctionalInterface
public interface FinancialAnalyzer {
    //performs analysis on a user
    AnalysisResult analyze(User user);
}
