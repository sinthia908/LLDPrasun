package com.practice;

import java.io.*;
import java.util.*;


public class Game {
	Board board;
	Dice dice;
	Cell cell;
	Deque<Player> playersList = new LinkedList<>();
	Player winner;
	
	
	
	public Game() {
		initializeGame();
	}

	private void initializeGame() {
		
		  board = new Board(10,5,4);
		  dice = new Dice(1);
		  winner = null;
		  addPlayers();
		
	}
	
	
	private void addPlayers() {
		Player player1 = new Player("p1",0);
		Player player2 = new Player("p2",0);
		playersList.add(player1);
																																	o
	}
	
	public void startGame() {
		while(winner == null) {
			
			// check whose turn now 
			
			 Player playerturn = findPlayerTurn();
			 System.out.println("player turn is:" +  playerturn.id + " current position is: " +  playerturn.currentPosition);
			 
			 // roll the dice 
			 
			 int diceNumbers = dice.rollDice();
			 
			 // get the new position
			 
			 int playerNewPostion = playerturn. + diceNumbers;
			 playerNewPostion = jumpCheck(playerNewPostion);
			 playerTurn.currentPosition = playerNewPosition;

	            System.out.println("player turn is:" + playerTurn.id + " new Position is: " + playerNewPosition);
	            //check for winning condition
	            if(playerNewPosition >= board.cells.length * board.cells.length-1){

	                winner = playerTurn;
	            }

			 

			 
	            
		}
		
	}
	
	
	
	

	private Player findPlayerTurn() {
		// TODO Auto-generated method stub
		 Player playerTurns = playersList.remove();
		 playersList.addLast(playerTurns);
		 return playerTurns;
		 
	}
	
	
	//
	
	private int jumpCheck(int playerNewPosition) {
	
		 if(playerNewPosition > board.cells.length * board.cells.length-1 ){
	            return playerNewPosition;
	        }

	        Cell cell = board.getCell(playerNewPosition);
	        if(cell.jump != null && cell.jump.start == playerNewPosition) {
	            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
	            System.out.println("jump done by: " + jumpBy);
	            return cell.jump.end;
	        }
	        return playerNewPosition;
	    }
	
	
	 
	
	
	

}
