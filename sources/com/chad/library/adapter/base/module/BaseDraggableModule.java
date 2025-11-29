package com.chad.library.adapter.base.module;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.dragswipe.DragAndSwipeCallback;
import com.chad.library.adapter.base.listener.DraggableListenerImp;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000  2\u00020\u0001:\u0001kB\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010\u001dJ\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010\u001dJ\u0017\u0010$\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b$\u0010\u001dJ\u0017\u0010%\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b%\u0010\u001dJ;\u0010,\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u000bH\u0016¢\u0006\u0004\b,\u0010-R\"\u00102\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010.\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u00101R\"\u00106\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u00101R\"\u0010<\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010B\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010>\u001a\u0004\b3\u0010?\"\u0004\b@\u0010AR\"\u0010I\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010P\u001a\u0004\u0018\u00010J8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010W\u001a\u0004\u0018\u00010Q8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010^\u001a\u0004\u0018\u00010X8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b/\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010f\u001a\u0004\u0018\u00010_8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR*\u0010i\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000b8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b`\u0010\u0017\"\u0004\bh\u00101R\u001c\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010j¨\u0006l"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "Lcom/chad/library/adapter/base/listener/DraggableListenerImp;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "baseQuickAdapter", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "", "f", "()V", "", "position", "", "e", "(I)Z", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "g", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "a", "(Landroidx/recyclerview/widget/RecyclerView;)V", "d", "()Z", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "c", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "m", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "source", "target", "l", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "k", "o", "n", "p", "Landroid/graphics/Canvas;", "canvas", "", "dX", "dY", "isCurrentlyActive", "q", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFZ)V", "Z", "h", "setDragEnabled", "(Z)V", "isDragEnabled", "b", "j", "setSwipeEnabled", "isSwipeEnabled", "I", "getToggleViewId", "()I", "setToggleViewId", "(I)V", "toggleViewId", "Landroidx/recyclerview/widget/ItemTouchHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "setItemTouchHelper", "(Landroidx/recyclerview/widget/ItemTouchHelper;)V", "itemTouchHelper", "Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;", "Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;", "getItemTouchHelperCallback", "()Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;", "setItemTouchHelperCallback", "(Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;)V", "itemTouchHelperCallback", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnTouchListener;", "getMOnToggleViewTouchListener", "()Landroid/view/View$OnTouchListener;", "setMOnToggleViewTouchListener", "(Landroid/view/View$OnTouchListener;)V", "mOnToggleViewTouchListener", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnLongClickListener;", "getMOnToggleViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setMOnToggleViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mOnToggleViewLongClickListener", "Lcom/chad/library/adapter/base/listener/OnItemDragListener;", "Lcom/chad/library/adapter/base/listener/OnItemDragListener;", "getMOnItemDragListener", "()Lcom/chad/library/adapter/base/listener/OnItemDragListener;", "setMOnItemDragListener", "(Lcom/chad/library/adapter/base/listener/OnItemDragListener;)V", "mOnItemDragListener", "Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;", "i", "Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;", "getMOnItemSwipeListener", "()Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;", "setMOnItemSwipeListener", "(Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;)V", "mOnItemSwipeListener", "value", "setDragOnLongPressEnabled", "isDragOnLongPressEnabled", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public class BaseDraggableModule implements DraggableListenerImp {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f2793a;
    public boolean b;
    public int c;
    public ItemTouchHelper d;
    public DragAndSwipeCallback e;
    public View.OnTouchListener f;
    public View.OnLongClickListener g;
    public OnItemDragListener h;
    public OnItemSwipeListener i;
    public boolean j = true;
    public final BaseQuickAdapter k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseDraggableModule$Companion;", "", "()V", "NO_TOGGLE_VIEW", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseDraggableModule(BaseQuickAdapter baseQuickAdapter) {
        this.k = baseQuickAdapter;
        f();
    }

    public final void a(RecyclerView recyclerView) {
        ItemTouchHelper itemTouchHelper = this.d;
        if (itemTouchHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public final ItemTouchHelper b() {
        ItemTouchHelper itemTouchHelper = this.d;
        if (itemTouchHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        return itemTouchHelper;
    }

    public final int c(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition() - this.k.M();
    }

    public boolean d() {
        return this.c != 0;
    }

    public final boolean e(int i2) {
        return i2 >= 0 && i2 < this.k.getData().size();
    }

    public final void f() {
        DragAndSwipeCallback dragAndSwipeCallback = new DragAndSwipeCallback(this);
        this.e = dragAndSwipeCallback;
        this.d = new ItemTouchHelper(dragAndSwipeCallback);
    }

    public final void g(BaseViewHolder baseViewHolder) {
        View findViewById;
        if (this.f2793a && d() && (findViewById = baseViewHolder.itemView.findViewById(this.c)) != null) {
            findViewById.setTag(R.id.BaseQuickAdapter_viewholder_support, baseViewHolder);
            if (i()) {
                findViewById.setOnLongClickListener(this.g);
            } else {
                findViewById.setOnTouchListener(this.f);
            }
        }
    }

    public final boolean h() {
        return this.f2793a;
    }

    public boolean i() {
        return this.j;
    }

    public final boolean j() {
        return this.b;
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        OnItemDragListener onItemDragListener = this.h;
        if (onItemDragListener != null) {
            onItemDragListener.a(viewHolder, c(viewHolder));
        }
    }

    public void l(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        int c2 = c(viewHolder);
        int c3 = c(viewHolder2);
        if (e(c2) && e(c3)) {
            if (c2 < c3) {
                int i2 = c2;
                while (i2 < c3) {
                    int i3 = i2 + 1;
                    Collections.swap(this.k.getData(), i2, i3);
                    i2 = i3;
                }
            } else {
                int i4 = c3 + 1;
                if (c2 >= i4) {
                    int i5 = c2;
                    while (true) {
                        Collections.swap(this.k.getData(), i5, i5 - 1);
                        if (i5 == i4) {
                            break;
                        }
                        i5--;
                    }
                }
            }
            this.k.notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.h;
        if (onItemDragListener != null) {
            onItemDragListener.b(viewHolder, c2, viewHolder2, c3);
        }
    }

    public void m(RecyclerView.ViewHolder viewHolder) {
        OnItemDragListener onItemDragListener = this.h;
        if (onItemDragListener != null) {
            onItemDragListener.c(viewHolder, c(viewHolder));
        }
    }

    public void n(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        if (this.b && (onItemSwipeListener = this.i) != null) {
            onItemSwipeListener.b(viewHolder, c(viewHolder));
        }
    }

    public void o(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        if (this.b && (onItemSwipeListener = this.i) != null) {
            onItemSwipeListener.d(viewHolder, c(viewHolder));
        }
    }

    public void p(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        int c2 = c(viewHolder);
        if (e(c2)) {
            this.k.getData().remove(c2);
            this.k.notifyItemRemoved(viewHolder.getAdapterPosition());
            if (this.b && (onItemSwipeListener = this.i) != null) {
                onItemSwipeListener.a(viewHolder, c2);
            }
        }
    }

    public void q(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f2, float f3, boolean z) {
        OnItemSwipeListener onItemSwipeListener;
        if (this.b && (onItemSwipeListener = this.i) != null) {
            onItemSwipeListener.c(canvas, viewHolder, f2, f3, z);
        }
    }
}
