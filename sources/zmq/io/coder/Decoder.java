package zmq.io.coder;

import com.here.posclient.UpdateOptions;
import zmq.Msg;
import zmq.io.coder.IDecoder;
import zmq.msg.MsgAllocator;
import zmq.util.Errno;

public abstract class Decoder extends DecoderBase {
    public final long h;
    public Msg i;
    public final IDecoder.Step j = new OneByteSizeReady();
    public final IDecoder.Step k = new EightByteSizeReady();
    public final IDecoder.Step l = new FlagsReady();
    public final IDecoder.Step m = new MessageReady();
    public final MsgAllocator n;

    public final class EightByteSizeReady implements IDecoder.Step {
        public EightByteSizeReady() {
        }

        public IDecoder.Step.Result apply() {
            return Decoder.this.g();
        }
    }

    public final class FlagsReady implements IDecoder.Step {
        public FlagsReady() {
        }

        public IDecoder.Step.Result apply() {
            return Decoder.this.h();
        }
    }

    public final class MessageReady implements IDecoder.Step {
        public MessageReady() {
        }

        public IDecoder.Step.Result apply() {
            return Decoder.this.i();
        }
    }

    public final class OneByteSizeReady implements IDecoder.Step {
        public OneByteSizeReady() {
        }

        public IDecoder.Step.Result apply() {
            return Decoder.this.j();
        }
    }

    public Decoder(Errno errno, int i2, long j2, MsgAllocator msgAllocator) {
        super(errno, i2);
        this.h = j2;
        this.n = msgAllocator;
    }

    public Msg a() {
        return this.i;
    }

    public Msg f(int i2) {
        return this.n.a(i2);
    }

    public IDecoder.Step.Result g() {
        throw new UnsupportedOperationException("Have you forgot to implement eightByteSizeReady ?");
    }

    public IDecoder.Step.Result h() {
        throw new UnsupportedOperationException("Have you forgot to implement flagsReady ?");
    }

    public IDecoder.Step.Result i() {
        throw new UnsupportedOperationException("Have you forgot to implement messageReady ?");
    }

    public IDecoder.Step.Result j() {
        throw new UnsupportedOperationException("Have you forgot to implement oneByteSizeReady ?");
    }

    public final IDecoder.Step.Result k(long j2) {
        long j3 = this.h;
        if (j3 >= 0 && j2 > j3) {
            c(156384722);
            return IDecoder.Step.Result.ERROR;
        } else if (j2 > UpdateOptions.SOURCE_ANY) {
            c(156384722);
            return IDecoder.Step.Result.ERROR;
        } else {
            this.i = f((int) j2);
            return IDecoder.Step.Result.MORE_DATA;
        }
    }
}
