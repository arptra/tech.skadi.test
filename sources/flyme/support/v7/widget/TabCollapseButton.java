package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.v7.appcompat.R;

public class TabCollapseButton extends AppCompatImageView implements ViewPropertyAnimatorListener {
    private static final int ANIMATION_DURATION = 350;
    private static final Interpolator ANIMATION_INTERPOLATOR_ROTATION = PathInterpolatorCompat.a(0.18f, 0.367f, 0.0f, 1.0f);
    private boolean mCollapsed;
    private ViewPropertyAnimatorCompatSet mCurAnimator;
    private Matrix mMatrix;
    private OnTabCollapseButtonClickListener mTabCollapseButtonOnClickListener;

    public interface OnTabCollapseButtonClickListener {
        void onTabCollapseButtonOnClick(TabCollapseButton tabCollapseButton);
    }

    public TabCollapseButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateToState(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurAnimator;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        ViewPropertyAnimatorCompatSet createCollapseAnimation = createCollapseAnimation(z);
        this.mCurAnimator = createCollapseAnimation;
        createCollapseAnimation.h();
    }

    @CallSuper
    public ViewPropertyAnimatorCompatSet createCollapseAnimation(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        if (z) {
            ViewCompat.Q0(this, 180.0f);
            viewPropertyAnimatorCompat = ViewCompat.e(this).f(360.0f);
        } else {
            ViewCompat.Q0(this, 0.0f);
            viewPropertyAnimatorCompat = ViewCompat.e(this).f(180.0f);
        }
        viewPropertyAnimatorCompat.j(ANIMATION_INTERPOLATOR_ROTATION);
        viewPropertyAnimatorCompat.i(350);
        viewPropertyAnimatorCompatSet.c(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompatSet.g(this);
        return viewPropertyAnimatorCompatSet;
    }

    public boolean isCollapsed() {
        return this.mCollapsed;
    }

    public void onAnimationCancel(View view) {
    }

    public void onAnimationEnd(View view) {
        if (this.mCollapsed) {
            ViewCompat.Q0(this, 0.0f);
        }
    }

    public void onAnimationStart(View view) {
    }

    public void onCollapseClick() {
        OnTabCollapseButtonClickListener onTabCollapseButtonClickListener = this.mTabCollapseButtonOnClickListener;
        if (onTabCollapseButtonClickListener != null) {
            onTabCollapseButtonClickListener.onTabCollapseButtonOnClick(this);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setPivotX((float) (getMeasuredWidth() / 2));
        setPivotY((float) (getMeasuredHeight() / 2));
    }

    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        return true;
    }

    public void setCollapsed(boolean z) {
        if (this.mCollapsed != z) {
            this.mCollapsed = z;
            animateToState(z);
        }
    }

    public void setOnTabCollapseButtonClickListener(OnTabCollapseButtonClickListener onTabCollapseButtonClickListener) {
        this.mTabCollapseButtonOnClickListener = onTabCollapseButtonClickListener;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (getScaleType() == ImageView.ScaleType.MATRIX && this.mMatrix == null) {
            this.mMatrix = new Matrix();
        }
    }

    public void toggle() {
        setCollapsed(!this.mCollapsed);
    }

    public TabCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzTabContainerCollapseButtonStyle);
    }

    public TabCollapseButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCollapsed = true;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TabCollapseButton.this.onCollapseClick();
            }
        });
        setBackgroundDrawable((Drawable) null);
    }
}
