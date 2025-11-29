package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;

@SourceDebugExtension({"SMAP\nLegacyPagingSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyPagingSource.kt\nandroidx/paging/LegacyPagingSource\n+ 2 PagingState.kt\nandroidx/paging/PagingState\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,148:1\n142#2,8:149\n1#3:157\n*S KotlinDebug\n*F\n+ 1 LegacyPagingSource.kt\nandroidx/paging/LegacyPagingSource\n*L\n128#1:149,8\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 %*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001&B#\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0000X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010!R\u0014\u0010$\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/paging/LegacyPagingSource;", "", "Key", "Value", "Landroidx/paging/PagingSource;", "Lkotlin/coroutines/CoroutineContext;", "fetchContext", "Landroidx/paging/DataSource;", "dataSource", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroidx/paging/DataSource;)V", "", "pageSize", "", "k", "(I)V", "Landroidx/paging/PagingSource$LoadParams;", "params", "Landroidx/paging/PagingSource$LoadResult;", "f", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PagingState;", "state", "d", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "j", "(Landroidx/paging/PagingSource$LoadParams;)I", "b", "Lkotlin/coroutines/CoroutineContext;", "c", "Landroidx/paging/DataSource;", "i", "()Landroidx/paging/DataSource;", "I", "", "()Z", "jumpingSupported", "e", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final CoroutineContext b;
    public final DataSource c;
    public int d = Integer.MIN_VALUE;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/LegacyPagingSource$Companion;", "", "()V", "PAGE_SIZE_NOT_SET", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.paging.DataSource$KeyType[] r0 = androidx.paging.DataSource.KeyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.paging.DataSource$KeyType r1 = androidx.paging.DataSource.KeyType.POSITIONAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.paging.DataSource$KeyType r1 = androidx.paging.DataSource.KeyType.PAGE_KEYED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.paging.DataSource$KeyType r1 = androidx.paging.DataSource.KeyType.ITEM_KEYED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.LegacyPagingSource.WhenMappings.<clinit>():void");
        }
    }

    public LegacyPagingSource(CoroutineContext coroutineContext, DataSource dataSource) {
        Intrinsics.checkNotNullParameter(coroutineContext, "fetchContext");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.b = coroutineContext;
        this.c = dataSource;
        dataSource.a(new Object() {
            public final void a() {
                LegacyPagingSource.this.e();
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof DataSource.InvalidatedCallback) || !(obj instanceof FunctionAdapter)) {
                    return false;
                }
                return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
            }

            public final Function getFunctionDelegate() {
                return new FunctionReferenceImpl(0, LegacyPagingSource.this, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }
        });
        g(new Function0<Unit>(this) {
            final /* synthetic */ LegacyPagingSource<Key, Value> this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                DataSource i = this.this$0.i();
                final LegacyPagingSource<Key, Value> legacyPagingSource = this.this$0;
                i.h(new Object() {
                    public final void a() {
                        LegacyPagingSource.this.e();
                    }

                    public final boolean equals(Object obj) {
                        if (!(obj instanceof DataSource.InvalidatedCallback) || !(obj instanceof FunctionAdapter)) {
                            return false;
                        }
                        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
                    }

                    public final Function getFunctionDelegate() {
                        return new FunctionReferenceImpl(0, LegacyPagingSource.this, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
                    }

                    public final int hashCode() {
                        return getFunctionDelegate().hashCode();
                    }
                });
                this.this$0.i().d();
            }
        });
    }

    public boolean b() {
        return this.c.c() == DataSource.KeyType.POSITIONAL;
    }

    public Object d(PagingState pagingState) {
        int i;
        Object b2;
        Intrinsics.checkNotNullParameter(pagingState, "state");
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.c.c().ordinal()];
        if (i2 == 1) {
            Integer d2 = pagingState.d();
            if (d2 == null) {
                return null;
            }
            int intValue = d2.intValue();
            int a2 = intValue - pagingState.d;
            int i3 = 0;
            while (i3 < CollectionsKt.getLastIndex(pagingState.f()) && a2 > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) pagingState.f().get(i3)).b())) {
                a2 -= ((PagingSource.LoadResult.Page) pagingState.f().get(i3)).b().size();
                i3++;
            }
            PagingSource.LoadResult.Page c2 = pagingState.c(intValue);
            if (c2 == null || (i = c2.f()) == null) {
                i = 0;
            }
            Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Int");
            return Integer.valueOf(((Integer) i).intValue() + a2);
        } else if (i2 == 2) {
            return null;
        } else {
            if (i2 == 3) {
                Integer d3 = pagingState.d();
                if (d3 == null || (b2 = pagingState.b(d3.intValue())) == null) {
                    return null;
                }
                return this.c.b(b2);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public Object f(PagingSource.LoadParams loadParams, Continuation continuation) {
        LoadType loadType;
        if (loadParams instanceof PagingSource.LoadParams.Refresh) {
            loadType = LoadType.REFRESH;
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            loadType = LoadType.APPEND;
        } else if (loadParams instanceof PagingSource.LoadParams.Prepend) {
            loadType = LoadType.PREPEND;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        LoadType loadType2 = loadType;
        if (this.d == Integer.MIN_VALUE) {
            System.out.println("WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            this.d = j(loadParams);
        }
        return BuildersKt.g(this.b, new LegacyPagingSource$load$2(this, new DataSource.Params(loadType2, loadParams.a(), loadParams.b(), loadParams.c(), this.d), loadParams, (Continuation<? super LegacyPagingSource$load$2>) null), continuation);
    }

    public final DataSource i() {
        return this.c;
    }

    public final int j(PagingSource.LoadParams loadParams) {
        return (!(loadParams instanceof PagingSource.LoadParams.Refresh) || loadParams.b() % 3 != 0) ? loadParams.b() : loadParams.b() / 3;
    }

    public final void k(int i) {
        int i2 = this.d;
        if (i2 == Integer.MIN_VALUE || i == i2) {
            this.d = i;
            return;
        }
        throw new IllegalStateException(("Page size is already set to " + this.d + '.').toString());
    }
}
