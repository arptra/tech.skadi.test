package zmq.io.coder.v1;

import java.nio.ByteBuffer;
import zmq.io.coder.Decoder;
import zmq.io.coder.IDecoder;
import zmq.msg.MsgAllocator;
import zmq.util.Errno;
import zmq.util.Wire;

public class V1Decoder extends Decoder {
    public final ByteBuffer o;

    public V1Decoder(Errno errno, int i, long j, MsgAllocator msgAllocator) {
        super(errno, i, j, msgAllocator);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        this.o = allocate;
        allocate.limit(1);
        d(allocate, this.j);
    }

    public IDecoder.Step.Result g() {
        this.o.position(0);
        this.o.limit(8);
        long c = Wire.c(this.o, 0);
        if (c <= 0) {
            c(156384820);
            return IDecoder.Step.Result.ERROR;
        }
        this.o.limit(1);
        IDecoder.Step.Result k = k(c - 1);
        if (k != IDecoder.Step.Result.ERROR) {
            d(this.o, this.l);
        }
        return k;
    }

    public IDecoder.Step.Result h() {
        if ((this.o.get(0) & 1) > 0) {
            this.i.J(1);
        }
        e(this.i, this.m);
        return IDecoder.Step.Result.MORE_DATA;
    }

    public IDecoder.Step.Result i() {
        this.o.position(0);
        this.o.limit(1);
        d(this.o, this.j);
        return IDecoder.Step.Result.DECODED;
    }

    public IDecoder.Step.Result j() {
        byte b = this.o.get(0) & 255;
        if (b == 255) {
            this.o.position(0);
            this.o.limit(8);
            d(this.o, this.k);
            return IDecoder.Step.Result.MORE_DATA;
        } else if (b <= 0) {
            c(156384820);
            return IDecoder.Step.Result.ERROR;
        } else {
            this.o.position(0);
            this.o.limit(1);
            IDecoder.Step.Result k = k((long) (b - 1));
            if (k != IDecoder.Step.Result.ERROR) {
                d(this.o, this.l);
            }
            return k;
        }
    }
}
