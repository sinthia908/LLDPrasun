package com.interview.practice.domain;

import com.interview.practice.statergy.PercentSplit;
import com.interview.practice.statergy.Split;

import java.util.List;

public class PercentExpense extends Expense {

    private static final double EPSILON = 0.001;

    public PercentExpense(
            double amount,
            User paidBy,
            List<Split> splits,
            ExpenseMetaData expenseMetadata) {

        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {

        List<Split> splits = getSplits();

        if (splits == null || splits.isEmpty()) {
            return false;
        }

        double totalPercent = 0;

        for (Split split : splits) {

            if (!(split instanceof PercentSplit)) {
                return false;
            }

            PercentSplit percentSplit = (PercentSplit) split;

            if (percentSplit.getPercent() < 0) {
                return false;
            }

            totalPercent += percentSplit.getPercent();
        }

        return Math.abs(totalPercent - 100.0) < EPSILON;
    }
}