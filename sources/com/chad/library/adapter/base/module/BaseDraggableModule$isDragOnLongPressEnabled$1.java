package com.chad.library.adapter.base.module;

import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 16})
final class BaseDraggableModule$isDragOnLongPressEnabled$1 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseDraggableModule f2794a;

    public final boolean onLongClick(View view) {
        if (!this.f2794a.h()) {
            return true;
        }
        ItemTouchHelper b = this.f2794a.b();
        Object tag = view.getTag(R.id.BaseQuickAdapter_viewholder_support);
        if (tag != null) {
            b.startDrag((RecyclerView.ViewHolder) tag);
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
    }
}
