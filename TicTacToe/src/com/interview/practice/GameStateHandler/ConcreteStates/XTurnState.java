package com.interview.practice.GameStateHandler.ConcreteStates;

import com.interview.practice.CommonEnum.Symbol;
import com.interview.practice.GameStateHandler.GameState;

public class XTurnState implements GameState {

    @Override
    public void next(GameContext context, Player player , boolean hasWon) {
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }else {
            // Switch to OTurnState
            context.setState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
