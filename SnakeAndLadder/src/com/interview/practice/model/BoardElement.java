package com.interview.practice.model;

public abstract class BoardElement {

    protected final int start;
    protected final int end;

    public BoardElement(int start,int end){
           this.start = start;
           this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
