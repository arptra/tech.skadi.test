package com.airbnb.epoxy;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/airbnb/epoxy/UnboundedViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "()V", "", "clear", "", "viewType", "max", "setMaxRecycledViews", "(II)V", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getRecycledView", "(I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "putRecycledView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "getRecycledViewCount", "(I)I", "Ljava/util/Queue;", "a", "(I)Ljava/util/Queue;", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "scrapHeaps", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public final class UnboundedViewPool extends RecyclerView.RecycledViewPool {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f2316a = new SparseArray();

    public final Queue a(int i) {
        Queue queue = (Queue) this.f2316a.get(i);
        if (queue != null) {
            return queue;
        }
        LinkedList linkedList = new LinkedList();
        this.f2316a.put(i, linkedList);
        return linkedList;
    }

    public void clear() {
        this.f2316a.clear();
    }

    public RecyclerView.ViewHolder getRecycledView(int i) {
        Queue queue = (Queue) this.f2316a.get(i);
        if (queue != null) {
            return (RecyclerView.ViewHolder) queue.poll();
        }
        return null;
    }

    public int getRecycledViewCount(int i) {
        Queue queue = (Queue) this.f2316a.get(i);
        if (queue != null) {
            return queue.size();
        }
        return 0;
    }

    public void putRecycledView(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        a(viewHolder.getItemViewType()).add(viewHolder);
    }

    public void setMaxRecycledViews(int i, int i2) {
        throw new UnsupportedOperationException("UnboundedViewPool does not support setting a maximum number of recycled views");
    }
}
