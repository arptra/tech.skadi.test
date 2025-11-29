package com.meizu.common.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.LruCache;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002#$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0007JD\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J2\u0010\u001e\u001a\u00020\u000e*\u00020\u001f2\b\b\u0001\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u0019H\u0007J(\u0010!\u001a\u00020\u000e*\u00020\"2\b\b\u0001\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/meizu/common/util/SmoothCornerPathGenerator;", "", "()V", "DefaultSmoothness", "", "clearBitmapPaint", "Landroid/graphics/Paint;", "getClearBitmapPaint", "()Landroid/graphics/Paint;", "pathCache", "Landroid/util/LruCache;", "Lcom/meizu/common/util/SmoothCornerPathGenerator$SmoothPathParams;", "Landroid/graphics/Path;", "addSmoothCorner", "", "path", "radius", "", "smoothness", "left", "top", "right", "bottom", "genSmoothCornerPath", "useNativeRoundCornerWhileParamsInvalid", "", "getSmoothnessRadiusLimit", "sizeFloat", "widthFloat", "heightFloat", "addSmoothCornerAsOutline", "Landroid/view/View;", "setLayerTypeToHardware", "clipToSmoothCorner", "Landroid/graphics/Bitmap;", "BezierCurve", "SmoothPathParams", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmoothCornerPathGenerator {
    public static final float DefaultSmoothness = 0.2f;
    @NotNull
    public static final SmoothCornerPathGenerator INSTANCE = new SmoothCornerPathGenerator();
    @NotNull
    private static final Paint clearBitmapPaint;
    @NotNull
    private static final LruCache<SmoothPathParams, Path> pathCache = new SmoothCornerPathGenerator$special$$inlined$lruCache$default$1(100);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/meizu/common/util/SmoothCornerPathGenerator$BezierCurve;", "", "()V", "points", "", "getPoints", "()[F", "setPoints", "([F)V", "apply", "", "path", "Landroid/graphics/Path;", "offset", "dx", "", "dy", "reverse", "Companion", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BezierCurve {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private float[] points;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/meizu/common/util/SmoothCornerPathGenerator$BezierCurve$Companion;", "", "()V", "create", "Lcom/meizu/common/util/SmoothCornerPathGenerator$BezierCurve;", "radius", "", "smoothness", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final BezierCurve create(float f, @FloatRange float f2) {
                float f3 = f;
                BezierCurve bezierCurve = new BezierCurve((DefaultConstructorMarker) null);
                bezierCurve.getPoints()[0] = 0.0f;
                bezierCurve.getPoints()[1] = (f2 * f3) + f3;
                bezierCurve.getPoints()[2] = 0.0f;
                double d = (double) 180;
                double d2 = (double) f3;
                bezierCurve.getPoints()[3] = (float) (((-Math.tan((((double) 15) * 3.141592653589793d) / d)) * d2) + d2);
                double d3 = (((double) 45) * 3.141592653589793d) / d;
                double cos = Math.cos(d3) * d2;
                double cos2 = Math.cos(d3) * Math.tan((((double) 14) * 3.141592653589793d) / d) * d2;
                bezierCurve.getPoints()[4] = (float) ((-(cos2 + cos)) + d2);
                bezierCurve.getPoints()[5] = (float) ((-(cos - cos2)) + d2);
                double d4 = (double) (-f3);
                bezierCurve.getPoints()[6] = (float) ((Math.cos(d3) * d4) + d2);
                bezierCurve.getPoints()[7] = (float) ((d4 * Math.sin(d3)) + d2);
                bezierCurve.getPoints()[8] = bezierCurve.getPoints()[5];
                bezierCurve.getPoints()[9] = bezierCurve.getPoints()[4];
                bezierCurve.getPoints()[10] = bezierCurve.getPoints()[3];
                bezierCurve.getPoints()[11] = bezierCurve.getPoints()[2];
                bezierCurve.getPoints()[12] = bezierCurve.getPoints()[1];
                bezierCurve.getPoints()[13] = bezierCurve.getPoints()[0];
                return bezierCurve;
            }

            private Companion() {
            }
        }

        public /* synthetic */ BezierCurve(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void apply(@NotNull Path path) {
            Intrinsics.checkNotNullParameter(path, "path");
            float[] fArr = this.points;
            path.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
            float[] fArr2 = this.points;
            path.cubicTo(fArr2[8], fArr2[9], fArr2[10], fArr2[11], fArr2[12], fArr2[13]);
        }

        @NotNull
        public final float[] getPoints() {
            return this.points;
        }

        public final void offset(float f, float f2) {
            int i = 0;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, this.points.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    float[] fArr = this.points;
                    fArr[i] = fArr[i] + f;
                    int i2 = i + 1;
                    fArr[i2] = fArr[i2] + f2;
                    if (i != progressionLastElement) {
                        i += 2;
                    } else {
                        return;
                    }
                }
            }
        }

        public final void reverse() {
            float[] fArr = this.points;
            float f = fArr[0];
            float f2 = fArr[1];
            fArr[0] = fArr[12];
            fArr[1] = fArr[13];
            fArr[12] = f;
            fArr[13] = f2;
            float f3 = fArr[2];
            float f4 = fArr[3];
            fArr[2] = fArr[10];
            fArr[3] = fArr[11];
            fArr[10] = f3;
            fArr[11] = f4;
            float f5 = fArr[4];
            float f6 = fArr[5];
            fArr[4] = fArr[8];
            fArr[5] = fArr[9];
            fArr[8] = f5;
            fArr[9] = f6;
        }

        public final void setPoints(@NotNull float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.points = fArr;
        }

        private BezierCurve() {
            this.points = new float[14];
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/meizu/common/util/SmoothCornerPathGenerator$SmoothPathParams;", "", "left", "", "top", "right", "bottom", "smoothness", "radius", "useNativeRoundCornerWhileParamsInvalid", "", "(FFFFFFZ)V", "getBottom", "()F", "getLeft", "getRadius", "getRight", "getSmoothness", "getTop", "getUseNativeRoundCornerWhileParamsInvalid", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SmoothPathParams {
        private final float bottom;
        private final float left;
        private final float radius;
        private final float right;
        private final float smoothness;

        /* renamed from: top  reason: collision with root package name */
        private final float f9495top;
        private final boolean useNativeRoundCornerWhileParamsInvalid;

        public SmoothPathParams(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.left = f;
            this.f9495top = f2;
            this.right = f3;
            this.bottom = f4;
            this.smoothness = f5;
            this.radius = f6;
            this.useNativeRoundCornerWhileParamsInvalid = z;
        }

        public static /* synthetic */ SmoothPathParams copy$default(SmoothPathParams smoothPathParams, float f, float f2, float f3, float f4, float f5, float f6, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                f = smoothPathParams.left;
            }
            if ((i & 2) != 0) {
                f2 = smoothPathParams.f9495top;
            }
            float f7 = f2;
            if ((i & 4) != 0) {
                f3 = smoothPathParams.right;
            }
            float f8 = f3;
            if ((i & 8) != 0) {
                f4 = smoothPathParams.bottom;
            }
            float f9 = f4;
            if ((i & 16) != 0) {
                f5 = smoothPathParams.smoothness;
            }
            float f10 = f5;
            if ((i & 32) != 0) {
                f6 = smoothPathParams.radius;
            }
            float f11 = f6;
            if ((i & 64) != 0) {
                z = smoothPathParams.useNativeRoundCornerWhileParamsInvalid;
            }
            return smoothPathParams.copy(f, f7, f8, f9, f10, f11, z);
        }

        public final float component1() {
            return this.left;
        }

        public final float component2() {
            return this.f9495top;
        }

        public final float component3() {
            return this.right;
        }

        public final float component4() {
            return this.bottom;
        }

        public final float component5() {
            return this.smoothness;
        }

        public final float component6() {
            return this.radius;
        }

        public final boolean component7() {
            return this.useNativeRoundCornerWhileParamsInvalid;
        }

        @NotNull
        public final SmoothPathParams copy(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            return new SmoothPathParams(f, f2, f3, f4, f5, f6, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SmoothPathParams)) {
                return false;
            }
            SmoothPathParams smoothPathParams = (SmoothPathParams) obj;
            return Float.compare(this.left, smoothPathParams.left) == 0 && Float.compare(this.f9495top, smoothPathParams.f9495top) == 0 && Float.compare(this.right, smoothPathParams.right) == 0 && Float.compare(this.bottom, smoothPathParams.bottom) == 0 && Float.compare(this.smoothness, smoothPathParams.smoothness) == 0 && Float.compare(this.radius, smoothPathParams.radius) == 0 && this.useNativeRoundCornerWhileParamsInvalid == smoothPathParams.useNativeRoundCornerWhileParamsInvalid;
        }

        public final float getBottom() {
            return this.bottom;
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getSmoothness() {
            return this.smoothness;
        }

        public final float getTop() {
            return this.f9495top;
        }

        public final boolean getUseNativeRoundCornerWhileParamsInvalid() {
            return this.useNativeRoundCornerWhileParamsInvalid;
        }

        public int hashCode() {
            int hashCode = ((((((((((Float.hashCode(this.left) * 31) + Float.hashCode(this.f9495top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + Float.hashCode(this.smoothness)) * 31) + Float.hashCode(this.radius)) * 31;
            boolean z = this.useNativeRoundCornerWhileParamsInvalid;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        @NotNull
        public String toString() {
            return "SmoothPathParams(left=" + this.left + ", top=" + this.f9495top + ", right=" + this.right + ", bottom=" + this.bottom + ", smoothness=" + this.smoothness + ", radius=" + this.radius + ", useNativeRoundCornerWhileParamsInvalid=" + this.useNativeRoundCornerWhileParamsInvalid + ')';
        }
    }

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        clearBitmapPaint = paint;
    }

    private SmoothCornerPathGenerator() {
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.ERROR, message = "请改用genSmoothCornerPath()方法！", replaceWith = @ReplaceWith(expression = "genSmoothCornerPath()", imports = {}))
    public static final void addSmoothCorner(@NotNull Path path, int i, float f, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IllegalStateException("请改用genSmoothCornerPath()方法！".toString());
    }

    @JvmStatic
    @JvmOverloads
    public static final void addSmoothCornerAsOutline(@NotNull View view, @FloatRange float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        addSmoothCornerAsOutline$default(view, f, f2, false, false, 12, (Object) null);
    }

    public static /* synthetic */ void addSmoothCornerAsOutline$default(View view, float f, float f2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        addSmoothCornerAsOutline(view, f, f2, z, z2);
    }

    @JvmStatic
    @JvmOverloads
    public static final void clipToSmoothCorner(@NotNull Bitmap bitmap, @FloatRange float f, float f2) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        clipToSmoothCorner$default(bitmap, f, f2, false, 4, (Object) null);
    }

    public static /* synthetic */ void clipToSmoothCorner$default(Bitmap bitmap, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        clipToSmoothCorner(bitmap, f, f2, z);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final Path genSmoothCornerPath(float f, float f2, float f3, float f4, @FloatRange float f5, float f6) {
        return genSmoothCornerPath$default(f, f2, f3, f4, f5, f6, false, 64, (Object) null);
    }

    public static /* synthetic */ Path genSmoothCornerPath$default(float f, float f2, float f3, float f4, float f5, float f6, boolean z, int i, Object obj) {
        if ((i & 64) != 0) {
            z = false;
        }
        return genSmoothCornerPath(f, f2, f3, f4, f5, f6, z);
    }

    @NotNull
    public final Paint getClearBitmapPaint() {
        return clearBitmapPaint;
    }

    public final float getSmoothnessRadiusLimit(float f, float f2, float f3) {
        return getSmoothnessRadiusLimit(Math.min(f, f2), f3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void addSmoothCornerAsOutline(@NotNull View view, @FloatRange float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        addSmoothCornerAsOutline$default(view, f, f2, z, false, 8, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void clipToSmoothCorner(@NotNull Bitmap bitmap, @FloatRange float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Canvas canvas = new Canvas(bitmap);
        float f3 = f;
        Path genSmoothCornerPath = genSmoothCornerPath(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), f3, RangesKt.coerceIn(f2, 0.0f, INSTANCE.getSmoothnessRadiusLimit((float) bitmap.getWidth(), (float) bitmap.getHeight(), f)), z);
        genSmoothCornerPath.setFillType(Path.FillType.INVERSE_WINDING);
        canvas.drawPath(genSmoothCornerPath, clearBitmapPaint);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final Path genSmoothCornerPath(float f, float f2, float f3, float f4, @FloatRange float f5, float f6, boolean z) {
        float f7 = f;
        float f8 = f2;
        float f9 = f5;
        float f10 = f6;
        Path path = new Path();
        SmoothPathParams smoothPathParams = new SmoothPathParams(f, f2, f3, f4, f5, f6, z);
        LruCache<SmoothPathParams, Path> lruCache = pathCache;
        Path path2 = lruCache.get(smoothPathParams);
        if (path2 != null) {
            path.addPath(path2);
            return path;
        }
        lruCache.put(smoothPathParams, path);
        float f11 = f3 - f7;
        float f12 = f4 - f8;
        float f13 = (float) 0;
        if (f11 <= f13 || f12 <= f13) {
            path.addRect(f, f2, f3, f4, Path.Direction.CW);
            return new Path(path);
        } else if (!z || f10 <= INSTANCE.getSmoothnessRadiusLimit(f11, f12, f9)) {
            float f14 = (f7 + f3) / 2.0f;
            float f15 = (f8 + f4) / 2.0f;
            BezierCurve create = BezierCurve.Companion.create(f10, f9);
            create.offset(f, f2);
            path.moveTo(create.getPoints()[0], create.getPoints()[1]);
            create.apply(path);
            Matrix matrix = new Matrix();
            float f16 = -f14;
            float f17 = -f15;
            matrix.postTranslate(f16, f17);
            matrix.postScale(-1.0f, 1.0f);
            matrix.postTranslate(f14, f15);
            matrix.mapPoints(create.getPoints());
            create.reverse();
            path.lineTo(create.getPoints()[0], create.getPoints()[1]);
            create.apply(path);
            create.reverse();
            matrix.reset();
            matrix.postTranslate(f16, f17);
            matrix.postScale(1.0f, -1.0f);
            matrix.postTranslate(f14, f15);
            matrix.mapPoints(create.getPoints());
            path.lineTo(create.getPoints()[0], create.getPoints()[1]);
            create.apply(path);
            matrix.reset();
            matrix.postTranslate(f16, f17);
            matrix.postScale(-1.0f, 1.0f);
            matrix.postTranslate(f14, f15);
            matrix.mapPoints(create.getPoints());
            create.reverse();
            path.lineTo(create.getPoints()[0], create.getPoints()[1]);
            create.apply(path);
            path.close();
            return new Path(path);
        } else {
            path.addRoundRect(f, f2, f3, f4, f6, f6, Path.Direction.CW);
            return new Path(path);
        }
    }

    public final float getSmoothnessRadiusLimit(float f, float f2) {
        return RangesKt.coerceAtMost(f, (f / 2.0f) / (f2 + 1.0f));
    }

    @JvmStatic
    @JvmOverloads
    public static final void addSmoothCornerAsOutline(@NotNull View view, @FloatRange float f, float f2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setClipToOutline(true);
        view.setOutlineProvider(new SmoothCornerPathGenerator$addSmoothCornerAsOutline$1(view, f, f2, z));
        if (z2) {
            view.setLayerType(2, (Paint) null);
        }
    }
}
