package com.expense.tracker.report;

import com.expense.tracker.model.Transaction;
import com.expense.tracker.model.TransactionCategory;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MonthlyReportGenerator implements ReportGenerator {
    @Override
    public String generateReport(List<Transaction> transactions) {
        Map<YearMonth, Map<TransactionCategory, Double>> summary = transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> YearMonth.from(t.getDate()),
                        Collectors.groupingBy(
                                Transaction::getCategory,
                                Collectors.summingDouble(Transaction::getAmount)
                        )
                ));

        return formatSummary(summary);
    }

    private String formatSummary(Map<YearMonth, Map<TransactionCategory, Double>> summary) {
        StringBuilder sb = new StringBuilder();
        summary.forEach((ym, categories) -> {
            sb.append("\n").append(ym.getMonth()).append(" ").append(ym.getYear()).append("\n");
            categories.forEach((category, amount) ->
                    sb.append(String.format("%-15s: %,.2f%n", category, amount)));
        });
        return sb.toString();
    }
}