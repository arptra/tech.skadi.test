package com.fasterxml.jackson.core.util;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;

public class Separators implements Serializable {
    private static final long serialVersionUID = 1;
    private final char arrayValueSeparator;
    private final char objectEntrySeparator;
    private final char objectFieldValueSeparator;

    public Separators() {
        this(':', StringUtil.COMMA, StringUtil.COMMA);
    }

    public static Separators createDefaultInstance() {
        return new Separators();
    }

    public char getArrayValueSeparator() {
        return this.arrayValueSeparator;
    }

    public char getObjectEntrySeparator() {
        return this.objectEntrySeparator;
    }

    public char getObjectFieldValueSeparator() {
        return this.objectFieldValueSeparator;
    }

    public Separators withArrayValueSeparator(char c) {
        return this.arrayValueSeparator == c ? this : new Separators(this.objectFieldValueSeparator, this.objectEntrySeparator, c);
    }

    public Separators withObjectEntrySeparator(char c) {
        return this.objectEntrySeparator == c ? this : new Separators(this.objectFieldValueSeparator, c, this.arrayValueSeparator);
    }

    public Separators withObjectFieldValueSeparator(char c) {
        return this.objectFieldValueSeparator == c ? this : new Separators(c, this.objectEntrySeparator, this.arrayValueSeparator);
    }

    public Separators(char c, char c2, char c3) {
        this.objectFieldValueSeparator = c;
        this.objectEntrySeparator = c2;
        this.arrayValueSeparator = c3;
    }
}
