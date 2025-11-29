package zmq.io.net;

import zmq.Options;
import zmq.Own;
import zmq.SocketBase;
import zmq.io.IOThread;
import zmq.poll.IPollEvents;

public abstract class Listener extends Own implements IPollEvents {
    public final SocketBase k;

    public Listener(IOThread iOThread, SocketBase socketBase, Options options) {
        super(iOThread, options);
        this.k = socketBase;
    }

    public abstract String p1();

    public abstract boolean q1(String str);
}
