package org.zeromq.proto;

import com.honey.account.rc.a;
import java.nio.ByteBuffer;
import org.zeromq.ZFrame;
import zmq.util.Utils;
import zmq.util.Wire;

public final class ZNeedle {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f3515a;

    public ZNeedle(ZFrame zFrame) {
        this(zFrame.c());
    }

    public static /* synthetic */ String c(int i) {
        return "Unable to handle " + i + " bytes";
    }

    public final void b(int i) {
        Utils.c(this.f3515a.position() + i <= this.f3515a.limit(), new a(i));
    }

    public void d(String str) {
        b(str.length() + 4);
        Wire.d(this.f3515a, str);
    }

    public void e(int i) {
        b(1);
        this.f3515a.put((byte) (i & 255));
    }

    public void f(int i) {
        b(4);
        Wire.i(this.f3515a, i);
    }

    public void g(String str) {
        b(str.length() + 1);
        Wire.f(this.f3515a, str);
    }

    public void h(String str) {
        if (str.length() > 255) {
            d(str);
        } else {
            g(str);
        }
    }

    public String toString() {
        return "ZNeedle [position=" + this.f3515a.position() + ", ceiling=" + this.f3515a.limit() + "]";
    }

    public ZNeedle(byte[] bArr) {
        this.f3515a = ByteBuffer.wrap(bArr);
    }
}
