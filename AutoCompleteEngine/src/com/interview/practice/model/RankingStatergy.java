package com.interview.practice.model;

import java.util.List;

public interface RankingStatergy {
    List<Suggestion> rank(List<Suggestion> suggestionList, AutoCompleteContext contextType);
}
