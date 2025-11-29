package zmq.io.net.ipc;

import java.net.InetSocketAddress;
import zmq.Options;
import zmq.SocketBase;
import zmq.io.IOThread;
import zmq.io.net.tcp.TcpListener;

public class IpcListener extends TcpListener {
    public IpcAddress r;

    public IpcListener(IOThread iOThread, SocketBase socketBase, Options options) {
        super(iOThread, socketBase, options);
    }

    public String p1() {
        return ((InetSocketAddress) this.r.address()).getPort() == 0 ? s1(this.r) : this.r.toString();
    }

    public boolean q1(String str) {
        IpcAddress ipcAddress = new IpcAddress(str);
        this.r = ipcAddress;
        return super.u1((InetSocketAddress) ipcAddress.address());
    }
}
