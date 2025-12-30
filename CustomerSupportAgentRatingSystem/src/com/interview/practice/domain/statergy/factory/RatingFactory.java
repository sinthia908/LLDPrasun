package com.interview.practice.domain.statergy.factory;

import com.interview.practice.domain.Rating;
import com.interview.practice.exception.InvalidRatingSystemException;

import java.time.LocalDate;

public class RatingFactory {

    public static Rating create(String agentId, int value, LocalDate date){

        if ( agentId == null || agentId.isEmpty())
            throw new InvalidRatingSystemException("Agent Id cannot be null or empty");

        if ( value < 1 || value > 5)
             throw new InvalidRatingSystemException("Rating must be between 1 and 5");

        return new Rating(agentId,value,date);

    }
}
