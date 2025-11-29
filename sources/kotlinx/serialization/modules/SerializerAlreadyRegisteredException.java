package kotlinx.serialization.modules;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\b\u0010\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "baseClass", "Lkotlin/reflect/KClass;", "concreteClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "msg", "", "(Ljava/lang/String;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SerializerAlreadyRegisteredException extends IllegalArgumentException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerializerAlreadyRegisteredException(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SerializerAlreadyRegisteredException(@NotNull KClass<?> kClass, @NotNull KClass<?> kClass2) {
        this("Serializer for " + kClass2 + " already registered in the scope of " + kClass);
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "concreteClass");
    }
}
