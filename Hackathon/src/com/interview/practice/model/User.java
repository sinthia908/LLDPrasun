package com.interview.practice.model;

import com.interview.practice.statergy.ScoringStatergy;

import java.util.*;

public class User {

    private final String id;
    private final String name;
    private final String department;

    // Problems solved by this user
    private final List<SolutionRecord> solvedProblems;

    public User(String name, String department) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.department = department;
        this.solvedProblems = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addSolvedProblem(SolutionRecord solution) {
        solvedProblems.add(solution);
    }

    public List<SolutionRecord> getSolvedProblems() {
        return Collections.unmodifiableList(solvedProblems);
    }

    public int getSolvedProblemCount() {
        return solvedProblems.size();
    }

    public int getScore(ScoringStatergy scoringStrategy) {
        return scoringStrategy.calculateScore(this);
    }
}