package io.reactivex.rxjava3.core;

public enum BackpressureStrategy {
    MISSING,
    ERROR,
    BUFFER,
    DROP,
    LATEST
}
