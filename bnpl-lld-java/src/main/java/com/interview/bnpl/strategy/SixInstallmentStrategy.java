package com.interview.bnpl.strategy;

import com.interview.bnpl.domain.Installment;
import com.interview.bnpl.domain.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SixInstallmentStrategy implements RepaymentPlanStrategy {
    public List<Installment> createPlan(Money amount, LocalDate startDate) {
        BigDecimal part = amount.amount().divide(BigDecimal.valueOf(6), 2, RoundingMode.DOWN);
        List<Installment> result = new ArrayList<>();
        BigDecimal allocated = BigDecimal.ZERO;
        for (int i = 1; i <= 6; i++) {
            BigDecimal value;
            if (i < 6) { value = part; allocated = allocated.add(value); }
            else { value = amount.amount().subtract(allocated); }
            result.add(new Installment(new Money(value, amount.currency()), startDate.plusDays(30L * i)));
        }
        return result;
    }
}
