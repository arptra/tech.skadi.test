package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nKotlinTypePreparator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 5 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt$transformComponents$1\n*L\n1#1,76:1\n1#2:77\n1549#3:78\n1620#3,3:79\n1549#3:82\n1620#3,3:83\n1549#3:92\n1620#3,2:93\n1622#3:101\n98#4,6:86\n104#4:95\n105#4,4:97\n112#4,7:102\n99#5:96\n*S KotlinDebug\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n*L\n27#1:78\n27#1:79,3\n37#1:82\n37#1:83,3\n48#1:92\n48#1:93,2\n48#1:101\n48#1:86,6\n48#1:95\n48#1:97,4\n48#1:102,7\n48#1:96\n*E\n"})
public abstract class KotlinTypePreparator extends AbstractTypePreparator {

    public static final class Default extends KotlinTypePreparator {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX WARNING: type inference failed for: r2v3, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType r14) {
        /*
            r13 = this;
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r13 = r14.getConstructor()
            boolean r0 = r13 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl
            r1 = 10
            r2 = 0
            if (r0 == 0) goto L_0x007f
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl r13 = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl) r13
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = r13.getProjection()
            kotlin.reflect.jvm.internal.impl.types.Variance r3 = r0.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r4 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r3 != r4) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r0 = r2
        L_0x001b:
            if (r0 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            if (r0 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r2 = r0.unwrap()
        L_0x0027:
            r6 = r2
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r0 = r13.getNewTypeConstructor()
            if (r0 != 0) goto L_0x0063
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r8 = r13.getProjection()
            java.util.Collection r0 = r13.getSupertypes()
            java.util.ArrayList r9 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r1)
            r9.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0043:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = r1.unwrap()
            r9.add(r1)
            goto L_0x0043
        L_0x0057:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r0 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
            r10 = 0
            r11 = 4
            r12 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            r13.setNewTypeConstructor(r0)
        L_0x0063:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r0 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r4 = kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r5 = r13.getNewTypeConstructor()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r7 = r14.getAttributes()
            boolean r8 = r14.isMarkedNullable()
            r10 = 32
            r11 = 0
            r9 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x007f:
            boolean r0 = r13 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor
            r3 = 0
            if (r0 == 0) goto L_0x00ca
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor r13 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor) r13
            java.util.Collection r13 = r13.getSupertypes()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r1)
            r0.<init>(r1)
            java.util.Iterator r13 = r13.iterator()
        L_0x0097:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x00b4
            java.lang.Object r1 = r13.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            boolean r2 = r14.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(r1, r2)
            java.lang.String r2 = "makeNullableAsSpecified(it, type.isMarkedNullable)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.add(r1)
            goto L_0x0097
        L_0x00b4:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r13 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r13.<init>(r0)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r0 = r14.getAttributes()
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r14 = r14.getMemberScope()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r0, r13, r1, r3, r14)
            return r13
        L_0x00ca:
            boolean r0 = r13 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r0 == 0) goto L_0x011b
            boolean r0 = r14.isMarkedNullable()
            if (r0 == 0) goto L_0x011b
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r13 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r13
            java.util.Collection r14 = r13.getSupertypes()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r1)
            r0.<init>(r1)
            java.util.Iterator r14 = r14.iterator()
        L_0x00e7:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x00fc
            java.lang.Object r1 = r14.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r1)
            r0.add(r1)
            r3 = 1
            goto L_0x00e7
        L_0x00fc:
            if (r3 != 0) goto L_0x00ff
            goto L_0x0112
        L_0x00ff:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = r13.getAlternativeType()
            if (r14 == 0) goto L_0x0109
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r14)
        L_0x0109:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r14 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r14.<init>(r0)
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r2 = r14.setAlternative(r2)
        L_0x0112:
            if (r2 != 0) goto L_0x0115
            goto L_0x0116
        L_0x0115:
            r13 = r2
        L_0x0116:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.createType()
            return r13
        L_0x011b:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    @NotNull
    public UnwrappedType prepareType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof KotlinType) {
            UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
            if (unwrap instanceof SimpleType) {
                unwrappedType = transformToNewType((SimpleType) unwrap);
            } else if (unwrap instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrap;
                SimpleType transformToNewType = transformToNewType(flexibleType.getLowerBound());
                SimpleType transformToNewType2 = transformToNewType(flexibleType.getUpperBound());
                if (transformToNewType == flexibleType.getLowerBound() && transformToNewType2 == flexibleType.getUpperBound()) {
                    unwrappedType = unwrap;
                } else {
                    unwrappedType = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap, new KotlinTypePreparator$prepareType$1(this));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
