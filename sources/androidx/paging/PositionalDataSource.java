package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@SourceDebugExtension({"SMAP\nPositionalDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PositionalDataSource.kt\nandroidx/paging/PositionalDataSource\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,506:1\n314#2,11:507\n314#2,11:518\n1549#3:529\n1620#3,3:530\n1549#3:533\n1620#3,3:534\n*S KotlinDebug\n*F\n+ 1 PositionalDataSource.kt\nandroidx/paging/PositionalDataSource\n*L\n360#1:507,11\n428#1:518,11\n500#1:529\n500#1:530,3\n504#1:533\n504#1:534,3\n*E\n"})
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000b\b'\u0018\u0000 \n*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0005#$%&'B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ=\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001b*\u00020\u00012\u001e\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001c¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\b\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/paging/PositionalDataSource;", "", "T", "Landroidx/paging/DataSource;", "", "<init>", "()V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "f", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "m", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "callback", "", "l", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Landroidx/paging/PositionalDataSource$LoadInitialCallback;)V", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "o", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Landroidx/paging/PositionalDataSource$LoadRangeCallback;)V", "item", "k", "(Ljava/lang/Object;)Ljava/lang/Integer;", "V", "Landroidx/arch/core/util/Function;", "", "function", "p", "(Landroidx/arch/core/util/Function;)Landroidx/paging/PositionalDataSource;", "n", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "LoadInitialCallback", "LoadInitialParams", "LoadRangeCallback", "LoadRangeParams", "paging-common"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "PositionalDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Int, T>", imports = {"androidx.paging.PagingSource"}))
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    @RestrictTo
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/paging/PositionalDataSource$Companion;", "", "<init>", "()V", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "params", "", "totalCount", "a", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;I)I", "initialLoadPosition", "b", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;II)I", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(LoadInitialParams loadInitialParams, int i) {
            Intrinsics.checkNotNullParameter(loadInitialParams, PayloadConstant.KEY_PARAMS);
            int i2 = loadInitialParams.f1623a;
            int i3 = loadInitialParams.b;
            int i4 = loadInitialParams.c;
            return Math.max(0, Math.min(((((i - i3) + i4) - 1) / i4) * i4, (i2 / i4) * i4));
        }

        public final int b(LoadInitialParams loadInitialParams, int i, int i2) {
            Intrinsics.checkNotNullParameter(loadInitialParams, PayloadConstant.KEY_PARAMS);
            return Math.min(i2 - i, loadInitialParams.b);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "T", "", "<init>", "()V", "", "data", "", "position", "totalCount", "", "a", "(Ljava/util/List;II)V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadInitialCallback<T> {
        public abstract void a(List list, int i, int i2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialParams;", "", "", "requestedStartPosition", "requestedLoadSize", "pageSize", "", "placeholdersEnabled", "<init>", "(IIIZ)V", "a", "I", "b", "c", "d", "Z", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static class LoadInitialParams {

        /* renamed from: a  reason: collision with root package name */
        public final int f1623a;
        public final int b;
        public final int c;
        public final boolean d;

        public LoadInitialParams(int i, int i2, int i3, boolean z) {
            this.f1623a = i;
            this.b = i2;
            this.c = i3;
            this.d = z;
            if (i < 0) {
                throw new IllegalStateException(("invalid start position: " + i).toString());
            } else if (i2 < 0) {
                throw new IllegalStateException(("invalid load size: " + i2).toString());
            } else if (i3 < 0) {
                throw new IllegalStateException(("invalid page size: " + i3).toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "T", "", "<init>", "()V", "", "data", "", "a", "(Ljava/util/List;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadRangeCallback<T> {
        public abstract void a(List list);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeParams;", "", "", "startPosition", "loadSize", "<init>", "(II)V", "a", "I", "b", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static class LoadRangeParams {

        /* renamed from: a  reason: collision with root package name */
        public final int f1624a;
        public final int b;

        public LoadRangeParams(int i, int i2) {
            this.f1624a = i;
            this.b = i2;
        }
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    public static final int i(LoadInitialParams loadInitialParams, int i) {
        return f.a(loadInitialParams, i);
    }

    public static final int j(LoadInitialParams loadInitialParams, int i, int i2) {
        return f.b(loadInitialParams, i, i2);
    }

    public final Object f(DataSource.Params params, Continuation continuation) {
        if (params.e() == LoadType.REFRESH) {
            int a2 = params.a();
            int i = 0;
            if (params.b() != null) {
                int intValue = ((Number) params.b()).intValue();
                if (params.d()) {
                    a2 = Math.max(a2 / params.c(), 2) * params.c();
                    i = Math.max(0, ((intValue - (a2 / 2)) / params.c()) * params.c());
                } else {
                    i = Math.max(0, intValue - (a2 / 2));
                }
            }
            return m(new LoadInitialParams(i, a2, params.c(), params.d()), continuation);
        }
        Object b = params.b();
        Intrinsics.checkNotNull(b);
        int intValue2 = ((Number) b).intValue();
        int c = params.c();
        if (params.e() == LoadType.PREPEND) {
            c = Math.min(c, intValue2);
            intValue2 -= c;
        }
        return n(new LoadRangeParams(intValue2, c), continuation);
    }

    /* renamed from: k */
    public final Integer b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    public abstract void l(LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback);

    public final Object m(LoadInitialParams loadInitialParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        l(loadInitialParams, new PositionalDataSource$loadInitial$2$1(this, cancellableContinuationImpl, loadInitialParams));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final Object n(LoadRangeParams loadRangeParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        o(loadRangeParams, new PositionalDataSource$loadRange$2$1(loadRangeParams, this, cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public abstract void o(LoadRangeParams loadRangeParams, LoadRangeCallback loadRangeCallback);

    /* renamed from: p */
    public final PositionalDataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPositionalDataSource(this, function);
    }
}
