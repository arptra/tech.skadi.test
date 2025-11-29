package flyme.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import com.here.posclient.PositionEstimate;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.ActionMode;

public class ActionBarContainer extends FrameLayout {
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    private boolean mIsCapsuleStyle;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    /* access modifiers changed from: private */
    public MzActionBarTabContainer mTabContainer;
    protected final TabsVisibilityAnimListener mTabsVisAnimListener;
    protected ViewPropertyAnimatorCompat mTabsVisibilityAnim;

    public class TabsVisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled = false;
        int mFinalVisibility;

        public TabsVisibilityAnimListener() {
        }

        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.mCanceled) {
                ActionBarContainer actionBarContainer = ActionBarContainer.this;
                actionBarContainer.mTabsVisibilityAnim = null;
                actionBarContainer.mTabContainer.setVisibility(this.mFinalVisibility);
            }
        }

        public void onAnimationStart(View view) {
            ActionBarContainer.this.mTabContainer.setVisibility(0);
            this.mCanceled = false;
        }

        public TabsVisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            ActionBarContainer.this.mTabsVisibilityAnim = viewPropertyAnimatorCompat;
            this.mFinalVisibility = i;
            return this;
        }
    }

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getMeasuredHeightWithMargins(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean isCollapsed(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mBackground;
        if (drawable != null && drawable.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
        Drawable drawable2 = this.mStackedBackground;
        if (drawable2 != null && drawable2.isStateful()) {
            this.mStackedBackground.setState(getDrawableState());
        }
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null && drawable3.isStateful()) {
            this.mSplitBackground.setState(getDrawableState());
        }
    }

    public MzActionBarTabContainer getTabContainer() {
        return this.mTabContainer;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mStackedBackground;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mIsTransitioning || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            flyme.support.v7.widget.MzActionBarTabContainer r6 = r5.mTabContainer
            r8 = 8
            r10 = 1
            r0 = 0
            if (r6 == 0) goto L_0x0013
            int r1 = r6.getVisibility()
            if (r1 == r8) goto L_0x0013
            r1 = r10
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r6 == 0) goto L_0x0039
            int r2 = r6.getVisibility()
            if (r2 == r8) goto L_0x0039
            int r8 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r6.getMeasuredHeight()
            int r4 = r2.leftMargin
            int r7 = r7 + r4
            int r3 = r8 - r3
            int r4 = r2.bottomMargin
            int r3 = r3 - r4
            int r2 = r2.rightMargin
            int r9 = r9 - r2
            int r8 = r8 - r4
            r6.layout(r7, r3, r9, r8)
        L_0x0039:
            boolean r7 = r5.mIsSplit
            if (r7 == 0) goto L_0x0051
            android.graphics.drawable.Drawable r6 = r5.mSplitBackground
            if (r6 == 0) goto L_0x004e
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            r6.setBounds(r0, r0, r7, r8)
            goto L_0x00cd
        L_0x004e:
            r10 = r0
            goto L_0x00cd
        L_0x0051:
            android.graphics.drawable.Drawable r7 = r5.mBackground
            if (r7 == 0) goto L_0x009d
            android.view.View r7 = r5.mActionBarView
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x0075
            android.graphics.drawable.Drawable r7 = r5.mBackground
            android.view.View r8 = r5.mActionBarView
            int r8 = r8.getLeft()
            android.view.View r9 = r5.mActionBarView
            int r9 = r9.getRight()
            android.view.View r2 = r5.mActionBarView
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L_0x009c
        L_0x0075:
            android.view.View r7 = r5.mContextView
            if (r7 == 0) goto L_0x0097
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x0097
            android.graphics.drawable.Drawable r7 = r5.mBackground
            android.view.View r8 = r5.mContextView
            int r8 = r8.getLeft()
            android.view.View r9 = r5.mContextView
            int r9 = r9.getRight()
            android.view.View r2 = r5.mContextView
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L_0x009c
        L_0x0097:
            android.graphics.drawable.Drawable r7 = r5.mBackground
            r7.setBounds(r0, r0, r0, r0)
        L_0x009c:
            r0 = r10
        L_0x009d:
            r5.mIsStacked = r1
            if (r1 == 0) goto L_0x004e
            android.graphics.drawable.Drawable r7 = r5.mStackedBackground
            if (r7 == 0) goto L_0x004e
            android.graphics.drawable.Drawable r7 = r5.mBackground
            if (r7 == 0) goto L_0x00b8
            boolean r8 = r7 instanceof android.graphics.drawable.ColorDrawable
            if (r8 == 0) goto L_0x00b8
            android.graphics.drawable.ColorDrawable r7 = (android.graphics.drawable.ColorDrawable) r7
            int r7 = r7.getColor()
            android.graphics.drawable.Drawable r8 = r5.mStackedBackground
            r8.setTint(r7)
        L_0x00b8:
            android.graphics.drawable.Drawable r7 = r5.mStackedBackground
            int r8 = r6.getLeft()
            int r9 = r6.getTop()
            int r0 = r6.getRight()
            int r6 = r6.getBottom()
            r7.setBounds(r8, r9, r0, r6)
        L_0x00cd:
            if (r10 == 0) goto L_0x00d2
            r5.invalidate()
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i, int i2) {
        int i3;
        if (this.mActionBarView == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.mHeight) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3 + getPaddingBottom() + getPaddingTop(), View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        int i4 = 0;
        if (this.mIsSplit && getMeasuredHeight() == getPaddingBottom() + getPaddingTop()) {
            setMeasuredDimension(getMeasuredWidth(), 0);
        }
        if (this.mActionBarView != null) {
            int mode = View.MeasureSpec.getMode(i2);
            MzActionBarTabContainer mzActionBarTabContainer = this.mTabContainer;
            if (mzActionBarTabContainer != null && mzActionBarTabContainer.getVisibility() != 8 && mode != 1073741824) {
                if (!isCollapsed(this.mActionBarView)) {
                    i4 = getMeasuredHeightWithMargins(this.mActionBarView);
                } else if (!isCollapsed(this.mContextView)) {
                    i4 = getMeasuredHeightWithMargins(this.mContextView);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + getMeasuredHeightWithMargins(this.mTabContainer) + getPaddingTop() + getPaddingBottom(), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCapsuleStyleEnable(boolean z) {
        this.mIsCapsuleStyle = z;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.mBackground;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mBackground);
        }
        this.mBackground = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.mActionBarView;
            if (view != null) {
                this.mBackground.setBounds(view.getLeft(), 0, this.mActionBarView.getRight(), this.mActionBarView.getBottom());
            }
        }
        if (!this.mIsSplit ? this.mBackground == null && this.mStackedBackground == null : this.mSplitBackground == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mSplitBackground);
        }
        this.mSplitBackground = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsSplit && (drawable2 = this.mSplitBackground) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.mIsSplit ? this.mBackground == null && this.mStackedBackground == null : this.mSplitBackground == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        MzActionBarTabContainer mzActionBarTabContainer;
        Drawable drawable3 = this.mStackedBackground;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mStackedBackground);
        }
        this.mStackedBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (!(!this.mIsStacked || (drawable2 = this.mStackedBackground) == null || (mzActionBarTabContainer = this.mTabContainer) == null)) {
                drawable2.setBounds(mzActionBarTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
            }
        }
        boolean z = false;
        if (!this.mIsSplit ? this.mBackground == null && this.mStackedBackground == null : this.mSplitBackground == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        MzActionBarTabContainer mzActionBarTabContainer = this.mTabContainer;
        if (mzActionBarTabContainer != null) {
            removeView(mzActionBarTabContainer);
        }
        if (this.mTabContainer == null && scrollingTabContainerView != null) {
            this.mTabContainer = new MzActionBarTabContainer(getContext());
        }
        if (scrollingTabContainerView != null) {
            this.mTabContainer.setTabView(scrollingTabContainerView);
            addView(this.mTabContainer);
            ViewGroup.LayoutParams layoutParams = this.mTabContainer.getLayoutParams();
            this.mTabContainer.showAtToolbar(false);
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
            this.mTabContainer.setCapsuleStyleEnable(this.mIsCapsuleStyle);
            return;
        }
        MzActionBarTabContainer mzActionBarTabContainer2 = this.mTabContainer;
        if (mzActionBarTabContainer2 != null) {
            mzActionBarTabContainer2.setTabView((ScrollingTabContainerView) null);
            this.mTabContainer = null;
        }
    }

    public void setTransitioning(boolean z) {
        this.mIsTransitioning = z;
        setDescendantFocusability(z ? 393216 : PositionEstimate.Value.BUILDING_NAME);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.mStackedBackground;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ViewPropertyAnimatorCompat setupTabsAnimatorToVisibility(int i, long j) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.mTabsVisibilityAnim;
        if (viewPropertyAnimatorCompat2 != null) {
            viewPropertyAnimatorCompat2.c();
        }
        if (i == this.mTabContainer.getVisibility()) {
            return null;
        }
        if (i == 0) {
            if (this.mTabContainer.getVisibility() != 0) {
                ViewCompat.y0(this.mTabContainer, 0.0f);
                Drawable drawable = this.mStackedBackground;
                if (drawable != null) {
                    drawable.setAlpha(0);
                    invalidate();
                }
            }
            viewPropertyAnimatorCompat = ViewCompat.e(this.mTabContainer).b(1.0f);
        } else {
            viewPropertyAnimatorCompat = ViewCompat.e(this.mTabContainer).b(0.0f);
        }
        viewPropertyAnimatorCompat.i(j);
        if (this.mStackedBackground != null) {
            viewPropertyAnimatorCompat.n(new ViewPropertyAnimatorUpdateListener() {
                public void onAnimationUpdate(View view) {
                    ActionBarContainer.this.mStackedBackground.setAlpha((int) (view.getAlpha() * 255.0f));
                    ActionBarContainer.this.invalidate();
                }
            });
        }
        viewPropertyAnimatorCompat.k(this.mTabsVisAnimListener.withFinalVisibility(viewPropertyAnimatorCompat, i));
        return viewPropertyAnimatorCompat;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.mBackground && !this.mIsSplit) || (drawable == this.mStackedBackground && this.mIsStacked) || ((drawable == this.mSplitBackground && this.mIsSplit) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabsVisAnimListener = new TabsVisibilityAnimListener();
        setBackgroundDrawable(new ActionBarBackgroundDrawableV21(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_background);
        this.mStackedBackground = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R.id.split_action_bar) {
            this.mIsSplit = true;
            this.mSplitBackground = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.mIsSplit ? !(this.mBackground == null && this.mStackedBackground == null) : this.mSplitBackground != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public flyme.support.v7.view.ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }
}
