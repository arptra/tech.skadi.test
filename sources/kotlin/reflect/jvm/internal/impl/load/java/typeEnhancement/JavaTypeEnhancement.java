package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\ntypeEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,262:1\n1#2:263\n3433#3,7:264\n1726#3,3:271\n3433#3,7:274\n*S KotlinDebug\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n*L\n117#1:264,7\n143#1:271,3\n155#1:274,7\n*E\n"})
public final class JavaTypeEnhancement {
    @NotNull
    private final JavaResolverSettings javaResolverSettings;

    public static final class Result {
        private final int subtreeSize;
        @Nullable
        private final KotlinType type;

        public Result(@Nullable KotlinType kotlinType, int i) {
            this.type = kotlinType;
            this.subtreeSize = i;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final KotlinType getType() {
            return this.type;
        }
    }

    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        @Nullable
        private final SimpleType type;

        public SimpleResult(@Nullable SimpleType simpleType, int i, boolean z) {
            this.type = simpleType;
            this.subtreeSize = i;
            this.forWarnings = z;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(@NotNull JavaResolverSettings javaResolverSettings2) {
        Intrinsics.checkNotNullParameter(javaResolverSettings2, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0201  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult enhanceInflexible(kotlin.reflect.jvm.internal.impl.types.SimpleType r19, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r20, int r21, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r22, boolean r23, boolean r24) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r22
            r3 = r24
            boolean r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPositionKt.shouldEnhance(r22)
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0015
            if (r23 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r7 = r5
            goto L_0x0016
        L_0x0015:
            r7 = r6
        L_0x0016:
            r8 = 0
            if (r4 != 0) goto L_0x0029
            java.util.List r4 = r19.getArguments()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0029
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r0.<init>(r8, r6, r5)
            return r0
        L_0x0029:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r19.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
            if (r4 != 0) goto L_0x0039
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r0.<init>(r8, r6, r5)
            return r0
        L_0x0039:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r21)
            java.lang.Object r9 = r1.invoke(r9)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r9 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r9
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.enhanceMutability(r4, r9, r2)
            java.lang.Boolean r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.getEnhancedNullability(r9, r2)
            if (r4 == 0) goto L_0x0056
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r4.getTypeConstructor()
            if (r10 != 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r12 = r10
            goto L_0x005b
        L_0x0056:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r19.getConstructor()
            goto L_0x0054
        L_0x005b:
            java.lang.String r10 = "enhancedClassifier?.typeConstructor ?: constructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r10)
            int r10 = r21 + 1
            java.util.List r11 = r19.getArguments()
            java.util.List r13 = r12.getParameters()
            java.lang.String r14 = "typeConstructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.util.Iterator r14 = r11.iterator()
            java.util.Iterator r15 = r13.iterator()
            java.util.ArrayList r6 = new java.util.ArrayList
            r5 = 10
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r5)
            int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r5)
            int r11 = java.lang.Math.min(r11, r13)
            r6.<init>(r11)
        L_0x008a:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L_0x014f
            boolean r11 = r15.hasNext()
            if (r11 == 0) goto L_0x014f
            java.lang.Object r11 = r14.next()
            java.lang.Object r13 = r15.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r13
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r11 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r11
            if (r7 != 0) goto L_0x00ad
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r23 = r7
            r7 = 0
            r5.<init>(r8, r7)
            goto L_0x0101
        L_0x00ad:
            r23 = r7
            boolean r5 = r11.isStarProjection()
            if (r5 != 0) goto L_0x00c2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r11.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5 = r5.unwrap()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r5 = r0.enhancePossiblyFlexible(r5, r1, r10, r3)
            goto L_0x0101
        L_0x00c2:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            java.lang.Object r5 = r1.invoke(r5)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = r5.getNullability()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            if (r5 != r7) goto L_0x00f9
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r11.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5 = r5.unwrap()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(r5)
            r1 = 0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r8.makeNullableAsSpecified(r1)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(r5)
            r5 = 1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.makeNullableAsSpecified(r5)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r8, r1)
            r7.<init>(r1, r5)
            r5 = r7
            goto L_0x0101
        L_0x00f9:
            r5 = 1
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r7 = 0
            r1.<init>(r7, r5)
            r5 = r1
        L_0x0101:
            int r1 = r5.getSubtreeSize()
            int r10 = r10 + r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r5.getType()
            java.lang.String r7 = "arg.projectionKind"
            if (r1 == 0) goto L_0x011e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r5.getType()
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r11.getProjectionKind()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(r1, r5, r13)
            goto L_0x0143
        L_0x011e:
            if (r4 == 0) goto L_0x013b
            boolean r1 = r11.isStarProjection()
            if (r1 != 0) goto L_0x013b
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r11.getType()
            java.lang.String r5 = "arg.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r11.getProjectionKind()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(r1, r5, r13)
            goto L_0x0143
        L_0x013b:
            if (r4 == 0) goto L_0x0142
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(r13)
            goto L_0x0143
        L_0x0142:
            r7 = 0
        L_0x0143:
            r6.add(r7)
            r1 = r20
            r7 = r23
            r5 = 10
            r8 = 0
            goto L_0x008a
        L_0x014f:
            int r10 = r10 - r21
            if (r4 != 0) goto L_0x016f
            if (r2 != 0) goto L_0x016f
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x015c
            goto L_0x0171
        L_0x015c:
            java.util.Iterator r1 = r6.iterator()
        L_0x0160:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0171
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r3 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r3
            if (r3 != 0) goto L_0x016f
            goto L_0x0160
        L_0x016f:
            r7 = 0
            goto L_0x0179
        L_0x0171:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r1 = 0
            r7 = 0
            r0.<init>(r7, r10, r1)
            return r0
        L_0x0179:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r19.getAnnotations()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS
            if (r4 == 0) goto L_0x0184
            goto L_0x0185
        L_0x0184:
            r3 = r7
        L_0x0185:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS()
            if (r2 == 0) goto L_0x018d
            r8 = r4
            goto L_0x018e
        L_0x018d:
            r8 = r7
        L_0x018e:
            r4 = 3
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[] r4 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[r4]
            r5 = 0
            r4[r5] = r1
            r1 = 1
            r4[r1] = r3
            r3 = 2
            r4[r3] = r8
            java.util.List r3 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r4)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.compositeAnnotationsOrSingle(r3)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r11 = kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.toDefaultAttributes(r3)
            java.util.List r3 = r19.getArguments()
            java.util.Iterator r4 = r6.iterator()
            java.util.Iterator r7 = r3.iterator()
            java.util.ArrayList r13 = new java.util.ArrayList
            r8 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r8)
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r8)
            int r3 = java.lang.Math.min(r6, r3)
            r13.<init>(r3)
        L_0x01c5:
            boolean r3 = r4.hasNext()
            if (r3 == 0) goto L_0x01e5
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x01e5
            java.lang.Object r3 = r4.next()
            java.lang.Object r6 = r7.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r6 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r6
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r3 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r3
            if (r3 != 0) goto L_0x01e0
            goto L_0x01e1
        L_0x01e0:
            r6 = r3
        L_0x01e1:
            r13.add(r6)
            goto L_0x01c5
        L_0x01e5:
            if (r2 == 0) goto L_0x01ed
            boolean r3 = r2.booleanValue()
        L_0x01eb:
            r14 = r3
            goto L_0x01f2
        L_0x01ed:
            boolean r3 = r19.isMarkedNullable()
            goto L_0x01eb
        L_0x01f2:
            r16 = 16
            r17 = 0
            r15 = 0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default((kotlin.reflect.jvm.internal.impl.types.TypeAttributes) r11, (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r12, (java.util.List) r13, (boolean) r14, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) r15, (int) r16, (java.lang.Object) r17)
            boolean r4 = r9.getDefinitelyNotNull()
            if (r4 == 0) goto L_0x0205
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r0.notNullTypeParameter(r3)
        L_0x0205:
            if (r2 == 0) goto L_0x020e
            boolean r0 = r9.isNullabilityQualifierForWarning()
            if (r0 == 0) goto L_0x020e
            r5 = r1
        L_0x020e:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r0.<init>(r3, r10, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhanceInflexible(kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.jvm.functions.Function1, int, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition, boolean, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult");
    }

    public static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
        if (r11 == null) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r13, int r14, boolean r15) {
        /*
            r11 = this;
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r12)
            r1 = 0
            if (r0 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r12 = 1
            r11.<init>(r1, r12)
            return r11
        L_0x000e:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto L_0x00ad
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.RawType
            r9 = r12
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r9 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r9
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getLowerBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r2 = r11
            r4 = r13
            r5 = r14
            r7 = r0
            r8 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r10 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getUpperBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r11 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            r10.getSubtreeSize()
            r11.getSubtreeSize()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r10.getType()
            if (r13 != 0) goto L_0x0043
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r11.getType()
            if (r13 != 0) goto L_0x0043
            goto L_0x00a3
        L_0x0043:
            boolean r13 = r10.getForWarnings()
            if (r13 != 0) goto L_0x0085
            boolean r13 = r11.getForWarnings()
            if (r13 == 0) goto L_0x0050
            goto L_0x0085
        L_0x0050:
            if (r0 == 0) goto L_0x006c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L_0x005e
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L_0x005e:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r11.getType()
            if (r11 != 0) goto L_0x0068
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r9.getUpperBound()
        L_0x0068:
            r1.<init>(r12, r11)
            goto L_0x00a3
        L_0x006c:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L_0x0076
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r11.getType()
            if (r11 != 0) goto L_0x0080
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r9.getUpperBound()
        L_0x0080:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r12, r11)
            goto L_0x00a3
        L_0x0085:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r11.getType()
            if (r11 == 0) goto L_0x0098
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r10.getType()
            if (r13 != 0) goto L_0x0092
            r13 = r11
        L_0x0092:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r11 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r13, r11)
            if (r11 != 0) goto L_0x009f
        L_0x0098:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r10.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
        L_0x009f:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r11)
        L_0x00a3:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            int r12 = r10.getSubtreeSize()
            r11.<init>(r1, r12)
            goto L_0x00df
        L_0x00ad:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x00e0
            r2 = r12
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r8 = 8
            r9 = 0
            r6 = 0
            r1 = r11
            r3 = r13
            r4 = r14
            r7 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r11 = enhanceInflexible$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r13 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            boolean r14 = r11.getForWarnings()
            if (r14 == 0) goto L_0x00d3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r11.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r14)
            goto L_0x00d7
        L_0x00d3:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r11.getType()
        L_0x00d7:
            int r11 = r11.getSubtreeSize()
            r13.<init>(r12, r11)
            r11 = r13
        L_0x00df:
            return r11
        L_0x00e0:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result");
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        return this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() ? SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true) : new NotNullTypeParameterImpl(simpleType);
    }

    @Nullable
    public final KotlinType enhance(@NotNull KotlinType kotlinType, @NotNull Function1<? super Integer, JavaTypeQualifiers> function1, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), function1, 0, z).getType();
    }
}
