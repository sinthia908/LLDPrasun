package com.interview.bnpl.state;

import com.interview.bnpl.domain.Loan;

public class ActiveLoanState implements LoanState {
    public void activate(Loan loan) { throw new IllegalStateException("Loan is already active"); }
    public void markPaidOff(Loan loan) { loan.setState(new PaidOffLoanState()); }
    public String name() { return "ACTIVE"; }
}
