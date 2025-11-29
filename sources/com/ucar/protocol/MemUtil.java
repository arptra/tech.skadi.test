package com.ucar.protocol;

import com.honey.account.f3.a;
import com.honey.account.f3.b;
import java.nio.ByteBuffer;

public class MemUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f9633a;
    public static final ByteBuffer b;
    public static final ThreadLocal c = ThreadLocal.withInitial(new a());
    public static final ThreadLocal d = ThreadLocal.withInitial(new b());

    static {
        byte[] bArr = new byte[0];
        f9633a = bArr;
        b = ByteBuffer.wrap(bArr);
    }

    public static /* synthetic */ byte[] c() {
        return new byte[131072];
    }

    public static byte[] e(int i) {
        return i <= 131072 ? (byte[]) c.get() : new byte[i];
    }

    public static ByteBuffer f(int i) {
        ByteBuffer allocate = i <= 131072 ? (ByteBuffer) d.get() : ByteBuffer.allocate(i);
        if (allocate != null) {
            allocate.clear();
            allocate.limit(i);
        }
        return allocate;
    }
}
