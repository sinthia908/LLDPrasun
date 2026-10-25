package com.interview.bnpl.state;

import com.interview.bnpl.domain.Loan;

public class PaidOffLoanState implements LoanState {
    public void activate(Loan loan) { throw new IllegalStateException("Paid-off loan cannot be activated"); }
    public void markPaidOff(Loan loan) { throw new IllegalStateException("Loan is already paid off"); }
    public String name() { return "PAID_OFF"; }
}
