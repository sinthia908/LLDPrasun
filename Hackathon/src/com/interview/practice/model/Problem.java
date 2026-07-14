package com.interview.practice.model;

import java.util.*;

public class Problem {

    private final String id;
    private final String name;
    private final String description;
    private final String tag;
    private final Difficulty difficulty;
    private final int score;

    private int likes;

    // Users who solved this problem
    private final List<SolutionRecord> solutions;

    public Problem(String name,
                   String description,
                   String tag,
                   Difficulty difficulty,
                   int score) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.difficulty = difficulty;
        this.score = score;
        this.likes = 0;
        this.solutions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public int getLikes() {
        return likes;
    }

    public void like() {
        likes++;
    }

    public void addSolution(SolutionRecord solution) {
        solutions.add(solution);
    }

    public List<SolutionRecord> getSolutions() {
        return Collections.unmodifiableList(solutions);
    }

    // Number of contestants who solved this problem
    public int getSolvedCount() {
        return solutions.size();
    }

    // Average solve time
    public double getAverageTime() {

        if (solutions.isEmpty()) {
            return 0;
        }

        long total = 0;

        for (SolutionRecord solution : solutions) {
            total += solution.getTimeTaken();
        }

        return (double) total / solutions.size();
    }
}