package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSerializersCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersCache.kt\nkotlinx/serialization/SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1\n+ 2 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n1#1,75:1\n79#2:76\n*S KotlinDebug\n*F\n+ 1 SerializersCache.kt\nkotlinx/serialization/SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1\n*L\n44#1:76\n*E\n"})
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlinx/serialization/KSerializer;", "", "clazz", "Lkotlin/reflect/KClass;", "types", "", "Lkotlin/reflect/KType;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 extends Lambda implements Function2<KClass<Object>, List<? extends KType>, KSerializer<Object>> {
    public static final SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 INSTANCE = new SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1();

    public SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1() {
        super(2);
    }

    @Nullable
    public final KSerializer<Object> invoke(@NotNull KClass<Object> kClass, @NotNull final List<? extends KType> list) {
        KSerializer<Object> t;
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(list, "types");
        List e = SerializersKt.e(SerializersModuleBuildersKt.a(), list, true);
        Intrinsics.checkNotNull(e);
        KSerializer a2 = SerializersKt.a(kClass, e, new Function0<KClassifier>() {
            @Nullable
            public final KClassifier invoke() {
                return list.get(0).getClassifier();
            }
        });
        if (a2 == null || (t = BuiltinSerializersKt.t(a2)) == null) {
            return null;
        }
        return t;
    }
}
