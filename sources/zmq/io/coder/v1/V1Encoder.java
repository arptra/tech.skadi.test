package zmq.io.coder.v1;

import java.nio.ByteBuffer;
import zmq.io.coder.Encoder;
import zmq.util.Errno;
import zmq.util.Wire;

public class V1Encoder extends Encoder {
    public final ByteBuffer l = ByteBuffer.allocate(10);

    public V1Encoder(Errno errno, int i) {
        super(errno, i);
        c(this.k, true);
    }

    public void g() {
        int O = this.h.O() + 1;
        this.l.position(0);
        if (O < 255) {
            this.l.limit(2);
            this.l.put((byte) O);
        } else {
            this.l.limit(10);
            this.l.put((byte) -1);
            Wire.l(this.l, (long) O);
        }
        this.l.put((byte) (this.h.d() & 1));
        ByteBuffer byteBuffer = this.l;
        e(byteBuffer, byteBuffer.limit(), this.j, false);
    }

    public void h() {
        e(this.h.a(), this.h.O(), this.k, true);
    }
}
