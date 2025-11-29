package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

public class Flow extends VirtualLayout {
    public androidx.constraintlayout.core.widgets.Flow l;

    public Flow(Context context) {
        super(context);
    }

    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.l = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.l.H2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.l.M1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.l.R1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.l.O1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.l.P1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.l.S1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.l.Q1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.l.N1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.l.M2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.l.B2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.l.L2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.l.v2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.l.D2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.l.x2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.l.F2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.l.z2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.l.u2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.l.C2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.l.w2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.l.E2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.l.J2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.l.y2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.l.I2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.l.A2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.l.K2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.l.G2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.d = this.l;
        w();
    }

    public void onMeasure(int i, int i2) {
        x(this.l, i, i2);
    }

    public void p(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        super.p(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i = layoutParams.Z;
            if (i != -1) {
                flow.H2(i);
            }
        }
    }

    public void q(ConstraintWidget constraintWidget, boolean z) {
        this.l.x1(z);
    }

    public void setFirstHorizontalBias(float f) {
        this.l.u2(f);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.l.v2(i);
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.l.w2(f);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.l.x2(i);
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.l.y2(i);
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.l.z2(f);
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.l.A2(i);
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.l.B2(i);
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.l.C2(f);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.l.D2(i);
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.l.E2(f);
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.l.F2(i);
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.l.G2(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        this.l.H2(i);
        requestLayout();
    }

    public void setPadding(int i) {
        this.l.M1(i);
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.l.N1(i);
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.l.P1(i);
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.l.Q1(i);
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.l.S1(i);
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.l.I2(i);
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.l.J2(f);
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.l.K2(i);
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.l.L2(i);
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.l.M2(i);
        requestLayout();
    }

    public void x(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (virtualLayout != null) {
            virtualLayout.G1(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.B1(), virtualLayout.A1());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
