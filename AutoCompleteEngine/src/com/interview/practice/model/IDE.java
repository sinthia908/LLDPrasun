package com.interview.practice.model;

import java.util.Set;

public enum IDE {

    INTELLIJ(Set.of(Language.JAVA)),
    PYCHARM(Set.of(Language.PYTHON)),
    VSCODE(Set.of(Language.JAVA,Language.PYTHON));


    private final Set<Language> supportedLanguages;


    IDE(Set<Language> supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    Set<Language> getSupportedLanguages(){
        return supportedLanguages;
    }


}
