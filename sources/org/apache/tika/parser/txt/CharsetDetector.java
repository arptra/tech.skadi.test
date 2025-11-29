package org.apache.tika.parser.txt;

import com.here.posclient.UpdateOptions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.tika.parser.txt.CharsetRecog_2022;
import org.apache.tika.parser.txt.CharsetRecog_Unicode;
import org.apache.tika.parser.txt.CharsetRecog_mbcs;
import org.apache.tika.parser.txt.CharsetRecog_sbcs;

public class CharsetDetector {
    public static final List k;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3260a;
    public final int b;
    public int c;
    public short[] d = new short[256];
    public boolean e = false;
    public String f;
    public byte[] g;
    public int h;
    public InputStream i;
    public boolean j = false;

    public static class CSRecognizerInfo {

        /* renamed from: a  reason: collision with root package name */
        public CharsetRecognizer f3261a;
        public boolean b;

        public CSRecognizerInfo(CharsetRecognizer charsetRecognizer, boolean z) {
            this.f3261a = charsetRecognizer;
            this.b = z;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF8(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_sjis(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022JP(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022CN(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022KR(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_gb_18030(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_jp(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_kr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_big5(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_1(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_2(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_5_ru(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_6_ar(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_7_el(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_I_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1251(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1256(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_KOI8_R(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_9_tr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_EBCDIC_500_de(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_EBCDIC_500_en(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_EBCDIC_500_es(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_EBCDIC_500_fr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_EBCDIC_500_it(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_EBCDIC_500_nl(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_rtl(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_ltr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_rtl(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_ltr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM866_ru(), true));
        k = Collections.unmodifiableList(arrayList);
    }

    public CharsetDetector(int i2) {
        this.b = i2;
        this.f3260a = new byte[i2];
    }

    public final void a() {
        int i2;
        int i3;
        if (this.j) {
            int i4 = 0;
            i3 = 0;
            i2 = 0;
            boolean z = false;
            for (int i5 = 0; i5 < this.h; i5++) {
                byte[] bArr = this.f3260a;
                if (i4 >= bArr.length) {
                    break;
                }
                byte b2 = this.g[i5];
                if (b2 == 60) {
                    if (z) {
                        i2++;
                    }
                    i3++;
                    z = true;
                }
                if (!z) {
                    bArr[i4] = b2;
                    i4++;
                }
                if (b2 == 62) {
                    z = false;
                }
            }
            this.c = i4;
        } else {
            i3 = 0;
            i2 = 0;
        }
        if (i3 < 5 || i3 / 5 < i2 || (this.c < 100 && this.h > 600)) {
            int i6 = this.h;
            int i7 = this.b;
            if (i6 > i7) {
                i6 = i7;
            }
            int i8 = 0;
            while (i8 < i6) {
                this.f3260a[i8] = this.g[i8];
                i8++;
            }
            this.c = i8;
        }
        Arrays.fill(this.d, 0);
        for (int i9 = 0; i9 < this.c; i9++) {
            byte b3 = this.f3260a[i9] & 255;
            short[] sArr = this.d;
            sArr[b3] = (short) (sArr[b3] + 1);
        }
        this.e = false;
        for (int i10 = 128; i10 <= 159; i10++) {
            if (this.d[i10] != 0) {
                this.e = true;
                return;
            }
        }
    }

    public CharsetMatch[] b() {
        int d2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            List list = k;
            if (i2 < list.size()) {
                CharsetRecognizer charsetRecognizer = ((CSRecognizerInfo) list.get(i2)).f3261a;
                CharsetMatch c2 = charsetRecognizer.c(this);
                if (c2 != null && (d2 = c2.d() & 255) > 0) {
                    int min = Math.min(d2, 100);
                    String str = this.f;
                    if (str != null && str.equalsIgnoreCase(charsetRecognizer.b())) {
                        min += (100 - min) / 2;
                    }
                    arrayList.add(new CharsetMatch(this, charsetRecognizer, min, c2.getName(), c2.f()));
                }
                i2++;
            } else {
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                return (CharsetMatch[]) arrayList.toArray(new CharsetMatch[0]);
            }
        }
    }

    public boolean c(boolean z) {
        boolean z2 = this.j;
        this.j = z;
        return z2;
    }

    public final void d(String str) {
        Charset forName;
        if (str != null && !str.isEmpty() && (forName = Charset.forName(str)) != null) {
            this.f = forName.name();
        }
    }

    public CharsetDetector e(String str) {
        d(str);
        return this;
    }

    /* JADX INFO: finally extract failed */
    public CharsetDetector f(InputStream inputStream) {
        this.i = inputStream;
        inputStream.mark(this.b);
        byte[] bArr = new byte[this.b];
        try {
            long read = (long) IOUtils.read(this.i, bArr);
            if (read < UpdateOptions.SOURCE_ANY) {
                this.i.reset();
                return read < 1 ? g(new byte[0]) : ((long) this.b) > read ? h(bArr, (int) read) : g(bArr);
            }
            throw new IOException("Can't have read > Integer.MAX_VALUE bytes");
        } catch (Throwable th) {
            this.i.reset();
            throw th;
        }
    }

    public CharsetDetector g(byte[] bArr) {
        return h(bArr, bArr.length);
    }

    public final CharsetDetector h(byte[] bArr, int i2) {
        this.g = bArr;
        this.h = i2;
        a();
        return this;
    }
}
