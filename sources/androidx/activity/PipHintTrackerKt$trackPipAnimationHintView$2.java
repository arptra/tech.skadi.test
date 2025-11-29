package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/Rect;", "hint", "", "d", "(Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
final class PipHintTrackerKt$trackPipAnimationHintView$2<T> implements FlowCollector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f105a;

    /* renamed from: d */
    public final Object emit(Rect rect, Continuation continuation) {
        Api26Impl.f86a.a(this.f105a, rect);
        return Unit.INSTANCE;
    }
}
