package com.meizu.common.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.common.drawble.ContactHeaderDrawable;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactHeaderUtils {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BG_COLOR = -11227562;
    private static final int DEFAULT_BORDER_COLOR = -1;
    private static final int[] colorArray = {-148165, -435152, -1169103, -10464278, -14315542, -14565170, -12402834};
    private static final String mEnglishFirstLetters = "\\b[a-zA-Z]";
    private static final String mRegExChinese = "[一-龥]";
    private static final String mRegExChineseText = "([一-龥]+)";
    private static final String mRegExEnglish = "[a-zA-Z]";
    private static final String mRegExNumber = "\\d";
    private static final String mSpace = " ";
    private static Method sMethodSetNightModeUseOf;

    private static String checkText(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return "";
        }
        String substring = trim.substring(0, 1);
        char charAt = substring.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            substring = substring.toUpperCase();
        }
        return substring;
    }

    public static Drawable createContactHeader(Resources resources, int i, int i2, Object obj, Object obj2, int i3) {
        return createContactHeader(resources, i, i2, new Object[]{obj}, new Object[]{obj2}, i3);
    }

    @Deprecated
    public static Bitmap createContactHeaderDrawable(Resources resources, int i, int i2, Object obj, Object obj2, int i3) {
        return createContactHeaderDrawable(resources, i, i2, new Object[]{obj}, new Object[]{obj2}, i3);
    }

    private static Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            return drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, BITMAP_CONFIG) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
        } catch (OutOfMemoryError unused) {
            Log.e("ContactHeaderUtils ", "getBitmapFromDrawable  OutOfMemoryError !");
            return null;
        }
    }

    public static int getChineseCount(String str) {
        int i = 0;
        while (Pattern.compile(mRegExChinese).matcher(str).find()) {
            i++;
        }
        return i;
    }

    public static String getChineseStr(String str) {
        Matcher matcher = Pattern.compile(mRegExChineseText).matcher(str);
        String str2 = "";
        while (matcher.find()) {
            str2 = str2 + matcher.group();
        }
        return str2;
    }

    public static int getColorByText(String str) {
        int abs = !TextUtils.isEmpty(str) ? Math.abs(str.hashCode()) % colorArray.length : 5;
        int[] iArr = colorArray;
        return abs < iArr.length ? iArr[abs] : DEFAULT_BG_COLOR;
    }

    public static int getEnglishCount(String str) {
        int i = 0;
        while (Pattern.compile(mRegExEnglish).matcher(str).find()) {
            i++;
        }
        return i;
    }

    public static String getEnglishFirstLetters(String str) {
        Matcher matcher = Pattern.compile(mEnglishFirstLetters).matcher(Pattern.compile(mRegExNumber).matcher(str).replaceAll(" "));
        String str2 = "";
        while (matcher.find()) {
            str2 = str2 + matcher.group();
        }
        return str2.toUpperCase();
    }

    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 19968 && c <= 40869) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnglish(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                return true;
            }
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public static Drawable createContactHeader(Resources resources, int i, int i2, Object[] objArr, Object[] objArr2, int i3) {
        return new ContactHeaderDrawable(resources, i, i2, objArr, objArr2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022b A[SYNTHETIC, Splitter:B:77:0x022b] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x029d  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createContactHeaderDrawable(android.content.res.Resources r30, int r31, int r32, java.lang.Object[] r33, java.lang.Object[] r34, int r35) {
        /*
            r0 = r30
            r1 = r33
            r2 = 1
            if (r1 == 0) goto L_0x0009
            int r3 = r1.length
            goto L_0x000a
        L_0x0009:
            r3 = r2
        L_0x000a:
            r4 = 3
            if (r3 <= r4) goto L_0x000e
            r3 = r4
        L_0x000e:
            android.util.DisplayMetrics r5 = r30.getDisplayMetrics()
            float r5 = r5.density
            r6 = r31
            float r6 = (float) r6
            float r6 = r6 * r5
            int r6 = (int) r6
            r7 = r32
            float r7 = (float) r7
            float r7 = r7 * r5
            int r7 = (int) r7
            int r5 = (int) r5
            int r5 = r5 + r2
            if (r3 != r2) goto L_0x0023
            r5 = 0
        L_0x0023:
            android.graphics.RectF r9 = new android.graphics.RectF
            r9.<init>()
            android.graphics.RectF r10 = new android.graphics.RectF
            r10.<init>()
            android.graphics.Paint r11 = new android.graphics.Paint
            r11.<init>()
            android.graphics.Paint r12 = new android.graphics.Paint
            r12.<init>()
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>()
            android.graphics.Paint r14 = new android.graphics.Paint
            r14.<init>()
            android.graphics.Paint r15 = new android.graphics.Paint
            r15.<init>()
            r8 = -1
            r4 = r35
            if (r4 == r8) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r4 = r8
        L_0x004d:
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r6, r7, r8)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r8)
            r35 = r8
            java.lang.reflect.Method r18 = sMethodSetNightModeUseOf     // Catch:{ Exception -> 0x007c }
            if (r18 != 0) goto L_0x006e
            java.lang.Class<android.graphics.Canvas> r8 = android.graphics.Canvas.class
            java.lang.String r0 = "setNightModeUseOf"
            java.lang.Class r19 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x007c }
            java.lang.Class[] r1 = new java.lang.Class[]{r19}     // Catch:{ Exception -> 0x007c }
            java.lang.reflect.Method r0 = r8.getDeclaredMethod(r0, r1)     // Catch:{ Exception -> 0x007c }
            sMethodSetNightModeUseOf = r0     // Catch:{ Exception -> 0x007c }
        L_0x006e:
            java.lang.reflect.Method r0 = sMethodSetNightModeUseOf     // Catch:{ Exception -> 0x007c }
            r1 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x007c }
            java.lang.Object[] r1 = new java.lang.Object[]{r8}     // Catch:{ Exception -> 0x007c }
            r0.invoke(r2, r1)     // Catch:{ Exception -> 0x007c }
        L_0x007c:
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL_AND_STROKE
            r14.setStyle(r0)
            r0 = 1
            r14.setAntiAlias(r0)
            r1 = -11227562(0xffffffffff54ae56, float:-2.8270154E38)
            r14.setColor(r1)
            r15.setAntiAlias(r0)
            android.graphics.Paint$Align r8 = android.graphics.Paint.Align.CENTER
            r15.setTextAlign(r8)
            r8 = -1
            r15.setColor(r8)
            android.graphics.Paint$Style r8 = android.graphics.Paint.Style.STROKE
            r12.setStyle(r8)
            r12.setAntiAlias(r0)
            r12.setColor(r4)
            float r4 = (float) r5
            r12.setStrokeWidth(r4)
            r13.setStyle(r8)
            r13.setAntiAlias(r0)
            r8 = 419430400(0x19000000, float:6.617445E-24)
            r13.setColor(r8)
            r8 = 1065353216(0x3f800000, float:1.0)
            r13.setStrokeWidth(r8)
            r11.setAntiAlias(r0)
            r11.setFilterBitmap(r0)
            r0 = 0
            r1 = 3
            if (r3 != r1) goto L_0x00cd
            int r1 = r6 * 33
            int r1 = r1 / 46
            float r1 = (float) r1
            int r19 = r7 * 33
            int r8 = r19 / 46
            float r8 = (float) r8
            r10.set(r0, r0, r1, r8)
        L_0x00cd:
            r1 = 2
            if (r3 != r1) goto L_0x00de
            int r1 = r6 * 38
            int r1 = r1 / 46
            float r1 = (float) r1
            int r8 = r7 * 38
            int r8 = r8 / 46
            float r8 = (float) r8
            r10.set(r0, r0, r1, r8)
            goto L_0x00ee
        L_0x00de:
            int r1 = r3 + 1
            int r8 = r6 * r1
            int r19 = r3 * 2
            int r8 = r8 / r19
            float r8 = (float) r8
            int r1 = r1 * r7
            int r1 = r1 / r19
            float r1 = (float) r1
            r10.set(r0, r0, r8, r1)
        L_0x00ee:
            float r1 = r10.height()
            float r1 = r1 - r4
            r8 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r8
            r19 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r19
            float r20 = r10.width()
            float r20 = r20 - r4
            float r20 = r20 - r8
            float r8 = r20 / r19
            float r1 = java.lang.Math.min(r1, r8)
            r9.set(r10)
            r9.inset(r4, r4)
            float r4 = r9.height()
            float r4 = r4 / r19
            float r8 = r9.width()
            float r8 = r8 / r19
            float r4 = java.lang.Math.min(r4, r8)
            r8 = 3
            if (r3 != r8) goto L_0x0129
            int r8 = r6 * 13
            int r8 = r8 / 92
            int r8 = r8 + r5
            float r8 = (float) r8
        L_0x0127:
            r10 = 2
            goto L_0x012b
        L_0x0129:
            r8 = r0
            goto L_0x0127
        L_0x012b:
            if (r3 != r10) goto L_0x0135
            int r8 = r6 * 8
            int r8 = r8 / 92
            int r10 = r5 / 2
            int r8 = r8 + r10
            float r8 = (float) r8
        L_0x0135:
            r10 = 1
            if (r3 != r10) goto L_0x0139
            goto L_0x013a
        L_0x0139:
            r0 = r8
        L_0x013a:
            int r3 = r3 - r10
            java.lang.String r10 = ""
            r8 = r3
            r16 = r10
            r10 = -11227562(0xffffffffff54ae56, float:-2.8270154E38)
            r20 = 0
            r21 = 0
            r22 = 0
        L_0x0149:
            if (r8 < 0) goto L_0x04ac
            if (r33 == 0) goto L_0x017e
            r23 = r10
            r10 = r33[r8]
            r24 = r3
            if (r10 == 0) goto L_0x0182
            boolean r3 = r10 instanceof java.lang.String
            if (r3 == 0) goto L_0x015a
            goto L_0x0182
        L_0x015a:
            boolean r3 = r10 instanceof android.graphics.Bitmap
            if (r3 == 0) goto L_0x0173
            r20 = r10
            android.graphics.Bitmap r20 = (android.graphics.Bitmap) r20
        L_0x0162:
            r3 = r30
            r17 = r1
            r26 = r12
            r25 = r13
            r12 = r16
            r13 = r20
            r10 = r23
        L_0x0170:
            r1 = 0
            goto L_0x023c
        L_0x0173:
            boolean r3 = r10 instanceof android.graphics.drawable.Drawable
            if (r3 == 0) goto L_0x0162
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10
            android.graphics.Bitmap r20 = getBitmapFromDrawable(r10)
            goto L_0x0162
        L_0x017e:
            r24 = r3
            r23 = r10
        L_0x0182:
            if (r33 == 0) goto L_0x020d
            r3 = r33[r8]
            if (r3 == 0) goto L_0x020d
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = getChineseStr(r3)
            boolean r10 = isChinese(r3)
            if (r10 == 0) goto L_0x01b6
            int r10 = getChineseCount(r3)
            r25 = r13
            r13 = 2
            if (r10 > r13) goto L_0x01a5
        L_0x019d:
            r17 = r1
            r16 = r3
        L_0x01a1:
            r26 = r12
            r13 = 1
            goto L_0x0204
        L_0x01a5:
            int r10 = r3.length()
            r13 = 1
            int r10 = r10 - r13
            int r13 = r3.length()
            java.lang.String r16 = r3.substring(r10, r13)
            r17 = r1
            goto L_0x01a1
        L_0x01b6:
            r25 = r13
            r3 = r33[r8]
            java.lang.String r3 = (java.lang.String) r3
            r10 = 1
            r13 = 0
            java.lang.String r3 = r3.substring(r13, r10)
            boolean r3 = isEnglish(r3)
            if (r3 == 0) goto L_0x01ff
            r3 = r33[r8]
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = getEnglishFirstLetters(r3)
            int r10 = getEnglishCount(r3)
            r13 = 2
            if (r10 > r13) goto L_0x01d8
            goto L_0x019d
        L_0x01d8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r17 = r1
            r26 = r12
            r1 = 0
            r13 = 1
            java.lang.String r12 = r3.substring(r1, r13)
            r10.append(r12)
            int r1 = r3.length()
            int r1 = r1 - r13
            int r12 = r3.length()
            java.lang.String r1 = r3.substring(r1, r12)
            r10.append(r1)
            java.lang.String r16 = r10.toString()
            goto L_0x0204
        L_0x01ff:
            r17 = r1
            r13 = r10
            r26 = r12
        L_0x0204:
            r1 = r33[r8]
            java.lang.String r1 = (java.lang.String) r1
            int r10 = getColorByText(r1)
            goto L_0x0216
        L_0x020d:
            r17 = r1
            r26 = r12
            r25 = r13
            r13 = 1
            r10 = r23
        L_0x0216:
            if (r33 == 0) goto L_0x022b
            r1 = r33[r8]
            if (r1 == 0) goto L_0x022b
            boolean r1 = android.text.TextUtils.isEmpty(r16)
            if (r1 == 0) goto L_0x0223
            goto L_0x022b
        L_0x0223:
            r3 = r30
            r12 = r16
            r13 = r20
            goto L_0x0170
        L_0x022b:
            int r1 = com.meizu.common.R.drawable.mc_contact_list_picture     // Catch:{ Exception -> 0x04aa }
            r3 = r30
            android.graphics.drawable.Drawable r1 = r3.getDrawable(r1)     // Catch:{ Exception -> 0x04aa }
            android.graphics.Bitmap r20 = getBitmapFromDrawable(r1)     // Catch:{ Exception -> 0x04aa }
            r1 = r13
            r12 = r16
            r13 = r20
        L_0x023c:
            if (r34 == 0) goto L_0x0248
            r20 = r34[r8]
            if (r20 == 0) goto L_0x0248
            java.lang.String r20 = (java.lang.String) r20
            int r10 = getColorByText(r20)
        L_0x0248:
            if (r13 == 0) goto L_0x0291
            r20 = r5
            android.graphics.BitmapShader r5 = new android.graphics.BitmapShader
            r23 = r1
            android.graphics.Shader$TileMode r1 = android.graphics.Shader.TileMode.CLAMP
            r5.<init>(r13, r1, r1)
            int r1 = r13.getWidth()
            float r1 = (float) r1
            float r21 = r9.height()
            float r1 = r1 * r21
            float r21 = r9.width()
            r27 = r11
            int r11 = r13.getHeight()
            float r11 = (float) r11
            float r21 = r21 * r11
            int r1 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r1 <= 0) goto L_0x027c
            float r1 = r9.height()
            int r11 = r13.getHeight()
        L_0x0279:
            float r11 = (float) r11
            float r1 = r1 / r11
            goto L_0x0285
        L_0x027c:
            float r1 = r9.width()
            int r11 = r13.getWidth()
            goto L_0x0279
        L_0x0285:
            android.graphics.Matrix r11 = new android.graphics.Matrix
            r11.<init>()
            r11.setScale(r1, r1)
            r5.setLocalMatrix(r11)
            goto L_0x029b
        L_0x0291:
            r23 = r1
            r20 = r5
            r27 = r11
            r11 = r21
            r5 = r22
        L_0x029b:
            if (r8 != 0) goto L_0x0397
            r14.setColor(r10)
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 != 0) goto L_0x0315
            int r1 = r6 / 2
            float r1 = (float) r1
            float r1 = r1 - r0
            r21 = r10
            int r10 = r7 / 2
            float r10 = (float) r10
            r2.drawCircle(r1, r10, r4, r14)
            r22 = r4
            java.lang.String r4 = "sans-serif-medium"
            r28 = r14
            r14 = 0
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r4, r14)
            r31 = r5
            r5 = 500(0x1f4, float:7.0E-43)
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r4, r5, r14)
            r15.setTypeface(r4)
            int r4 = getChineseCount(r12)
            r5 = 2
            if (r4 == r5) goto L_0x02ef
            int r4 = getChineseCount(r12)
            if (r4 != 0) goto L_0x02e4
            r4 = r33[r8]
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = getEnglishFirstLetters(r4)
            int r4 = getEnglishCount(r4)
            if (r4 != r5) goto L_0x02e4
            goto L_0x02ef
        L_0x02e4:
            int r4 = com.meizu.common.R.dimen.avatar_name_char_one
            int r4 = r3.getDimensionPixelSize(r4)
            float r4 = (float) r4
            r15.setTextSize(r4)
            goto L_0x02f9
        L_0x02ef:
            int r4 = com.meizu.common.R.dimen.avatar_name_char_two
            int r4 = r3.getDimensionPixelSize(r4)
            float r4 = (float) r4
            r15.setTextSize(r4)
        L_0x02f9:
            android.graphics.Paint$FontMetrics r4 = r15.getFontMetrics()
            float r5 = r4.bottom
            float r4 = r4.top
            float r4 = r5 - r4
            float r4 = r4 / r19
            float r4 = r4 - r5
            float r10 = r10 + r4
            float r10 = r10 - r19
            r2.drawText(r12, r1, r10, r15)
        L_0x030c:
            r5 = r31
            r3 = r22
            r1 = r27
            r14 = r28
            goto L_0x035d
        L_0x0315:
            r22 = r4
            r31 = r5
            r21 = r10
            r28 = r14
            r14 = 0
            if (r13 == 0) goto L_0x030c
            float r1 = (float) r6
            float r4 = r9.width()
            float r1 = r1 - r4
            float r1 = r1 / r19
            float r1 = r1 - r0
            float r4 = (float) r7
            float r5 = r9.height()
            float r4 = r4 - r5
            float r4 = r4 / r19
            r11.postTranslate(r1, r4)
            r5 = r31
            r5.setLocalMatrix(r11)
            r1 = r27
            r1.setShader(r5)
            if (r23 == 0) goto L_0x034f
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 - r0
            int r10 = r7 / 2
            float r10 = (float) r10
            r3 = r22
            r14 = r28
            r2.drawCircle(r4, r10, r3, r14)
            goto L_0x0353
        L_0x034f:
            r3 = r22
            r14 = r28
        L_0x0353:
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 - r0
            int r10 = r7 / 2
            float r10 = (float) r10
            r2.drawCircle(r4, r10, r3, r1)
        L_0x035d:
            if (r20 == 0) goto L_0x0374
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 - r0
            int r10 = r7 / 2
            float r10 = (float) r10
            r22 = r12
            r12 = r26
            r29 = r17
            r17 = r15
            r15 = r29
            r2.drawCircle(r4, r10, r15, r12)
            goto L_0x037e
        L_0x0374:
            r22 = r12
            r12 = r26
            r29 = r17
            r17 = r15
            r15 = r29
        L_0x037e:
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 - r0
            int r10 = r7 / 2
            float r10 = (float) r10
            r26 = r12
            r12 = r25
            r2.drawCircle(r4, r10, r3, r12)
            r23 = r0
            r4 = r1
            r10 = r21
            r1 = r26
            r21 = r8
            goto L_0x0491
        L_0x0397:
            r3 = r4
            r21 = r10
            r22 = r12
            r4 = r24
            r12 = r25
            r1 = r27
            r29 = r17
            r17 = r15
            r15 = r29
            if (r8 != r4) goto L_0x0426
            if (r13 == 0) goto L_0x03ee
            if (r23 == 0) goto L_0x03c2
            r10 = r21
            r14.setColor(r10)
            r24 = r4
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 + r0
            r21 = r8
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r4, r8, r3, r14)
            goto L_0x0401
        L_0x03c2:
            r24 = r4
            r10 = r21
            r21 = r8
            float r4 = (float) r6
            float r8 = r9.width()
            float r4 = r4 - r8
            float r4 = r4 / r19
            float r4 = r4 + r0
            float r8 = (float) r7
            float r23 = r9.height()
            float r8 = r8 - r23
            float r8 = r8 / r19
            r11.postTranslate(r4, r8)
            r5.setLocalMatrix(r11)
            r1.setShader(r5)
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 + r0
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r4, r8, r3, r1)
            goto L_0x0401
        L_0x03ee:
            r24 = r4
            r10 = r21
            r21 = r8
            r14.setColor(r10)
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 + r0
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r4, r8, r3, r14)
        L_0x0401:
            if (r20 == 0) goto L_0x0412
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 + r0
            int r8 = r7 / 2
            float r8 = (float) r8
            r27 = r1
            r1 = r26
            r2.drawCircle(r4, r8, r15, r1)
            goto L_0x0416
        L_0x0412:
            r27 = r1
            r1 = r26
        L_0x0416:
            int r4 = r6 / 2
            float r4 = (float) r4
            float r4 = r4 + r0
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r4, r8, r3, r12)
            r23 = r0
            r4 = r27
            goto L_0x0491
        L_0x0426:
            r27 = r1
            r24 = r4
            r10 = r21
            r1 = r26
            r21 = r8
            if (r13 == 0) goto L_0x046d
            if (r23 == 0) goto L_0x0445
            r14.setColor(r10)
            int r4 = r6 / 2
            float r4 = (float) r4
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r4, r8, r3, r14)
            r23 = r0
            r4 = r27
            goto L_0x047d
        L_0x0445:
            float r4 = (float) r6
            float r8 = r9.width()
            float r4 = r4 - r8
            float r4 = r4 / r19
            float r8 = (float) r7
            float r23 = r9.height()
            float r8 = r8 - r23
            float r8 = r8 / r19
            r11.postTranslate(r4, r8)
            r5.setLocalMatrix(r11)
            r4 = r27
            r4.setShader(r5)
            int r8 = r6 / 2
            float r8 = (float) r8
            r23 = r0
            int r0 = r7 / 2
            float r0 = (float) r0
            r2.drawCircle(r8, r0, r3, r4)
            goto L_0x047d
        L_0x046d:
            r23 = r0
            r4 = r27
            r14.setColor(r10)
            int r0 = r6 / 2
            float r0 = (float) r0
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r0, r8, r3, r14)
        L_0x047d:
            if (r20 == 0) goto L_0x0488
            int r0 = r6 / 2
            float r0 = (float) r0
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r0, r8, r15, r1)
        L_0x0488:
            int r0 = r6 / 2
            float r0 = (float) r0
            int r8 = r7 / 2
            float r8 = (float) r8
            r2.drawCircle(r0, r8, r3, r12)
        L_0x0491:
            int r8 = r21 + -1
            r21 = r11
            r16 = r22
            r0 = r23
            r11 = r4
            r22 = r5
            r5 = r20
            r4 = r3
            r20 = r13
            r3 = r24
            r13 = r12
            r12 = r1
            r1 = r15
            r15 = r17
            goto L_0x0149
        L_0x04aa:
            r0 = 0
            return r0
        L_0x04ac:
            return r35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.util.ContactHeaderUtils.createContactHeaderDrawable(android.content.res.Resources, int, int, java.lang.Object[], java.lang.Object[], int):android.graphics.Bitmap");
    }
}
