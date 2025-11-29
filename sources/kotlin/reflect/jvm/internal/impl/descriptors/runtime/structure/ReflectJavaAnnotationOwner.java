package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {
    @Nullable
    ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName);

    @NotNull
    List<ReflectJavaAnnotation> getAnnotations();

    @Nullable
    AnnotatedElement getElement();
}
