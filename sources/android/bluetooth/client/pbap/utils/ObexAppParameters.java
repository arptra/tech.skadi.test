package android.bluetooth.client.pbap.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.obex.HeaderSet;

public final class ObexAppParameters {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f82a = new HashMap();

    public ObexAppParameters() {
    }

    public static ObexAppParameters g(HeaderSet headerSet) {
        try {
            return new ObexAppParameters((byte[]) headerSet.b(76));
        } catch (IOException unused) {
            return null;
        }
    }

    public void a(byte b, byte b2) {
        this.f82a.put(Byte.valueOf(b), ByteBuffer.allocate(1).put(b2).array());
    }

    public void b(byte b, long j) {
        this.f82a.put(Byte.valueOf(b), ByteBuffer.allocate(8).putLong(j).array());
    }

    public void c(byte b, short s) {
        this.f82a.put(Byte.valueOf(b), ByteBuffer.allocate(2).putShort(s).array());
    }

    public void d(byte b, byte[] bArr) {
        this.f82a.put(Byte.valueOf(b), bArr);
    }

    public void e(HeaderSet headerSet) {
        if (this.f82a.size() > 0) {
            headerSet.e(76, i());
        }
    }

    public boolean f(byte b) {
        return this.f82a.containsKey(Byte.valueOf(b));
    }

    public byte h(byte b) {
        byte[] bArr = (byte[]) this.f82a.get(Byte.valueOf(b));
        if (bArr == null || bArr.length < 1) {
            return 0;
        }
        return ByteBuffer.wrap(bArr).get();
    }

    public byte[] i() {
        int i = 0;
        for (Map.Entry value : this.f82a.entrySet()) {
            i += ((byte[]) value.getValue()).length + 2;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (Map.Entry entry : this.f82a.entrySet()) {
            int length = ((byte[]) entry.getValue()).length;
            int i3 = i2 + 1;
            bArr[i2] = ((Byte) entry.getKey()).byteValue();
            int i4 = i2 + 2;
            bArr[i3] = (byte) length;
            System.arraycopy(entry.getValue(), 0, bArr, i4, length);
            i2 = i4 + length;
        }
        return bArr;
    }

    public short j(byte b) {
        byte[] bArr = (byte[]) this.f82a.get(Byte.valueOf(b));
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        return ByteBuffer.wrap(bArr).getShort();
    }

    public String toString() {
        return this.f82a.toString();
    }

    public ObexAppParameters(byte[] bArr) {
        if (bArr != null) {
            int i = 0;
            while (i < bArr.length && bArr.length - i >= 2) {
                int i2 = i + 1;
                byte b = bArr[i];
                int i3 = i + 2;
                byte b2 = bArr[i2];
                if ((bArr.length - i3) - b2 >= 0) {
                    byte[] bArr2 = new byte[b2];
                    System.arraycopy(bArr, i3, bArr2, 0, b2);
                    d(b, bArr2);
                    i = i3 + b2;
                } else {
                    return;
                }
            }
        }
    }
}
