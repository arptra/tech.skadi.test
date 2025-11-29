package zmq.io.coder;

import java.nio.ByteBuffer;
import zmq.Msg;
import zmq.io.coder.IDecoder;
import zmq.util.Errno;
import zmq.util.ValueReference;

public abstract class DecoderBase implements IDecoder {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f3625a = null;
    public boolean b;
    public int c = 0;
    public int d;
    public ByteBuffer e;
    public IDecoder.Step f = null;
    public final Errno g;

    public DecoderBase(Errno errno, int i) {
        this.d = i;
        this.e = ByteBuffer.allocateDirect(i);
        this.g = errno;
    }

    public IDecoder.Step.Result b(ByteBuffer byteBuffer, int i, ValueReference valueReference) {
        valueReference.b(0);
        if (this.b) {
            ByteBuffer byteBuffer2 = this.f3625a;
            byteBuffer2.position(byteBuffer2.position() + i);
            this.c -= i;
            valueReference.b(Integer.valueOf(i));
            while (this.f3625a.remaining() == 0) {
                IDecoder.Step.Result apply = this.f.apply();
                if (apply != IDecoder.Step.Result.MORE_DATA) {
                    return apply;
                }
            }
            return IDecoder.Step.Result.MORE_DATA;
        }
        while (((Integer) valueReference.a()).intValue() < i) {
            int min = Math.min(this.c, i - ((Integer) valueReference.a()).intValue());
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + min);
            this.f3625a.put(byteBuffer);
            byteBuffer.limit(limit);
            this.c -= min;
            valueReference.b(Integer.valueOf(((Integer) valueReference.a()).intValue() + min));
            while (true) {
                if (this.f3625a.remaining() == 0) {
                    IDecoder.Step.Result apply2 = this.f.apply();
                    if (apply2 != IDecoder.Step.Result.MORE_DATA) {
                        return apply2;
                    }
                }
            }
        }
        return IDecoder.Step.Result.MORE_DATA;
    }

    public void c(int i) {
        this.g.c(i);
    }

    public void d(ByteBuffer byteBuffer, IDecoder.Step step) {
        this.f3625a = byteBuffer;
        this.c = byteBuffer.remaining();
        this.f = step;
    }

    public void destroy() {
    }

    public void e(Msg msg, IDecoder.Step step) {
        d(msg.a(), step);
    }

    public ByteBuffer getBuffer() {
        if (this.c >= this.d) {
            this.b = true;
            return this.f3625a.duplicate();
        }
        this.b = false;
        this.e.clear();
        return this.e;
    }
}
