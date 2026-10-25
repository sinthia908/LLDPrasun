package com.interview.bnpl.state;

import com.interview.bnpl.domain.Loan;

public class CreatedLoanState implements LoanState {
    public void activate(Loan loan) { loan.setState(new ActiveLoanState()); }
    public void markPaidOff(Loan loan) { throw new IllegalStateException("Created loan cannot be paid off"); }
    public String name() { return "CREATED"; }
}
