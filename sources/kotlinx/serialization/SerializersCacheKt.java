package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.SerializerCache;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a/\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aC\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00050\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\r\"\"\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011\"\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\f\u0010\u000f\u0012\u0004\b\u0013\u0010\u0011\"\"\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00158\u0002X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0011\"\"\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00158\u0002X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u0012\u0004\b\u001b\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/KClass;", "", "clazz", "", "isNullable", "Lkotlinx/serialization/KSerializer;", "a", "(Lkotlin/reflect/KClass;Z)Lkotlinx/serialization/KSerializer;", "", "Lkotlin/reflect/KType;", "types", "Lkotlin/Result;", "b", "(Lkotlin/reflect/KClass;Ljava/util/List;Z)Ljava/lang/Object;", "Lkotlinx/serialization/internal/SerializerCache;", "Lkotlinx/serialization/internal/SerializerCache;", "getSERIALIZERS_CACHE$annotations", "()V", "SERIALIZERS_CACHE", "getSERIALIZERS_CACHE_NULLABLE$annotations", "SERIALIZERS_CACHE_NULLABLE", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "c", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "getPARAMETRIZED_SERIALIZERS_CACHE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE", "d", "getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSerializersCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersCache.kt\nkotlinx/serialization/SerializersCacheKt\n+ 2 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n1#1,75:1\n79#2:76\n*S KotlinDebug\n*F\n+ 1 SerializersCache.kt\nkotlinx/serialization/SerializersCacheKt\n*L\n53#1:76\n*E\n"})
public final class SerializersCacheKt {

    /* renamed from: a  reason: collision with root package name */
    public static final SerializerCache f3986a = CachingKt.a(SerializersCacheKt$SERIALIZERS_CACHE$1.INSTANCE);
    public static final SerializerCache b = CachingKt.a(SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1.INSTANCE);
    public static final ParametrizedSerializerCache c = CachingKt.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.INSTANCE);
    public static final ParametrizedSerializerCache d = CachingKt.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.INSTANCE);

    public static final KSerializer a(KClass kClass, boolean z) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        if (z) {
            return b.a(kClass);
        }
        KSerializer a2 = f3986a.a(kClass);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    public static final Object b(KClass kClass, List list, boolean z) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(list, "types");
        return !z ? c.a(kClass, list) : d.a(kClass, list);
    }
}
