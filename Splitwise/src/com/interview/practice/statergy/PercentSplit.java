package com.interview.practice.statergy;

import com.interview.practice.domain.User;

public class PercentSplit extends Split{

    double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}
