package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/chad/library/adapter/base/diff/BrvahAsyncDiffer$submitList$1$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public final class BrvahAsyncDiffer$submitList$1$result$1 extends DiffUtil.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BrvahAsyncDiffer$submitList$1 f2786a;

    public BrvahAsyncDiffer$submitList$1$result$1(BrvahAsyncDiffer$submitList$1 brvahAsyncDiffer$submitList$1) {
        this.f2786a = brvahAsyncDiffer$submitList$1;
    }

    public boolean areContentsTheSame(int i, int i2) {
        Object obj = this.f2786a.b.get(i);
        Object obj2 = this.f2786a.c.get(i2);
        if (obj != null && obj2 != null) {
            return this.f2786a.f2784a.f.a().areContentsTheSame(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    public boolean areItemsTheSame(int i, int i2) {
        Object obj = this.f2786a.b.get(i);
        Object obj2 = this.f2786a.c.get(i2);
        return (obj == null || obj2 == null) ? obj == null && obj2 == null : this.f2786a.f2784a.f.a().areItemsTheSame(obj, obj2);
    }

    public Object getChangePayload(int i, int i2) {
        Object obj = this.f2786a.b.get(i);
        Object obj2 = this.f2786a.c.get(i2);
        if (obj != null && obj2 != null) {
            return this.f2786a.f2784a.f.a().getChangePayload(obj, obj2);
        }
        throw new AssertionError();
    }

    public int getNewListSize() {
        return this.f2786a.c.size();
    }

    public int getOldListSize() {
        return this.f2786a.b.size();
    }
}
