package com.upuphone.star.core.log.file;

import android.util.Log;
import com.upuphone.star.core.log.Printer;
import com.upuphone.star.core.log.file.backup.BackupStrategy;
import com.upuphone.star.core.log.file.backup.BackupUtil;
import com.upuphone.star.core.log.file.backup.FileSizeBackupStrategy;
import com.upuphone.star.core.log.file.clean.CleanStrategy;
import com.upuphone.star.core.log.file.clean.NeverCleanStrategy;
import com.upuphone.star.core.log.file.flattener.ClassicFlattener;
import com.upuphone.star.core.log.file.flattener.Flattener;
import com.upuphone.star.core.log.file.naming.DateFileNameGenerator;
import com.upuphone.star.core.log.file.naming.FileNameGenerator;
import com.upuphone.star.core.log.file.writer.SimpleWriter;
import com.upuphone.star.core.log.file.writer.Writer;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FilePrinter extends Printer {
    public final String c;
    public final FileNameGenerator d;
    public final BackupStrategy e;
    public final CleanStrategy f;
    public Flattener g;
    public Writer h;
    public volatile Worker i = new Worker();

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f6447a;
        public FileNameGenerator b;
        public BackupStrategy c;
        public CleanStrategy d;
        public Flattener e;
        public Writer f;

        public Builder(String str) {
            this.f6447a = str;
        }

        public FilePrinter a() {
            c();
            return new FilePrinter(this);
        }

        public Builder b(CleanStrategy cleanStrategy) {
            this.d = cleanStrategy;
            return this;
        }

        public final void c() {
            if (this.b == null) {
                this.b = new DateFileNameGenerator();
            }
            if (this.c == null) {
                this.c = new FileSizeBackupStrategy(6291456, 4);
            }
            if (this.d == null) {
                this.d = new NeverCleanStrategy();
            }
            if (this.e == null) {
                this.e = new ClassicFlattener();
            }
            if (this.f == null) {
                this.f = new SimpleWriter();
            }
        }
    }

    public class Worker implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public BlockingQueue f6448a;
        public volatile boolean b;
        public volatile boolean c;

        public Worker() {
            this.f6448a = new LinkedBlockingQueue();
        }

        public void a() {
            this.c = true;
        }

        public void b(LogItem logItem) {
            try {
                this.f6448a.put(logItem);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public boolean c() {
            boolean z;
            synchronized (this) {
                z = this.b;
            }
            return z;
        }

        public void d() {
            synchronized (this) {
                try {
                    if (!this.b) {
                        new Thread(this).start();
                        this.b = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                r0 = 0
                boolean r1 = r3.c     // Catch:{ InterruptedException -> 0x0017 }
                if (r1 != 0) goto L_0x0019
                java.util.concurrent.BlockingQueue r1 = r3.f6448a     // Catch:{ InterruptedException -> 0x0017 }
                java.lang.Object r1 = r1.take()     // Catch:{ InterruptedException -> 0x0017 }
                com.upuphone.star.core.log.file.LogItem r1 = (com.upuphone.star.core.log.file.LogItem) r1     // Catch:{ InterruptedException -> 0x0017 }
                if (r1 == 0) goto L_0x0019
                com.upuphone.star.core.log.file.FilePrinter r2 = com.upuphone.star.core.log.file.FilePrinter.this     // Catch:{ InterruptedException -> 0x0017 }
                r2.u(r1)     // Catch:{ InterruptedException -> 0x0017 }
                goto L_0x0000
            L_0x0015:
                r1 = move-exception
                goto L_0x002c
            L_0x0017:
                r1 = move-exception
                goto L_0x0021
            L_0x0019:
                monitor-enter(r3)
                r3.b = r0     // Catch:{ all -> 0x001e }
                monitor-exit(r3)     // Catch:{ all -> 0x001e }
                goto L_0x0028
            L_0x001e:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x001e }
                throw r0
            L_0x0021:
                r1.printStackTrace()     // Catch:{ all -> 0x0015 }
                monitor-enter(r3)
                r3.b = r0     // Catch:{ all -> 0x0029 }
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            L_0x0028:
                return
            L_0x0029:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                throw r0
            L_0x002c:
                monitor-enter(r3)
                r3.b = r0     // Catch:{ all -> 0x0031 }
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                throw r1
            L_0x0031:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.star.core.log.file.FilePrinter.Worker.run():void");
        }
    }

    public FilePrinter(Builder builder) {
        this.c = builder.f6447a;
        this.d = builder.b;
        this.e = builder.c;
        this.f = builder.d;
        this.g = builder.e;
        this.h = builder.f;
        s();
    }

    public void j(int i2, String str, String str2) {
        LogItem logItem = new LogItem(System.currentTimeMillis(), i2, str, str2);
        if (!this.i.c()) {
            this.i.d();
        }
        this.i.b(logItem);
    }

    public void r() {
        if (this.i != null && this.i.c()) {
            this.i.a();
        }
        Writer writer = this.h;
        if (writer != null && writer.e()) {
            this.h.b();
        }
    }

    public final void s() {
        File file = new File(this.c);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void t() {
        File[] listFiles = new File(this.c).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.f.a(file)) {
                    file.delete();
                }
            }
        }
    }

    public final void u(LogItem logItem) {
        String d2 = this.h.d();
        boolean z = !this.h.e();
        if (d2 == null || z || this.d.a()) {
            String b = this.d.b(logItem.b, System.currentTimeMillis());
            if (b == null || b.trim().length() == 0) {
                Log.e("ulog", "File name should not be empty, ignore log: " + logItem.d);
                return;
            } else if (!b.equals(d2) || z) {
                this.h.b();
                t();
                if (this.h.f(new File(this.c, b))) {
                    d2 = b;
                } else {
                    return;
                }
            }
        }
        File c2 = this.h.c();
        if (this.e.c(c2)) {
            this.h.b();
            BackupUtil.a(c2, this.e);
            if (!this.h.f(new File(this.c, d2))) {
                return;
            }
        }
        this.h.a(this.g.a(logItem).toString());
    }
}
