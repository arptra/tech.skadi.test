package com.bumptech.glide.disklrucache;

import android.os.StrictMode;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

public final class DiskLruCache implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final File f2432a;
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
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());
    public final Callable n = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() {
            /*
                r3 = this;
                com.bumptech.glide.disklrucache.DiskLruCache r0 = com.bumptech.glide.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                java.io.Writer r1 = r1.i     // Catch:{ all -> 0x000e }
                r2 = 0
                if (r1 != 0) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return r2
            L_0x000e:
                r3 = move-exception
                goto L_0x002a
            L_0x0010:
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1.q0()     // Catch:{ all -> 0x000e }
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                boolean r1 = r1.S()     // Catch:{ all -> 0x000e }
                if (r1 == 0) goto L_0x0028
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1.f0()     // Catch:{ all -> 0x000e }
                com.bumptech.glide.disklrucache.DiskLruCache r3 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1 = 0
                int unused = r3.k = r1     // Catch:{ all -> 0x000e }
            L_0x0028:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return r2
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.AnonymousClass1.call():java.lang.Void");
        }
    };

    public static final class DiskLruCacheThreadFactory implements ThreadFactory {
        public DiskLruCacheThreadFactory() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Entry f2434a;
        public final boolean[] b;
        public boolean c;

        public void a() {
            DiskLruCache.this.s(this, false);
        }

        public void b() {
            if (!this.c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() {
            DiskLruCache.this.s(this, true);
            this.c = true;
        }

        public File f(int i) {
            File k;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f2434a.f == this) {
                        if (!this.f2434a.e) {
                            this.b[i] = true;
                        }
                        k = this.f2434a.k(i);
                        DiskLruCache.this.f2432a.mkdirs();
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return k;
        }

        public Editor(Entry entry) {
            this.f2434a = entry;
            this.b = entry.e ? null : new boolean[DiskLruCache.this.g];
        }
    }

    public final class Entry {

        /* renamed from: a  reason: collision with root package name */
        public final String f2435a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public Editor f;
        public long g;

        public File j(int i) {
            return this.c[i];
        }

        public File k(int i) {
            return this.d[i];
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
            this.f2435a = str;
            this.b = new long[DiskLruCache.this.g];
            this.c = new File[DiskLruCache.this.g];
            this.d = new File[DiskLruCache.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.g; i++) {
                sb.append(i);
                this.c[i] = new File(DiskLruCache.this.f2432a, sb.toString());
                sb.append(DiskFileUpload.postfix);
                this.d[i] = new File(DiskLruCache.this.f2432a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    public final class Value {

        /* renamed from: a  reason: collision with root package name */
        public final String f2436a;
        public final long b;
        public final long[] c;
        public final File[] d;

        public File a(int i) {
            return this.d[i];
        }

        public Value(String str, long j, File[] fileArr, long[] jArr) {
            this.f2436a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }
    }

    public DiskLruCache(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.f2432a = file2;
        this.e = i2;
        this.b = new File(file2, "journal");
        this.c = new File(file2, "journal.tmp");
        this.d = new File(file2, "journal.bkp");
        this.g = i3;
        this.f = j2;
    }

    public static void J(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static DiskLruCache T(File file, int i2, int i3, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    p0(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i2, i3, j2);
            if (diskLruCache.b.exists()) {
                try {
                    diskLruCache.c0();
                    diskLruCache.U();
                    return diskLruCache;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    diskLruCache.u();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i2, i3, j2);
            diskLruCache2.f0();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public static void p0(File file, File file2, boolean z) {
        if (z) {
            v(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void r(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void v(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized Value N(String str) {
        o();
        Entry entry = (Entry) this.j.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.e) {
            return null;
        }
        for (File exists : entry.c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append("READ");
        this.i.append(' ');
        this.i.append(str);
        this.i.append(10);
        if (S()) {
            this.m.submit(this.n);
        }
        return new Value(str, entry.g, entry.c, entry.b);
    }

    public final boolean S() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.j.size();
    }

    public final void U() {
        v(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i2 = 0;
            if (entry.f == null) {
                while (i2 < this.g) {
                    this.h += entry.b[i2];
                    i2++;
                }
            } else {
                Editor unused = entry.f = null;
                while (i2 < this.g) {
                    v(entry.j(i2));
                    v(entry.k(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(1:20)(1:21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r8.k = r0 - r8.j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        if (r1.c() != false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        f0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        r8.i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r8.b, true), com.bumptech.glide.disklrucache.Util.f2439a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0061 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0061=Splitter:B:17:0x0061, B:24:0x008e=Splitter:B:24:0x008e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c0() {
        /*
            r8 = this;
            java.lang.String r0 = ", "
            com.bumptech.glide.disklrucache.StrictLineReader r1 = new com.bumptech.glide.disklrucache.StrictLineReader
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r8.b
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.bumptech.glide.disklrucache.Util.f2439a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.d()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r1.d()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r1.d()     // Catch:{ all -> 0x005f }
            java.lang.String r5 = r1.d()     // Catch:{ all -> 0x005f }
            java.lang.String r6 = r1.d()     // Catch:{ all -> 0x005f }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x008e
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x008e
            int r7 = r8.e     // Catch:{ all -> 0x005f }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005f }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x008e
            int r4 = r8.g     // Catch:{ all -> 0x005f }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005f }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x008e
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x008e
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.d()     // Catch:{ EOFException -> 0x0061 }
            r8.d0(r2)     // Catch:{ EOFException -> 0x0061 }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            r8 = move-exception
            goto L_0x00bc
        L_0x0061:
            java.util.LinkedHashMap r2 = r8.j     // Catch:{ all -> 0x005f }
            int r2 = r2.size()     // Catch:{ all -> 0x005f }
            int r0 = r0 - r2
            r8.k = r0     // Catch:{ all -> 0x005f }
            boolean r0 = r1.c()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0074
            r8.f0()     // Catch:{ all -> 0x005f }
            goto L_0x008a
        L_0x0074:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x005f }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x005f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x005f }
            java.io.File r4 = r8.b     // Catch:{ all -> 0x005f }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x005f }
            java.nio.charset.Charset r4 = com.bumptech.glide.disklrucache.Util.f2439a     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x005f }
            r0.<init>(r2)     // Catch:{ all -> 0x005f }
            r8.i = r0     // Catch:{ all -> 0x005f }
        L_0x008a:
            com.bumptech.glide.disklrucache.Util.a(r1)
            return
        L_0x008e:
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
        L_0x00bc:
            com.bumptech.glide.disklrucache.Util.a(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.c0():void");
    }

    public synchronized void close() {
        try {
            if (this.i != null) {
                Iterator it = new ArrayList(this.j.values()).iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (entry.f != null) {
                        entry.f.a();
                    }
                }
                q0();
                r(this.i);
                this.i = null;
            }
        } finally {
        }
    }

    public final void d0(String str) {
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
                boolean unused = entry.e = true;
                Editor unused2 = entry.f = null;
                entry.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                Editor unused3 = entry.f = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void f0() {
        BufferedWriter bufferedWriter;
        try {
            Writer writer = this.i;
            if (writer != null) {
                r(writer);
            }
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), Util.f2439a));
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
                if (entry.f != null) {
                    bufferedWriter.write("DIRTY " + entry.f2435a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + entry.f2435a + entry.l() + 10);
                }
            }
            r(bufferedWriter);
            if (this.b.exists()) {
                p0(this.b, this.d, true);
            }
            p0(this.c, this.b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), Util.f2439a));
        } catch (Throwable th) {
            r(bufferedWriter);
            throw th;
        } finally {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean i0(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.o()     // Catch:{ all -> 0x0043 }
            java.util.LinkedHashMap r0 = r6.j     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0043 }
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0043 }
            r1 = 0
            if (r0 == 0) goto L_0x008f
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r2 = r0.f     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0017
            goto L_0x008f
        L_0x0017:
            int r2 = r6.g     // Catch:{ all -> 0x0043 }
            if (r1 >= r2) goto L_0x005b
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0043 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x0045
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x002c
            goto L_0x0045
        L_0x002c:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r0.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0043 }
            r7.<init>(r0)     // Catch:{ all -> 0x0043 }
            throw r7     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r7 = move-exception
            goto L_0x0091
        L_0x0045:
            long r2 = r6.h     // Catch:{ all -> 0x0043 }
            long[] r4 = r0.b     // Catch:{ all -> 0x0043 }
            r4 = r4[r1]     // Catch:{ all -> 0x0043 }
            long r2 = r2 - r4
            r6.h = r2     // Catch:{ all -> 0x0043 }
            long[] r2 = r0.b     // Catch:{ all -> 0x0043 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0043 }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x005b:
            int r0 = r6.k     // Catch:{ all -> 0x0043 }
            r1 = 1
            int r0 = r0 + r1
            r6.k = r0     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r6.i     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r6.i     // Catch:{ all -> 0x0043 }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r6.i     // Catch:{ all -> 0x0043 }
            r0.append(r7)     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r6.i     // Catch:{ all -> 0x0043 }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.util.LinkedHashMap r0 = r6.j     // Catch:{ all -> 0x0043 }
            r0.remove(r7)     // Catch:{ all -> 0x0043 }
            boolean r7 = r6.S()     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x008d
            java.util.concurrent.ThreadPoolExecutor r7 = r6.m     // Catch:{ all -> 0x0043 }
            java.util.concurrent.Callable r0 = r6.n     // Catch:{ all -> 0x0043 }
            r7.submit(r0)     // Catch:{ all -> 0x0043 }
        L_0x008d:
            monitor-exit(r6)
            return r1
        L_0x008f:
            monitor-exit(r6)
            return r1
        L_0x0091:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.i0(java.lang.String):boolean");
    }

    public final void o() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void q0() {
        while (this.h > this.f) {
            i0((String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void s(com.bumptech.glide.disklrucache.DiskLruCache.Editor r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = r10.f2434a     // Catch:{ all -> 0x0030 }
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r1 = r0.f     // Catch:{ all -> 0x0030 }
            if (r1 != r10) goto L_0x010b
            r1 = 0
            if (r11 == 0) goto L_0x0050
            boolean r2 = r0.e     // Catch:{ all -> 0x0030 }
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
            goto L_0x0111
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
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f = r10     // Catch:{ all -> 0x0030 }
            boolean r10 = r0.e     // Catch:{ all -> 0x0030 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00cc
            boolean unused = r0.e = r1     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            r10.append(r3)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r0.f2435a     // Catch:{ all -> 0x0030 }
            r10.append(r1)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r0.l()     // Catch:{ all -> 0x0030 }
            r10.append(r1)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            r10.append(r2)     // Catch:{ all -> 0x0030 }
            if (r11 == 0) goto L_0x00ef
            long r10 = r9.l     // Catch:{ all -> 0x0030 }
            r1 = 1
            long r1 = r1 + r10
            r9.l = r1     // Catch:{ all -> 0x0030 }
            long unused = r0.g = r10     // Catch:{ all -> 0x0030 }
            goto L_0x00ef
        L_0x00cc:
            java.util.LinkedHashMap r10 = r9.j     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r0.f2435a     // Catch:{ all -> 0x0030 }
            r10.remove(r11)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            r10.append(r3)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r0.f2435a     // Catch:{ all -> 0x0030 }
            r10.append(r11)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            r10.append(r2)     // Catch:{ all -> 0x0030 }
        L_0x00ef:
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0030 }
            J(r10)     // Catch:{ all -> 0x0030 }
            long r10 = r9.h     // Catch:{ all -> 0x0030 }
            long r0 = r9.f     // Catch:{ all -> 0x0030 }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0102
            boolean r10 = r9.S()     // Catch:{ all -> 0x0030 }
            if (r10 == 0) goto L_0x0109
        L_0x0102:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.m     // Catch:{ all -> 0x0030 }
            java.util.concurrent.Callable r11 = r9.n     // Catch:{ all -> 0x0030 }
            r10.submit(r11)     // Catch:{ all -> 0x0030 }
        L_0x0109:
            monitor-exit(r9)
            return
        L_0x010b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0030 }
            r10.<init>()     // Catch:{ all -> 0x0030 }
            throw r10     // Catch:{ all -> 0x0030 }
        L_0x0111:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.s(com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    public void u() {
        close();
        Util.b(this.f2432a);
    }

    public Editor w(String str) {
        return z(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.bumptech.glide.disklrucache.DiskLruCache.Editor z(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.o()     // Catch:{ all -> 0x001e }
            java.util.LinkedHashMap r0 = r5.j     // Catch:{ all -> 0x001e }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x001e }
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x001e }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r3 = r0.g     // Catch:{ all -> 0x001e }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0022
            goto L_0x0020
        L_0x001e:
            r6 = move-exception
            goto L_0x0060
        L_0x0020:
            monitor-exit(r5)
            return r2
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = new com.bumptech.glide.disklrucache.DiskLruCache$Entry     // Catch:{ all -> 0x001e }
            r0.<init>(r6)     // Catch:{ all -> 0x001e }
            java.util.LinkedHashMap r7 = r5.j     // Catch:{ all -> 0x001e }
            r7.put(r6, r0)     // Catch:{ all -> 0x001e }
            goto L_0x0037
        L_0x002f:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = r0.f     // Catch:{ all -> 0x001e }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r2
        L_0x0037:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = new com.bumptech.glide.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x001e }
            r7.<init>(r0)     // Catch:{ all -> 0x001e }
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f = r7     // Catch:{ all -> 0x001e }
            java.io.Writer r8 = r5.i     // Catch:{ all -> 0x001e }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x001e }
            java.io.Writer r8 = r5.i     // Catch:{ all -> 0x001e }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x001e }
            java.io.Writer r8 = r5.i     // Catch:{ all -> 0x001e }
            r8.append(r6)     // Catch:{ all -> 0x001e }
            java.io.Writer r6 = r5.i     // Catch:{ all -> 0x001e }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x001e }
            java.io.Writer r6 = r5.i     // Catch:{ all -> 0x001e }
            J(r6)     // Catch:{ all -> 0x001e }
            monitor-exit(r5)
            return r7
        L_0x0060:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.z(java.lang.String, long):com.bumptech.glide.disklrucache.DiskLruCache$Editor");
    }
}
