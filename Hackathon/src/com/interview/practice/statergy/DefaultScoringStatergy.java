package com.interview.practice.statergy;

import com.interview.practice.model.SolutionRecord;
import com.interview.practice.model.User;

public class DefaultScoringStatergy implements ScoringStatergy {

    @Override
    public int calculateScore(User user) {
        int score = 0;

        for (SolutionRecord solutionRecord : user.getSolvedProblems()) {
            score += solutionRecord.getProblem().getScore();
        }

        return score;
    }
}