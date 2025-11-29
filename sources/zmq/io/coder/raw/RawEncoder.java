package zmq.io.coder.raw;

import zmq.io.coder.Encoder;
import zmq.util.Errno;

public class RawEncoder extends Encoder {
    public RawEncoder(Errno errno, int i) {
        super(errno, i);
        c(this.k, true);
    }

    public void g() {
        e(this.h.a(), this.h.O(), this.k, true);
    }

    public void h() {
        throw new UnsupportedOperationException();
    }
}
