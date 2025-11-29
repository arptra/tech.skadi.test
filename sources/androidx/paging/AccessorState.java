package androidx.paging;

import androidx.paging.LoadState;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nRemoteMediatorAccessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteMediatorAccessor.kt\nandroidx/paging/AccessorState\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,460:1\n1747#2,3:461\n288#2,2:464\n288#2,2:466\n288#2,2:468\n*S KotlinDebug\n*F\n+ 1 RemoteMediatorAccessor.kt\nandroidx/paging/AccessorState\n*L\n133#1:461,3\n173#1:464,2\n220#1:466,2\n224#1:468,2\n*E\n"})
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u0005J\u0015\u0010\u001b\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u0005J\u001f\u0010 \u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010&R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010(R&\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010+0*8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010,R\"\u00103\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00066"}, d2 = {"Landroidx/paging/AccessorState;", "", "Key", "Value", "<init>", "()V", "Landroidx/paging/LoadStates;", "e", "()Landroidx/paging/LoadStates;", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/PagingState;", "pagingState", "", "a", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)Z", "Landroidx/paging/AccessorState$BlockState;", "state", "", "j", "(Landroidx/paging/LoadType;Landroidx/paging/AccessorState$BlockState;)V", "h", "()Landroidx/paging/PagingState;", "Lkotlin/Pair;", "g", "()Lkotlin/Pair;", "d", "c", "(Landroidx/paging/LoadType;)V", "b", "Landroidx/paging/LoadState$Error;", "errorState", "k", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState$Error;)V", "Landroidx/paging/LoadState;", "f", "(Landroidx/paging/LoadType;)Landroidx/paging/LoadState;", "", "[Landroidx/paging/AccessorState$BlockState;", "blockStates", "[Landroidx/paging/LoadState$Error;", "errors", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/AccessorState$PendingRequest;", "Lkotlin/collections/ArrayDeque;", "pendingRequests", "Z", "i", "()Z", "l", "(Z)V", "refreshAllowed", "BlockState", "PendingRequest", "paging-common"}, k = 1, mv = {1, 8, 0})
final class AccessorState<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final BlockState[] f1510a;
    public final LoadState.Error[] b;
    public final ArrayDeque c;
    public boolean d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/AccessorState$BlockState;", "", "(Ljava/lang/String;I)V", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum BlockState {
        UNBLOCKED,
        COMPLETED,
        REQUIRES_REFRESH
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR.\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/paging/AccessorState$PendingRequest;", "", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/PagingState;", "pagingState", "<init>", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "a", "Landroidx/paging/LoadType;", "()Landroidx/paging/LoadType;", "b", "Landroidx/paging/PagingState;", "()Landroidx/paging/PagingState;", "c", "(Landroidx/paging/PagingState;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class PendingRequest<Key, Value> {

        /* renamed from: a  reason: collision with root package name */
        public final LoadType f1511a;
        public PagingState b;

        public PendingRequest(LoadType loadType, PagingState pagingState) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(pagingState, "pagingState");
            this.f1511a = loadType;
            this.b = pagingState;
        }

        public final LoadType a() {
            return this.f1511a;
        }

        public final PagingState b() {
            return this.b;
        }

        public final void c(PagingState pagingState) {
            Intrinsics.checkNotNullParameter(pagingState, "<set-?>");
            this.b = pagingState;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|(2:1|2)|3|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                androidx.paging.LoadType[] r0 = androidx.paging.LoadType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.paging.LoadType r2 = androidx.paging.LoadType.REFRESH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                $EnumSwitchMapping$0 = r0
                androidx.paging.AccessorState$BlockState[] r0 = androidx.paging.AccessorState.BlockState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.paging.AccessorState$BlockState r2 = androidx.paging.AccessorState.BlockState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                androidx.paging.AccessorState$BlockState r1 = androidx.paging.AccessorState.BlockState.REQUIRES_REFRESH     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                androidx.paging.AccessorState$BlockState r1 = androidx.paging.AccessorState.BlockState.UNBLOCKED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.AccessorState.WhenMappings.<clinit>():void");
        }
    }

    public AccessorState() {
        int length = LoadType.values().length;
        BlockState[] blockStateArr = new BlockState[length];
        for (int i = 0; i < length; i++) {
            blockStateArr[i] = BlockState.UNBLOCKED;
        }
        this.f1510a = blockStateArr;
        int length2 = LoadType.values().length;
        LoadState.Error[] errorArr = new LoadState.Error[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            errorArr[i2] = null;
        }
        this.b = errorArr;
        this.c = new ArrayDeque();
    }

    public final boolean a(LoadType loadType, PagingState pagingState) {
        Object obj;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((PendingRequest) obj).a() == loadType) {
                break;
            }
        }
        PendingRequest pendingRequest = (PendingRequest) obj;
        if (pendingRequest != null) {
            pendingRequest.c(pagingState);
            return false;
        }
        BlockState blockState = this.f1510a[loadType.ordinal()];
        if (blockState == BlockState.REQUIRES_REFRESH && loadType != LoadType.REFRESH) {
            this.c.add(new PendingRequest(loadType, pagingState));
            return false;
        } else if (blockState != BlockState.UNBLOCKED && loadType != LoadType.REFRESH) {
            return false;
        } else {
            LoadType loadType2 = LoadType.REFRESH;
            if (loadType == loadType2) {
                k(loadType2, (LoadState.Error) null);
            }
            if (this.b[loadType.ordinal()] == null) {
                return this.c.add(new PendingRequest(loadType, pagingState));
            }
            return false;
        }
    }

    public final void b() {
        int length = this.b.length;
        for (int i = 0; i < length; i++) {
            this.b[i] = null;
        }
    }

    public final void c(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        CollectionsKt.removeAll(this.c, new AccessorState$clearPendingRequest$1(loadType));
    }

    public final void d() {
        this.c.clear();
    }

    public final LoadStates e() {
        return new LoadStates(f(LoadType.REFRESH), f(LoadType.PREPEND), f(LoadType.APPEND));
    }

    public final LoadState f(LoadType loadType) {
        BlockState blockState = this.f1510a[loadType.ordinal()];
        ArrayDeque arrayDeque = this.c;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((PendingRequest) it.next()).a() == loadType) {
                    if (blockState != BlockState.REQUIRES_REFRESH) {
                        return LoadState.Loading.b;
                    }
                }
            }
        }
        LoadState.Error error = this.b[loadType.ordinal()];
        if (error != null) {
            return error;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[blockState.ordinal()];
        if (i == 1) {
            return WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1 ? LoadState.NotLoading.b.b() : LoadState.NotLoading.b.a();
        }
        if (i == 2) {
            return LoadState.NotLoading.b.b();
        }
        if (i == 3) {
            return LoadState.NotLoading.b.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Pair g() {
        Object obj;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            PendingRequest pendingRequest = (PendingRequest) obj;
            if (pendingRequest.a() != LoadType.REFRESH && this.f1510a[pendingRequest.a().ordinal()] == BlockState.UNBLOCKED) {
                break;
            }
        }
        PendingRequest pendingRequest2 = (PendingRequest) obj;
        if (pendingRequest2 != null) {
            return TuplesKt.to(pendingRequest2.a(), pendingRequest2.b());
        }
        return null;
    }

    public final PagingState h() {
        Object obj;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((PendingRequest) obj).a() == LoadType.REFRESH) {
                break;
            }
        }
        PendingRequest pendingRequest = (PendingRequest) obj;
        if (pendingRequest != null) {
            return pendingRequest.b();
        }
        return null;
    }

    public final boolean i() {
        return this.d;
    }

    public final void j(LoadType loadType, BlockState blockState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(blockState, "state");
        this.f1510a[loadType.ordinal()] = blockState;
    }

    public final void k(LoadType loadType, LoadState.Error error) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        this.b[loadType.ordinal()] = error;
    }

    public final void l(boolean z) {
        this.d = z;
    }
}
