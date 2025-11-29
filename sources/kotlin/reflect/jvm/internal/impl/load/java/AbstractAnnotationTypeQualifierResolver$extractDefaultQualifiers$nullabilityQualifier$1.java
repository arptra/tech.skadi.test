package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1 extends Lambda implements Function1<TAnnotation, Boolean> {
    public static final AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1 INSTANCE = new AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1();

    public AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull TAnnotation tannotation) {
        Intrinsics.checkNotNullParameter(tannotation, "$this$extractNullability");
        return Boolean.FALSE;
    }
}
