package com.interview.bnpl.domain;

public class Payment {
    private final String paymentId = java.util.UUID.randomUUID().toString();
    private final String loanId;
    private final String idempotencyKey;
    private final Money amount;
    private PaymentStatus status = PaymentStatus.PENDING;
    private String providerReference;

    public Payment(String loanId, String idempotencyKey, Money amount) {
        this.loanId = loanId; this.idempotencyKey = idempotencyKey; this.amount = amount;
    }
    public void markSuccess(String providerReference) {
        this.status = PaymentStatus.SUCCESS; this.providerReference = providerReference;
    }
    public void markFailed() { this.status = PaymentStatus.FAILED; }
    public String getPaymentId() { return paymentId; }
    public String getLoanId() { return loanId; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public Money getAmount() { return amount; }
    public PaymentStatus getStatus() { return status; }
    public String getProviderReference() { return providerReference; }
}
