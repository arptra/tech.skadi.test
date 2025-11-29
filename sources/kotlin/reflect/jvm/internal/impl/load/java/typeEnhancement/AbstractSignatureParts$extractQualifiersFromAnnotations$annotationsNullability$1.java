package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import org.jetbrains.annotations.NotNull;

public final class AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1 extends Lambda implements Function1<TAnnotation, Boolean> {
    final /* synthetic */ AbstractSignatureParts.TypeAndDefaultQualifiers $this_extractQualifiersFromAnnotations;
    final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1(AbstractSignatureParts<TAnnotation> abstractSignatureParts, AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        super(1);
        this.this$0 = abstractSignatureParts;
        this.$this_extractQualifiersFromAnnotations = typeAndDefaultQualifiers;
    }

    @NotNull
    public final Boolean invoke(@NotNull TAnnotation tannotation) {
        Intrinsics.checkNotNullParameter(tannotation, "$this$extractNullability");
        return Boolean.valueOf(this.this$0.forceWarning(tannotation, this.$this_extractQualifiersFromAnnotations.getType()));
    }
}
