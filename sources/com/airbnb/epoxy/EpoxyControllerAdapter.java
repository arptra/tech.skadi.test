package com.airbnb.epoxy;

import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.AsyncEpoxyDiffer;
import java.util.ArrayList;
import java.util.List;

public final class EpoxyControllerAdapter extends BaseEpoxyAdapter implements AsyncEpoxyDiffer.ResultCallback {
    public static final DiffUtil.ItemCallback k = new DiffUtil.ItemCallback<EpoxyModel<?>>() {
        /* renamed from: a */
        public boolean areContentsTheSame(EpoxyModel epoxyModel, EpoxyModel epoxyModel2) {
            return epoxyModel.equals(epoxyModel2);
        }

        /* renamed from: b */
        public boolean areItemsTheSame(EpoxyModel epoxyModel, EpoxyModel epoxyModel2) {
            return epoxyModel.D() == epoxyModel2.D();
        }

        /* renamed from: c */
        public Object getChangePayload(EpoxyModel epoxyModel, EpoxyModel epoxyModel2) {
            return new DiffPayload(epoxyModel);
        }
    };
    public final NotifyBlocker f;
    public final AsyncEpoxyDiffer g;
    public final EpoxyController h;
    public int i;
    public final List j = new ArrayList();

    public EpoxyControllerAdapter(EpoxyController epoxyController, Handler handler) {
        NotifyBlocker notifyBlocker = new NotifyBlocker();
        this.f = notifyBlocker;
        this.h = epoxyController;
        this.g = new AsyncEpoxyDiffer(handler, this, k);
        registerAdapterDataObserver(notifyBlocker);
    }

    /* renamed from: A */
    public void onViewAttachedToWindow(EpoxyViewHolder epoxyViewHolder) {
        super.onViewAttachedToWindow(epoxyViewHolder);
        this.h.onViewAttachedToWindow(epoxyViewHolder, epoxyViewHolder.d());
    }

    /* renamed from: B */
    public void onViewDetachedFromWindow(EpoxyViewHolder epoxyViewHolder) {
        super.onViewDetachedFromWindow(epoxyViewHolder);
        this.h.onViewDetachedFromWindow(epoxyViewHolder, epoxyViewHolder.d());
    }

    public void E(View view) {
        this.h.setupStickyHeaderView(view);
    }

    public void F(View view) {
        this.h.teardownStickyHeaderView(view);
    }

    public void G(OnModelBuildFinishedListener onModelBuildFinishedListener) {
        this.j.add(onModelBuildFinishedListener);
    }

    public List H() {
        return j();
    }

    public int I(EpoxyModel epoxyModel) {
        int size = j().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((EpoxyModel) j().get(i2)).D() == epoxyModel.D()) {
                return i2;
            }
        }
        return -1;
    }

    public boolean J() {
        return this.g.g();
    }

    public void K(int i2, int i3) {
        ArrayList arrayList = new ArrayList(j());
        arrayList.add(i3, (EpoxyModel) arrayList.remove(i2));
        this.f.a();
        notifyItemMoved(i2, i3);
        this.f.b();
        if (this.g.e(arrayList)) {
            this.h.requestModelBuild();
        }
    }

    public void L(int i2) {
        ArrayList arrayList = new ArrayList(j());
        this.f.a();
        notifyItemChanged(i2);
        this.f.b();
        if (this.g.e(arrayList)) {
            this.h.requestModelBuild();
        }
    }

    public void M(OnModelBuildFinishedListener onModelBuildFinishedListener) {
        this.j.remove(onModelBuildFinishedListener);
    }

    public void N(ControllerModelList controllerModelList) {
        List j2 = j();
        if (!j2.isEmpty()) {
            if (((EpoxyModel) j2.get(0)).G()) {
                for (int i2 = 0; i2 < j2.size(); i2++) {
                    ((EpoxyModel) j2.get(i2)).S("The model was changed between being bound and when models were rebuilt", i2);
                }
            }
        }
        this.g.i(controllerModelList);
    }

    public void c(DiffResult diffResult) {
        this.i = diffResult.b.size();
        this.f.a();
        diffResult.d(this);
        this.f.b();
        for (int size = this.j.size() - 1; size >= 0; size--) {
            ((OnModelBuildFinishedListener) this.j.get(size)).a(diffResult);
        }
    }

    public int getItemCount() {
        return this.i;
    }

    public boolean h() {
        return true;
    }

    public BoundViewHolders i() {
        return super.i();
    }

    public List j() {
        return this.g.f();
    }

    public boolean o(int i2) {
        return this.h.isStickyHeader(i2);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.h.onAttachedToRecyclerViewInternal(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.h.onDetachedFromRecyclerViewInternal(recyclerView);
    }

    public void s(RuntimeException runtimeException) {
        this.h.onExceptionSwallowed(runtimeException);
    }

    public void v(EpoxyViewHolder epoxyViewHolder, EpoxyModel epoxyModel, int i2, EpoxyModel epoxyModel2) {
        this.h.onModelBound(epoxyViewHolder, epoxyModel, i2, epoxyModel2);
    }

    public void x(EpoxyViewHolder epoxyViewHolder, EpoxyModel epoxyModel) {
        this.h.onModelUnbound(epoxyViewHolder, epoxyModel);
    }
}
