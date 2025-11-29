package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.ViewHolderState;
import java.util.List;

public class EpoxyViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public EpoxyModel f2300a;
    public List b;
    public EpoxyHolder c;
    public ViewHolderState.ViewState d;
    public ViewParent e;

    public EpoxyViewHolder(ViewParent viewParent, View view, boolean z) {
        super(view);
        this.e = viewParent;
        if (z) {
            ViewHolderState.ViewState viewState = new ViewHolderState.ViewState();
            this.d = viewState;
            viewState.save(this.itemView);
        }
    }

    public final void a() {
        if (this.f2300a == null) {
            throw new IllegalStateException("This holder is not currently bound.");
        }
    }

    public void b(EpoxyModel epoxyModel, EpoxyModel epoxyModel2, List list, int i) {
        this.b = list;
        if (this.c == null && (epoxyModel instanceof EpoxyModelWithHolder)) {
            EpoxyHolder W = ((EpoxyModelWithHolder) epoxyModel).W(this.e);
            this.c = W;
            W.a(this.itemView);
        }
        this.e = null;
        if (epoxyModel instanceof GeneratedModel) {
            ((GeneratedModel) epoxyModel).k(this, e(), i);
        }
        epoxyModel.O(e(), epoxyModel2);
        if (epoxyModel2 != null) {
            epoxyModel.u(e(), epoxyModel2);
        } else if (list.isEmpty()) {
            epoxyModel.t(e());
        } else {
            epoxyModel.v(e(), list);
        }
        if (epoxyModel instanceof GeneratedModel) {
            ((GeneratedModel) epoxyModel).d(e(), i);
        }
        this.f2300a = epoxyModel;
    }

    public EpoxyHolder c() {
        a();
        return this.c;
    }

    public EpoxyModel d() {
        a();
        return this.f2300a;
    }

    public Object e() {
        EpoxyHolder epoxyHolder = this.c;
        return epoxyHolder != null ? epoxyHolder : this.itemView;
    }

    public void f() {
        ViewHolderState.ViewState viewState = this.d;
        if (viewState != null) {
            viewState.restore(this.itemView);
        }
    }

    public void g() {
        a();
        this.f2300a.R(e());
        this.f2300a = null;
        this.b = null;
    }

    public void h(float f, float f2, int i, int i2) {
        a();
        this.f2300a.M(f, f2, i, i2, e());
    }

    public void i(int i) {
        a();
        this.f2300a.N(i, e());
    }

    public String toString() {
        return "EpoxyViewHolder{epoxyModel=" + this.f2300a + ", view=" + this.itemView + ", super=" + super.toString() + '}';
    }
}
