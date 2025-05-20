package com.expense.tracker.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private final LocalDate date;
    private final TransactionType type;
    private final TransactionCategory category;
    private final double amount;
    private final String description;

    public Transaction(LocalDate date, TransactionType type,
                       TransactionCategory category, double amount, String description) {
        this.date = date;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    // Getters
    public LocalDate getDate() { return date; }
    public TransactionType getType() { return type; }
    public TransactionCategory getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
}