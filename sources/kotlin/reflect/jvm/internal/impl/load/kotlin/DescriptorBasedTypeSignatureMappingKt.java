package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\ndescriptorBasedTypeSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 descriptorBasedTypeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/DescriptorBasedTypeSignatureMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,198:1\n1#2:199\n*E\n"})
public final class DescriptorBasedTypeSignatureMappingKt {
    @NotNull
    public static final String computeInternalName(@NotNull ClassDescriptor classDescriptor, @NotNull TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkNotNullParameter(classDescriptor, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = SpecialNames.safeIdentifier(classDescriptor.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String asString = fqName.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
            sb.append(StringsKt.replace$default(asString, '.', '/', false, 4, (Object) null));
            sb.append('/');
            sb.append(identifier);
            return sb.toString();
        }
        ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor2 != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = computeInternalName(classDescriptor2, typeMappingConfiguration);
            }
            return predefinedInternalNameForClass + '$' + identifier;
        }
        throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final boolean hasVoidReturnType(@NotNull CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = callableDescriptor.getReturnType();
            Intrinsics.checkNotNull(returnType2);
            return !TypeUtils.isNullableType(returnType2) && !(callableDescriptor instanceof PropertyGetterDescriptor);
        }
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T mapType(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.KotlinType r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> r9, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T> r11, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter<T> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? super T, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.Unit> r13) {
        /*
            java.lang.String r0 = "kotlinType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "typeMappingConfiguration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "writeGenericType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r11.preprocessType(r8)
            if (r1 == 0) goto L_0x0029
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object r8 = mapType(r1, r2, r3, r4, r5, r6)
            return r8
        L_0x0029:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r8)
            if (r0 == 0) goto L_0x003d
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(r8)
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object r8 = mapType(r1, r2, r3, r4, r5, r6)
            return r8
        L_0x003d:
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r0 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            java.lang.Object r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.mapBuiltInType(r0, r8, r9, r10)
            if (r1 == 0) goto L_0x0051
            boolean r11 = r10.getNeedPrimitiveBoxing()
            java.lang.Object r9 = kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.boxTypeIfNeeded(r9, r1, r11)
            r13.invoke(r8, r9, r10)
            return r9
        L_0x0051:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r8.getConstructor()
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r2 == 0) goto L_0x0077
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r1 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r1.getAlternativeType()
            if (r8 != 0) goto L_0x0069
            java.util.Collection r8 = r1.getSupertypes()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r11.commonSupertype(r8)
        L_0x0069:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r8)
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r8 = mapType(r0, r1, r2, r3, r4, r5)
            return r8
        L_0x0077:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r1 = r1.getDeclarationDescriptor()
            if (r1 == 0) goto L_0x01ee
            boolean r2 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(r1)
            if (r2 == 0) goto L_0x0094
            java.lang.String r10 = "error/NonExistentClass"
            java.lang.Object r9 = r9.createObjectType(r10)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
            r11.processErrorType(r8, r1)
            if (r12 == 0) goto L_0x0093
            r12.writeClass(r9)
        L_0x0093:
            return r9
        L_0x0094:
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 == 0) goto L_0x0118
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(r8)
            if (r3 == 0) goto L_0x0118
            java.util.List r0 = r8.getArguments()
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x0110
            java.util.List r8 = r8.getArguments()
            r0 = 0
            java.lang.Object r8 = r8.get(r0)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r8 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r8.getType()
            java.lang.String r0 = "memberProjection.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = r8.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r3 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r0 != r3) goto L_0x00d7
            java.lang.String r8 = "java/lang/Object"
            java.lang.Object r8 = r9.createObjectType(r8)
            if (r12 == 0) goto L_0x00f6
            r12.writeArrayType()
            r12.writeClass(r8)
            r12.writeArrayEnd()
            goto L_0x00f6
        L_0x00d7:
            if (r12 == 0) goto L_0x00dc
            r12.writeArrayType()
        L_0x00dc:
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = r8.getProjectionKind()
            java.lang.String r0 = "memberProjection.projectionKind"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r4 = r10.toGenericArgumentMode(r8, r1)
            r3 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            java.lang.Object r8 = mapType(r2, r3, r4, r5, r6, r7)
            if (r12 == 0) goto L_0x00f6
            r12.writeArrayEnd()
        L_0x00f6:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r11 = 91
            r10.append(r11)
            java.lang.String r8 = r9.toString(r8)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            java.lang.Object r8 = r9.createFromString(r8)
            return r8
        L_0x0110:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            java.lang.String r9 = "arrays must have one type argument"
            r8.<init>(r9)
            throw r8
        L_0x0118:
            if (r2 == 0) goto L_0x018c
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r1)
            if (r2 == 0) goto L_0x013c
            boolean r2 = r10.getNeedInlineClassWrapping()
            if (r2 != 0) goto L_0x013c
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(r0, r8)
            r2 = r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            if (r2 == 0) goto L_0x013c
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r4 = r10.wrapInlineClassesMode()
            r3 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            java.lang.Object r8 = mapType(r2, r3, r4, r5, r6, r7)
            return r8
        L_0x013c:
            boolean r12 = r10.isForAnnotationParameter()
            if (r12 == 0) goto L_0x0150
            r12 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r12
            boolean r12 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass(r12)
            if (r12 == 0) goto L_0x0150
            java.lang.Object r9 = r9.getJavaLangClassType()
            goto L_0x0188
        L_0x0150:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12 = r1.getOriginal()
            java.lang.String r0 = "descriptor.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            java.lang.Object r12 = r11.getPredefinedTypeForClass(r12)
            if (r12 != 0) goto L_0x0187
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r12 = r1.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r12 != r0) goto L_0x0175
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r12 = r1.getContainingDeclaration()
            java.lang.String r0 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r0)
            r1 = r12
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
        L_0x0175:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12 = r1.getOriginal()
            java.lang.String r0 = "enumClassIfEnumEntry.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            java.lang.String r11 = computeInternalName(r12, r11)
            java.lang.Object r9 = r9.createObjectType(r11)
            goto L_0x0188
        L_0x0187:
            r9 = r12
        L_0x0188:
            r13.invoke(r8, r9, r10)
            return r9
        L_0x018c:
            boolean r0 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r0 == 0) goto L_0x01bd
            r13 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r13
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(r13)
            boolean r8 = r8.isMarkedNullable()
            if (r8 == 0) goto L_0x01a1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r13)
        L_0x01a1:
            r2 = r13
            kotlin.jvm.functions.Function3 r7 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.getDO_NOTHING_3()
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r8 = mapType(r2, r3, r4, r5, r6, r7)
            if (r12 == 0) goto L_0x01bc
            kotlin.reflect.jvm.internal.impl.name.Name r9 = r1.getName()
            java.lang.String r10 = "descriptor.getName()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r12.writeTypeVariable(r9, r8)
        L_0x01bc:
            return r8
        L_0x01bd:
            boolean r0 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
            if (r0 == 0) goto L_0x01d7
            boolean r0 = r10.getMapTypeAliases()
            if (r0 == 0) goto L_0x01d7
            kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r1.getExpandedType()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            java.lang.Object r8 = mapType(r2, r3, r4, r5, r6, r7)
            return r8
        L_0x01d7:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unknown type "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x01ee:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "no descriptor for type constructor of "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt.mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3<Object, Object, Object, Unit> function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }
}
