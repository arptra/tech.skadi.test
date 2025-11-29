package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PagingSource;
import androidx.paging.ViewportHint;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@SourceDebugExtension({"SMAP\nPageFetcherSnapshotState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageFetcherSnapshotState.kt\nandroidx/paging/PageFetcherSnapshotState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,397:1\n1#2:398\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0001UB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0010\u0010\u000fJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J%\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%2\b\u0010$\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R&\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00110*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R,\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00110.8\u0000X\u0004¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u00101R$\u00108\u001a\u00020\n2\u0006\u00103\u001a\u00020\n8\u0000@BX\u000e¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u00105R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u00105R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u00105R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u00105R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0=8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010>R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0=8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010>R&\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0A8\u0000X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bB\u0010DR$\u0010J\u001a\u00020F2\u0006\u00103\u001a\u00020F8\u0000@BX\u000e¢\u0006\f\n\u0004\b6\u0010G\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\bK\u00107R$\u0010Q\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n8@@@X\u000e¢\u0006\f\u001a\u0004\bN\u00107\"\u0004\bO\u0010PR$\u0010T\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n8@@@X\u000e¢\u0006\f\u001a\u0004\bR\u00107\"\u0004\bS\u0010P¨\u0006V"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState;", "", "Key", "Value", "Landroidx/paging/PagingConfig;", "config", "<init>", "(Landroidx/paging/PagingConfig;)V", "Landroidx/paging/LoadType;", "loadType", "", "j", "(Landroidx/paging/LoadType;)I", "Lkotlinx/coroutines/flow/Flow;", "f", "()Lkotlinx/coroutines/flow/Flow;", "e", "Landroidx/paging/PagingSource$LoadResult$Page;", "Landroidx/paging/PageEvent;", "u", "(Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/LoadType;)Landroidx/paging/PageEvent;", "loadId", "page", "", "r", "(ILandroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;)Z", "Landroidx/paging/PageEvent$Drop;", "event", "", "h", "(Landroidx/paging/PageEvent$Drop;)V", "Landroidx/paging/ViewportHint;", "hint", "i", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;)Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/ViewportHint$Access;", "viewportHint", "Landroidx/paging/PagingState;", "g", "(Landroidx/paging/ViewportHint$Access;)Landroidx/paging/PagingState;", "a", "Landroidx/paging/PagingConfig;", "", "b", "Ljava/util/List;", "_pages", "", "c", "m", "()Ljava/util/List;", "pages", "<set-?>", "d", "I", "l", "()I", "initialPageIndex", "_placeholdersBefore", "_placeholdersAfter", "prependGenerationId", "appendGenerationId", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "prependGenerationIdCh", "appendGenerationIdCh", "", "k", "Ljava/util/Map;", "()Ljava/util/Map;", "failedHintsByLoadType", "Landroidx/paging/MutableLoadStateCollection;", "Landroidx/paging/MutableLoadStateCollection;", "p", "()Landroidx/paging/MutableLoadStateCollection;", "sourceLoadStates", "q", "storageCount", "value", "o", "t", "(I)V", "placeholdersBefore", "n", "s", "placeholdersAfter", "Holder", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PageFetcherSnapshotState<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final PagingConfig f1583a;
    public final List b;
    public final List c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final Channel i;
    public final Channel j;
    public final Map k;
    public MutableLoadStateCollection l;

    @SourceDebugExtension({"SMAP\nPageFetcherSnapshotState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageFetcherSnapshotState.kt\nandroidx/paging/PageFetcherSnapshotState$Holder\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,397:1\n107#2,10:398\n*S KotlinDebug\n*F\n+ 1 PageFetcherSnapshotState.kt\nandroidx/paging/PageFetcherSnapshotState$Holder\n*L\n391#1:398,10\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u000f\u001a\u00028\u0004\"\u0004\b\u0004\u0010\b2-\u0010\u000e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00040\tHHø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState$Holder;", "", "Key", "Value", "Landroidx/paging/PagingConfig;", "config", "<init>", "(Landroidx/paging/PagingConfig;)V", "T", "Lkotlin/Function1;", "Landroidx/paging/PageFetcherSnapshotState;", "Lkotlin/ParameterName;", "name", "state", "block", "c", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Landroidx/paging/PagingConfig;", "Lkotlinx/coroutines/sync/Mutex;", "b", "Lkotlinx/coroutines/sync/Mutex;", "lock", "Landroidx/paging/PageFetcherSnapshotState;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Holder<Key, Value> {

        /* renamed from: a  reason: collision with root package name */
        public final PagingConfig f1584a;
        public final Mutex b = MutexKt.b(false, 1, (Object) null);
        public final PageFetcherSnapshotState c;

        public Holder(PagingConfig pagingConfig) {
            Intrinsics.checkNotNullParameter(pagingConfig, "config");
            this.f1584a = pagingConfig;
            this.c = new PageFetcherSnapshotState(pagingConfig, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object c(kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                if (r0 == 0) goto L_0x0013
                r0 = r7
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = (androidx.paging.PageFetcherSnapshotState$Holder$withLock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = new androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0040
                if (r2 != r3) goto L_0x0038
                java.lang.Object r5 = r0.L$2
                kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
                java.lang.Object r6 = r0.L$1
                kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
                java.lang.Object r0 = r0.L$0
                androidx.paging.PageFetcherSnapshotState$Holder r0 = (androidx.paging.PageFetcherSnapshotState.Holder) r0
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r5
                r5 = r0
                goto L_0x0056
            L_0x0038:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0040:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.sync.Mutex r7 = r5.b
                r0.L$0 = r5
                r0.L$1 = r6
                r0.L$2 = r7
                r0.label = r3
                java.lang.Object r0 = r7.c(r4, r0)
                if (r0 != r1) goto L_0x0056
                return r1
            L_0x0056:
                androidx.paging.PageFetcherSnapshotState r5 = r5.c     // Catch:{ all -> 0x0068 }
                java.lang.Object r5 = r6.invoke(r5)     // Catch:{ all -> 0x0068 }
                kotlin.jvm.internal.InlineMarker.finallyStart(r3)
                r7.d(r4)
                kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
                return r5
            L_0x0068:
                r5 = move-exception
                kotlin.jvm.internal.InlineMarker.finallyStart(r3)
                r7.d(r4)
                kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshotState.Holder.c(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshotState.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig);
    }

    public final Flow e() {
        return FlowKt.M(FlowKt.m(this.j), new PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(this, (Continuation<? super PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1>) null));
    }

    public final Flow f() {
        return FlowKt.M(FlowKt.m(this.i), new PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1(this, (Continuation<? super PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1>) null));
    }

    public final PagingState g(ViewportHint.Access access) {
        Integer num;
        List list = CollectionsKt.toList(this.c);
        if (access != null) {
            int o = o();
            int i2 = -this.d;
            int lastIndex = CollectionsKt.getLastIndex(this.c) - this.d;
            int g2 = access.g();
            int i3 = i2;
            while (i3 < g2) {
                o += i3 > lastIndex ? this.f1583a.f1596a : ((PagingSource.LoadResult.Page) this.c.get(this.d + i3)).b().size();
                i3++;
            }
            int f2 = o + access.f();
            if (access.g() < i2) {
                f2 -= this.f1583a.f1596a;
            }
            num = Integer.valueOf(f2);
        } else {
            num = null;
        }
        return new PagingState(list, num, this.f1583a, o());
    }

    public final void h(PageEvent.Drop drop) {
        Intrinsics.checkNotNullParameter(drop, "event");
        if (drop.j() <= this.c.size()) {
            this.k.remove(drop.g());
            this.l.c(drop.g(), LoadState.NotLoading.b.b());
            int i2 = WhenMappings.$EnumSwitchMapping$0[drop.g().ordinal()];
            if (i2 == 2) {
                int j2 = drop.j();
                for (int i3 = 0; i3 < j2; i3++) {
                    this.b.remove(0);
                }
                this.d -= drop.j();
                t(drop.k());
                int i4 = this.g + 1;
                this.g = i4;
                this.i.q(Integer.valueOf(i4));
            } else if (i2 == 3) {
                int j3 = drop.j();
                for (int i5 = 0; i5 < j3; i5++) {
                    this.b.remove(this.c.size() - 1);
                }
                s(drop.k());
                int i6 = this.h + 1;
                this.h = i6;
                this.j.q(Integer.valueOf(i6));
            } else {
                throw new IllegalArgumentException("cannot drop " + drop.g());
            }
        } else {
            throw new IllegalStateException(("invalid drop count. have " + this.c.size() + " but wanted to drop " + drop.j()).toString());
        }
    }

    public final PageEvent.Drop i(LoadType loadType, ViewportHint viewportHint) {
        int i2;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(viewportHint, "hint");
        PageEvent.Drop drop = null;
        if (this.f1583a.e == Integer.MAX_VALUE || this.c.size() <= 2 || q() <= this.f1583a.e) {
            return null;
        }
        if (loadType != LoadType.REFRESH) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.c.size() && q() - i5 > this.f1583a.e) {
                int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                if (iArr[loadType.ordinal()] == 2) {
                    i2 = ((PagingSource.LoadResult.Page) this.c.get(i4)).b().size();
                } else {
                    List list = this.c;
                    i2 = ((PagingSource.LoadResult.Page) list.get(CollectionsKt.getLastIndex(list) - i4)).b().size();
                }
                if (((iArr[loadType.ordinal()] == 2 ? viewportHint.d() : viewportHint.c()) - i5) - i2 < this.f1583a.b) {
                    break;
                }
                i5 += i2;
                i4++;
            }
            if (i4 != 0) {
                int[] iArr2 = WhenMappings.$EnumSwitchMapping$0;
                int lastIndex = iArr2[loadType.ordinal()] == 2 ? -this.d : (CollectionsKt.getLastIndex(this.c) - this.d) - (i4 - 1);
                int lastIndex2 = iArr2[loadType.ordinal()] == 2 ? (i4 - 1) - this.d : CollectionsKt.getLastIndex(this.c) - this.d;
                if (this.f1583a.c) {
                    i3 = (loadType == LoadType.PREPEND ? o() : n()) + i5;
                }
                drop = new PageEvent.Drop(loadType, lastIndex, lastIndex2, i3);
            }
            return drop;
        }
        throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + loadType).toString());
    }

    public final int j(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i2 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i2 == 1) {
            throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
        } else if (i2 == 2) {
            return this.g;
        } else {
            if (i2 == 3) {
                return this.h;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final Map k() {
        return this.k;
    }

    public final int l() {
        return this.d;
    }

    public final List m() {
        return this.c;
    }

    public final int n() {
        if (this.f1583a.c) {
            return this.f;
        }
        return 0;
    }

    public final int o() {
        if (this.f1583a.c) {
            return this.e;
        }
        return 0;
    }

    public final MutableLoadStateCollection p() {
        return this.l;
    }

    public final int q() {
        int i2 = 0;
        for (PagingSource.LoadResult.Page b2 : this.c) {
            i2 += b2.b().size();
        }
        return i2;
    }

    public final boolean r(int i2, LoadType loadType, PagingSource.LoadResult.Page page) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(page, "page");
        int i3 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (!(!this.c.isEmpty())) {
                        throw new IllegalStateException("should've received an init before append".toString());
                    } else if (i2 != this.h) {
                        return false;
                    } else {
                        this.b.add(page);
                        s(page.c() == Integer.MIN_VALUE ? RangesKt.coerceAtLeast(n() - page.b().size(), 0) : page.c());
                        this.k.remove(LoadType.APPEND);
                    }
                }
            } else if (!(!this.c.isEmpty())) {
                throw new IllegalStateException("should've received an init before prepend".toString());
            } else if (i2 != this.g) {
                return false;
            } else {
                this.b.add(0, page);
                this.d++;
                t(page.d() == Integer.MIN_VALUE ? RangesKt.coerceAtLeast(o() - page.b().size(), 0) : page.d());
                this.k.remove(LoadType.PREPEND);
            }
        } else if (!this.c.isEmpty()) {
            throw new IllegalStateException("cannot receive multiple init calls".toString());
        } else if (i2 == 0) {
            this.b.add(page);
            this.d = 0;
            s(page.c());
            t(page.d());
        } else {
            throw new IllegalStateException("init loadId must be the initial value, 0".toString());
        }
        return true;
    }

    public final void s(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            i2 = 0;
        }
        this.f = i2;
    }

    public final void t(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            i2 = 0;
        }
        this.e = i2;
    }

    public final PageEvent u(PagingSource.LoadResult.Page page, LoadType loadType) {
        Intrinsics.checkNotNullParameter(page, "<this>");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i2 = iArr[loadType.ordinal()];
        int i3 = 0;
        if (i2 != 1) {
            if (i2 == 2) {
                i3 = 0 - this.d;
            } else if (i2 == 3) {
                i3 = (this.c.size() - this.d) - 1;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        List listOf = CollectionsKt.listOf(new TransformablePage(i3, page.b()));
        int i4 = iArr[loadType.ordinal()];
        if (i4 == 1) {
            return PageEvent.Insert.g.c(listOf, o(), n(), this.l.d(), (LoadStates) null);
        }
        if (i4 == 2) {
            return PageEvent.Insert.g.b(listOf, o(), this.l.d(), (LoadStates) null);
        }
        if (i4 == 3) {
            return PageEvent.Insert.g.a(listOf, n(), this.l.d(), (LoadStates) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.f1583a = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = arrayList;
        this.i = ChannelKt.b(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.j = ChannelKt.b(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.k = new LinkedHashMap();
        MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
        mutableLoadStateCollection.c(LoadType.REFRESH, LoadState.Loading.b);
        this.l = mutableLoadStateCollection;
    }
}
