package com.airbnb.epoxy;

import android.view.View;
import com.airbnb.epoxy.EpoxyModel;

public interface OnModelLongClickListener<T extends EpoxyModel<?>, V> {
    boolean a(EpoxyModel epoxyModel, Object obj, View view, int i);
}
