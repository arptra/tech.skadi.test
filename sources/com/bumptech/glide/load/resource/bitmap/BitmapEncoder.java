package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option b = Option.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Option c = Option.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a  reason: collision with root package name */
    public final ArrayPool f2614a;

    public BitmapEncoder(ArrayPool arrayPool) {
        this.f2614a = arrayPool;
    }

    public EncodeStrategy b(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|(2:43|44)|45|46) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c5 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[SYNTHETIC, Splitter:B:31:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0076 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2 A[SYNTHETIC, Splitter:B:43:0x00c2] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.bumptech.glide.load.engine.Resource r8, java.io.File r9, com.bumptech.glide.load.Options r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.d(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.d(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.LogTime.b()     // Catch:{ all -> 0x0056 }
            com.bumptech.glide.load.Option r4 = b     // Catch:{ all -> 0x0056 }
            java.lang.Object r4 = r10.c(r4)     // Catch:{ all -> 0x0056 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0056 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0056 }
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005c }
            r6.<init>(r9)     // Catch:{ IOException -> 0x005c }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r9 = r7.f2614a     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            if (r9 == 0) goto L_0x004b
            com.bumptech.glide.load.data.BufferedOutputStream r9 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r7 = r7.f2614a     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            r9.<init>(r6, r7)     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            r5 = r9
            goto L_0x004c
        L_0x0044:
            r7 = move-exception
            r5 = r6
            goto L_0x00c0
        L_0x0048:
            r7 = move-exception
            r5 = r6
            goto L_0x005d
        L_0x004b:
            r5 = r6
        L_0x004c:
            r8.compress(r1, r4, r5)     // Catch:{ IOException -> 0x005c }
            r5.close()     // Catch:{ IOException -> 0x005c }
            r5.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0058
        L_0x0056:
            r7 = move-exception
            goto L_0x00c6
        L_0x0058:
            r7 = 1
            goto L_0x006f
        L_0x005a:
            r7 = move-exception
            goto L_0x00c0
        L_0x005c:
            r7 = move-exception
        L_0x005d:
            r9 = 3
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch:{ all -> 0x005a }
            if (r9 == 0) goto L_0x0069
            java.lang.String r9 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r9, r7)     // Catch:{ all -> 0x005a }
        L_0x0069:
            if (r5 == 0) goto L_0x006e
            r5.close()     // Catch:{ IOException -> 0x006e }
        L_0x006e:
            r7 = 0
        L_0x006f:
            r9 = 2
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch:{ all -> 0x0056 }
            if (r9 == 0) goto L_0x00bc
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = "Compressed with type: "
            r9.append(r4)     // Catch:{ all -> 0x0056 }
            r9.append(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = " of size "
            r9.append(r1)     // Catch:{ all -> 0x0056 }
            int r1 = com.bumptech.glide.util.Util.i(r8)     // Catch:{ all -> 0x0056 }
            r9.append(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = " in "
            r9.append(r1)     // Catch:{ all -> 0x0056 }
            double r1 = com.bumptech.glide.util.LogTime.a(r2)     // Catch:{ all -> 0x0056 }
            r9.append(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = ", options format: "
            r9.append(r1)     // Catch:{ all -> 0x0056 }
            com.bumptech.glide.load.Option r1 = c     // Catch:{ all -> 0x0056 }
            java.lang.Object r10 = r10.c(r1)     // Catch:{ all -> 0x0056 }
            r9.append(r10)     // Catch:{ all -> 0x0056 }
            java.lang.String r10 = ", hasAlpha: "
            r9.append(r10)     // Catch:{ all -> 0x0056 }
            boolean r8 = r8.hasAlpha()     // Catch:{ all -> 0x0056 }
            r9.append(r8)     // Catch:{ all -> 0x0056 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0056 }
            android.util.Log.v(r0, r8)     // Catch:{ all -> 0x0056 }
        L_0x00bc:
            com.bumptech.glide.util.pool.GlideTrace.e()
            return r7
        L_0x00c0:
            if (r5 == 0) goto L_0x00c5
            r5.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00c5:
            throw r7     // Catch:{ all -> 0x0056 }
        L_0x00c6:
            com.bumptech.glide.util.pool.GlideTrace.e()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.a(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    public final Bitmap.CompressFormat d(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.c(c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }
}
