package zmq;

import zmq.Signaler;

public final /* synthetic */ class c implements Signaler.IoOperation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Signaler f3613a;

    public /* synthetic */ c(Signaler signaler) {
        this.f3613a = signaler;
    }

    public final Object call() {
        return this.f3613a.o();
    }
}
