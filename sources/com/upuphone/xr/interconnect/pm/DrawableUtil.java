package com.upuphone.xr.interconnect.pm;

import android.graphics.drawable.Drawable;
import java.util.UUID;

public final class DrawableUtil {
    private static final String TAG = "DrawableUtil";

    private DrawableUtil() {
    }

    public static String saveDrawable2File(Drawable drawable, String str) {
        return saveDrawable2File(drawable, str, UUID.randomUUID().toString() + ".png");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0103 A[SYNTHETIC, Splitter:B:36:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0124 A[SYNTHETIC, Splitter:B:42:0x0124] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String saveDrawable2File(android.graphics.drawable.Drawable r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "File closing threw: "
            int r1 = r8.getIntrinsicWidth()
            int r2 = r8.getIntrinsicHeight()
            r3 = 0
            r8.setBounds(r3, r3, r1, r2)
            int r4 = r8.getOpacity()
            r5 = -1
            if (r4 == r5) goto L_0x0018
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x001a
        L_0x0018:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
        L_0x001a:
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r2, r4)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r1)
            r8.draw(r2)
            java.io.File r8 = new java.io.File
            r8.<init>(r9)
            boolean r2 = r8.exists()
            r4 = 0
            java.lang.String r5 = "!"
            java.lang.String r6 = "DrawableUtil"
            if (r2 != 0) goto L_0x0054
            boolean r8 = r8.mkdirs()
            if (r8 != 0) goto L_0x0054
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "Failed creating dir "
            r8.append(r10)
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            com.upuphone.xr.interconnect.util.log.ILog.w(r6, r8)
            return r4
        L_0x0054:
            java.io.File r8 = new java.io.File
            r8.<init>(r9, r10)
            boolean r2 = r8.exists()
            if (r2 != 0) goto L_0x00a1
            boolean r2 = r8.createNewFile()     // Catch:{ IOException -> 0x0085 }
            if (r2 != 0) goto L_0x00a1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0085 }
            r2.<init>()     // Catch:{ IOException -> 0x0085 }
            java.lang.String r7 = "Failed creating file "
            r2.append(r7)     // Catch:{ IOException -> 0x0085 }
            r2.append(r9)     // Catch:{ IOException -> 0x0085 }
            java.lang.String r9 = "/"
            r2.append(r9)     // Catch:{ IOException -> 0x0085 }
            r2.append(r10)     // Catch:{ IOException -> 0x0085 }
            r2.append(r5)     // Catch:{ IOException -> 0x0085 }
            java.lang.String r9 = r2.toString()     // Catch:{ IOException -> 0x0085 }
            com.upuphone.xr.interconnect.util.log.ILog.w(r6, r9)     // Catch:{ IOException -> 0x0085 }
            goto L_0x00a1
        L_0x0085:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "File creation threw: "
            r10.append(r2)
            java.lang.String r9 = r9.getLocalizedMessage()
            r10.append(r9)
            r10.append(r5)
            java.lang.String r9 = r10.toString()
            com.upuphone.xr.interconnect.util.log.ILog.w(r6, r9)
        L_0x00a1:
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00e4, all -> 0x00e2 }
            java.nio.file.Path r10 = r8.toPath()     // Catch:{ IOException -> 0x00e4, all -> 0x00e2 }
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r3]     // Catch:{ IOException -> 0x00e4, all -> 0x00e2 }
            java.io.OutputStream r10 = java.nio.file.Files.newOutputStream(r10, r2)     // Catch:{ IOException -> 0x00e4, all -> 0x00e2 }
            r9.<init>(r10)     // Catch:{ IOException -> 0x00e4, all -> 0x00e2 }
            android.graphics.Bitmap$CompressFormat r10 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x00e0 }
            r2 = 100
            r1.compress(r10, r2, r9)     // Catch:{ IOException -> 0x00e0 }
            r9.flush()     // Catch:{ IOException -> 0x00e0 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ IOException -> 0x00e0 }
            r9.close()     // Catch:{ IOException -> 0x00c2 }
            goto L_0x00dc
        L_0x00c2:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getLocalizedMessage()
            r10.append(r9)
            r10.append(r5)
            java.lang.String r9 = r10.toString()
            com.upuphone.xr.interconnect.util.log.ILog.w(r6, r9)
        L_0x00dc:
            return r8
        L_0x00dd:
            r8 = move-exception
            r4 = r9
            goto L_0x0122
        L_0x00e0:
            r8 = move-exception
            goto L_0x00e6
        L_0x00e2:
            r8 = move-exception
            goto L_0x0122
        L_0x00e4:
            r8 = move-exception
            r9 = r4
        L_0x00e6:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r10.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "File writing threw: "
            r10.append(r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ all -> 0x00dd }
            r10.append(r8)     // Catch:{ all -> 0x00dd }
            r10.append(r5)     // Catch:{ all -> 0x00dd }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x00dd }
            com.upuphone.xr.interconnect.util.log.ILog.w(r6, r8)     // Catch:{ all -> 0x00dd }
            if (r9 == 0) goto L_0x0121
            r9.close()     // Catch:{ IOException -> 0x0107 }
            goto L_0x0121
        L_0x0107:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.getLocalizedMessage()
            r9.append(r8)
            r9.append(r5)
            java.lang.String r8 = r9.toString()
            com.upuphone.xr.interconnect.util.log.ILog.w(r6, r8)
        L_0x0121:
            return r4
        L_0x0122:
            if (r4 == 0) goto L_0x0142
            r4.close()     // Catch:{ IOException -> 0x0128 }
            goto L_0x0142
        L_0x0128:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getLocalizedMessage()
            r10.append(r9)
            r10.append(r5)
            java.lang.String r9 = r10.toString()
            com.upuphone.xr.interconnect.util.log.ILog.w(r6, r9)
        L_0x0142:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.pm.DrawableUtil.saveDrawable2File(android.graphics.drawable.Drawable, java.lang.String, java.lang.String):java.lang.String");
    }
}
