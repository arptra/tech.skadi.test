package io.netty.util;

import io.netty.util.Constant;

public interface Constant<T extends Constant<T>> extends Comparable<T> {
    int id();

    String name();
}
