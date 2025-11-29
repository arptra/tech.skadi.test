package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class e implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f114a;
    public final /* synthetic */ View b;

    public /* synthetic */ e(ProducerScope producerScope, View view) {
        this.f114a = producerScope;
        this.b = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(this.f114a, this.b);
    }
}
