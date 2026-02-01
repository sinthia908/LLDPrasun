package com.interview.practice.model;

import java.util.List;

public class FrequencyBasedRanking implements RankingStatergy {

    @Override
    public List<Suggestion> rank(List<Suggestion> suggestionList, AutoCompleteContext context) {

        // Get the typed prefix if TEXT context
        String prefix = context.getContextType() == ContextType.TEXT ? context.getPrefix() : "";

        final String finalPrefix = prefix != null ? prefix : "";

        return suggestionList.stream()
                .filter(s -> s.contextTypes.contains(context.getContextType()))
                .sorted((a, b) -> score(b, finalPrefix) - score(a, finalPrefix))
                .toList();
    }

    private int score(Suggestion s, String prefix) {
        int score = s.frequency; // base score = frequency

        // Add a small boost if suggestion starts with the typed prefix
        if (!prefix.isEmpty() && s.text.startsWith(prefix)) {
            score += 10;
        }

        return score;
    }
}
