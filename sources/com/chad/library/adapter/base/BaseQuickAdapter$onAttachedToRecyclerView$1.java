package com.chad.library.adapter.base;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.listener.GridSpanSizeLookup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/chad/library/adapter/base/BaseQuickAdapter$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public final class BaseQuickAdapter$onAttachedToRecyclerView$1 extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseQuickAdapter f2775a;
    public final /* synthetic */ RecyclerView.LayoutManager b;
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup c;

    public BaseQuickAdapter$onAttachedToRecyclerView$1(BaseQuickAdapter baseQuickAdapter, RecyclerView.LayoutManager layoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f2775a = baseQuickAdapter;
        this.b = layoutManager;
        this.c = spanSizeLookup;
    }

    public int getSpanSize(int i) {
        int itemViewType = this.f2775a.getItemViewType(i);
        if (itemViewType == 268435729 && this.f2775a.N()) {
            return 1;
        }
        if (itemViewType == 268436275 && this.f2775a.L()) {
            return 1;
        }
        if (this.f2775a.n == null) {
            return this.f2775a.a0(itemViewType) ? ((GridLayoutManager) this.b).getSpanCount() : this.c.getSpanSize(i);
        }
        if (this.f2775a.a0(itemViewType)) {
            return ((GridLayoutManager) this.b).getSpanCount();
        }
        GridSpanSizeLookup j = this.f2775a.n;
        if (j == null) {
            Intrinsics.throwNpe();
        }
        return j.a((GridLayoutManager) this.b, itemViewType, i - this.f2775a.M());
    }
}
