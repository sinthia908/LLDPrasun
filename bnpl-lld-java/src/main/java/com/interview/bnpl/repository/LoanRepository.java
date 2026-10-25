package com.interview.bnpl.repository;

import com.interview.bnpl.domain.Loan;
import java.util.Optional;

public interface LoanRepository {
    Optional<Loan> findById(String loanId);
    Optional<Loan> findByOrderId(String orderId);
    void save(Loan loan);
}
