package com.meizu.common.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.lang.reflect.Array;

public class FastBlurUtil {
    public static Bitmap fastBlur(Bitmap bitmap, float f) {
        int i;
        int[] iArr;
        if (bitmap == null || (i = (int) f) < 1) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i + i;
        int i6 = i5 + 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i5 + 2) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i6;
        int[][] iArr9 = (int[][]) Array.newInstance(Integer.TYPE, iArr8);
        int i11 = i + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            int i15 = -i;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i15 <= i) {
                int i25 = i4;
                int i26 = height;
                int i27 = iArr2[i13 + Math.min(i3, Math.max(i15, 0))];
                int[] iArr10 = iArr9[i15 + i];
                iArr10[0] = (i27 & 16711680) >> 16;
                iArr10[1] = (i27 & 65280) >> 8;
                iArr10[2] = i27 & 255;
                int abs = i11 - Math.abs(i15);
                int i28 = iArr10[0];
                i16 += i28 * abs;
                int i29 = iArr10[1];
                i17 += i29 * abs;
                int i30 = iArr10[2];
                i18 += abs * i30;
                if (i15 > 0) {
                    i22 += i28;
                    i23 += i29;
                    i24 += i30;
                } else {
                    i19 += i28;
                    i20 += i29;
                    i21 += i30;
                }
                i15++;
                height = i26;
                i4 = i25;
            }
            int i31 = i4;
            int i32 = height;
            int i33 = i;
            int i34 = 0;
            while (i34 < width) {
                iArr3[i13] = iArr7[i16];
                iArr4[i13] = iArr7[i17];
                iArr5[i13] = iArr7[i18];
                int i35 = i16 - i19;
                int i36 = i17 - i20;
                int i37 = i18 - i21;
                int[] iArr11 = iArr9[((i33 - i) + i6) % i6];
                int i38 = i19 - iArr11[0];
                int i39 = i20 - iArr11[1];
                int i40 = i21 - iArr11[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr6[i34] = Math.min(i34 + i + 1, i3);
                } else {
                    iArr = iArr7;
                }
                int i41 = iArr2[i14 + iArr6[i34]];
                int i42 = (i41 & 16711680) >> 16;
                iArr11[0] = i42;
                int i43 = (i41 & 65280) >> 8;
                iArr11[1] = i43;
                int i44 = i41 & 255;
                iArr11[2] = i44;
                int i45 = i22 + i42;
                int i46 = i23 + i43;
                int i47 = i24 + i44;
                i16 = i35 + i45;
                i17 = i36 + i46;
                i18 = i37 + i47;
                i33 = (i33 + 1) % i6;
                int[] iArr12 = iArr9[i33 % i6];
                int i48 = iArr12[0];
                i19 = i38 + i48;
                int i49 = iArr12[1];
                i20 = i39 + i49;
                int i50 = iArr12[2];
                i21 = i40 + i50;
                i22 = i45 - i48;
                i23 = i46 - i49;
                i24 = i47 - i50;
                i13++;
                i34++;
                iArr7 = iArr;
            }
            int[] iArr13 = iArr7;
            i14 += width;
            i12++;
            height = i32;
            i4 = i31;
        }
        int i51 = i4;
        int i52 = height;
        int[] iArr14 = iArr7;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i;
            int i55 = i54 * width;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            while (i54 <= i) {
                int[] iArr15 = iArr6;
                int max = Math.max(0, i55) + i53;
                int[] iArr16 = iArr9[i54 + i];
                iArr16[0] = iArr3[max];
                iArr16[1] = iArr4[max];
                iArr16[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i54);
                i56 += iArr3[max] * abs2;
                i57 += iArr4[max] * abs2;
                i58 += iArr5[max] * abs2;
                if (i54 > 0) {
                    i62 += iArr16[0];
                    i63 += iArr16[1];
                    i64 += iArr16[2];
                } else {
                    i59 += iArr16[0];
                    i60 += iArr16[1];
                    i61 += iArr16[2];
                }
                int i65 = i51;
                if (i54 < i65) {
                    i55 += width;
                }
                i54++;
                i51 = i65;
                iArr6 = iArr15;
            }
            int[] iArr17 = iArr6;
            int i66 = i51;
            int i67 = i53;
            int i68 = i;
            int i69 = i52;
            int i70 = 0;
            while (i70 < i69) {
                iArr2[i67] = (iArr2[i67] & -16777216) | (iArr14[i56] << 16) | (iArr14[i57] << 8) | iArr14[i58];
                int i71 = i56 - i59;
                int i72 = i57 - i60;
                int i73 = i58 - i61;
                int[] iArr18 = iArr9[((i68 - i) + i6) % i6];
                int i74 = i59 - iArr18[0];
                int i75 = i60 - iArr18[1];
                int i76 = i61 - iArr18[2];
                int i77 = i;
                if (i53 == 0) {
                    iArr17[i70] = Math.min(i70 + i11, i66) * width;
                }
                int i78 = iArr17[i70] + i53;
                int i79 = iArr3[i78];
                iArr18[0] = i79;
                int i80 = iArr4[i78];
                iArr18[1] = i80;
                int i81 = iArr5[i78];
                iArr18[2] = i81;
                int i82 = i62 + i79;
                int i83 = i63 + i80;
                int i84 = i64 + i81;
                i56 = i71 + i82;
                i57 = i72 + i83;
                i58 = i73 + i84;
                i68 = (i68 + 1) % i6;
                int[] iArr19 = iArr9[i68];
                int i85 = iArr19[0];
                i59 = i74 + i85;
                int i86 = iArr19[1];
                i60 = i75 + i86;
                int i87 = iArr19[2];
                i61 = i76 + i87;
                i62 = i82 - i85;
                i63 = i83 - i86;
                i64 = i84 - i87;
                i67 += width;
                i70++;
                i = i77;
            }
            int i88 = i;
            i53++;
            i51 = i66;
            i52 = i69;
            iArr6 = iArr17;
        }
        bitmap.setPixels(iArr2, 0, width, 0, 0, width, i52);
        return bitmap;
    }

    public static Bitmap getOverlayBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawColor(i);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }
}
