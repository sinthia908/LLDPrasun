package com.interview.practice.domain;

import com.interview.practice.statergy.Split;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(double amount, User paidBy, List<Split> splitList, ExpenseMetaData expenseMetaData) {
        super(amount, paidBy, splitList, expenseMetaData);
       }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if (!(split instanceof Split)){
                return false;
            }
        }
        return true;
    }
}
