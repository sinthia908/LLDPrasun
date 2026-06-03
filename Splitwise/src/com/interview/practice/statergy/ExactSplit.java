package com.interview.practice.statergy;

import com.interview.practice.domain.Expense;
import com.interview.practice.domain.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
