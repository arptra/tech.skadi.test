package flyme.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.CollapsingToolbarLayout;
import flyme.support.v7.widget.ControlTitleBar;

public class MzCollapsingToolbarLayout extends CollapsingToolbarLayout {
    private ActionBarContextView mContextView;
    private ControlTitleBar mControlTitleBar;
    private int mCurOffset;
    private OffsetUpdateListener mInnerOnOffsetChangedListener;
    private WindowInsetsCompat mLastInsets;
    private TextView mMultiTitleView;
    private ControlTitleBar.OnTitleChangedListener mMultiTitleWatcher;
    /* access modifiers changed from: private */
    public ActionBar.OnOffsetChangedListener mOnOffsetChangedListener;
    /* access modifiers changed from: private */
    public ScrollingTabContainerView mTabView;
    private float mTitleAlpha;
    private CollapsingToolbarLayoutWrapper mWrapper;
    /* access modifiers changed from: private */
    public float mfraction;

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float unused = MzCollapsingToolbarLayout.this.mfraction = ((float) Math.abs(i)) / ((float) MzCollapsingToolbarLayout.this.getExpandRange());
            MzCollapsingToolbarLayout mzCollapsingToolbarLayout = MzCollapsingToolbarLayout.this;
            mzCollapsingToolbarLayout.updateAlpha(mzCollapsingToolbarLayout.mfraction);
            if (MzCollapsingToolbarLayout.this.mTabView != null) {
                float access$000 = 1.0f - (MzCollapsingToolbarLayout.this.mfraction * 0.27f);
                MzCollapsingToolbarLayout.this.mTabView.setScaleX(access$000);
                MzCollapsingToolbarLayout.this.mTabView.setScaleY(access$000);
            }
            if (MzCollapsingToolbarLayout.this.mOnOffsetChangedListener != null) {
                MzCollapsingToolbarLayout.this.mOnOffsetChangedListener.onOffsetChanged(i);
            }
        }
    }

    public MzCollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void updateAlpha(float f) {
        TextView textView = this.mMultiTitleView;
        if (textView != null) {
            float f2 = 0.0f;
            textView.setAlpha(f < 0.5f ? 0.0f : (f * 2.0f) - 1.0f);
            float f3 = 1.0f - f;
            CollapsingTextHelper collapsingTextHelper = this.mCollapsingTextHelper;
            if (f3 > 0.5f) {
                f2 = (f3 * 2.0f) - 1.0f;
            }
            collapsingTextHelper.setTextAlpha(f2);
        }
    }

    public void closeMode() {
        ScrollingTabContainerView scrollingTabContainerView = this.mTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setVisibility(0);
        }
        this.mCollapsingTextHelper.setText(getTitle());
        this.mCollapsingTextHelper.setTextAlpha(1.0f);
        ControlTitleBar controlTitleBar = this.mControlTitleBar;
        if (controlTitleBar != null) {
            controlTitleBar.removeOnTitleChangedListener(this.mMultiTitleWatcher);
        }
        this.mControlTitleBar = null;
        this.mMultiTitleView = null;
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        super.dispatchConfigurationChanged(configuration);
        ScrollingTabContainerView scrollingTabContainerView = this.mTabView;
        if (scrollingTabContainerView != null) {
            setTabLayout(scrollingTabContainerView);
            if (this.mMultiTitleView != null) {
                this.mTabView.setVisibility(8);
            }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateAlpha(this.mfraction);
    }

    public int getExpandRange() {
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        return (getHeight() - ViewCompat.B(this)) - (windowInsetsCompat != null ? windowInsetsCompat.l() : 0);
    }

    public CollapsingToolbarLayoutWrapper getWrapper(DecorToolbar decorToolbar) {
        if (this.mWrapper == null) {
            this.mWrapper = new CollapsingToolbarLayoutWrapper(this, decorToolbar);
        }
        return this.mWrapper;
    }

    public void initForMultiChoiceMode() {
        ActionBarContextView actionBarContextView = this.mContextView;
        if (actionBarContextView != null) {
            View customView = actionBarContextView.getCustomView();
            if (customView instanceof ControlTitleBar) {
                ControlTitleBar controlTitleBar = (ControlTitleBar) customView;
                this.mControlTitleBar = controlTitleBar;
                this.mMultiTitleView = controlTitleBar.getTitleView();
                this.mControlTitleBar.addOnTitleChangedListener(this.mMultiTitleWatcher);
            }
            ScrollingTabContainerView scrollingTabContainerView = this.mTabView;
            if (scrollingTabContainerView != null) {
                scrollingTabContainerView.setVisibility(8);
            }
            updateAlpha(this.mfraction);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.mInnerOnOffsetChangedListener == null) {
                this.mInnerOnOffsetChangedListener = new OffsetUpdateListener();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this.mInnerOnOffsetChangedListener);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mContextView = (ActionBarContextView) findViewById(R.id.action_context_bar);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        int l = windowInsetsCompat != null ? windowInsetsCompat.l() : 0;
        if (l > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + l, 1073741824));
        }
        ScrollingTabContainerView scrollingTabContainerView = this.mTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setPivotX((float) scrollingTabContainerView.getContentStart());
            ScrollingTabContainerView scrollingTabContainerView2 = this.mTabView;
            scrollingTabContainerView2.setPivotY(scrollingTabContainerView2.getContentBottom());
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        if (!ObjectsCompat.a(this.mLastInsets, windowInsetsCompat)) {
            this.mLastInsets = windowInsetsCompat;
            requestLayout();
        }
        return super.onWindowInsetChanged(windowInsetsCompat);
    }

    public void releaseTitleScale() {
        this.mCollapsingTextHelper.releaseTitleScale();
    }

    public void setOnOffsetChangedListener(ActionBar.OnOffsetChangedListener onOffsetChangedListener) {
        this.mOnOffsetChangedListener = onOffsetChangedListener;
    }

    public void setTabLayout(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.mTabView;
        if (scrollingTabContainerView2 != null && scrollingTabContainerView2.getParent() == this) {
            removeView(this.mTabView);
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.showAtToolbar(true);
            addView(this.mTabView);
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) this.mTabView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            Resources resources = getResources();
            layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.mz_tab_bar_margin_bottom_nested_scroll);
            this.mTabView.setPadding(resources.getDimensionPixelSize(R.dimen.mz_tab_bar_padding_left_nested_scroll), 0, 0, 0);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        ColorStateList valueOf = ColorStateList.valueOf(i);
        this.mCollapsingTextHelper.setCollapsedTextColor(valueOf);
        this.mCollapsingTextHelper.setExpandedTextColor(valueOf);
    }

    public void setTitleTextDrawParams(float f, float f2) {
        this.mCollapsingTextHelper.takeOverTitleScale();
        this.mCollapsingTextHelper.updateScaleValue(f);
        this.mCollapsingTextHelper.setTextPositionY(f2);
        requestLayout();
    }

    public MzCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzCollapsingToolbarLayoutStyle);
    }

    public MzCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleAlpha = 1.0f;
        this.mMultiTitleWatcher = new ControlTitleBar.OnTitleChangedListener() {
            public void onSubTitleChanged(CharSequence charSequence) {
            }

            public void onTitleChanged(CharSequence charSequence) {
                MzCollapsingToolbarLayout.this.mCollapsingTextHelper.setText(charSequence);
            }
        };
    }
}
