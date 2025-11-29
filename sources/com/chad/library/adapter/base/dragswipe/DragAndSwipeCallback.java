package com.chad.library.adapter.base.dragswipe;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.module.BaseDraggableModule;

public class DragAndSwipeCallback extends ItemTouchHelper.Callback {

    /* renamed from: a  reason: collision with root package name */
    public BaseDraggableModule f2790a;
    public float b = 0.1f;
    public float c = 0.7f;
    public int d = 15;
    public int e = 32;

    public DragAndSwipeCallback(BaseDraggableModule baseDraggableModule) {
        this.f2790a = baseDraggableModule;
    }

    public final boolean b(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 268435729 || itemViewType == 268436002 || itemViewType == 268436275 || itemViewType == 268436821;
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (!b(viewHolder)) {
            if (viewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support) != null && ((Boolean) viewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support)).booleanValue()) {
                BaseDraggableModule baseDraggableModule = this.f2790a;
                if (baseDraggableModule != null) {
                    baseDraggableModule.k(viewHolder);
                }
                viewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.FALSE);
            }
            if (viewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support) != null && ((Boolean) viewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support)).booleanValue()) {
                BaseDraggableModule baseDraggableModule2 = this.f2790a;
                if (baseDraggableModule2 != null) {
                    baseDraggableModule2.n(viewHolder);
                }
                viewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.FALSE);
            }
        }
    }

    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.b;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return b(viewHolder) ? ItemTouchHelper.Callback.makeMovementFlags(0, 0) : ItemTouchHelper.Callback.makeMovementFlags(this.d, this.e);
    }

    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.c;
    }

    public boolean isItemViewSwipeEnabled() {
        BaseDraggableModule baseDraggableModule = this.f2790a;
        if (baseDraggableModule != null) {
            return baseDraggableModule.j();
        }
        return false;
    }

    public boolean isLongPressDragEnabled() {
        BaseDraggableModule baseDraggableModule = this.f2790a;
        return baseDraggableModule != null && baseDraggableModule.h() && !this.f2790a.d();
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, z);
        if (i == 1 && !b(viewHolder)) {
            View view = viewHolder.itemView;
            canvas.save();
            if (f > 0.0f) {
                canvas.clipRect((float) view.getLeft(), (float) view.getTop(), ((float) view.getLeft()) + f, (float) view.getBottom());
                canvas.translate((float) view.getLeft(), (float) view.getTop());
            } else {
                canvas.clipRect(((float) view.getRight()) + f, (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
                canvas.translate(((float) view.getRight()) + f, (float) view.getTop());
            }
            BaseDraggableModule baseDraggableModule = this.f2790a;
            if (baseDraggableModule != null) {
                baseDraggableModule.q(canvas, viewHolder, f, f2, z);
            }
            canvas.restore();
        }
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return viewHolder.getItemViewType() == viewHolder2.getItemViewType();
    }

    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
        super.onMoved(recyclerView, viewHolder, i, viewHolder2, i2, i3, i4);
        BaseDraggableModule baseDraggableModule = this.f2790a;
        if (baseDraggableModule != null) {
            baseDraggableModule.l(viewHolder, viewHolder2);
        }
    }

    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i == 2 && !b(viewHolder)) {
            BaseDraggableModule baseDraggableModule = this.f2790a;
            if (baseDraggableModule != null) {
                baseDraggableModule.m(viewHolder);
            }
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.TRUE);
        } else if (i == 1 && !b(viewHolder)) {
            BaseDraggableModule baseDraggableModule2 = this.f2790a;
            if (baseDraggableModule2 != null) {
                baseDraggableModule2.o(viewHolder);
            }
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        }
        super.onSelectedChanged(viewHolder, i);
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        BaseDraggableModule baseDraggableModule;
        if (!b(viewHolder) && (baseDraggableModule = this.f2790a) != null) {
            baseDraggableModule.p(viewHolder);
        }
    }
}
