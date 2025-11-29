package zmq.socket;

import zmq.Ctx;
import zmq.Options;

public class Raw extends Peer {
    public Raw(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 18;
        options.d0 = true;
        options.y = true;
    }
}
