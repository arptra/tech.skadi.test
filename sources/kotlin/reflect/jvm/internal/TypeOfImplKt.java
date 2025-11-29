package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002¨\u0006\t"}, d2 = {"createMutableCollectionKType", "Lkotlin/reflect/KType;", "type", "createNothingType", "createPlatformKType", "lowerBound", "upperBound", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\ntypeOfImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeOfImpl.kt\nkotlin/reflect/jvm/internal/TypeOfImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class TypeOfImplKt {
    @NotNull
    public static final KType createMutableCollectionKType(@NotNull KType kType) {
        Intrinsics.checkNotNullParameter(kType, "type");
        KotlinType type = ((KTypeImpl) kType).getType();
        if (type instanceof SimpleType) {
            ClassifierDescriptor declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                TypeConstructor typeConstructor = readOnlyToMutable(classDescriptor).getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor, "classifier.readOnlyToMutable().typeConstructor");
                return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) type, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), (Function0) null, 2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + kType);
        }
        throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + kType).toString());
    }

    @NotNull
    public static final KType createNothingType(@NotNull KType kType) {
        Intrinsics.checkNotNullParameter(kType, "type");
        KotlinType type = ((KTypeImpl) kType).getType();
        if (type instanceof SimpleType) {
            TypeConstructor typeConstructor = TypeUtilsKt.getBuiltIns(type).getNothing().getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "kotlinType.builtIns.nothing.typeConstructor");
            return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) type, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), (Function0) null, 2, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + kType).toString());
    }

    @NotNull
    public static final KType createPlatformKType(@NotNull KType kType, @NotNull KType kType2) {
        Intrinsics.checkNotNullParameter(kType, "lowerBound");
        Intrinsics.checkNotNullParameter(kType2, "upperBound");
        KotlinType type = ((KTypeImpl) kType).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType type2 = ((KTypeImpl) kType2).getType();
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) type, (SimpleType) type2), (Function0) null, 2, (DefaultConstructorMarker) null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor classDescriptor) {
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(classDescriptor));
        if (readOnlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(readOnlyToMutable);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(fqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Not a readonly collection: " + classDescriptor);
    }
}
