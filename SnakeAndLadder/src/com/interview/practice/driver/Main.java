package com.interview.practice.driver;

import com.interview.practice.model.Board;

public class Main {

    public static void main(String[] args){
        Board board = new Board.Builder(100)
                      .addLadder();

                      .build()
    }
}
