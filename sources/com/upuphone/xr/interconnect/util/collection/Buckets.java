package com.upuphone.xr.interconnect.util.collection;

import com.honey.account.view.web.WebJs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\fJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0016H\u0016R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006j\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/interconnect/util/collection/Buckets;", "T", "R", "", "()V", "storage", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "forEach", "", "action", "Ljava/util/function/BiConsumer;", "", "get", "key", "(Ljava/lang/Object;)Ljava/util/Set;", "remove", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "set", "toString", "", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBuckets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buckets.kt\ncom/upuphone/xr/interconnect/util/collection/Buckets\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,43:1\n361#2,7:44\n215#3,2:51\n*S KotlinDebug\n*F\n+ 1 Buckets.kt\ncom/upuphone/xr/interconnect/util/collection/Buckets\n*L\n12#1:44,7\n33#1:51,2\n*E\n"})
public final class Buckets<T, R> {
    @NotNull
    private final HashMap<T, Set<R>> storage = new HashMap<>();

    public final void forEach(@NotNull BiConsumer<T, Set<R>> biConsumer) {
        Intrinsics.checkNotNullParameter(biConsumer, WebJs.ACTION);
        for (Map.Entry next : this.storage.entrySet()) {
            biConsumer.accept(next.getKey(), BucketsKt.toImmutable((Set) next.getValue()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.upuphone.xr.interconnect.util.collection.BucketsKt.access$toImmutable(r0);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<R> get(T r1) {
        /*
            r0 = this;
            java.util.HashMap<T, java.util.Set<R>> r0 = r0.storage
            java.lang.Object r0 = r0.get(r1)
            java.util.Set r0 = (java.util.Set) r0
            if (r0 == 0) goto L_0x0010
            java.util.Set r0 = com.upuphone.xr.interconnect.util.collection.BucketsKt.toImmutable(r0)
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.util.collection.Buckets.get(java.lang.Object):java.util.Set");
    }

    public final void remove(T t, R r) {
        Set set = this.storage.get(t);
        if (set != null) {
            set.remove(r);
            if (set.isEmpty()) {
                this.storage.remove(t);
            }
        }
    }

    public final void set(T t, R r) {
        HashMap<T, Set<R>> hashMap = this.storage;
        Set<R> set = hashMap.get(t);
        if (set == null) {
            set = new HashSet<>();
            hashMap.put(t, set);
        }
        set.add(r);
    }

    @NotNull
    public String toString() {
        String obj = this.storage.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "storage.toString()");
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.upuphone.xr.interconnect.util.collection.BucketsKt.access$toImmutable(r0);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<R> remove(T r1) {
        /*
            r0 = this;
            java.util.HashMap<T, java.util.Set<R>> r0 = r0.storage
            java.lang.Object r0 = r0.remove(r1)
            java.util.Set r0 = (java.util.Set) r0
            if (r0 == 0) goto L_0x0010
            java.util.Set r0 = com.upuphone.xr.interconnect.util.collection.BucketsKt.toImmutable(r0)
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.util.collection.Buckets.remove(java.lang.Object):java.util.Set");
    }
}
