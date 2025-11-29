package rxhttp.wrapper.coroutines;

import kotlinx.coroutines.channels.ProducerScope;
import rxhttp.wrapper.callback.ProgressCallback;

public final /* synthetic */ class a implements ProgressCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f3549a;

    public /* synthetic */ a(ProducerScope producerScope) {
        this.f3549a = producerScope;
    }

    public final void a(long j, long j2, long j3) {
        CallFlow$toFlowProgress$3.invokeSuspend$lambda$0(this.f3549a, j, j2, j3);
    }
}
