package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

public class AspectRatioTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    public final float f8772a;
    public final Rect b;
    public Paint c;
    public int d;
    public float e;
    public String f;
    public float g;
    public float h;

    public AspectRatioTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void b(int i) {
        Paint paint = this.c;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget)}));
    }

    public float c(boolean z) {
        if (z) {
            f();
            e();
        }
        return this.e;
    }

    public final void d(TypedArray typedArray) {
        setGravity(1);
        this.f = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.g = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f2 = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.h = f2;
        float f3 = this.g;
        if (f3 == 0.0f || f2 == 0.0f) {
            this.e = 0.0f;
        } else {
            this.e = f3 / f2;
        }
        this.d = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        e();
        b(getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    public final void e() {
        if (!TextUtils.isEmpty(this.f)) {
            setText(this.f);
        } else {
            setText(String.format(Locale.US, "%d:%d", new Object[]{Integer.valueOf((int) this.g), Integer.valueOf((int) this.h)}));
        }
    }

    public final void f() {
        if (this.e != 0.0f) {
            float f2 = this.g;
            float f3 = this.h;
            this.g = f3;
            this.h = f2;
            this.e = f3 / f2;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.b);
            Rect rect = this.b;
            float f2 = ((float) rect.bottom) - (((float) rect.top) / 2.0f);
            int i = this.d;
            canvas.drawCircle(((float) (rect.right - rect.left)) / 2.0f, f2 - (((float) i) * 1.5f), ((float) i) / 2.0f, this.c);
        }
    }

    public void setActiveColor(@ColorInt int i) {
        b(i);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.f = aspectRatio.getAspectRatioTitle();
        this.g = aspectRatio.getAspectRatioX();
        float aspectRatioY = aspectRatio.getAspectRatioY();
        this.h = aspectRatioY;
        float f2 = this.g;
        if (f2 == 0.0f || aspectRatioY == 0.0f) {
            this.e = 0.0f;
        } else {
            this.e = f2 / aspectRatioY;
        }
        e();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8772a = 1.5f;
        this.b = new Rect();
        d(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }
}
