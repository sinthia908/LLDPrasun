package com.interview.practice.domain;

import com.interview.practice.statergy.ExactSplit;
import com.interview.practice.statergy.Split;

import java.util.List;

public class ExactExpense extends Expense {

    private static final double EPSILON = 0.001;

    public ExactExpense(
            double amount,
            User paidBy,
            List<Split> splitList,
            ExpenseMetaData expenseMetaData) {

        super(amount, paidBy, splitList, expenseMetaData);
    }

    @Override
    public boolean validate() {

        List<Split> splits = getSplits();

        if (splits == null || splits.isEmpty()) {
            return false;
        }

        double totalSplitAmount = 0;

        for (Split split : splits) {

            if (!(split instanceof ExactSplit)) {
                return false;
            }

            ExactSplit exactSplit = (ExactSplit) split;

            if (exactSplit.getAmount() < 0) {
                return false;
            }

            totalSplitAmount += exactSplit.getAmount();
        }

        return Math.abs(totalSplitAmount - getAmount()) < EPSILON;
    }
}