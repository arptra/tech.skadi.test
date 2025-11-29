package com.upuphone.xr.interconnect.util;

import java.util.concurrent.CopyOnWriteArrayList;

public class DeDuplicateCopyOnWriteArrayList<E> extends CopyOnWriteArrayList<E> {
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        return super.add(e);
    }
}
