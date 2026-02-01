package com.interview.practice.main;

import com.interview.practice.model.*;
import com.interview.practice.service.AutoCompleteEngine;
import java.util.Set;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        AutoCompleteEngine engine = new AutoCompleteEngine();

        // Add suggestions
        engine.addSuggestion(new Suggestion("print", 50, Set.of(ContextType.TEXT, ContextType.IDE), Set.of(Language.PYTHON)));
        engine.addSuggestion(new Suggestion("private", 40, Set.of(ContextType.IDE), Set.of(Language.JAVA)));
        engine.addSuggestion(new Suggestion("printf", 20, Set.of(ContextType.IDE), Set.of(Language.JAVA)));
        engine.addSuggestion(new Suggestion("priority", 10, Set.of(ContextType.TEXT), null));

        // TEXT suggestions (frequency-based, with prefix boost)
        List<String> textSuggestions = engine.getSuggestions(
                "pri",
                AutoCompleteContext.text("pri") // pass the typed prefix
        );
        System.out.println("TEXT suggestions: " + textSuggestions);

        // IDE suggestions (relevance-based)
        List<String> ideSuggestions = engine.getSuggestions(
                "pri",
                AutoCompleteContext.ide(IDE.INTELLIJ)
        );
        System.out.println("IDE suggestions: " + ideSuggestions);
    }
}
