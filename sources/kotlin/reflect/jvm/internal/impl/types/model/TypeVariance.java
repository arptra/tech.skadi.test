package kotlin.reflect.jvm.internal.impl.types.model;

import org.jetbrains.annotations.NotNull;

public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");
    
    @NotNull
    private final String presentation;

    private TypeVariance(String str) {
        this.presentation = str;
    }

    @NotNull
    public String toString() {
        return this.presentation;
    }
}
