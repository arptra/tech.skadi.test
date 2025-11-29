package zmq.socket.pubsub;

import zmq.Ctx;
import zmq.Msg;
import zmq.Options;

public class Sub extends XSub {
    public Sub(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 2;
        options.w = true;
    }

    public boolean m2() {
        return false;
    }

    public boolean r2(Msg msg) {
        this.j.c(45);
        throw new UnsupportedOperationException();
    }

    public boolean s2(int i, Object obj) {
        if (i != 6 && i != 7) {
            this.j.c(22);
            return false;
        } else if (obj == null) {
            this.j.c(22);
            return false;
        } else {
            byte[] f = Options.f(i, obj);
            Msg msg = new Msg(f.length + 1);
            if (i == 6) {
                msg.x((byte) 1);
            } else {
                msg.x((byte) 0);
            }
            msg.C(f);
            if (super.r2(msg)) {
                return true;
            }
            this.j.c(22);
            throw new IllegalStateException("Failed to send subscribe/unsubscribe message");
        }
    }
}
