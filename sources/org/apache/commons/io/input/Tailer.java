package org.apache.commons.io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

public class Tailer implements Runnable {
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset charset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file2, TailerListener tailerListener) {
        this(file2, tailerListener, 1000);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        return create(file2, tailerListener, j, z, false, i);
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        try {
            long filePointer = randomAccessFile.getFilePointer();
            long j = filePointer;
            boolean z = false;
            while (getRun() && (read = randomAccessFile.read(this.inbuf)) != -1) {
                for (int i = 0; i < read; i++) {
                    byte b = this.inbuf[i];
                    if (b == 10) {
                        this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.charset));
                        byteArrayOutputStream.reset();
                        filePointer = ((long) i) + j + 1;
                        z = false;
                    } else if (b != 13) {
                        if (z) {
                            this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.charset));
                            byteArrayOutputStream.reset();
                            filePointer = ((long) i) + j + 1;
                            z = false;
                        }
                        byteArrayOutputStream.write(b);
                    } else {
                        if (z) {
                            byteArrayOutputStream.write(13);
                        }
                        z = true;
                    }
                }
                j = randomAccessFile.getFilePointer();
            }
            randomAccessFile.seek(filePointer);
            TailerListener tailerListener = this.listener;
            if (tailerListener instanceof TailerListenerAdapter) {
                ((TailerListenerAdapter) tailerListener).endOfFileReached();
            }
            byteArrayOutputStream.close();
            return filePointer;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public long getDelay() {
        return this.delayMillis;
    }

    public File getFile() {
        return this.file;
    }

    public boolean getRun() {
        return this.run;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r13.listener.fileNotFound();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0021 */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00ff A[SYNTHETIC, Splitter:B:88:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011c A[SYNTHETIC, Splitter:B:99:0x011c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:91:0x0105=Splitter:B:91:0x0105, B:85:0x00f8=Splitter:B:85:0x00f8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            r0 = 0
            r2 = 0
            r3 = r0
            r5 = r3
        L_0x0005:
            boolean r7 = r13.getRun()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.lang.String r8 = "r"
            if (r7 == 0) goto L_0x0045
            if (r2 != 0) goto L_0x0045
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0021 }
            java.io.File r9 = r13.file     // Catch:{ FileNotFoundException -> 0x0021 }
            r7.<init>(r9, r8)     // Catch:{ FileNotFoundException -> 0x0021 }
            r2 = r7
            goto L_0x0026
        L_0x0018:
            r0 = move-exception
            goto L_0x011a
        L_0x001b:
            r0 = move-exception
            goto L_0x00f8
        L_0x001e:
            r0 = move-exception
            goto L_0x0105
        L_0x0021:
            org.apache.commons.io.input.TailerListener r7 = r13.listener     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            r7.fileNotFound()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
        L_0x0026:
            if (r2 != 0) goto L_0x002e
            long r7 = r13.delayMillis     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.lang.Thread.sleep(r7)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            goto L_0x0005
        L_0x002e:
            boolean r3 = r13.end     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            if (r3 == 0) goto L_0x003a
            java.io.File r3 = r13.file     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            long r3 = r3.length()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            r5 = r3
            goto L_0x003b
        L_0x003a:
            r5 = r0
        L_0x003b:
            java.io.File r3 = r13.file     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            long r3 = org.apache.commons.io.FileUtils.lastModified(r3)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            r2.seek(r5)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            goto L_0x0005
        L_0x0045:
            boolean r7 = r13.getRun()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            if (r7 == 0) goto L_0x00e8
            java.io.File r7 = r13.file     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            boolean r7 = org.apache.commons.io.FileUtils.isFileNewer((java.io.File) r7, (long) r3)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.io.File r9 = r13.file     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            long r9 = r9.length()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a5
            org.apache.commons.io.input.TailerListener r7 = r13.listener     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            r7.fileRotated()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ all -> 0x008b }
            java.io.File r9 = r13.file     // Catch:{ all -> 0x008b }
            r7.<init>(r9, r8)     // Catch:{ all -> 0x008b }
            r13.readLines(r2)     // Catch:{ IOException -> 0x006d }
            goto L_0x0073
        L_0x006b:
            r9 = move-exception
            goto L_0x008d
        L_0x006d:
            r9 = move-exception
            org.apache.commons.io.input.TailerListener r10 = r13.listener     // Catch:{ all -> 0x006b }
            r10.handle((java.lang.Exception) r9)     // Catch:{ all -> 0x006b }
        L_0x0073:
            if (r2 == 0) goto L_0x0088
            r2.close()     // Catch:{ FileNotFoundException -> 0x0085 }
            goto L_0x0088
        L_0x0079:
            r0 = move-exception
            r2 = r7
            goto L_0x011a
        L_0x007d:
            r0 = move-exception
            r2 = r7
            goto L_0x00f8
        L_0x0081:
            r0 = move-exception
            r2 = r7
            goto L_0x0105
        L_0x0085:
            r5 = r0
        L_0x0086:
            r2 = r7
            goto L_0x009a
        L_0x0088:
            r5 = r0
        L_0x0089:
            r2 = r7
            goto L_0x0045
        L_0x008b:
            r9 = move-exception
            r7 = r2
        L_0x008d:
            throw r9     // Catch:{ all -> 0x008e }
        L_0x008e:
            r10 = move-exception
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ all -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r2 = move-exception
            r9.addSuppressed(r2)     // Catch:{ FileNotFoundException -> 0x0086 }
        L_0x0099:
            throw r10     // Catch:{ FileNotFoundException -> 0x0086 }
        L_0x009a:
            org.apache.commons.io.input.TailerListener r7 = r13.listener     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            r7.fileNotFound()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            long r9 = r13.delayMillis     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.lang.Thread.sleep(r9)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            goto L_0x0045
        L_0x00a5:
            if (r9 <= 0) goto L_0x00b5
            long r3 = r13.readLines(r2)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.io.File r5 = r13.file     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            long r5 = org.apache.commons.io.FileUtils.lastModified(r5)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
        L_0x00b1:
            r11 = r3
            r3 = r5
            r5 = r11
            goto L_0x00c5
        L_0x00b5:
            if (r7 == 0) goto L_0x00c5
            r2.seek(r0)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            long r3 = r13.readLines(r2)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.io.File r5 = r13.file     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            long r5 = org.apache.commons.io.FileUtils.lastModified(r5)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            goto L_0x00b1
        L_0x00c5:
            boolean r7 = r13.reOpen     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            if (r7 == 0) goto L_0x00ce
            if (r2 == 0) goto L_0x00ce
            r2.close()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
        L_0x00ce:
            long r9 = r13.delayMillis     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.lang.Thread.sleep(r9)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            boolean r7 = r13.getRun()     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            if (r7 == 0) goto L_0x0045
            boolean r7 = r13.reOpen     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            if (r7 == 0) goto L_0x0045
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            java.io.File r9 = r13.file     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            r7.<init>(r9, r8)     // Catch:{ InterruptedException -> 0x001e, Exception -> 0x001b }
            r7.seek(r5)     // Catch:{ InterruptedException -> 0x0081, Exception -> 0x007d, all -> 0x0079 }
            goto L_0x0089
        L_0x00e8:
            if (r2 == 0) goto L_0x00f4
            r2.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x00f4
        L_0x00ee:
            r0 = move-exception
        L_0x00ef:
            org.apache.commons.io.input.TailerListener r1 = r13.listener
            r1.handle((java.lang.Exception) r0)
        L_0x00f4:
            r13.stop()
            goto L_0x0119
        L_0x00f8:
            org.apache.commons.io.input.TailerListener r1 = r13.listener     // Catch:{ all -> 0x0018 }
            r1.handle((java.lang.Exception) r0)     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x00f4
            r2.close()     // Catch:{ IOException -> 0x0103 }
            goto L_0x00f4
        L_0x0103:
            r0 = move-exception
            goto L_0x00ef
        L_0x0105:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0018 }
            r1.interrupt()     // Catch:{ all -> 0x0018 }
            org.apache.commons.io.input.TailerListener r1 = r13.listener     // Catch:{ all -> 0x0018 }
            r1.handle((java.lang.Exception) r0)     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x00f4
            r2.close()     // Catch:{ IOException -> 0x0117 }
            goto L_0x00f4
        L_0x0117:
            r0 = move-exception
            goto L_0x00ef
        L_0x0119:
            return
        L_0x011a:
            if (r2 == 0) goto L_0x0126
            r2.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0126
        L_0x0120:
            r1 = move-exception
            org.apache.commons.io.input.TailerListener r2 = r13.listener
            r2.handle((java.lang.Exception) r1)
        L_0x0126:
            r13.stop()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.Tailer.run():void");
    }

    public void stop() {
        this.run = false;
    }

    public Tailer(File file2, TailerListener tailerListener, long j) {
        this(file2, tailerListener, j, false);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        return create(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z) {
        this(file2, tailerListener, j, z, 8192);
    }

    public static Tailer create(File file2, Charset charset2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        Tailer tailer = new Tailer(file2, charset2, tailerListener, j, z, z2, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        this(file2, tailerListener, j, z, z2, 8192);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        this(file2, tailerListener, j, z, false, i);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public Tailer(File file2, Charset charset2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this.run = true;
        this.file = file2;
        this.delayMillis = j;
        this.end = z;
        this.inbuf = IOUtils.byteArray(i);
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z2;
        this.charset = charset2;
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z) {
        return create(file2, tailerListener, j, z, 8192);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        return create(file2, tailerListener, j, z, z2, 8192);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j) {
        return create(file2, tailerListener, j, false);
    }

    public static Tailer create(File file2, TailerListener tailerListener) {
        return create(file2, tailerListener, 1000, false);
    }
}
