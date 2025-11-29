package androidx.paging;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

@SourceDebugExtension({"SMAP\nRemoteMediatorAccessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteMediatorAccessor.kt\nandroidx/paging/RemoteMediatorAccessImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,460:1\n1855#2,2:461\n*S KotlinDebug\n*F\n+ 1 RemoteMediatorAccessor.kt\nandroidx/paging/RemoteMediatorAccessImpl\n*L\n439#1:461,2\n*E\n"})
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u0014*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001+B#\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u0013\u0010\u0018\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\u001b\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010$R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl;", "", "Key", "Value", "Landroidx/paging/RemoteMediatorAccessor;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/paging/RemoteMediator;", "remoteMediator", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/RemoteMediator;)V", "Landroidx/paging/PagingState;", "pagingState", "", "d", "(Landroidx/paging/PagingState;)V", "b", "()V", "Landroidx/paging/LoadType;", "loadType", "e", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "c", "Landroidx/paging/RemoteMediator$InitializeAction;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/AccessorStateHolder;", "m", "(Landroidx/paging/AccessorStateHolder;Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "l", "k", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/RemoteMediator;", "Landroidx/paging/AccessorStateHolder;", "accessorState", "Landroidx/paging/SingleRunner;", "Landroidx/paging/SingleRunner;", "isolationRunner", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/LoadStates;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "state", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
final class RemoteMediatorAccessImpl<Key, Value> implements RemoteMediatorAccessor<Key, Value> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f1630a;
    public final RemoteMediator b;
    public final AccessorStateHolder c = new AccessorStateHolder();
    public final SingleRunner d = new SingleRunner(false);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl$Companion;", "", "()V", "PRIORITY_APPEND_PREPEND", "", "PRIORITY_REFRESH", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RemoteMediatorAccessImpl(CoroutineScope coroutineScope, RemoteMediator remoteMediator) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(remoteMediator, "remoteMediator");
        this.f1630a = coroutineScope;
        this.b = remoteMediator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.paging.RemoteMediatorAccessImpl$initialize$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.paging.RemoteMediatorAccessImpl$initialize$1 r0 = (androidx.paging.RemoteMediatorAccessImpl$initialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.RemoteMediatorAccessImpl$initialize$1 r0 = new androidx.paging.RemoteMediatorAccessImpl$initialize$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            androidx.paging.RemoteMediatorAccessImpl r4 = (androidx.paging.RemoteMediatorAccessImpl) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.paging.RemoteMediator r5 = r4.b
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r5
            androidx.paging.RemoteMediator$InitializeAction r0 = (androidx.paging.RemoteMediator.InitializeAction) r0
            androidx.paging.RemoteMediator$InitializeAction r1 = androidx.paging.RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH
            if (r0 != r1) goto L_0x0053
            androidx.paging.AccessorStateHolder r4 = r4.c
            androidx.paging.RemoteMediatorAccessImpl$initialize$2$1 r0 = androidx.paging.RemoteMediatorAccessImpl$initialize$2$1.INSTANCE
            r4.b(r0)
        L_0x0053:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void b() {
        this.c.b(RemoteMediatorAccessImpl$allowRefresh$1.INSTANCE);
    }

    public void c(PagingState pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        ArrayList<LoadType> arrayList = new ArrayList<>();
        this.c.b(new RemoteMediatorAccessImpl$retryFailed$1(arrayList));
        for (LoadType e2 : arrayList) {
            e(e2, pagingState);
        }
    }

    public void d(PagingState pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        this.c.b(new RemoteMediatorAccessImpl$requestRefreshIfAllowed$1(this, pagingState));
    }

    public void e(LoadType loadType, PagingState pagingState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        m(this.c, loadType, pagingState);
    }

    public StateFlow getState() {
        return this.c.a();
    }

    public final void k() {
        Job unused = BuildersKt__Builders_commonKt.d(this.f1630a, (CoroutineContext) null, (CoroutineStart) null, new RemoteMediatorAccessImpl$launchBoundary$1(this, (Continuation<? super RemoteMediatorAccessImpl$launchBoundary$1>) null), 3, (Object) null);
    }

    public final void l() {
        Job unused = BuildersKt__Builders_commonKt.d(this.f1630a, (CoroutineContext) null, (CoroutineStart) null, new RemoteMediatorAccessImpl$launchRefresh$1(this, (Continuation<? super RemoteMediatorAccessImpl$launchRefresh$1>) null), 3, (Object) null);
    }

    public final void m(AccessorStateHolder accessorStateHolder, LoadType loadType, PagingState pagingState) {
        if (!((Boolean) accessorStateHolder.b(new RemoteMediatorAccessImpl$requestLoad$newRequest$1(loadType, pagingState))).booleanValue()) {
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
            l();
        } else {
            k();
        }
    }
}
