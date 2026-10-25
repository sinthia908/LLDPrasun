package com.interview.bnpl.strategy;

import com.interview.bnpl.domain.Installment;
import com.interview.bnpl.domain.Money;
import java.time.LocalDate;
import java.util.List;

public class PayIn30DaysStrategy implements RepaymentPlanStrategy {
    public List<Installment> createPlan(Money amount, LocalDate startDate) {
        return List.of(new Installment(amount, startDate.plusDays(30)));
    }
}
