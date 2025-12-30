package com.interview.practice.domain.statergy;

import com.interview.practice.domain.Rating;

import java.util.List;

public interface RankingStatergy {

    List<?> rank(List<Rating> ratings);


}
