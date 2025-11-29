package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@SourceDebugExtension({"SMAP\nPageKeyedDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageKeyedDataSource.kt\nandroidx/paging/PageKeyedDataSource\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,350:1\n314#2,11:351\n314#2,11:362\n314#2,11:373\n1549#3:384\n1620#3,3:385\n1549#3:388\n1620#3,3:389\n*S KotlinDebug\n*F\n+ 1 PageKeyedDataSource.kt\nandroidx/paging/PageKeyedDataSource\n*L\n202#1:351,11\n236#1:362,11\n241#1:373,11\n344#1:384\n344#1:385,3\n349#1:388\n349#1:389,3\n*E\n"})
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0004+,-.B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0010\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH&¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0014\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0016\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H&¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\u0018\u0010\u0019JC\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\u001a*\u00020\u00012\u001e\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u001c0\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH@ø\u0001\u0000¢\u0006\u0004\b \u0010!J'\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J'\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H@ø\u0001\u0000¢\u0006\u0004\b$\u0010#J7\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00132\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0%2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Landroidx/paging/PageKeyedDataSource;", "", "Key", "Value", "Landroidx/paging/DataSource;", "<init>", "()V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "f", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "callback", "", "p", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "n", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "l", "item", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "ToValue", "Landroidx/arch/core/util/Function;", "", "function", "q", "(Landroidx/arch/core/util/Function;)Landroidx/paging/PageKeyedDataSource;", "o", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "", "isAppend", "j", "(Lkotlinx/coroutines/CancellableContinuation;Z)Landroidx/paging/PageKeyedDataSource$LoadCallback;", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams", "paging-common"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "PageKeyedDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Key, Value>", imports = {"androidx.paging.PagingSource"}))
public abstract class PageKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadCallback;", "Key", "Value", "", "<init>", "()V", "", "data", "adjacentPageKey", "", "a", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadCallback<Key, Value> {
        public abstract void a(List list, Object obj);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005JA\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00018\u00022\b\u0010\f\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "Key", "Value", "", "<init>", "()V", "", "data", "", "position", "totalCount", "previousPageKey", "nextPageKey", "", "a", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void a(List list, int i, int i2, Object obj, Object obj2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "", "Key", "", "requestedLoadSize", "", "placeholdersEnabled", "<init>", "(IZ)V", "a", "I", "b", "Z", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static class LoadInitialParams<Key> {

        /* renamed from: a  reason: collision with root package name */
        public final int f1585a;
        public final boolean b;

        public LoadInitialParams(int i, boolean z) {
            this.f1585a = i;
            this.b = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00028\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadParams;", "", "Key", "key", "", "requestedLoadSize", "<init>", "(Ljava/lang/Object;I)V", "a", "Ljava/lang/Object;", "b", "I", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static class LoadParams<Key> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1586a;
        public final int b;

        public LoadParams(Object obj, int i) {
            Intrinsics.checkNotNullParameter(obj, IntentKey.ACTIVITY.ACTION_KEY);
            this.f1586a = obj;
            this.b = i;
        }
    }

    public PageKeyedDataSource() {
        super(DataSource.KeyType.PAGE_KEYED);
    }

    public Object b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        throw new IllegalStateException("Cannot get key by item in pageKeyedDataSource");
    }

    public final Object f(DataSource.Params params, Continuation continuation) {
        if (params.e() == LoadType.REFRESH) {
            return o(new LoadInitialParams(params.a(), params.d()), continuation);
        }
        if (params.b() == null) {
            return DataSource.BaseResult.f.b();
        }
        if (params.e() == LoadType.PREPEND) {
            return m(new LoadParams(params.b(), params.c()), continuation);
        }
        if (params.e() == LoadType.APPEND) {
            return k(new LoadParams(params.b(), params.c()), continuation);
        }
        throw new IllegalArgumentException("Unsupported type " + params.e());
    }

    public final LoadCallback j(CancellableContinuation cancellableContinuation, boolean z) {
        return new PageKeyedDataSource$continuationAsCallback$1(cancellableContinuation, z);
    }

    public final Object k(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        l(loadParams, j(cancellableContinuationImpl, true));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public abstract void l(LoadParams loadParams, LoadCallback loadCallback);

    public final Object m(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        n(loadParams, j(cancellableContinuationImpl, false));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public abstract void n(LoadParams loadParams, LoadCallback loadCallback);

    public final Object o(LoadInitialParams loadInitialParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        p(loadInitialParams, new PageKeyedDataSource$loadInitial$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public abstract void p(LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback);

    /* renamed from: q */
    public final PageKeyedDataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPageKeyedDataSource(this, function);
    }
}
