package com.xingin.xhssharesdk.a;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f8140a = Charset.forName("UTF-8");
    public static final byte[] b;

    public interface a {
        int a();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new f(bArr, 0, 0, false).c(0);
        } catch (m e) {
            throw new IllegalArgumentException(e);
        }
    }
}
