package com.interview.practice.model;

import java.util.Set;

import java.util.Set;

public class    Suggestion {

    public String text;
    public int frequency;
    public Set<ContextType> contextTypes;
    public Set<Language> languages; // null or empty = all

    public Suggestion(String text,
                      int frequency,
                      Set<ContextType> contextTypes,
                      Set<Language> languages) {
        this.text = text;
        this.frequency = frequency;
        this.contextTypes = contextTypes;
        this.languages = languages;
    }
}

