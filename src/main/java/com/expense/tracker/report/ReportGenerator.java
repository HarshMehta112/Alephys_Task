package com.expense.tracker.report;

import com.expense.tracker.model.Transaction;

import java.util.List;

public interface ReportGenerator {
    String generateReport(List<Transaction> transactions);
}