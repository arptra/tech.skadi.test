package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import org.apache.commons.io.IOUtils;

public class EmptyFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter EMPTY;
    public static final IOFileFilter NOT_EMPTY;
    private static final long serialVersionUID = 3631422087512832211L;

    static {
        EmptyFileFilter emptyFileFilter = new EmptyFileFilter();
        EMPTY = emptyFileFilter;
        NOT_EMPTY = emptyFileFilter.negate();
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            if (IOUtils.length((Object[]) file.listFiles()) == 0) {
                return true;
            }
            return false;
        } else if (file.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r8 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.file.FileVisitResult accept(java.nio.file.Path r7, java.nio.file.attribute.BasicFileAttributes r8) {
        /*
            r6 = this;
            r8 = 0
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r8]     // Catch:{ IOException -> 0x001f }
            boolean r0 = java.nio.file.Files.isDirectory(r7, r0)     // Catch:{ IOException -> 0x001f }
            r1 = 1
            if (r0 == 0) goto L_0x002f
            java.util.stream.Stream r8 = java.nio.file.Files.list(r7)     // Catch:{ IOException -> 0x001f }
            java.util.Optional r0 = r8.findFirst()     // Catch:{ all -> 0x0021 }
            boolean r0 = r0.isPresent()     // Catch:{ all -> 0x0021 }
            r0 = r0 ^ r1
            java.nio.file.FileVisitResult r7 = org.apache.commons.io.filefilter.AbstractFileFilter.toFileVisitResult(r0, r7)     // Catch:{ all -> 0x0021 }
            r8.close()     // Catch:{ IOException -> 0x001f }
            return r7
        L_0x001f:
            r7 = move-exception
            goto L_0x003f
        L_0x0021:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            if (r8 == 0) goto L_0x002e
            r8.close()     // Catch:{ all -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r8 = move-exception
            r7.addSuppressed(r8)     // Catch:{ IOException -> 0x001f }
        L_0x002e:
            throw r0     // Catch:{ IOException -> 0x001f }
        L_0x002f:
            long r2 = java.nio.file.Files.size(r7)     // Catch:{ IOException -> 0x001f }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x003a
            r8 = r1
        L_0x003a:
            java.nio.file.FileVisitResult r6 = org.apache.commons.io.filefilter.AbstractFileFilter.toFileVisitResult(r8, r7)     // Catch:{ IOException -> 0x001f }
            return r6
        L_0x003f:
            java.nio.file.FileVisitResult r6 = r6.handle(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.filefilter.EmptyFileFilter.accept(java.nio.file.Path, java.nio.file.attribute.BasicFileAttributes):java.nio.file.FileVisitResult");
    }
}
