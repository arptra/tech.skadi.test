package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class CapturedTypeParameterDescriptor implements TypeParameterDescriptor {
    @NotNull
    private final DeclarationDescriptor declarationDescriptor;
    private final int declaredTypeParametersCount;
    @NotNull
    private final TypeParameterDescriptor originalDescriptor;

    public CapturedTypeParameterDescriptor(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2, int i) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "originalDescriptor");
        Intrinsics.checkNotNullParameter(declarationDescriptor2, "declarationDescriptor");
        this.originalDescriptor = typeParameterDescriptor;
        this.declarationDescriptor = declarationDescriptor2;
        this.declaredTypeParametersCount = i;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return this.originalDescriptor.accept(declarationDescriptorVisitor, d);
    }

    @NotNull
    public Annotations getAnnotations() {
        return this.originalDescriptor.getAnnotations();
    }

    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.declarationDescriptor;
    }

    @NotNull
    public SimpleType getDefaultType() {
        return this.originalDescriptor.getDefaultType();
    }

    public int getIndex() {
        return this.declaredTypeParametersCount + this.originalDescriptor.getIndex();
    }

    @NotNull
    public Name getName() {
        return this.originalDescriptor.getName();
    }

    @NotNull
    public SourceElement getSource() {
        return this.originalDescriptor.getSource();
    }

    @NotNull
    public StorageManager getStorageManager() {
        return this.originalDescriptor.getStorageManager();
    }

    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.originalDescriptor.getTypeConstructor();
    }

    @NotNull
    public List<KotlinType> getUpperBounds() {
        return this.originalDescriptor.getUpperBounds();
    }

    @NotNull
    public Variance getVariance() {
        return this.originalDescriptor.getVariance();
    }

    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    public boolean isReified() {
        return this.originalDescriptor.isReified();
    }

    @NotNull
    public String toString() {
        return this.originalDescriptor + "[inner-copy]";
    }

    @NotNull
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.originalDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }
}
