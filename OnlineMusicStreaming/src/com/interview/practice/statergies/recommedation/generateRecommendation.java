package com.interview.practice.statergies.recommedation;

import com.interview.practice.entities.Song;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class generateRecommendation implements RecommendationStatergy{


    // In a real system , songs would have generate . We simulate this
    @Override
    public List<Song> recommend(List<Song> allSongs) {
           System.out.println("Generation genre-based recommandations");
           List<Song> shuffled = new java.util.ArrayList<>();
           Collections.shuffle(shuffled);
           return shuffled.stream().limit(5).collect(Collectors.toList());
    }
}
