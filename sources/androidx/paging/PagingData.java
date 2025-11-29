package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001a*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u001bBE\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017R\"\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Landroidx/paging/PagingData;", "", "T", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "flow", "Landroidx/paging/UiReceiver;", "uiReceiver", "Landroidx/paging/HintReceiver;", "hintReceiver", "Lkotlin/Function0;", "Landroidx/paging/PageEvent$Insert;", "cachedPageEvent", "<init>", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/UiReceiver;Landroidx/paging/HintReceiver;Lkotlin/jvm/functions/Function0;)V", "a", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "b", "Landroidx/paging/UiReceiver;", "c", "()Landroidx/paging/UiReceiver;", "Landroidx/paging/HintReceiver;", "()Landroidx/paging/HintReceiver;", "d", "Lkotlin/jvm/functions/Function0;", "e", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PagingData<T> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final UiReceiver f = new PagingData$Companion$NOOP_UI_RECEIVER$1();
    public static final HintReceiver g = new PagingData$Companion$NOOP_HINT_RECEIVER$1();

    /* renamed from: a  reason: collision with root package name */
    public final Flow f1597a;
    public final UiReceiver b;
    public final HintReceiver c;
    public final Function0 d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PagingData$Companion;", "", "<init>", "()V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PagingData(Flow flow, UiReceiver uiReceiver, HintReceiver hintReceiver, Function0 function0) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(uiReceiver, "uiReceiver");
        Intrinsics.checkNotNullParameter(hintReceiver, "hintReceiver");
        Intrinsics.checkNotNullParameter(function0, "cachedPageEvent");
        this.f1597a = flow;
        this.b = uiReceiver;
        this.c = hintReceiver;
        this.d = function0;
    }

    public final Flow a() {
        return this.f1597a;
    }

    public final HintReceiver b() {
        return this.c;
    }

    public final UiReceiver c() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagingData(Flow flow, UiReceiver uiReceiver, HintReceiver hintReceiver, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(flow, uiReceiver, hintReceiver, (i & 8) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
