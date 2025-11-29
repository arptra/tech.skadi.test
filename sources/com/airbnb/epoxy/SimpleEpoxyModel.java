package com.airbnb.epoxy;

import android.view.View;

public class SimpleEpoxyModel extends EpoxyModel<View> {
    public final int l;
    public View.OnClickListener m;
    public int n;

    public int A(int i, int i2, int i3) {
        return this.n;
    }

    /* renamed from: T */
    public void t(View view) {
        super.t(view);
        view.setOnClickListener(this.m);
        view.setClickable(this.m != null);
    }

    /* renamed from: U */
    public void R(View view) {
        super.R(view);
        view.setOnClickListener((View.OnClickListener) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleEpoxyModel) || !super.equals(obj)) {
            return false;
        }
        SimpleEpoxyModel simpleEpoxyModel = (SimpleEpoxyModel) obj;
        if (this.l != simpleEpoxyModel.l || this.n != simpleEpoxyModel.n) {
            return false;
        }
        View.OnClickListener onClickListener = this.m;
        return onClickListener != null ? onClickListener.equals(simpleEpoxyModel.m) : simpleEpoxyModel.m == null;
    }

    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + this.l) * 31;
        View.OnClickListener onClickListener = this.m;
        return ((hashCode + (onClickListener != null ? onClickListener.hashCode() : 0)) * 31) + this.n;
    }

    public int x() {
        return this.l;
    }
}
