package top.zibin.luban;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;

public enum Checker {
    SINGLE;
    
    private static final String JPG = ".jpg";
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE;

    public static boolean isContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    private int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        byte b = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return b;
            }
            b = (bArr[i] & 255) | (b << 8);
            i += i3;
            i2 = i4;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return new byte[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] toByteArray(java.io.InputStream r6) {
        /*
            r5 = this;
            r5 = 0
            if (r6 != 0) goto L_0x0006
            byte[] r5 = new byte[r5]
            return r5
        L_0x0006:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r1]
        L_0x000f:
            int r3 = r6.read(r2, r5, r1)     // Catch:{ Exception -> 0x0024 }
            r4 = -1
            if (r3 == r4) goto L_0x001c
            r0.write(r2, r5, r3)     // Catch:{ Exception -> 0x0024 }
            goto L_0x000f
        L_0x001a:
            r5 = move-exception
            goto L_0x002a
        L_0x001c:
            r0.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            byte[] r5 = r0.toByteArray()
            return r5
        L_0x0024:
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x001a }
            r0.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            return r5
        L_0x002a:
            r0.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: top.zibin.luban.Checker.toByteArray(java.io.InputStream):byte[]");
    }

    public String extSuffix(InputStreamProvider inputStreamProvider) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamProvider.open(), (Rect) null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return JPG;
        }
    }

    public int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    public boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    public boolean needCompress(int i, String str) {
        if (i <= 0) {
            return true;
        }
        File file = new File(str);
        return file.exists() && file.length() > (((long) i) << 10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        r9 = 0;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r9 <= 8) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
        r2 = pack(r12, r1, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
        if (r2 == 1229531648) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0074, code lost:
        if (r2 == 1296891946) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        android.util.Log.e(TAG, "Invalid byte order");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007b, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007c, code lost:
        if (r2 != 1229531648) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007e, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0080, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0081, code lost:
        r3 = pack(r12, r1 + 4, 4, r2) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
        if (r3 < 10) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
        if (r3 <= r9) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008f, code lost:
        r1 = r1 + r3;
        r9 = r9 - r3;
        r3 = pack(r12, r1 - 2, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0097, code lost:
        r6 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0099, code lost:
        if (r3 <= 0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009d, code lost:
        if (r9 < 12) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a5, code lost:
        if (pack(r12, r1, 2, r2) != 274) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a7, code lost:
        r11 = pack(r12, r1 + 8, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ac, code lost:
        if (r11 == 1) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00af, code lost:
        if (r11 == 3) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b2, code lost:
        if (r11 == 6) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b4, code lost:
        if (r11 == 8) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b6, code lost:
        android.util.Log.e(TAG, "Unsupported orientation");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00bb, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00bc, code lost:
        return com.ucar.databus.proto.UCarProto.Orientation.ORIENTATION_270_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00bf, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c2, code lost:
        return 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c5, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c6, code lost:
        r1 = r1 + 12;
        r9 = r9 - 12;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00cc, code lost:
        android.util.Log.e(TAG, "Invalid offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d1, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d2, code lost:
        android.util.Log.e(TAG, "Orientation not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d7, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getOrientation(byte[] r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = r0
        L_0x0005:
            int r2 = r1 + 3
            int r3 = r12.length
            r4 = 1
            java.lang.String r5 = "Luban"
            r6 = 4
            r7 = 8
            r8 = 2
            if (r2 >= r3) goto L_0x0065
            int r2 = r1 + 1
            byte r3 = r12[r1]
            r9 = 255(0xff, float:3.57E-43)
            r3 = r3 & r9
            if (r3 != r9) goto L_0x0062
            byte r3 = r12[r2]
            r3 = r3 & r9
            if (r3 != r9) goto L_0x0021
        L_0x001f:
            r1 = r2
            goto L_0x0005
        L_0x0021:
            int r2 = r1 + 2
            r9 = 216(0xd8, float:3.03E-43)
            if (r3 == r9) goto L_0x001f
            if (r3 != r4) goto L_0x002a
            goto L_0x001f
        L_0x002a:
            r9 = 217(0xd9, float:3.04E-43)
            if (r3 == r9) goto L_0x0062
            r9 = 218(0xda, float:3.05E-43)
            if (r3 != r9) goto L_0x0033
            goto L_0x0062
        L_0x0033:
            int r9 = r11.pack(r12, r2, r8, r0)
            if (r9 < r8) goto L_0x005c
            int r2 = r2 + r9
            int r10 = r12.length
            if (r2 <= r10) goto L_0x003e
            goto L_0x005c
        L_0x003e:
            r10 = 225(0xe1, float:3.15E-43)
            if (r3 != r10) goto L_0x001f
            if (r9 < r7) goto L_0x001f
            int r3 = r1 + 4
            int r3 = r11.pack(r12, r3, r6, r0)
            r10 = 1165519206(0x45786966, float:3974.5874)
            if (r3 != r10) goto L_0x001f
            int r3 = r1 + 8
            int r3 = r11.pack(r12, r3, r8, r0)
            if (r3 != 0) goto L_0x001f
            int r1 = r1 + 10
            int r9 = r9 + -8
            goto L_0x0066
        L_0x005c:
            java.lang.String r11 = "Invalid length"
            android.util.Log.e(r5, r11)
            return r0
        L_0x0062:
            r9 = r0
            r1 = r2
            goto L_0x0066
        L_0x0065:
            r9 = r0
        L_0x0066:
            if (r9 <= r7) goto L_0x00d2
            int r2 = r11.pack(r12, r1, r6, r0)
            r3 = 1229531648(0x49492a00, float:823968.0)
            if (r2 == r3) goto L_0x007c
            r10 = 1296891946(0x4d4d002a, float:2.14958752E8)
            if (r2 == r10) goto L_0x007c
            java.lang.String r11 = "Invalid byte order"
            android.util.Log.e(r5, r11)
            return r0
        L_0x007c:
            if (r2 != r3) goto L_0x0080
            r2 = r4
            goto L_0x0081
        L_0x0080:
            r2 = r0
        L_0x0081:
            int r3 = r1 + 4
            int r3 = r11.pack(r12, r3, r6, r2)
            int r3 = r3 + r8
            r6 = 10
            if (r3 < r6) goto L_0x00cc
            if (r3 <= r9) goto L_0x008f
            goto L_0x00cc
        L_0x008f:
            int r1 = r1 + r3
            int r9 = r9 - r3
            int r3 = r1 + -2
            int r3 = r11.pack(r12, r3, r8, r2)
        L_0x0097:
            int r6 = r3 + -1
            if (r3 <= 0) goto L_0x00d2
            r3 = 12
            if (r9 < r3) goto L_0x00d2
            int r3 = r11.pack(r12, r1, r8, r2)
            r10 = 274(0x112, float:3.84E-43)
            if (r3 != r10) goto L_0x00c6
            int r1 = r1 + r7
            int r11 = r11.pack(r12, r1, r8, r2)
            if (r11 == r4) goto L_0x00c5
            r12 = 3
            if (r11 == r12) goto L_0x00c2
            r12 = 6
            if (r11 == r12) goto L_0x00bf
            if (r11 == r7) goto L_0x00bc
            java.lang.String r11 = "Unsupported orientation"
            android.util.Log.e(r5, r11)
            return r0
        L_0x00bc:
            r11 = 270(0x10e, float:3.78E-43)
            return r11
        L_0x00bf:
            r11 = 90
            return r11
        L_0x00c2:
            r11 = 180(0xb4, float:2.52E-43)
            return r11
        L_0x00c5:
            return r0
        L_0x00c6:
            int r1 = r1 + 12
            int r9 = r9 + -12
            r3 = r6
            goto L_0x0097
        L_0x00cc:
            java.lang.String r11 = "Invalid offset"
            android.util.Log.e(r5, r11)
            return r0
        L_0x00d2:
            java.lang.String r11 = "Orientation not found"
            android.util.Log.e(r5, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: top.zibin.luban.Checker.getOrientation(byte[]):int");
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }
}
