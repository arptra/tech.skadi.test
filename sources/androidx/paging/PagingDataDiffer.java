package androidx.paging;

import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableSharedFlow;

@SourceDebugExtension({"SMAP\nPagingDataDiffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagingDataDiffer.kt\nandroidx/paging/PagingDataDiffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Logger.kt\nandroidx/paging/LoggerKt\n*L\n1#1,548:1\n1#2:549\n41#3,10:550\n41#3,10:560\n41#3,10:570\n*S KotlinDebug\n*F\n+ 1 PagingDataDiffer.kt\nandroidx/paging/PagingDataDiffer\n*L\n268#1:550,10\n303#1:560,10\n324#1:570,10\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001N\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J[\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\u001d\u001a\u0004\u0018\u00010\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH¦@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010#\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u00102\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100%¢\u0006\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00028\u0000098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R \u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001b0A8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000N8\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00100R8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0011\u0010X\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bV\u0010W\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, d2 = {"Landroidx/paging/PagingDataDiffer;", "", "T", "", "Landroidx/paging/TransformablePage;", "pages", "", "placeholdersBefore", "placeholdersAfter", "", "dispatchLoadStates", "Landroidx/paging/LoadStates;", "sourceLoadStates", "mediatorLoadStates", "Landroidx/paging/HintReceiver;", "newHintReceiver", "", "u", "(Ljava/util/List;IIZLandroidx/paging/LoadStates;Landroidx/paging/LoadStates;Landroidx/paging/HintReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "source", "mediator", "q", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "Landroidx/paging/NullPaddedList;", "previousList", "newList", "lastAccessedIndex", "Lkotlin/Function0;", "onListPresentable", "t", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "()Z", "Landroidx/paging/PagingData;", "pagingData", "p", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "listener", "v", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/paging/DifferCallback;", "a", "Landroidx/paging/DifferCallback;", "differCallback", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "mainContext", "c", "Landroidx/paging/HintReceiver;", "hintReceiver", "Landroidx/paging/UiReceiver;", "d", "Landroidx/paging/UiReceiver;", "uiReceiver", "Landroidx/paging/PagePresenter;", "e", "Landroidx/paging/PagePresenter;", "presenter", "Landroidx/paging/MutableCombinedLoadStateCollection;", "f", "Landroidx/paging/MutableCombinedLoadStateCollection;", "combinedLoadStatesCollection", "Ljava/util/concurrent/CopyOnWriteArrayList;", "g", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onPagesUpdatedListeners", "Landroidx/paging/SingleRunner;", "h", "Landroidx/paging/SingleRunner;", "collectFromRunner", "i", "Z", "lastAccessedIndexUnfulfilled", "j", "I", "androidx/paging/PagingDataDiffer$processPageEventCallback$1", "k", "Landroidx/paging/PagingDataDiffer$processPageEventCallback$1;", "processPageEventCallback", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "l", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_onPagesUpdatedFlow", "r", "()I", "size", "paging-common"}, k = 1, mv = {1, 8, 0})
public abstract class PagingDataDiffer<T> {

    /* renamed from: a  reason: collision with root package name */
    public final DifferCallback f1601a;
    public final CoroutineContext b;
    public HintReceiver c;
    public UiReceiver d;
    public PagePresenter e;
    public final MutableCombinedLoadStateCollection f;
    public final CopyOnWriteArrayList g;
    public final SingleRunner h;
    public volatile boolean i;
    public volatile int j;
    public final PagingDataDiffer$processPageEventCallback$1 k;
    public final MutableSharedFlow l;

    public final Object p(PagingData pagingData, Continuation continuation) {
        Object c2 = SingleRunner.c(this.h, 0, new PagingDataDiffer$collectFrom$2(this, pagingData, (Continuation<? super PagingDataDiffer$collectFrom$2>) null), continuation, 1, (Object) null);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public final void q(LoadStates loadStates, LoadStates loadStates2) {
        Intrinsics.checkNotNullParameter(loadStates, "source");
        this.f.g(loadStates, loadStates2);
    }

    public final int r() {
        return this.e.b();
    }

    public boolean s() {
        return false;
    }

    public abstract Object t(NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2, int i2, Function0 function0, Continuation continuation);

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(java.util.List r21, int r22, int r23, boolean r24, androidx.paging.LoadStates r25, androidx.paging.LoadStates r26, androidx.paging.HintReceiver r27, kotlin.coroutines.Continuation r28) {
        /*
            r20 = this;
            r10 = r20
            r11 = r24
            r12 = r25
            r0 = r28
            boolean r1 = r0 instanceof androidx.paging.PagingDataDiffer$presentNewList$1
            if (r1 == 0) goto L_0x001c
            r1 = r0
            androidx.paging.PagingDataDiffer$presentNewList$1 r1 = (androidx.paging.PagingDataDiffer$presentNewList$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x001c
            int r2 = r2 - r3
            r1.label = r2
        L_0x001a:
            r13 = r1
            goto L_0x0022
        L_0x001c:
            androidx.paging.PagingDataDiffer$presentNewList$1 r1 = new androidx.paging.PagingDataDiffer$presentNewList$1
            r1.<init>(r10, r0)
            goto L_0x001a
        L_0x0022:
            java.lang.Object r0 = r13.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r15 = 1
            if (r1 == 0) goto L_0x0055
            if (r1 != r15) goto L_0x004d
            boolean r1 = r13.Z$0
            java.lang.Object r2 = r13.L$4
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r3 = r13.L$3
            androidx.paging.PagePresenter r3 = (androidx.paging.PagePresenter) r3
            java.lang.Object r4 = r13.L$2
            androidx.paging.LoadStates r4 = (androidx.paging.LoadStates) r4
            java.lang.Object r5 = r13.L$1
            androidx.paging.LoadStates r5 = (androidx.paging.LoadStates) r5
            java.lang.Object r6 = r13.L$0
            androidx.paging.PagingDataDiffer r6 = (androidx.paging.PagingDataDiffer) r6
            kotlin.ResultKt.throwOnFailure(r0)
            r11 = r1
            r12 = r5
            r10 = r6
            goto L_0x00c0
        L_0x004d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r0)
            if (r11 == 0) goto L_0x0069
            if (r12 == 0) goto L_0x005d
            goto L_0x0069
        L_0x005d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot dispatch LoadStates in PagingDataDiffer without source LoadStates set."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0069:
            r0 = 0
            r10.i = r0
            androidx.paging.PagePresenter r9 = new androidx.paging.PagePresenter
            r6 = r21
            r7 = r22
            r8 = r23
            r9.<init>(r6, r7, r8)
            kotlin.jvm.internal.Ref$BooleanRef r5 = new kotlin.jvm.internal.Ref$BooleanRef
            r5.<init>()
            androidx.paging.PagePresenter r4 = r10.e
            int r3 = r10.j
            androidx.paging.PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1 r16 = new androidx.paging.PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1
            r0 = r16
            r1 = r20
            r2 = r9
            r17 = r3
            r3 = r5
            r18 = r4
            r4 = r27
            r15 = r5
            r5 = r26
            r19 = r14
            r14 = r9
            r9 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r13.L$0 = r10
            r13.L$1 = r12
            r6 = r26
            r13.L$2 = r6
            r13.L$3 = r14
            r13.L$4 = r15
            r13.Z$0 = r11
            r0 = 1
            r13.label = r0
            r0 = r20
            r1 = r18
            r2 = r14
            r3 = r17
            r4 = r16
            r5 = r13
            java.lang.Object r0 = r0.t(r1, r2, r3, r4, r5)
            r1 = r19
            if (r0 != r1) goto L_0x00bd
            return r1
        L_0x00bd:
            r4 = r6
            r3 = r14
            r2 = r15
        L_0x00c0:
            java.lang.Integer r0 = (java.lang.Integer) r0
            boolean r1 = r2.element
            if (r1 == 0) goto L_0x00f4
            if (r11 == 0) goto L_0x00ce
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r10.q(r12, r4)
        L_0x00ce:
            if (r0 != 0) goto L_0x00dc
            androidx.paging.HintReceiver r0 = r10.c
            if (r0 == 0) goto L_0x00f1
            androidx.paging.ViewportHint$Initial r1 = r3.l()
            r0.a(r1)
            goto L_0x00f1
        L_0x00dc:
            int r1 = r0.intValue()
            r10.j = r1
            androidx.paging.HintReceiver r1 = r10.c
            if (r1 == 0) goto L_0x00f1
            int r0 = r0.intValue()
            androidx.paging.ViewportHint$Access r0 = r3.a(r0)
            r1.a(r0)
        L_0x00f1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00f4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Missing call to onListPresentable after new list was presented. If you are seeing\n this exception, it is generally an indication of an issue with Paging.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataDiffer.u(java.util.List, int, int, boolean, androidx.paging.LoadStates, androidx.paging.LoadStates, androidx.paging.HintReceiver, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void v(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f.f(function1);
    }
}
