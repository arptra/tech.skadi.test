package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

public class MotionButton extends AppCompatButton {

    /* renamed from: a  reason: collision with root package name */
    public float f593a = 0.0f;
    public float b = Float.NaN;
    public Path c;
    public ViewOutlineProvider d;
    public RectF e;

    public MotionButton(Context context) {
        super(context);
        c(context, (AttributeSet) null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.b;
    }

    public float getRoundPercent() {
        return this.f593a;
    }

    @RequiresApi
    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.b = f;
            float f2 = this.f593a;
            this.f593a = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.b != f;
        this.b = f;
        if (f != 0.0f) {
            if (this.c == null) {
                this.c = new Path();
            }
            if (this.e == null) {
                this.e = new RectF();
            }
            if (this.d == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.b);
                    }
                };
                this.d = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.e.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.c.reset();
            Path path = this.c;
            RectF rectF = this.e;
            float f3 = this.b;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi
    public void setRoundPercent(float f) {
        boolean z = this.f593a != f;
        this.f593a = f;
        if (f != 0.0f) {
            if (this.c == null) {
                this.c = new Path();
            }
            if (this.e == null) {
                this.e = new RectF();
            }
            if (this.d == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionButton.this.getWidth();
                        int height = MotionButton.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionButton.this.f593a) / 2.0f);
                    }
                };
                this.d = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f593a) / 2.0f;
            this.e.set(0.0f, 0.0f, (float) width, (float) height);
            this.c.reset();
            this.c.addRoundRect(this.e, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }
}
