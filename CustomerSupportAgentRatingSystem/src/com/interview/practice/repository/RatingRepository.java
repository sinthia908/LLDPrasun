// Dependency Inversion (SOLID principle)



package com.interview.practice.repository;

import com.interview.practice.domain.Rating;

import java.util.List;




public interface RatingRepository {

    void save(Rating rating);
    List<Rating> findAll();

}
