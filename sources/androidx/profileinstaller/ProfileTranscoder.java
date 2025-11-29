package androidx.profileinstaller;

import androidx.annotation.RequiresApi;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

@RequiresApi
class ProfileTranscoder {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f1711a = {RingSecurityPair.OPCODE_RING_PAIR, 114, 111, 0};
    public static final byte[] b = {RingSecurityPair.OPCODE_RING_PAIR, 114, 109, 0};

    public static void A(InputStream inputStream) {
        Encoding.h(inputStream);
        int j = Encoding.j(inputStream);
        if (j != 6 && j != 7) {
            while (j > 0) {
                Encoding.j(inputStream);
                for (int j2 = Encoding.j(inputStream); j2 > 0; j2--) {
                    Encoding.h(inputStream);
                }
                j--;
            }
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) {
        if (Arrays.equals(bArr, ProfileVersion.f1715a)) {
            N(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.b)) {
            M(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.d)) {
            K(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.c)) {
            L(outputStream, dexProfileDataArr);
            return true;
        } else if (!Arrays.equals(bArr, ProfileVersion.e)) {
            return false;
        } else {
            J(outputStream, dexProfileDataArr);
            return true;
        }
    }

    public static void C(OutputStream outputStream, DexProfileData dexProfileData) {
        int[] iArr = dexProfileData.h;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            Encoding.p(outputStream, i3 - i2);
            i++;
            i2 = i3;
        }
    }

    public static WritableFileSection D(DexProfileData[] dexProfileDataArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Encoding.p(byteArrayOutputStream, dexProfileDataArr.length);
            int i = 2;
            for (DexProfileData dexProfileData : dexProfileDataArr) {
                Encoding.q(byteArrayOutputStream, dexProfileData.c);
                Encoding.q(byteArrayOutputStream, dexProfileData.d);
                Encoding.q(byteArrayOutputStream, (long) dexProfileData.g);
                String j = j(dexProfileData.f1708a, dexProfileData.b, ProfileVersion.f1715a);
                int k = Encoding.k(j);
                Encoding.p(byteArrayOutputStream, k);
                i = i + 14 + k;
                Encoding.n(byteArrayOutputStream, j);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i == byteArray.length) {
                WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, i, byteArray, false);
                byteArrayOutputStream.close();
                return writableFileSection;
            }
            throw Encoding.c("Expected size " + i + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static void E(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f1711a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, DexProfileData dexProfileData) {
        I(outputStream, dexProfileData);
        C(outputStream, dexProfileData);
        H(outputStream, dexProfileData);
    }

    public static void G(OutputStream outputStream, DexProfileData dexProfileData, String str) {
        Encoding.p(outputStream, Encoding.k(str));
        Encoding.p(outputStream, dexProfileData.e);
        Encoding.q(outputStream, (long) dexProfileData.f);
        Encoding.q(outputStream, dexProfileData.c);
        Encoding.q(outputStream, (long) dexProfileData.g);
        Encoding.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, DexProfileData dexProfileData) {
        byte[] bArr = new byte[k(dexProfileData.g)];
        for (Map.Entry entry : dexProfileData.i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, dexProfileData);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, dexProfileData);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(OutputStream outputStream, DexProfileData dexProfileData) {
        int i = 0;
        for (Map.Entry entry : dexProfileData.i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                Encoding.p(outputStream, intValue - i);
                Encoding.p(outputStream, 0);
                i = intValue;
            }
        }
    }

    public static void J(OutputStream outputStream, DexProfileData[] dexProfileDataArr) {
        Encoding.p(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String j = j(dexProfileData.f1708a, dexProfileData.b, ProfileVersion.e);
            Encoding.p(outputStream, Encoding.k(j));
            Encoding.p(outputStream, dexProfileData.i.size());
            Encoding.p(outputStream, dexProfileData.h.length);
            Encoding.q(outputStream, dexProfileData.c);
            Encoding.n(outputStream, j);
            for (Integer intValue : dexProfileData.i.keySet()) {
                Encoding.p(outputStream, intValue.intValue());
            }
            for (int p : dexProfileData.h) {
                Encoding.p(outputStream, p);
            }
        }
    }

    public static void K(OutputStream outputStream, DexProfileData[] dexProfileDataArr) {
        Encoding.r(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String j = j(dexProfileData.f1708a, dexProfileData.b, ProfileVersion.d);
            Encoding.p(outputStream, Encoding.k(j));
            Encoding.p(outputStream, dexProfileData.h.length);
            Encoding.q(outputStream, (long) (dexProfileData.i.size() * 4));
            Encoding.q(outputStream, dexProfileData.c);
            Encoding.n(outputStream, j);
            for (Integer intValue : dexProfileData.i.keySet()) {
                Encoding.p(outputStream, intValue.intValue());
                Encoding.p(outputStream, 0);
            }
            for (int p : dexProfileData.h) {
                Encoding.p(outputStream, p);
            }
        }
    }

    public static void L(OutputStream outputStream, DexProfileData[] dexProfileDataArr) {
        byte[] b2 = b(dexProfileDataArr, ProfileVersion.c);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, b2);
    }

    public static void M(OutputStream outputStream, DexProfileData[] dexProfileDataArr) {
        byte[] b2 = b(dexProfileDataArr, ProfileVersion.b);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, b2);
    }

    public static void N(OutputStream outputStream, DexProfileData[] dexProfileDataArr) {
        O(outputStream, dexProfileDataArr);
    }

    public static void O(OutputStream outputStream, DexProfileData[] dexProfileDataArr) {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dexProfileDataArr));
        arrayList.add(c(dexProfileDataArr));
        arrayList.add(d(dexProfileDataArr));
        long length2 = ((long) ProfileVersion.f1715a.length) + ((long) f1711a.length) + 4 + ((long) (arrayList.size() * 16));
        Encoding.q(outputStream, (long) arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            WritableFileSection writableFileSection = (WritableFileSection) arrayList.get(i);
            Encoding.q(outputStream, writableFileSection.f1716a.getValue());
            Encoding.q(outputStream, length2);
            if (writableFileSection.d) {
                byte[] bArr = writableFileSection.c;
                byte[] b2 = Encoding.b(bArr);
                arrayList2.add(b2);
                Encoding.q(outputStream, (long) b2.length);
                Encoding.q(outputStream, (long) bArr.length);
                length = b2.length;
            } else {
                arrayList2.add(writableFileSection.c);
                Encoding.q(outputStream, (long) writableFileSection.c.length);
                Encoding.q(outputStream, 0);
                length = writableFileSection.c.length;
            }
            length2 += (long) length;
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            outputStream.write((byte[]) arrayList2.get(i2));
        }
    }

    public static int a(DexProfileData dexProfileData) {
        int i = 0;
        for (Map.Entry value : dexProfileData.i.entrySet()) {
            i |= ((Integer) value.getValue()).intValue();
        }
        return i;
    }

    public static byte[] b(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            i2 += Encoding.k(j(dexProfileData.f1708a, dexProfileData.b, bArr)) + 16 + (dexProfileData.e * 2) + dexProfileData.f + k(dexProfileData.g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        if (Arrays.equals(bArr, ProfileVersion.c)) {
            int length = dexProfileDataArr.length;
            while (i < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i];
                G(byteArrayOutputStream, dexProfileData2, j(dexProfileData2.f1708a, dexProfileData2.b, bArr));
                F(byteArrayOutputStream, dexProfileData2);
                i++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                G(byteArrayOutputStream, dexProfileData3, j(dexProfileData3.f1708a, dexProfileData3.b, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i < length2) {
                F(byteArrayOutputStream, dexProfileDataArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == i2) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Encoding.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i2);
    }

    public static WritableFileSection c(DexProfileData[] dexProfileDataArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (i < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i];
                Encoding.p(byteArrayOutputStream, i);
                Encoding.p(byteArrayOutputStream, dexProfileData.e);
                i2 = i2 + 4 + (dexProfileData.e * 2);
                C(byteArrayOutputStream, dexProfileData);
                i++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i2 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, i2, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i2 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    public static WritableFileSection d(DexProfileData[] dexProfileDataArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (i < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i];
                int a2 = a(dexProfileData);
                byte[] e = e(dexProfileData);
                byte[] f = f(dexProfileData);
                Encoding.p(byteArrayOutputStream, i);
                int length = e.length + 2 + f.length;
                Encoding.q(byteArrayOutputStream, (long) length);
                Encoding.p(byteArrayOutputStream, a2);
                byteArrayOutputStream.write(e);
                byteArrayOutputStream.write(f);
                i2 = i2 + 6 + length;
                i++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i2 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, i2, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i2 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    public static byte[] e(DexProfileData dexProfileData) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] f(DexProfileData dexProfileData) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(AccountConstantKt.CODE_SEPARTOR, "!") : AccountConstantKt.CODE_SEPARTOR.equals(str2) ? str.replace("!", AccountConstantKt.CODE_SEPARTOR) : str;
    }

    public static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(AccountConstantKt.CODE_SEPARTOR);
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    public static DexProfileData i(DexProfileData[] dexProfileDataArr, String str) {
        if (dexProfileDataArr.length <= 0) {
            return null;
        }
        String h = h(str);
        for (int i = 0; i < dexProfileDataArr.length; i++) {
            if (dexProfileDataArr[i].b.equals(h)) {
                return dexProfileDataArr[i];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String a2 = ProfileVersion.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a2);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(AccountConstantKt.CODE_SEPARTOR)) {
            return g(str2, a2);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + ProfileVersion.a(bArr) + str2;
    }

    public static int k(int i) {
        return y(i * 2) / 8;
    }

    public static int l(int i, int i2, int i3) {
        if (i == 1) {
            throw Encoding.c("HOT methods are not stored in the bitmap");
        } else if (i == 2) {
            return i2;
        } else {
            if (i == 4) {
                return i2 + i3;
            }
            throw Encoding.c("Unexpected flag: " + i);
        }
    }

    public static int[] m(InputStream inputStream, int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += Encoding.h(inputStream);
            iArr[i3] = i2;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i, int i2) {
        int i3 = 2;
        if (!bitSet.get(l(2, i, i2))) {
            i3 = 0;
        }
        return bitSet.get(l(4, i, i2)) ? i3 | 4 : i3;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, Encoding.d(inputStream, bArr.length))) {
            return Encoding.d(inputStream, ProfileVersion.b.length);
        }
        throw Encoding.c("Invalid magic");
    }

    public static void p(InputStream inputStream, DexProfileData dexProfileData) {
        int available = inputStream.available() - dexProfileData.f;
        int i = 0;
        while (inputStream.available() > available) {
            i += Encoding.h(inputStream);
            dexProfileData.i.put(Integer.valueOf(i), 1);
            for (int h = Encoding.h(inputStream); h > 0; h--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw Encoding.c("Read too much data during profile line parse");
        }
    }

    public static DexProfileData[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) {
        if (Arrays.equals(bArr, ProfileVersion.f)) {
            if (!Arrays.equals(ProfileVersion.f1715a, bArr2)) {
                return r(inputStream, bArr, dexProfileDataArr);
            }
            throw Encoding.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, ProfileVersion.g)) {
            return t(inputStream, bArr2, dexProfileDataArr);
        } else {
            throw Encoding.c("Unsupported meta version");
        }
    }

    public static DexProfileData[] r(InputStream inputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) {
        if (Arrays.equals(bArr, ProfileVersion.f)) {
            int j = Encoding.j(inputStream);
            byte[] e = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e);
                try {
                    DexProfileData[] s = s(byteArrayInputStream, j, dexProfileDataArr);
                    byteArrayInputStream.close();
                    return s;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.c("Content found after the end of file");
            }
        } else {
            throw Encoding.c("Unsupported meta version");
        }
        throw th;
    }

    public static DexProfileData[] s(InputStream inputStream, int i, DexProfileData[] dexProfileDataArr) {
        int i2 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i == dexProfileDataArr.length) {
            String[] strArr = new String[i];
            int[] iArr = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                int h = Encoding.h(inputStream);
                iArr[i3] = Encoding.h(inputStream);
                strArr[i3] = Encoding.f(inputStream, h);
            }
            while (i2 < i) {
                DexProfileData dexProfileData = dexProfileDataArr[i2];
                if (dexProfileData.b.equals(strArr[i2])) {
                    int i4 = iArr[i2];
                    dexProfileData.e = i4;
                    dexProfileData.h = m(inputStream, i4);
                    i2++;
                } else {
                    throw Encoding.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.c("Mismatched number of dex files found in metadata");
    }

    public static DexProfileData[] t(InputStream inputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) {
        int h = Encoding.h(inputStream);
        byte[] e = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e);
            try {
                DexProfileData[] u = u(byteArrayInputStream, bArr, h, dexProfileDataArr);
                byteArrayInputStream.close();
                return u;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw Encoding.c("Content found after the end of file");
        }
        throw th;
    }

    public static DexProfileData[] u(InputStream inputStream, byte[] bArr, int i, DexProfileData[] dexProfileDataArr) {
        int i2 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i == dexProfileDataArr.length) {
            while (i2 < i) {
                Encoding.h(inputStream);
                String f = Encoding.f(inputStream, Encoding.h(inputStream));
                long i3 = Encoding.i(inputStream);
                int h = Encoding.h(inputStream);
                DexProfileData i4 = i(dexProfileDataArr, f);
                if (i4 != null) {
                    i4.d = i3;
                    int[] m = m(inputStream, h);
                    if (Arrays.equals(bArr, ProfileVersion.e)) {
                        i4.e = h;
                        i4.h = m;
                    }
                    i2++;
                } else {
                    throw Encoding.c("Missing profile key: " + f);
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.c("Mismatched number of dex files found in metadata");
    }

    public static void v(InputStream inputStream, DexProfileData dexProfileData) {
        BitSet valueOf = BitSet.valueOf(Encoding.d(inputStream, Encoding.a(dexProfileData.g * 2)));
        int i = 0;
        while (true) {
            int i2 = dexProfileData.g;
            if (i < i2) {
                int n = n(valueOf, i, i2);
                if (n != 0) {
                    Integer num = (Integer) dexProfileData.i.get(Integer.valueOf(i));
                    if (num == null) {
                        num = 0;
                    }
                    dexProfileData.i.put(Integer.valueOf(i), Integer.valueOf(n | num.intValue()));
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static DexProfileData[] w(InputStream inputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, ProfileVersion.b)) {
            int j = Encoding.j(inputStream);
            byte[] e = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e);
                try {
                    DexProfileData[] x = x(byteArrayInputStream, str, j);
                    byteArrayInputStream.close();
                    return x;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.c("Content found after the end of file");
            }
        } else {
            throw Encoding.c("Unsupported version");
        }
        throw th;
    }

    public static DexProfileData[] x(InputStream inputStream, String str, int i) {
        InputStream inputStream2 = inputStream;
        int i2 = i;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int h = Encoding.h(inputStream);
            int h2 = Encoding.h(inputStream);
            String str2 = str;
            int[] iArr = new int[h2];
            dexProfileDataArr[i3] = new DexProfileData(str2, Encoding.f(inputStream2, h), Encoding.i(inputStream), 0, h2, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream), iArr, new TreeMap());
        }
        for (int i4 = 0; i4 < i2; i4++) {
            DexProfileData dexProfileData = dexProfileDataArr[i4];
            p(inputStream2, dexProfileData);
            dexProfileData.h = m(inputStream2, dexProfileData.e);
            v(inputStream2, dexProfileData);
        }
        return dexProfileDataArr;
    }

    public static int y(int i) {
        return (i + 7) & -8;
    }

    public static void z(byte[] bArr, int i, int i2, DexProfileData dexProfileData) {
        int l = l(i, i2, dexProfileData.g);
        int i3 = l / 8;
        bArr[i3] = (byte) ((1 << (l % 8)) | bArr[i3]);
    }
}
