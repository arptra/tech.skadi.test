package androidx.lifecycle;

import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f1402a;

    public /* synthetic */ a(ProducerScope producerScope) {
        this.f1402a = producerScope;
    }

    public final void onChanged(Object obj) {
        FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(this.f1402a, obj);
    }
}
