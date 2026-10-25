package com.interview.bnpl.gateway;

import com.interview.bnpl.domain.Money;

public class MockPaymentGateway implements PaymentGateway {
    @Override
    public PaymentResult charge(Money amount, String idempotencyKey) {
        // Replace with provider API integration; this mock always succeeds.
        return new PaymentResult(PaymentResult.Status.SUCCESS, "MOCK-" + idempotencyKey);
    }
}
