package com.chad.library.adapter.base.module;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
final class BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseLoadMoreModule f2798a;
    public final /* synthetic */ RecyclerView.LayoutManager b;

    public final void run() {
        if (this.f2798a.n((LinearLayoutManager) this.b)) {
            this.f2798a.b = true;
        }
    }
}
