package com.airbnb.epoxy;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

public class DiffResult {

    /* renamed from: a  reason: collision with root package name */
    public final List f2281a;
    public final List b;
    public final DiffUtil.DiffResult c;

    public DiffResult(List list, List list2, DiffUtil.DiffResult diffResult) {
        this.f2281a = list;
        this.b = list2;
        this.c = diffResult;
    }

    public static DiffResult a(List list) {
        return new DiffResult(list, Collections.EMPTY_LIST, (DiffUtil.DiffResult) null);
    }

    public static DiffResult b(List list, List list2, DiffUtil.DiffResult diffResult) {
        return new DiffResult(list, list2, diffResult);
    }

    public static DiffResult e(List list) {
        return new DiffResult(Collections.EMPTY_LIST, list, (DiffUtil.DiffResult) null);
    }

    public static DiffResult f(List list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        return new DiffResult(list, list, (DiffUtil.DiffResult) null);
    }

    public void c(ListUpdateCallback listUpdateCallback) {
        DiffUtil.DiffResult diffResult = this.c;
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(listUpdateCallback);
        } else if (this.b.isEmpty() && !this.f2281a.isEmpty()) {
            listUpdateCallback.onRemoved(0, this.f2281a.size());
        } else if (!this.b.isEmpty() && this.f2281a.isEmpty()) {
            listUpdateCallback.onInserted(0, this.b.size());
        }
    }

    public void d(RecyclerView.Adapter adapter) {
        c(new AdapterListUpdateCallback(adapter));
    }
}
