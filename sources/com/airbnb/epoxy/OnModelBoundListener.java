package com.airbnb.epoxy;

import com.airbnb.epoxy.EpoxyModel;

public interface OnModelBoundListener<T extends EpoxyModel<?>, V> {
    void a(EpoxyModel epoxyModel, Object obj, int i);
}
