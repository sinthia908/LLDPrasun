package com.interview.practice.model;

import java.util.List;

public class FrequencyBasedRanking implements RankingStatergy{
    @Override
    public List<Suggestion> rank(List<Suggestion> suggestionList,AutoCompleteContext contextType) {
        return suggestionList.stream().filter(s->s.contextTypes.contains(contextType))
                .sorted((a,b)->b.frequency-a.frequency).toList();

    }
}
