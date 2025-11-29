package com.upuphone.xr.sapp.common;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0003R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/common/GlobalViewStoreOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "()V", "", "tag", "Landroidx/lifecycle/ViewModelStore;", "g", "(Ljava/lang/String;)Landroidx/lifecycle/ViewModelStore;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "d", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "", "i", "(Ljava/lang/String;)I", "f", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "viewStoreMap", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "viewStoreRefCount", "Lkotlin/Lazy;", "h", "()Landroidx/lifecycle/ViewModelStore;", "_viewModelStore", "getViewModelStore", "viewModelStore", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlobalViewStoreOwner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalViewStoreOwner.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreOwner\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,75:1\n72#2,2:76\n72#2,2:79\n72#2,2:82\n1#3:78\n1#3:81\n1#3:84\n32#4,2:85\n*S KotlinDebug\n*F\n+ 1 GlobalViewStoreOwner.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreOwner\n*L\n26#1:76,2\n49#1:79,2\n54#1:82,2\n26#1:78\n49#1:81\n54#1:84\n60#1:85,2\n*E\n"})
public final class GlobalViewStoreOwner implements ViewModelStoreOwner {

    /* renamed from: a  reason: collision with root package name */
    public static final GlobalViewStoreOwner f6658a = new GlobalViewStoreOwner();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final Lazy d = LazyKt.lazy(GlobalViewStoreOwner$_viewModelStore$2.INSTANCE);

    public final void d(LifecycleOwner lifecycleOwner, String str) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (lifecycleOwner.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
            i(str);
        }
        lifecycleOwner.getLifecycle().a(new GlobalViewStoreOwner$bindLifecycle$1(str));
    }

    public final void e() {
        ViewModelStore viewModelStore;
        for (Map.Entry entry : c.entrySet()) {
            if (((AtomicInteger) entry.getValue()).get() <= 0 && (viewModelStore = (ViewModelStore) b.get(entry.getKey())) != null) {
                viewModelStore.clear();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = new java.util.concurrent.atomic.AtomicInteger();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int f(java.lang.String r2) {
        /*
            r1 = this;
            java.util.concurrent.ConcurrentHashMap r1 = c
            java.lang.Object r0 = r1.get(r2)
            if (r0 != 0) goto L_0x0015
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r0.<init>()
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            if (r1 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            int r1 = r0.decrementAndGet()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.common.GlobalViewStoreOwner.f(java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = new androidx.lifecycle.ViewModelStore();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.ViewModelStore g(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r1 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.util.concurrent.ConcurrentHashMap r1 = b
            java.lang.Object r0 = r1.get(r2)
            if (r0 != 0) goto L_0x001a
            androidx.lifecycle.ViewModelStore r0 = new androidx.lifecycle.ViewModelStore
            r0.<init>()
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            if (r1 != 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            java.lang.String r1 = "getOrPut(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.lifecycle.ViewModelStore r0 = (androidx.lifecycle.ViewModelStore) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.common.GlobalViewStoreOwner.g(java.lang.String):androidx.lifecycle.ViewModelStore");
    }

    public ViewModelStore getViewModelStore() {
        return h();
    }

    public final ViewModelStore h() {
        return (ViewModelStore) d.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = new java.util.concurrent.atomic.AtomicInteger();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int i(java.lang.String r2) {
        /*
            r1 = this;
            java.util.concurrent.ConcurrentHashMap r1 = c
            java.lang.Object r0 = r1.get(r2)
            if (r0 != 0) goto L_0x0015
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r0.<init>()
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            if (r1 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            int r1 = r0.incrementAndGet()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.common.GlobalViewStoreOwner.i(java.lang.String):int");
    }
}
