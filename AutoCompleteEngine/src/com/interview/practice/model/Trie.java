package com.interview.practice.model;

import java.util.Collections;
import java.util.List;

public class Trie {

private final TrieNode root = new TrieNode();

public void insert(Suggestion suggestion){

    TrieNode node = root;

    for(char c: suggestion.text.toCharArray()){
        node = node.children.computeIfAbsent(c,k->new TrieNode());
        node.suggestions.add(suggestion);
    }
    node.isEnd = true;
}

public List<Suggestion> searchByPrefix(String prefix){
    TrieNode node = root;
    for(char c : prefix.toCharArray()){
        node = node.children.get(c);
        if ( node == null) return Collections.EMPTY_LIST;
    }

    return node.suggestions;
}

}
