package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {
    public static final boolean b = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f289a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    public final void a(Context context, AttributeSet attributeSet, int i, int i2) {
        TintTypedArray v = TintTypedArray.v(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (v.s(R.styleable.PopupWindow_overlapAnchor)) {
            b(v.a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(v.g(R.styleable.PopupWindow_android_popupBackground));
        v.w();
    }

    public final void b(boolean z) {
        if (b) {
            this.f289a = z;
        } else {
            PopupWindowCompat.b(this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (b && this.f289a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (b && this.f289a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (b && this.f289a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}
