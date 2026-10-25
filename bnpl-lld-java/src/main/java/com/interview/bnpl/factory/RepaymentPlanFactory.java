package com.interview.bnpl.factory;

import com.interview.bnpl.domain.RepaymentPlanType;
import com.interview.bnpl.strategy.*;

public final class RepaymentPlanFactory {
    private RepaymentPlanFactory() {}
    public static RepaymentPlanStrategy getStrategy(RepaymentPlanType type) {
        return switch (type) {
            case PAY_IN_30_DAYS -> new PayIn30DaysStrategy();
            case THREE_INSTALLMENTS -> new ThreeInstallmentStrategy();
            case SIX_INSTALLMENTS -> new SixInstallmentStrategy();
        };
    }
}
