package com.xjsd.ai.assistant.nlu.util;

import java.util.ArrayList;

public class AutoExcludeNullArrayList<E> extends ArrayList<E> {
    public boolean add(E e) {
        if (e == null) {
            return true;
        }
        return super.add(e);
    }
}
