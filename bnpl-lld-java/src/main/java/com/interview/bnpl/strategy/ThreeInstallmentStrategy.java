package com.interview.bnpl.strategy;

import com.interview.bnpl.domain.Installment;
import com.interview.bnpl.domain.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ThreeInstallmentStrategy implements RepaymentPlanStrategy {
    public List<Installment> createPlan(Money amount, LocalDate startDate) {
        BigDecimal part = amount.amount().divide(BigDecimal.valueOf(3), 2, RoundingMode.DOWN);
        List<Installment> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            BigDecimal value = i < 3 ? part : amount.amount().subtract(part.multiply(BigDecimal.valueOf(2)));
            result.add(new Installment(new Money(value, amount.currency()), startDate.plusDays(30L * i)));
        }
        return result;
    }
}
