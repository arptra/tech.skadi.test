package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Landroidx/paging/GenerationalViewportHint;", "generationalHint", "", "d", "(Landroidx/paging/GenerationalViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$4<T> implements FlowCollector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f1579a;
    public final /* synthetic */ LoadType b;

    public PageFetcherSnapshot$collectAsGenerationalViewportHints$4(PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        this.f1579a = pageFetcherSnapshot;
        this.b = loadType;
    }

    /* renamed from: d */
    public final Object emit(GenerationalViewportHint generationalViewportHint, Continuation continuation) {
        Object c = this.f1579a.t(this.b, generationalViewportHint, continuation);
        return c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c : Unit.INSTANCE;
    }
}
