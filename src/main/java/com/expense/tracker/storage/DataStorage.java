package com.expense.tracker.storage;

import com.expense.tracker.model.Transaction;
import com.expense.tracker.exception.ExpenseTrackerException;

import java.util.List;

public interface DataStorage {
    void saveTransactions(List<Transaction> transactions, String filename)
            throws ExpenseTrackerException;

    List<Transaction> loadTransactions(String filename)
            throws ExpenseTrackerException;
}