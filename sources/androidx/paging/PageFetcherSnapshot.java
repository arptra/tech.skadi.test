package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PageFetcherSnapshotState;
import androidx.paging.PagingSource;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@SourceDebugExtension({"SMAP\nPageFetcherSnapshot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageFetcherSnapshot.kt\nandroidx/paging/PageFetcherSnapshot\n+ 2 PageFetcherSnapshotState.kt\nandroidx/paging/PageFetcherSnapshotState$Holder\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 FlowExt.kt\nandroidx/paging/FlowExtKt\n+ 5 Logger.kt\nandroidx/paging/LoggerKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,638:1\n391#2:639\n392#2:648\n391#2:652\n392#2:661\n391#2:674\n392#2:683\n391#2:696\n392#2:705\n391#2:718\n392#2:727\n391#2:740\n392#2:749\n391#2:763\n392#2:772\n391#2:775\n392#2:784\n391#2:797\n392#2:806\n391#2:839\n392#2:848\n391#2:861\n392#2:870\n391#2:873\n392#2:882\n107#3,8:640\n116#3:649\n115#3:650\n107#3,8:653\n116#3:662\n115#3:663\n107#3,8:675\n116#3:684\n115#3:685\n107#3,8:697\n116#3:706\n115#3:707\n107#3,8:719\n116#3:728\n115#3:729\n107#3,8:741\n116#3:750\n115#3:751\n107#3,8:764\n116#3:773\n115#3:774\n107#3,8:776\n116#3:785\n115#3:786\n107#3,8:798\n116#3:807\n115#3:808\n107#3,8:840\n116#3:849\n115#3:850\n107#3,8:862\n116#3:871\n115#3:872\n107#3,8:874\n116#3:883\n115#3:884\n99#4:651\n41#5,10:664\n41#5,10:686\n41#5,10:708\n41#5,10:730\n41#5,10:752\n41#5,10:787\n41#5,10:809\n41#5,10:819\n41#5,10:829\n41#5,10:851\n1#6:762\n*S KotlinDebug\n*F\n+ 1 PageFetcherSnapshot.kt\nandroidx/paging/PageFetcherSnapshot\n*L\n210#1:639\n210#1:648\n284#1:652\n284#1:661\n294#1:674\n294#1:683\n324#1:696\n324#1:705\n336#1:718\n336#1:727\n352#1:740\n352#1:749\n374#1:763\n374#1:772\n410#1:775\n410#1:784\n446#1:797\n446#1:806\n470#1:839\n470#1:848\n492#1:861\n492#1:870\n527#1:873\n527#1:882\n210#1:640,8\n210#1:649\n210#1:650\n284#1:653,8\n284#1:662\n284#1:663\n294#1:675,8\n294#1:684\n294#1:685\n324#1:697,8\n324#1:706\n324#1:707\n336#1:719,8\n336#1:728\n336#1:729\n352#1:741,8\n352#1:750\n352#1:751\n374#1:764,8\n374#1:773\n374#1:774\n410#1:776,8\n410#1:785\n410#1:786\n446#1:798,8\n446#1:807\n446#1:808\n470#1:840,8\n470#1:849\n470#1:850\n492#1:862,8\n492#1:871\n492#1:872\n527#1:874,8\n527#1:883\n527#1:884\n251#1:651\n288#1:664,10\n322#1:686,10\n330#1:708,10\n351#1:730,10\n358#1:752,10\n423#1:787,10\n452#1:809,10\n456#1:819,10\n469#1:829,10\n481#1:851,10\n*E\n"})
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B{\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\n*\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\u0015\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J#\u0010(\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J7\u0010.\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00018\u00002\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010+H\u0002¢\u0006\u0004\b.\u0010/J+\u00101\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001002\u0006\u0010\u0015\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b1\u00102J3\u00105\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00104\u001a\u000203H@ø\u0001\u0000¢\u0006\u0004\b5\u00106J9\u00109\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001dH\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\nH\u0002¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\n¢\u0006\u0004\b?\u0010<J\u001f\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH@ø\u0001\u0000¢\u0006\u0004\b@\u0010%R\u001c\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0000X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0000X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010X\u001a\u00020U8\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R \u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010^0]8\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R \u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010b8\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR#\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010^0\t8\u0006¢\u0006\f\n\u0004\bj\u0010L\u001a\u0004\bk\u0010l\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, d2 = {"Landroidx/paging/PageFetcherSnapshot;", "", "Key", "Value", "initialKey", "Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/PagingConfig;", "config", "Lkotlinx/coroutines/flow/Flow;", "", "retryFlow", "Landroidx/paging/RemoteMediatorConnection;", "remoteMediatorConnection", "Landroidx/paging/PagingState;", "previousPagingState", "Lkotlin/Function0;", "jumpCallback", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/PagingConfig;Lkotlinx/coroutines/flow/Flow;Landroidx/paging/RemoteMediatorConnection;Landroidx/paging/PagingState;Lkotlin/jvm/functions/Function0;)V", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/ViewportHint;", "viewportHint", "B", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "E", "(Lkotlinx/coroutines/CoroutineScope;)V", "", "q", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "Landroidx/paging/PagingSource$LoadParams;", "x", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "s", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/GenerationalViewportHint;", "generationalHint", "t", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadKey", "Landroidx/paging/PagingSource$LoadResult;", "result", "", "y", "(Landroidx/paging/LoadType;Ljava/lang/Object;Landroidx/paging/PagingSource$LoadResult;)Ljava/lang/String;", "Landroidx/paging/PageFetcherSnapshotState;", "D", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/LoadState$Error;", "error", "C", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Landroidx/paging/LoadState$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generationId", "presentedItemsBeyondAnchor", "z", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "A", "()V", "o", "(Landroidx/paging/ViewportHint;)V", "p", "r", "a", "Ljava/lang/Object;", "getInitialKey$paging_common", "()Ljava/lang/Object;", "b", "Landroidx/paging/PagingSource;", "v", "()Landroidx/paging/PagingSource;", "c", "Landroidx/paging/PagingConfig;", "d", "Lkotlinx/coroutines/flow/Flow;", "e", "Landroidx/paging/RemoteMediatorConnection;", "w", "()Landroidx/paging/RemoteMediatorConnection;", "f", "Landroidx/paging/PagingState;", "g", "Lkotlin/jvm/functions/Function0;", "Landroidx/paging/HintHandler;", "h", "Landroidx/paging/HintHandler;", "hintHandler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageEventChCollected", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageEvent;", "j", "Lkotlinx/coroutines/channels/Channel;", "pageEventCh", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "k", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "stateHolder", "Lkotlinx/coroutines/CompletableJob;", "l", "Lkotlinx/coroutines/CompletableJob;", "pageEventChannelFlowJob", "m", "u", "()Lkotlinx/coroutines/flow/Flow;", "pageEventFlow", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PageFetcherSnapshot<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1576a;
    public final PagingSource b;
    public final PagingConfig c;
    public final Flow d;
    public final RemoteMediatorConnection e;
    public final PagingState f;
    public final Function0 g;
    public final HintHandler h;
    public final AtomicBoolean i;
    public final Channel j;
    public final PageFetcherSnapshotState.Holder k;
    public final CompletableJob l;
    public final Flow m;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.paging.LoadType[] r0 = androidx.paging.LoadType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.WhenMappings.<clinit>():void");
        }
    }

    public PageFetcherSnapshot(Object obj, PagingSource pagingSource, PagingConfig pagingConfig, Flow flow, RemoteMediatorConnection remoteMediatorConnection, PagingState pagingState, Function0 function0) {
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(pagingConfig, "config");
        Intrinsics.checkNotNullParameter(flow, "retryFlow");
        Intrinsics.checkNotNullParameter(function0, "jumpCallback");
        this.f1576a = obj;
        this.b = pagingSource;
        this.c = pagingConfig;
        this.d = flow;
        this.e = remoteMediatorConnection;
        this.f = pagingState;
        this.g = function0;
        if (pagingConfig.f == Integer.MIN_VALUE || pagingSource.b()) {
            this.h = new HintHandler();
            this.i = new AtomicBoolean(false);
            this.j = ChannelKt.b(-2, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            this.k = new PageFetcherSnapshotState.Holder(pagingConfig);
            CompletableJob b2 = JobKt__JobKt.b((Job) null, 1, (Object) null);
            this.l = b2;
            this.m = FlowKt.M(CancelableChannelFlowKt.a(b2, new PageFetcherSnapshot$pageEventFlow$1(this, (Continuation<? super PageFetcherSnapshot$pageEventFlow$1>) null)), new PageFetcherSnapshot$pageEventFlow$2(this, (Continuation<? super PageFetcherSnapshot$pageEventFlow$2>) null));
            return;
        }
        throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
    }

    public final void A() {
        p();
        this.b.e();
    }

    public final Object B(LoadType loadType, ViewportHint viewportHint, Continuation continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
            Object s = s(continuation);
            return s == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? s : Unit.INSTANCE;
        } else if (viewportHint != null) {
            this.h.a(loadType, viewportHint);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
        }
    }

    public final Object C(PageFetcherSnapshotState pageFetcherSnapshotState, LoadType loadType, LoadState.Error error, Continuation continuation) {
        if (Intrinsics.areEqual((Object) pageFetcherSnapshotState.p().a(loadType), (Object) error)) {
            return Unit.INSTANCE;
        }
        pageFetcherSnapshotState.p().c(loadType, error);
        Object L = this.j.L(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.p().d(), (LoadStates) null), continuation);
        return L == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? L : Unit.INSTANCE;
    }

    public final Object D(PageFetcherSnapshotState pageFetcherSnapshotState, LoadType loadType, Continuation continuation) {
        LoadState a2 = pageFetcherSnapshotState.p().a(loadType);
        LoadState.Loading loading = LoadState.Loading.b;
        if (Intrinsics.areEqual((Object) a2, (Object) loading)) {
            return Unit.INSTANCE;
        }
        pageFetcherSnapshotState.p().c(loadType, loading);
        Object L = this.j.L(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.p().d(), (LoadStates) null), continuation);
        return L == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? L : Unit.INSTANCE;
    }

    public final void E(CoroutineScope coroutineScope) {
        if (this.c.f != Integer.MIN_VALUE) {
            Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PageFetcherSnapshot$startConsumingHints$1(this, (Continuation<? super PageFetcherSnapshot$startConsumingHints$1>) null), 3, (Object) null);
        }
        Job unused2 = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PageFetcherSnapshot$startConsumingHints$2(this, (Continuation<? super PageFetcherSnapshot$startConsumingHints$2>) null), 3, (Object) null);
        Job unused3 = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PageFetcherSnapshot$startConsumingHints$3(this, (Continuation<? super PageFetcherSnapshot$startConsumingHints$3>) null), 3, (Object) null);
    }

    public final void o(ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.h.d(viewportHint);
    }

    public final void p() {
        Job.DefaultImpls.a(this.l, (CancellationException) null, 1, (Object) null);
    }

    public final Object q(Flow flow, LoadType loadType, Continuation continuation) {
        Object collect = FlowKt.l(FlowExtKt.b(FlowExtKt.d(flow, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1((Continuation) null, this, loadType)), new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(loadType, (Continuation<? super PageFetcherSnapshot$collectAsGenerationalViewportHints$3>) null))).collect(new PageFetcherSnapshot$collectAsGenerationalViewportHints$4(this, loadType), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot$currentPagingState$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = (androidx.paging.PageFetcherSnapshot$currentPagingState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = new androidx.paging.PageFetcherSnapshot$currentPagingState$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r1 = r0.L$1
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r0 = r0.L$0
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r5
            r5 = r0
            goto L_0x0059
        L_0x0038:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.paging.PageFetcherSnapshotState$Holder r6 = r5.k
            kotlinx.coroutines.sync.Mutex r2 = r6.b
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r0 = r2.c(r4, r0)
            if (r0 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r1 = r6
        L_0x0059:
            androidx.paging.PageFetcherSnapshotState r6 = r1.c     // Catch:{ all -> 0x006b }
            androidx.paging.HintHandler r5 = r5.h     // Catch:{ all -> 0x006b }
            androidx.paging.ViewportHint$Access r5 = r5.b()     // Catch:{ all -> 0x006b }
            androidx.paging.PagingState r5 = r6.g(r5)     // Catch:{ all -> 0x006b }
            r2.d(r4)
            return r5
        L_0x006b:
            r5 = move-exception
            r2.d(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v41, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v48, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r0 = androidx.paging.PageFetcherSnapshotState.Holder.b(r3).g(r2.h.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0275, code lost:
        r1.d((java.lang.Object) null);
        r4 = (androidx.paging.PagingSource.LoadResult.Page) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x027e, code lost:
        if (r4.f() != null) goto L_0x0287;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0280, code lost:
        r2.e.e(androidx.paging.LoadType.PREPEND, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x028b, code lost:
        if (r4.e() != null) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x028d, code lost:
        r2.e.e(androidx.paging.LoadType.APPEND, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0296, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0297, code lost:
        r1.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x029a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x029b, code lost:
        r9.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x029e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02a1, code lost:
        if ((r1 instanceof androidx.paging.PagingSource.LoadResult.Error) == false) goto L_0x0307;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02a3, code lost:
        r4 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02a7, code lost:
        if (r4 == null) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02ad, code lost:
        if (r4.b(2) != true) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02af, code lost:
        r4.a(2, r0.y(androidx.paging.LoadType.REFRESH, r0.f1576a, r1), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02ba, code lost:
        r4 = r0.k;
        r5 = androidx.paging.PageFetcherSnapshotState.Holder.a(r4);
        r2.L$0 = r0;
        r2.L$1 = r1;
        r2.L$2 = r4;
        r2.L$3 = r5;
        r2.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02d0, code lost:
        if (r5.c((java.lang.Object) null, r2) != r3) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02d2, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02d3, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        r0 = androidx.paging.PageFetcherSnapshotState.Holder.b(r4);
        r4 = new androidx.paging.LoadState.Error(((androidx.paging.PagingSource.LoadResult.Error) r1).a());
        r1 = androidx.paging.LoadType.REFRESH;
        r2.L$0 = r5;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02f5, code lost:
        if (r6.C(r0, r1, r4, r2) != r3) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02f7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02f8, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02fb, code lost:
        r2.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0300, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0301, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0302, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0303, code lost:
        r2.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0306, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0309, code lost:
        if ((r1 instanceof androidx.paging.PagingSource.LoadResult.Invalid) == false) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x030b, code lost:
        r2 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x030f, code lost:
        if (r2 == null) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0315, code lost:
        if (r2.b(2) != true) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0317, code lost:
        r2.a(2, r0.y(androidx.paging.LoadType.REFRESH, r0.f1576a, r1), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0322, code lost:
        r0.A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0327, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0328, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0329, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x032a, code lost:
        r4.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x032d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r4 = androidx.paging.PageFetcherSnapshotState.Holder.b(r4);
        r9 = androidx.paging.LoadType.REFRESH;
        r2.L$0 = r0;
        r2.L$1 = r1;
        r2.L$2 = null;
        r2.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0106, code lost:
        if (r0.D(r4, r9, r2) != r3) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0108, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0109, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010c, code lost:
        r4.d((java.lang.Object) null);
        r1 = r0.x(androidx.paging.LoadType.REFRESH, r0.f1576a);
        r4 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011b, code lost:
        if (r4 == null) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0121, code lost:
        if (r4.b(3) != true) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0123, code lost:
        r4.a(3, "Start REFRESH with loadKey " + r0.f1576a + " on " + r0.b, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0143, code lost:
        r4 = r0.b;
        r2.L$0 = r0;
        r2.L$1 = null;
        r2.label = 3;
        r1 = r4.f(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x014f, code lost:
        if (r1 != r3) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0151, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0152, code lost:
        r1 = (androidx.paging.PagingSource.LoadResult) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0156, code lost:
        if ((r1 instanceof androidx.paging.PagingSource.LoadResult.Page) == false) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0158, code lost:
        r4 = r0.k;
        r9 = androidx.paging.PageFetcherSnapshotState.Holder.a(r4);
        r2.L$0 = r0;
        r2.L$1 = r1;
        r2.L$2 = r4;
        r2.L$3 = r9;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x016d, code lost:
        if (r9.c((java.lang.Object) null, r2) != r3) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x016f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0170, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r0 = androidx.paging.PageFetcherSnapshotState.Holder.b(r4);
        r4 = androidx.paging.LoadType.REFRESH;
        r11 = r0.r(0, r4, (androidx.paging.PagingSource.LoadResult.Page) r1);
        r12 = r0.p();
        r13 = androidx.paging.LoadState.NotLoading.b;
        r12.c(r4, r13.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0193, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r1).f() != null) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0195, code lost:
        r0.p().c(androidx.paging.LoadType.PREPEND, r13.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ad, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r1).e() != null) goto L_0x01bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01af, code lost:
        r0.p().c(androidx.paging.LoadType.APPEND, r13.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01bc, code lost:
        r9.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01bf, code lost:
        if (r11 == false) goto L_0x0223;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01c1, code lost:
        r0 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01c5, code lost:
        if (r0 == null) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01cb, code lost:
        if (r0.b(3) != true) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01cd, code lost:
        r0.a(3, r10.y(r4, r10.f1576a, r1), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01d6, code lost:
        r4 = r10.k;
        r0 = androidx.paging.PageFetcherSnapshotState.Holder.a(r4);
        r2.L$0 = r10;
        r2.L$1 = r1;
        r2.L$2 = r4;
        r2.L$3 = r0;
        r2.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01eb, code lost:
        if (r0.c((java.lang.Object) null, r2) != r3) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ed, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ee, code lost:
        r5 = r10;
        r16 = r1;
        r1 = r0;
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4 = androidx.paging.PageFetcherSnapshotState.Holder.b(r4);
        r6 = r5.j;
        r4 = r4.u((androidx.paging.PagingSource.LoadResult.Page) r0, androidx.paging.LoadType.REFRESH);
        r2.L$0 = r5;
        r2.L$1 = r0;
        r2.L$2 = r1;
        r2.L$3 = null;
        r2.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0212, code lost:
        if (r6.L(r4, r2) != r3) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0214, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0215, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0218, code lost:
        r4.d((java.lang.Object) null);
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x021d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x021e, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x021f, code lost:
        r4.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0222, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0223, code lost:
        r0 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0227, code lost:
        if (r0 == null) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x022d, code lost:
        if (r0.b(2) != true) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x022f, code lost:
        r0.a(2, r10.y(r4, r10.f1576a, (androidx.paging.PagingSource.LoadResult) null), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0238, code lost:
        r4 = r1;
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x023c, code lost:
        if (r5.e == null) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x023e, code lost:
        r0 = (androidx.paging.PagingSource.LoadResult.Page) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0245, code lost:
        if (r0.f() == null) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x024b, code lost:
        if (r0.e() != null) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x024d, code lost:
        r0 = r5.k;
        r1 = androidx.paging.PageFetcherSnapshotState.Holder.a(r0);
        r2.L$0 = r5;
        r2.L$1 = r4;
        r2.L$2 = r0;
        r2.L$3 = r1;
        r2.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0262, code lost:
        if (r1.c((java.lang.Object) null, r2) != r3) goto L_0x0265;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0264, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0265, code lost:
        r3 = r0;
        r2 = r5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(kotlin.coroutines.Continuation r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof androidx.paging.PageFetcherSnapshot$doInitialLoad$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            androidx.paging.PageFetcherSnapshot$doInitialLoad$1 r2 = (androidx.paging.PageFetcherSnapshot$doInitialLoad$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            androidx.paging.PageFetcherSnapshot$doInitialLoad$1 r2 = new androidx.paging.PageFetcherSnapshot$doInitialLoad$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            switch(r4) {
                case 0: goto L_0x00dc;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00b1;
                case 4: goto L_0x009a;
                case 5: goto L_0x0082;
                case 6: goto L_0x006d;
                case 7: goto L_0x0057;
                case 8: goto L_0x0040;
                case 9: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0033:
            java.lang.Object r0 = r2.L$0
            r2 = r0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x003d }
            goto L_0x02f9
        L_0x003d:
            r0 = move-exception
            goto L_0x0303
        L_0x0040:
            java.lang.Object r0 = r2.L$3
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r4 = r2.L$2
            androidx.paging.PageFetcherSnapshotState$Holder r4 = (androidx.paging.PageFetcherSnapshotState.Holder) r4
            java.lang.Object r5 = r2.L$1
            androidx.paging.PagingSource$LoadResult r5 = (androidx.paging.PagingSource.LoadResult) r5
            java.lang.Object r6 = r2.L$0
            androidx.paging.PageFetcherSnapshot r6 = (androidx.paging.PageFetcherSnapshot) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r5
            r5 = r0
            goto L_0x02d4
        L_0x0057:
            java.lang.Object r0 = r2.L$3
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r3 = r2.L$2
            androidx.paging.PageFetcherSnapshotState$Holder r3 = (androidx.paging.PageFetcherSnapshotState.Holder) r3
            java.lang.Object r4 = r2.L$1
            androidx.paging.PagingSource$LoadResult r4 = (androidx.paging.PagingSource.LoadResult) r4
            java.lang.Object r2 = r2.L$0
            androidx.paging.PageFetcherSnapshot r2 = (androidx.paging.PageFetcherSnapshot) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            goto L_0x0267
        L_0x006d:
            java.lang.Object r0 = r2.L$2
            r4 = r0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r0 = r2.L$1
            androidx.paging.PagingSource$LoadResult r0 = (androidx.paging.PagingSource.LoadResult) r0
            java.lang.Object r5 = r2.L$0
            androidx.paging.PageFetcherSnapshot r5 = (androidx.paging.PageFetcherSnapshot) r5
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x007f }
            goto L_0x0216
        L_0x007f:
            r0 = move-exception
            goto L_0x021f
        L_0x0082:
            java.lang.Object r0 = r2.L$3
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r4 = r2.L$2
            androidx.paging.PageFetcherSnapshotState$Holder r4 = (androidx.paging.PageFetcherSnapshotState.Holder) r4
            java.lang.Object r5 = r2.L$1
            androidx.paging.PagingSource$LoadResult r5 = (androidx.paging.PagingSource.LoadResult) r5
            java.lang.Object r6 = r2.L$0
            androidx.paging.PageFetcherSnapshot r6 = (androidx.paging.PageFetcherSnapshot) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r0 = r5
            r5 = r6
            goto L_0x01f4
        L_0x009a:
            java.lang.Object r0 = r2.L$3
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r4 = r2.L$2
            androidx.paging.PageFetcherSnapshotState$Holder r4 = (androidx.paging.PageFetcherSnapshotState.Holder) r4
            java.lang.Object r9 = r2.L$1
            androidx.paging.PagingSource$LoadResult r9 = (androidx.paging.PagingSource.LoadResult) r9
            java.lang.Object r10 = r2.L$0
            androidx.paging.PageFetcherSnapshot r10 = (androidx.paging.PageFetcherSnapshot) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r9
            r9 = r0
            goto L_0x0171
        L_0x00b1:
            java.lang.Object r0 = r2.L$0
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0152
        L_0x00ba:
            java.lang.Object r0 = r2.L$1
            r4 = r0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r0 = r2.L$0
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x00c7 }
            goto L_0x010a
        L_0x00c7:
            r0 = move-exception
            goto L_0x032a
        L_0x00ca:
            java.lang.Object r0 = r2.L$2
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r4 = r2.L$1
            androidx.paging.PageFetcherSnapshotState$Holder r4 = (androidx.paging.PageFetcherSnapshotState.Holder) r4
            java.lang.Object r9 = r2.L$0
            androidx.paging.PageFetcherSnapshot r9 = (androidx.paging.PageFetcherSnapshot) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r0 = r9
            goto L_0x00f4
        L_0x00dc:
            kotlin.ResultKt.throwOnFailure(r1)
            androidx.paging.PageFetcherSnapshotState$Holder r4 = r0.k
            kotlinx.coroutines.sync.Mutex r1 = r4.b
            r2.L$0 = r0
            r2.L$1 = r4
            r2.L$2 = r1
            r2.label = r7
            java.lang.Object r9 = r1.c(r8, r2)
            if (r9 != r3) goto L_0x00f4
            return r3
        L_0x00f4:
            androidx.paging.PageFetcherSnapshotState r4 = r4.c     // Catch:{ all -> 0x0328 }
            androidx.paging.LoadType r9 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0328 }
            r2.L$0 = r0     // Catch:{ all -> 0x0328 }
            r2.L$1 = r1     // Catch:{ all -> 0x0328 }
            r2.L$2 = r8     // Catch:{ all -> 0x0328 }
            r2.label = r6     // Catch:{ all -> 0x0328 }
            java.lang.Object r4 = r0.D(r4, r9, r2)     // Catch:{ all -> 0x0328 }
            if (r4 != r3) goto L_0x0109
            return r3
        L_0x0109:
            r4 = r1
        L_0x010a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c7 }
            r4.d(r8)
            androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH
            java.lang.Object r4 = r0.f1576a
            androidx.paging.PagingSource$LoadParams r1 = r0.x(r1, r4)
            androidx.paging.Logger r4 = androidx.paging.LoggerKt.a()
            if (r4 == 0) goto L_0x0143
            boolean r9 = r4.b(r5)
            if (r9 != r7) goto L_0x0143
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Start REFRESH with loadKey "
            r9.append(r10)
            java.lang.Object r10 = r0.f1576a
            r9.append(r10)
            java.lang.String r10 = " on "
            r9.append(r10)
            androidx.paging.PagingSource r10 = r0.b
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r4.a(r5, r9, r8)
        L_0x0143:
            androidx.paging.PagingSource r4 = r0.b
            r2.L$0 = r0
            r2.L$1 = r8
            r2.label = r5
            java.lang.Object r1 = r4.f(r1, r2)
            if (r1 != r3) goto L_0x0152
            return r3
        L_0x0152:
            androidx.paging.PagingSource$LoadResult r1 = (androidx.paging.PagingSource.LoadResult) r1
            boolean r4 = r1 instanceof androidx.paging.PagingSource.LoadResult.Page
            if (r4 == 0) goto L_0x029f
            androidx.paging.PageFetcherSnapshotState$Holder r4 = r0.k
            kotlinx.coroutines.sync.Mutex r9 = r4.b
            r2.L$0 = r0
            r2.L$1 = r1
            r2.L$2 = r4
            r2.L$3 = r9
            r10 = 4
            r2.label = r10
            java.lang.Object r10 = r9.c(r8, r2)
            if (r10 != r3) goto L_0x0170
            return r3
        L_0x0170:
            r10 = r0
        L_0x0171:
            androidx.paging.PageFetcherSnapshotState r0 = r4.c     // Catch:{ all -> 0x01a3 }
            androidx.paging.LoadType r4 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x01a3 }
            r11 = r1
            androidx.paging.PagingSource$LoadResult$Page r11 = (androidx.paging.PagingSource.LoadResult.Page) r11     // Catch:{ all -> 0x01a3 }
            r12 = 0
            boolean r11 = r0.r(r12, r4, r11)     // Catch:{ all -> 0x01a3 }
            androidx.paging.MutableLoadStateCollection r12 = r0.p()     // Catch:{ all -> 0x01a3 }
            androidx.paging.LoadState$NotLoading$Companion r13 = androidx.paging.LoadState.NotLoading.b     // Catch:{ all -> 0x01a3 }
            androidx.paging.LoadState$NotLoading r14 = r13.b()     // Catch:{ all -> 0x01a3 }
            r12.c(r4, r14)     // Catch:{ all -> 0x01a3 }
            r12 = r1
            androidx.paging.PagingSource$LoadResult$Page r12 = (androidx.paging.PagingSource.LoadResult.Page) r12     // Catch:{ all -> 0x01a3 }
            java.lang.Object r12 = r12.f()     // Catch:{ all -> 0x01a3 }
            if (r12 != 0) goto L_0x01a6
            androidx.paging.MutableLoadStateCollection r12 = r0.p()     // Catch:{ all -> 0x01a3 }
            androidx.paging.LoadType r14 = androidx.paging.LoadType.PREPEND     // Catch:{ all -> 0x01a3 }
            androidx.paging.LoadState$NotLoading r15 = r13.a()     // Catch:{ all -> 0x01a3 }
            r12.c(r14, r15)     // Catch:{ all -> 0x01a3 }
            goto L_0x01a6
        L_0x01a3:
            r0 = move-exception
            goto L_0x029b
        L_0x01a6:
            r12 = r1
            androidx.paging.PagingSource$LoadResult$Page r12 = (androidx.paging.PagingSource.LoadResult.Page) r12     // Catch:{ all -> 0x01a3 }
            java.lang.Object r12 = r12.e()     // Catch:{ all -> 0x01a3 }
            if (r12 != 0) goto L_0x01bc
            androidx.paging.MutableLoadStateCollection r0 = r0.p()     // Catch:{ all -> 0x01a3 }
            androidx.paging.LoadType r12 = androidx.paging.LoadType.APPEND     // Catch:{ all -> 0x01a3 }
            androidx.paging.LoadState$NotLoading r13 = r13.a()     // Catch:{ all -> 0x01a3 }
            r0.c(r12, r13)     // Catch:{ all -> 0x01a3 }
        L_0x01bc:
            r9.d(r8)
            if (r11 == 0) goto L_0x0223
            androidx.paging.Logger r0 = androidx.paging.LoggerKt.a()
            if (r0 == 0) goto L_0x01d6
            boolean r6 = r0.b(r5)
            if (r6 != r7) goto L_0x01d6
            java.lang.Object r6 = r10.f1576a
            java.lang.String r4 = r10.y(r4, r6, r1)
            r0.a(r5, r4, r8)
        L_0x01d6:
            androidx.paging.PageFetcherSnapshotState$Holder r4 = r10.k
            kotlinx.coroutines.sync.Mutex r0 = r4.b
            r2.L$0 = r10
            r2.L$1 = r1
            r2.L$2 = r4
            r2.L$3 = r0
            r5 = 5
            r2.label = r5
            java.lang.Object r5 = r0.c(r8, r2)
            if (r5 != r3) goto L_0x01ee
            return r3
        L_0x01ee:
            r5 = r10
            r16 = r1
            r1 = r0
            r0 = r16
        L_0x01f4:
            androidx.paging.PageFetcherSnapshotState r4 = r4.c     // Catch:{ all -> 0x021d }
            kotlinx.coroutines.channels.Channel r6 = r5.j     // Catch:{ all -> 0x021d }
            r7 = r0
            androidx.paging.PagingSource$LoadResult$Page r7 = (androidx.paging.PagingSource.LoadResult.Page) r7     // Catch:{ all -> 0x021d }
            androidx.paging.LoadType r9 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x021d }
            androidx.paging.PageEvent r4 = r4.u(r7, r9)     // Catch:{ all -> 0x021d }
            r2.L$0 = r5     // Catch:{ all -> 0x021d }
            r2.L$1 = r0     // Catch:{ all -> 0x021d }
            r2.L$2 = r1     // Catch:{ all -> 0x021d }
            r2.L$3 = r8     // Catch:{ all -> 0x021d }
            r7 = 6
            r2.label = r7     // Catch:{ all -> 0x021d }
            java.lang.Object r4 = r6.L(r4, r2)     // Catch:{ all -> 0x021d }
            if (r4 != r3) goto L_0x0215
            return r3
        L_0x0215:
            r4 = r1
        L_0x0216:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007f }
            r4.d(r8)
            r4 = r0
            goto L_0x023a
        L_0x021d:
            r0 = move-exception
            r4 = r1
        L_0x021f:
            r4.d(r8)
            throw r0
        L_0x0223:
            androidx.paging.Logger r0 = androidx.paging.LoggerKt.a()
            if (r0 == 0) goto L_0x0238
            boolean r5 = r0.b(r6)
            if (r5 != r7) goto L_0x0238
            java.lang.Object r5 = r10.f1576a
            java.lang.String r4 = r10.y(r4, r5, r8)
            r0.a(r6, r4, r8)
        L_0x0238:
            r4 = r1
            r5 = r10
        L_0x023a:
            androidx.paging.RemoteMediatorConnection r0 = r5.e
            if (r0 == 0) goto L_0x0325
            r0 = r4
            androidx.paging.PagingSource$LoadResult$Page r0 = (androidx.paging.PagingSource.LoadResult.Page) r0
            java.lang.Object r1 = r0.f()
            if (r1 == 0) goto L_0x024d
            java.lang.Object r0 = r0.e()
            if (r0 != 0) goto L_0x0325
        L_0x024d:
            androidx.paging.PageFetcherSnapshotState$Holder r0 = r5.k
            kotlinx.coroutines.sync.Mutex r1 = r0.b
            r2.L$0 = r5
            r2.L$1 = r4
            r2.L$2 = r0
            r2.L$3 = r1
            r6 = 7
            r2.label = r6
            java.lang.Object r2 = r1.c(r8, r2)
            if (r2 != r3) goto L_0x0265
            return r3
        L_0x0265:
            r3 = r0
            r2 = r5
        L_0x0267:
            androidx.paging.PageFetcherSnapshotState r0 = r3.c     // Catch:{ all -> 0x0296 }
            androidx.paging.HintHandler r3 = r2.h     // Catch:{ all -> 0x0296 }
            androidx.paging.ViewportHint$Access r3 = r3.b()     // Catch:{ all -> 0x0296 }
            androidx.paging.PagingState r0 = r0.g(r3)     // Catch:{ all -> 0x0296 }
            r1.d(r8)
            androidx.paging.PagingSource$LoadResult$Page r4 = (androidx.paging.PagingSource.LoadResult.Page) r4
            java.lang.Object r1 = r4.f()
            if (r1 != 0) goto L_0x0287
            androidx.paging.RemoteMediatorConnection r1 = r2.e
            androidx.paging.LoadType r3 = androidx.paging.LoadType.PREPEND
            r1.e(r3, r0)
        L_0x0287:
            java.lang.Object r1 = r4.e()
            if (r1 != 0) goto L_0x0325
            androidx.paging.RemoteMediatorConnection r1 = r2.e
            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
            r1.e(r2, r0)
            goto L_0x0325
        L_0x0296:
            r0 = move-exception
            r1.d(r8)
            throw r0
        L_0x029b:
            r9.d(r8)
            throw r0
        L_0x029f:
            boolean r4 = r1 instanceof androidx.paging.PagingSource.LoadResult.Error
            if (r4 == 0) goto L_0x0307
            androidx.paging.Logger r4 = androidx.paging.LoggerKt.a()
            if (r4 == 0) goto L_0x02ba
            boolean r5 = r4.b(r6)
            if (r5 != r7) goto L_0x02ba
            androidx.paging.LoadType r5 = androidx.paging.LoadType.REFRESH
            java.lang.Object r7 = r0.f1576a
            java.lang.String r5 = r0.y(r5, r7, r1)
            r4.a(r6, r5, r8)
        L_0x02ba:
            androidx.paging.PageFetcherSnapshotState$Holder r4 = r0.k
            kotlinx.coroutines.sync.Mutex r5 = r4.b
            r2.L$0 = r0
            r2.L$1 = r1
            r2.L$2 = r4
            r2.L$3 = r5
            r6 = 8
            r2.label = r6
            java.lang.Object r6 = r5.c(r8, r2)
            if (r6 != r3) goto L_0x02d3
            return r3
        L_0x02d3:
            r6 = r0
        L_0x02d4:
            androidx.paging.PageFetcherSnapshotState r0 = r4.c     // Catch:{ all -> 0x0301 }
            androidx.paging.LoadState$Error r4 = new androidx.paging.LoadState$Error     // Catch:{ all -> 0x0301 }
            androidx.paging.PagingSource$LoadResult$Error r1 = (androidx.paging.PagingSource.LoadResult.Error) r1     // Catch:{ all -> 0x0301 }
            java.lang.Throwable r1 = r1.a()     // Catch:{ all -> 0x0301 }
            r4.<init>(r1)     // Catch:{ all -> 0x0301 }
            androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0301 }
            r2.L$0 = r5     // Catch:{ all -> 0x0301 }
            r2.L$1 = r8     // Catch:{ all -> 0x0301 }
            r2.L$2 = r8     // Catch:{ all -> 0x0301 }
            r2.L$3 = r8     // Catch:{ all -> 0x0301 }
            r7 = 9
            r2.label = r7     // Catch:{ all -> 0x0301 }
            java.lang.Object r0 = r6.C(r0, r1, r4, r2)     // Catch:{ all -> 0x0301 }
            if (r0 != r3) goto L_0x02f8
            return r3
        L_0x02f8:
            r2 = r5
        L_0x02f9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003d }
            r2.d(r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0301:
            r0 = move-exception
            r2 = r5
        L_0x0303:
            r2.d(r8)
            throw r0
        L_0x0307:
            boolean r2 = r1 instanceof androidx.paging.PagingSource.LoadResult.Invalid
            if (r2 == 0) goto L_0x0325
            androidx.paging.Logger r2 = androidx.paging.LoggerKt.a()
            if (r2 == 0) goto L_0x0322
            boolean r3 = r2.b(r6)
            if (r3 != r7) goto L_0x0322
            androidx.paging.LoadType r3 = androidx.paging.LoadType.REFRESH
            java.lang.Object r4 = r0.f1576a
            java.lang.String r1 = r0.y(r3, r4, r1)
            r2.a(r6, r1, r8)
        L_0x0322:
            r0.A()
        L_0x0325:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0328:
            r0 = move-exception
            r4 = r1
        L_0x032a:
            r4.d(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v90, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: type inference failed for: r2v19, types: [java.lang.Throwable, androidx.paging.PagingSource$LoadResult, java.lang.Object] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x03cf, code lost:
        r2 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x03d8, code lost:
        if (r2 == 2) goto L_0x03eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x03db, code lost:
        if (r2 != 3) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x03dd, code lost:
        r2 = ((androidx.paging.PagingSource.LoadResult.Page) r1).e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x03ea, code lost:
        throw new java.lang.IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x03eb, code lost:
        r2 = ((androidx.paging.PagingSource.LoadResult.Page) r1).f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03f8, code lost:
        if (r8.b.c() != false) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0400, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, (java.lang.Object) r10.element) != false) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0405, code lost:
        if (r13 != androidx.paging.LoadType.PREPEND) goto L_0x040a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0407, code lost:
        r0 = "prevKey";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x040a, code lost:
        r0 = "nextKey";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x043a, code lost:
        throw new java.lang.IllegalStateException(kotlin.text.StringsKt.trimMargin$default("The same value, " + r10.element + ", was passed as the " + r0 + " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            ", (java.lang.String) null, r3, (java.lang.Object) null).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x043b, code lost:
        r2 = r8.k;
        r6 = androidx.paging.PageFetcherSnapshotState.Holder.a(r2);
        r4.L$0 = r8;
        r4.L$1 = r13;
        r4.L$2 = r12;
        r4.L$3 = r11;
        r4.L$4 = r10;
        r4.L$5 = r9;
        r4.L$6 = r0;
        r4.L$7 = r1;
        r4.L$8 = r2;
        r4.L$9 = r6;
        r4.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x045d, code lost:
        if (r6.c((java.lang.Object) null, r4) != r5) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x045f, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0460, code lost:
        r14 = r8;
        r8 = r0;
        r0 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0477, code lost:
        if (androidx.paging.PageFetcherSnapshotState.Holder.b(r1).r(r12.a(), r13, (androidx.paging.PagingSource.LoadResult.Page) r0) != false) goto L_0x0491;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0479, code lost:
        r0 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x047d, code lost:
        if (r0 == null) goto L_0x0701;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0484, code lost:
        if (r0.b(2) != r3) goto L_0x0701;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0486, code lost:
        r0.a(2, r14.y(r13, r10.element, r2), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0491, code lost:
        r1 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0496, code lost:
        if (r1 == null) goto L_0x04a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x049c, code lost:
        if (r1.b(3) != r3) goto L_0x04a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x049e, code lost:
        r1.a(3, r14.y(r13, r10.element, r0), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x04a8, code lost:
        r6 = (androidx.paging.PagingSource.LoadResult.Page) r0;
        r11.element += r6.b().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x04ba, code lost:
        if (r13 != androidx.paging.LoadType.PREPEND) goto L_0x04c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x04c0, code lost:
        if (r6.f() == null) goto L_0x04cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x04c4, code lost:
        if (r13 != androidx.paging.LoadType.APPEND) goto L_0x04ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x04ca, code lost:
        if (r6.e() != null) goto L_0x04ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x04cc, code lost:
        r9.element = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x04ce, code lost:
        r1 = r0;
        r0 = r8;
        r8 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x04d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x04d4, code lost:
        r6.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x04d8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x04dd, code lost:
        if ((r1 instanceof androidx.paging.PagingSource.LoadResult.Error) == false) goto L_0x055d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x04df, code lost:
        r0 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x04e3, code lost:
        if (r0 == null) goto L_0x04f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x04ea, code lost:
        if (r0.b(2) != r3) goto L_0x04f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x04ec, code lost:
        r0.a(2, r8.y(r13, r10.element, r1), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x04f5, code lost:
        r0 = r8.k;
        r2 = androidx.paging.PageFetcherSnapshotState.Holder.a(r0);
        r4.L$0 = r8;
        r4.L$1 = r13;
        r4.L$2 = r12;
        r4.L$3 = r1;
        r4.L$4 = r0;
        r4.L$5 = r2;
        r4.L$6 = null;
        r4.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0511, code lost:
        if (r2.c((java.lang.Object) null, r4) != r5) goto L_0x0514;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0513, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0514, code lost:
        r3 = r1;
        r1 = r0;
        r0 = r4;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0095, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r1 = androidx.paging.PageFetcherSnapshotState.Holder.b(r1);
        r6 = new androidx.paging.LoadState.Error(((androidx.paging.PagingSource.LoadResult.Error) r3).a());
        r0.L$0 = r4;
        r0.L$1 = r12;
        r0.L$2 = r2;
        r0.L$3 = r1;
        r0.L$4 = null;
        r0.L$5 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x053b, code lost:
        if (r8.C(r1, r4, r6, r0) != r5) goto L_0x053e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x053d, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x053e, code lost:
        r0 = r1;
        r1 = r2;
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        r0.k().put(r4, r3.b());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x054e, code lost:
        r1.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0554, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0555, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0556, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0559, code lost:
        r1.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x055c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0560, code lost:
        if ((r1 instanceof androidx.paging.PagingSource.LoadResult.Invalid) == false) goto L_0x057e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0562, code lost:
        r0 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0566, code lost:
        if (r0 == null) goto L_0x0578;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x056d, code lost:
        if (r0.b(2) != r3) goto L_0x0578;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x056f, code lost:
        r0.a(2, r8.y(r13, r10.element, r1), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0578, code lost:
        r8.A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x057d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0587, code lost:
        if (androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0[r13.ordinal()] != 2) goto L_0x058c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0589, code lost:
        r6 = androidx.paging.LoadType.APPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x058c, code lost:
        r6 = androidx.paging.LoadType.PREPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x058e, code lost:
        r15 = r8.k;
        r2 = androidx.paging.PageFetcherSnapshotState.Holder.a(r15);
        r4.L$0 = r8;
        r4.L$1 = r13;
        r4.L$2 = r12;
        r4.L$3 = r11;
        r4.L$4 = r10;
        r4.L$5 = r9;
        r4.L$6 = r0;
        r4.L$7 = r1;
        r4.L$8 = r6;
        r4.L$9 = r15;
        r4.L$10 = r2;
        r4.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x05b3, code lost:
        if (r2.c((java.lang.Object) null, r4) != r5) goto L_0x05b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x05b5, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x05b6, code lost:
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r16 = r8;
        r8 = r1;
        r1 = r15;
        r15 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:?, code lost:
        r1 = androidx.paging.PageFetcherSnapshotState.Holder.b(r1);
        r3 = r1.i(r6, r13.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x05cb, code lost:
        if (r3 == null) goto L_0x0603;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x05cd, code lost:
        r1.h(r3);
        r6 = r15.j;
        r4.L$0 = r15;
        r4.L$1 = r14;
        r4.L$2 = r13;
        r4.L$3 = r12;
        r4.L$4 = r10;
        r4.L$5 = r9;
        r4.L$6 = r0;
        r4.L$7 = r8;
        r4.L$8 = r2;
        r4.L$9 = r1;
        r4.L$10 = null;
        r4.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x05f1, code lost:
        if (r6.L(r3, r4) != r5) goto L_0x05f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x05f3, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x05f4, code lost:
        r6 = r8;
        r8 = r0;
        r0 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x05fa, code lost:
        r2 = r1;
        r1 = r0;
        r0 = r6;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x05ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0600, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0603, code lost:
        r6 = r0;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:?, code lost:
        r3 = r15.z(r1, r14, r13.a(), r13.b().e(r14) + r12.element);
        r10.element = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x061a, code lost:
        if (r3 != null) goto L_0x0640;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0626, code lost:
        if ((r1.p().a(r14) instanceof androidx.paging.LoadState.Error) != false) goto L_0x0640;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0628, code lost:
        r3 = r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x062e, code lost:
        if (r9.element == false) goto L_0x0637;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0630, code lost:
        r8 = androidx.paging.LoadState.NotLoading.b.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0637, code lost:
        r8 = androidx.paging.LoadState.NotLoading.b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x063d, code lost:
        r3.c(r14, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0640, code lost:
        r1 = r1.u((androidx.paging.PagingSource.LoadResult.Page) r0, r14);
        r3 = r15.j;
        r4.L$0 = r15;
        r4.L$1 = r14;
        r4.L$2 = r13;
        r4.L$3 = r12;
        r4.L$4 = r10;
        r4.L$5 = r9;
        r4.L$6 = r6;
        r4.L$7 = r0;
        r4.L$8 = r2;
        r4.L$9 = null;
        r4.L$10 = null;
        r4.label = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0668, code lost:
        if (r3.L(r1, r4) != r5) goto L_0x066b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x066a, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x066b, code lost:
        r1 = r2;
        r8 = r9;
        r9 = r10;
        r10 = r13;
        r11 = r14;
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:?, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0673, code lost:
        r1.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0679, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadParams.Prepend) == false) goto L_0x0686;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0682, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r0).f() != null) goto L_0x0686;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0684, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0686, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0689, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadParams.Append) == false) goto L_0x0695;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0691, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r0).e() != null) goto L_0x0695;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0693, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0695, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0698, code lost:
        if (r14.e == null) goto L_0x06f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x069a, code lost:
        if (r1 != 0) goto L_0x069e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x069c, code lost:
        if (r0 == 0) goto L_0x06f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x069e, code lost:
        r2 = r14.k;
        r6 = androidx.paging.PageFetcherSnapshotState.Holder.a(r2);
        r4.L$0 = r14;
        r4.L$1 = r11;
        r4.L$2 = r10;
        r4.L$3 = r12;
        r4.L$4 = r9;
        r4.L$5 = r8;
        r4.L$6 = r2;
        r4.L$7 = r6;
        r4.L$8 = null;
        r4.I$0 = r1;
        r4.I$1 = r0;
        r4.label = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x06c3, code lost:
        if (r6.c((java.lang.Object) null, r4) != r5) goto L_0x06c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x06c5, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x06c6, code lost:
        r13 = r8;
        r8 = r9;
        r9 = r12;
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        r2 = androidx.paging.PageFetcherSnapshotState.Holder.b(r12).g(r14.h.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x06dc, code lost:
        if (r1 == 0) goto L_0x06e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x06de, code lost:
        r14.e.e(androidx.paging.LoadType.PREPEND, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x06e5, code lost:
        if (r0 == 0) goto L_0x06ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x06e7, code lost:
        r14.e.e(androidx.paging.LoadType.APPEND, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x06ee, code lost:
        r0 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x06ef, code lost:
        r12 = r14;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x06f3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x06f4, code lost:
        r6.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x06f8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x06f9, code lost:
        r0 = r8;
        r8 = r9;
        r9 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x06fd, code lost:
        r1.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0700, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0703, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0704, code lost:
        r6.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0707, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x070d, code lost:
        throw new java.lang.IllegalStateException("Use doInitialLoad for LoadType == REFRESH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x070e, code lost:
        r2.d((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0711, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0202, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r6 = androidx.paging.PageFetcherSnapshotState.Holder.b(r6);
        r10 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0241, code lost:
        if (r10 == 1) goto L_0x0708;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0244, code lost:
        if (r10 == 2) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0247, code lost:
        if (r10 == 3) goto L_0x024b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x024b, code lost:
        r10 = (r6.l() + r8.b().b()) + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0259, code lost:
        if (r10 >= 0) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x025b, code lost:
        r9.element += r0.c.f1596a * (-r10);
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0268, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x026c, code lost:
        r11 = kotlin.collections.CollectionsKt.getLastIndex(r6.m());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0274, code lost:
        if (r10 > r11) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0276, code lost:
        r9.element += ((androidx.paging.PagingSource.LoadResult.Page) r6.m().get(r10)).b().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x028d, code lost:
        if (r10 == r11) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x028f, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0291, code lost:
        r10 = (r6.l() + r8.b().a()) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x02a7, code lost:
        if (r10 <= kotlin.collections.CollectionsKt.getLastIndex(r6.m())) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02a9, code lost:
        r9.element += r0.c.f1596a * (r10 - kotlin.collections.CollectionsKt.getLastIndex(r6.m()));
        r10 = kotlin.collections.CollectionsKt.getLastIndex(r6.m());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x02c4, code lost:
        if (r10 < 0) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02c6, code lost:
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02c7, code lost:
        r9.element += ((androidx.paging.PagingSource.LoadResult.Page) r6.m().get(r11)).b().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02de, code lost:
        if (r11 == r10) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02e0, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02e2, code lost:
        r6 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02e4, code lost:
        r2.d((java.lang.Object) null);
        r2 = new kotlin.jvm.internal.Ref.ObjectRef();
        r6 = r0.k;
        r10 = androidx.paging.PageFetcherSnapshotState.Holder.a(r6);
        r4.L$0 = r0;
        r4.L$1 = r1;
        r4.L$2 = r8;
        r4.L$3 = r9;
        r4.L$4 = r2;
        r4.L$5 = r6;
        r4.L$6 = r10;
        r4.L$7 = r2;
        r4.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x030b, code lost:
        if (r10.c((java.lang.Object) null, r4) != r5) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x030d, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x030e, code lost:
        r12 = r0;
        r11 = r1;
        r0 = r2;
        r1 = r10;
        r10 = r8;
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r2 = androidx.paging.PageFetcherSnapshotState.Holder.b(r6);
        r6 = r12.z(r2, r11, r10.a(), r10.b().e(r11) + r9.element);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x032b, code lost:
        if (r6 == null) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x032d, code lost:
        r4.L$0 = r12;
        r4.L$1 = r11;
        r4.L$2 = r10;
        r4.L$3 = r9;
        r4.L$4 = r8;
        r4.L$5 = r1;
        r4.L$6 = r6;
        r4.L$7 = r0;
        r4.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0344, code lost:
        if (r12.D(r2, r11, r4) != r5) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0346, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0347, code lost:
        r16 = r6;
        r6 = r1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x034c, code lost:
        r2 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0350, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0351, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0354, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0356, code lost:
        r1.d((java.lang.Object) null);
        r0.element = r2;
        r0 = new kotlin.jvm.internal.Ref.BooleanRef();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0360, code lost:
        r1 = r8.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0362, code lost:
        if (r1 == null) goto L_0x0701;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0364, code lost:
        r1 = r12.x(r11, r1);
        r2 = androidx.paging.LoggerKt.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x036c, code lost:
        if (r2 == null) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0373, code lost:
        if (r2.b(3) != r3) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0375, code lost:
        r2.a(3, "Start " + r11 + " with loadKey " + r8.element + " on " + r12.b, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x039f, code lost:
        r2 = r12.b;
        r4.L$0 = r12;
        r4.L$1 = r11;
        r4.L$2 = r10;
        r4.L$3 = r9;
        r4.L$4 = r8;
        r4.L$5 = r0;
        r4.L$6 = r1;
        r4.L$7 = null;
        r4.L$8 = null;
        r4.label = 4;
        r2 = r2.f(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x03bb, code lost:
        if (r2 != r5) goto L_0x03be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x03bd, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x03be, code lost:
        r13 = r11;
        r11 = r9;
        r9 = r0;
        r0 = r1;
        r16 = r10;
        r10 = r8;
        r8 = r12;
        r12 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x03c8, code lost:
        r1 = (androidx.paging.PagingSource.LoadResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x03cd, code lost:
        if ((r1 instanceof androidx.paging.PagingSource.LoadResult.Page) == false) goto L_0x04d9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(androidx.paging.LoadType r18, androidx.paging.GenerationalViewportHint r19, kotlin.coroutines.Continuation r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            r3 = 1
            boolean r4 = r2 instanceof androidx.paging.PageFetcherSnapshot$doLoad$1
            if (r4 == 0) goto L_0x001a
            r4 = r2
            androidx.paging.PageFetcherSnapshot$doLoad$1 r4 = (androidx.paging.PageFetcherSnapshot$doLoad$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001a
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x001f
        L_0x001a:
            androidx.paging.PageFetcherSnapshot$doLoad$1 r4 = new androidx.paging.PageFetcherSnapshot$doLoad$1
            r4.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            java.lang.String r7 = "Use doInitialLoad for LoadType == REFRESH"
            switch(r6) {
                case 0: goto L_0x0205;
                case 1: goto L_0x01e1;
                case 2: goto L_0x01bc;
                case 3: goto L_0x0195;
                case 4: goto L_0x016b;
                case 5: goto L_0x0139;
                case 6: goto L_0x0118;
                case 7: goto L_0x00ff;
                case 8: goto L_0x00c6;
                case 9: goto L_0x0099;
                case 10: goto L_0x0065;
                case 11: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            int r0 = r4.I$1
            int r1 = r4.I$0
            java.lang.Object r6 = r4.L$7
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r12 = r4.L$6
            androidx.paging.PageFetcherSnapshotState$Holder r12 = (androidx.paging.PageFetcherSnapshotState.Holder) r12
            java.lang.Object r13 = r4.L$5
            kotlin.jvm.internal.Ref$BooleanRef r13 = (kotlin.jvm.internal.Ref.BooleanRef) r13
            java.lang.Object r14 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r15 = (kotlin.jvm.internal.Ref.IntRef) r15
            java.lang.Object r8 = r4.L$2
            androidx.paging.GenerationalViewportHint r8 = (androidx.paging.GenerationalViewportHint) r8
            java.lang.Object r9 = r4.L$1
            androidx.paging.LoadType r9 = (androidx.paging.LoadType) r9
            java.lang.Object r10 = r4.L$0
            androidx.paging.PageFetcherSnapshot r10 = (androidx.paging.PageFetcherSnapshot) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r11 = r9
            r9 = r15
            r16 = r10
            r10 = r8
            r8 = r14
            r14 = r16
            goto L_0x06ca
        L_0x0065:
            java.lang.Object r0 = r4.L$8
            r1 = r0
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r4.L$7
            androidx.paging.PagingSource$LoadResult r0 = (androidx.paging.PagingSource.LoadResult) r0
            java.lang.Object r6 = r4.L$6
            androidx.paging.PagingSource$LoadParams r6 = (androidx.paging.PagingSource.LoadParams) r6
            java.lang.Object r8 = r4.L$5
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            java.lang.Object r9 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r12 = r4.L$2
            androidx.paging.GenerationalViewportHint r12 = (androidx.paging.GenerationalViewportHint) r12
            java.lang.Object r13 = r4.L$1
            androidx.paging.LoadType r13 = (androidx.paging.LoadType) r13
            java.lang.Object r14 = r4.L$0
            androidx.paging.PageFetcherSnapshot r14 = (androidx.paging.PageFetcherSnapshot) r14
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0095 }
            r11 = r13
            r16 = r12
            r12 = r10
            r10 = r16
            goto L_0x0671
        L_0x0095:
            r0 = move-exception
        L_0x0096:
            r2 = 0
            goto L_0x06fd
        L_0x0099:
            java.lang.Object r0 = r4.L$9
            androidx.paging.PageFetcherSnapshotState r0 = (androidx.paging.PageFetcherSnapshotState) r0
            java.lang.Object r1 = r4.L$8
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r6 = r4.L$7
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r8 = r4.L$6
            androidx.paging.PagingSource$LoadParams r8 = (androidx.paging.PagingSource.LoadParams) r8
            java.lang.Object r9 = r4.L$5
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r12 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref.IntRef) r12
            java.lang.Object r13 = r4.L$2
            androidx.paging.GenerationalViewportHint r13 = (androidx.paging.GenerationalViewportHint) r13
            java.lang.Object r14 = r4.L$1
            androidx.paging.LoadType r14 = (androidx.paging.LoadType) r14
            java.lang.Object r15 = r4.L$0
            androidx.paging.PageFetcherSnapshot r15 = (androidx.paging.PageFetcherSnapshot) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0095 }
            goto L_0x05f8
        L_0x00c6:
            java.lang.Object r0 = r4.L$10
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r1 = r4.L$9
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r6 = r4.L$8
            androidx.paging.LoadType r6 = (androidx.paging.LoadType) r6
            java.lang.Object r8 = r4.L$7
            androidx.paging.PagingSource$LoadResult r8 = (androidx.paging.PagingSource.LoadResult) r8
            java.lang.Object r9 = r4.L$6
            androidx.paging.PagingSource$LoadParams r9 = (androidx.paging.PagingSource.LoadParams) r9
            java.lang.Object r10 = r4.L$5
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r12 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r13 = (kotlin.jvm.internal.Ref.IntRef) r13
            java.lang.Object r14 = r4.L$2
            androidx.paging.GenerationalViewportHint r14 = (androidx.paging.GenerationalViewportHint) r14
            java.lang.Object r15 = r4.L$1
            androidx.paging.LoadType r15 = (androidx.paging.LoadType) r15
            java.lang.Object r11 = r4.L$0
            androidx.paging.PageFetcherSnapshot r11 = (androidx.paging.PageFetcherSnapshot) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r9
            r9 = r10
            r10 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r11
            goto L_0x05bf
        L_0x00ff:
            java.lang.Object r0 = r4.L$3
            androidx.paging.PageFetcherSnapshotState r0 = (androidx.paging.PageFetcherSnapshotState) r0
            java.lang.Object r1 = r4.L$2
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r3 = r4.L$1
            androidx.paging.GenerationalViewportHint r3 = (androidx.paging.GenerationalViewportHint) r3
            java.lang.Object r4 = r4.L$0
            androidx.paging.LoadType r4 = (androidx.paging.LoadType) r4
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0114 }
            goto L_0x0541
        L_0x0114:
            r0 = move-exception
        L_0x0115:
            r6 = 0
            goto L_0x0559
        L_0x0118:
            java.lang.Object r0 = r4.L$5
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r1 = r4.L$4
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r3 = r4.L$3
            androidx.paging.PagingSource$LoadResult r3 = (androidx.paging.PagingSource.LoadResult) r3
            java.lang.Object r6 = r4.L$2
            androidx.paging.GenerationalViewportHint r6 = (androidx.paging.GenerationalViewportHint) r6
            java.lang.Object r7 = r4.L$1
            androidx.paging.LoadType r7 = (androidx.paging.LoadType) r7
            java.lang.Object r8 = r4.L$0
            androidx.paging.PageFetcherSnapshot r8 = (androidx.paging.PageFetcherSnapshot) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r4
            r12 = r6
            r4 = r7
            goto L_0x0518
        L_0x0139:
            java.lang.Object r0 = r4.L$9
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r1 = r4.L$8
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r6 = r4.L$7
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r8 = r4.L$6
            androidx.paging.PagingSource$LoadParams r8 = (androidx.paging.PagingSource.LoadParams) r8
            java.lang.Object r9 = r4.L$5
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r4.L$2
            androidx.paging.GenerationalViewportHint r12 = (androidx.paging.GenerationalViewportHint) r12
            java.lang.Object r13 = r4.L$1
            androidx.paging.LoadType r13 = (androidx.paging.LoadType) r13
            java.lang.Object r14 = r4.L$0
            androidx.paging.PageFetcherSnapshot r14 = (androidx.paging.PageFetcherSnapshot) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r6
            r6 = r0
            r0 = r16
            goto L_0x0464
        L_0x016b:
            java.lang.Object r0 = r4.L$6
            androidx.paging.PagingSource$LoadParams r0 = (androidx.paging.PagingSource.LoadParams) r0
            java.lang.Object r1 = r4.L$5
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r6 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r8 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r8 = (kotlin.jvm.internal.Ref.IntRef) r8
            java.lang.Object r9 = r4.L$2
            androidx.paging.GenerationalViewportHint r9 = (androidx.paging.GenerationalViewportHint) r9
            java.lang.Object r10 = r4.L$1
            androidx.paging.LoadType r10 = (androidx.paging.LoadType) r10
            java.lang.Object r11 = r4.L$0
            androidx.paging.PageFetcherSnapshot r11 = (androidx.paging.PageFetcherSnapshot) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r12 = r9
            r13 = r10
            r9 = r1
            r10 = r6
            r16 = r11
            r11 = r8
            r8 = r16
            goto L_0x03c8
        L_0x0195:
            java.lang.Object r0 = r4.L$7
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r4.L$6
            java.lang.Object r6 = r4.L$5
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r8 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r4.L$2
            androidx.paging.GenerationalViewportHint r10 = (androidx.paging.GenerationalViewportHint) r10
            java.lang.Object r11 = r4.L$1
            androidx.paging.LoadType r11 = (androidx.paging.LoadType) r11
            java.lang.Object r12 = r4.L$0
            androidx.paging.PageFetcherSnapshot r12 = (androidx.paging.PageFetcherSnapshot) r12
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x01b8 }
            goto L_0x034c
        L_0x01b8:
            r0 = move-exception
        L_0x01b9:
            r1 = 0
            goto L_0x0704
        L_0x01bc:
            java.lang.Object r0 = r4.L$7
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r4.L$6
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r6 = r4.L$5
            androidx.paging.PageFetcherSnapshotState$Holder r6 = (androidx.paging.PageFetcherSnapshotState.Holder) r6
            java.lang.Object r8 = r4.L$4
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r4.L$2
            androidx.paging.GenerationalViewportHint r10 = (androidx.paging.GenerationalViewportHint) r10
            java.lang.Object r11 = r4.L$1
            androidx.paging.LoadType r11 = (androidx.paging.LoadType) r11
            java.lang.Object r12 = r4.L$0
            androidx.paging.PageFetcherSnapshot r12 = (androidx.paging.PageFetcherSnapshot) r12
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0314
        L_0x01e1:
            java.lang.Object r0 = r4.L$5
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r1 = r4.L$4
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r6 = r4.L$3
            kotlin.jvm.internal.Ref$IntRef r6 = (kotlin.jvm.internal.Ref.IntRef) r6
            java.lang.Object r8 = r4.L$2
            androidx.paging.GenerationalViewportHint r8 = (androidx.paging.GenerationalViewportHint) r8
            java.lang.Object r9 = r4.L$1
            androidx.paging.LoadType r9 = (androidx.paging.LoadType) r9
            java.lang.Object r10 = r4.L$0
            androidx.paging.PageFetcherSnapshot r10 = (androidx.paging.PageFetcherSnapshot) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r10
            r16 = r6
            r6 = r1
            r1 = r9
        L_0x0202:
            r9 = r16
            goto L_0x0235
        L_0x0205:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.paging.LoadType r2 = androidx.paging.LoadType.REFRESH
            if (r1 == r2) goto L_0x0712
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            androidx.paging.PageFetcherSnapshotState$Holder r2 = r0.k
            kotlinx.coroutines.sync.Mutex r8 = r2.b
            r4.L$0 = r0
            r4.L$1 = r1
            r9 = r19
            r4.L$2 = r9
            r4.L$3 = r6
            r4.L$4 = r2
            r4.L$5 = r8
            r4.label = r3
            r10 = 0
            java.lang.Object r11 = r8.c(r10, r4)
            if (r11 != r5) goto L_0x022f
            return r5
        L_0x022f:
            r16 = r6
            r6 = r2
            r2 = r8
            r8 = r9
            goto L_0x0202
        L_0x0235:
            androidx.paging.PageFetcherSnapshotState r6 = r6.c     // Catch:{ all -> 0x0268 }
            int[] r10 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x0268 }
            int r11 = r1.ordinal()     // Catch:{ all -> 0x0268 }
            r10 = r10[r11]     // Catch:{ all -> 0x0268 }
            if (r10 == r3) goto L_0x0708
            r11 = 2
            if (r10 == r11) goto L_0x0291
            r11 = 3
            if (r10 == r11) goto L_0x024b
            goto L_0x02e2
        L_0x024b:
            int r10 = r6.l()     // Catch:{ all -> 0x0268 }
            androidx.paging.ViewportHint r11 = r8.b()     // Catch:{ all -> 0x0268 }
            int r11 = r11.b()     // Catch:{ all -> 0x0268 }
            int r10 = r10 + r11
            int r10 = r10 + r3
            if (r10 >= 0) goto L_0x026c
            int r11 = r9.element     // Catch:{ all -> 0x0268 }
            androidx.paging.PagingConfig r12 = r0.c     // Catch:{ all -> 0x0268 }
            int r12 = r12.f1596a     // Catch:{ all -> 0x0268 }
            int r10 = -r10
            int r12 = r12 * r10
            int r11 = r11 + r12
            r9.element = r11     // Catch:{ all -> 0x0268 }
            r10 = 0
            goto L_0x026c
        L_0x0268:
            r0 = move-exception
            r1 = 0
            goto L_0x070e
        L_0x026c:
            java.util.List r11 = r6.m()     // Catch:{ all -> 0x0268 }
            int r11 = kotlin.collections.CollectionsKt.getLastIndex(r11)     // Catch:{ all -> 0x0268 }
            if (r10 > r11) goto L_0x02e2
        L_0x0276:
            int r12 = r9.element     // Catch:{ all -> 0x0268 }
            java.util.List r13 = r6.m()     // Catch:{ all -> 0x0268 }
            java.lang.Object r13 = r13.get(r10)     // Catch:{ all -> 0x0268 }
            androidx.paging.PagingSource$LoadResult$Page r13 = (androidx.paging.PagingSource.LoadResult.Page) r13     // Catch:{ all -> 0x0268 }
            java.util.List r13 = r13.b()     // Catch:{ all -> 0x0268 }
            int r13 = r13.size()     // Catch:{ all -> 0x0268 }
            int r12 = r12 + r13
            r9.element = r12     // Catch:{ all -> 0x0268 }
            if (r10 == r11) goto L_0x02e2
            int r10 = r10 + r3
            goto L_0x0276
        L_0x0291:
            int r10 = r6.l()     // Catch:{ all -> 0x0268 }
            androidx.paging.ViewportHint r11 = r8.b()     // Catch:{ all -> 0x0268 }
            int r11 = r11.a()     // Catch:{ all -> 0x0268 }
            int r10 = r10 + r11
            int r10 = r10 - r3
            java.util.List r11 = r6.m()     // Catch:{ all -> 0x0268 }
            int r11 = kotlin.collections.CollectionsKt.getLastIndex(r11)     // Catch:{ all -> 0x0268 }
            if (r10 <= r11) goto L_0x02c4
            int r11 = r9.element     // Catch:{ all -> 0x0268 }
            androidx.paging.PagingConfig r12 = r0.c     // Catch:{ all -> 0x0268 }
            int r12 = r12.f1596a     // Catch:{ all -> 0x0268 }
            java.util.List r13 = r6.m()     // Catch:{ all -> 0x0268 }
            int r13 = kotlin.collections.CollectionsKt.getLastIndex(r13)     // Catch:{ all -> 0x0268 }
            int r10 = r10 - r13
            int r12 = r12 * r10
            int r11 = r11 + r12
            r9.element = r11     // Catch:{ all -> 0x0268 }
            java.util.List r10 = r6.m()     // Catch:{ all -> 0x0268 }
            int r10 = kotlin.collections.CollectionsKt.getLastIndex(r10)     // Catch:{ all -> 0x0268 }
        L_0x02c4:
            if (r10 < 0) goto L_0x02e2
            r11 = 0
        L_0x02c7:
            int r12 = r9.element     // Catch:{ all -> 0x0268 }
            java.util.List r13 = r6.m()     // Catch:{ all -> 0x0268 }
            java.lang.Object r13 = r13.get(r11)     // Catch:{ all -> 0x0268 }
            androidx.paging.PagingSource$LoadResult$Page r13 = (androidx.paging.PagingSource.LoadResult.Page) r13     // Catch:{ all -> 0x0268 }
            java.util.List r13 = r13.b()     // Catch:{ all -> 0x0268 }
            int r13 = r13.size()     // Catch:{ all -> 0x0268 }
            int r12 = r12 + r13
            r9.element = r12     // Catch:{ all -> 0x0268 }
            if (r11 == r10) goto L_0x02e2
            int r11 = r11 + r3
            goto L_0x02c7
        L_0x02e2:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0268 }
            r6 = 0
            r2.d(r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            androidx.paging.PageFetcherSnapshotState$Holder r6 = r0.k
            kotlinx.coroutines.sync.Mutex r10 = r6.b
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r8
            r4.L$3 = r9
            r4.L$4 = r2
            r4.L$5 = r6
            r4.L$6 = r10
            r4.L$7 = r2
            r11 = 2
            r4.label = r11
            r11 = 0
            java.lang.Object r12 = r10.c(r11, r4)
            if (r12 != r5) goto L_0x030e
            return r5
        L_0x030e:
            r12 = r0
            r11 = r1
            r0 = r2
            r1 = r10
            r10 = r8
            r8 = r0
        L_0x0314:
            androidx.paging.PageFetcherSnapshotState r2 = r6.c     // Catch:{ all -> 0x0350 }
            int r6 = r10.a()     // Catch:{ all -> 0x0350 }
            androidx.paging.ViewportHint r13 = r10.b()     // Catch:{ all -> 0x0350 }
            int r13 = r13.e(r11)     // Catch:{ all -> 0x0350 }
            int r14 = r9.element     // Catch:{ all -> 0x0350 }
            int r13 = r13 + r14
            java.lang.Object r6 = r12.z(r2, r11, r6, r13)     // Catch:{ all -> 0x0350 }
            if (r6 == 0) goto L_0x0354
            r4.L$0 = r12     // Catch:{ all -> 0x0350 }
            r4.L$1 = r11     // Catch:{ all -> 0x0350 }
            r4.L$2 = r10     // Catch:{ all -> 0x0350 }
            r4.L$3 = r9     // Catch:{ all -> 0x0350 }
            r4.L$4 = r8     // Catch:{ all -> 0x0350 }
            r4.L$5 = r1     // Catch:{ all -> 0x0350 }
            r4.L$6 = r6     // Catch:{ all -> 0x0350 }
            r4.L$7 = r0     // Catch:{ all -> 0x0350 }
            r13 = 3
            r4.label = r13     // Catch:{ all -> 0x0350 }
            java.lang.Object r2 = r12.D(r2, r11, r4)     // Catch:{ all -> 0x0350 }
            if (r2 != r5) goto L_0x0347
            return r5
        L_0x0347:
            r16 = r6
            r6 = r1
            r1 = r16
        L_0x034c:
            r2 = r1
            r1 = r6
        L_0x034e:
            r6 = 0
            goto L_0x0356
        L_0x0350:
            r0 = move-exception
            r6 = r1
            goto L_0x01b9
        L_0x0354:
            r2 = 0
            goto L_0x034e
        L_0x0356:
            r1.d(r6)
            r0.element = r2
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
        L_0x0360:
            T r1 = r8.element
            if (r1 == 0) goto L_0x0701
            androidx.paging.PagingSource$LoadParams r1 = r12.x(r11, r1)
            androidx.paging.Logger r2 = androidx.paging.LoggerKt.a()
            if (r2 == 0) goto L_0x039f
            r6 = 3
            boolean r13 = r2.b(r6)
            if (r13 != r3) goto L_0x039f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r13 = "Start "
            r6.append(r13)
            r6.append(r11)
            java.lang.String r13 = " with loadKey "
            r6.append(r13)
            T r13 = r8.element
            r6.append(r13)
            java.lang.String r13 = " on "
            r6.append(r13)
            androidx.paging.PagingSource r13 = r12.b
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            r13 = 3
            r14 = 0
            r2.a(r13, r6, r14)
        L_0x039f:
            androidx.paging.PagingSource r2 = r12.b
            r4.L$0 = r12
            r4.L$1 = r11
            r4.L$2 = r10
            r4.L$3 = r9
            r4.L$4 = r8
            r4.L$5 = r0
            r4.L$6 = r1
            r6 = 0
            r4.L$7 = r6
            r4.L$8 = r6
            r6 = 4
            r4.label = r6
            java.lang.Object r2 = r2.f(r1, r4)
            if (r2 != r5) goto L_0x03be
            return r5
        L_0x03be:
            r13 = r11
            r11 = r9
            r9 = r0
            r0 = r1
            r16 = r10
            r10 = r8
            r8 = r12
            r12 = r16
        L_0x03c8:
            r1 = r2
            androidx.paging.PagingSource$LoadResult r1 = (androidx.paging.PagingSource.LoadResult) r1
            boolean r2 = r1 instanceof androidx.paging.PagingSource.LoadResult.Page
            if (r2 == 0) goto L_0x04d9
            int[] r2 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0
            int r6 = r13.ordinal()
            r2 = r2[r6]
            r6 = 2
            if (r2 == r6) goto L_0x03eb
            r6 = 3
            if (r2 != r6) goto L_0x03e5
            r2 = r1
            androidx.paging.PagingSource$LoadResult$Page r2 = (androidx.paging.PagingSource.LoadResult.Page) r2
            java.lang.Object r2 = r2.e()
            goto L_0x03f2
        L_0x03e5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x03eb:
            r2 = r1
            androidx.paging.PagingSource$LoadResult$Page r2 = (androidx.paging.PagingSource.LoadResult.Page) r2
            java.lang.Object r2 = r2.f()
        L_0x03f2:
            androidx.paging.PagingSource r6 = r8.b
            boolean r6 = r6.c()
            if (r6 != 0) goto L_0x043b
            T r6 = r10.element
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 != 0) goto L_0x0403
            goto L_0x043b
        L_0x0403:
            androidx.paging.LoadType r0 = androidx.paging.LoadType.PREPEND
            if (r13 != r0) goto L_0x040a
            java.lang.String r0 = "prevKey"
            goto L_0x040c
        L_0x040a:
            java.lang.String r0 = "nextKey"
        L_0x040c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The same value, "
            r1.append(r2)
            T r2 = r10.element
            r1.append(r2)
            java.lang.String r2 = ", was passed as the "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            java.lang.String r0 = kotlin.text.StringsKt.trimMargin$default(r0, r1, r3, r1)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x043b:
            androidx.paging.PageFetcherSnapshotState$Holder r2 = r8.k
            kotlinx.coroutines.sync.Mutex r6 = r2.b
            r4.L$0 = r8
            r4.L$1 = r13
            r4.L$2 = r12
            r4.L$3 = r11
            r4.L$4 = r10
            r4.L$5 = r9
            r4.L$6 = r0
            r4.L$7 = r1
            r4.L$8 = r2
            r4.L$9 = r6
            r14 = 5
            r4.label = r14
            r14 = 0
            java.lang.Object r15 = r6.c(r14, r4)
            if (r15 != r5) goto L_0x0460
            return r5
        L_0x0460:
            r14 = r8
            r8 = r0
            r0 = r1
            r1 = r2
        L_0x0464:
            androidx.paging.PageFetcherSnapshotState r1 = r1.c     // Catch:{ all -> 0x04d3 }
            int r2 = r12.a()     // Catch:{ all -> 0x04d3 }
            r15 = r0
            androidx.paging.PagingSource$LoadResult$Page r15 = (androidx.paging.PagingSource.LoadResult.Page) r15     // Catch:{ all -> 0x04d3 }
            boolean r1 = r1.r(r2, r13, r15)     // Catch:{ all -> 0x04d3 }
            r2 = 0
            r6.d(r2)
            if (r1 != 0) goto L_0x0491
            androidx.paging.Logger r0 = androidx.paging.LoggerKt.a()
            if (r0 == 0) goto L_0x0701
            r1 = 2
            boolean r4 = r0.b(r1)
            if (r4 != r3) goto L_0x0701
            T r3 = r10.element
            java.lang.String r3 = r14.y(r13, r3, r2)
            r0.a(r1, r3, r2)
            goto L_0x0701
        L_0x0491:
            androidx.paging.Logger r1 = androidx.paging.LoggerKt.a()
            r2 = 3
            if (r1 == 0) goto L_0x04a8
            boolean r6 = r1.b(r2)
            if (r6 != r3) goto L_0x04a8
            T r6 = r10.element
            java.lang.String r6 = r14.y(r13, r6, r0)
            r15 = 0
            r1.a(r2, r6, r15)
        L_0x04a8:
            int r1 = r11.element
            r6 = r0
            androidx.paging.PagingSource$LoadResult$Page r6 = (androidx.paging.PagingSource.LoadResult.Page) r6
            java.util.List r15 = r6.b()
            int r15 = r15.size()
            int r1 = r1 + r15
            r11.element = r1
            androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND
            if (r13 != r1) goto L_0x04c2
            java.lang.Object r1 = r6.f()
            if (r1 == 0) goto L_0x04cc
        L_0x04c2:
            androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
            if (r13 != r1) goto L_0x04ce
            java.lang.Object r1 = r6.e()
            if (r1 != 0) goto L_0x04ce
        L_0x04cc:
            r9.element = r3
        L_0x04ce:
            r1 = r0
            r0 = r8
            r8 = r14
            goto L_0x057e
        L_0x04d3:
            r0 = move-exception
            r14 = 0
            r6.d(r14)
            throw r0
        L_0x04d9:
            r2 = 3
            r14 = 0
            boolean r6 = r1 instanceof androidx.paging.PagingSource.LoadResult.Error
            if (r6 == 0) goto L_0x055d
            androidx.paging.Logger r0 = androidx.paging.LoggerKt.a()
            if (r0 == 0) goto L_0x04f5
            r2 = 2
            boolean r6 = r0.b(r2)
            if (r6 != r3) goto L_0x04f5
            T r3 = r10.element
            java.lang.String r3 = r8.y(r13, r3, r1)
            r0.a(r2, r3, r14)
        L_0x04f5:
            androidx.paging.PageFetcherSnapshotState$Holder r0 = r8.k
            kotlinx.coroutines.sync.Mutex r2 = r0.b
            r4.L$0 = r8
            r4.L$1 = r13
            r4.L$2 = r12
            r4.L$3 = r1
            r4.L$4 = r0
            r4.L$5 = r2
            r3 = 0
            r4.L$6 = r3
            r6 = 6
            r4.label = r6
            java.lang.Object r6 = r2.c(r3, r4)
            if (r6 != r5) goto L_0x0514
            return r5
        L_0x0514:
            r3 = r1
            r1 = r0
            r0 = r4
            r4 = r13
        L_0x0518:
            androidx.paging.PageFetcherSnapshotState r1 = r1.c     // Catch:{ all -> 0x0555 }
            androidx.paging.LoadState$Error r6 = new androidx.paging.LoadState$Error     // Catch:{ all -> 0x0555 }
            androidx.paging.PagingSource$LoadResult$Error r3 = (androidx.paging.PagingSource.LoadResult.Error) r3     // Catch:{ all -> 0x0555 }
            java.lang.Throwable r3 = r3.a()     // Catch:{ all -> 0x0555 }
            r6.<init>(r3)     // Catch:{ all -> 0x0555 }
            r0.L$0 = r4     // Catch:{ all -> 0x0555 }
            r0.L$1 = r12     // Catch:{ all -> 0x0555 }
            r0.L$2 = r2     // Catch:{ all -> 0x0555 }
            r0.L$3 = r1     // Catch:{ all -> 0x0555 }
            r3 = 0
            r0.L$4 = r3     // Catch:{ all -> 0x0555 }
            r0.L$5 = r3     // Catch:{ all -> 0x0555 }
            r3 = 7
            r0.label = r3     // Catch:{ all -> 0x0555 }
            java.lang.Object r0 = r8.C(r1, r4, r6, r0)     // Catch:{ all -> 0x0555 }
            if (r0 != r5) goto L_0x053e
            return r5
        L_0x053e:
            r0 = r1
            r1 = r2
            r3 = r12
        L_0x0541:
            java.util.Map r0 = r0.k()     // Catch:{ all -> 0x0114 }
            androidx.paging.ViewportHint r2 = r3.b()     // Catch:{ all -> 0x0114 }
            r0.put(r4, r2)     // Catch:{ all -> 0x0114 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0114 }
            r2 = 0
            r1.d(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0555:
            r0 = move-exception
            r1 = r2
            goto L_0x0115
        L_0x0559:
            r1.d(r6)
            throw r0
        L_0x055d:
            r6 = r14
            boolean r14 = r1 instanceof androidx.paging.PagingSource.LoadResult.Invalid
            if (r14 == 0) goto L_0x057e
            androidx.paging.Logger r0 = androidx.paging.LoggerKt.a()
            if (r0 == 0) goto L_0x0578
            r2 = 2
            boolean r4 = r0.b(r2)
            if (r4 != r3) goto L_0x0578
            T r3 = r10.element
            java.lang.String r1 = r8.y(r13, r3, r1)
            r0.a(r2, r1, r6)
        L_0x0578:
            r8.A()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x057e:
            int[] r6 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$0
            int r14 = r13.ordinal()
            r6 = r6[r14]
            r14 = 2
            if (r6 != r14) goto L_0x058c
            androidx.paging.LoadType r6 = androidx.paging.LoadType.APPEND
            goto L_0x058e
        L_0x058c:
            androidx.paging.LoadType r6 = androidx.paging.LoadType.PREPEND
        L_0x058e:
            androidx.paging.PageFetcherSnapshotState$Holder r15 = r8.k
            kotlinx.coroutines.sync.Mutex r2 = r15.b
            r4.L$0 = r8
            r4.L$1 = r13
            r4.L$2 = r12
            r4.L$3 = r11
            r4.L$4 = r10
            r4.L$5 = r9
            r4.L$6 = r0
            r4.L$7 = r1
            r4.L$8 = r6
            r4.L$9 = r15
            r4.L$10 = r2
            r3 = 8
            r4.label = r3
            r3 = 0
            java.lang.Object r14 = r2.c(r3, r4)
            if (r14 != r5) goto L_0x05b6
            return r5
        L_0x05b6:
            r14 = r13
            r13 = r12
            r12 = r11
            r16 = r8
            r8 = r1
            r1 = r15
            r15 = r16
        L_0x05bf:
            androidx.paging.PageFetcherSnapshotState r1 = r1.c     // Catch:{ all -> 0x05ff }
            androidx.paging.ViewportHint r3 = r13.b()     // Catch:{ all -> 0x05ff }
            androidx.paging.PageEvent$Drop r3 = r1.i(r6, r3)     // Catch:{ all -> 0x05ff }
            if (r3 == 0) goto L_0x0603
            r1.h(r3)     // Catch:{ all -> 0x05ff }
            kotlinx.coroutines.channels.Channel r6 = r15.j     // Catch:{ all -> 0x05ff }
            r4.L$0 = r15     // Catch:{ all -> 0x05ff }
            r4.L$1 = r14     // Catch:{ all -> 0x05ff }
            r4.L$2 = r13     // Catch:{ all -> 0x05ff }
            r4.L$3 = r12     // Catch:{ all -> 0x05ff }
            r4.L$4 = r10     // Catch:{ all -> 0x05ff }
            r4.L$5 = r9     // Catch:{ all -> 0x05ff }
            r4.L$6 = r0     // Catch:{ all -> 0x05ff }
            r4.L$7 = r8     // Catch:{ all -> 0x05ff }
            r4.L$8 = r2     // Catch:{ all -> 0x05ff }
            r4.L$9 = r1     // Catch:{ all -> 0x05ff }
            r11 = 0
            r4.L$10 = r11     // Catch:{ all -> 0x05ff }
            r11 = 9
            r4.label = r11     // Catch:{ all -> 0x05ff }
            java.lang.Object r3 = r6.L(r3, r4)     // Catch:{ all -> 0x05ff }
            if (r3 != r5) goto L_0x05f4
            return r5
        L_0x05f4:
            r6 = r8
            r8 = r0
            r0 = r1
            r1 = r2
        L_0x05f8:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0095 }
            r2 = r1
            r1 = r0
            r0 = r6
            r6 = r8
            goto L_0x0605
        L_0x05ff:
            r0 = move-exception
            r1 = r2
            goto L_0x0096
        L_0x0603:
            r6 = r0
            r0 = r8
        L_0x0605:
            int r3 = r13.a()     // Catch:{ all -> 0x05ff }
            androidx.paging.ViewportHint r8 = r13.b()     // Catch:{ all -> 0x05ff }
            int r8 = r8.e(r14)     // Catch:{ all -> 0x05ff }
            int r11 = r12.element     // Catch:{ all -> 0x05ff }
            int r8 = r8 + r11
            java.lang.Object r3 = r15.z(r1, r14, r3, r8)     // Catch:{ all -> 0x05ff }
            r10.element = r3     // Catch:{ all -> 0x05ff }
            if (r3 != 0) goto L_0x0640
            androidx.paging.MutableLoadStateCollection r3 = r1.p()     // Catch:{ all -> 0x05ff }
            androidx.paging.LoadState r3 = r3.a(r14)     // Catch:{ all -> 0x05ff }
            boolean r3 = r3 instanceof androidx.paging.LoadState.Error     // Catch:{ all -> 0x05ff }
            if (r3 != 0) goto L_0x0640
            androidx.paging.MutableLoadStateCollection r3 = r1.p()     // Catch:{ all -> 0x05ff }
            boolean r8 = r9.element     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x0637
            androidx.paging.LoadState$NotLoading$Companion r8 = androidx.paging.LoadState.NotLoading.b     // Catch:{ all -> 0x05ff }
            androidx.paging.LoadState$NotLoading r8 = r8.a()     // Catch:{ all -> 0x05ff }
            goto L_0x063d
        L_0x0637:
            androidx.paging.LoadState$NotLoading$Companion r8 = androidx.paging.LoadState.NotLoading.b     // Catch:{ all -> 0x05ff }
            androidx.paging.LoadState$NotLoading r8 = r8.b()     // Catch:{ all -> 0x05ff }
        L_0x063d:
            r3.c(r14, r8)     // Catch:{ all -> 0x05ff }
        L_0x0640:
            r3 = r0
            androidx.paging.PagingSource$LoadResult$Page r3 = (androidx.paging.PagingSource.LoadResult.Page) r3     // Catch:{ all -> 0x05ff }
            androidx.paging.PageEvent r1 = r1.u(r3, r14)     // Catch:{ all -> 0x05ff }
            kotlinx.coroutines.channels.Channel r3 = r15.j     // Catch:{ all -> 0x05ff }
            r4.L$0 = r15     // Catch:{ all -> 0x05ff }
            r4.L$1 = r14     // Catch:{ all -> 0x05ff }
            r4.L$2 = r13     // Catch:{ all -> 0x05ff }
            r4.L$3 = r12     // Catch:{ all -> 0x05ff }
            r4.L$4 = r10     // Catch:{ all -> 0x05ff }
            r4.L$5 = r9     // Catch:{ all -> 0x05ff }
            r4.L$6 = r6     // Catch:{ all -> 0x05ff }
            r4.L$7 = r0     // Catch:{ all -> 0x05ff }
            r4.L$8 = r2     // Catch:{ all -> 0x05ff }
            r8 = 0
            r4.L$9 = r8     // Catch:{ all -> 0x05ff }
            r4.L$10 = r8     // Catch:{ all -> 0x05ff }
            r8 = 10
            r4.label = r8     // Catch:{ all -> 0x05ff }
            java.lang.Object r1 = r3.L(r1, r4)     // Catch:{ all -> 0x05ff }
            if (r1 != r5) goto L_0x066b
            return r5
        L_0x066b:
            r1 = r2
            r8 = r9
            r9 = r10
            r10 = r13
            r11 = r14
            r14 = r15
        L_0x0671:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0095 }
            r2 = 0
            r1.d(r2)
            boolean r1 = r6 instanceof androidx.paging.PagingSource.LoadParams.Prepend
            if (r1 == 0) goto L_0x0686
            r1 = r0
            androidx.paging.PagingSource$LoadResult$Page r1 = (androidx.paging.PagingSource.LoadResult.Page) r1
            java.lang.Object r1 = r1.f()
            if (r1 != 0) goto L_0x0686
            r1 = 1
            goto L_0x0687
        L_0x0686:
            r1 = 0
        L_0x0687:
            boolean r2 = r6 instanceof androidx.paging.PagingSource.LoadParams.Append
            if (r2 == 0) goto L_0x0695
            androidx.paging.PagingSource$LoadResult$Page r0 = (androidx.paging.PagingSource.LoadResult.Page) r0
            java.lang.Object r0 = r0.e()
            if (r0 != 0) goto L_0x0695
            r0 = 1
            goto L_0x0696
        L_0x0695:
            r0 = 0
        L_0x0696:
            androidx.paging.RemoteMediatorConnection r2 = r14.e
            if (r2 == 0) goto L_0x06f9
            if (r1 != 0) goto L_0x069e
            if (r0 == 0) goto L_0x06f9
        L_0x069e:
            androidx.paging.PageFetcherSnapshotState$Holder r2 = r14.k
            kotlinx.coroutines.sync.Mutex r6 = r2.b
            r4.L$0 = r14
            r4.L$1 = r11
            r4.L$2 = r10
            r4.L$3 = r12
            r4.L$4 = r9
            r4.L$5 = r8
            r4.L$6 = r2
            r4.L$7 = r6
            r3 = 0
            r4.L$8 = r3
            r4.I$0 = r1
            r4.I$1 = r0
            r13 = 11
            r4.label = r13
            java.lang.Object r13 = r6.c(r3, r4)
            if (r13 != r5) goto L_0x06c6
            return r5
        L_0x06c6:
            r13 = r8
            r8 = r9
            r9 = r12
            r12 = r2
        L_0x06ca:
            androidx.paging.PageFetcherSnapshotState r2 = r12.c     // Catch:{ all -> 0x06f3 }
            androidx.paging.HintHandler r3 = r14.h     // Catch:{ all -> 0x06f3 }
            androidx.paging.ViewportHint$Access r3 = r3.b()     // Catch:{ all -> 0x06f3 }
            androidx.paging.PagingState r2 = r2.g(r3)     // Catch:{ all -> 0x06f3 }
            r3 = 0
            r6.d(r3)
            if (r1 == 0) goto L_0x06e5
            androidx.paging.RemoteMediatorConnection r1 = r14.e
            androidx.paging.LoadType r3 = androidx.paging.LoadType.PREPEND
            r1.e(r3, r2)
        L_0x06e5:
            if (r0 == 0) goto L_0x06ee
            androidx.paging.RemoteMediatorConnection r0 = r14.e
            androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
            r0.e(r1, r2)
        L_0x06ee:
            r0 = r13
        L_0x06ef:
            r12 = r14
            r3 = 1
            goto L_0x0360
        L_0x06f3:
            r0 = move-exception
            r1 = 0
            r6.d(r1)
            throw r0
        L_0x06f9:
            r0 = r8
            r8 = r9
            r9 = r12
            goto L_0x06ef
        L_0x06fd:
            r1.d(r2)
            throw r0
        L_0x0701:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0704:
            r6.d(r1)
            throw r0
        L_0x0708:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0268 }
            r0.<init>(r7)     // Catch:{ all -> 0x0268 }
            throw r0     // Catch:{ all -> 0x0268 }
        L_0x070e:
            r2.d(r1)
            throw r0
        L_0x0712:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r7.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.t(androidx.paging.LoadType, androidx.paging.GenerationalViewportHint, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow u() {
        return this.m;
    }

    public final PagingSource v() {
        return this.b;
    }

    public final RemoteMediatorConnection w() {
        return this.e;
    }

    public final PagingSource.LoadParams x(LoadType loadType, Object obj) {
        return PagingSource.LoadParams.c.a(loadType, obj, loadType == LoadType.REFRESH ? this.c.d : this.c.f1596a, this.c.c);
    }

    public final String y(LoadType loadType, Object obj, PagingSource.LoadResult loadResult) {
        if (loadResult == null) {
            return "End " + loadType + " with loadkey " + obj + ". Load CANCELLED.";
        }
        return "End " + loadType + " with loadKey " + obj + ". Returned " + loadResult;
    }

    public final Object z(PageFetcherSnapshotState pageFetcherSnapshotState, LoadType loadType, int i2, int i3) {
        if (i2 == pageFetcherSnapshotState.j(loadType) && !(pageFetcherSnapshotState.p().a(loadType) instanceof LoadState.Error) && i3 < this.c.b) {
            return loadType == LoadType.PREPEND ? ((PagingSource.LoadResult.Page) CollectionsKt.first(pageFetcherSnapshotState.m())).f() : ((PagingSource.LoadResult.Page) CollectionsKt.last(pageFetcherSnapshotState.m())).e();
        }
        return null;
    }
}
