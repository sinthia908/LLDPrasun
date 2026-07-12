package com.interview.practice.Specification;

import com.interview.practice.model.Problem;

class AndSpecification
        implements ProblemSpecification{

    private ProblemSpecification left;
    private ProblemSpecification right;

    public boolean isSatisfied(Problem p){

        return left.isSatisfied(p)
                && right.isSatisfied(p);
    }
}
