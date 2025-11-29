package io.netty.handler.ssl;

public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    public SniCompletionEvent(String str) {
        this.hostname = str;
    }

    public String hostname() {
        return this.hostname;
    }

    public String toString() {
        Throwable cause = cause();
        Class<SniCompletionEvent> cls = SniCompletionEvent.class;
        if (cause == null) {
            return cls.getSimpleName() + "(SUCCESS='" + this.hostname + "'\")";
        }
        return cls.getSimpleName() + '(' + cause + ')';
    }

    public SniCompletionEvent(String str, Throwable th) {
        super(th);
        this.hostname = str;
    }

    public SniCompletionEvent(Throwable th) {
        this((String) null, th);
    }
}
