package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererImpl$renderTypeConstructor$1 extends Lambda implements Function1<KotlinType, Object> {
    public static final DescriptorRendererImpl$renderTypeConstructor$1 INSTANCE = new DescriptorRendererImpl$renderTypeConstructor$1();

    public DescriptorRendererImpl$renderTypeConstructor$1() {
        super(1);
    }

    @NotNull
    public final Object invoke(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "it");
        return kotlinType instanceof StubTypeForBuilderInference ? ((StubTypeForBuilderInference) kotlinType).getOriginalTypeVariable() : kotlinType;
    }
}
