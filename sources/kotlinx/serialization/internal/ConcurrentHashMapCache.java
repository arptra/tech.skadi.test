package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B'\u0012\u001e\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR,\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR*\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapCache;", "T", "Lkotlinx/serialization/internal/SerializerCache;", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "compute", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "key", "a", "(Lkotlin/reflect/KClass;)Lkotlinx/serialization/KSerializer;", "Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/CacheEntry;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n72#2,2:207\n1#3:209\n*S KotlinDebug\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapCache\n*L\n133#1:207,2\n133#1:209\n*E\n"})
final class ConcurrentHashMapCache<T> implements SerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f4025a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public ConcurrentHashMapCache(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "compute");
        this.f4025a = function1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r2 = new kotlinx.serialization.internal.CacheEntry((kotlinx.serialization.KSerializer) r3.f4025a.invoke(r4));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer a(kotlin.reflect.KClass r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.concurrent.ConcurrentHashMap r0 = r3.b
            java.lang.Class r1 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r4)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0026
            kotlinx.serialization.internal.CacheEntry r2 = new kotlinx.serialization.internal.CacheEntry
            kotlin.jvm.functions.Function1 r3 = r3.f4025a
            java.lang.Object r3 = r3.invoke(r4)
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
            r2.<init>(r3)
            java.lang.Object r3 = r0.putIfAbsent(r1, r2)
            if (r3 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            kotlinx.serialization.internal.CacheEntry r2 = (kotlinx.serialization.internal.CacheEntry) r2
            kotlinx.serialization.KSerializer r3 = r2.f4018a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ConcurrentHashMapCache.a(kotlin.reflect.KClass):kotlinx.serialization.KSerializer");
    }
}
