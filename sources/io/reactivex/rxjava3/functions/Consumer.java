package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t) throws Throwable;
}
