package org.apache.commons.io.output;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import org.apache.commons.io.FileUtils;

public class DeferredFileOutputStream extends ThresholdingOutputStream {
    private boolean closed;
    private OutputStream currentOutputStream;
    private final File directory;
    private ByteArrayOutputStream memoryOutputStream;
    private File outputFile;
    private final String prefix;
    private final String suffix;

    public DeferredFileOutputStream(int i, File file) {
        this(i, file, (String) null, (String) null, (File) null, 1024);
    }

    public void close() throws IOException {
        super.close();
        this.closed = true;
    }

    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.memoryOutputStream;
        if (byteArrayOutputStream != null) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public File getFile() {
        return this.outputFile;
    }

    public OutputStream getStream() throws IOException {
        return this.currentOutputStream;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    public void thresholdReached() throws IOException {
        String str = this.prefix;
        if (str != null) {
            this.outputFile = File.createTempFile(str, this.suffix, this.directory);
        }
        FileUtils.forceMkdirParent(this.outputFile);
        OutputStream newOutputStream = Files.newOutputStream(this.outputFile.toPath(), new OpenOption[0]);
        try {
            this.memoryOutputStream.writeTo(newOutputStream);
            this.currentOutputStream = newOutputStream;
            this.memoryOutputStream = null;
        } catch (IOException e) {
            newOutputStream.close();
            throw e;
        }
    }

    public InputStream toInputStream() throws IOException {
        if (this.closed) {
            return isInMemory() ? this.memoryOutputStream.toInputStream() : Files.newInputStream(this.outputFile.toPath(), new OpenOption[0]);
        }
        throw new IOException("Stream not closed");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r1 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(java.io.OutputStream r2) throws java.io.IOException {
        /*
            r1 = this;
            boolean r0 = r1.closed
            if (r0 == 0) goto L_0x0034
            boolean r0 = r1.isInMemory()
            if (r0 == 0) goto L_0x0010
            org.apache.commons.io.output.ByteArrayOutputStream r1 = r1.memoryOutputStream
            r1.writeTo(r2)
            goto L_0x0025
        L_0x0010:
            java.io.File r1 = r1.outputFile
            java.nio.file.Path r1 = r1.toPath()
            r0 = 0
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.io.InputStream r1 = java.nio.file.Files.newInputStream(r1, r0)
            org.apache.commons.io.IOUtils.copy((java.io.InputStream) r1, (java.io.OutputStream) r2)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0025
            r1.close()
        L_0x0025:
            return
        L_0x0026:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r0 = move-exception
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ all -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x0033:
            throw r0
        L_0x0034:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Stream not closed"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.output.DeferredFileOutputStream.writeTo(java.io.OutputStream):void");
    }

    private DeferredFileOutputStream(int i, File file, String str, String str2, File file2, int i2) {
        super(i);
        this.outputFile = file;
        this.prefix = str;
        this.suffix = str2;
        this.directory = file2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        this.memoryOutputStream = byteArrayOutputStream;
        this.currentOutputStream = byteArrayOutputStream;
    }

    public DeferredFileOutputStream(int i, int i2, File file) {
        this(i, file, (String) null, (String) null, (File) null, i2);
        if (i2 < 0) {
            throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
        }
    }

    public DeferredFileOutputStream(int i, int i2, String str, String str2, File file) {
        this(i, (File) null, str, str2, file, i2);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
        }
    }

    public DeferredFileOutputStream(int i, String str, String str2, File file) {
        this(i, (File) null, str, str2, file, 1024);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
    }
}
