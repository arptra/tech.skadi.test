package com.rousetime.android_startup.dispatcher;

import com.rousetime.android_startup.StartupListener;
import com.rousetime.android_startup.utils.StartupCostTimesUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
public final class StartupManagerDispatcher$notifyChildren$2$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StartupListener f9822a;

    public StartupManagerDispatcher$notifyChildren$2$1(StartupListener startupListener) {
        this.f9822a = startupListener;
    }

    public final void run() {
        StartupListener startupListener = this.f9822a;
        StartupCostTimesUtils startupCostTimesUtils = StartupCostTimesUtils.d;
        long d = startupCostTimesUtils.d();
        Collection values = startupCostTimesUtils.c().values();
        Intrinsics.checkExpressionValueIsNotNull(values, "StartupCostTimesUtils.costTimesMap.values");
        startupListener.a(d, CollectionsKt.toList(values));
    }
}
