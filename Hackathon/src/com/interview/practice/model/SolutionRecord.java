package com.interview.practice.model;

public class SolutionRecord {

    private final User user;
    private final Problem problem;
    private final long timeTaken;

    public SolutionRecord(User user,
                          Problem problem,
                          long timeTaken) {
        this.user = user;
        this.problem = problem;
        this.timeTaken = timeTaken;
    }

    public User getUser() {
        return user;
    }

    public Problem getProblem() {
        return problem;
    }

    public long getTimeTaken() {
        return timeTaken;
    }
}


