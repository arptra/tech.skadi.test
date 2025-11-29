package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class NullableSimpleType extends DelegatingSimpleTypeImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NullableSimpleType(@NotNull SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
    }

    public boolean isMarkedNullable() {
        return true;
    }

    @NotNull
    public NullableSimpleType replaceDelegate(@NotNull SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new NullableSimpleType(simpleType);
    }
}
