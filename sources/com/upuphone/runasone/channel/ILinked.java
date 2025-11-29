package com.upuphone.runasone.channel;

interface ILinked<T> {
    void add(T t);

    boolean contains(T t);

    int getCount();

    String getName();

    T getNodeById(Integer num);

    boolean isEmpty();

    void modifyById(Integer num, T t);

    void remove(T t);

    void removeAll();

    void removeRoot();

    Object[] returnAll();
}
