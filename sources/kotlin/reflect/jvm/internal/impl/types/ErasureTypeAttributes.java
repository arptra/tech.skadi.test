package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nErasureTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErasureTypeAttributes.kt\norg/jetbrains/kotlin/types/ErasureTypeAttributes\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
public class ErasureTypeAttributes {
    @Nullable
    private final SimpleType defaultType;
    @NotNull
    private final TypeUsage howThisTypeIsUsed;
    @Nullable
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public ErasureTypeAttributes(@NotNull TypeUsage typeUsage, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = typeUsage;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ErasureTypeAttributes)) {
            return false;
        }
        ErasureTypeAttributes erasureTypeAttributes = (ErasureTypeAttributes) obj;
        return Intrinsics.areEqual((Object) erasureTypeAttributes.getDefaultType(), (Object) getDefaultType()) && erasureTypeAttributes.getHowThisTypeIsUsed() == getHowThisTypeIsUsed();
    }

    @Nullable
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    @NotNull
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Nullable
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public int hashCode() {
        SimpleType defaultType2 = getDefaultType();
        int hashCode = defaultType2 != null ? defaultType2.hashCode() : 0;
        return hashCode + (hashCode * 31) + getHowThisTypeIsUsed().hashCode();
    }

    @NotNull
    public ErasureTypeAttributes withNewVisitedTypeParameter(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Set<T> set;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        TypeUsage howThisTypeIsUsed2 = getHowThisTypeIsUsed();
        Set<TypeParameterDescriptor> visitedTypeParameters2 = getVisitedTypeParameters();
        if (visitedTypeParameters2 == null || (set = SetsKt.plus(visitedTypeParameters2, typeParameterDescriptor)) == null) {
            set = SetsKt.setOf(typeParameterDescriptor);
        }
        return new ErasureTypeAttributes(howThisTypeIsUsed2, set, getDefaultType());
    }
}
