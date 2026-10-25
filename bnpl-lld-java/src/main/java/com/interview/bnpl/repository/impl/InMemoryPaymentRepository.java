package com.interview.bnpl.repository.impl;

import com.interview.bnpl.domain.Payment;
import com.interview.bnpl.repository.PaymentRepository;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final Map<String, Payment> payments = new ConcurrentHashMap<>();
    public Optional<Payment> findByIdempotencyKey(String key) { return Optional.ofNullable(payments.get(key)); }
    public void save(Payment payment) {
        Payment existing = payments.putIfAbsent(payment.getIdempotencyKey(), payment);
        if (existing != null && existing != payment) throw new IllegalStateException("Duplicate idempotency key");
    }
}
