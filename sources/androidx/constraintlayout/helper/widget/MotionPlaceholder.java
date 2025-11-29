package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

public class MotionPlaceholder extends VirtualLayout {
    public Placeholder l;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.d = new Placeholder();
        w();
    }

    public void onMeasure(int i, int i2) {
        x(this.l, i, i2);
    }

    public void u(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray sparseArray) {
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

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
