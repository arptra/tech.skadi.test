package com.jakewharton.disklrucache;

import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public final class DiskLruCache implements Closeable {
    public static final Pattern o = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final OutputStream p = new OutputStream() {
        public void write(int i) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final File f9239a;
    public final File b;
    public final File c;
    public final File d;
    public final int e;
    public long f;
    public final int g;
    public long h = 0;
    public Writer i;
    public final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    public int k;
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable n = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() {
            /*
                r3 = this;
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                java.io.Writer r1 = r1.i     // Catch:{ all -> 0x000e }
                r2 = 0
                if (r1 != 0) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return r2
            L_0x000e:
                r3 = move-exception
                goto L_0x002a
            L_0x0010:
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1.p0()     // Catch:{ all -> 0x000e }
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                boolean r1 = r1.N()     // Catch:{ all -> 0x000e }
                if (r1 == 0) goto L_0x0028
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1.d0()     // Catch:{ all -> 0x000e }
                com.jakewharton.disklrucache.DiskLruCache r3 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1 = 0
                int unused = r3.k = r1     // Catch:{ all -> 0x000e }
            L_0x0028:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return r2
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.AnonymousClass1.call():java.lang.Void");
        }
    };

    public final class Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Entry f9241a;
        public final boolean[] b;
        public boolean c;
        public boolean d;

        public class FaultHidingOutputStream extends FilterOutputStream {
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.c = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.c = true;
                }
            }

            public FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.c = true;
                }
            }
        }

        public void a() {
            DiskLruCache.this.s(this, false);
        }

        public void e() {
            if (this.c) {
                DiskLruCache.this.s(this, false);
                DiskLruCache.this.f0(this.f9241a.f9243a);
            } else {
                DiskLruCache.this.s(this, true);
            }
            this.d = true;
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream f(int r4) {
            /*
                r3 = this;
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.f9241a     // Catch:{ all -> 0x0019 }
                com.jakewharton.disklrucache.DiskLruCache$Editor r1 = r1.d     // Catch:{ all -> 0x0019 }
                if (r1 != r3) goto L_0x0043
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.f9241a     // Catch:{ all -> 0x0019 }
                boolean r1 = r1.c     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x001b
                boolean[] r1 = r3.b     // Catch:{ all -> 0x0019 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0019 }
                goto L_0x001b
            L_0x0019:
                r3 = move-exception
                goto L_0x0049
            L_0x001b:
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.f9241a     // Catch:{ all -> 0x0019 }
                java.io.File r4 = r1.k(r4)     // Catch:{ all -> 0x0019 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0027 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0027 }
                goto L_0x0035
            L_0x0027:
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0019 }
                java.io.File r1 = r1.f9239a     // Catch:{ all -> 0x0019 }
                r1.mkdirs()     // Catch:{ all -> 0x0019 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003d }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003d }
            L_0x0035:
                com.jakewharton.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream r4 = new com.jakewharton.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream     // Catch:{ all -> 0x0019 }
                r2 = 0
                r4.<init>(r1)     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return r4
            L_0x003d:
                java.io.OutputStream r3 = com.jakewharton.disklrucache.DiskLruCache.p     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return r3
            L_0x0043:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0019 }
                r3.<init>()     // Catch:{ all -> 0x0019 }
                throw r3     // Catch:{ all -> 0x0019 }
            L_0x0049:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.f(int):java.io.OutputStream");
        }

        public Editor(Entry entry) {
            this.f9241a = entry;
            this.b = entry.c ? null : new boolean[DiskLruCache.this.g];
        }
    }

    public final class Entry {

        /* renamed from: a  reason: collision with root package name */
        public final String f9243a;
        public final long[] b;
        public boolean c;
        public Editor d;
        public long e;

        public File j(int i) {
            File d2 = DiskLruCache.this.f9239a;
            return new File(d2, this.f9243a + "." + i);
        }

        public File k(int i) {
            File d2 = DiskLruCache.this.f9239a;
            return new File(d2, this.f9243a + "." + i + DiskFileUpload.postfix);
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long append : this.b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public final IOException m(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) {
            if (strArr.length == DiskLruCache.this.g) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public Entry(String str) {
            this.f9243a = str;
            this.b = new long[DiskLruCache.this.g];
        }
    }

    public final class Snapshot implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final String f9244a;
        public final long b;
        public final InputStream[] c;
        public final long[] d;

        public InputStream a(int i) {
            return this.c[i];
        }

        public void close() {
            for (InputStream a2 : this.c) {
                Util.a(a2);
            }
        }

        public Snapshot(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f9244a = str;
            this.b = j;
            this.c = inputStreamArr;
            this.d = jArr;
        }
    }

    public DiskLruCache(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.f9239a = file2;
        this.e = i2;
        this.b = new File(file2, "journal");
        this.c = new File(file2, "journal.tmp");
        this.d = new File(file2, "journal.bkp");
        this.g = i3;
        this.f = j2;
    }

    public static DiskLruCache S(File file, int i2, int i3, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    i0(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i2, i3, j2);
            if (diskLruCache.b.exists()) {
                try {
                    diskLruCache.U();
                    diskLruCache.T();
                    diskLruCache.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.b, true), Util.f9247a));
                    return diskLruCache;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    diskLruCache.u();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i2, i3, j2);
            diskLruCache2.d0();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public static void i0(File file, File file2, boolean z) {
        if (z) {
            v(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void v(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:33|34|29|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r11.k++;
        r11.i.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        if (N() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        r11.m.submit(r11.n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        return new com.jakewharton.disklrucache.DiskLruCache.Snapshot(r11, r12, com.jakewharton.disklrucache.DiskLruCache.Entry.c(r0), r8, com.jakewharton.disklrucache.DiskLruCache.Entry.a(r0), (com.jakewharton.disklrucache.DiskLruCache.AnonymousClass1) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0077 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.jakewharton.disklrucache.DiskLruCache.Snapshot J(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.r()     // Catch:{ all -> 0x0034 }
            r11.q0(r12)     // Catch:{ all -> 0x0034 }
            java.util.LinkedHashMap r0 = r11.j     // Catch:{ all -> 0x0034 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0034 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0034 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.c     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.g     // Catch:{ all -> 0x0034 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0034 }
            r2 = 0
            r3 = r2
        L_0x0022:
            int r4 = r11.g     // Catch:{ FileNotFoundException -> 0x0077 }
            if (r3 >= r4) goto L_0x0036
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0077 }
            java.io.File r5 = r0.j(r3)     // Catch:{ FileNotFoundException -> 0x0077 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0077 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0077 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            r12 = move-exception
            goto L_0x0087
        L_0x0036:
            int r1 = r11.k     // Catch:{ all -> 0x0034 }
            int r1 = r1 + 1
            r11.k = r1     // Catch:{ all -> 0x0034 }
            java.io.Writer r1 = r11.i     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x0034 }
            r2.append(r12)     // Catch:{ all -> 0x0034 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0034 }
            r1.append(r2)     // Catch:{ all -> 0x0034 }
            boolean r1 = r11.N()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0064
            java.util.concurrent.ThreadPoolExecutor r1 = r11.m     // Catch:{ all -> 0x0034 }
            java.util.concurrent.Callable r2 = r11.n     // Catch:{ all -> 0x0034 }
            r1.submit(r2)     // Catch:{ all -> 0x0034 }
        L_0x0064:
            com.jakewharton.disklrucache.DiskLruCache$Snapshot r1 = new com.jakewharton.disklrucache.DiskLruCache$Snapshot     // Catch:{ all -> 0x0034 }
            long r6 = r0.e     // Catch:{ all -> 0x0034 }
            long[] r9 = r0.b     // Catch:{ all -> 0x0034 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r5, r6, r8, r9)     // Catch:{ all -> 0x0034 }
            monitor-exit(r11)
            return r1
        L_0x0077:
            int r12 = r11.g     // Catch:{ all -> 0x0034 }
            if (r2 >= r12) goto L_0x0085
            r12 = r8[r2]     // Catch:{ all -> 0x0034 }
            if (r12 == 0) goto L_0x0085
            com.jakewharton.disklrucache.Util.a(r12)     // Catch:{ all -> 0x0034 }
            int r2 = r2 + 1
            goto L_0x0077
        L_0x0085:
            monitor-exit(r11)
            return r1
        L_0x0087:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.J(java.lang.String):com.jakewharton.disklrucache.DiskLruCache$Snapshot");
    }

    public final boolean N() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.j.size();
    }

    public final void T() {
        v(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i2 = 0;
            if (entry.d == null) {
                while (i2 < this.g) {
                    this.h += entry.b[i2];
                    i2++;
                }
            } else {
                Editor unused = entry.d = null;
                while (i2 < this.g) {
                    v(entry.j(i2));
                    v(entry.k(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r8.k = r0 - r8.j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0061 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0061=Splitter:B:17:0x0061, B:21:0x006e=Splitter:B:21:0x006e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void U() {
        /*
            r8 = this;
            java.lang.String r0 = ", "
            com.jakewharton.disklrucache.StrictLineReader r1 = new com.jakewharton.disklrucache.StrictLineReader
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r8.b
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.jakewharton.disklrucache.Util.f9247a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.c()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r1.c()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r1.c()     // Catch:{ all -> 0x005f }
            java.lang.String r5 = r1.c()     // Catch:{ all -> 0x005f }
            java.lang.String r6 = r1.c()     // Catch:{ all -> 0x005f }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x006e
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x006e
            int r7 = r8.e     // Catch:{ all -> 0x005f }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005f }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x006e
            int r4 = r8.g     // Catch:{ all -> 0x005f }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005f }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x006e
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.c()     // Catch:{ EOFException -> 0x0061 }
            r8.c0(r2)     // Catch:{ EOFException -> 0x0061 }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            r8 = move-exception
            goto L_0x009c
        L_0x0061:
            java.util.LinkedHashMap r2 = r8.j     // Catch:{ all -> 0x005f }
            int r2 = r2.size()     // Catch:{ all -> 0x005f }
            int r0 = r0 - r2
            r8.k = r0     // Catch:{ all -> 0x005f }
            com.jakewharton.disklrucache.Util.a(r1)
            return
        L_0x006e:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r4.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r7 = "unexpected journal header: ["
            r4.append(r7)     // Catch:{ all -> 0x005f }
            r4.append(r2)     // Catch:{ all -> 0x005f }
            r4.append(r0)     // Catch:{ all -> 0x005f }
            r4.append(r3)     // Catch:{ all -> 0x005f }
            r4.append(r0)     // Catch:{ all -> 0x005f }
            r4.append(r5)     // Catch:{ all -> 0x005f }
            r4.append(r0)     // Catch:{ all -> 0x005f }
            r4.append(r6)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "]"
            r4.append(r0)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x005f }
            r8.<init>(r0)     // Catch:{ all -> 0x005f }
            throw r8     // Catch:{ all -> 0x005f }
        L_0x009c:
            com.jakewharton.disklrucache.Util.a(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.U():void");
    }

    public final void c0(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            Entry entry = (Entry) this.j.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.j.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = entry.c = true;
                Editor unused2 = entry.d = null;
                entry.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                Editor unused3 = entry.d = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public synchronized void close() {
        try {
            if (this.i != null) {
                Iterator it = new ArrayList(this.j.values()).iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (entry.d != null) {
                        entry.d.a();
                    }
                }
                p0();
                this.i.close();
                this.i = null;
            }
        } finally {
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void d0() {
        BufferedWriter bufferedWriter;
        try {
            Writer writer = this.i;
            if (writer != null) {
                writer.close();
            }
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), Util.f9247a));
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(StringUtils.LF);
            for (Entry entry : this.j.values()) {
                if (entry.d != null) {
                    bufferedWriter.write("DIRTY " + entry.f9243a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + entry.f9243a + entry.l() + 10);
                }
            }
            bufferedWriter.close();
            if (this.b.exists()) {
                i0(this.b, this.d, true);
            }
            i0(this.c, this.b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), Util.f9247a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        } finally {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean f0(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.r()     // Catch:{ all -> 0x0046 }
            r6.q0(r7)     // Catch:{ all -> 0x0046 }
            java.util.LinkedHashMap r0 = r6.j     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0046 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0046 }
            r1 = 0
            if (r0 == 0) goto L_0x0093
            com.jakewharton.disklrucache.DiskLruCache$Editor r2 = r0.d     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0093
        L_0x001a:
            int r2 = r6.g     // Catch:{ all -> 0x0046 }
            if (r1 >= r2) goto L_0x005e
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0046 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x0048
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x002f
            goto L_0x0048
        L_0x002f:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r0.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0046 }
            r0.append(r2)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0046 }
            r7.<init>(r0)     // Catch:{ all -> 0x0046 }
            throw r7     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r7 = move-exception
            goto L_0x0095
        L_0x0048:
            long r2 = r6.h     // Catch:{ all -> 0x0046 }
            long[] r4 = r0.b     // Catch:{ all -> 0x0046 }
            r4 = r4[r1]     // Catch:{ all -> 0x0046 }
            long r2 = r2 - r4
            r6.h = r2     // Catch:{ all -> 0x0046 }
            long[] r2 = r0.b     // Catch:{ all -> 0x0046 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0046 }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x005e:
            int r0 = r6.k     // Catch:{ all -> 0x0046 }
            r1 = 1
            int r0 = r0 + r1
            r6.k = r0     // Catch:{ all -> 0x0046 }
            java.io.Writer r0 = r6.i     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r2.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x0046 }
            r2.append(r7)     // Catch:{ all -> 0x0046 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0046 }
            r0.append(r2)     // Catch:{ all -> 0x0046 }
            java.util.LinkedHashMap r0 = r6.j     // Catch:{ all -> 0x0046 }
            r0.remove(r7)     // Catch:{ all -> 0x0046 }
            boolean r7 = r6.N()     // Catch:{ all -> 0x0046 }
            if (r7 == 0) goto L_0x0091
            java.util.concurrent.ThreadPoolExecutor r7 = r6.m     // Catch:{ all -> 0x0046 }
            java.util.concurrent.Callable r0 = r6.n     // Catch:{ all -> 0x0046 }
            r7.submit(r0)     // Catch:{ all -> 0x0046 }
        L_0x0091:
            monitor-exit(r6)
            return r1
        L_0x0093:
            monitor-exit(r6)
            return r1
        L_0x0095:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.f0(java.lang.String):boolean");
    }

    public synchronized void flush() {
        r();
        p0();
        this.i.flush();
    }

    public final void p0() {
        while (this.h > this.f) {
            f0((String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    public final void q0(String str) {
        if (!o.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    public final void r() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void s(com.jakewharton.disklrucache.DiskLruCache.Editor r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = r10.f9241a     // Catch:{ all -> 0x0030 }
            com.jakewharton.disklrucache.DiskLruCache$Editor r1 = r0.d     // Catch:{ all -> 0x0030 }
            if (r1 != r10) goto L_0x010d
            r1 = 0
            if (r11 == 0) goto L_0x0050
            boolean r2 = r0.c     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0050
            r2 = r1
        L_0x0015:
            int r3 = r9.g     // Catch:{ all -> 0x0030 }
            if (r2 >= r3) goto L_0x0050
            boolean[] r3 = r10.b     // Catch:{ all -> 0x0030 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0036
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x0030 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0030 }
            if (r3 != 0) goto L_0x0033
            r10.a()     // Catch:{ all -> 0x0030 }
            monitor-exit(r9)
            return
        L_0x0030:
            r10 = move-exception
            goto L_0x0113
        L_0x0033:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0036:
            r10.a()     // Catch:{ all -> 0x0030 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r11.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0030 }
            r11.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0030 }
            r10.<init>(r11)     // Catch:{ all -> 0x0030 }
            throw r10     // Catch:{ all -> 0x0030 }
        L_0x0050:
            int r10 = r9.g     // Catch:{ all -> 0x0030 }
            if (r1 >= r10) goto L_0x0084
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x0030 }
            if (r11 == 0) goto L_0x007e
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0081
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0030 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0030 }
            long[] r10 = r0.b     // Catch:{ all -> 0x0030 }
            r3 = r10[r1]     // Catch:{ all -> 0x0030 }
            long r5 = r2.length()     // Catch:{ all -> 0x0030 }
            long[] r10 = r0.b     // Catch:{ all -> 0x0030 }
            r10[r1] = r5     // Catch:{ all -> 0x0030 }
            long r7 = r9.h     // Catch:{ all -> 0x0030 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.h = r7     // Catch:{ all -> 0x0030 }
            goto L_0x0081
        L_0x007e:
            v(r10)     // Catch:{ all -> 0x0030 }
        L_0x0081:
            int r1 = r1 + 1
            goto L_0x0050
        L_0x0084:
            int r10 = r9.k     // Catch:{ all -> 0x0030 }
            r1 = 1
            int r10 = r10 + r1
            r9.k = r10     // Catch:{ all -> 0x0030 }
            r10 = 0
            com.jakewharton.disklrucache.DiskLruCache.Editor unused = r0.d = r10     // Catch:{ all -> 0x0030 }
            boolean r10 = r0.c     // Catch:{ all -> 0x0030 }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00cb
            boolean unused = r0.c = r1     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = "CLEAN "
            r1.append(r3)     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = r0.f9243a     // Catch:{ all -> 0x0030 }
            r1.append(r3)     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = r0.l()     // Catch:{ all -> 0x0030 }
            r1.append(r3)     // Catch:{ all -> 0x0030 }
            r1.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0030 }
            r10.write(r1)     // Catch:{ all -> 0x0030 }
            if (r11 == 0) goto L_0x00f1
            long r10 = r9.l     // Catch:{ all -> 0x0030 }
            r1 = 1
            long r1 = r1 + r10
            r9.l = r1     // Catch:{ all -> 0x0030 }
            long unused = r0.e = r10     // Catch:{ all -> 0x0030 }
            goto L_0x00f1
        L_0x00cb:
            java.util.LinkedHashMap r10 = r9.j     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r0.f9243a     // Catch:{ all -> 0x0030 }
            r10.remove(r11)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r11.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "REMOVE "
            r11.append(r1)     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = r0.f9243a     // Catch:{ all -> 0x0030 }
            r11.append(r0)     // Catch:{ all -> 0x0030 }
            r11.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0030 }
            r10.write(r11)     // Catch:{ all -> 0x0030 }
        L_0x00f1:
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            r10.flush()     // Catch:{ all -> 0x0030 }
            long r10 = r9.h     // Catch:{ all -> 0x0030 }
            long r0 = r9.f     // Catch:{ all -> 0x0030 }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0104
            boolean r10 = r9.N()     // Catch:{ all -> 0x0030 }
            if (r10 == 0) goto L_0x010b
        L_0x0104:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.m     // Catch:{ all -> 0x0030 }
            java.util.concurrent.Callable r11 = r9.n     // Catch:{ all -> 0x0030 }
            r10.submit(r11)     // Catch:{ all -> 0x0030 }
        L_0x010b:
            monitor-exit(r9)
            return
        L_0x010d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0030 }
            r10.<init>()     // Catch:{ all -> 0x0030 }
            throw r10     // Catch:{ all -> 0x0030 }
        L_0x0113:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.s(com.jakewharton.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    public void u() {
        close();
        Util.b(this.f9239a);
    }

    public Editor w(String str) {
        return z(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.jakewharton.disklrucache.DiskLruCache.Editor z(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.r()     // Catch:{ all -> 0x0021 }
            r5.q0(r6)     // Catch:{ all -> 0x0021 }
            java.util.LinkedHashMap r0 = r5.j     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0021 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0021 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0025
            if (r0 == 0) goto L_0x0023
            long r3 = r0.e     // Catch:{ all -> 0x0021 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0025
            goto L_0x0023
        L_0x0021:
            r6 = move-exception
            goto L_0x0064
        L_0x0023:
            monitor-exit(r5)
            return r2
        L_0x0025:
            if (r0 != 0) goto L_0x0032
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = new com.jakewharton.disklrucache.DiskLruCache$Entry     // Catch:{ all -> 0x0021 }
            r0.<init>(r6)     // Catch:{ all -> 0x0021 }
            java.util.LinkedHashMap r7 = r5.j     // Catch:{ all -> 0x0021 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0021 }
            goto L_0x003a
        L_0x0032:
            com.jakewharton.disklrucache.DiskLruCache$Editor r7 = r0.d     // Catch:{ all -> 0x0021 }
            if (r7 == 0) goto L_0x003a
            monitor-exit(r5)
            return r2
        L_0x003a:
            com.jakewharton.disklrucache.DiskLruCache$Editor r7 = new com.jakewharton.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x0021 }
            r7.<init>(r0)     // Catch:{ all -> 0x0021 }
            com.jakewharton.disklrucache.DiskLruCache.Editor unused = r0.d = r7     // Catch:{ all -> 0x0021 }
            java.io.Writer r8 = r5.i     // Catch:{ all -> 0x0021 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r0.<init>()     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0021 }
            r0.append(r6)     // Catch:{ all -> 0x0021 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0021 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0021 }
            r8.write(r6)     // Catch:{ all -> 0x0021 }
            java.io.Writer r6 = r5.i     // Catch:{ all -> 0x0021 }
            r6.flush()     // Catch:{ all -> 0x0021 }
            monitor-exit(r5)
            return r7
        L_0x0064:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.z(java.lang.String, long):com.jakewharton.disklrucache.DiskLruCache$Editor");
    }
}
