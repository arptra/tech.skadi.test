package com.meizu.common.drawble;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Build;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import com.meizu.common.util.SmoothCornerPathGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000202H\u0016J\u0010\u00108\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000206H\u0016J\u0010\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u000206H\u0002R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00058F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0012R$\u0010!\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0012R$\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R$\u0010.\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0012R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\"\u0004\b4\u0010\u0012¨\u0006@"}, d2 = {"Lcom/meizu/common/drawble/SmoothCornerDrawableWrapper;", "Landroid/graphics/drawable/DrawableWrapper;", "drawable", "Landroid/graphics/drawable/Drawable;", "smoothness", "", "radius", "(Landroid/graphics/drawable/Drawable;FF)V", "strokeWidth", "strokeColor", "", "(Landroid/graphics/drawable/Drawable;FFFI)V", "(Landroid/graphics/drawable/Drawable;)V", "bitmapWithTransparency", "Landroid/graphics/Bitmap;", "value", "heightFloat", "setHeightFloat", "(F)V", "maxSmoothRadius", "getMaxSmoothRadius", "()F", "needRegenPath", "", "path", "Landroid/graphics/Path;", "provideOutline", "getProvideOutline", "()Z", "setProvideOutline", "(Z)V", "getRadius", "setRadius", "smoothCornerEnable", "getSmoothCornerEnable", "setSmoothCornerEnable", "getSmoothness", "setSmoothness", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokePaint", "Landroid/graphics/Paint;", "getStrokePaint", "()Landroid/graphics/Paint;", "strokeWidthExt", "getStrokeWidthExt", "setStrokeWidthExt", "tmpCanvas", "Landroid/graphics/Canvas;", "widthFloat", "setWidthFloat", "draw", "", "canvas", "getOutline", "outline", "Landroid/graphics/Outline;", "invalidateSelf", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "trySmoothPath", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SmoothCornerDrawableWrapper extends DrawableWrapper {
    private Bitmap bitmapWithTransparency;
    private float heightFloat;
    private boolean needRegenPath;
    @NotNull
    private Path path;
    private boolean provideOutline;
    private float radius;
    private boolean smoothCornerEnable;
    private float smoothness;
    private int strokeColor;
    @NotNull
    private final Paint strokePaint;
    private float strokeWidthExt;
    @NotNull
    private final Canvas tmpCanvas;
    private float widthFloat;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(@NotNull Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.tmpCanvas = new Canvas();
        this.path = new Path();
        this.provideOutline = true;
        this.smoothCornerEnable = true;
        this.smoothness = 0.2f;
        this.radius = 0.2f;
        this.strokeColor = -16777216;
        Paint paint = new Paint();
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.strokePaint = paint;
    }

    private final void setHeightFloat(float f) {
        if (this.heightFloat != f) {
            this.heightFloat = f;
            this.needRegenPath = true;
        }
    }

    private final void setWidthFloat(float f) {
        if (this.widthFloat != f) {
            this.widthFloat = f;
            this.needRegenPath = true;
        }
    }

    private final void trySmoothPath() {
        if (this.needRegenPath) {
            Path genSmoothCornerPath$default = SmoothCornerPathGenerator.genSmoothCornerPath$default(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.smoothness, getRadius(), false, 64, (Object) null);
            genSmoothCornerPath$default.setFillType(Path.FillType.INVERSE_WINDING);
            this.path = genSmoothCornerPath$default;
            this.needRegenPath = false;
        }
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        this.tmpCanvas.drawColor(0);
        super.draw(this.tmpCanvas);
        this.tmpCanvas.drawPath(this.path, SmoothCornerPathGenerator.INSTANCE.getClearBitmapPaint());
        if (this.strokePaint.getStrokeWidth() > ((float) 0)) {
            float f = (float) 2;
            Path genSmoothCornerPath$default = SmoothCornerPathGenerator.genSmoothCornerPath$default((this.strokePaint.getStrokeWidth() / f) + 0.0f, (this.strokePaint.getStrokeWidth() / f) + 0.0f, this.widthFloat - (this.strokePaint.getStrokeWidth() / f), this.heightFloat - (this.strokePaint.getStrokeWidth() / f), this.smoothness, getRadius() - (this.strokePaint.getStrokeWidth() / f), false, 64, (Object) null);
            genSmoothCornerPath$default.setFillType(Path.FillType.WINDING);
            this.tmpCanvas.drawPath(genSmoothCornerPath$default, this.strokePaint);
        }
        Bitmap bitmap = this.bitmapWithTransparency;
        if (bitmap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bitmapWithTransparency");
            bitmap = null;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
    }

    public final float getMaxSmoothRadius() {
        return SmoothCornerPathGenerator.INSTANCE.getSmoothnessRadiusLimit(this.widthFloat, this.heightFloat, this.smoothness);
    }

    public void getOutline(@NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        super.getOutline(outline);
        if (!this.smoothCornerEnable || !this.provideOutline) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(this.path);
        } else {
            outline.setConvexPath(this.path);
        }
    }

    public final boolean getProvideOutline() {
        return this.provideOutline;
    }

    public final float getRadius() {
        return RangesKt.coerceIn(this.radius, 0.0f, getMaxSmoothRadius());
    }

    public final boolean getSmoothCornerEnable() {
        return this.smoothCornerEnable;
    }

    public final float getSmoothness() {
        return this.smoothness;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    @NotNull
    public final Paint getStrokePaint() {
        return this.strokePaint;
    }

    public final float getStrokeWidthExt() {
        return this.strokeWidthExt;
    }

    public void invalidateSelf() {
        if (!this.smoothCornerEnable) {
            super.invalidateSelf();
            return;
        }
        trySmoothPath();
        super.invalidateSelf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0.getHeight() != r7.height()) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBoundsChange(@org.jetbrains.annotations.NotNull android.graphics.Rect r7) {
        /*
            r6 = this;
            java.lang.String r0 = "bounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r6.smoothCornerEnable
            if (r0 != 0) goto L_0x000d
            super.onBoundsChange(r7)
            return
        L_0x000d:
            int r0 = r7.width()
            float r0 = (float) r0
            r6.setWidthFloat(r0)
            int r0 = r7.height()
            float r0 = (float) r0
            r6.setHeightFloat(r0)
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            java.lang.String r1 = "createBitmap(bounds.widt… Bitmap.Config.ARGB_8888)"
            r2 = 0
            java.lang.String r3 = "bitmapWithTransparency"
            if (r0 == 0) goto L_0x00b3
            if (r0 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x002c:
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L_0x0034
            goto L_0x00b3
        L_0x0034:
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L_0x003c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x003c:
            int r0 = r0.getWidth()
            int r4 = r7.width()
            if (r0 != r4) goto L_0x0058
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L_0x004e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x004e:
            int r0 = r0.getHeight()
            int r4 = r7.height()
            if (r0 == r4) goto L_0x00d2
        L_0x0058:
            int r0 = r7.width()
            android.graphics.Bitmap r4 = r6.bitmapWithTransparency
            if (r4 != 0) goto L_0x0064
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r4 = r2
        L_0x0064:
            int r4 = r4.getWidth()
            if (r0 > r4) goto L_0x0093
            int r0 = r7.height()
            android.graphics.Bitmap r4 = r6.bitmapWithTransparency
            if (r4 != 0) goto L_0x0076
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r4 = r2
        L_0x0076:
            int r4 = r4.getHeight()
            if (r0 > r4) goto L_0x0093
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L_0x0084
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0085
        L_0x0084:
            r2 = r0
        L_0x0085:
            int r0 = r7.width()
            int r1 = r7.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            r2.reconfigure(r0, r1, r3)
            goto L_0x00d2
        L_0x0093:
            int r0 = r7.width()
            int r4 = r7.height()
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r4, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r6.tmpCanvas
            if (r0 != 0) goto L_0x00ae
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x00af
        L_0x00ae:
            r2 = r0
        L_0x00af:
            r1.setBitmap(r2)
            goto L_0x00d2
        L_0x00b3:
            int r0 = r7.width()
            int r4 = r7.height()
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r4, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r6.tmpCanvas
            if (r0 != 0) goto L_0x00ce
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x00cf
        L_0x00ce:
            r2 = r0
        L_0x00cf:
            r1.setBitmap(r2)
        L_0x00d2:
            r6.trySmoothPath()
            super.onBoundsChange(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.drawble.SmoothCornerDrawableWrapper.onBoundsChange(android.graphics.Rect):void");
    }

    public final void setProvideOutline(boolean z) {
        this.provideOutline = z;
    }

    public final void setRadius(float f) {
        if (f != this.radius) {
            this.radius = f;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setSmoothCornerEnable(boolean z) {
        if (z != this.smoothCornerEnable) {
            this.smoothCornerEnable = z;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setSmoothness(float f) {
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        if (coerceIn != this.smoothness) {
            this.smoothness = coerceIn;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setStrokeColor(int i) {
        if (i != this.strokeColor) {
            this.strokeColor = i;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setStrokeWidthExt(float f) {
        if (f != this.strokeWidthExt) {
            this.strokeWidthExt = f;
            this.needRegenPath = true;
            this.strokePaint.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(@NotNull Drawable drawable, @FloatRange float f, float f2) {
        this(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setSmoothness(f);
        setRadius(f2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmoothCornerDrawableWrapper(Drawable drawable, float f, float f2, float f3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, f, f2, (i2 & 8) != 0 ? 0.0f : f3, (i2 & 16) != 0 ? -16777216 : i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(@NotNull Drawable drawable, @FloatRange float f, float f2, float f3, int i) {
        this(drawable, f, f2);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setStrokeColor(i);
        setStrokeWidthExt(f3);
    }
}
