package com.airbnb.epoxy;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.viewmodeladapter.R;

public abstract class EpoxyModelTouchCallback<T extends EpoxyModel> extends EpoxyTouchHelperCallback implements EpoxyDragCallback<T>, EpoxySwipeCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    public final EpoxyController f2294a;
    public final Class b;
    public EpoxyViewHolder c;
    public EpoxyViewHolder d;

    public final boolean A(RecyclerView recyclerView) {
        return recyclerView.getTag(R.id.epoxy_touch_helper_selection_status) != null;
    }

    public boolean b(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, EpoxyViewHolder epoxyViewHolder2) {
        return r(epoxyViewHolder2.d());
    }

    public void e(final RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder) {
        super.e(recyclerView, epoxyViewHolder);
        q(epoxyViewHolder.d(), epoxyViewHolder.itemView);
        recyclerView.postDelayed(new Runnable() {
            public void run() {
                EpoxyModelTouchCallback.this.p(recyclerView);
            }
        }, 300);
    }

    public int g(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder) {
        EpoxyModel d2 = epoxyViewHolder.d();
        if ((this.c != null || this.d != null || !A(recyclerView)) && r(d2)) {
            return a(d2, epoxyViewHolder.getAdapterPosition());
        }
        return 0;
    }

    public void i(Canvas canvas, RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, float f, float f2, int i, boolean z) {
        super.i(canvas, recyclerView, epoxyViewHolder, f, f2, i, z);
        try {
            EpoxyModel d2 = epoxyViewHolder.d();
            if (r(d2)) {
                View view = epoxyViewHolder.itemView;
                x(d2, view, Math.max(-1.0f, Math.min(1.0f, Math.abs(f) > Math.abs(f2) ? f / ((float) view.getWidth()) : f2 / ((float) view.getHeight()))), canvas);
                return;
            }
            throw new IllegalStateException("A model was selected that is not a valid target: " + d2.getClass());
        } catch (IllegalStateException unused) {
        }
    }

    public boolean k(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, EpoxyViewHolder epoxyViewHolder2) {
        if (this.f2294a != null) {
            int adapterPosition = epoxyViewHolder.getAdapterPosition();
            int adapterPosition2 = epoxyViewHolder2.getAdapterPosition();
            this.f2294a.moveModel(adapterPosition, adapterPosition2);
            EpoxyModel d2 = epoxyViewHolder.d();
            if (r(d2)) {
                v(adapterPosition, adapterPosition2, d2, epoxyViewHolder.itemView);
                return true;
            }
            throw new IllegalStateException("A model was dragged that is not a valid target: " + d2.getClass());
        }
        throw new IllegalStateException("A controller must be provided in the constructor if dragging is enabled");
    }

    public void m(EpoxyViewHolder epoxyViewHolder, int i) {
        super.m(epoxyViewHolder, i);
        if (epoxyViewHolder != null) {
            EpoxyModel d2 = epoxyViewHolder.d();
            if (r(d2)) {
                s((RecyclerView) epoxyViewHolder.itemView.getParent());
                if (i == 1) {
                    this.d = epoxyViewHolder;
                    z(d2, epoxyViewHolder.itemView, epoxyViewHolder.getAdapterPosition());
                } else if (i == 2) {
                    this.c = epoxyViewHolder;
                    u(d2, epoxyViewHolder.itemView, epoxyViewHolder.getAdapterPosition());
                }
            } else {
                throw new IllegalStateException("A model was selected that is not a valid target: " + d2.getClass());
            }
        } else {
            EpoxyViewHolder epoxyViewHolder2 = this.c;
            if (epoxyViewHolder2 != null) {
                t(epoxyViewHolder2.d(), this.c.itemView);
                this.c = null;
                return;
            }
            EpoxyViewHolder epoxyViewHolder3 = this.d;
            if (epoxyViewHolder3 != null) {
                y(epoxyViewHolder3.d(), this.d.itemView);
                this.d = null;
            }
        }
    }

    public void n(EpoxyViewHolder epoxyViewHolder, int i) {
        EpoxyModel d2 = epoxyViewHolder.d();
        View view = epoxyViewHolder.itemView;
        int adapterPosition = epoxyViewHolder.getAdapterPosition();
        if (r(d2)) {
            w(d2, view, adapterPosition, i);
            return;
        }
        throw new IllegalStateException("A model was swiped that is not a valid target: " + d2.getClass());
    }

    public final void p(RecyclerView recyclerView) {
        recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, (Object) null);
    }

    public void q(EpoxyModel epoxyModel, View view) {
    }

    public boolean r(EpoxyModel epoxyModel) {
        return this.b.isInstance(epoxyModel);
    }

    public final void s(RecyclerView recyclerView) {
        recyclerView.setTag(R.id.epoxy_touch_helper_selection_status, Boolean.TRUE);
    }

    public void t(EpoxyModel epoxyModel, View view) {
    }

    public void u(EpoxyModel epoxyModel, View view, int i) {
    }

    public void v(int i, int i2, EpoxyModel epoxyModel, View view) {
    }

    public void w(EpoxyModel epoxyModel, View view, int i, int i2) {
    }

    public void x(EpoxyModel epoxyModel, View view, float f, Canvas canvas) {
    }

    public void y(EpoxyModel epoxyModel, View view) {
    }

    public void z(EpoxyModel epoxyModel, View view, int i) {
    }
}
