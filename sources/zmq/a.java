package zmq;

import zmq.Signaler;

public final /* synthetic */ class a implements Signaler.IoOperation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Signaler f3611a;

    public /* synthetic */ a(Signaler signaler) {
        this.f3611a = signaler;
    }

    public final Object call() {
        return this.f3611a.j();
    }
}
