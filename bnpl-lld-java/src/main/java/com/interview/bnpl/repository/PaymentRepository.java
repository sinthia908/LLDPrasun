package com.interview.bnpl.repository;

import com.interview.bnpl.domain.Payment;
import java.util.Optional;

public interface PaymentRepository {
    Optional<Payment> findByIdempotencyKey(String key);
    void save(Payment payment);
}
