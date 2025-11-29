package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo
final class GradientColorInflaterCompat {
    public static ColorStops a(ColorStops colorStops, int i, int i2, boolean z, int i3) {
        return colorStops != null ? colorStops : z ? new ColorStops(i, i3, i2) : new ColorStops(i, i2);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray q = TypedArrayUtils.q(resources, theme2, attributeSet, R.styleable.GradientColor);
            float j = TypedArrayUtils.j(q, xmlPullParser2, "startX", R.styleable.GradientColor_android_startX, 0.0f);
            float j2 = TypedArrayUtils.j(q, xmlPullParser2, "startY", R.styleable.GradientColor_android_startY, 0.0f);
            float j3 = TypedArrayUtils.j(q, xmlPullParser2, "endX", R.styleable.GradientColor_android_endX, 0.0f);
            float j4 = TypedArrayUtils.j(q, xmlPullParser2, "endY", R.styleable.GradientColor_android_endY, 0.0f);
            float j5 = TypedArrayUtils.j(q, xmlPullParser2, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
            float j6 = TypedArrayUtils.j(q, xmlPullParser2, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
            int k = TypedArrayUtils.k(q, xmlPullParser2, "type", R.styleable.GradientColor_android_type, 0);
            int f = TypedArrayUtils.f(q, xmlPullParser2, "startColor", R.styleable.GradientColor_android_startColor, 0);
            boolean p = TypedArrayUtils.p(xmlPullParser2, "centerColor");
            int f2 = TypedArrayUtils.f(q, xmlPullParser2, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
            int f3 = TypedArrayUtils.f(q, xmlPullParser2, "endColor", R.styleable.GradientColor_android_endColor, 0);
            int k2 = TypedArrayUtils.k(q, xmlPullParser2, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
            float f4 = j5;
            float j7 = TypedArrayUtils.j(q, xmlPullParser2, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
            q.recycle();
            ColorStops a2 = a(c(resources, xmlPullParser, attributeSet, theme), f, f3, p, f2);
            if (k == 1) {
                float f5 = f4;
                if (j7 > 0.0f) {
                    int[] iArr = a2.f701a;
                    return new RadialGradient(f5, j6, j7, iArr, a2.b, d(k2));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (k != 2) {
                return new LinearGradient(j, j2, j3, j4, a2.f701a, a2.b, d(k2));
            } else {
                return new SweepGradient(f4, j6, a2.f701a, a2.b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.content.res.GradientColorInflaterCompat.ColorStops c(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r9.next()
            if (r3 == r1) goto L_0x0085
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0085
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = androidx.core.R.styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.content.res.TypedArrayUtils.q(r8, r11, r10, r3)
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L_0x006a
            if (r6 == 0) goto L_0x006a
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x006a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L_0x0085:
            int r8 = r4.size()
            if (r8 <= 0) goto L_0x0091
            androidx.core.content.res.GradientColorInflaterCompat$ColorStops r8 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops
            r8.<init>((java.util.List) r4, (java.util.List) r2)
            return r8
        L_0x0091:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.GradientColorInflaterCompat.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.GradientColorInflaterCompat$ColorStops");
    }

    public static Shader.TileMode d(int i) {
        return i != 1 ? i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    public static final class ColorStops {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f701a;
        public final float[] b;

        public ColorStops(List list, List list2) {
            int size = list.size();
            this.f701a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f701a[i] = ((Integer) list.get(i)).intValue();
                this.b[i] = ((Float) list2.get(i)).floatValue();
            }
        }

        public ColorStops(int i, int i2) {
            this.f701a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        public ColorStops(int i, int i2, int i3) {
            this.f701a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
