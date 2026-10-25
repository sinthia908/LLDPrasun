package com.interview.bnpl.repository;

import com.interview.bnpl.domain.CreditAccount;

public interface CreditAccountRepository {
    CreditAccount findByCustomerId(String customerId);
    void save(CreditAccount account);
}
