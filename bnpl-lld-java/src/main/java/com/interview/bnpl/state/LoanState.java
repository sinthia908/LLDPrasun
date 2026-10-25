package com.interview.bnpl.state;

import com.interview.bnpl.domain.Loan;

public interface LoanState {
    void activate(Loan loan);
    void markPaidOff(Loan loan);
    String name();
}
