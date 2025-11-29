package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
    public static final float m = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    public final Paint f207a;
    public float b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public final Path g = new Path();
    public final int h;
    public boolean i = false;
    public float j;
    public float k;
    public int l = 2;

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f207a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        d(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        c(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        f(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        e((float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.c = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.b = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.d = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float b(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public float a() {
        return this.j;
    }

    public void c(float f2) {
        if (this.f207a.getStrokeWidth() != f2) {
            this.f207a.setStrokeWidth(f2);
            this.k = (float) (((double) (f2 / 2.0f)) * Math.cos((double) m));
            invalidateSelf();
        }
    }

    public void d(int i2) {
        if (i2 != this.f207a.getColor()) {
            this.f207a.setColor(i2);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i2 = this.l;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? DrawableCompat.f(this) == 0 : DrawableCompat.f(this) == 1))) {
            z = true;
        }
        float f2 = this.b;
        float b2 = b(this.c, (float) Math.sqrt((double) (f2 * f2 * 2.0f)), this.j);
        float b3 = b(this.c, this.d, this.j);
        float round = (float) Math.round(b(0.0f, this.k, this.j));
        float b4 = b(0.0f, m, this.j);
        double d2 = (double) b2;
        float b5 = b(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.j);
        double d3 = (double) b4;
        boolean z2 = z;
        float round2 = (float) Math.round(Math.cos(d3) * d2);
        float round3 = (float) Math.round(d2 * Math.sin(d3));
        this.g.rewind();
        float b6 = b(this.e + this.f207a.getStrokeWidth(), -this.k, this.j);
        float f3 = (-b3) / 2.0f;
        this.g.moveTo(f3 + round, 0.0f);
        this.g.rLineTo(b3 - (round * 2.0f), 0.0f);
        this.g.moveTo(f3, b6);
        this.g.rLineTo(round2, round3);
        this.g.moveTo(f3, -b6);
        this.g.rLineTo(round2, -round3);
        this.g.close();
        canvas.save();
        float strokeWidth = this.f207a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f4 = this.e;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f4))) / 4) * 2)) + (strokeWidth * 1.5f) + f4);
        if (this.f) {
            canvas2.rotate(b5 * ((float) (this.i ^ z2 ? -1 : 1)));
        } else if (z2) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.g, this.f207a);
        canvas.restore();
    }

    public void e(float f2) {
        if (f2 != this.e) {
            this.e = f2;
            invalidateSelf();
        }
    }

    public void f(boolean z) {
        if (this.f != z) {
            this.f = z;
            invalidateSelf();
        }
    }

    public void g(boolean z) {
        if (this.i != z) {
            this.i = z;
            invalidateSelf();
        }
    }

    public int getIntrinsicHeight() {
        return this.h;
    }

    public int getIntrinsicWidth() {
        return this.h;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        if (i2 != this.f207a.getAlpha()) {
            this.f207a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f207a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(@FloatRange float f2) {
        if (this.j != f2) {
            this.j = f2;
            invalidateSelf();
        }
    }
}
