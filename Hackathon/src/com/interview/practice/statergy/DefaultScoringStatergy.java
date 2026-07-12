package com.interview.practice.statergy;

import com.interview.practice.model.SolutionRecord;
import com.interview.practice.model.User;

class DefaultScoringStrategy
        implements ScoringStatergy{

    public int calculateScore(User user){

        int score=0;

        for(SolutionRecord s:
                user.getSolvedProblems())
            score+=s.getProblem().getScore();

        return score;
    }
}