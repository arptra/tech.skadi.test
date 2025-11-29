package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B5\u0012,\u0010\t\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010R:\u0010\t\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R*\u0010\u0017\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "compute", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "key", "types", "Lkotlin/Result;", "a", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function2;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Caching.kt\nkotlinx/serialization/internal/ParametrizedCacheEntry\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,206:1\n72#2,2:207\n72#2,2:216\n1#3:209\n1#3:219\n199#4:210\n200#4:215\n201#4:218\n1549#5:211\n1620#5,3:212\n*S KotlinDebug\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache\n*L\n145#1:207,2\n146#1:216,2\n145#1:209\n146#1:219\n146#1:210\n146#1:215\n146#1:218\n146#1:211\n146#1:212,3\n*E\n"})
final class ConcurrentHashMapParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Function2 f4026a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public ConcurrentHashMapParametrizedCache(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "compute");
        this.f4026a = function2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
        r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.reflect.KClass r6, java.util.List r7) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "types"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.concurrent.ConcurrentHashMap r0 = r5.b
            java.lang.Class r1 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r6)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0023
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry
            r2.<init>()
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r2 = r0
        L_0x0023:
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = (kotlinx.serialization.internal.ParametrizedCacheEntry) r2
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r1)
            r0.<init>(r1)
            java.util.Iterator r1 = r7.iterator()
        L_0x0034:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0049
            java.lang.Object r3 = r1.next()
            kotlin.reflect.KType r3 = (kotlin.reflect.KType) r3
            kotlinx.serialization.internal.KTypeWrapper r4 = new kotlinx.serialization.internal.KTypeWrapper
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x0034
        L_0x0049:
            java.util.concurrent.ConcurrentHashMap r1 = r2.f4051a
            java.lang.Object r2 = r1.get(r0)
            if (r2 != 0) goto L_0x007a
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0062 }
            kotlin.jvm.functions.Function2 r5 = r5.f4026a     // Catch:{ all -> 0x0062 }
            java.lang.Object r5 = r5.invoke(r6, r7)     // Catch:{ all -> 0x0062 }
            kotlinx.serialization.KSerializer r5 = (kotlinx.serialization.KSerializer) r5     // Catch:{ all -> 0x0062 }
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)     // Catch:{ all -> 0x0062 }
            goto L_0x006d
        L_0x0062:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)
        L_0x006d:
            kotlin.Result r5 = kotlin.Result.m19boximpl(r5)
            java.lang.Object r6 = r1.putIfAbsent(r0, r5)
            if (r6 != 0) goto L_0x0079
            r2 = r5
            goto L_0x007a
        L_0x0079:
            r2 = r6
        L_0x007a:
            java.lang.String r5 = "getOrPut(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            kotlin.Result r2 = (kotlin.Result) r2
            java.lang.Object r5 = r2.m29unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ConcurrentHashMapParametrizedCache.a(kotlin.reflect.KClass, java.util.List):java.lang.Object");
    }
}
