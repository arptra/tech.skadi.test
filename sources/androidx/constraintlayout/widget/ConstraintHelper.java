package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import com.meizu.common.widget.MzContactsContract;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {

    /* renamed from: a  reason: collision with root package name */
    public int[] f601a = new int[32];
    public int b;
    public Context c;
    public Helper d;
    public boolean e = false;
    public String f;
    public String g;
    public View[] h = null;
    public HashMap i = new HashMap();

    public ConstraintHelper(Context context) {
        super(context);
        this.c = context;
        o((AttributeSet) null);
    }

    public final void e(String str) {
        if (str != null && str.length() != 0 && this.c != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int m = m(trim);
            if (m != 0) {
                this.i.put(Integer.valueOf(m), trim);
                f(m);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    public final void f(int i2) {
        if (i2 != getId()) {
            int i3 = this.b + 1;
            int[] iArr = this.f601a;
            if (i3 > iArr.length) {
                this.f601a = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f601a;
            int i4 = this.b;
            iArr2[i4] = i2;
            this.b = i4 + 1;
        }
    }

    public final void g(String str) {
        if (str != null && str.length() != 0 && this.c != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = constraintLayout.getChildAt(i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).c0)) {
                    if (childAt.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                    } else {
                        f(childAt.getId());
                    }
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f601a, this.b);
    }

    public void h() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            i((ConstraintLayout) parent);
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i2 = 0; i2 < this.b; i2++) {
            View viewById = constraintLayout.getViewById(this.f601a[i2]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public final int[] k(View view, String str) {
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        for (String trim : split) {
            int m = m(trim.trim());
            if (m != 0) {
                iArr[i2] = m;
                i2++;
            }
        }
        return i2 != split.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public final int l(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int m(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i2 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i2 = ((Integer) designInformation).intValue();
            }
        }
        if (i2 == 0 && constraintLayout != null) {
            i2 = l(constraintLayout, str);
        }
        if (i2 == 0) {
            try {
                i2 = R.id.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? this.c.getResources().getIdentifier(str, "id", this.c.getPackageName()) : i2;
    }

    public View[] n(ConstraintLayout constraintLayout) {
        View[] viewArr = this.h;
        if (viewArr == null || viewArr.length != this.b) {
            this.h = new View[this.b];
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            this.h[i2] = constraintLayout.getViewById(this.f601a[i2]);
        }
        return this.h;
    }

    public void o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i2, int i3) {
        if (this.e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        ConstraintSet.Layout layout = constraint.e;
        int[] iArr = layout.k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.l0;
            if (str != null) {
                if (str.length() > 0) {
                    ConstraintSet.Layout layout2 = constraint.e;
                    layout2.k0 = k(this, layout2.l0);
                } else {
                    constraint.e.k0 = null;
                }
            }
        }
        if (helperWidget != null) {
            helperWidget.b();
            if (constraint.e.k0 != null) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = constraint.e.k0;
                    if (i2 < iArr2.length) {
                        ConstraintWidget constraintWidget = (ConstraintWidget) sparseArray.get(iArr2[i2]);
                        if (constraintWidget != null) {
                            helperWidget.a(constraintWidget);
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void q(ConstraintWidget constraintWidget, boolean z) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
    }

    public void setIds(String str) {
        this.f = str;
        if (str != null) {
            int i2 = 0;
            this.b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    e(str.substring(i2));
                    return;
                } else {
                    e(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferenceTags(String str) {
        this.g = str;
        if (str != null) {
            int i2 = 0;
            this.b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    g(str.substring(i2));
                    return;
                } else {
                    g(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f = null;
        this.b = 0;
        for (int f2 : iArr) {
            f(f2);
        }
    }

    public void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.f == null) {
            f(i2);
        }
    }

    public void t(ConstraintLayout constraintLayout) {
    }

    public void u(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray sparseArray) {
        helper.b();
        for (int i2 = 0; i2 < this.b; i2++) {
            helper.a((ConstraintWidget) sparseArray.get(this.f601a[i2]));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = (java.lang.String) r5.i.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.f
            r5.setIds(r0)
        L_0x000b:
            androidx.constraintlayout.core.widgets.Helper r0 = r5.d
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.b()
            r0 = 0
        L_0x0014:
            int r1 = r5.b
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.f601a
            r1 = r1[r0]
            android.view.View r2 = r6.getViewById(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap r3 = r5.i
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.l(r6, r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.f601a
            r2[r0] = r3
            java.util.HashMap r2 = r5.i
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.getViewById(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            androidx.constraintlayout.core.widgets.Helper r1 = r5.d
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r6.getViewWidget(r2)
            r1.a(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            androidx.constraintlayout.core.widgets.Helper r5 = r5.d
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r6.mLayoutWidget
            r5.c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.v(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public void w() {
        if (this.d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).v0 = (ConstraintWidget) this.d;
            }
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = context;
        o(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = context;
        o(attributeSet);
    }
}
