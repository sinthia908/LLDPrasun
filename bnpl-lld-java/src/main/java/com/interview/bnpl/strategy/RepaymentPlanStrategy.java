package com.interview.bnpl.strategy;

import com.interview.bnpl.domain.Installment;
import com.interview.bnpl.domain.Money;
import java.time.LocalDate;
import java.util.List;

public interface RepaymentPlanStrategy {
    List<Installment> createPlan(Money amount, LocalDate startDate);
}
