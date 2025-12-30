package com.interview.practice.service;

import com.interview.practice.domain.Rating;
import com.interview.practice.domain.statergy.factory.RatingFactory;
import com.interview.practice.repository.RatingRepository;

import java.time.LocalDate;

public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository){
           this.ratingRepository = ratingRepository;
    }

    public void addRating(String agentId, int rating, LocalDate localDate){
           Rating rating = RatingFactory.create(agentId,rating,localDate);
    }



}
