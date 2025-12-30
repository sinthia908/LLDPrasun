package com.interview.practice.statergies.recommedation;

import com.interview.practice.entities.Song;

import java.util.List;

public interface RecommendationStatergy {

    List<Song> recommend(List<Song> allSongs);
}
