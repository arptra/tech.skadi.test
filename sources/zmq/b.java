package zmq;

import zmq.Signaler;

public final /* synthetic */ class b implements Signaler.IoOperation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Signaler f3612a;

    public /* synthetic */ b(Signaler signaler) {
        this.f3612a = signaler;
    }

    public final Object call() {
        return this.f3612a.n();
    }
}
