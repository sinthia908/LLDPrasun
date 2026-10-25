package com.interview.bnpl.gateway;

public record PaymentResult(Status status, String providerReference) {
    public enum Status { SUCCESS, FAILED, UNKNOWN }
}
