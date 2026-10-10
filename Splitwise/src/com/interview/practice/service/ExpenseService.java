package com.interview.practice.service;

import com.interview.practice.domain.*;
import com.interview.practice.statergy.PercentSplit;
import com.interview.practice.statergy.Split;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(
            ExpenseType expenseType,
            double amount,
            User paidBy,
            List<Split> splits,
            ExpenseMetaData expenseMetadata) {

        if (expenseType == null) {
            throw new IllegalArgumentException("Expense type cannot be null");
        }

        if (splits == null || splits.isEmpty()) {
            throw new IllegalArgumentException("Splits cannot be empty");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        switch (expenseType) {

            case EXACT:
                return new ExactExpense(
                        amount,
                        paidBy,
                        splits,
                        expenseMetadata
                );

            case PERCENT:

                for (Split split : splits) {

                    if (!(split instanceof PercentSplit)) {
                        throw new IllegalArgumentException(
                                "All splits must be PercentSplit for PERCENT expense"
                        );
                    }

                    PercentSplit percentSplit = (PercentSplit) split;

                    double splitAmount =
                            amount * percentSplit.getPercent() / 100.0;

                    split.setAmount(
                            Math.round(splitAmount * 100.0) / 100.0
                    );
                }

                return new PercentExpense(
                        amount,
                        paidBy,
                        splits,
                        expenseMetadata
                );

            case EQUAL:

                double splitAmount =
                        Math.round(
                                (amount / splits.size()) * 100.0
                        ) / 100.0;

                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }

                /*
                 * Handle rounding difference.
                 *
                 * Example:
                 * 100 / 3 = 33.33
                 *
                 * 33.33 + 33.33 + 33.33 = 99.99
                 *
                 * Add 0.01 to the first split.
                 */
                double difference =
                        amount - (splitAmount * splits.size());

                splits.get(0).setAmount(
                        splits.get(0).getAmount() + difference
                );

                return new EqualExpense(
                        amount,
                        paidBy,
                        splits,
                        expenseMetadata
                );

            default:
                throw new IllegalArgumentException(
                        "Unsupported expense type: " + expenseType
                );
        }
    }
}