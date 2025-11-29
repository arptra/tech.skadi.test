package zmq.io;

import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.io.net.Address;

public class HelloMsgSession extends SessionBase {
    public boolean w = true;

    public HelloMsgSession(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
        super(iOThread, z, socketBase, options, address);
    }

    public Msg u1() {
        if (!this.w) {
            return super.u1();
        }
        this.w = false;
        return this.c.c0;
    }

    public void y1() {
        super.y1();
        this.w = true;
    }
}
