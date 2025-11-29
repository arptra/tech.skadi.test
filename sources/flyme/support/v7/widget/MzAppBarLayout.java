package flyme.support.v7.widget;

import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.FlymeAppBarBehavior;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.MzRecyclerView;
import java.lang.reflect.Field;

public class MzAppBarLayout extends AppBarLayout implements MzRecyclerView.OverScrollListener {
    private final float MIN_OVER_SCROLL;
    private final String TAG;
    private ViewGroup mActionBarContainer;
    Drawable mBackground;
    private FlymeAppBarBehavior mFlymeAppBarBehavior;
    Drawable mStackedBackground;
    private MzActionBarTabContainer mTabContainer;
    private View springLayoutMiddle;
    private View springLayoutQuick;

    public static class AppbarValueAnimator extends ValueAnimator {
        private int[] offsetValues;

        public int[] getOffsetValues() {
            return this.offsetValues;
        }

        public void setIntValues(int... iArr) {
            this.offsetValues = iArr;
            super.setIntValues(iArr);
        }
    }

    public MzAppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initView() {
        setWillNotDraw(false);
        this.mActionBarContainer = (ViewGroup) findViewById(R.id.action_bar_container);
        this.springLayoutMiddle = findViewById(R.id.action_bar_spring_layout_middle);
        this.springLayoutQuick = findViewById(R.id.action_bar_spring_layout_quick);
    }

    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Field field = null;
        try {
            field = getClass().getSuperclass().getDeclaredField("behavior");
            field.setAccessible(true);
            Log.i(" [MzAppBarLayout] ", "getBehavior find success");
        } catch (Exception e) {
            Log.e(" [MzAppBarLayout] ", "getBehavior:" + e);
        }
        FlymeAppBarBehavior flymeAppBarBehavior = new FlymeAppBarBehavior();
        if (field != null) {
            try {
                field.set(this, flymeAppBarBehavior);
            } catch (Exception e2) {
                Log.e(" [MzAppBarLayout] ", "getBehavior field set:" + e2);
            }
        }
        this.mFlymeAppBarBehavior = flymeAppBarBehavior;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof CoordinatorLayout)) {
            flymeAppBarBehavior.initLayout((CoordinatorLayout) parent, this);
        }
        return flymeAppBarBehavior;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setWillNotDraw(false);
        initView();
    }

    public void onOverScroll(View view, float f, float f2) {
        if (f2 >= 16.0f && this.mFlymeAppBarBehavior != null) {
            this.springLayoutMiddle.setTranslationY(0.1f * f2);
            this.springLayoutQuick.setTranslationY(f2 * 0.13f);
        }
    }

    public void onOverScrollStateChanged(View view, int i) {
        Log.i(" [MzAppBarLayout] ", "onOverScrollStateChanged: " + i);
        if (i == 0) {
            this.mFlymeAppBarBehavior.setTitleOverScrollY(0.0f);
            ViewGroup viewGroup = this.mActionBarContainer;
            if (viewGroup != null) {
                viewGroup.postInvalidate();
            }
        }
    }

    public void setPrimaryBackground(Drawable drawable) {
        ViewCompat.z0(this, drawable);
    }

    public void setStackedBackground(Drawable drawable) {
    }

    public void setTransitioning(boolean z) {
    }

    public ViewPropertyAnimatorCompat setupTabsAnimatorToVisibility(int i, long j) {
        return null;
    }

    public static class OverlayScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public OverlayScrollingViewBehavior() {
            init();
        }

        private void init() {
            setOverlayTop(90);
        }

        public OverlayScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init();
        }
    }

    public MzAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = " [MzAppBarLayout] ";
        this.MIN_OVER_SCROLL = 16.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_background);
        this.mStackedBackground = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_backgroundStacked);
        obtainStyledAttributes.recycle();
        ViewCompat.z0(this, this.mBackground);
        setStateListAnimator((StateListAnimator) null);
    }
}
