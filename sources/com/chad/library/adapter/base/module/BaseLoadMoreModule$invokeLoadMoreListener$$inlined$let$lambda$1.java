package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/chad/library/adapter/base/module/BaseLoadMoreModule$invokeLoadMoreListener$1$1"}, k = 3, mv = {1, 1, 16})
public final class BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseLoadMoreModule f2797a;

    public BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1(BaseLoadMoreModule baseLoadMoreModule) {
        this.f2797a = baseLoadMoreModule;
    }

    public final void run() {
        OnLoadMoreListener b = this.f2797a.f2796a;
        if (b != null) {
            b.a();
        }
    }
}
