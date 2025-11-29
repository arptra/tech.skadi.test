package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class Layer extends ConstraintHelper {
    public boolean A;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public ConstraintLayout m;
    public float n = 1.0f;
    public float o = 1.0f;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public float r = Float.NaN;
    public float s = Float.NaN;
    public float t = Float.NaN;
    public float u = Float.NaN;
    public boolean v = true;
    public View[] w = null;
    public float x = 0.0f;
    public float y = 0.0f;
    public boolean z;

    public Layer(Context context) {
        super(context);
    }

    public void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.e = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.z = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = (ConstraintLayout) getParent();
        if (this.z || this.A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.b; i++) {
                View viewById = this.m.getViewById(this.f601a[i]);
                if (viewById != null) {
                    if (this.z) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.A && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void r(ConstraintLayout constraintLayout) {
        y();
        this.p = Float.NaN;
        this.q = Float.NaN;
        ConstraintWidget b = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        b.o1(0);
        b.P0(0);
        x();
        layout(((int) this.t) - getPaddingLeft(), ((int) this.u) - getPaddingTop(), ((int) this.r) + getPaddingRight(), ((int) this.s) + getPaddingBottom());
        z();
    }

    public void setElevation(float f) {
        super.setElevation(f);
        h();
    }

    public void setPivotX(float f) {
        this.j = f;
        z();
    }

    public void setPivotY(float f) {
        this.k = f;
        z();
    }

    public void setRotation(float f) {
        this.l = f;
        z();
    }

    public void setScaleX(float f) {
        this.n = f;
        z();
    }

    public void setScaleY(float f) {
        this.o = f;
        z();
    }

    public void setTranslationX(float f) {
        this.x = f;
        z();
    }

    public void setTranslationY(float f) {
        this.y = f;
        z();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        h();
    }

    public void t(ConstraintLayout constraintLayout) {
        this.m = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.l = rotation;
        } else if (!Float.isNaN(this.l)) {
            this.l = rotation;
        }
    }

    public void x() {
        if (this.m != null) {
            if (!this.v && !Float.isNaN(this.p) && !Float.isNaN(this.q)) {
                return;
            }
            if (Float.isNaN(this.j) || Float.isNaN(this.k)) {
                View[] n2 = n(this.m);
                int left = n2[0].getLeft();
                int top2 = n2[0].getTop();
                int right = n2[0].getRight();
                int bottom = n2[0].getBottom();
                for (int i = 0; i < this.b; i++) {
                    View view = n2[i];
                    left = Math.min(left, view.getLeft());
                    top2 = Math.min(top2, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.r = (float) right;
                this.s = (float) bottom;
                this.t = (float) left;
                this.u = (float) top2;
                if (Float.isNaN(this.j)) {
                    this.p = (float) ((left + right) / 2);
                } else {
                    this.p = this.j;
                }
                if (Float.isNaN(this.k)) {
                    this.q = (float) ((top2 + bottom) / 2);
                } else {
                    this.q = this.k;
                }
            } else {
                this.q = this.k;
                this.p = this.j;
            }
        }
    }

    public final void y() {
        int i;
        if (this.m != null && (i = this.b) != 0) {
            View[] viewArr = this.w;
            if (viewArr == null || viewArr.length != i) {
                this.w = new View[i];
            }
            for (int i2 = 0; i2 < this.b; i2++) {
                this.w[i2] = this.m.getViewById(this.f601a[i2]);
            }
        }
    }

    public final void z() {
        if (this.m != null) {
            if (this.w == null) {
                y();
            }
            x();
            double radians = Float.isNaN(this.l) ? 0.0d : Math.toRadians((double) this.l);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f = this.n;
            float f2 = f * cos;
            float f3 = this.o;
            float f4 = (-f3) * sin;
            float f5 = f * sin;
            float f6 = f3 * cos;
            for (int i = 0; i < this.b; i++) {
                View view = this.w[i];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.p;
                float top2 = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.q;
                view.setTranslationX((((f2 * left) + (f4 * top2)) - left) + this.x);
                view.setTranslationY((((left * f5) + (f6 * top2)) - top2) + this.y);
                view.setScaleY(this.o);
                view.setScaleX(this.n);
                if (!Float.isNaN(this.l)) {
                    view.setRotation(this.l);
                }
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
