package com.interview.practice.model;

import java.util.List;

public class RelevanceRankingStatergy implements RankingStatergy {

    @Override
    public List<Suggestion> rank(List<Suggestion> suggestions,
                                 AutoCompleteContext context) {

        return suggestions.stream()
                .filter(s -> s.contextTypes.contains(context.getContextType()))
                .sorted((a, b) ->
                        relevanceScore(b, context) -
                                relevanceScore(a, context))
                .toList();
    }

    private int relevanceScore(Suggestion s,
                               AutoCompleteContext context) {

        int score = s.frequency;

        if (context.getContextType() == ContextType.IDE) {

            if (context.getIde().getSupportedLanguages()
                    .contains(Language.JAVA)
                    && s.text.matches("private|class|public")) {
                score += 10;
            }

            if (context.getIde().getSupportedLanguages()
                    .contains(Language.PYTHON)
                    && s.text.matches("def|print|self")) {
                score += 10;
            }
        }

        return score;
    }
}































