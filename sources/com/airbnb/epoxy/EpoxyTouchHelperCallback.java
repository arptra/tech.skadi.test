package com.airbnb.epoxy;

import android.graphics.Canvas;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH$¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH$¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0006H$¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ'\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u001dJ\u0017\u0010!\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\tH\u0004¢\u0006\u0004\b!\u0010\u001fJ7\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010(J7\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0#2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0004¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u0015J!\u0010-\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u0006H\u0014¢\u0006\u0004\b-\u0010\u0017JG\u00102\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u00103JG\u00104\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0004¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0014¢\u0006\u0004\b8\u00109JG\u0010>\u001a\u00020\u00132\u0006\u0010'\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\rH\u0016¢\u0006\u0004\b>\u0010?JG\u0010@\u001a\u00020\u00132\u0006\u0010'\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\rH\u0014¢\u0006\u0004\b@\u0010AJG\u0010B\u001a\u00020\u00132\u0006\u0010'\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\rH\u0016¢\u0006\u0004\bB\u0010?JI\u0010C\u001a\u00020\u00132\u0006\u0010'\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\rH\u0004¢\u0006\u0004\bC\u0010A¨\u0006D"}, d2 = {"Lcom/airbnb/epoxy/EpoxyTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "Lcom/airbnb/epoxy/EpoxyViewHolder;", "g", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/EpoxyViewHolder;)I", "target", "", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "k", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/EpoxyViewHolder;Lcom/airbnb/epoxy/EpoxyViewHolder;)Z", "direction", "", "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "n", "(Lcom/airbnb/epoxy/EpoxyViewHolder;I)V", "current", "canDropOver", "b", "", "getSwipeThreshold", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)F", "h", "(Lcom/airbnb/epoxy/EpoxyViewHolder;)F", "getMoveThreshold", "f", "selected", "", "dropTargets", "curX", "curY", "c", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;II)Lcom/airbnb/epoxy/EpoxyViewHolder;", "d", "(Lcom/airbnb/epoxy/EpoxyViewHolder;Ljava/util/List;II)Lcom/airbnb/epoxy/EpoxyViewHolder;", "actionState", "onSelectedChanged", "m", "fromPos", "toPos", "x", "y", "onMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;III)V", "l", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/EpoxyViewHolder;ILcom/airbnb/epoxy/EpoxyViewHolder;III)V", "clearView", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "e", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/EpoxyViewHolder;)V", "Landroid/graphics/Canvas;", "dX", "dY", "isCurrentlyActive", "onChildDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V", "i", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Lcom/airbnb/epoxy/EpoxyViewHolder;FFIZ)V", "onChildDrawOver", "j", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public abstract class EpoxyTouchHelperCallback extends ItemTouchHelper.Callback {
    public boolean b(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, EpoxyViewHolder epoxyViewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "current");
        Intrinsics.checkNotNullParameter(epoxyViewHolder2, "target");
        return super.canDropOver(recyclerView, epoxyViewHolder, epoxyViewHolder2);
    }

    /* renamed from: c */
    public EpoxyViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List list, int i, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "selected");
        Intrinsics.checkNotNullParameter(list, "dropTargets");
        return d((EpoxyViewHolder) viewHolder, list, i, i2);
    }

    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "current");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        return b(recyclerView, (EpoxyViewHolder) viewHolder, (EpoxyViewHolder) viewHolder2);
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        e(recyclerView, (EpoxyViewHolder) viewHolder);
    }

    public final EpoxyViewHolder d(EpoxyViewHolder epoxyViewHolder, List list, int i, int i2) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "selected");
        Intrinsics.checkNotNullParameter(list, "dropTargets");
        RecyclerView.ViewHolder chooseDropTarget = super.chooseDropTarget(epoxyViewHolder, list, i, i2);
        if (chooseDropTarget instanceof EpoxyViewHolder) {
            return (EpoxyViewHolder) chooseDropTarget;
        }
        return null;
    }

    public void e(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "viewHolder");
        super.clearView(recyclerView, epoxyViewHolder);
    }

    public final float f(EpoxyViewHolder epoxyViewHolder) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "viewHolder");
        return super.getMoveThreshold(epoxyViewHolder);
    }

    public abstract int g(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder);

    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return f((EpoxyViewHolder) viewHolder);
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return g(recyclerView, (EpoxyViewHolder) viewHolder);
    }

    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return h((EpoxyViewHolder) viewHolder);
    }

    public float h(EpoxyViewHolder epoxyViewHolder) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "viewHolder");
        return super.getSwipeThreshold(epoxyViewHolder);
    }

    public void i(Canvas canvas, RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, float f, float f2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "viewHolder");
        super.onChildDraw(canvas, recyclerView, epoxyViewHolder, f, f2, i, z);
    }

    public final void j(Canvas canvas, RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, float f, float f2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNull(epoxyViewHolder, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
        super.onChildDrawOver(canvas, recyclerView, epoxyViewHolder, f, f2, i, z);
    }

    public abstract boolean k(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, EpoxyViewHolder epoxyViewHolder2);

    public final void l(RecyclerView recyclerView, EpoxyViewHolder epoxyViewHolder, int i, EpoxyViewHolder epoxyViewHolder2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(epoxyViewHolder2, "target");
        super.onMoved(recyclerView, epoxyViewHolder, i, epoxyViewHolder2, i2, i3, i4);
    }

    public void m(EpoxyViewHolder epoxyViewHolder, int i) {
        super.onSelectedChanged(epoxyViewHolder, i);
    }

    public abstract void n(EpoxyViewHolder epoxyViewHolder, int i);

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        i(canvas, recyclerView, (EpoxyViewHolder) viewHolder, f, f2, i, z);
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        j(canvas, recyclerView, viewHolder instanceof EpoxyViewHolder ? (EpoxyViewHolder) viewHolder : null, f, f2, i, z);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        return k(recyclerView, (EpoxyViewHolder) viewHolder, (EpoxyViewHolder) viewHolder2);
    }

    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        l(recyclerView, (EpoxyViewHolder) viewHolder, i, (EpoxyViewHolder) viewHolder2, i2, i3, i4);
    }

    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        m((EpoxyViewHolder) viewHolder, i);
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        n((EpoxyViewHolder) viewHolder, i);
    }
}
