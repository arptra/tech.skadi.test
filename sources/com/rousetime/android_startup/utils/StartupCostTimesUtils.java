package com.rousetime.android_startup.utils;

import com.rousetime.android_startup.extensions.StartupExtensionsKt;
import com.rousetime.android_startup.manager.StartupCacheManager;
import com.rousetime.android_startup.model.CostTimesModel;
import com.rousetime.android_startup.model.StartupConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000b\u001a\u00020\n2*\u0010\t\u001a&\u0012\"\u0012 \u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00050\u0004¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\n2\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0004¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010'\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b&\u0010\u001c¨\u0006("}, d2 = {"Lcom/rousetime/android_startup/utils/StartupCostTimesUtils;", "", "<init>", "()V", "Lkotlin/Function0;", "Lkotlin/Triple;", "Ljava/lang/Class;", "Lcom/rousetime/android_startup/Startup;", "", "block", "", "g", "(Lkotlin/jvm/functions/Function0;)V", "f", "b", "e", "a", "()Z", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/rousetime/android_startup/model/CostTimesModel;", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "()Ljava/util/concurrent/ConcurrentHashMap;", "costTimesMap", "", "J", "getStartTime", "()J", "i", "(J)V", "startTime", "Ljava/lang/Long;", "getEndTime", "()Ljava/lang/Long;", "h", "(Ljava/lang/Long;)V", "endTime", "d", "mainThreadTimes", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupCostTimesUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap f9836a = new ConcurrentHashMap();
    public static long b;
    public static Long c;
    public static final StartupCostTimesUtils d = new StartupCostTimesUtils();

    public final boolean a() {
        StartupConfig b2 = StartupCacheManager.d.a().b();
        return Intrinsics.areEqual((Object) b2 != null ? b2.d() : null, (Object) Boolean.TRUE);
    }

    public final void b() {
        if (a()) {
            c = null;
            f9836a.clear();
        }
    }

    public final ConcurrentHashMap c() {
        return f9836a;
    }

    public final long d() {
        Long l = c;
        return (l != null ? l.longValue() : System.nanoTime()) - b;
    }

    public final void e() {
        StartupLogUtils.b.b(StartupCostTimesUtils$printAll$1.INSTANCE);
    }

    public final void f(Function0 function0) {
        CostTimesModel costTimesModel;
        if (a() && (costTimesModel = (CostTimesModel) f9836a.get(StartupExtensionsKt.a((Class) function0.invoke()))) != null) {
            costTimesModel.f(System.nanoTime() / 1000000);
        }
    }

    public final void g(Function0 function0) {
        if (a()) {
            Triple triple = (Triple) function0.invoke();
            ConcurrentHashMap concurrentHashMap = f9836a;
            String a2 = StartupExtensionsKt.a((Class) triple.getFirst());
            String simpleName = ((Class) triple.getFirst()).getSimpleName();
            Intrinsics.checkExpressionValueIsNotNull(simpleName, "first.simpleName");
            concurrentHashMap.put(a2, new CostTimesModel(simpleName, ((Boolean) triple.getSecond()).booleanValue(), ((Boolean) triple.getThird()).booleanValue(), System.nanoTime() / 1000000, 0, 16, (DefaultConstructorMarker) null));
        }
    }

    public final void h(Long l) {
        c = l;
    }

    public final void i(long j) {
        b = j;
    }
}
