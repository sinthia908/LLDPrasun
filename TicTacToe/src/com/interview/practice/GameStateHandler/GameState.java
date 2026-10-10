package com.interview.practice.GameStateHandler;

import com.interview.practice.GameStateHandler.Context.GameContext;
import com.interview.practice.Utility.Player;

// GameState Interface
public interface GameState {
    void next(GameContext context, Player player , boolean hasWon);
    boolean isGameOver();
}