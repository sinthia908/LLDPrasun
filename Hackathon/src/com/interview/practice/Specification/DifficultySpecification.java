package com.interview.practice.Specification;

import com.interview.practice.model.Difficulty;
import com.interview.practice.model.Problem;

class DifficultySpecification
        implements ProblemSpecification{

    private Difficulty difficulty;

    public DifficultySpecification(
            Difficulty difficulty){

        this.difficulty=difficulty;
    }

    public boolean isSatisfied(Problem p){

        return p.getDifficulty()==difficulty;
    }
}