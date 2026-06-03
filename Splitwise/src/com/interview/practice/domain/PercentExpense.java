package com.interview.practice.domain;


import com.interview.practice.statergy.PercentSplit;
import com.interview.practice.statergy.Split;

import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentSplit exactSplit = (PercentSplit) split;
            sumSplitPercent += exactSplit.getPercent();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}
