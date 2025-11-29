package com.meizu.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.honey.account.u2.c;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;
import java.lang.reflect.InvocationTargetException;

public class PageIndicator extends LinearLayout {
    private static final int ANIMATION_DURATION_MS = 200;
    private static final float DEFAULT_ITEM_SIZE_DP = 6.0f;
    private static final float DEFAULT_ITEM_SPACING_DP = 10.0f;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final float INTERPOLATOR_CONTROL_POINT1_X = 0.33f;
    private static final float INTERPOLATOR_CONTROL_POINT1_Y = 0.0f;
    private static final float INTERPOLATOR_CONTROL_POINT2_X = 0.67f;
    private static final float INTERPOLATOR_CONTROL_POINT2_Y = 1.0f;
    private int mDefaultIndicatorColor;
    private int mDefaultItemDrawableResId;
    private int mItemCount;
    private int mItemSize;
    private int mItemSpacing;
    private int mSelectedIndicatorColor;
    private int mSelectedItemDrawableResId;
    private int mSelectedItemPosition;

    public PageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    @RequiresApi
    private ValueAnimator createColorTransitionAnimation(View view, int i, int i2) {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(new int[]{i, i2});
        ofArgb.setDuration(200);
        ofArgb.setInterpolator(new PathInterpolator(INTERPOLATOR_CONTROL_POINT1_X, INTERPOLATOR_CONTROL_POINT1_Y, INTERPOLATOR_CONTROL_POINT2_X, 1.0f));
        ofArgb.addUpdateListener(new c(view));
        return ofArgb;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageIndicator, i, 0);
        this.mItemSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PageIndicator_indicatorItemSize, ResourceUtils.dp2pxOffset(context, DEFAULT_ITEM_SIZE_DP));
        this.mItemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PageIndicator_indicatorItemSpacing, ResourceUtils.dp2pxOffset(context, DEFAULT_ITEM_SPACING_DP));
        this.mSelectedItemDrawableResId = obtainStyledAttributes.getResourceId(R.styleable.PageIndicator_indicatorSelectedItemDrawable, R.drawable.mz_selected_page_indicator);
        this.mDefaultItemDrawableResId = obtainStyledAttributes.getResourceId(R.styleable.PageIndicator_indicatorDefaultItemDrawable, R.drawable.mz_default_page_indicator);
        this.mSelectedIndicatorColor = obtainStyledAttributes.getColor(R.styleable.PageIndicator_indicatorSelectedColor, -1);
        this.mDefaultIndicatorColor = obtainStyledAttributes.getColor(R.styleable.PageIndicator_indicatorDefaultColor, -1);
        if (obtainStyledAttributes.getInt(R.styleable.PageIndicator_indicatorOrientation, 0) != 0) {
            i2 = 1;
        }
        setOrientation(i2);
        obtainStyledAttributes.recycle();
        try {
            View.class.getDeclaredMethod("actInMzNightMode", new Class[]{Integer.TYPE}).invoke(this, new Object[]{2});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        populateIndicators();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createColorTransitionAnimation$0(View view, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(intValue);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(intValue);
        } else if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(intValue);
        } else if (background instanceof VectorDrawable) {
            Drawable r = DrawableCompat.r((VectorDrawable) background);
            DrawableCompat.n(r, intValue);
            r.mutate();
            view.setBackground(r);
        } else if (background != null) {
            background.setColorFilter(new PorterDuffColorFilter(intValue, PorterDuff.Mode.SRC_IN));
        }
        view.invalidate();
    }

    private void populateIndicators() {
        removeAllViews();
        int i = this.mSelectedIndicatorColor;
        if (i == 0) {
            i = ContextCompat.getColor(getContext(), R.color.mz_page_indicator_selected);
        }
        int i2 = this.mDefaultIndicatorColor;
        if (i2 == 0) {
            i2 = ContextCompat.getColor(getContext(), R.color.mz_page_indicator_default);
        }
        int i3 = 0;
        while (i3 < this.mItemCount) {
            View view = new View(getContext());
            boolean z = i3 == this.mSelectedItemPosition;
            view.setBackgroundResource(z ? this.mSelectedItemDrawableResId : this.mDefaultItemDrawableResId);
            createColorTransitionAnimation(view, z ? i2 : i, z ? i : i2).start();
            view.setSelected(z);
            int i4 = this.mItemSize;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            if (getOrientation() != 0) {
                layoutParams.topMargin = i3 == 0 ? 0 : this.mItemSpacing;
            } else if (i3 != 0) {
                layoutParams.setMarginStart(this.mItemSpacing);
            }
            addView(view, layoutParams);
            i3++;
        }
    }

    public int getDefaultIndicatorColor() {
        return this.mDefaultIndicatorColor;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int getSelectedIndicatorColor() {
        return this.mSelectedIndicatorColor;
    }

    public int getSelectedItemPosition() {
        return this.mSelectedItemPosition;
    }

    public void setDefaultIndicatorColor(int i) {
        this.mDefaultIndicatorColor = i;
        populateIndicators();
    }

    public void setItemCount(int i) {
        this.mItemCount = i;
        populateIndicators();
    }

    public void setSelectedIndicatorColor(int i) {
        this.mSelectedIndicatorColor = i;
        populateIndicators();
    }

    public void setSelectedItemPosition(int i) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = this.mSelectedIndicatorColor;
            if (i2 == 0) {
                i2 = ContextCompat.getColor(getContext(), R.color.mz_page_indicator_selected);
            }
            int i3 = this.mDefaultIndicatorColor;
            if (i3 == 0) {
                i3 = ContextCompat.getColor(getContext(), R.color.mz_page_indicator_default);
            }
            View childAt = getChildAt(this.mSelectedItemPosition);
            if (childAt != null) {
                childAt.setSelected(false);
                createColorTransitionAnimation(childAt, i2, i3).start();
            }
            this.mSelectedItemPosition = i;
            View childAt2 = getChildAt(i);
            if (childAt2 != null) {
                childAt2.setSelected(true);
                createColorTransitionAnimation(childAt2, i3, i2).start();
            }
        }
    }

    public PageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzPageIndicatorStyle);
    }

    public PageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }
}
