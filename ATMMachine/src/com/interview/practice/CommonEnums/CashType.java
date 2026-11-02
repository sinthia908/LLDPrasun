package com.interview.practice.CommonEnums;

public enum CashType {

    BILL_1OO(100),
    BILL_50(50),
    BILL_20(20),
    BILL_10(10),
    BILL_1(1);

    public  final int value;

    CashType(int value) {
        this.value = value;

    }
}
