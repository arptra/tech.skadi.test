package zmq.io.net.tcp;

import java.net.ServerSocket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class g implements TcpUtils.OptionSetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3645a;

    public /* synthetic */ g(boolean z) {
        this.f3645a = z;
    }

    public final void a(Object obj) {
        ((ServerSocket) obj).setReuseAddress(this.f3645a);
    }
}
