package zmq.io.coder.v2;

import java.nio.ByteBuffer;
import zmq.Msg;
import zmq.io.coder.Decoder;
import zmq.io.coder.IDecoder;
import zmq.msg.MsgAllocator;
import zmq.util.Errno;
import zmq.util.Wire;

public class V2Decoder extends Decoder {
    public final ByteBuffer o;
    public int p;

    public V2Decoder(Errno errno, int i, long j, MsgAllocator msgAllocator) {
        super(errno, i, j, msgAllocator);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        this.o = allocate;
        allocate.limit(1);
        d(allocate, this.l);
    }

    public Msg f(int i) {
        Msg f = super.f(i);
        f.J(this.p);
        return f;
    }

    public IDecoder.Step.Result g() {
        this.o.position(0);
        this.o.limit(8);
        IDecoder.Step.Result k = k(Wire.c(this.o, 0));
        if (k != IDecoder.Step.Result.ERROR) {
            e(this.i, this.m);
        }
        return k;
    }

    public IDecoder.Step.Result h() {
        this.p = 0;
        byte b = this.o.get(0);
        if ((b & 1) > 0) {
            this.p |= 1;
        }
        if ((b & 4) > 0) {
            this.p |= 2;
        }
        this.o.position(0);
        if ((b & 2) > 0) {
            this.o.limit(8);
            d(this.o, this.k);
        } else {
            this.o.limit(1);
            d(this.o, this.j);
        }
        return IDecoder.Step.Result.MORE_DATA;
    }

    public IDecoder.Step.Result i() {
        this.o.position(0);
        this.o.limit(1);
        d(this.o, this.l);
        return IDecoder.Step.Result.DECODED;
    }

    public IDecoder.Step.Result j() {
        IDecoder.Step.Result k = k((long) (this.o.get(0) & 255));
        if (k != IDecoder.Step.Result.ERROR) {
            e(this.i, this.m);
        }
        return k;
    }
}
