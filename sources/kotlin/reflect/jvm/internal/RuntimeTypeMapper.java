package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRuntimeTypeMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/RuntimeTypeMapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1#2:284\n*E\n"})
public final class RuntimeTypeMapper {
    @NotNull
    public static final RuntimeTypeMapper INSTANCE = new RuntimeTypeMapper();
    @NotNull
    private static final ClassId JAVA_LANG_VOID;

    static {
        ClassId classId = ClassId.topLevel(new FqName("java.lang.Void"));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(\"java.lang.Void\"))");
        JAVA_LANG_VOID = classId;
    }

    private RuntimeTypeMapper() {
    }

    private final PrimitiveType getPrimitiveType(Class<?> cls) {
        if (cls.isPrimitive()) {
            return JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor functionDescriptor) {
        if (DescriptorFactory.isEnumValueOfMethod(functionDescriptor) || DescriptorFactory.isEnumValuesMethod(functionDescriptor)) {
            return true;
        }
        return Intrinsics.areEqual((Object) functionDescriptor.getName(), (Object) CloneableClassScope.Companion.getCLONE_NAME()) && functionDescriptor.getValueParameters().isEmpty();
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor functionDescriptor) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(functionDescriptor), MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 1, (Object) null)));
    }

    private final String mapName(CallableMemberDescriptor callableMemberDescriptor) {
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(callableMemberDescriptor);
        if (jvmMethodNameIfSpecial != null) {
            return jvmMethodNameIfSpecial;
        }
        if (callableMemberDescriptor instanceof PropertyGetterDescriptor) {
            String asString = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "descriptor.propertyIfAccessor.name.asString()");
            return JvmAbi.getterName(asString);
        } else if (callableMemberDescriptor instanceof PropertySetterDescriptor) {
            String asString2 = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString2, "descriptor.propertyIfAccessor.name.asString()");
            return JvmAbi.setterName(asString2);
        } else {
            String asString3 = callableMemberDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString3, "descriptor.name.asString()");
            return asString3;
        }
    }

    @NotNull
    public final ClassId mapJvmClassToKotlinClassId(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "klass.componentType");
            PrimitiveType primitiveType = getPrimitiveType(componentType);
            if (primitiveType != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType.getArrayTypeName());
            }
            ClassId classId = ClassId.topLevel(StandardNames.FqNames.array.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.array.toSafe())");
            return classId;
        } else if (Intrinsics.areEqual((Object) cls, (Object) Void.TYPE)) {
            return JAVA_LANG_VOID;
        } else {
            PrimitiveType primitiveType2 = getPrimitiveType(cls);
            if (primitiveType2 != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType2.getTypeName());
            }
            ClassId classId2 = ReflectClassUtilKt.getClassId(cls);
            if (!classId2.isLocal()) {
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                FqName asSingleFqName = classId2.asSingleFqName();
                Intrinsics.checkNotNullExpressionValue(asSingleFqName, "classId.asSingleFqName()");
                ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
                if (mapJavaToKotlin != null) {
                    return mapJavaToKotlin;
                }
            }
            return classId2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.reflect.Method} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.JvmPropertySignature mapPropertySignature(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7) {
        /*
            r6 = this;
            java.lang.String r0 = "possiblyOverriddenProperty"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r7 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverride(r7)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = r7.getOriginal()
            java.lang.String r7 = "unwrapFakeOverride(possi…rriddenProperty).original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            boolean r7 = r1 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor
            r0 = 0
            if (r7 == 0) goto L_0x003e
            r7 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r7 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) r7
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r2 = r7.getProto()
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature
            java.lang.String r4 = "propertySignature"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Object r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(r2, r3)
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r3
            if (r3 == 0) goto L_0x00c7
            kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty r6 = new kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r7.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r5 = r7.getTypeTable()
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        L_0x003e:
            boolean r7 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
            if (r7 == 0) goto L_0x00c7
            r6 = r1
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r6 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) r6
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r6 = r6.getSource()
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r7 == 0) goto L_0x0050
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r6 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r6
            goto L_0x0051
        L_0x0050:
            r6 = r0
        L_0x0051:
            if (r6 == 0) goto L_0x0058
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r6 = r6.getJavaElement()
            goto L_0x0059
        L_0x0058:
            r6 = r0
        L_0x0059:
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField
            if (r7 == 0) goto L_0x0069
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField r7 = new kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField r6 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField) r6
            java.lang.reflect.Field r6 = r6.getMember()
            r7.<init>(r6)
            goto L_0x00a2
        L_0x0069:
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r7 == 0) goto L_0x00a3
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty r7 = new kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r6 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r6
            java.lang.reflect.Method r6 = r6.getMember()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor r1 = r1.getSetter()
            if (r1 == 0) goto L_0x0080
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r1 = r1.getSource()
            goto L_0x0081
        L_0x0080:
            r1 = r0
        L_0x0081:
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r2 == 0) goto L_0x0088
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r1 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r1
            goto L_0x0089
        L_0x0088:
            r1 = r0
        L_0x0089:
            if (r1 == 0) goto L_0x0090
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r1 = r1.getJavaElement()
            goto L_0x0091
        L_0x0090:
            r1 = r0
        L_0x0091:
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r2 == 0) goto L_0x0098
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r1 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r1
            goto L_0x0099
        L_0x0098:
            r1 = r0
        L_0x0099:
            if (r1 == 0) goto L_0x009f
            java.lang.reflect.Method r0 = r1.getMember()
        L_0x009f:
            r7.<init>(r6, r0)
        L_0x00a2:
            return r7
        L_0x00a3:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Incorrect resolution sequence for Java field "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = " (source = "
            r0.append(r1)
            r0.append(r6)
            r6 = 41
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x00c7:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor r7 = r1.getGetter()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = r6.mapJvmFunctionSignature(r7)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor r1 = r1.getSetter()
            if (r1 == 0) goto L_0x00dc
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r0 = r6.mapJvmFunctionSignature(r1)
        L_0x00dc:
            kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty r6 = new kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty
            r6.<init>(r7, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapPropertySignature(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor):kotlin.reflect.jvm.internal.JvmPropertySignature");
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.JvmFunctionSignature mapSignature(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r8) {
        /*
            r7 = this;
            java.lang.String r0 = "possiblySubstitutedFunction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverride(r8)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = r0.getOriginal()
            java.lang.String r1 = "unwrapFakeOverride(possi…titutedFunction).original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor
            if (r1 == 0) goto L_0x0072
            r1 = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor r1 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor) r1
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r2 = r1.getProto()
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function
            if (r3 == 0) goto L_0x003c
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE
            r4 = r2
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r4
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r5 = r1.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r6 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r3 = r3.getJvmMethodSignature(r4, r5, r6)
            if (r3 == 0) goto L_0x003c
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction
            r7.<init>(r3)
            return r7
        L_0x003c:
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor
            if (r3 == 0) goto L_0x006d
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r2 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r2
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r1.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r1 = r3.getJvmConstructorSignature(r2, r4, r1)
            if (r1 == 0) goto L_0x006d
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7 = r8.getContainingDeclaration()
            java.lang.String r8 = "possiblySubstitutedFunction.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            boolean r7 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r7)
            if (r7 == 0) goto L_0x0067
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction
            r7.<init>(r1)
            goto L_0x006c
        L_0x0067:
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinConstructor r7 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinConstructor
            r7.<init>(r1)
        L_0x006c:
            return r7
        L_0x006d:
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = r7.mapJvmFunctionSignature(r0)
            return r7
        L_0x0072:
            boolean r8 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor
            r1 = 0
            if (r8 == 0) goto L_0x00ba
            r7 = r0
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor r7 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = r7.getSource()
            boolean r8 = r7 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r8 == 0) goto L_0x0085
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r7 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r7
            goto L_0x0086
        L_0x0085:
            r7 = r1
        L_0x0086:
            if (r7 == 0) goto L_0x008d
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r7 = r7.getJavaElement()
            goto L_0x008e
        L_0x008d:
            r7 = r1
        L_0x008e:
            boolean r8 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r8 == 0) goto L_0x0095
            r1 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r1 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r1
        L_0x0095:
            if (r1 == 0) goto L_0x00a3
            java.lang.reflect.Method r7 = r1.getMember()
            if (r7 == 0) goto L_0x00a3
            kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaMethod r8 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaMethod
            r8.<init>(r7)
            return r8
        L_0x00a3:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Incorrect resolution sequence for Java method "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00ba:
            boolean r8 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor
            r2 = 41
            java.lang.String r3 = " ("
            if (r8 == 0) goto L_0x011f
            r7 = r0
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor r7 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = r7.getSource()
            boolean r8 = r7 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r8 == 0) goto L_0x00d0
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r7 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r7
            goto L_0x00d1
        L_0x00d0:
            r7 = r1
        L_0x00d1:
            if (r7 == 0) goto L_0x00d7
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r1 = r7.getJavaElement()
        L_0x00d7:
            boolean r7 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor
            if (r7 == 0) goto L_0x00e7
            kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaConstructor r7 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaConstructor
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor) r1
            java.lang.reflect.Constructor r8 = r1.getMember()
            r7.<init>(r8)
            goto L_0x00fe
        L_0x00e7:
            boolean r7 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass
            if (r7 == 0) goto L_0x00ff
            r7 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r7 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass) r7
            boolean r8 = r7.isAnnotationType()
            if (r8 == 0) goto L_0x00ff
            kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor r8 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor
            java.lang.Class r7 = r7.getElement()
            r8.<init>(r7)
            r7 = r8
        L_0x00fe:
            return r7
        L_0x00ff:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r4 = "Incorrect resolution sequence for Java constructor "
            r8.append(r4)
            r8.append(r0)
            r8.append(r3)
            r8.append(r1)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x011f:
            boolean r8 = r7.isKnownBuiltInFunction(r0)
            if (r8 == 0) goto L_0x012a
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = r7.mapJvmFunctionSignature(r0)
            return r7
        L_0x012a:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r7 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Unknown origin of "
            r8.append(r1)
            r8.append(r0)
            r8.append(r3)
            java.lang.Class r0 = r0.getClass()
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapSignature(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):kotlin.reflect.jvm.internal.JvmFunctionSignature");
    }
}
