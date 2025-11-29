package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002FGBW\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0013H\u0002¢\u0006\u0004\b$\u0010\u0015J\u000f\u0010%\u001a\u00020\u0013H\u0002¢\u0006\u0004\b%\u0010\u0015J\u000f\u0010&\u001a\u00020\u0013H\u0002¢\u0006\u0004\b&\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u00102R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00107R\u0014\u0010:\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00109R(\u0010B\u001a\u00020;8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b<\u0010=\u0012\u0004\bA\u0010\u0015\u001a\u0004\b3\u0010>\"\u0004\b?\u0010@R\u0011\u0010E\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\b<\u0010D¨\u0006H"}, d2 = {"Landroidx/paging/LegacyPageFetcher;", "", "K", "V", "Lkotlinx/coroutines/CoroutineScope;", "pagedListScope", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagingSource;", "source", "Lkotlinx/coroutines/CoroutineDispatcher;", "notifyDispatcher", "fetchDispatcher", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "pageConsumer", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "keyProvider", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/LegacyPageFetcher$PageConsumer;Landroidx/paging/LegacyPageFetcher$KeyProvider;)V", "", "e", "()V", "Landroidx/paging/LoadType;", "type", "Landroidx/paging/PagingSource$LoadParams;", "params", "n", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadParams;)V", "Landroidx/paging/PagingSource$LoadResult$Page;", "value", "l", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)V", "", "throwable", "j", "(Landroidx/paging/LoadType;Ljava/lang/Throwable;)V", "k", "o", "m", "a", "Lkotlinx/coroutines/CoroutineScope;", "b", "Landroidx/paging/PagedList$Config;", "getConfig", "()Landroidx/paging/PagedList$Config;", "c", "Landroidx/paging/PagingSource;", "h", "()Landroidx/paging/PagingSource;", "d", "Lkotlinx/coroutines/CoroutineDispatcher;", "f", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "g", "()Landroidx/paging/LegacyPageFetcher$PageConsumer;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "detached", "Landroidx/paging/PagedList$LoadStateManager;", "i", "Landroidx/paging/PagedList$LoadStateManager;", "()Landroidx/paging/PagedList$LoadStateManager;", "setLoadStateManager", "(Landroidx/paging/PagedList$LoadStateManager;)V", "getLoadStateManager$annotations", "loadStateManager", "", "()Z", "isDetached", "KeyProvider", "PageConsumer", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class LegacyPageFetcher<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f1550a;
    public final PagedList.Config b;
    public final PagingSource c;
    public final CoroutineDispatcher d;
    public final CoroutineDispatcher e;
    public final PageConsumer f;
    public final KeyProvider g;
    public final AtomicBoolean h = new AtomicBoolean(false);
    public PagedList.LoadStateManager i = new LegacyPageFetcher$loadStateManager$1(this);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b`\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00018\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00018\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/paging/LegacyPageFetcher$KeyProvider;", "", "K", "h", "()Ljava/lang/Object;", "prevKey", "a", "nextKey", "paging-common"}, k = 1, mv = {1, 8, 0})
    public interface KeyProvider<K> {
        Object a();

        Object h();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/paging/LegacyPageFetcher$PageConsumer;", "", "V", "Landroidx/paging/LoadType;", "type", "Landroidx/paging/PagingSource$LoadResult$Page;", "page", "", "b", "(Landroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/LoadState;", "state", "", "d", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public interface PageConsumer<V> {
        boolean b(LoadType loadType, PagingSource.LoadResult.Page page);

        void d(LoadType loadType, LoadState loadState);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.paging.LoadType[] r0 = androidx.paging.LoadType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.LegacyPageFetcher.WhenMappings.<clinit>():void");
        }
    }

    public LegacyPageFetcher(CoroutineScope coroutineScope, PagedList.Config config, PagingSource pagingSource, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, PageConsumer pageConsumer, KeyProvider keyProvider) {
        Intrinsics.checkNotNullParameter(coroutineScope, "pagedListScope");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSource, "source");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "fetchDispatcher");
        Intrinsics.checkNotNullParameter(pageConsumer, "pageConsumer");
        Intrinsics.checkNotNullParameter(keyProvider, "keyProvider");
        this.f1550a = coroutineScope;
        this.b = config;
        this.c = pagingSource;
        this.d = coroutineDispatcher;
        this.e = coroutineDispatcher2;
        this.f = pageConsumer;
        this.g = keyProvider;
    }

    public final void e() {
        this.h.set(true);
    }

    public final PagedList.LoadStateManager f() {
        return this.i;
    }

    public final PageConsumer g() {
        return this.f;
    }

    public final PagingSource h() {
        return this.c;
    }

    public final boolean i() {
        return this.h.get();
    }

    public final void j(LoadType loadType, Throwable th) {
        if (!i()) {
            this.i.d(loadType, new LoadState.Error(th));
        }
    }

    public final void k() {
        this.c.e();
        e();
    }

    public final void l(LoadType loadType, PagingSource.LoadResult.Page page) {
        if (!i()) {
            if (this.f.b(loadType, page)) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
                if (i2 == 1) {
                    o();
                } else if (i2 == 2) {
                    m();
                } else {
                    throw new IllegalStateException("Can only fetch more during append/prepend");
                }
            } else {
                this.i.d(loadType, page.b().isEmpty() ? LoadState.NotLoading.b.a() : LoadState.NotLoading.b.b());
            }
        }
    }

    public final void m() {
        Object a2 = this.g.a();
        if (a2 == null) {
            l(LoadType.APPEND, PagingSource.LoadResult.Page.f.a());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.i;
        LoadType loadType = LoadType.APPEND;
        loadStateManager.d(loadType, LoadState.Loading.b);
        PagedList.Config config = this.b;
        n(loadType, new PagingSource.LoadParams.Append(a2, config.f1591a, config.c));
    }

    public final void n(LoadType loadType, PagingSource.LoadParams loadParams) {
        Job unused = BuildersKt__Builders_commonKt.d(this.f1550a, this.e, (CoroutineStart) null, new LegacyPageFetcher$scheduleLoad$1(this, loadParams, loadType, (Continuation<? super LegacyPageFetcher$scheduleLoad$1>) null), 2, (Object) null);
    }

    public final void o() {
        Object h2 = this.g.h();
        if (h2 == null) {
            l(LoadType.PREPEND, PagingSource.LoadResult.Page.f.a());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.i;
        LoadType loadType = LoadType.PREPEND;
        loadStateManager.d(loadType, LoadState.Loading.b);
        PagedList.Config config = this.b;
        n(loadType, new PagingSource.LoadParams.Prepend(h2, config.f1591a, config.c));
    }
}
