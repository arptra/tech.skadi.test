package com.chad.library.adapter.base.diff;

import java.util.List;

public interface ListChangeListener<T> {
    void onCurrentListChanged(List list, List list2);
}
