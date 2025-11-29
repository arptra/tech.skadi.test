package zmq.io.coder.raw;

import java.nio.ByteBuffer;
import zmq.Msg;
import zmq.io.coder.IDecoder;
import zmq.util.ValueReference;

public class RawDecoder implements IDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f3629a;
    public Msg b = new Msg();

    public RawDecoder(int i) {
        this.f3629a = ByteBuffer.allocateDirect(i);
    }

    public Msg a() {
        return this.b;
    }

    public IDecoder.Step.Result b(ByteBuffer byteBuffer, int i, ValueReference valueReference) {
        valueReference.b(Integer.valueOf(i));
        Msg msg = new Msg(i);
        this.b = msg;
        msg.A(byteBuffer);
        return IDecoder.Step.Result.DECODED;
    }

    public void destroy() {
    }

    public ByteBuffer getBuffer() {
        this.f3629a.clear();
        return this.f3629a;
    }
}
