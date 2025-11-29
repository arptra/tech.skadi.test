package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

public class CircularFlow extends VirtualLayout {
    public static int v;
    public static float w;
    public ConstraintLayout l;
    public int m;
    public float[] n;
    public int[] o;
    public int p;
    public int q;
    public String r;
    public String s;
    public Float t;
    public Integer u;

    public CircularFlow(Context context) {
        super(context);
    }

    private void setAngles(String str) {
        if (str != null) {
            int i = 0;
            this.q = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    y(str.substring(i).trim());
                    return;
                } else {
                    y(str.substring(i, indexOf).trim());
                    i = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i = 0;
            this.p = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    z(str.substring(i).trim());
                    return;
                } else {
                    z(str.substring(i, indexOf).trim());
                    i = indexOf + 1;
                }
            }
        }
    }

    public final void A() {
        this.l = (ConstraintLayout) getParent();
        for (int i = 0; i < this.b; i++) {
            View viewById = this.l.getViewById(this.f601a[i]);
            if (viewById != null) {
                int i2 = v;
                float f = w;
                int[] iArr = this.o;
                if (iArr == null || i >= iArr.length) {
                    Integer num = this.u;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + ((String) this.i.get(Integer.valueOf(viewById.getId()))));
                    } else {
                        this.p++;
                        if (this.o == null) {
                            this.o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.o = radius;
                        radius[this.p - 1] = i2;
                    }
                } else {
                    i2 = iArr[i];
                }
                float[] fArr = this.n;
                if (fArr == null || i >= fArr.length) {
                    Float f2 = this.t;
                    if (f2 == null || f2.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + ((String) this.i.get(Integer.valueOf(viewById.getId()))));
                    } else {
                        this.q++;
                        if (this.n == null) {
                            this.n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.n = angles;
                        angles[this.q - 1] = f;
                    }
                } else {
                    f = fArr[i];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.r = f;
                layoutParams.p = this.m;
                layoutParams.q = i2;
                viewById.setLayoutParams(layoutParams);
            }
        }
        h();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.n, this.q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.o, this.p);
    }

    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.m = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.r = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.s = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, w));
                    this.t = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, v));
                    this.u = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.r;
        if (str != null) {
            this.n = new float[1];
            setAngles(str);
        }
        String str2 = this.s;
        if (str2 != null) {
            this.o = new int[1];
            setRadius(str2);
        }
        Float f = this.t;
        if (f != null) {
            setDefaultAngle(f.floatValue());
        }
        Integer num = this.u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        A();
    }

    public void setDefaultAngle(float f) {
        w = f;
    }

    public void setDefaultRadius(int i) {
        v = i;
    }

    public final void y(String str) {
        float[] fArr;
        if (str != null && str.length() != 0 && this.c != null && (fArr = this.n) != null) {
            if (this.q + 1 > fArr.length) {
                this.n = Arrays.copyOf(fArr, fArr.length + 1);
            }
            this.n[this.q] = (float) Integer.parseInt(str);
            this.q++;
        }
    }

    public final void z(String str) {
        int[] iArr;
        if (str != null && str.length() != 0 && this.c != null && (iArr = this.o) != null) {
            if (this.p + 1 > iArr.length) {
                this.o = Arrays.copyOf(iArr, iArr.length + 1);
            }
            this.o[this.p] = (int) (((float) Integer.parseInt(str)) * this.c.getResources().getDisplayMetrics().density);
            this.p++;
        }
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
