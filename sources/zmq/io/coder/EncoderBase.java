package zmq.io.coder;

import java.nio.ByteBuffer;
import zmq.Msg;
import zmq.util.Errno;
import zmq.util.ValueReference;

public abstract class EncoderBase implements IEncoder {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f3628a;
    public Runnable b;
    public boolean c;
    public int d;
    public final ByteBuffer e;
    public final int f;
    public boolean g = false;
    public Msg h;
    public final Errno i;

    public EncoderBase(Errno errno, int i2) {
        this.i = errno;
        this.f = i2;
        this.e = ByteBuffer.allocateDirect(i2);
    }

    public final void a(Msg msg) {
        this.h = msg;
        d();
    }

    public final int b(ValueReference valueReference, int i2) {
        ByteBuffer byteBuffer = (ByteBuffer) valueReference.a();
        if (byteBuffer == null) {
            byteBuffer = this.e;
            i2 = this.f;
            byteBuffer.clear();
        }
        if (this.h == null) {
            return 0;
        }
        byteBuffer.limit(byteBuffer.capacity());
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            if (this.d == 0) {
                if (this.c) {
                    this.h = null;
                    break;
                }
                d();
            }
            if (i3 == 0 && valueReference.a() == null && this.d >= i2) {
                ByteBuffer byteBuffer2 = this.f3628a;
                byteBuffer2.limit(byteBuffer2.capacity());
                valueReference.b(this.f3628a);
                int i4 = this.d;
                this.f3628a = null;
                this.d = 0;
                return i4;
            }
            int min = Math.min(this.d, i2 - i3);
            int limit = this.f3628a.limit();
            ByteBuffer byteBuffer3 = this.f3628a;
            byteBuffer3.limit(Math.min(byteBuffer3.capacity(), this.f3628a.position() + min));
            int position = byteBuffer.position();
            byteBuffer.put(this.f3628a);
            int position2 = byteBuffer.position() - position;
            this.f3628a.limit(limit);
            i3 += position2;
            this.d -= position2;
        }
        valueReference.b(byteBuffer);
        return i3;
    }

    public void c(Runnable runnable, boolean z) {
        f((byte[]) null, 0, runnable, z);
    }

    public void d() {
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void destroy() {
    }

    public void e(ByteBuffer byteBuffer, int i2, Runnable runnable, boolean z) {
        byteBuffer.limit(i2);
        byteBuffer.position(i2);
        byteBuffer.flip();
        this.f3628a = byteBuffer;
        this.d = i2;
        this.b = runnable;
        this.c = z;
    }

    public void encoded() {
        this.e.flip();
    }

    public final void f(byte[] bArr, int i2, Runnable runnable, boolean z) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f3628a = wrap;
            wrap.limit(i2);
        } else {
            this.f3628a = null;
        }
        this.d = i2;
        this.b = runnable;
        this.c = z;
    }
}
