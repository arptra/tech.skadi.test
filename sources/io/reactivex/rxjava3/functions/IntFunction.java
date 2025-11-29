package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface IntFunction<T> {
    T apply(int i) throws Throwable;
}
