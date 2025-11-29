package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1 extends Lambda implements Function2<AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C>, MemberSignature, C> {
    public static final AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1 INSTANCE = new AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1();

    public AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1() {
        super(2);
    }

    @Nullable
    public final C invoke(@NotNull AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C> annotationsContainerWithConstants, @NotNull MemberSignature memberSignature) {
        Intrinsics.checkNotNullParameter(annotationsContainerWithConstants, "$this$loadConstantFromProperty");
        Intrinsics.checkNotNullParameter(memberSignature, "it");
        return annotationsContainerWithConstants.getAnnotationParametersDefaultValues().get(memberSignature);
    }
}
