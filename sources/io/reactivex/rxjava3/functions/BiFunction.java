package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface BiFunction<T1, T2, R> {
    R apply(T1 t1, T2 t2) throws Throwable;
}
