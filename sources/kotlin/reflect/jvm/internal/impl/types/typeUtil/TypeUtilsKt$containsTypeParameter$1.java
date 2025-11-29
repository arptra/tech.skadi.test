package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

public final class TypeUtilsKt$containsTypeParameter$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    public static final TypeUtilsKt$containsTypeParameter$1 INSTANCE = new TypeUtilsKt$containsTypeParameter$1();

    public TypeUtilsKt$containsTypeParameter$1() {
        super(1);
    }

    public final Boolean invoke(UnwrappedType unwrappedType) {
        return Boolean.valueOf(TypeUtils.isTypeParameter(unwrappedType));
    }
}
