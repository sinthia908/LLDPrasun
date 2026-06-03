package com.interview.practice.domain;

import com.interview.practice.statergy.ExactSplit;
import com.interview.practice.statergy.Split;

import java.util.List;

public class ExactExpense extends Expense{

    public ExactExpense(double amount, User paidBy, List<Split> splitList, ExpenseMetaData expenseMetaData) {
        super(amount, paidBy, splitList, expenseMetaData);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if (!(split instanceof Split)){
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;

        for(Split split: getSplits()){
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }

        if (sumSplitAmount != totalAmount)
            return false;

        return true;
    }
}
