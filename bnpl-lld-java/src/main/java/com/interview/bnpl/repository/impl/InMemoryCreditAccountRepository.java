package com.interview.bnpl.repository.impl;

import com.interview.bnpl.domain.CreditAccount;
import com.interview.bnpl.repository.CreditAccountRepository;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class InMemoryCreditAccountRepository implements CreditAccountRepository {
    private final Map<String, CreditAccount> accounts = new ConcurrentHashMap<>();
    public CreditAccount findByCustomerId(String customerId) {
        CreditAccount account = accounts.get(customerId);
        if (account == null) throw new IllegalArgumentException("Credit account not found: " + customerId);
        return account;
    }
    public void save(CreditAccount account) { accounts.put(account.getCustomerId(), account); }
}
