package com.interview.bnpl.repository.impl;

import com.interview.bnpl.domain.Loan;
import com.interview.bnpl.repository.LoanRepository;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryLoanRepository implements LoanRepository {
    private final Map<String, Loan> loans = new ConcurrentHashMap<>();
    public Optional<Loan> findById(String loanId) { return Optional.ofNullable(loans.get(loanId)); }
    public Optional<Loan> findByOrderId(String orderId) {
        return loans.values().stream().filter(l -> l.getOrderId().equals(orderId)).findFirst();
    }
    public void save(Loan loan) { loans.put(loan.getLoanId(), loan); }
}
