package com.scwang.smart.refresh.classics;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.scwang.smart.drawable.PaintDrawable;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.footer.classics.R;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import com.scwang.smart.refresh.layout.util.SmartUtil;

public abstract class ClassicsAbstract<T extends ClassicsAbstract<?>> extends SimpleComponent implements RefreshComponent {
    public static final int q = R.id.srl_classics_title;
    public static final int r = R.id.srl_classics_arrow;
    public static final int s = R.id.srl_classics_progress;
    public TextView d;
    public ImageView e;
    public ImageView f;
    public RefreshKernel g;
    public PaintDrawable h;
    public PaintDrawable i;
    public boolean j;
    public boolean k;
    public int l;
    public int m = 500;
    public int n = 20;
    public int o = 20;
    public int p = 0;

    public ClassicsAbstract(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = SpinnerStyle.d;
    }

    public void b(RefreshLayout refreshLayout, int i2, int i3) {
        ImageView imageView = this.f;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Drawable drawable = this.f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000);
            }
        }
    }

    public void c(RefreshLayout refreshLayout, int i2, int i3) {
        b(refreshLayout, i2, i3);
    }

    public int f(RefreshLayout refreshLayout, boolean z) {
        ImageView imageView = this.f;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0);
        }
        imageView.setVisibility(8);
        return this.m;
    }

    public void g(RefreshKernel refreshKernel, int i2, int i3) {
        this.g = refreshKernel;
        refreshKernel.e(this, this.l);
    }

    public ClassicsAbstract i() {
        return this;
    }

    public ClassicsAbstract j(int i2) {
        this.j = true;
        this.d.setTextColor(i2);
        PaintDrawable paintDrawable = this.h;
        if (paintDrawable != null) {
            paintDrawable.a(i2);
            this.e.invalidateDrawable(this.h);
        }
        PaintDrawable paintDrawable2 = this.i;
        if (paintDrawable2 != null) {
            paintDrawable2.a(i2);
            this.f.invalidateDrawable(this.i);
        }
        return i();
    }

    public ClassicsAbstract k(int i2) {
        this.k = true;
        this.l = i2;
        RefreshKernel refreshKernel = this.g;
        if (refreshKernel != null) {
            refreshKernel.e(this, i2);
        }
        return i();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.e;
        ImageView imageView2 = this.f;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Drawable drawable = this.f.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        if (this.p == 0) {
            this.n = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.o = paddingBottom;
            if (this.n == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i4 = this.n;
                if (i4 == 0) {
                    i4 = SmartUtil.c(20.0f);
                }
                this.n = i4;
                int i5 = this.o;
                if (i5 == 0) {
                    i5 = SmartUtil.c(20.0f);
                }
                this.o = i5;
                setPadding(paddingLeft, this.n, paddingRight, i5);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            int size = View.MeasureSpec.getSize(i3);
            int i6 = this.p;
            if (size < i6) {
                int i7 = (size - i6) / 2;
                setPadding(getPaddingLeft(), i7, getPaddingRight(), i7);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.n, getPaddingRight(), this.o);
        }
        super.onMeasure(i2, i3);
        if (this.p == 0) {
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                int measuredHeight = getChildAt(i8).getMeasuredHeight();
                if (this.p < measuredHeight) {
                    this.p = measuredHeight;
                }
            }
        }
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.k) {
                k(iArr[0]);
                this.k = false;
            }
            if (!this.j) {
                if (iArr.length > 1) {
                    j(iArr[1]);
                }
                this.j = false;
            }
        }
    }
}
