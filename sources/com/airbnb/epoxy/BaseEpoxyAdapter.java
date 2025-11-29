package com.airbnb.epoxy;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseEpoxyAdapter extends RecyclerView.Adapter<EpoxyViewHolder> implements StickyHeaderCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public int f2271a = 1;
    public final ViewTypeManager b = new ViewTypeManager();
    public final BoundViewHolders c = new BoundViewHolders();
    public ViewHolderState d = new ViewHolderState();
    public final GridLayoutManager.SpanSizeLookup e;

    public BaseEpoxyAdapter() {
        AnonymousClass1 r1 = new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                try {
                    return BaseEpoxyAdapter.this.k(i).Q(BaseEpoxyAdapter.this.f2271a, i, BaseEpoxyAdapter.this.getItemCount());
                } catch (IndexOutOfBoundsException e) {
                    BaseEpoxyAdapter.this.s(e);
                    return 1;
                }
            }
        };
        this.e = r1;
        setHasStableIds(true);
        r1.setSpanIndexCacheEnabled(true);
    }

    /* renamed from: A */
    public void onViewAttachedToWindow(EpoxyViewHolder epoxyViewHolder) {
        epoxyViewHolder.d().K(epoxyViewHolder.e());
    }

    /* renamed from: B */
    public void onViewDetachedFromWindow(EpoxyViewHolder epoxyViewHolder) {
        epoxyViewHolder.d().L(epoxyViewHolder.e());
    }

    /* renamed from: C */
    public void onViewRecycled(EpoxyViewHolder epoxyViewHolder) {
        this.d.save(epoxyViewHolder);
        this.c.c(epoxyViewHolder);
        EpoxyModel d2 = epoxyViewHolder.d();
        epoxyViewHolder.g();
        x(epoxyViewHolder, d2);
    }

    public void D(int i) {
        this.f2271a = i;
    }

    public void E(View view) {
    }

    public void F(View view) {
    }

    public int getItemCount() {
        return j().size();
    }

    public long getItemId(int i) {
        return ((EpoxyModel) j().get(i)).D();
    }

    public int getItemViewType(int i) {
        return this.b.c(k(i));
    }

    public boolean h() {
        return false;
    }

    public BoundViewHolders i() {
        return this.c;
    }

    public abstract List j();

    public EpoxyModel k(int i) {
        return (EpoxyModel) j().get(i);
    }

    public int l() {
        return this.f2271a;
    }

    public GridLayoutManager.SpanSizeLookup m() {
        return this.e;
    }

    public boolean n() {
        return this.f2271a > 1;
    }

    public boolean o(int i) {
        return false;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.b.f2319a = null;
    }

    /* renamed from: p */
    public void onBindViewHolder(EpoxyViewHolder epoxyViewHolder, int i) {
        onBindViewHolder(epoxyViewHolder, i, Collections.emptyList());
    }

    /* renamed from: q */
    public void onBindViewHolder(EpoxyViewHolder epoxyViewHolder, int i, List list) {
        EpoxyModel k = k(i);
        EpoxyModel a2 = h() ? DiffPayload.a(list, getItemId(i)) : null;
        epoxyViewHolder.b(k, a2, list, i);
        if (list.isEmpty()) {
            this.d.restore(epoxyViewHolder);
        }
        this.c.b(epoxyViewHolder);
        if (h()) {
            v(epoxyViewHolder, k, i, a2);
        } else {
            w(epoxyViewHolder, k, i, list);
        }
    }

    /* renamed from: r */
    public EpoxyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        EpoxyModel a2 = this.b.a(this, i);
        return new EpoxyViewHolder(viewGroup, a2.w(viewGroup), a2.P());
    }

    public void s(RuntimeException runtimeException) {
    }

    /* renamed from: t */
    public boolean onFailedToRecycleView(EpoxyViewHolder epoxyViewHolder) {
        return epoxyViewHolder.d().I(epoxyViewHolder.e());
    }

    public void u(EpoxyViewHolder epoxyViewHolder, EpoxyModel epoxyModel, int i) {
    }

    public void v(EpoxyViewHolder epoxyViewHolder, EpoxyModel epoxyModel, int i, EpoxyModel epoxyModel2) {
        u(epoxyViewHolder, epoxyModel, i);
    }

    public void w(EpoxyViewHolder epoxyViewHolder, EpoxyModel epoxyModel, int i, List list) {
        u(epoxyViewHolder, epoxyModel, i);
    }

    public void x(EpoxyViewHolder epoxyViewHolder, EpoxyModel epoxyModel) {
    }

    public void y(Bundle bundle) {
        if (this.c.size() > 0) {
            throw new IllegalStateException("State cannot be restored once views have been bound. It should be done before adding the adapter to the recycler view.");
        } else if (bundle != null) {
            ViewHolderState viewHolderState = (ViewHolderState) bundle.getParcelable("saved_state_view_holders");
            this.d = viewHolderState;
            if (viewHolderState == null) {
                throw new IllegalStateException("Tried to restore instance state, but onSaveInstanceState was never called.");
            }
        }
    }

    public void z(Bundle bundle) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            this.d.save((EpoxyViewHolder) it.next());
        }
        if (this.d.size() <= 0 || hasStableIds()) {
            bundle.putParcelable("saved_state_view_holders", this.d);
            return;
        }
        throw new IllegalStateException("Must have stable ids when saving view holder state");
    }
}
