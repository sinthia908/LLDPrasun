package com.interview.practice.model;

class SolutionRecord{

    private User user;
    private Problem problem;

    private long startTime;
    private long endTime;

    public long getTimeTaken(){
        return endTime-startTime;
    }
}
