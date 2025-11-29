package com.airbnb.epoxy;

import androidx.recyclerview.widget.RecyclerView;

class NotifyBlocker extends RecyclerView.AdapterDataObserver {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2312a;

    public void a() {
        this.f2312a = true;
    }

    public void b() {
        this.f2312a = false;
    }

    public void onChanged() {
        if (!this.f2312a) {
            throw new IllegalStateException("You cannot notify item changes directly. Call `requestModelBuild` instead.");
        }
    }

    public void onItemRangeChanged(int i, int i2) {
        onChanged();
    }

    public void onItemRangeInserted(int i, int i2) {
        onChanged();
    }

    public void onItemRangeMoved(int i, int i2, int i3) {
        onChanged();
    }

    public void onItemRangeRemoved(int i, int i2) {
        onChanged();
    }

    public void onItemRangeChanged(int i, int i2, Object obj) {
        onChanged();
    }
}
