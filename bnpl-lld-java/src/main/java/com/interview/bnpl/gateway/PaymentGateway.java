package com.interview.bnpl.gateway;

import com.interview.bnpl.domain.Money;

public interface PaymentGateway {
    PaymentResult charge(Money amount, String idempotencyKey);
}
