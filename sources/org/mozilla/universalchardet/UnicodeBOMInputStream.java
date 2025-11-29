package org.mozilla.universalchardet;

import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.InputStream;
import java.io.PushbackInputStream;
import org.eclipse.jetty.util.security.Constraint;

public class UnicodeBOMInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final PushbackInputStream f3432a;
    public boolean b;

    public static final class BOM {
        public static final BOM c = new BOM(new byte[0], Constraint.NONE);
        public static final BOM d = new BOM(new byte[]{ByteSourceJsonBootstrapper.UTF8_BOM_1, ByteSourceJsonBootstrapper.UTF8_BOM_2, ByteSourceJsonBootstrapper.UTF8_BOM_3}, "UTF-8");
        public static final BOM e = new BOM(new byte[]{-1, -2}, "UTF-16 little-endian");
        public static final BOM f = new BOM(new byte[]{-2, -1}, "UTF-16 big-endian");
        public static final BOM g = new BOM(new byte[]{-1, -2, 0, 0}, "UTF-32 little-endian");
        public static final BOM h = new BOM(new byte[]{0, 0, -2, -1}, "UTF-32 big-endian");

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f3433a;
        public final String b;

        public BOM(byte[] bArr, String str) {
            this.f3433a = bArr;
            this.b = str;
        }

        public final String toString() {
            return this.b;
        }
    }

    public int available() {
        return this.f3432a.available();
    }

    public void close() {
        this.f3432a.close();
    }

    public synchronized void mark(int i) {
        this.f3432a.mark(i);
    }

    public boolean markSupported() {
        return this.f3432a.markSupported();
    }

    public int read() {
        this.b = true;
        return this.f3432a.read();
    }

    public synchronized void reset() {
        this.f3432a.reset();
    }

    public long skip(long j) {
        this.b = true;
        return this.f3432a.skip(j);
    }

    public int read(byte[] bArr) {
        this.b = true;
        return this.f3432a.read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        this.b = true;
        return this.f3432a.read(bArr, i, i2);
    }
}
