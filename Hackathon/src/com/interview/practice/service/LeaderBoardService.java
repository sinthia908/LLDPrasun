package com.interview.practice.service;

import com.interview.practice.model.User;

import java.util.Comparator;
import java.util.List;

class LeaderboardService{

    private ScoringStrategy strategy;

    public User getLeader(List<User> users){

        return users.stream()
                .max(Comparator.comparingInt(
                        u->u.getScore(strategy)))
                .orElse(null);
    }
}