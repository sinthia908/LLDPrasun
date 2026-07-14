package com.interview.practice.service;

import com.interview.practice.model.Problem;
import com.interview.practice.model.SolutionRecord;
import com.interview.practice.model.User;
import com.interview.practice.repository.ProblemRepository;
import com.interview.practice.repository.SolutionRepository;
import com.interview.practice.repository.UserRepository;
import com.interview.practice.statergy.ScoringStatergy;

import java.util.ArrayList;
import java.util.List;

public class ContestService {

    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;
    private final SolutionRepository solutionRepository;
    private final ScoringStatergy scoringStrategy;

    public ContestService(UserRepository userRepository,
                          ProblemRepository problemRepository,
                          SolutionRepository solutionRepository,
                          ScoringStatergy scoringStrategy) {

        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
        this.solutionRepository = solutionRepository;
        this.scoringStrategy = scoringStrategy;
    }

    /**
     * User solves a problem
     */
    public void solve(String userId,
                      String problemId,
                      long timeTaken) {

        User user = userRepository.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Problem problem = problemRepository.findById(problemId);

        if (problem == null) {
            throw new IllegalArgumentException("Problem not found");
        }

        SolutionRecord solution =
                new SolutionRecord(user, problem, timeTaken);

        // update domain objects
        user.addSolvedProblem(solution);

        problem.addSolution(solution);

        // save solution
        solutionRepository.save(solution);
    }

    /**
     * Returns all problems solved by a user
     */
    public List<Problem> fetchSolvedProblems(String userId) {

        User user = userRepository.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        List<Problem> result = new ArrayList<>();

        for (SolutionRecord solution : user.getSolvedProblems()) {
            result.add(solution.getProblem());
        }

        return result;
    }

    /**
     * Current leader
     */
    public User getLeader() {

        List<User> users = userRepository.findAll();

        User leader = null;
        int maxScore = Integer.MIN_VALUE;

        for (User user : users) {

            int score = user.getScore(scoringStrategy);

            if (score > maxScore) {
                maxScore = score;
                leader = user;
            }
        }

        return leader;
    }
}
