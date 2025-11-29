package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.a;
import com.xingin.xhssharesdk.a.a.C0026a;
import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.r;
import java.io.IOException;
import java.util.logging.Logger;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0026a<MessageType, BuilderType>> implements r {

    /* renamed from: a  reason: collision with root package name */
    public int f8121a = 0;

    /* renamed from: com.xingin.xhssharesdk.a.a$a  reason: collision with other inner class name */
    public static abstract class C0026a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0026a<MessageType, BuilderType>> implements r.a {
    }

    public final byte[] a() {
        try {
            int b = b();
            byte[] bArr = new byte[b];
            Logger logger = g.f8130a;
            g.b bVar = new g.b(bArr, b);
            b(bVar);
            if (bVar.e - bVar.f == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
