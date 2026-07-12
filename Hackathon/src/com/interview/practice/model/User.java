package com.interview.practice.model;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private final String id;
    private final String name;
    private final String department;

    // Problems solved by this user
    private final List<SolutionRecord> solvedProblems;

    public User(String id, String name, String department) {
        this.id = id;
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

    public int getScore(ScoringStrategy scoringStrategy) {
        return scoringStrategy.calculateScore(this);
    }
}