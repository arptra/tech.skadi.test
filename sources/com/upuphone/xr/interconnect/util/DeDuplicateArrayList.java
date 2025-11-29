package com.upuphone.xr.interconnect.util;

import java.util.ArrayList;

public class DeDuplicateArrayList<E> extends ArrayList<E> {
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        return super.add(e);
    }
}
