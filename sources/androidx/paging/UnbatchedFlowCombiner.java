package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003Bg\u0012[\u0010\r\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014Rl\u0010\r\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00048\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00160\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/paging/UnbatchedFlowCombiner;", "T1", "T2", "", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "t1", "t2", "Landroidx/paging/CombineSource;", "updateFrom", "Lkotlin/coroutines/Continuation;", "", "send", "<init>", "(Lkotlin/jvm/functions/Function4;)V", "", "index", "value", "a", "(ILjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function4;", "Lkotlinx/coroutines/CompletableDeferred;", "b", "Lkotlinx/coroutines/CompletableDeferred;", "initialDispatched", "Lkotlinx/coroutines/sync/Mutex;", "c", "Lkotlinx/coroutines/sync/Mutex;", "lock", "", "d", "[Lkotlinx/coroutines/CompletableDeferred;", "valueReceived", "e", "[Ljava/lang/Object;", "values", "paging-common"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFlowExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExt.kt\nandroidx/paging/UnbatchedFlowCombiner\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,224:1\n107#2,8:225\n116#2:237\n115#2:238\n12744#3,2:233\n18987#3,2:235\n*S KotlinDebug\n*F\n+ 1 FlowExt.kt\nandroidx/paging/UnbatchedFlowCombiner\n*L\n196#1:225,8\n196#1:237\n196#1:238\n197#1:233,2\n200#1:235,2\n*E\n"})
public final class UnbatchedFlowCombiner<T1, T2> {

    /* renamed from: a  reason: collision with root package name */
    public final Function4 f1639a;
    public final CompletableDeferred b = CompletableDeferredKt.c((Job) null, 1, (Object) null);
    public final Mutex c;
    public final CompletableDeferred[] d;
    public final Object[] e;

    public UnbatchedFlowCombiner(Function4 function4) {
        Intrinsics.checkNotNullParameter(function4, "send");
        this.f1639a = function4;
        this.c = MutexKt.b(false, 1, (Object) null);
        CompletableDeferred[] completableDeferredArr = new CompletableDeferred[2];
        for (int i = 0; i < 2; i++) {
            completableDeferredArr[i] = CompletableDeferredKt.c((Job) null, 1, (Object) null);
        }
        this.d = completableDeferredArr;
        Object[] objArr = new Object[2];
        for (int i2 = 0; i2 < 2; i2++) {
            objArr[i2] = FlowExtKt.f1535a;
        }
        this.e = objArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4 A[Catch:{ all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00be A[Catch:{ all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc A[Catch:{ all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf A[Catch:{ all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ec A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(int r13, java.lang.Object r14, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            r0 = 1
            boolean r1 = r15 instanceof androidx.paging.UnbatchedFlowCombiner$onNext$1
            if (r1 == 0) goto L_0x0014
            r1 = r15
            androidx.paging.UnbatchedFlowCombiner$onNext$1 r1 = (androidx.paging.UnbatchedFlowCombiner$onNext$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0014
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x0019
        L_0x0014:
            androidx.paging.UnbatchedFlowCombiner$onNext$1 r1 = new androidx.paging.UnbatchedFlowCombiner$onNext$1
            r1.<init>(r12, r15)
        L_0x0019:
            java.lang.Object r15 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 3
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L_0x0060
            if (r3 == r0) goto L_0x0054
            if (r3 == r5) goto L_0x0044
            if (r3 != r4) goto L_0x003c
            java.lang.Object r12 = r1.L$1
            kotlinx.coroutines.sync.Mutex r12 = (kotlinx.coroutines.sync.Mutex) r12
            java.lang.Object r13 = r1.L$0
            androidx.paging.UnbatchedFlowCombiner r13 = (androidx.paging.UnbatchedFlowCombiner) r13
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0039 }
            goto L_0x00ef
        L_0x0039:
            r13 = move-exception
            goto L_0x00fe
        L_0x003c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0044:
            int r12 = r1.I$0
            java.lang.Object r13 = r1.L$2
            kotlinx.coroutines.sync.Mutex r13 = (kotlinx.coroutines.sync.Mutex) r13
            java.lang.Object r14 = r1.L$1
            java.lang.Object r3 = r1.L$0
            androidx.paging.UnbatchedFlowCombiner r3 = (androidx.paging.UnbatchedFlowCombiner) r3
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x009d
        L_0x0054:
            int r13 = r1.I$0
            java.lang.Object r14 = r1.L$1
            java.lang.Object r12 = r1.L$0
            androidx.paging.UnbatchedFlowCombiner r12 = (androidx.paging.UnbatchedFlowCombiner) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0087
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.CompletableDeferred[] r15 = r12.d
            r15 = r15[r13]
            boolean r15 = r15.isCompleted()
            if (r15 == 0) goto L_0x007e
            kotlinx.coroutines.CompletableDeferred r15 = r12.b
            r1.L$0 = r12
            r1.L$1 = r14
            r1.I$0 = r13
            r1.label = r0
            java.lang.Object r15 = r15.c(r1)
            if (r15 != r2) goto L_0x0087
            return r2
        L_0x007e:
            kotlinx.coroutines.CompletableDeferred[] r15 = r12.d
            r15 = r15[r13]
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r15.w(r3)
        L_0x0087:
            kotlinx.coroutines.sync.Mutex r15 = r12.c
            r1.L$0 = r12
            r1.L$1 = r14
            r1.L$2 = r15
            r1.I$0 = r13
            r1.label = r5
            java.lang.Object r3 = r15.c(r6, r1)
            if (r3 != r2) goto L_0x009a
            return r2
        L_0x009a:
            r3 = r12
            r12 = r13
            r13 = r15
        L_0x009d:
            java.lang.Object[] r15 = r3.e     // Catch:{ all -> 0x00b0 }
            int r5 = r15.length     // Catch:{ all -> 0x00b0 }
            r7 = 0
            r8 = r7
        L_0x00a2:
            if (r8 >= r5) goto L_0x00b5
            r9 = r15[r8]     // Catch:{ all -> 0x00b0 }
            java.lang.Object r10 = androidx.paging.FlowExtKt.f1535a     // Catch:{ all -> 0x00b0 }
            if (r9 != r10) goto L_0x00ae
            r15 = r0
            goto L_0x00b6
        L_0x00ae:
            int r8 = r8 + r0
            goto L_0x00a2
        L_0x00b0:
            r12 = move-exception
            r11 = r13
            r13 = r12
            r12 = r11
            goto L_0x00fe
        L_0x00b5:
            r15 = r7
        L_0x00b6:
            java.lang.Object[] r5 = r3.e     // Catch:{ all -> 0x00b0 }
            r5[r12] = r14     // Catch:{ all -> 0x00b0 }
            int r14 = r5.length     // Catch:{ all -> 0x00b0 }
            r8 = r7
        L_0x00bc:
            if (r8 >= r14) goto L_0x00ca
            r9 = r5[r8]     // Catch:{ all -> 0x00b0 }
            java.lang.Object r10 = androidx.paging.FlowExtKt.f1535a     // Catch:{ all -> 0x00b0 }
            if (r9 != r10) goto L_0x00c8
            r12 = r13
            goto L_0x00f6
        L_0x00c8:
            int r8 = r8 + r0
            goto L_0x00bc
        L_0x00ca:
            if (r15 == 0) goto L_0x00cf
            androidx.paging.CombineSource r12 = androidx.paging.CombineSource.INITIAL     // Catch:{ all -> 0x00b0 }
            goto L_0x00d6
        L_0x00cf:
            if (r12 != 0) goto L_0x00d4
            androidx.paging.CombineSource r12 = androidx.paging.CombineSource.RECEIVER     // Catch:{ all -> 0x00b0 }
            goto L_0x00d6
        L_0x00d4:
            androidx.paging.CombineSource r12 = androidx.paging.CombineSource.OTHER     // Catch:{ all -> 0x00b0 }
        L_0x00d6:
            kotlin.jvm.functions.Function4 r14 = r3.f1639a     // Catch:{ all -> 0x00b0 }
            java.lang.Object[] r15 = r3.e     // Catch:{ all -> 0x00b0 }
            r5 = r15[r7]     // Catch:{ all -> 0x00b0 }
            r15 = r15[r0]     // Catch:{ all -> 0x00b0 }
            r1.L$0 = r3     // Catch:{ all -> 0x00b0 }
            r1.L$1 = r13     // Catch:{ all -> 0x00b0 }
            r1.L$2 = r6     // Catch:{ all -> 0x00b0 }
            r1.label = r4     // Catch:{ all -> 0x00b0 }
            java.lang.Object r12 = r14.invoke(r5, r15, r12, r1)     // Catch:{ all -> 0x00b0 }
            if (r12 != r2) goto L_0x00ed
            return r2
        L_0x00ed:
            r12 = r13
            r13 = r3
        L_0x00ef:
            kotlinx.coroutines.CompletableDeferred r13 = r13.b     // Catch:{ all -> 0x0039 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            r13.w(r14)     // Catch:{ all -> 0x0039 }
        L_0x00f6:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            r12.d(r6)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00fe:
            r12.d(r6)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.UnbatchedFlowCombiner.a(int, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
