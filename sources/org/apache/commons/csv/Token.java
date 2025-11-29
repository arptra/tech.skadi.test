package org.apache.commons.csv;

final class Token {
    private static final int INITIAL_TOKEN_LENGTH = 50;
    final StringBuilder content = new StringBuilder(50);
    boolean isQuoted;
    boolean isReady;
    Type type = Type.INVALID;

    public enum Type {
        INVALID,
        TOKEN,
        EOF,
        EORECORD,
        COMMENT
    }

    public void reset() {
        this.content.setLength(0);
        this.type = Type.INVALID;
        this.isReady = false;
        this.isQuoted = false;
    }

    public String toString() {
        return this.type.name() + " [" + this.content.toString() + "]";
    }
}
