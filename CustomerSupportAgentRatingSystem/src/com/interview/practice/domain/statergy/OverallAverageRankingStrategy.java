//


package com.interview.practice.domain.statergy;

import com.interview.practice.domain.Rating;
import com.interview.practice.dto.AverageAgentDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OverallAverageRankingStrategy implements RankingStatergy {
    @Override
    public List<AverageAgentDTO> rank(List<Rating> ratings) {
        Map<String, List<Rating>> grouped = ratings.stream()
                .collect(Collectors.groupingBy(Rating::getAgentId));
        return grouped.entrySet().stream()
                .map(e -> {
                    double avg = e.getValue().stream()
                            .mapToInt(Rating::getRating)
                            .average().orElse(0.0);

                    return AverageAgentDTO.Builder.builder()
                            .agentId(e.getKey())
                            .averageRating(avg)
                            .build();
                })
                .sorted((a, b) -> Double.compare(b.getAverageRating(), a.getAverageRating()))
                .collect(Collectors.toList());
    }
}