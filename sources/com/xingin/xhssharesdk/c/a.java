package com.xingin.xhssharesdk.c;

import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.r.c;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class a<T> implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final g f8167a;

    public a(g.d dVar) {
        this.f8167a = dVar;
    }

    public final void a(c cVar) {
        try {
            byte[] a2 = cVar.a();
            int i = b.f8168a;
            byte[] bArr = {(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
            if (a2.length <= 5242880) {
                this.f8167a.y((long) (a2.length + 4));
                g gVar = this.f8167a;
                gVar.getClass();
                gVar.u(bArr, 0, 4);
                g gVar2 = this.f8167a;
                gVar2.getClass();
                gVar2.u(a2, 0, a2.length);
                this.f8167a.h();
                return;
            }
            throw new IOException("Byte array length exceed! Required: <5242880, but got:" + a2.length);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
