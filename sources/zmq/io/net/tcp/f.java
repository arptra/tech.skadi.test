package zmq.io.net.tcp;

import java.net.Socket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class f implements TcpUtils.OptionSetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3644a;

    public /* synthetic */ f(boolean z) {
        this.f3644a = z;
    }

    public final void a(Object obj) {
        ((Socket) obj).setReuseAddress(this.f3644a);
    }
}
