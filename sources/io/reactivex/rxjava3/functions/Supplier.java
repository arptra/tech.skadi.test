package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Supplier<T> {
    T get() throws Throwable;
}
