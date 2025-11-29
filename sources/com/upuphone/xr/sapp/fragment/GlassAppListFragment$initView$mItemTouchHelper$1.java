package com.upuphone.xr.sapp.fragment;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.xr.sapp.databinding.FragmentGlassAppListBinding;
import com.upuphone.xr.sapp.fragment.GlassAppListFragment;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/fragment/GlassAppListFragment$initView$mItemTouchHelper$1", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isLongPressDragEnabled", "", "onMove", "target", "onSelectedChanged", "", "actionState", "onSwiped", "direction", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassAppListFragment$initView$mItemTouchHelper$1 extends ItemTouchHelper.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassAppListFragment f6959a;

    public GlassAppListFragment$initView$mItemTouchHelper$1(GlassAppListFragment glassAppListFragment) {
        this.f6959a = glassAppListFragment;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
            return false;
        }
        Collections.swap(this.f6959a.l, adapterPosition, adapterPosition2);
        GlassAppListFragment.MyAdapter F0 = this.f6959a.n;
        Intrinsics.checkNotNull(F0);
        F0.notifyItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        FragmentGlassAppListBinding E0 = this.f6959a.j;
        if (E0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E0 = null;
        }
        E0.d.setOverScrollEnable(i == 0);
        GlassAppListFragment glassAppListFragment = this.f6959a;
        if (!glassAppListFragment.J0(glassAppListFragment.l, this.f6959a.m)) {
            this.f6959a.m.clear();
            this.f6959a.m.addAll(this.f6959a.l);
            this.f6959a.N0();
        }
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }
}
