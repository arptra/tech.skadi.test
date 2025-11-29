package com.xjsd.ai.assistant.core.util;

import java.util.concurrent.CopyOnWriteArrayList;

public class DeDuplicateCopyOnWriteArrayList<E> extends CopyOnWriteArrayList<E> {
    public boolean add(E e) {
        if (contains(e)) {
            return true;
        }
        return super.add(e);
    }
}
