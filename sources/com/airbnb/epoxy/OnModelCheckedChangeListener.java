package com.airbnb.epoxy;

import android.widget.CompoundButton;
import com.airbnb.epoxy.EpoxyModel;

public interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V> {
    void a(EpoxyModel epoxyModel, Object obj, CompoundButton compoundButton, boolean z, int i);
}
