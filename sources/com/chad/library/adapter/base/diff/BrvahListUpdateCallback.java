package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J)\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", "position", "count", "", "onInserted", "(II)V", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "(IILjava/lang/Object;)V", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "a", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "mAdapter", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class BrvahListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final BaseQuickAdapter f2789a;

    public void onChanged(int i, int i2, Object obj) {
        BaseQuickAdapter baseQuickAdapter = this.f2789a;
        baseQuickAdapter.notifyItemRangeChanged(i + baseQuickAdapter.M(), i2, obj);
    }

    public void onInserted(int i, int i2) {
        BaseQuickAdapter baseQuickAdapter = this.f2789a;
        baseQuickAdapter.notifyItemRangeInserted(i + baseQuickAdapter.M(), i2);
    }

    public void onMoved(int i, int i2) {
        BaseQuickAdapter baseQuickAdapter = this.f2789a;
        baseQuickAdapter.notifyItemMoved(i + baseQuickAdapter.M(), i2 + this.f2789a.M());
    }

    public void onRemoved(int i, int i2) {
        BaseLoadMoreModule R = this.f2789a.R();
        if (R != null && R.l() && this.f2789a.getItemCount() == 0) {
            BaseQuickAdapter baseQuickAdapter = this.f2789a;
            baseQuickAdapter.notifyItemRangeRemoved(i + baseQuickAdapter.M(), i2 + 1);
            return;
        }
        BaseQuickAdapter baseQuickAdapter2 = this.f2789a;
        baseQuickAdapter2.notifyItemRangeRemoved(i + baseQuickAdapter2.M(), i2);
    }
}
