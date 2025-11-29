package zmq.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import zmq.ZMQ;
import zmq.util.Wire;

public class Metadata {

    /* renamed from: a  reason: collision with root package name */
    public final Properties f3617a = new Properties();

    public interface ParseListener {
        int a(String str, byte[] bArr, String str2);
    }

    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(g());
            h(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException unused) {
            return new byte[0];
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public final byte[] b(ByteBuffer byteBuffer, int i, int i2) {
        byte[] bArr = new byte[i2];
        int position = byteBuffer.position();
        byteBuffer.position(i);
        byteBuffer.get(bArr, 0, i2);
        byteBuffer.position(position);
        return bArr;
    }

    public final boolean c() {
        return this.f3617a.isEmpty();
    }

    public final int d(ByteBuffer byteBuffer, int i, ParseListener parseListener) {
        int a2;
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i);
        int remaining = duplicate.remaining();
        while (remaining > 1) {
            byte b = duplicate.get(i);
            int i2 = i + 1;
            remaining--;
            if (remaining < b) {
                break;
            }
            byte[] b2 = b(duplicate, i2, b);
            Charset charset = ZMQ.c;
            String str = new String(b2, charset);
            int i3 = i2 + b;
            remaining -= b;
            if (remaining < 4) {
                break;
            }
            int b3 = Wire.b(duplicate, i3);
            int i4 = i3 + 4;
            remaining -= 4;
            if (remaining < b3) {
                break;
            }
            byte[] b4 = b(duplicate, i4, b3);
            String str2 = new String(b4, charset);
            i = i4 + b3;
            remaining -= b3;
            if (parseListener != null && (a2 = parseListener.a(str, b4, str2)) != 0) {
                return a2;
            }
            e(str, str2);
        }
        return remaining > 0 ? 156384820 : 0;
    }

    public final void e(String str, String str2) {
        this.f3617a.setProperty(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Metadata)) {
            return this.f3617a.equals(((Metadata) obj).f3617a);
        }
        return false;
    }

    public final void f(Metadata metadata) {
        this.f3617a.putAll(metadata.f3617a);
    }

    public final int g() {
        int i = 0;
        for (Map.Entry entry : this.f3617a.entrySet()) {
            i = i + 1 + entry.getKey().toString().length() + 4 + entry.getValue().toString().length();
        }
        return i;
    }

    public final void h(OutputStream outputStream) {
        for (Map.Entry entry : this.f3617a.entrySet()) {
            String obj = entry.getKey().toString();
            String obj2 = entry.getValue().toString();
            outputStream.write(obj.length());
            Charset charset = ZMQ.c;
            outputStream.write(obj.getBytes(charset));
            outputStream.write(Wire.k(obj2.length()));
            outputStream.write(obj2.getBytes(charset));
        }
    }

    public int hashCode() {
        return this.f3617a.hashCode();
    }

    public String toString() {
        return "Metadata=" + this.f3617a;
    }
}
