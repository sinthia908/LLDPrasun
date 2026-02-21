package com.interview.practice.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int size;
    private final Map<Integer,Integer> snakes;
    private final Map<Integer,Integer> ladders;

    public Board(int size){
           this.size = size;
           this.snakes = new HashMap<>();
           this.ladders = new HashMap<>();
    }

    public int getSize(){
        return size;
    }


    public int getNextPosition(int position){
        if (snakes.containsKey(position))
            return snakes.get(position);

        if (ladders.containsKey(position))
            return ladders.get(position);

        return position;

    }

    // Builder design pattern
    public static class Builder{

    private Board board;

    public Builder(int size) {
        board = new Board(size);
    }

    public Builder addSnake(int head, int tail) {
        board.snakes.put(head, tail);
        return this;
    }

    public Builder addLadder(int bottom, int top) {
        board.ladders.put(bottom, top);
        return this;
    }

    public Board build() {
        return board;
    }
  }
}
