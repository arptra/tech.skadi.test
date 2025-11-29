package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0007\u001ag\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00032.\u0010\u0006\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00002\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aK\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\u0002*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00112\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001am\u0010\u0017\u001a\u00020\u0012\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00112\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"", "R", "T", "Landroidx/paging/TransformablePage;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "generator", "c", "(Landroidx/paging/TransformablePage;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "separator", "", "originalPageOffsets", "", "hintOriginalPageOffset", "hintOriginalIndex", "d", "(Ljava/lang/Object;[III)Landroidx/paging/TransformablePage;", "", "", "b", "(Ljava/util/List;Ljava/lang/Object;[III)V", "adjacentPageBefore", "adjacentPageAfter", "a", "(Ljava/util/List;Ljava/lang/Object;Landroidx/paging/TransformablePage;Landroidx/paging/TransformablePage;II)V", "paging-common"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSeparators.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Separators.kt\nandroidx/paging/SeparatorsKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,607:1\n47#2:608\n49#2:612\n50#3:609\n55#3:611\n106#4:610\n*S KotlinDebug\n*F\n+ 1 Separators.kt\nandroidx/paging/SeparatorsKt\n*L\n606#1:608\n606#1:612\n606#1:609\n606#1:611\n606#1:610\n*E\n"})
public final class SeparatorsKt {
    public static final void a(List list, Object obj, TransformablePage transformablePage, TransformablePage transformablePage2, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int[] iArr = null;
        int[] e = transformablePage != null ? transformablePage.e() : null;
        if (transformablePage2 != null) {
            iArr = transformablePage2.e();
        }
        if (e != null && iArr != null) {
            e = CollectionsKt.toIntArray(CollectionsKt.sorted(ArraysKt.distinct(ArraysKt.plus(e, iArr))));
        } else if (e == null && iArr != null) {
            e = iArr;
        } else if (e == null || iArr != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        b(list, obj, e, i, i2);
    }

    public static final void b(List list, Object obj, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "originalPageOffsets");
        if (obj != null) {
            list.add(d(obj, iArr, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(androidx.paging.TransformablePage r12, kotlin.jvm.functions.Function3 r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof androidx.paging.SeparatorsKt$insertInternalSeparators$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.paging.SeparatorsKt$insertInternalSeparators$1 r0 = (androidx.paging.SeparatorsKt$insertInternalSeparators$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.SeparatorsKt$insertInternalSeparators$1 r0 = new androidx.paging.SeparatorsKt$insertInternalSeparators$1
            r0.<init>(r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "null cannot be cast to non-null type androidx.paging.TransformablePage<R of androidx.paging.SeparatorsKt.insertInternalSeparators>"
            r4 = 1
            if (r2 == 0) goto L_0x004f
            if (r2 != r4) goto L_0x0047
            int r12 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r2 = r0.L$4
            java.lang.Object r5 = r0.L$3
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r0.L$2
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            java.lang.Object r8 = r0.L$0
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            kotlin.ResultKt.throwOnFailure(r14)
            r10 = r5
            r5 = r0
            r0 = r7
            r7 = r6
            r6 = r10
            goto L_0x00da
        L_0x0047:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.List r14 = r12.b()
            boolean r14 = r14.isEmpty()
            if (r14 == 0) goto L_0x0060
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r3)
            return r12
        L_0x0060:
            java.util.List r14 = r12.b()
            int r14 = r14.size()
            int r14 = r14 + 4
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r14)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r14)
            java.util.List r14 = r12.b()
            java.lang.Object r14 = kotlin.collections.CollectionsKt.first(r14)
            r2.add(r14)
            java.util.List r14 = r12.c()
            if (r14 == 0) goto L_0x0090
            java.lang.Object r14 = kotlin.collections.CollectionsKt.first(r14)
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            goto L_0x0091
        L_0x0090:
            r14 = 0
        L_0x0091:
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r14)
            r5.add(r14)
            java.util.List r14 = r12.b()
            int r14 = r14.size()
            r6 = r2
            r2 = r0
            r0 = r13
            r13 = r12
            r12 = r14
            r14 = r4
        L_0x00a6:
            if (r14 >= r12) goto L_0x00f7
            java.util.List r7 = r13.b()
            java.lang.Object r7 = r7.get(r14)
            java.util.List r8 = r13.b()
            int r9 = r14 + -1
            java.lang.Object r8 = r8.get(r9)
            r2.L$0 = r13
            r2.L$1 = r0
            r2.L$2 = r6
            r2.L$3 = r5
            r2.L$4 = r7
            r2.I$0 = r14
            r2.I$1 = r12
            r2.label = r4
            java.lang.Object r8 = r0.invoke(r8, r7, r2)
            if (r8 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            r10 = r8
            r8 = r13
            r13 = r14
            r14 = r10
            r11 = r5
            r5 = r2
            r2 = r7
            r7 = r6
            r6 = r11
        L_0x00da:
            if (r14 == 0) goto L_0x00e6
            r7.add(r14)
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            r6.add(r14)
        L_0x00e6:
            r7.add(r2)
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            r6.add(r14)
            int r14 = r13 + 1
            r2 = r5
            r5 = r6
            r6 = r7
            r13 = r8
            goto L_0x00a6
        L_0x00f7:
            int r12 = r6.size()
            java.util.List r14 = r13.b()
            int r14 = r14.size()
            if (r12 != r14) goto L_0x0109
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r3)
            goto L_0x0117
        L_0x0109:
            androidx.paging.TransformablePage r12 = new androidx.paging.TransformablePage
            int[] r14 = r13.e()
            int r13 = r13.d()
            r12.<init>(r14, r6, r13, r5)
            r13 = r12
        L_0x0117:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorsKt.c(androidx.paging.TransformablePage, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final TransformablePage d(Object obj, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(obj, "separator");
        Intrinsics.checkNotNullParameter(iArr, "originalPageOffsets");
        return new TransformablePage(iArr, CollectionsKt.listOf(obj), i, CollectionsKt.listOf(Integer.valueOf(i2)));
    }
}
