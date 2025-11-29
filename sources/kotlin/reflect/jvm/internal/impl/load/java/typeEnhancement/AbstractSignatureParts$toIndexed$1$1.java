package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

@SourceDebugExtension({"SMAP\nAbstractSignatureParts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts$toIndexed$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,228:1\n3433#2,7:229\n*S KotlinDebug\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts$toIndexed$1$1\n*L\n209#1:229,7\n*E\n"})
public final class AbstractSignatureParts$toIndexed$1$1 extends Lambda implements Function1<AbstractSignatureParts.TypeAndDefaultQualifiers, Iterable<? extends AbstractSignatureParts.TypeAndDefaultQualifiers>> {
    final /* synthetic */ TypeSystemContext $this_with;
    final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractSignatureParts$toIndexed$1$1(AbstractSignatureParts<TAnnotation> abstractSignatureParts, TypeSystemContext typeSystemContext) {
        super(1);
        this.this$0 = abstractSignatureParts;
        this.$this_with = typeSystemContext;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r9.$this_with.asFlexibleType(r0);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Iterable<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers> invoke(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers r10) {
        /*
            r9 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts<TAnnotation> r0 = r9.this$0
            boolean r0 = r0.getSkipRawTypeArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r10.getType()
            if (r0 == 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r9.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker r0 = r2.asFlexibleType(r0)
            if (r0 == 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r9.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker r0 = r2.asRawType(r0)
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return r1
        L_0x0027:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r10.getType()
            if (r0 == 0) goto L_0x00a5
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r9.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0)
            if (r0 == 0) goto L_0x00a5
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r9.$this_with
            java.util.List r0 = r2.getParameters(r0)
            if (r0 == 0) goto L_0x00a5
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r9.$this_with
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = r10.getType()
            java.util.List r2 = r2.getArguments(r3)
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r3 = r9.$this_with
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts<TAnnotation> r9 = r9.this$0
            java.util.Iterator r4 = r0.iterator()
            java.util.Iterator r5 = r2.iterator()
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r7)
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r7)
            int r0 = java.lang.Math.min(r0, r2)
            r6.<init>(r0)
        L_0x0066:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x00a4
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r0 = r4.next()
            java.lang.Object r2 = r5.next()
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker) r2
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker) r0
            boolean r7 = r3.isStarProjection(r2)
            if (r7 == 0) goto L_0x008e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r7 = r10.getDefaultQualifiers()
            r2.<init>(r1, r7, r0)
            goto L_0x00a0
        L_0x008e:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = r3.getType(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r8 = r10.getDefaultQualifiers()
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r8 = r9.extractAndMergeDefaultQualifiers(r2, r8)
            r7.<init>(r2, r8, r0)
            r2 = r7
        L_0x00a0:
            r6.add(r2)
            goto L_0x0066
        L_0x00a4:
            r1 = r6
        L_0x00a5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$toIndexed$1$1.invoke(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers):java.lang.Iterable");
    }
}
