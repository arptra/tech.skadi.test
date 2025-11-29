package com.airbnb.epoxy;

import android.widget.CompoundButton;
import com.airbnb.epoxy.EpoxyModel;

public class WrappedEpoxyModelCheckedChangeListener<T extends EpoxyModel<?>, V> implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final OnModelCheckedChangeListener f2320a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WrappedEpoxyModelCheckedChangeListener)) {
            return false;
        }
        return this.f2320a.equals(((WrappedEpoxyModelCheckedChangeListener) obj).f2320a);
    }

    public int hashCode() {
        return this.f2320a.hashCode();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int adapterPosition;
        EpoxyViewHolder b = ListenersUtils.b(compoundButton);
        if (b != null && (adapterPosition = b.getAdapterPosition()) != -1) {
            this.f2320a.a(b.d(), b.e(), compoundButton, z, adapterPosition);
        }
    }
}
