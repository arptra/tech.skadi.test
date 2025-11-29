package zmq.io.net.tcp;

import java.net.Socket;
import zmq.io.net.tcp.TcpUtils;

public final /* synthetic */ class d implements TcpUtils.OptionSetter {
    public final void a(Object obj) {
        ((Socket) obj).setTcpNoDelay(true);
    }
}
