package zmq.socket.pubsub;

import zmq.Ctx;
import zmq.Msg;
import zmq.pipe.Pipe;

public class Pub extends XPub {
    public Pub(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        this.c.m = 1;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        pipe.y1();
        super.k2(pipe, z, z2);
    }

    public boolean l2() {
        return false;
    }

    public Msg q2() {
        this.j.c(45);
        throw new UnsupportedOperationException();
    }
}
