package zmq;

import zmq.Signaler;

public final /* synthetic */ class d implements Signaler.IoOperation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Signaler f3614a;

    public /* synthetic */ d(Signaler signaler) {
        this.f3614a = signaler;
    }

    public final Object call() {
        return this.f3614a.s();
    }
}
