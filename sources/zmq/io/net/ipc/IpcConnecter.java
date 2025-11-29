package zmq.io.net.ipc;

import zmq.Options;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.net.Address;
import zmq.io.net.tcp.TcpConnecter;

public class IpcConnecter extends TcpConnecter {
    public IpcConnecter(IOThread iOThread, SessionBase sessionBase, Options options, Address address, boolean z) {
        super(iOThread, sessionBase, options, address, z);
    }
}
