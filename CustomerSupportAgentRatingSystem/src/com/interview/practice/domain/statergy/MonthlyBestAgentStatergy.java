package com.interview.practice.domain.statergy;

import com.interview.practice.domain.Rating;
import com.interview.practice.dto.MonthlyBestAgentDTO;

import java.time.YearMonth;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MonthlyBestAgentStatergy implements RankingStatergy{
    @Override
    public List<MonthlyBestAgentDTO> rank(List<Rating> ratings) {

        Map<YearMonth, Map<String, List<Rating>>> grouped =
                ratings.stream().collect(
                        Collectors.groupingBy(
                                r -> YearMonth.from((TemporalAccessor) r.getDate()),
                                Collectors.groupingBy(Rating::getAgentId)
                        )
                );

        List<MonthlyBestAgentDTO> output = new ArrayList<>();

        // Sort by year month
        for(YearMonth yearMonth: grouped.keySet().stream().sorted().collect(Collectors.toList())){
            Map<String,List<Rating>> byAgent = grouped.get(yearMonth);
            String bestAgent = null;
            double bestAvg = 0.0 ;

           for(Map.Entry<String,List<Rating>> entry: byAgent.entrySet()){
               double avg = entry.getValue().stream().mapToInt(Rating::getRating).average().orElse(0.0);

               if (avg > bestAvg || bestAgent == null){
                   bestAgent = entry.getKey();
                   bestAvg = avg;
               }
           }
            output.add(
                    MonthlyBestAgentDTO.Builder.builder()
                            .month(yearMonth)
                            .agentId(bestAgent)
                            .averageRating(bestAvg)
                            .build()
            );
        }

        return output;
    }
}
