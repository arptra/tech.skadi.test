package zmq.io.net.tcp;

import java.net.Socket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class b implements TcpUtils.OptionSetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3641a;

    public /* synthetic */ b(int i) {
        this.f3641a = i;
    }

    public final void a(Object obj) {
        ((Socket) obj).setReceiveBufferSize(this.f3641a);
    }
}
