package com.airbnb.epoxy;

import com.airbnb.epoxy.EpoxyModel;

public interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V> {
    void a(EpoxyModel epoxyModel, Object obj, int i);
}
