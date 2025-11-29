package org.apache.tika.parser.csv;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.input.ProxyReader;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

class CSVSniffer {

    /* renamed from: a  reason: collision with root package name */
    public final char[] f3254a;
    public final int b;
    public final double c;

    public static class CloseShieldReader extends ProxyReader {
        public CloseShieldReader(Reader reader) {
            super(reader);
        }

        public void close() {
        }
    }

    public static class HitMarkLimitException extends EOFException {
        private HitMarkLimitException() {
        }
    }

    public static class MutableInt {

        /* renamed from: a  reason: collision with root package name */
        public int f3255a;

        public MutableInt(int i) {
            this.f3255a = i;
        }

        public void a() {
            this.f3255a++;
        }

        public int b() {
            return this.f3255a;
        }
    }

    public class Snifflet {

        /* renamed from: a  reason: collision with root package name */
        public final char f3256a;
        public final char b = '\"';
        public Map c = new HashMap();
        public int d = 0;
        public int e = 0;
        public int f = 0;
        public boolean g = false;

        public Snifflet(char c2) {
            this.f3256a = c2;
        }

        public final CSVResult a() {
            double h2 = h();
            MediaType mediaType = TextAndCSVParser.CSV;
            if (this.f3256a == 9) {
                mediaType = TextAndCSVParser.TSV;
            }
            return new CSVResult(h2, mediaType, Character.valueOf(this.f3256a));
        }

        public final double b() {
            int i = -1;
            int i2 = 0;
            for (Map.Entry entry : this.c.entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                int b2 = ((MutableInt) entry.getValue()).b();
                if (intValue > 1 && b2 > i) {
                    i = b2;
                }
                i2 += b2;
            }
            if (i < 0 || i2 < 3) {
                return 0.0d;
            }
            double d2 = (double) i;
            double d3 = (double) i2;
            return (1.0d - (1.0d / Math.pow(d3, 0.3d))) * (d2 / d3);
        }

        public void c(PushbackReader pushbackReader) {
            int j = j(pushbackReader);
            while (true) {
                if (j != 10 && j != 13) {
                    break;
                }
                j = j(pushbackReader);
            }
            if (j != -1) {
                m(pushbackReader, j);
                return;
            }
            throw new EOFException();
        }

        public boolean d(PushbackReader pushbackReader, int i) {
            int j = j(pushbackReader);
            while (j != -1) {
                if (j == i) {
                    int j2 = j(pushbackReader);
                    if (j2 == -1) {
                        this.f++;
                        f();
                        throw new UnsurprisingEOF();
                    } else if (j2 != i) {
                        this.f++;
                        f();
                        m(pushbackReader, j2);
                        e(pushbackReader);
                        int j3 = j(pushbackReader);
                        if (j3 == -1) {
                            throw new UnsurprisingEOF();
                        } else if (j3 == 10 || j3 == 13) {
                            m(pushbackReader, j3);
                            return true;
                        } else if (j3 != this.f3256a) {
                            m(pushbackReader, j3);
                            return false;
                        } else {
                            m(pushbackReader, j3);
                            return true;
                        }
                    }
                }
                j = j(pushbackReader);
            }
            throw new EOFException();
        }

        public void e(PushbackReader pushbackReader) {
            int j = j(pushbackReader);
            while (j == 32) {
                j = j(pushbackReader);
            }
            if (j != -1) {
                m(pushbackReader, j);
                return;
            }
            throw new UnsurprisingEOF();
        }

        public void f() {
            this.e++;
        }

        public void g() {
            MutableInt mutableInt = (MutableInt) this.c.get(Integer.valueOf(this.e));
            if (mutableInt == null) {
                this.c.put(Integer.valueOf(this.e), new MutableInt(1));
            } else {
                mutableInt.a();
            }
            this.e = 0;
        }

        public double h() {
            if (this.g) {
                return -1.0d;
            }
            double b2 = b();
            double d2 = 0.0d;
            if (b2 <= -1.0d) {
                b2 = 0.0d;
            }
            int i = this.f;
            if (i > 0) {
                d2 = 1.0d - (1.0d / Math.pow((double) i, 0.2d));
            }
            return Math.min(b2 + d2, 1.0d);
        }

        public final void i(StringBuilder sb) {
            if (sb.length() > 0) {
                l(sb.toString());
                sb.setLength(0);
            }
        }

        public final int j(PushbackReader pushbackReader) {
            if (this.d < CSVSniffer.this.b - 1) {
                int read = pushbackReader.read();
                if (read == -1) {
                    return -1;
                }
                this.d++;
                return read;
            }
            throw new HitMarkLimitException();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
            r5 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            r5 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
            r5 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a6, code lost:
            r13.reset();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a9, code lost:
            throw r12;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003c A[ExcHandler: all (r12v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.apache.tika.parser.csv.CSVResult k(java.io.Reader r13) {
            /*
                r12 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r1 = 13
                r2 = 10
                r3 = 1
                r4 = 0
                r5 = -1
                java.io.PushbackReader r6 = new java.io.PushbackReader     // Catch:{ HitMarkLimitException -> 0x00b8, UnsurprisingEOF -> 0x00b2, EOFException -> 0x00aa, all -> 0x003c }
                org.apache.tika.parser.csv.CSVSniffer$CloseShieldReader r7 = new org.apache.tika.parser.csv.CSVSniffer$CloseShieldReader     // Catch:{ HitMarkLimitException -> 0x00b8, UnsurprisingEOF -> 0x00b2, EOFException -> 0x00aa, all -> 0x003c }
                r7.<init>(r13)     // Catch:{ HitMarkLimitException -> 0x00b8, UnsurprisingEOF -> 0x00b2, EOFException -> 0x00aa, all -> 0x003c }
                r8 = 2
                r6.<init>(r7, r8)     // Catch:{ HitMarkLimitException -> 0x00b8, UnsurprisingEOF -> 0x00b2, EOFException -> 0x00aa, all -> 0x003c }
                int r7 = r12.j(r6)     // Catch:{ all -> 0x009a }
                r8 = r5
            L_0x001c:
                if (r7 == r5) goto L_0x0092
                r9 = 34
                if (r7 != r9) goto L_0x005d
                r12.i(r0)     // Catch:{ all -> 0x0048 }
                if (r8 <= r5) goto L_0x004a
                char r10 = r12.f3256a     // Catch:{ all -> 0x0048 }
                if (r8 == r10) goto L_0x004a
                if (r8 == r2) goto L_0x004a
                if (r8 == r1) goto L_0x004a
                r12.g = r3     // Catch:{ all -> 0x0048 }
                org.apache.tika.parser.csv.CSVResult r5 = r12.a()     // Catch:{ all -> 0x0048 }
                r6.close()     // Catch:{ HitMarkLimitException -> 0x0045, UnsurprisingEOF -> 0x0042, EOFException -> 0x003f, all -> 0x003c }
                r13.reset()
                return r5
            L_0x003c:
                r12 = move-exception
                goto L_0x00a6
            L_0x003f:
                r5 = r8
                goto L_0x00aa
            L_0x0042:
                r5 = r8
                goto L_0x00b2
            L_0x0045:
                r5 = r8
                goto L_0x00b8
            L_0x0048:
                r5 = move-exception
                goto L_0x009d
            L_0x004a:
                boolean r9 = r12.d(r6, r9)     // Catch:{ all -> 0x0048 }
                if (r9 != 0) goto L_0x0087
                r12.g = r3     // Catch:{ all -> 0x0048 }
                org.apache.tika.parser.csv.CSVResult r5 = r12.a()     // Catch:{ all -> 0x0048 }
                r6.close()     // Catch:{ HitMarkLimitException -> 0x0045, UnsurprisingEOF -> 0x0042, EOFException -> 0x003f, all -> 0x003c }
                r13.reset()
                return r5
            L_0x005d:
                char r9 = r12.f3256a     // Catch:{ all -> 0x0048 }
                if (r7 != r9) goto L_0x006b
                r12.i(r0)     // Catch:{ all -> 0x0048 }
                r12.f()     // Catch:{ all -> 0x0048 }
                r12.e(r6)     // Catch:{ all -> 0x0048 }
                goto L_0x0087
            L_0x006b:
                if (r7 == r2) goto L_0x0075
                if (r7 != r1) goto L_0x0070
                goto L_0x0075
            L_0x0070:
                char r9 = (char) r7     // Catch:{ all -> 0x0048 }
                r0.append(r9)     // Catch:{ all -> 0x0048 }
                goto L_0x0087
            L_0x0075:
                int r9 = r0.length()     // Catch:{ all -> 0x0048 }
                if (r9 <= 0) goto L_0x007e
                r12.f()     // Catch:{ all -> 0x0048 }
            L_0x007e:
                r12.i(r0)     // Catch:{ all -> 0x0048 }
                r12.g()     // Catch:{ all -> 0x0048 }
                r12.c(r6)     // Catch:{ all -> 0x0048 }
            L_0x0087:
                int r8 = r12.j(r6)     // Catch:{ all -> 0x008f }
                r11 = r8
                r8 = r7
                r7 = r11
                goto L_0x001c
            L_0x008f:
                r5 = move-exception
                r8 = r7
                goto L_0x009d
            L_0x0092:
                r6.close()     // Catch:{ HitMarkLimitException -> 0x0045, UnsurprisingEOF -> 0x0042, EOFException -> 0x003f, all -> 0x003c }
                r13.reset()
                r3 = r4
                goto L_0x00bc
            L_0x009a:
                r7 = move-exception
                r8 = r5
                r5 = r7
            L_0x009d:
                r6.close()     // Catch:{ all -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r6 = move-exception
                r5.addSuppressed(r6)     // Catch:{ HitMarkLimitException -> 0x0045, UnsurprisingEOF -> 0x0042, EOFException -> 0x003f, all -> 0x003c }
            L_0x00a5:
                throw r5     // Catch:{ HitMarkLimitException -> 0x0045, UnsurprisingEOF -> 0x0042, EOFException -> 0x003f, all -> 0x003c }
            L_0x00a6:
                r13.reset()
                throw r12
            L_0x00aa:
                r13.reset()
                r8 = r5
                r11 = r4
                r4 = r3
                r3 = r11
                goto L_0x00bc
            L_0x00b2:
                r13.reset()
                r3 = r4
            L_0x00b6:
                r8 = r5
                goto L_0x00bc
            L_0x00b8:
                r13.reset()
                goto L_0x00b6
            L_0x00bc:
                if (r3 != 0) goto L_0x00cd
                if (r4 != 0) goto L_0x00cd
                if (r8 == r2) goto L_0x00cd
                if (r8 == r1) goto L_0x00cd
                r12.i(r0)
                r12.f()
                r12.g()
            L_0x00cd:
                org.apache.tika.parser.csv.CSVResult r12 = r12.a()
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.csv.CSVSniffer.Snifflet.k(java.io.Reader):org.apache.tika.parser.csv.CSVResult");
        }

        public void l(String str) {
        }

        public final void m(PushbackReader pushbackReader, int i) {
            if (i != -1) {
                pushbackReader.unread(i);
                this.d--;
            }
        }
    }

    public static class UnsurprisingEOF extends EOFException {
        private UnsurprisingEOF() {
        }
    }

    public CSVSniffer(int i, char[] cArr, double d) {
        this.b = i;
        this.f3254a = cArr;
        this.c = d;
    }

    public CSVResult b(Reader reader, Metadata metadata) {
        List c2 = c(reader);
        if (c2 == null || c2.size() == 0) {
            return CSVResult.d;
        }
        CSVResult cSVResult = (CSVResult) c2.get(0);
        return cSVResult.d() < this.c ? CSVResult.d : cSVResult;
    }

    /* JADX INFO: finally extract failed */
    public List c(Reader reader) {
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader);
        }
        ArrayList arrayList = new ArrayList();
        char[] cArr = this.f3254a;
        int length = cArr.length;
        int i = 0;
        while (i < length) {
            char c2 = cArr[i];
            reader.mark(this.b);
            try {
                arrayList.add(new Snifflet(c2).k(reader));
                reader.reset();
                i++;
            } catch (Throwable th) {
                reader.reset();
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
