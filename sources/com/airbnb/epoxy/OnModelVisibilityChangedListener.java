package com.airbnb.epoxy;

import com.airbnb.epoxy.EpoxyModel;

public interface OnModelVisibilityChangedListener<T extends EpoxyModel<V>, V> {
    void a(EpoxyModel epoxyModel, Object obj, float f, float f2, int i, int i2);
}
