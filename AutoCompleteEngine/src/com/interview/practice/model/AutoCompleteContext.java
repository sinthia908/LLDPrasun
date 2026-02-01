package com.interview.practice.model;

public class AutoCompleteContext {
    private final ContextType contextType;
    private final IDE ide; // null if TEXT
    private final String prefix; // store typed prefix for TEXT

    private AutoCompleteContext(ContextType contextType, IDE ide, String prefix) {
        this.contextType = contextType;
        this.ide = ide;
        this.prefix = prefix;
    }

    public static AutoCompleteContext text(String prefix) {
        return new AutoCompleteContext(ContextType.TEXT, null, prefix);
    }

    public static AutoCompleteContext ide(IDE ide) {
        return new AutoCompleteContext(ContextType.IDE, ide, null);
    }

    public ContextType getContextType() { return contextType; }
    public IDE getIde() { return ide; }
    public String getPrefix() { return prefix; }
}
