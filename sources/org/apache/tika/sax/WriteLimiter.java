package org.apache.tika.sax;

public interface WriteLimiter {
    int getWriteLimit();

    boolean isThrowOnWriteLimitReached();
}
