package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@SourceDebugExtension({"SMAP\nItemKeyedDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemKeyedDataSource.kt\nandroidx/paging/ItemKeyedDataSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,350:1\n1#2:351\n314#3,11:352\n314#3,11:363\n314#3,11:374\n1549#4:385\n1620#4,3:386\n1549#4:389\n1620#4,3:390\n*S KotlinDebug\n*F\n+ 1 ItemKeyedDataSource.kt\nandroidx/paging/ItemKeyedDataSource\n*L\n187#1:352,11\n232#1:363,11\n238#1:374,11\n343#1:385\n343#1:386,3\n348#1:389\n348#1:390,3\n*E\n"})
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001'\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0004*+,-B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011J+\u0010\u0016\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0019\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001b\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\u001f\u0010\u001eJC\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010 *\u00020\u00012\u001e\u0010#\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\"0!¢\u0006\u0004\b$\u0010%J+\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0&H\u0002¢\u0006\u0004\b(\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Landroidx/paging/ItemKeyedDataSource;", "", "Key", "Value", "Landroidx/paging/DataSource;", "<init>", "()V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "f", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "q", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "o", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "callback", "", "p", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;)V", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "l", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Landroidx/paging/ItemKeyedDataSource$LoadCallback;)V", "n", "item", "k", "(Ljava/lang/Object;)Ljava/lang/Object;", "b", "ToValue", "Landroidx/arch/core/util/Function;", "", "function", "r", "(Landroidx/arch/core/util/Function;)Landroidx/paging/ItemKeyedDataSource;", "Lkotlinx/coroutines/CancellableContinuation;", "androidx/paging/ItemKeyedDataSource$asCallback$1", "j", "(Lkotlinx/coroutines/CancellableContinuation;)Landroidx/paging/ItemKeyedDataSource$asCallback$1;", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams", "paging-common"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "ItemKeyedDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Key, Value>", imports = {"androidx.paging.PagingSource"}))
public abstract class ItemKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "Value", "", "<init>", "()V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadCallback<Value> {
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "Value", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "<init>", "()V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u0004\u0018\u00018\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "", "Key", "requestedInitialKey", "", "requestedLoadSize", "", "placeholdersEnabled", "<init>", "(Ljava/lang/Object;IZ)V", "a", "Ljava/lang/Object;", "b", "I", "c", "Z", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static class LoadInitialParams<Key> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1545a;
        public final int b;
        public final boolean c;

        public LoadInitialParams(Object obj, int i, boolean z) {
            this.f1545a = obj;
            this.b = i;
            this.c = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00028\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadParams;", "", "Key", "key", "", "requestedLoadSize", "<init>", "(Ljava/lang/Object;I)V", "a", "Ljava/lang/Object;", "b", "I", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static class LoadParams<Key> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1546a;
        public final int b;

        public LoadParams(Object obj, int i) {
            Intrinsics.checkNotNullParameter(obj, IntentKey.ACTIVITY.ACTION_KEY);
            this.f1546a = obj;
            this.b = i;
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.ItemKeyedDataSource.WhenMappings.<clinit>():void");
        }
    }

    public ItemKeyedDataSource() {
        super(DataSource.KeyType.ITEM_KEYED);
    }

    public Object b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        return k(obj);
    }

    public final Object f(DataSource.Params params, Continuation continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[params.e().ordinal()];
        if (i == 1) {
            return q(new LoadInitialParams(params.b(), params.a(), params.d()), continuation);
        }
        if (i == 2) {
            Object b = params.b();
            Intrinsics.checkNotNull(b);
            return o(new LoadParams(b, params.c()), continuation);
        } else if (i == 3) {
            Object b2 = params.b();
            Intrinsics.checkNotNull(b2);
            return m(new LoadParams(b2, params.c()), continuation);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final ItemKeyedDataSource$asCallback$1 j(CancellableContinuation cancellableContinuation) {
        return new ItemKeyedDataSource$asCallback$1(cancellableContinuation, this);
    }

    public abstract Object k(Object obj);

    public abstract void l(LoadParams loadParams, LoadCallback loadCallback);

    public final Object m(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        l(loadParams, j(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public abstract void n(LoadParams loadParams, LoadCallback loadCallback);

    public final Object o(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        n(loadParams, j(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public abstract void p(LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback);

    public final Object q(LoadInitialParams loadInitialParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        p(loadInitialParams, new ItemKeyedDataSource$loadInitial$2$1(cancellableContinuationImpl, this));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* renamed from: r */
    public final ItemKeyedDataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperItemKeyedDataSource(this, function);
    }
}
