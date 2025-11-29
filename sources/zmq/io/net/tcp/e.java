package zmq.io.net.tcp;

import java.net.Socket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class e implements TcpUtils.OptionSetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3643a;

    public /* synthetic */ e(int i) {
        this.f3643a = i;
    }

    public final void a(Object obj) {
        TcpUtils.r(this.f3643a, (Socket) obj);
    }
}
