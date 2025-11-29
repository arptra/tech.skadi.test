package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import org.jetbrains.annotations.NotNull;

public final class JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1 extends Lambda implements Function0<KotlinType> {
    final /* synthetic */ JavaTypeAttributes $attr;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ JavaClassifierType $javaType;
    final /* synthetic */ TypeParameterDescriptor $parameter;
    final /* synthetic */ JavaTypeResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(JavaTypeResolver javaTypeResolver, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor, JavaClassifierType javaClassifierType) {
        super(0);
        this.this$0 = javaTypeResolver;
        this.$parameter = typeParameterDescriptor;
        this.$attr = javaTypeAttributes;
        this.$constructor = typeConstructor;
        this.$javaType = javaClassifierType;
    }

    @NotNull
    public final KotlinType invoke() {
        TypeParameterUpperBoundEraser access$getTypeParameterUpperBoundEraser$p = this.this$0.typeParameterUpperBoundEraser;
        TypeParameterDescriptor typeParameterDescriptor = this.$parameter;
        JavaTypeAttributes javaTypeAttributes = this.$attr;
        ClassifierDescriptor declarationDescriptor = this.$constructor.getDeclarationDescriptor();
        return access$getTypeParameterUpperBoundEraser$p.getErasedUpperBound(typeParameterDescriptor, javaTypeAttributes.withDefaultType(declarationDescriptor != null ? declarationDescriptor.getDefaultType() : null).markIsRaw(this.$javaType.isRaw()));
    }
}
