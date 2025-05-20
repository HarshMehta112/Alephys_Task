package com.expense.tracker.storage;

import com.expense.tracker.model.Transaction;
import com.expense.tracker.exception.ExpenseTrackerException;

import java.io.*;
import java.util.List;
import java.util.concurrent.*;

public class FileStorage implements DataStorage {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void saveTransactions(List<Transaction> transactions, String filename)
            throws ExpenseTrackerException {

        Future<?> future = executor.submit(() -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(transactions);
            } catch (IOException e) {
                try {
                    throw new ExpenseTrackerException("Failed to save transactions", e);
                } catch (ExpenseTrackerException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });

        awaitCompletion(future);
    }

    @Override
    public List<Transaction> loadTransactions(String filename)
            throws ExpenseTrackerException {

        Future<List<Transaction>> future = executor.submit(() -> {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                return (List<Transaction>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new ExpenseTrackerException("Failed to load transactions", e);
            }
        });

        return awaitCompletion(future);
    }

    private <T> T awaitCompletion(Future<T> future) throws ExpenseTrackerException {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new ExpenseTrackerException("Operation interrupted", e);
        }
    }
}