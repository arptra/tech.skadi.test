package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@SourceDebugExtension({"SMAP\nPageFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageFetcher.kt\nandroidx/paging/PageFetcher\n+ 2 Logger.kt\nandroidx/paging/LoggerKt\n*L\n1#1,256:1\n41#2,10:257\n*S KotlinDebug\n*F\n+ 1 PageFetcher.kt\nandroidx/paging/PageFetcher\n*L\n227#1:257,10\n*E\n"})
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0003()*J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006JI\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\r*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R9\u0010\u0019\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00158\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00018\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/paging/PageFetcher;", "", "Key", "Value", "", "k", "()V", "j", "Landroidx/paging/PageFetcherSnapshot;", "Lkotlinx/coroutines/Job;", "job", "Landroidx/paging/RemoteMediatorAccessor;", "accessor", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "i", "(Landroidx/paging/PageFetcherSnapshot;Lkotlinx/coroutines/Job;Landroidx/paging/RemoteMediatorAccessor;)Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingSource;", "previousPagingSource", "h", "(Landroidx/paging/PagingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "a", "Lkotlin/jvm/functions/Function1;", "pagingSourceFactory", "b", "Ljava/lang/Object;", "initialKey", "Landroidx/paging/PagingConfig;", "c", "Landroidx/paging/PagingConfig;", "config", "Landroidx/paging/ConflatedEventBus;", "", "d", "Landroidx/paging/ConflatedEventBus;", "refreshEvents", "e", "retryEvents", "GenerationInfo", "PagerHintReceiver", "PagerUiReceiver", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PageFetcher<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1569a;
    public final Object b;
    public final PagingConfig c;
    public final ConflatedEventBus d;
    public final ConflatedEventBus e;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B9\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\f\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/paging/PageFetcher$GenerationInfo;", "", "Key", "Value", "Landroidx/paging/PageFetcherSnapshot;", "snapshot", "Landroidx/paging/PagingState;", "state", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;Lkotlinx/coroutines/Job;)V", "a", "Landroidx/paging/PageFetcherSnapshot;", "b", "()Landroidx/paging/PageFetcherSnapshot;", "Landroidx/paging/PagingState;", "c", "()Landroidx/paging/PagingState;", "Lkotlinx/coroutines/Job;", "()Lkotlinx/coroutines/Job;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class GenerationInfo<Key, Value> {

        /* renamed from: a  reason: collision with root package name */
        public final PageFetcherSnapshot f1571a;
        public final PagingState b;
        public final Job c;

        public GenerationInfo(PageFetcherSnapshot pageFetcherSnapshot, PagingState pagingState, Job job) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, "snapshot");
            Intrinsics.checkNotNullParameter(job, "job");
            this.f1571a = pageFetcherSnapshot;
            this.b = pagingState;
            this.c = job;
        }

        public final Job a() {
            return this.c;
        }

        public final PageFetcherSnapshot b() {
            return this.f1571a;
        }

        public final PagingState c() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0004B\u001d\u0012\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00058\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/PageFetcher$PagerHintReceiver;", "", "Key", "Value", "Landroidx/paging/HintReceiver;", "Landroidx/paging/PageFetcherSnapshot;", "pageFetcherSnapshot", "<init>", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;)V", "Landroidx/paging/ViewportHint;", "viewportHint", "", "a", "(Landroidx/paging/ViewportHint;)V", "Landroidx/paging/PageFetcherSnapshot;", "getPageFetcherSnapshot$paging_common", "()Landroidx/paging/PageFetcherSnapshot;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public final class PagerHintReceiver<Key, Value> implements HintReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final PageFetcherSnapshot f1572a;
        public final /* synthetic */ PageFetcher b;

        public PagerHintReceiver(PageFetcher pageFetcher, PageFetcherSnapshot pageFetcherSnapshot) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, "pageFetcherSnapshot");
            this.b = pageFetcher;
            this.f1572a = pageFetcherSnapshot;
        }

        public void a(ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
            this.f1572a.o(viewportHint);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/paging/PageFetcher$PagerUiReceiver;", "Landroidx/paging/UiReceiver;", "Landroidx/paging/ConflatedEventBus;", "", "retryEventBus", "<init>", "(Landroidx/paging/PageFetcher;Landroidx/paging/ConflatedEventBus;)V", "a", "Landroidx/paging/ConflatedEventBus;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public final class PagerUiReceiver implements UiReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final ConflatedEventBus f1573a;
        public final /* synthetic */ PageFetcher b;

        public PagerUiReceiver(PageFetcher pageFetcher, ConflatedEventBus conflatedEventBus) {
            Intrinsics.checkNotNullParameter(conflatedEventBus, "retryEventBus");
            this.b = pageFetcher;
            this.f1573a = conflatedEventBus;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: androidx.paging.PagingSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(androidx.paging.PagingSource r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcher$generateNewPagingSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = (androidx.paging.PageFetcher$generateNewPagingSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            androidx.paging.PagingSource r5 = (androidx.paging.PagingSource) r5
            java.lang.Object r4 = r0.L$0
            androidx.paging.PageFetcher r4 = (androidx.paging.PageFetcher) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004c
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function1 r6 = r4.f1569a
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            androidx.paging.PagingSource r6 = (androidx.paging.PagingSource) r6
            boolean r0 = r6 instanceof androidx.paging.LegacyPagingSource
            if (r0 == 0) goto L_0x005c
            r0 = r6
            androidx.paging.LegacyPagingSource r0 = (androidx.paging.LegacyPagingSource) r0
            androidx.paging.PagingConfig r1 = r4.c
            int r1 = r1.f1596a
            r0.k(r1)
        L_0x005c:
            if (r6 == r5) goto L_0x0098
            androidx.paging.PageFetcher$generateNewPagingSource$3 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$3
            r0.<init>(r4)
            r6.g(r0)
            if (r5 == 0) goto L_0x0070
            androidx.paging.PageFetcher$generateNewPagingSource$4 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$4
            r0.<init>(r4)
            r5.h(r0)
        L_0x0070:
            if (r5 == 0) goto L_0x0075
            r5.e()
        L_0x0075:
            androidx.paging.Logger r4 = androidx.paging.LoggerKt.a()
            if (r4 == 0) goto L_0x0097
            r5 = 3
            boolean r0 = r4.b(r5)
            if (r0 != r3) goto L_0x0097
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Generated new PagingSource "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r1 = 0
            r4.a(r5, r0, r1)
        L_0x0097:
            return r6
        L_0x0098:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource."
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher.h(androidx.paging.PagingSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow i(PageFetcherSnapshot pageFetcherSnapshot, Job job, RemoteMediatorAccessor remoteMediatorAccessor) {
        return remoteMediatorAccessor == null ? pageFetcherSnapshot.u() : CancelableChannelFlowKt.a(job, new PageFetcher$injectRemoteEvents$1(remoteMediatorAccessor, pageFetcherSnapshot, new MutableLoadStateCollection(), (Continuation<? super PageFetcher$injectRemoteEvents$1>) null));
    }

    public final void j() {
        this.d.b(Boolean.FALSE);
    }

    public final void k() {
        this.d.b(Boolean.TRUE);
    }
}
