package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import org.apache.tika.exception.ZeroByteFileException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.BodyContentHandler;

public class ParsingReader extends Reader {

    /* renamed from: a  reason: collision with root package name */
    public final Parser f3249a;
    public final Reader b;
    public final Writer c;
    public final InputStream d;
    public final Metadata e;
    public final ParseContext f;
    public transient Throwable g;

    public class ParsingTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ParsingReader f3250a;

        public void run() {
            try {
                this.f3250a.f3249a.parse(this.f3250a.d, new BodyContentHandler(this.f3250a.c), this.f3250a.e, this.f3250a.f);
            } catch (Throwable th) {
                Throwable unused = this.f3250a.g = th;
            }
            try {
                this.f3250a.d.close();
            } catch (Throwable th2) {
                if (this.f3250a.g == null) {
                    Throwable unused2 = this.f3250a.g = th2;
                }
            }
            try {
                this.f3250a.c.close();
            } catch (Throwable th3) {
                if (this.f3250a.g == null) {
                    Throwable unused3 = this.f3250a.g = th3;
                }
            }
        }
    }

    public void close() {
        this.b.close();
    }

    public int read(char[] cArr, int i, int i2) {
        Throwable th = this.g;
        if (th instanceof ZeroByteFileException) {
            return -1;
        }
        if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th == null) {
            return this.b.read(cArr, i, i2);
        } else {
            throw new IOException("", this.g);
        }
    }
}
