package com.interview.practice.CommonEnums;

public enum Coin {

    ONE_RUPEE(1),
    TWO_RUPEES(2),
    FIVE_RUPEES(5),
    TEN_RUPEES(10);

    // Value of the coin in India Rupee

    public int value;

    Coin(int value){
        this.value = value;
    }

}
