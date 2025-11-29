package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

class InputStreamResource implements ForkResource {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f10067a;

    public InputStreamResource(InputStream inputStream) {
        this.f10067a = inputStream;
    }

    public Throwable a(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        int i;
        byte[] bArr = new byte[dataInputStream.readInt()];
        try {
            i = this.f10067a.read(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        dataOutputStream.writeInt(i);
        if (i > 0) {
            dataOutputStream.write(bArr, 0, i);
        }
        dataOutputStream.flush();
        return null;
    }
}
