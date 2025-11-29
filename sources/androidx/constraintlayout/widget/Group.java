package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.e = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    public void r(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.v0.o1(0);
        layoutParams.v0.P0(0);
    }

    public void setElevation(float f) {
        super.setElevation(f);
        h();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        h();
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
