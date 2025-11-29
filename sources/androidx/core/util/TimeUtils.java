package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;
import org.apache.commons.codec.language.Soundex;

@RestrictTo
public final class TimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f860a = new Object();
    public static char[] b = new char[24];

    public static int a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    public static void b(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            d(j - j2, printWriter, 0);
        }
    }

    public static void c(long j, PrintWriter printWriter) {
        d(j, printWriter, 0);
    }

    public static void d(long j, PrintWriter printWriter, int i) {
        synchronized (f860a) {
            printWriter.print(new String(b, 0, f(j, i)));
        }
    }

    public static void e(long j, StringBuilder sb) {
        synchronized (f860a) {
            sb.append(b, 0, f(j, 0));
        }
    }

    public static int f(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2 = j;
        int i7 = i;
        if (b.length < i7) {
            b = new char[i7];
        }
        char[] cArr = b;
        int i8 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i8 == 0) {
            int i9 = i7 - 1;
            while (i9 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i8 > 0) {
            c = '+';
        } else {
            j2 = -j2;
            c = Soundex.SILENT_MARKER;
        }
        int i10 = (int) (j2 % 1000);
        int floor = (int) Math.floor((double) (j2 / 1000));
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i11 = floor / 60;
            i4 = floor - (i11 * 60);
            i5 = i11;
        } else {
            i4 = floor;
            i5 = 0;
        }
        if (i7 != 0) {
            int a2 = a(i2, 1, false, 0);
            int a3 = a2 + a(i3, 1, a2 > 0, 2);
            int a4 = a3 + a(i5, 1, a3 > 0, 2);
            int a5 = a4 + a(i4, 1, a4 > 0, 2);
            i6 = 0;
            for (int a6 = a5 + a(i10, 2, true, a5 > 0 ? 3 : 0) + 1; a6 < i7; a6++) {
                cArr[i6] = ' ';
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i12 = i6 + 1;
        boolean z = i7 != 0;
        int i13 = i12;
        int g = g(cArr, i2, 'd', i12, false, 0);
        int g2 = g(cArr, i3, 'h', g, g != i13, z ? 2 : 0);
        int g3 = g(cArr, i5, 'm', g2, g2 != i13, z ? 2 : 0);
        int g4 = g(cArr, i4, 's', g3, g3 != i13, z ? 2 : 0);
        int g5 = g(cArr, i10, 'm', g4, true, (!z || g4 == i13) ? 0 : 3);
        cArr[g5] = 's';
        return g5 + 1;
    }

    public static int g(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
        } else {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        }
        if ((z && i3 >= 2) || i > 9 || i2 != i4) {
            int i6 = i / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i -= i6 * 10;
        }
        cArr[i4] = (char) (i + 48);
        cArr[i4 + 1] = c;
        return i4 + 2;
    }
}
