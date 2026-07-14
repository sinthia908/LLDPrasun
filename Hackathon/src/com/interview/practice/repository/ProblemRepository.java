package com.interview.practice.repository;

import com.interview.practice.model.Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemRepository {

    private final Map<String, Problem> problems = new HashMap<>();

    public void save(Problem problem) {
        problems.put(problem.getId(), problem);
    }

    public Problem findById(String id) {
        return problems.get(id);
    }

    public List<Problem> findAll() {
        return new ArrayList<>(problems.values());
    }

    public void delete(String id) {
        problems.remove(id);
    }
}
