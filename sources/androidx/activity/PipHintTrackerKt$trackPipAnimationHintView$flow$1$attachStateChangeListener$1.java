package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/activity/PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f106a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewTreeObserver.OnScrollChangedListener c;
    public final /* synthetic */ View.OnLayoutChangeListener d;

    public PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(ProducerScope producerScope, View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener) {
        this.f106a = producerScope;
        this.b = view;
        this.c = onScrollChangedListener;
        this.d = onLayoutChangeListener;
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        this.f106a.q(PipHintTrackerKt.b(this.b));
        this.b.getViewTreeObserver().addOnScrollChangedListener(this.c);
        this.b.addOnLayoutChangeListener(this.d);
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        view.getViewTreeObserver().removeOnScrollChangedListener(this.c);
        view.removeOnLayoutChangeListener(this.d);
    }
}
