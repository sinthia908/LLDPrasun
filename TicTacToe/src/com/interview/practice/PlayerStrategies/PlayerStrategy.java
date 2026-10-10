package com.interview.practice.PlayerStrategies;

// Strategy Interface for Player Moves
// Defines a makeMove(Board board) method.

import com.interview.practice.Utility.Board;

import javax.swing.text.Position;

public interface PlayerStrategy {
    // Allows different player strategies to be used interchangeably without
    // modifying client code.

    Position makeMove(Board board);
}
