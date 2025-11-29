package org.libpag;

import android.hardware.HardwareBuffer;

abstract class a {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair a(int r3, int r4, boolean r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0036
            if (r4 != 0) goto L_0x0006
            goto L_0x0036
        L_0x0006:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 >= r2) goto L_0x000e
            if (r5 != 0) goto L_0x002b
        L_0x000e:
            android.hardware.HardwareBuffer r5 = a(r3, r4)
            if (r5 == 0) goto L_0x0023
            android.graphics.ColorSpace$Named r1 = android.graphics.ColorSpace.Named.SRGB     // Catch:{ Exception -> 0x001f }
            android.graphics.ColorSpace r1 = android.graphics.ColorSpace.get(r1)     // Catch:{ Exception -> 0x001f }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.wrapHardwareBuffer(r5, r1)     // Catch:{ Exception -> 0x001f }
            goto L_0x0024
        L_0x001f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0023:
            r1 = r0
        L_0x0024:
            if (r1 == 0) goto L_0x002b
            android.util.Pair r3 = android.util.Pair.create(r1, r5)
            return r3
        L_0x002b:
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r4, r5)
            android.util.Pair r3 = android.util.Pair.create(r3, r0)
            return r3
        L_0x0036:
            android.util.Pair r3 = android.util.Pair.create(r0, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.a.a(int, int, boolean):android.util.Pair");
    }

    private static HardwareBuffer a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        try {
            return HardwareBuffer.create(i, i2, 1, 1, 819);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
