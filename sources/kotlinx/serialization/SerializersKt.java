package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"kotlinx/serialization/SerializersKt__SerializersJvmKt", "kotlinx/serialization/SerializersKt__SerializersKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class SerializersKt {
    public static final KSerializer a(KClass kClass, List list, Function0 function0) {
        return SerializersKt__SerializersKt.d(kClass, list, function0);
    }

    public static final KSerializer b(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.e(serializersModule, kType);
    }

    public static final KSerializer c(KClass kClass) {
        return SerializersKt__SerializersKt.g(kClass);
    }

    public static final KSerializer d(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.h(serializersModule, kType);
    }

    public static final List e(SerializersModule serializersModule, List list, boolean z) {
        return SerializersKt__SerializersKt.i(serializersModule, list, z);
    }
}
