package com.practice;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	
	Cell[][] cells;
    Board(int boardSize,int numberOfSnakes,int numberOfLadders){
    	 initializeCells(boardSize);
    	 AddingSnakeAndLadders(numberOfSnakes,numberOfLadders);
    	 
    }
    // Adding snake and ladders to the board 
	private void AddingSnakeAndLadders(int numberOfSnakes, int numberOfLadders) {
		while( numberOfSnakes > 0 ) {
			int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			
			 if(snakeTail >= snakeHead) {
	               continue;
	      	}
			 
			Jump snakeObj = new Jump(snakeHead,snakeTail);
		    Cell cell = getCell(snakeHead);
	           cell.jump = snakeObj;
			
	           numberOfSnakes--;
			 
		}
		
		
		while( numberOfLadders > 0 ) {
			int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			
			
		}
		
		
		
	}
	private void initializeCells(int boardSize) {
         cells = new Cell[boardSize][boardSize];
         
         for(int i=0; i<boardSize;i++ ) {
        	 for(int j=0; j<boardSize;j++ ) {
        		 Cell cellobj = new Cell();
        		 cells[i][j] = cellobj;
        	 }
        	 
         }
         
	}
	

	
	// Add snakes 
	
	
Cell getCell(int playerPosition) {
	int boardRow = playerPosition/cells.length;
	int boardColumn = ( playerPosition % cells.length);
	
	return cells[boardRow][boardColumn];	
	
}	
	
	
	

}



