package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.honey.account.constant.AccountConstantKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaLiteralAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaLiteralAnnotationArgument {
    @NotNull
    private final Object value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaLiteralAnnotationArgument(@Nullable Name name, @NotNull Object obj) {
        super(name, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, AccountConstantKt.RESPONSE_VALUE);
        this.value = obj;
    }

    @NotNull
    public Object getValue() {
        return this.value;
    }
}
