package zmq;

import zmq.Signaler;

public final /* synthetic */ class e implements Signaler.IoOperation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Signaler f3615a;

    public /* synthetic */ e(Signaler signaler) {
        this.f3615a = signaler;
    }

    public final Object call() {
        return this.f3615a.r();
    }
}
