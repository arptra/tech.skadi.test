package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.xjsd.ai.assistant.protocol.CmdCode;

public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f727a;
    public int b = 160;
    public int c = CmdCode.CODE_RESET_VAD_STATUS;
    public final Paint d = new Paint(3);
    public final BitmapShader e;
    public final Matrix f = new Matrix();
    public float g;
    public final Rect h = new Rect();
    public final RectF i = new RectF();
    public boolean j = true;
    public boolean k;
    public int l;
    public int m;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.b = resources.getDisplayMetrics().densityDpi;
        }
        this.f727a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.e = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.e = null;
    }

    public static boolean e(float f2) {
        return f2 > 0.05f;
    }

    public final void a() {
        this.l = this.f727a.getScaledWidth(this.b);
        this.m = this.f727a.getScaledHeight(this.b);
    }

    public final Bitmap b() {
        return this.f727a;
    }

    public float c() {
        return this.g;
    }

    public void d(int i2, int i3, int i4, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f727a;
        if (bitmap != null) {
            i();
            if (this.d.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.h, this.d);
                return;
            }
            RectF rectF = this.i;
            float f2 = this.g;
            canvas.drawRoundRect(rectF, f2, f2, this.d);
        }
    }

    public void f(boolean z) {
        this.k = z;
        this.j = true;
        if (z) {
            h();
            this.d.setShader(this.e);
            invalidateSelf();
            return;
        }
        g(0.0f);
    }

    public void g(float f2) {
        if (this.g != f2) {
            this.k = false;
            if (e(f2)) {
                this.d.setShader(this.e);
            } else {
                this.d.setShader((Shader) null);
            }
            this.g = f2;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.d.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.d.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.m;
    }

    public int getIntrinsicWidth() {
        return this.l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r3.f727a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOpacity() {
        /*
            r3 = this;
            int r0 = r3.c
            r1 = 119(0x77, float:1.67E-43)
            r2 = -3
            if (r0 != r1) goto L_0x002a
            boolean r0 = r3.k
            if (r0 == 0) goto L_0x000c
            goto L_0x002a
        L_0x000c:
            android.graphics.Bitmap r0 = r3.f727a
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.hasAlpha()
            if (r0 != 0) goto L_0x002a
            android.graphics.Paint r0 = r3.d
            int r0 = r0.getAlpha()
            r1 = 255(0xff, float:3.57E-43)
            if (r0 < r1) goto L_0x002a
            float r3 = r3.g
            boolean r3 = e(r3)
            if (r3 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = -1
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.RoundedBitmapDrawable.getOpacity():int");
    }

    public final void h() {
        this.g = (float) (Math.min(this.m, this.l) / 2);
    }

    public void i() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                d(this.c, min, min, getBounds(), this.h);
                int min2 = Math.min(this.h.width(), this.h.height());
                this.h.inset(Math.max(0, (this.h.width() - min2) / 2), Math.max(0, (this.h.height() - min2) / 2));
                this.g = ((float) min2) * 0.5f;
            } else {
                d(this.c, this.l, this.m, getBounds(), this.h);
            }
            this.i.set(this.h);
            if (this.e != null) {
                Matrix matrix = this.f;
                RectF rectF = this.i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f.preScale(this.i.width() / ((float) this.f727a.getWidth()), this.i.height() / ((float) this.f727a.getHeight()));
                this.e.setLocalMatrix(this.f);
                this.d.setShader(this.e);
            }
            this.j = false;
        }
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            h();
        }
        this.j = true;
    }

    public void setAlpha(int i2) {
        if (i2 != this.d.getAlpha()) {
            this.d.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.d.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.d.setFilterBitmap(z);
        invalidateSelf();
    }
}
