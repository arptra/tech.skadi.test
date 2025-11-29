package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlinx/serialization/KSerializer;", "", "it", "Lkotlin/reflect/KClass;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SerializersCacheKt$SERIALIZERS_CACHE$1 extends Lambda implements Function1<KClass<?>, KSerializer<? extends Object>> {
    public static final SerializersCacheKt$SERIALIZERS_CACHE$1 INSTANCE = new SerializersCacheKt$SERIALIZERS_CACHE$1();

    public SerializersCacheKt$SERIALIZERS_CACHE$1() {
        super(1);
    }

    @Nullable
    public final KSerializer<? extends Object> invoke(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "it");
        return SerializersKt.c(kClass);
    }
}
