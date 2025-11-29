package com.here.sdk.search;

public enum SuggestionType {
    CATEGORY(0),
    CHAIN(1),
    PLACE(2);
    
    public final int value;

    private SuggestionType(int i) {
        this.value = i;
    }
}
