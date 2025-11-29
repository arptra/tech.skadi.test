package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Cancellable {
    void cancel() throws Throwable;
}
