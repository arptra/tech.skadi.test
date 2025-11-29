package flyme.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo
public class FlymeAlertDialogLayout extends LinearLayoutCompat {
    private Context mContext;
    private int mMaxHeight;

    public FlymeAlertDialogLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int dp2px(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private boolean tryOnMeasure(int i, int i2) {
        int id;
        int i3 = i;
        int i4 = i2;
        int childCount = getChildCount();
        View view = null;
        boolean z = false;
        int i5 = 0;
        while (true) {
            int i6 = 8;
            if (i5 < childCount) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8 && ((id = childAt.getId()) == R.id.contentPanel || id == R.id.customPanel)) {
                    if (view != null) {
                        return false;
                    }
                    view = childAt;
                }
                i5++;
            } else if (view == null) {
                return false;
            } else {
                int min = Math.min(this.mMaxHeight, View.MeasureSpec.getSize(i2));
                int mode = View.MeasureSpec.getMode(i);
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int i7 = min - paddingTop;
                int childCount2 = getChildCount();
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    boolean z2 = true;
                    if (i8 < childCount2) {
                        View childAt2 = getChildAt(i8);
                        if (childAt2.getVisibility() == i6 || childAt2 == view) {
                            z = false;
                        } else {
                            if (childAt2.getLayoutParams().height == -1) {
                                childAt2.measure(i3, View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
                            } else if (childAt2.getLayoutParams().height == -2) {
                                if (this.mContext.getResources().getConfiguration().orientation != 2) {
                                    z2 = false;
                                }
                                if (childAt2.getId() == R.id.topPanel && z2) {
                                    i7 = this.mContext.getResources().getDimensionPixelOffset(flyme.support.v7.appcompat.R.dimen.mz_alert_dialog_top_panel_max_height);
                                }
                                if (childAt2.getId() == R.id.buttonPanel && z2) {
                                    i7 = this.mContext.getResources().getDimensionPixelOffset(flyme.support.v7.appcompat.R.dimen.mz_alert_dialog_button_bar_max_height);
                                }
                                childAt2.measure(i3, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                            } else {
                                childAt2.measure(i3, View.MeasureSpec.makeMeasureSpec(childAt2.getLayoutParams().height, 1073741824));
                            }
                            paddingTop += childAt2.getMeasuredHeight();
                            int i10 = min - paddingTop;
                            i9 = View.combineMeasuredStates(i9, childAt2.getMeasuredState());
                            z = false;
                            if (i10 <= 0) {
                                return false;
                            }
                            i7 = i10;
                        }
                        i8++;
                        i6 = 8;
                    } else {
                        view.measure(i3, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                        if (view.getMeasuredHeight() > i7) {
                            return z;
                        }
                        int measuredHeight = paddingTop + view.getMeasuredHeight();
                        int combineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                        int i11 = 0;
                        for (int i12 = 0; i12 < childCount; i12++) {
                            View childAt3 = getChildAt(i12);
                            if (childAt3.getVisibility() != 8) {
                                i11 = Math.max(i11, childAt3.getMeasuredWidth());
                            }
                        }
                        setMeasuredDimension(View.resolveSizeAndState(i11 + getPaddingLeft() + getPaddingRight(), i3, combineMeasuredStates), View.resolveSizeAndState(measuredHeight, i4, 0));
                        if (mode != 1073741824) {
                            forceUniformWidth(childCount, i4);
                        }
                        return true;
                    }
                }
            }
        }
    }

    public void onMeasure(int i, int i2) {
        if (!tryOnMeasure(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
        requestLayout();
    }

    public FlymeAlertDialogLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlymeAlertDialogLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mContext = context;
    }
}
