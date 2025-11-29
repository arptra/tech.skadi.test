package zmq.io.net.tcp;

import java.net.Socket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class a implements TcpUtils.OptionSetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3640a;

    public /* synthetic */ a(int i) {
        this.f3640a = i;
    }

    public final void a(Object obj) {
        ((Socket) obj).setSendBufferSize(this.f3640a);
    }
}
