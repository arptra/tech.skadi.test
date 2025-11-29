package flyme.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingParent2;

public class FitsBottomContentLayout extends FitsWindowsContentLayout implements NestedScrollingParent2 {
    private boolean mActionBarOverlay;
    private boolean mInterceptNestedScroll;

    public FitsBottomContentLayout(Context context) {
        super(context);
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return (Build.VERSION.SDK_INT < 30 || this.mActionBarOverlay) ? super.dispatchApplyWindowInsets(windowInsets) : super.dispatchApplyWindowInsets(windowInsets.inset(0, windowInsets.getInsets(WindowInsets.Type.systemBars()).top, 0, 0));
    }

    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
    }

    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5) {
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i2) {
        return this.mInterceptNestedScroll;
    }

    public void onStopNestedScroll(@NonNull View view, int i) {
    }

    public void setActionBarOverlay(boolean z) {
        this.mActionBarOverlay = z;
    }

    public void setInterceptNestedScrollEnabled(boolean z) {
        this.mInterceptNestedScroll = z;
    }

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
