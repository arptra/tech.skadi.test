package com.airbnb.epoxy;

import android.view.View;
import com.airbnb.epoxy.EpoxyModel;

public interface OnModelClickListener<T extends EpoxyModel<?>, V> {
    void a(EpoxyModel epoxyModel, Object obj, View view, int i);
}
