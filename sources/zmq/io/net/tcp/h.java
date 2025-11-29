package zmq.io.net.tcp;

import java.net.Socket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class h implements TcpUtils.OptionSetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3646a;

    public /* synthetic */ h(int i) {
        this.f3646a = i;
    }

    public final void a(Object obj) {
        ((Socket) obj).setTrafficClass(this.f3646a);
    }
}
