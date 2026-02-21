package com.interview.practice.service;

import com.interview.practice.model.Board;
import com.interview.practice.model.GameStatus;
import com.interview.practice.model.Player;

import java.util.Queue;

public class GameService {

    private final Board board;
    private final Queue<Player> players;
    private final DiceStatergy diceStatergy;
    private GameStatus gameStatus;
    
    public GameService(Board board,Queue<Player> players,DiceStatergy diceStatergy){
          this.board = board;
          this.players = players;
          this.diceStatergy = diceStatergy;
          this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void startGame(){
           gameStatus = GameStatus.IN_PROGRESS;
           while (gameStatus == GameStatus.IN_PROGRESS){
                  playTurn(); 
           }
    }

    private void playTurn() {

            Player player = players.poll();
            int roll = diceStatergy.roll();
            int nextPosition = player.getPosition() + roll;

            // if the next position is out of the board.

            if (nextPosition > board.getSize()){
                players.offer(player);
                return;
            }

            nextPosition = board.getNextPosition(nextPosition);
            player.setPosition(nextPosition);

            System.out.println(player.getName() +
                " rolled " + roll +
                " and moved to " + nextPosition);


        if (nextPosition == board.getSize()){
                gameStatus = GameStatus.FINISHED;
                return;
            }

        players.offer(player);

    }

    private boolean hasPlayerWon(Player player) {
        return player.getPosition() == board.getSize();
    }

    private boolean isGameCompleted() {
        return gameStatus == GameStatus.FINISHED;
    }

}
