package com.expense.tracker.util;

import com.expense.tracker.model.TransactionCategory;
import com.expense.tracker.model.TransactionType;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static LocalDate getDate() {
        while (true) {
            System.out.print("Enter date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            try {
                return LocalDate.parse(dateStr);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    public static TransactionType getTransactionType() {
        while (true) {
            System.out.println("Select transaction type:");
            System.out.println("1. Income");
            System.out.println("2. Expense");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": return TransactionType.INCOME;
                case "2": return TransactionType.EXPENSE;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static TransactionCategory getCategory(TransactionType type) {
        TransactionCategory[] categories = type == TransactionType.INCOME ?
                new TransactionCategory[]{
                        TransactionCategory.SALARY,
                        TransactionCategory.BUSINESS,
                        TransactionCategory.INVESTMENT,
                        TransactionCategory.OTHER_INCOME
                } :
                new TransactionCategory[]{
                        TransactionCategory.FOOD,
                        TransactionCategory.RENT,
                        TransactionCategory.TRAVEL,
                        TransactionCategory.UTILITIES,
                        TransactionCategory.ENTERTAINMENT,
                        TransactionCategory.OTHER_EXPENSE
                };

        while (true) {
            System.out.println("Select category:");
            for (int i = 0; i < categories.length; i++) {
                System.out.println((i + 1) + ". " + categories[i]);
            }
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine()) - 1;
                if (choice >= 0 && choice < categories.length) {
                    return categories[choice];
                }
            } catch (NumberFormatException e) {}

            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static double getAmount() {
        while (true) {
            System.out.print("Enter amount: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) return amount;
                System.out.println("Amount must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount format.");
            }
        }
    }

    public static String getDescription() {
        System.out.print("Enter description: ");
        return scanner.nextLine();
    }

    public static String getInput(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }
}