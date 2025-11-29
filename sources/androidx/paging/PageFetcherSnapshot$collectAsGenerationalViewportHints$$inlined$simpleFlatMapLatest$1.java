package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFlowExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExt.kt\nandroidx/paging/FlowExtKt$simpleFlatMapLatest$1\n+ 2 PageFetcherSnapshot.kt\nandroidx/paging/PageFetcherSnapshot\n+ 3 PageFetcherSnapshotState.kt\nandroidx/paging/PageFetcherSnapshotState$Holder\n+ 4 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 5 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 6 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 7 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,224:1\n254#2:225\n258#2,2:236\n260#2,4:239\n265#2,4:244\n391#3:226\n392#3:235\n107#4,8:227\n116#4:238\n115#4:243\n47#5:248\n49#5:252\n50#6:249\n55#6:251\n106#7:250\n*S KotlinDebug\n*F\n+ 1 PageFetcherSnapshot.kt\nandroidx/paging/PageFetcherSnapshot\n*L\n254#1:226\n254#1:235\n254#1:227,8\n254#1:238\n254#1:243\n268#1:248\n268#1:252\n268#1:249\n268#1:251\n268#1:250\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "androidx/paging/FlowExtKt$simpleFlatMapLatest$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0}, l = {232, 99}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv", "generationId"}, s = {"L$1", "L$2", "I$0"})
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super GenerationalViewportHint>, Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadType $loadType$inlined;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(Continuation continuation, PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        super(3, continuation);
        this.this$0 = pageFetcherSnapshot;
        this.$loadType$inlined = loadType;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x002e
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00c8
        L_0x0014:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x001c:
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$2
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r11.L$1
            androidx.paging.PageFetcherSnapshotState$Holder r6 = (androidx.paging.PageFetcherSnapshotState.Holder) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0059
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r7 = r12
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r12 = r11.L$1
            java.lang.Number r12 = (java.lang.Number) r12
            int r1 = r12.intValue()
            androidx.paging.PageFetcherSnapshot r12 = r11.this$0
            androidx.paging.PageFetcherSnapshotState$Holder r6 = r12.k
            kotlinx.coroutines.sync.Mutex r5 = r6.b
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r5
            r11.I$0 = r1
            r11.label = r3
            java.lang.Object r12 = r5.c(r4, r11)
            if (r12 != r0) goto L_0x0059
            return r0
        L_0x0059:
            androidx.paging.PageFetcherSnapshotState r12 = r6.c     // Catch:{ all -> 0x007e }
            androidx.paging.MutableLoadStateCollection r6 = r12.p()     // Catch:{ all -> 0x007e }
            androidx.paging.LoadType r8 = r11.$loadType$inlined     // Catch:{ all -> 0x007e }
            androidx.paging.LoadState r6 = r6.a(r8)     // Catch:{ all -> 0x007e }
            androidx.paging.LoadState$NotLoading$Companion r8 = androidx.paging.LoadState.NotLoading.b     // Catch:{ all -> 0x007e }
            androidx.paging.LoadState$NotLoading r9 = r8.a()     // Catch:{ all -> 0x007e }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r9)     // Catch:{ all -> 0x007e }
            r9 = 0
            if (r6 == 0) goto L_0x0080
            androidx.paging.GenerationalViewportHint[] r12 = new androidx.paging.GenerationalViewportHint[r9]     // Catch:{ all -> 0x007e }
            kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.E(r12)     // Catch:{ all -> 0x007e }
            r5.d(r4)
            goto L_0x00b9
        L_0x007e:
            r11 = move-exception
            goto L_0x00cb
        L_0x0080:
            androidx.paging.MutableLoadStateCollection r6 = r12.p()     // Catch:{ all -> 0x007e }
            androidx.paging.LoadType r10 = r11.$loadType$inlined     // Catch:{ all -> 0x007e }
            androidx.paging.LoadState r6 = r6.a(r10)     // Catch:{ all -> 0x007e }
            boolean r6 = r6 instanceof androidx.paging.LoadState.Error     // Catch:{ all -> 0x007e }
            if (r6 != 0) goto L_0x009b
            androidx.paging.MutableLoadStateCollection r12 = r12.p()     // Catch:{ all -> 0x007e }
            androidx.paging.LoadType r6 = r11.$loadType$inlined     // Catch:{ all -> 0x007e }
            androidx.paging.LoadState$NotLoading r8 = r8.b()     // Catch:{ all -> 0x007e }
            r12.c(r6, r8)     // Catch:{ all -> 0x007e }
        L_0x009b:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007e }
            r5.d(r4)
            androidx.paging.PageFetcherSnapshot r12 = r11.this$0
            androidx.paging.HintHandler r12 = r12.h
            androidx.paging.LoadType r5 = r11.$loadType$inlined
            kotlinx.coroutines.flow.Flow r12 = r12.c(r5)
            if (r1 != 0) goto L_0x00af
            r3 = r9
        L_0x00af:
            kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.q(r12, r3)
            androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1 r3 = new androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1
            r3.<init>(r12, r1)
            r12 = r3
        L_0x00b9:
            r11.L$0 = r4
            r11.L$1 = r4
            r11.L$2 = r4
            r11.label = r2
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.t(r7, r12, r11)
            if (r11 != r0) goto L_0x00c8
            return r0
        L_0x00c8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00cb:
            r5.d(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super GenerationalViewportHint> flowCollector, Integer num, @Nullable Continuation<? super Unit> continuation) {
        PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(continuation, this.this$0, this.$loadType$inlined);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$0 = flowCollector;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$1 = num;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }
}
