package com.interview.practice.service;

import java.util.Random;

public class NormalDice implements DiceStatergy{

    private final Random random = new Random();

    @Override
    public int roll() {
        return random.nextInt(6) + 1 ;
    }
}
