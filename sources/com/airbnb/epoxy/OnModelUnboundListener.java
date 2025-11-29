package com.airbnb.epoxy;

import com.airbnb.epoxy.EpoxyModel;

public interface OnModelUnboundListener<T extends EpoxyModel<?>, V> {
    void a(EpoxyModel epoxyModel, Object obj);
}
