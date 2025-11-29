package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    @NotNull
    private final Collection<JavaAnnotation> annotations;
    @NotNull
    private final ReflectJavaType componentType;
    private final boolean isDeprecatedInJavaDoc;
    @NotNull
    private final Type reflectType;

    public ReflectJavaArrayType(@NotNull Type type) {
        ReflectJavaType reflectJavaType;
        Intrinsics.checkNotNullParameter(type, "reflectType");
        this.reflectType = type;
        Type reflectType2 = getReflectType();
        if (reflectType2 instanceof GenericArrayType) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Type genericComponentType = ((GenericArrayType) reflectType2).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
            reflectJavaType = factory.create(genericComponentType);
        } else {
            if (reflectType2 instanceof Class) {
                Class cls = (Class) reflectType2;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Class<?> componentType2 = cls.getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType2, "getComponentType()");
                    reflectJavaType = factory2.create(componentType2);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
        }
        this.componentType = reflectJavaType;
        this.annotations = CollectionsKt.emptyList();
    }

    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public Type getReflectType() {
        return this.reflectType;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    @NotNull
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }
}
