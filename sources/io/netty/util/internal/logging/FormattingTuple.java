package io.netty.util.internal.logging;

public final class FormattingTuple {
    private final String message;
    private final Throwable throwable;

    public FormattingTuple(String str, Throwable th) {
        this.message = str;
        this.throwable = th;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
