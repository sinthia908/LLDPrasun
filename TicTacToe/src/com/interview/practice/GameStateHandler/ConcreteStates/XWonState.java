package com.interview.practice.GameStateHandler.ConcreteStates;

import com.interview.practice.GameStateHandler.GameState;

public class XWonState implements GameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
