package com.expense.tracker;

import com.expense.tracker.model.Transaction;
import com.expense.tracker.model.TransactionCategory;
import com.expense.tracker.model.TransactionType;
import com.expense.tracker.report.MonthlyReportGenerator;
import com.expense.tracker.report.ReportGenerator;
import com.expense.tracker.storage.DataStorage;
import com.expense.tracker.storage.FileStorage;
import com.expense.tracker.util.ExpenseLogger;
import com.expense.tracker.util.InputHandler;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;


/**
 * Expense Tracker Application
 *
 * This application allows users to track their expenses and incomes.
 * It provides a simple CLI interface for adding transactions, generating reports,
 * and saving/loading transactions to/from a file.
 *
 * The application uses the following components:
 * - Transaction: Represents a single transaction with date, type, category, amount, and description.
 * - TransactionType: Enum representing the type of transaction (income or expense).
 * - TransactionCategory: Enum representing the category of transaction (e.g., salary, rent, etc.).
 * - ReportGenerator: Interface for generating reports from a list of transactions.
 * - MonthlyReportGenerator: Implementation of ReportGenerator that generates a monthly report.
 * - DataStorage: Interface for storing and loading transactions.
 * - FileStorage: Implementation of DataStorage that stores transactions in a file.
 * - ExpenseLogger: Utility class for logging.
 * - InputHandler: Utility class for handling user input.
 */

public class ExpenseTrackerApp {
    private final List<Transaction> transactions = new ArrayList<>();
    private final DataStorage storage = new FileStorage();
    private final ReportGenerator reportGenerator = new MonthlyReportGenerator();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        ExpenseLogger.log(Level.INFO, "Added transaction: " + transaction.getDescription());
    }

    public void saveTransactions(String filename) throws Exception {
        storage.saveTransactions(transactions, filename);
    }

    public void loadTransactions(String filename) throws Exception {
        transactions.addAll(storage.loadTransactions(filename));
    }

    public String generateReport() {
        return reportGenerator.generateReport(transactions);
    }

    public static void main(String[] args) {
        ExpenseTrackerApp app = new ExpenseTrackerApp();
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                ExpenseLogger.log(Level.INFO, "Application shutdown")));

        while (true) {
            printMenu();
            try {
                int choice = Integer.parseInt(InputHandler.getInput("Enter your choice: "));
                switch (choice) {
                    case 1 -> addTransaction(app);
                    case 2 -> System.out.println(app.generateReport());
                    case 3 -> saveTransactions(app);
                    case 4 -> loadTransactions(app);
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                ExpenseLogger.log(Level.SEVERE, "Error occurred: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nExpense Tracker Menu:");
        System.out.println("1. Add Transaction");
        System.out.println("2. Generate Monthly Report");
        System.out.println("3. Save Transactions");
        System.out.println("4. Load Transactions");
        System.out.println("5. Exit");
    }

    private static void addTransaction(ExpenseTrackerApp app) {
        LocalDate date = InputHandler.getDate();
        TransactionType type = InputHandler.getTransactionType();
        TransactionCategory category = InputHandler.getCategory(type);
        double amount = InputHandler.getAmount();
        String description = InputHandler.getDescription();

        app.addTransaction(new Transaction(date, type, category, amount, description));
        System.out.println("Transaction added successfully!");
    }

    private static void saveTransactions(ExpenseTrackerApp app) throws Exception {
        String filename = InputHandler.getInput("Enter filename to save: ");
        app.saveTransactions(filename);
        System.out.println("Transactions saved successfully!");
    }

    private static void loadTransactions(ExpenseTrackerApp app) throws Exception {
        String filename = InputHandler.getInput("Enter filename to load: ");
        app.loadTransactions(filename);
        System.out.println("Transactions loaded successfully!");
    }
}