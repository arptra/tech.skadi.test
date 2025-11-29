package zmq.io.net.tipc;

import zmq.Options;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.net.Address;
import zmq.io.net.tcp.TcpConnecter;

public class TipcConnecter extends TcpConnecter {
    public TipcConnecter(IOThread iOThread, SessionBase sessionBase, Options options, Address address, boolean z) {
        super(iOThread, sessionBase, options, address, z);
        throw new UnsupportedOperationException("TODO implement Tipc");
    }
}
