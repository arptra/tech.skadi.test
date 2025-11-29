package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.honey.account.constant.AccountConstantKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaEnumValueAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaEnumValueAnnotationArgument {
    @NotNull
    private final Enum<?> value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaEnumValueAnnotationArgument(@Nullable Name name, @NotNull Enum<?> enumR) {
        super(name, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(enumR, AccountConstantKt.RESPONSE_VALUE);
        this.value = enumR;
    }

    @Nullable
    public Name getEntryName() {
        return Name.identifier(this.value.name());
    }

    @Nullable
    public ClassId getEnumClassId() {
        Class<?> cls = this.value.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        Intrinsics.checkNotNullExpressionValue(cls, "enumClass");
        return ReflectClassUtilKt.getClassId(cls);
    }
}
