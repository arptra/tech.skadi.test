package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class LogWriter extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public final String f1318a;
    public StringBuilder b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f1318a = str;
    }

    public final void a() {
        if (this.b.length() > 0) {
            Log.d(this.f1318a, this.b.toString());
            StringBuilder sb = this.b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                a();
            } else {
                this.b.append(c);
            }
        }
    }
}
