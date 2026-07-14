package com.interview.practice.service;

import com.interview.practice.model.Problem;
import com.interview.practice.repository.ProblemRepository;

import java.util.ArrayList;
import java.util.List;

public class ProblemService {

    private ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public void addProblem(Problem problem) {
        problemRepository.save(problem);
    }

    public List<Problem> getTopNProblems(String tag, int n) {

        List<Problem> result = new ArrayList<>();

        for (Problem problem : problemRepository.findAll()) {

            if (problem.getTag().equalsIgnoreCase(tag)) {
                result.add(problem);
            }
        }

        result.sort((p1, p2) ->
                Integer.compare(p2.getLikes(), p1.getLikes()));

        if (result.size() > n) {
            return result.subList(0, n);
        }

        return result;
    }

}
