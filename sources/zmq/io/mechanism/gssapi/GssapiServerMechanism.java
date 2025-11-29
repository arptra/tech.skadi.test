package zmq.io.mechanism.gssapi;

import zmq.Msg;
import zmq.Options;
import zmq.io.SessionBase;
import zmq.io.mechanism.Mechanism;
import zmq.io.net.Address;

public class GssapiServerMechanism extends Mechanism {
    public GssapiServerMechanism(SessionBase sessionBase, Address address, Options options) {
        super(sessionBase, address, options);
        throw new UnsupportedOperationException("GSSAPI mechanism is not yet implemented");
    }

    public int m(Msg msg) {
        return 0;
    }

    public int r(Msg msg) {
        return 0;
    }

    public Mechanism.Status y() {
        return null;
    }

    public int z() {
        return 0;
    }
}
