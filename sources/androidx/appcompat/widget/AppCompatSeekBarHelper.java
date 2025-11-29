package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    public final SeekBar d;
    public Drawable e;
    public ColorStateList f = null;
    public PorterDuff.Mode g = null;
    public boolean h = false;
    public boolean i = false;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.d = seekBar;
    }

    public void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        TintTypedArray v = TintTypedArray.v(this.d.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i2, 0);
        SeekBar seekBar = this.d;
        ViewCompat.s0(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, v.r(), i2, 0);
        Drawable h2 = v.h(R.styleable.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.d.setThumb(h2);
        }
        j(v.g(R.styleable.AppCompatSeekBar_tickMark));
        if (v.s(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = DrawableUtils.e(v.k(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (v.s(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f = v.c(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        v.w();
        f();
    }

    public final void f() {
        Drawable drawable = this.e;
        if (drawable == null) {
            return;
        }
        if (this.h || this.i) {
            Drawable r = DrawableCompat.r(drawable.mutate());
            this.e = r;
            if (this.h) {
                DrawableCompat.o(r, this.f);
            }
            if (this.i) {
                DrawableCompat.p(this.e, this.g);
            }
            if (this.e.isStateful()) {
                this.e.setState(this.d.getDrawableState());
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.e != null) {
            int max = this.d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.d.getPaddingLeft(), (float) (this.d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void h() {
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.d);
            DrawableCompat.m(drawable, ViewCompat.z(this.d));
            if (drawable.isStateful()) {
                drawable.setState(this.d.getDrawableState());
            }
            f();
        }
        this.d.invalidate();
    }
}
