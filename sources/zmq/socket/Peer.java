package zmq.socket;

import zmq.Ctx;
import zmq.Options;
import zmq.pipe.Pipe;
import zmq.socket.clientserver.Server;

public class Peer extends Server {
    public Peer(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 17;
        options.d0 = true;
        options.f0 = true;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        super.k2(pipe, z, z2);
        this.c.j0 = pipe.l1();
    }
}
