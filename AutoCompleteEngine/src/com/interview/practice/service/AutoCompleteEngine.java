package com.interview.practice.service;

import com.interview.practice.model.*;

import java.util.List;
import java.util.stream.Collectors;

/*
 This keeps ranking logic extensible and decoupled from search.
*/

public class AutoCompleteEngine {

    private final Trie trie = new Trie();

    public void addSuggestion(Suggestion suggestion) {
        trie.insert(suggestion);
    }

    // Unified entry point for TEXT and IDE autocomplete
    public List<String> getSuggestions(String prefix,
                                       AutoCompleteContext context) {

        // 1️⃣ Prefix search (Trie responsibility)
        List<Suggestion> matches = trie.searchByPrefix(prefix);

        // 2️⃣ Strategy selection (Factory responsibility)
        RankingStatergy strategy =
                RankingStatergyFactory.getStrategy(context);

        // 3️⃣ Ranking + projection (Strategy responsibility)
        return strategy.rank(matches, context)
                .stream()
                .map(s -> s.text)
                .collect(Collectors.toUnmodifiableList());
    }
}
