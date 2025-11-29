package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.LegacyPageFetcher;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import androidx.paging.PagingSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nContiguousPagedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContiguousPagedList.kt\nandroidx/paging/ContiguousPagedList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,411:1\n1#2:412\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 g*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\b\u0012\u0004\u0012\u00028\u00010\u0006:\u0001hBi\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001aH\u0001¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001dH\u0016¢\u0006\u0004\b)\u0010!J\u0017\u0010,\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020*H\u0017¢\u0006\u0004\b,\u0010-J'\u00101\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*H\u0017¢\u0006\u0004\b1\u00102J'\u00104\u001a\u00020\u001f2\u0006\u00103\u001a\u00020*2\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020*H\u0017¢\u0006\u0004\b4\u00102J\u001f\u00106\u001a\u00020\u001f2\u0006\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u001f2\u0006\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b8\u00107J%\u0010:\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u000109H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001aH\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\u001aH\u0002¢\u0006\u0004\bA\u0010BR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e8\u0000X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010\u0014\u001a\u0004\u0018\u00018\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010NR\u0016\u0010S\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010W\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010NR\u0016\u0010Y\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010NR\u0016\u0010[\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010RR\u0014\u0010]\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010RR&\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010^8\u0002X\u0004¢\u0006\f\n\u0004\b_\u0010`\u0012\u0004\ba\u0010bR\u001c\u0010f\u001a\u0004\u0018\u00018\u00008VX\u0004¢\u0006\f\u0012\u0004\be\u0010b\u001a\u0004\bK\u0010d¨\u0006i"}, d2 = {"Landroidx/paging/ContiguousPagedList;", "", "K", "V", "Landroidx/paging/PagedList;", "Landroidx/paging/PagedStorage$Callback;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "Landroidx/paging/PagingSource;", "pagingSource", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineDispatcher;", "notifyDispatcher", "backgroundDispatcher", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialPage", "initialLastKey", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource$LoadResult$Page;Ljava/lang/Object;)V", "Landroidx/paging/LoadType;", "type", "page", "", "b", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/LoadState;", "state", "", "d", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "deferEmpty", "deferBegin", "deferEnd", "D", "(ZZZ)V", "loadType", "loadState", "x", "", "count", "c", "(I)V", "leadingNulls", "changed", "added", "a", "(III)V", "endPosition", "h", "startOfDrops", "f", "(II)V", "e", "", "G", "(Landroidx/paging/LoadType;Ljava/util/List;)V", "post", "H", "(Z)V", "begin", "end", "E", "(ZZ)V", "k", "Landroidx/paging/PagingSource;", "o", "()Landroidx/paging/PagingSource;", "l", "Landroidx/paging/PagedList$BoundaryCallback;", "F", "()Landroidx/paging/PagedList$BoundaryCallback;", "m", "Ljava/lang/Object;", "n", "I", "prependItemsRequested", "appendItemsRequested", "p", "Z", "boundaryCallbackBeginDeferred", "q", "boundaryCallbackEndDeferred", "r", "lowestIndexAccessed", "s", "highestIndexAccessed", "t", "replacePagesWithNulls", "u", "shouldTrim", "Landroidx/paging/LegacyPageFetcher;", "v", "Landroidx/paging/LegacyPageFetcher;", "getPager$annotations", "()V", "pager", "()Ljava/lang/Object;", "getLastKey$annotations", "lastKey", "w", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
public class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback, LegacyPageFetcher.PageConsumer<V> {
    public static final Companion w = new Companion((DefaultConstructorMarker) null);
    public final PagingSource k;
    public final PagedList.BoundaryCallback l;
    public final Object m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public int r = Integer.MAX_VALUE;
    public int s = Integer.MIN_VALUE;
    public boolean t;
    public final boolean u;
    public final LegacyPageFetcher v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/ContiguousPagedList$Companion;", "", "<init>", "()V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContiguousPagedList(PagingSource pagingSource, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, PagedList.BoundaryCallback boundaryCallback, PagedList.Config config, PagingSource.LoadResult.Page page, Object obj) {
        super(pagingSource, coroutineScope, coroutineDispatcher, new PagedStorage(), config);
        PagingSource pagingSource2 = pagingSource;
        PagedList.Config config2 = config;
        Intrinsics.checkNotNullParameter(pagingSource2, "pagingSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(page, "initialPage");
        this.k = pagingSource2;
        this.l = boundaryCallback;
        this.m = obj;
        this.u = config2.e != Integer.MAX_VALUE;
        PagedStorage r2 = r();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.paging.LegacyPageFetcher.KeyProvider<K of androidx.paging.ContiguousPagedList>");
        LegacyPageFetcher legacyPageFetcher = r0;
        LegacyPageFetcher legacyPageFetcher2 = new LegacyPageFetcher(coroutineScope, config, pagingSource, coroutineDispatcher, coroutineDispatcher2, this, r2);
        this.v = legacyPageFetcher;
        if (config2.c) {
            r().o(page.d() != Integer.MIN_VALUE ? page.d() : 0, page, page.c() != Integer.MIN_VALUE ? page.c() : 0, 0, this, (page.d() == Integer.MIN_VALUE || page.c() == Integer.MIN_VALUE) ? false : true);
        } else {
            r().o(0, page, 0, page.d() != Integer.MIN_VALUE ? page.d() : 0, this, false);
        }
        G(LoadType.REFRESH, page.b());
    }

    public final void D(boolean z, boolean z2, boolean z3) {
        if (this.l != null) {
            if (this.r == Integer.MAX_VALUE) {
                this.r = r().size();
            }
            if (this.s == Integer.MIN_VALUE) {
                this.s = 0;
            }
            if (z || z2 || z3) {
                Job unused = BuildersKt__Builders_commonKt.d(l(), n(), (CoroutineStart) null, new ContiguousPagedList$deferBoundaryCallbacks$1(z, this, z2, z3, (Continuation<? super ContiguousPagedList$deferBoundaryCallbacks$1>) null), 2, (Object) null);
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
    }

    public final void E(boolean z, boolean z2) {
        if (z) {
            PagedList.BoundaryCallback boundaryCallback = this.l;
            Intrinsics.checkNotNull(boundaryCallback);
            boundaryCallback.b(r().j());
        }
        if (z2) {
            PagedList.BoundaryCallback boundaryCallback2 = this.l;
            Intrinsics.checkNotNull(boundaryCallback2);
            boundaryCallback2.a(r().l());
        }
    }

    public final PagedList.BoundaryCallback F() {
        return this.l;
    }

    public final void G(LoadType loadType, List list) {
        if (this.l != null) {
            boolean z = false;
            boolean z2 = r().size() == 0;
            boolean z3 = !z2 && loadType == LoadType.PREPEND && list.isEmpty();
            if (!z2 && loadType == LoadType.APPEND && list.isEmpty()) {
                z = true;
            }
            D(z2, z3, z);
        }
    }

    public final void H(boolean z) {
        boolean z2 = true;
        boolean z3 = this.p && this.r <= k().b;
        if (!this.q || this.s < (size() - 1) - k().b) {
            z2 = false;
        }
        if (z3 || z2) {
            if (z3) {
                this.p = false;
            }
            if (z2) {
                this.q = false;
            }
            if (z) {
                Job unused = BuildersKt__Builders_commonKt.d(l(), n(), (CoroutineStart) null, new ContiguousPagedList$tryDispatchBoundaryCallbacks$1(this, z3, z2, (Continuation<? super ContiguousPagedList$tryDispatchBoundaryCallbacks$1>) null), 2, (Object) null);
            } else {
                E(z3, z2);
            }
        }
    }

    public void a(int i, int i2, int i3) {
        t(i, i2);
        u(0, i3);
        this.r += i3;
        this.s += i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        if ((!r0.isEmpty()) != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        if ((!r0.isEmpty()) != false) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(androidx.paging.LoadType r9, androidx.paging.PagingSource.LoadResult.Page r10) {
        /*
            r8 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "page"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.List r0 = r10.b()
            int r1 = r8.s()
            androidx.paging.PagedStorage r2 = r8.r()
            int r2 = r2.m()
            r3 = 1
            r4 = 0
            if (r1 <= r2) goto L_0x0020
            r1 = r3
            goto L_0x0021
        L_0x0020:
            r1 = r4
        L_0x0021:
            boolean r2 = r8.u
            if (r2 == 0) goto L_0x003f
            androidx.paging.PagedStorage r2 = r8.r()
            androidx.paging.PagedList$Config r5 = r8.k()
            int r5 = r5.e
            int r6 = r8.p()
            int r7 = r0.size()
            boolean r2 = r2.v(r5, r6, r7)
            if (r2 == 0) goto L_0x003f
            r2 = r3
            goto L_0x0040
        L_0x003f:
            r2 = r4
        L_0x0040:
            androidx.paging.LoadType r5 = androidx.paging.LoadType.APPEND
            if (r9 != r5) goto L_0x0065
            if (r2 == 0) goto L_0x004b
            if (r1 != 0) goto L_0x004b
            r8.o = r4
            goto L_0x008a
        L_0x004b:
            androidx.paging.PagedStorage r2 = r8.r()
            r2.i(r10, r8)
            int r10 = r8.o
            int r2 = r0.size()
            int r10 = r10 - r2
            r8.o = r10
            if (r10 <= 0) goto L_0x008a
            boolean r10 = r0.isEmpty()
            r10 = r10 ^ r3
            if (r10 == 0) goto L_0x008a
            goto L_0x008b
        L_0x0065:
            androidx.paging.LoadType r6 = androidx.paging.LoadType.PREPEND
            if (r9 != r6) goto L_0x00fe
            if (r2 == 0) goto L_0x0070
            if (r1 == 0) goto L_0x0070
            r8.n = r4
            goto L_0x008a
        L_0x0070:
            androidx.paging.PagedStorage r2 = r8.r()
            r2.t(r10, r8)
            int r10 = r8.n
            int r2 = r0.size()
            int r10 = r10 - r2
            r8.n = r10
            if (r10 <= 0) goto L_0x008a
            boolean r10 = r0.isEmpty()
            r10 = r10 ^ r3
            if (r10 == 0) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r3 = r4
        L_0x008b:
            boolean r10 = r8.u
            if (r10 == 0) goto L_0x00fa
            if (r1 == 0) goto L_0x00c7
            androidx.paging.LegacyPageFetcher r10 = r8.v
            androidx.paging.PagedList$LoadStateManager r10 = r10.f()
            androidx.paging.LoadState r10 = r10.b()
            boolean r10 = r10 instanceof androidx.paging.LoadState.Loading
            if (r10 != 0) goto L_0x00fa
            androidx.paging.PagedStorage r10 = r8.r()
            boolean r1 = r8.t
            androidx.paging.PagedList$Config r2 = r8.k()
            int r2 = r2.e
            int r4 = r8.p()
            boolean r10 = r10.x(r1, r2, r4, r8)
            if (r10 == 0) goto L_0x00fa
            androidx.paging.LegacyPageFetcher r10 = r8.v
            androidx.paging.PagedList$LoadStateManager r10 = r10.f()
            androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND
            androidx.paging.LoadState$NotLoading$Companion r2 = androidx.paging.LoadState.NotLoading.b
            androidx.paging.LoadState$NotLoading r2 = r2.b()
            r10.d(r1, r2)
            goto L_0x00fa
        L_0x00c7:
            androidx.paging.LegacyPageFetcher r10 = r8.v
            androidx.paging.PagedList$LoadStateManager r10 = r10.f()
            androidx.paging.LoadState r10 = r10.a()
            boolean r10 = r10 instanceof androidx.paging.LoadState.Loading
            if (r10 != 0) goto L_0x00fa
            androidx.paging.PagedStorage r10 = r8.r()
            boolean r1 = r8.t
            androidx.paging.PagedList$Config r2 = r8.k()
            int r2 = r2.e
            int r4 = r8.p()
            boolean r10 = r10.w(r1, r2, r4, r8)
            if (r10 == 0) goto L_0x00fa
            androidx.paging.LegacyPageFetcher r10 = r8.v
            androidx.paging.PagedList$LoadStateManager r10 = r10.f()
            androidx.paging.LoadState$NotLoading$Companion r1 = androidx.paging.LoadState.NotLoading.b
            androidx.paging.LoadState$NotLoading r1 = r1.b()
            r10.d(r5, r1)
        L_0x00fa:
            r8.G(r9, r0)
            return r3
        L_0x00fe:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "unexpected result type "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.ContiguousPagedList.b(androidx.paging.LoadType, androidx.paging.PagingSource$LoadResult$Page):boolean");
    }

    public void c(int i) {
        boolean z = false;
        u(0, i);
        if (r().d() > 0 || r().e() > 0) {
            z = true;
        }
        this.t = z;
    }

    public void d(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        j(loadType, loadState);
    }

    public void e(int i, int i2) {
        t(i, i2);
    }

    public void f(int i, int i2) {
        v(i, i2);
    }

    public void h(int i, int i2, int i3) {
        t(i, i2);
        u(i + i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = r2.k.d(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m() {
        /*
            r2 = this;
            androidx.paging.PagedStorage r0 = r2.r()
            androidx.paging.PagedList$Config r1 = r2.k()
            androidx.paging.PagingState r0 = r0.n(r1)
            if (r0 == 0) goto L_0x0017
            androidx.paging.PagingSource r1 = r2.k
            java.lang.Object r0 = r1.d(r0)
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            java.lang.Object r0 = r2.m
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.ContiguousPagedList.m():java.lang.Object");
    }

    public final PagingSource o() {
        return this.k;
    }

    public void x(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        this.v.f().d(loadType, loadState);
    }
}
