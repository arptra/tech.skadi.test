package androidx.paging;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.paging.LoadState;
import androidx.paging.PagingSource;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nPagedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagedList.kt\nandroidx/paging/PagedList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1314:1\n1855#2,2:1315\n1855#2,2:1317\n1855#2,2:1319\n*S KotlinDebug\n*F\n+ 1 PagedList.kt\nandroidx/paging/PagedList\n*L\n1257#1:1315,2\n1266#1:1317,2\n1275#1:1319,2\n*E\n"})
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u0000  *\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0006UVWXYZBA\b\u0000\u0012\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0015H\u0000¢\u0006\u0004\b \u0010\u0019J\u001a\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0000¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0007¢\u0006\u0004\b(\u0010'J\u001f\u0010)\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0007¢\u0006\u0004\b)\u0010'R$\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00048\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u0010\t\u001a\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0000X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010\u001dR\u001a\u0010F\u001a\u00020\u00108\u0000X\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0012R \u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0H0G8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR2\u0010O\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00170M0H0G8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010KR\u0014\u0010Q\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0012R\u0016\u0010T\u001a\u0004\u0018\u00010\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006["}, d2 = {"Landroidx/paging/PagedList;", "", "T", "Ljava/util/AbstractList;", "Landroidx/paging/PagingSource;", "pagingSource", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineDispatcher;", "notifyDispatcher", "Landroidx/paging/PagedStorage;", "storage", "Landroidx/paging/PagedList$Config;", "config", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedStorage;Landroidx/paging/PagedList$Config;)V", "", "s", "()I", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/LoadState;", "loadState", "", "x", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "Ljava/lang/Runnable;", "refreshRetryCallback", "y", "(Ljava/lang/Runnable;)V", "type", "state", "j", "index", "get", "(I)Ljava/lang/Object;", "position", "count", "u", "(II)V", "t", "v", "a", "Landroidx/paging/PagingSource;", "o", "()Landroidx/paging/PagingSource;", "b", "Lkotlinx/coroutines/CoroutineScope;", "l", "()Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "n", "()Lkotlinx/coroutines/CoroutineDispatcher;", "d", "Landroidx/paging/PagedStorage;", "r", "()Landroidx/paging/PagedStorage;", "e", "Landroidx/paging/PagedList$Config;", "k", "()Landroidx/paging/PagedList$Config;", "f", "Ljava/lang/Runnable;", "getRefreshRetryCallback$paging_common", "()Ljava/lang/Runnable;", "setRefreshRetryCallback$paging_common", "g", "I", "p", "requiredRemainder", "", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "h", "Ljava/util/List;", "callbacks", "Lkotlin/Function2;", "i", "loadStateListeners", "q", "size", "m", "()Ljava/lang/Object;", "lastKey", "BoundaryCallback", "Builder", "Callback", "Companion", "Config", "LoadStateManager", "paging-common"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
public abstract class PagedList<T> extends AbstractList<T> {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final PagingSource f1590a;
    public final CoroutineScope b;
    public final CoroutineDispatcher c;
    public final PagedStorage d;
    public final Config e;
    public Runnable f;
    public final int g;
    public final List h = new ArrayList();
    public final List i = new ArrayList();

    @MainThread
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b'\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/paging/PagedList$BoundaryCallback;", "", "T", "", "c", "()V", "itemAtFront", "b", "(Ljava/lang/Object;)V", "itemAtEnd", "a", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class BoundaryCallback<T> {
        public void a(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "itemAtEnd");
        }

        public void b(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "itemAtFront");
        }

        public void c() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u0001*\b\b\u0002\u0010\u0003*\u00020\u00012\u00020\u0001¨\u0006\u0004"}, d2 = {"Landroidx/paging/PagedList$Builder;", "", "Key", "Value", "paging-common"}, k = 1, mv = {1, 8, 0})
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData, which no longer supports constructing snapshots of loaded data manually.", replaceWith = @ReplaceWith(expression = "Pager.flow", imports = {"androidx.paging.Pager"}))
    public static final class Builder<Key, Value> {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/paging/PagedList$Callback;", "", "", "position", "count", "", "a", "(II)V", "b", "c", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class Callback {
        public abstract void a(int i, int i2);

        public abstract void b(int i, int i2);

        public abstract void c(int i, int i2);
    }

    @RestrictTo
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0014\"\b\b\u0001\u0010\u0004*\u00020\u0001\"\b\b\u0002\u0010\u0005*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/paging/PagedList$Companion;", "", "<init>", "()V", "K", "T", "Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialPage", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineDispatcher;", "notifyDispatcher", "fetchDispatcher", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Landroidx/paging/PagedList$Config;", "config", "key", "Landroidx/paging/PagedList;", "a", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagedList;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PagedList a(PagingSource pagingSource, PagingSource.LoadResult.Page page, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, BoundaryCallback boundaryCallback, Config config, Object obj) {
            PagingSource.LoadResult.Page page2;
            PagingSource pagingSource2 = pagingSource;
            Config config2 = config;
            Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
            CoroutineScope coroutineScope2 = coroutineScope;
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            CoroutineDispatcher coroutineDispatcher3 = coroutineDispatcher;
            Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
            CoroutineDispatcher coroutineDispatcher4 = coroutineDispatcher2;
            Intrinsics.checkNotNullParameter(coroutineDispatcher2, "fetchDispatcher");
            Intrinsics.checkNotNullParameter(config2, "config");
            if (page == null) {
                page2 = (PagingSource.LoadResult.Page) BuildersKt__BuildersKt.b((CoroutineContext) null, new PagedList$Companion$create$resolvedInitialPage$1(pagingSource, new PagingSource.LoadParams.Refresh(obj, config2.d, config2.c), (Continuation<? super PagedList$Companion$create$resolvedInitialPage$1>) null), 1, (Object) null);
            } else {
                Object obj2 = obj;
                page2 = page;
            }
            return new ContiguousPagedList(pagingSource, coroutineScope, coroutineDispatcher, coroutineDispatcher2, boundaryCallback, config, page2, obj);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0012R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0013"}, d2 = {"Landroidx/paging/PagedList$Config;", "", "", "a", "I", "pageSize", "b", "prefetchDistance", "", "c", "Z", "enablePlaceholders", "d", "initialLoadSizeHint", "e", "maxSize", "f", "Builder", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Config {
        public static final Companion f = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final int f1591a;
        public final int b;
        public final boolean c;
        public final int d;
        public final int e;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PagedList$Config$Builder;", "", "a", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public static final Companion f1592a = new Companion((DefaultConstructorMarker) null);

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/PagedList$Config$Builder$Companion;", "", "()V", "DEFAULT_INITIAL_PAGE_MULTIPLIER", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PagedList$Config$Companion;", "", "<init>", "()V", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }
    }

    @RestrictTo
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\u000b\u0010\nR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/paging/PagedList$LoadStateManager;", "", "<init>", "()V", "Landroidx/paging/LoadType;", "type", "Landroidx/paging/LoadState;", "state", "", "d", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "c", "a", "Landroidx/paging/LoadState;", "getRefreshState", "()Landroidx/paging/LoadState;", "setRefreshState", "(Landroidx/paging/LoadState;)V", "refreshState", "b", "setStartState", "startState", "setEndState", "endState", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadStateManager {

        /* renamed from: a  reason: collision with root package name */
        public LoadState f1593a;
        public LoadState b;
        public LoadState c;

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
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagedList.LoadStateManager.WhenMappings.<clinit>():void");
            }
        }

        public LoadStateManager() {
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.b;
            this.f1593a = companion.b();
            this.b = companion.b();
            this.c = companion.b();
        }

        public final LoadState a() {
            return this.c;
        }

        public final LoadState b() {
            return this.b;
        }

        public abstract void c(LoadType loadType, LoadState loadState);

        public final void d(LoadType loadType, LoadState loadState) {
            Intrinsics.checkNotNullParameter(loadType, "type");
            Intrinsics.checkNotNullParameter(loadState, "state");
            int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (!Intrinsics.areEqual((Object) this.c, (Object) loadState)) {
                            this.c = loadState;
                        } else {
                            return;
                        }
                    }
                } else if (!Intrinsics.areEqual((Object) this.b, (Object) loadState)) {
                    this.b = loadState;
                } else {
                    return;
                }
            } else if (!Intrinsics.areEqual((Object) this.f1593a, (Object) loadState)) {
                this.f1593a = loadState;
            } else {
                return;
            }
            c(loadType, loadState);
        }
    }

    public PagedList(PagingSource pagingSource, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, PagedStorage pagedStorage, Config config) {
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(pagedStorage, "storage");
        Intrinsics.checkNotNullParameter(config, "config");
        this.f1590a = pagingSource;
        this.b = coroutineScope;
        this.c = coroutineDispatcher;
        this.d = pagedStorage;
        this.e = config;
        this.g = (config.b * 2) + config.f1591a;
    }

    public Object get(int i2) {
        return this.d.get(i2);
    }

    public final void j(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        Job unused = BuildersKt__Builders_commonKt.d(this.b, this.c, (CoroutineStart) null, new PagedList$dispatchStateChangeAsync$1(this, loadType, loadState, (Continuation<? super PagedList$dispatchStateChangeAsync$1>) null), 2, (Object) null);
    }

    public final Config k() {
        return this.e;
    }

    public final CoroutineScope l() {
        return this.b;
    }

    public abstract Object m();

    public final CoroutineDispatcher n() {
        return this.c;
    }

    public PagingSource o() {
        return this.f1590a;
    }

    public final int p() {
        return this.g;
    }

    public int q() {
        return this.d.size();
    }

    public final PagedStorage r() {
        return this.d;
    }

    public final /* bridge */ Object remove(int i2) {
        return w(i2);
    }

    public final int s() {
        return this.d.k();
    }

    public final /* bridge */ int size() {
        return q();
    }

    public final void t(int i2, int i3) {
        if (i3 != 0) {
            for (WeakReference weakReference : CollectionsKt.reversed(this.h)) {
                Callback callback = (Callback) weakReference.get();
                if (callback != null) {
                    callback.a(i2, i3);
                }
            }
        }
    }

    public final void u(int i2, int i3) {
        if (i3 != 0) {
            for (WeakReference weakReference : CollectionsKt.reversed(this.h)) {
                Callback callback = (Callback) weakReference.get();
                if (callback != null) {
                    callback.b(i2, i3);
                }
            }
        }
    }

    public final void v(int i2, int i3) {
        if (i3 != 0) {
            for (WeakReference weakReference : CollectionsKt.reversed(this.h)) {
                Callback callback = (Callback) weakReference.get();
                if (callback != null) {
                    callback.c(i2, i3);
                }
            }
        }
    }

    public /* bridge */ Object w(int i2) {
        return super.remove(i2);
    }

    public void x(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
    }

    public final void y(Runnable runnable) {
        this.f = runnable;
    }
}
