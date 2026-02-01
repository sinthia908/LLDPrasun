package com.interview.practice.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
    List<Suggestion> suggestions = new ArrayList<>();

}
