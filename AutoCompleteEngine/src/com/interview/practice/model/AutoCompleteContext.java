package com.interview.practice.model;

public class AutoCompleteContext {

    private final ContextType contextType;
    private final IDE ide; // null for TEXT

    private AutoCompleteContext(ContextType contextType, IDE ide) {
        this.contextType = contextType;
        this.ide = ide;
    }

    public static AutoCompleteContext text() {
        return new AutoCompleteContext(ContextType.TEXT, null);
    }

    public static AutoCompleteContext ide(IDE ide) {
        return new AutoCompleteContext(ContextType.IDE, ide);
    }

    public ContextType getContextType() {
        return contextType;
    }

    public IDE getIde() {
        return ide;
    }
}
