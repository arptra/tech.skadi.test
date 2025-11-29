package kotlin.reflect.jvm.internal.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1 implements KotlinJvmBinaryClass.AnnotationVisitor {
    final /* synthetic */ Ref.BooleanRef $result;

    public SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1(Ref.BooleanRef booleanRef) {
        this.$result = booleanRef;
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        if (!Intrinsics.areEqual((Object) classId, (Object) JvmAbi.INSTANCE.getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION())) {
            return null;
        }
        this.$result.element = true;
        return null;
    }

    public void visitEnd() {
    }
}
