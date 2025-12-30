package com.interview.practice.repository;

import com.interview.practice.domain.Rating;

import java.util.*;

public class InMemoryRatingRepository implements RatingRepository{

    private final List<Rating> ratingList = new ArrayList<>();

    @Override
    public void save(Rating rating) {
        ratingList.add(rating);
    }

    @Override
    public List<Rating> findAll() {
        return new ArrayList<>(ratingList);
    }
}
