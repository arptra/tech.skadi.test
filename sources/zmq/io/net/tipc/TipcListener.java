package zmq.io.net.tipc;

import zmq.Options;
import zmq.SocketBase;
import zmq.io.IOThread;
import zmq.io.net.tcp.TcpListener;

public class TipcListener extends TcpListener {
    public TipcListener(IOThread iOThread, SocketBase socketBase, Options options) {
        super(iOThread, socketBase, options);
        throw new UnsupportedOperationException("TODO implement tipc");
    }
}
