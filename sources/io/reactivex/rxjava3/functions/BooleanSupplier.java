package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface BooleanSupplier {
    boolean getAsBoolean() throws Throwable;
}
