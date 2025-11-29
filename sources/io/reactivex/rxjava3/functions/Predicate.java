package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t) throws Throwable;
}
