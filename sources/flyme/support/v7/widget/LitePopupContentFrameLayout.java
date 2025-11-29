package flyme.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LitePopupContentFrameLayout extends FrameLayout {
    private int mLimitHeight;

    public LitePopupContentFrameLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void onMeasure(int i, int i2) {
        if (this.mLimitHeight != -1) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mLimitHeight, mode));
            if (mode == 1073741824) {
                setMeasuredDimension(getMeasuredWidth(), size);
                return;
            }
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setLimitHeight(int i) {
        this.mLimitHeight = i;
    }

    public LitePopupContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LitePopupContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLimitHeight = -1;
    }
}
