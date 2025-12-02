package com.example.gestion.Analysis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AnalysisExporter {

    public void exportAnalysisResult(AnalysisResult result, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("User ID: " + result.userId());
            writer.newLine();
            writer.write("Total Income: " + result.totalIncome());
            writer.newLine();
            writer.write("Total Expense: " + result.totalExpense());
            writer.newLine();
            writer.write("Net Balance: " + result.netBalance());
        } catch (IOException e) {
            e.printStackTrace(); // Optionally throw a custom exception here
        }
    }
}


//examples:Logging transactions to a file
//
//Exporting analysis results
//
//Saving user or budget data