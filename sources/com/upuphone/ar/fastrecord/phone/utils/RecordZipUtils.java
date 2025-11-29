package com.upuphone.ar.fastrecord.phone.utils;

import java.io.File;
import java.io.IOException;

public final class RecordZipUtils {
    private static final int BUFFER_LEN = 8192;

    private RecordZipUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean zipFile(File file, File file2) throws IOException {
        return zipFile(file, file2, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zipFile(java.io.File r3, java.io.File r4, java.lang.String r5) throws java.io.IOException {
        /*
            if (r3 == 0) goto L_0x0024
            if (r4 != 0) goto L_0x0005
            goto L_0x0024
        L_0x0005:
            r0 = 0
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x001d }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x001d }
            r2.<init>(r4)     // Catch:{ all -> 0x001d }
            r1.<init>(r2)     // Catch:{ all -> 0x001d }
            java.lang.String r4 = ""
            boolean r3 = zipFile(r3, r4, r1, r5)     // Catch:{ all -> 0x001a }
            r1.close()
            return r3
        L_0x001a:
            r3 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001d:
            r3 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()
        L_0x0023:
            throw r3
        L_0x0024:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordZipUtils.zipFile(java.io.File, java.io.File, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zipFile(java.io.File r4, java.lang.String r5, java.util.zip.ZipOutputStream r6, java.lang.String r7) throws java.io.IOException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            boolean r5 = isSpace(r5)
            if (r5 == 0) goto L_0x0011
            java.lang.String r5 = ""
            goto L_0x0013
        L_0x0011:
            java.lang.String r5 = java.io.File.separator
        L_0x0013:
            r0.append(r5)
            java.lang.String r5 = r4.getName()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            boolean r0 = r4.isDirectory()
            r1 = 0
            if (r0 == 0) goto L_0x0062
            java.io.File[] r4 = r4.listFiles()
            if (r4 == 0) goto L_0x0042
            int r0 = r4.length
            if (r0 > 0) goto L_0x0032
            goto L_0x0042
        L_0x0032:
            int r0 = r4.length
            r2 = r1
        L_0x0034:
            if (r2 >= r0) goto L_0x0090
            r3 = r4[r2]
            boolean r3 = zipFile(r3, r5, r6, r7)
            if (r3 != 0) goto L_0x003f
            return r1
        L_0x003f:
            int r2 = r2 + 1
            goto L_0x0034
        L_0x0042:
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r5 = 47
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            r4.setComment(r7)
            r6.putNextEntry(r4)
            r6.closeEntry()
            goto L_0x0090
        L_0x0062:
            r0 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0092 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0092 }
            r3.<init>(r4)     // Catch:{ all -> 0x0092 }
            r2.<init>(r3)     // Catch:{ all -> 0x0092 }
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0087 }
            r4.<init>(r5)     // Catch:{ all -> 0x0087 }
            r4.setComment(r7)     // Catch:{ all -> 0x0087 }
            r6.putNextEntry(r4)     // Catch:{ all -> 0x0087 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r4]     // Catch:{ all -> 0x0087 }
        L_0x007c:
            int r7 = r2.read(r5, r1, r4)     // Catch:{ all -> 0x0087 }
            r0 = -1
            if (r7 == r0) goto L_0x008a
            r6.write(r5, r1, r7)     // Catch:{ all -> 0x0087 }
            goto L_0x007c
        L_0x0087:
            r4 = move-exception
            r0 = r2
            goto L_0x0093
        L_0x008a:
            r6.closeEntry()     // Catch:{ all -> 0x0087 }
            r2.close()
        L_0x0090:
            r4 = 1
            return r4
        L_0x0092:
            r4 = move-exception
        L_0x0093:
            if (r0 == 0) goto L_0x0098
            r0.close()
        L_0x0098:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordZipUtils.zipFile(java.io.File, java.lang.String, java.util.zip.ZipOutputStream, java.lang.String):boolean");
    }
}
