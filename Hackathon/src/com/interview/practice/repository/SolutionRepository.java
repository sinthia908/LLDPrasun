package com.interview.practice.repository;

import com.interview.practice.model.Problem;
import com.interview.practice.model.SolutionRecord;

import java.util.ArrayList;

public class InMemorySolutionRepository {

    private final List<SolutionRecord> solutions = new ArrayList<>();

    public void save(SolutionRecord solution) {
        solutions.add(solution);
    }

    public List<SolutionRecord> findAll() {
        return solutions;
    }

    public List<SolutionRecord> findByUser(User user) {
        return solutions.stream()
                .filter(s -> s.getUser().equals(user))
                .toList();
    }

    public List<SolutionRecord> findByProblem(Problem problem) {
        return solutions.stream()
                .filter(s -> s.getProblem().equals(problem))
                .toList();
    }
}