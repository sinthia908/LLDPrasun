package com.interview.practice.statergy;

import com.interview.practice.model.SolutionRecord;
import com.interview.practice.model.User;

class TimeBasedScoringStrategy
        implements ScoringStrategy{

    public int calculateScore(User user){

        int total=0;

        for(SolutionRecord s:
                user.getSolvedProblems()){

            total+=s.getProblem().getScore();

            if(s.getTimeTaken()<600)
                total+=50;
        }

        return total;
    }
}
