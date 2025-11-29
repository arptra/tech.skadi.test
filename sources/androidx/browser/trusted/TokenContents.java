package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class TokenContents {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f436a;
    public String b;
    public List c;

    public TokenContents(byte[] bArr, String str, List list) {
        this.f436a = bArr;
        this.b = str;
        this.c = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            this.c.add(Arrays.copyOf(bArr2, bArr2.length));
        }
    }

    public static int b(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        for (int i = 0; i < Math.min(bArr.length, bArr2.length); i++) {
            byte b2 = bArr[i];
            byte b3 = bArr2[i];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        return 0;
    }

    public static TokenContents c(String str, List list) {
        return new TokenContents(d(str, list), str, list);
    }

    public static byte[] d(String str, List list) {
        Collections.sort(list, new a());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] e(int i) {
        g();
        List list = this.c;
        if (list != null) {
            return Arrays.copyOf((byte[]) list.get(i), ((byte[]) this.c.get(i)).length);
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TokenContents.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f436a, ((TokenContents) obj).f436a);
    }

    public String f() {
        g();
        String str = this.b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException();
    }

    public final void g() {
        if (this.b == null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.f436a));
            this.b = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            this.c = new ArrayList(readInt);
            int i = 0;
            while (i < readInt) {
                int readInt2 = dataInputStream.readInt();
                byte[] bArr = new byte[readInt2];
                if (dataInputStream.read(bArr) == readInt2) {
                    this.c.add(bArr);
                    i++;
                } else {
                    throw new IllegalStateException("Could not read fingerprint");
                }
            }
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.f436a);
    }
}
