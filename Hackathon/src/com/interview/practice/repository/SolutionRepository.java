package com.interview.practice.repository;

import com.interview.practice.model.Problem;
import com.interview.practice.model.SolutionRecord;
import com.interview.practice.model.User;

import java.util.ArrayList;
import java.util.List;

public class SolutionRepository {

     private final List<SolutionRecord> solutions = new ArrayList<>();

        public void save(SolutionRecord solution) {
            solutions.add(solution);
        }

        public List<SolutionRecord> findAll() {
            return solutions;
        }

        public List<SolutionRecord> findByUser(User user) {

            List<SolutionRecord> list = new ArrayList<>();
            for(SolutionRecord s : user.getSolvedProblems()){
                if (s.getUser().equals(user)){
                    list.add(s);
                }
            }
            return list;
        }

        public List<SolutionRecord> findByProblem(Problem problem) {
            List<SolutionRecord> list = new ArrayList<>();
            for(SolutionRecord s : problem.getSolutions()){
                if (s.getUser().equals(problem)){
                    list.add(s);
                }
            }
            return list;
        }
    }

