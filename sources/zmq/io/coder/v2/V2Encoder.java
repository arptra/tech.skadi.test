package zmq.io.coder.v2;

import java.nio.ByteBuffer;
import zmq.io.coder.Encoder;
import zmq.util.Errno;
import zmq.util.Wire;

public class V2Encoder extends Encoder {
    public final ByteBuffer l = ByteBuffer.allocate(9);

    public V2Encoder(Errno errno, int i) {
        super(errno, i);
        c(this.k, true);
    }

    public void g() {
        byte b = this.h.n() ? (byte) 1 : 0;
        if (this.h.O() > 255) {
            b = (byte) (b | 2);
        }
        if (this.h.r()) {
            b = (byte) (b | 4);
        }
        int O = this.h.O();
        this.l.position(0);
        this.l.put(b);
        if (O > 255) {
            this.l.limit(9);
            Wire.l(this.l, (long) O);
        } else {
            this.l.limit(2);
            this.l.put((byte) O);
        }
        ByteBuffer byteBuffer = this.l;
        e(byteBuffer, byteBuffer.limit(), this.j, false);
    }

    public void h() {
        e(this.h.a(), this.h.O(), this.k, true);
    }
}
