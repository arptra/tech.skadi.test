package zmq.io.net.tcp;

import java.net.ServerSocket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class c implements TcpUtils.OptionSetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3642a;

    public /* synthetic */ c(int i) {
        this.f3642a = i;
    }

    public final void a(Object obj) {
        ((ServerSocket) obj).setReceiveBufferSize(this.f3642a);
    }
}
