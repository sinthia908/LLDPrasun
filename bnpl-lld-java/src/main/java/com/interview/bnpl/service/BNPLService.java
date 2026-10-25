package com.interview.bnpl.service;

import com.interview.bnpl.domain.*;

public interface BNPLService {
    Money checkAvailableCredit(String customerId);
    Loan purchase(String customerId, String orderId, Money amount,
                  String idempotencyKey, RepaymentPlanType planType);
    Payment repay(String loanId, Money amount, String idempotencyKey);
}
