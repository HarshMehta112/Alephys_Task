package com.expense.tracker.util;

import java.util.logging.*;
import java.io.IOException;

public class ExpenseLogger {
    private static final Logger logger = Logger.getLogger(ExpenseLogger.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("expense_tracker.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize logger", e);
        }
    }

    public static void log(Level level, String message) {
        logger.log(level, message);
    }
}