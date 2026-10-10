package com.interview.practice.domain;

import com.interview.practice.statergy.Split;

import java.util.List;

public class EqualExpense extends Expense {

    private static final double EPSILON = 0.001;

    public EqualExpense(
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

            if (split == null || split.getAmount() < 0) {
                return false;
            }

            totalSplitAmount += split.getAmount();
        }

        return Math.abs(totalSplitAmount - getAmount()) < EPSILON;
    }
}