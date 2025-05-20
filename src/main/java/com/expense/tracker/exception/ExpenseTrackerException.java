package com.expense.tracker.exception;

public class ExpenseTrackerException extends Exception {
    public ExpenseTrackerException(String message) {
        super(message);
    }

    public ExpenseTrackerException(String message, Throwable cause) {
        super(message, cause);
    }
}