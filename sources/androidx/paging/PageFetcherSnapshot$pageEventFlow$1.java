package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPageFetcherSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageFetcherSnapshot.kt\nandroidx/paging/PageFetcherSnapshot$pageEventFlow$1\n+ 2 PageFetcherSnapshotState.kt\nandroidx/paging/PageFetcherSnapshotState$Holder\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,638:1\n391#2:639\n392#2:648\n391#2:651\n392#2:660\n107#3,8:640\n116#3:649\n115#3:650\n107#3,8:652\n116#3:661\n115#3:662\n*S KotlinDebug\n*F\n+ 1 PageFetcherSnapshot.kt\nandroidx/paging/PageFetcherSnapshot$pageEventFlow$1\n*L\n161#1:639\n161#1:648\n171#1:651\n171#1:660\n161#1:640,8\n161#1:649\n161#1:650\n171#1:652,8\n171#1:661\n171#1:662\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 0, 1, 2, 2, 2}, l = {645, 168, 657}, m = "invokeSuspend", n = {"$this$cancelableChannelFlow", "it", "this_$iv", "$this$withLock_u24default$iv$iv", "$this$cancelableChannelFlow", "$this$cancelableChannelFlow", "this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2"})
public final class PageFetcherSnapshot$pageEventFlow$1 extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$pageEventFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PageFetcherSnapshot$pageEventFlow$1 pageFetcherSnapshot$pageEventFlow$1 = new PageFetcherSnapshot$pageEventFlow$1(this.this$0, continuation);
        pageFetcherSnapshot$pageEventFlow$1.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$1;
    }

    @Nullable
    public final Object invoke(@NotNull SimpleProducerScope<PageEvent<Value>> simpleProducerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PageFetcherSnapshot$pageEventFlow$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0049
            if (r1 == r4) goto L_0x0035
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r14.L$2
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r1 = r14.L$1
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r2 = r14.L$0
            androidx.paging.SimpleProducerScope r2 = (androidx.paging.SimpleProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00f8
        L_0x0023:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x002b:
            java.lang.Object r1 = r14.L$0
            androidx.paging.SimpleProducerScope r1 = (androidx.paging.SimpleProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r1
            goto L_0x00dd
        L_0x0035:
            java.lang.Object r1 = r14.L$3
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r4 = r14.L$2
            androidx.paging.PageFetcherSnapshotState$Holder r4 = (androidx.paging.PageFetcherSnapshotState.Holder) r4
            java.lang.Object r6 = r14.L$1
            androidx.paging.RemoteMediatorConnection r6 = (androidx.paging.RemoteMediatorConnection) r6
            java.lang.Object r7 = r14.L$0
            androidx.paging.SimpleProducerScope r7 = (androidx.paging.SimpleProducerScope) r7
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b3
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            androidx.paging.SimpleProducerScope r15 = (androidx.paging.SimpleProducerScope) r15
            androidx.paging.PageFetcherSnapshot<Key, Value> r1 = r14.this$0
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.i
            r12 = 0
            boolean r1 = r1.compareAndSet(r12, r4)
            if (r1 == 0) goto L_0x011a
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2 r9 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2
            androidx.paging.PageFetcherSnapshot<Key, Value> r1 = r14.this$0
            r9.<init>(r1, r15, r5)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            r6 = r15
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r6, r7, r8, r9, r10, r11)
            r1 = 6
            kotlinx.coroutines.channels.Channel r1 = kotlinx.coroutines.channels.ChannelKt.b(r12, r5, r5, r1, r5)
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3 r9 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3
            androidx.paging.PageFetcherSnapshot<Key, Value> r6 = r14.this$0
            r9.<init>(r6, r1, r5)
            r6 = r15
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r6, r7, r8, r9, r10, r11)
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r9 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4
            androidx.paging.PageFetcherSnapshot<Key, Value> r6 = r14.this$0
            r9.<init>(r1, r6, r5)
            r6 = r15
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r6, r7, r8, r9, r10, r11)
            androidx.paging.PageFetcherSnapshot<Key, Value> r1 = r14.this$0
            androidx.paging.RemoteMediatorConnection r6 = r1.w()
            if (r6 == 0) goto L_0x00ca
            androidx.paging.PageFetcherSnapshot<Key, Value> r1 = r14.this$0
            androidx.paging.PagingState r7 = r1.f
            if (r7 != 0) goto L_0x00c7
            androidx.paging.PageFetcherSnapshotState$Holder r1 = r1.k
            kotlinx.coroutines.sync.Mutex r7 = r1.b
            r14.L$0 = r15
            r14.L$1 = r6
            r14.L$2 = r1
            r14.L$3 = r7
            r14.label = r4
            java.lang.Object r4 = r7.c(r5, r14)
            if (r4 != r0) goto L_0x00b0
            return r0
        L_0x00b0:
            r4 = r1
            r1 = r7
            r7 = r15
        L_0x00b3:
            androidx.paging.PageFetcherSnapshotState r15 = r4.c     // Catch:{ all -> 0x00c2 }
            androidx.paging.PagingState r15 = r15.g(r5)     // Catch:{ all -> 0x00c2 }
            r1.d(r5)
            r13 = r7
            r7 = r15
            r15 = r13
            goto L_0x00c7
        L_0x00c2:
            r14 = move-exception
            r1.d(r5)
            throw r14
        L_0x00c7:
            r6.d(r7)
        L_0x00ca:
            androidx.paging.PageFetcherSnapshot<Key, Value> r1 = r14.this$0
            r14.L$0 = r15
            r14.L$1 = r5
            r14.L$2 = r5
            r14.L$3 = r5
            r14.label = r3
            java.lang.Object r1 = r1.s(r14)
            if (r1 != r0) goto L_0x00dd
            return r0
        L_0x00dd:
            androidx.paging.PageFetcherSnapshot<Key, Value> r1 = r14.this$0
            androidx.paging.PageFetcherSnapshotState$Holder r1 = r1.k
            kotlinx.coroutines.sync.Mutex r3 = r1.b
            r14.L$0 = r15
            r14.L$1 = r1
            r14.L$2 = r3
            r14.label = r2
            java.lang.Object r2 = r3.c(r5, r14)
            if (r2 != r0) goto L_0x00f6
            return r0
        L_0x00f6:
            r2 = r15
            r0 = r3
        L_0x00f8:
            androidx.paging.PageFetcherSnapshotState r15 = r1.c     // Catch:{ all -> 0x0115 }
            androidx.paging.MutableLoadStateCollection r15 = r15.p()     // Catch:{ all -> 0x0115 }
            androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0115 }
            androidx.paging.LoadState r15 = r15.a(r1)     // Catch:{ all -> 0x0115 }
            r0.d(r5)
            boolean r15 = r15 instanceof androidx.paging.LoadState.Error
            if (r15 != 0) goto L_0x0112
            androidx.paging.PageFetcherSnapshot<Key, Value> r14 = r14.this$0
            r14.E(r2)
        L_0x0112:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0115:
            r14 = move-exception
            r0.d(r5)
            throw r14
        L_0x011a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
