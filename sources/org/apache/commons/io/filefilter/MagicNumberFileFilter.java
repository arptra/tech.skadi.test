package org.apache.commons.io.filefilter;

import com.meizu.common.widget.MzContactsContract;
import java.io.Serializable;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -547733176983104172L;
    private final long byteOffset;
    private final byte[] magicNumbers;

    public MagicNumberFileFilter(byte[] bArr) {
        this(bArr, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean accept(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0043
            boolean r1 = r5.isFile()
            if (r1 == 0) goto L_0x0043
            boolean r1 = r5.canRead()
            if (r1 == 0) goto L_0x0043
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0043 }
            java.lang.String r2 = "r"
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x0043 }
            byte[] r5 = r4.magicNumbers     // Catch:{ all -> 0x0037 }
            int r5 = r5.length     // Catch:{ all -> 0x0037 }
            byte[] r5 = org.apache.commons.io.IOUtils.byteArray(r5)     // Catch:{ all -> 0x0037 }
            long r2 = r4.byteOffset     // Catch:{ all -> 0x0037 }
            r1.seek(r2)     // Catch:{ all -> 0x0037 }
            int r2 = r1.read(r5)     // Catch:{ all -> 0x0037 }
            byte[] r4 = r4.magicNumbers     // Catch:{ all -> 0x0037 }
            int r3 = r4.length     // Catch:{ all -> 0x0037 }
            if (r2 == r3) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x0043 }
            return r0
        L_0x002f:
            boolean r4 = java.util.Arrays.equals(r4, r5)     // Catch:{ all -> 0x0037 }
            r1.close()     // Catch:{ IOException -> 0x0043 }
            return r4
        L_0x0037:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r5 = move-exception
            r1.close()     // Catch:{ all -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch:{ IOException -> 0x0043 }
        L_0x0042:
            throw r5     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.filefilter.MagicNumberFileFilter.accept(java.io.File):boolean");
    }

    public String toString() {
        return super.toString() + "(" + new String(this.magicNumbers, Charset.defaultCharset()) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.byteOffset + ")";
    }

    public MagicNumberFileFilter(byte[] bArr, long j) {
        if (bArr == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            byte[] byteArray = IOUtils.byteArray(bArr.length);
            this.magicNumbers = byteArray;
            System.arraycopy(bArr, 0, byteArray, 0, bArr.length);
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }

    public MagicNumberFileFilter(String str) {
        this(str, 0);
    }

    public MagicNumberFileFilter(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            this.magicNumbers = str.getBytes(Charset.defaultCharset());
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r5 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004b, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.file.FileVisitResult accept(java.nio.file.Path r4, java.nio.file.attribute.BasicFileAttributes r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x004c
            r5 = 0
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r5]
            boolean r0 = java.nio.file.Files.isRegularFile(r4, r0)
            if (r0 == 0) goto L_0x004c
            boolean r0 = java.nio.file.Files.isReadable(r4)
            if (r0 == 0) goto L_0x004c
            java.nio.file.OpenOption[] r5 = new java.nio.file.OpenOption[r5]     // Catch:{ IOException -> 0x004c }
            java.nio.channels.FileChannel r5 = java.nio.channels.FileChannel.open(r4, r5)     // Catch:{ IOException -> 0x004c }
            byte[] r0 = r3.magicNumbers     // Catch:{ all -> 0x002d }
            int r0 = r0.length     // Catch:{ all -> 0x002d }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x002d }
            int r1 = r5.read(r0)     // Catch:{ all -> 0x002d }
            byte[] r3 = r3.magicNumbers     // Catch:{ all -> 0x002d }
            int r2 = r3.length     // Catch:{ all -> 0x002d }
            if (r1 == r2) goto L_0x002f
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.TERMINATE     // Catch:{ all -> 0x002d }
            r5.close()     // Catch:{ IOException -> 0x004c }
            return r3
        L_0x002d:
            r3 = move-exception
            goto L_0x003f
        L_0x002f:
            byte[] r0 = r0.array()     // Catch:{ all -> 0x002d }
            boolean r3 = java.util.Arrays.equals(r3, r0)     // Catch:{ all -> 0x002d }
            java.nio.file.FileVisitResult r3 = org.apache.commons.io.filefilter.AbstractFileFilter.toFileVisitResult(r3, r4)     // Catch:{ all -> 0x002d }
            r5.close()     // Catch:{ IOException -> 0x004c }
            return r3
        L_0x003f:
            throw r3     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r4 = move-exception
            if (r5 == 0) goto L_0x004b
            r5.close()     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r5 = move-exception
            r3.addSuppressed(r5)     // Catch:{ IOException -> 0x004c }
        L_0x004b:
            throw r4     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.TERMINATE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.filefilter.MagicNumberFileFilter.accept(java.nio.file.Path, java.nio.file.attribute.BasicFileAttributes):java.nio.file.FileVisitResult");
    }
}
