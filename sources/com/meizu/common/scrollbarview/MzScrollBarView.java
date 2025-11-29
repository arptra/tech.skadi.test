package com.meizu.common.scrollbarview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.common.R;
import com.meizu.common.scrollview.MzNestedScrollView;
import com.meizu.common.scrollview.MzScrollView;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.util.VibrateUtil;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import flyme.support.v7.widget.MzRecyclerView;
import flyme.support.v7.widget.animations.SpringAnimationHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MzScrollBarView extends View {
    private static final boolean DEBUG = false;
    private static final int FADE_DELAY_DURATION = 2000;
    private static final int FADE_DURATION_DEFAULT = 500;
    private static final float FULL_OPAQUE = 255.0f;
    private static final float FULL_TRANSPARENT = 0.0f;
    private static final int HOTSPOT_THICKNESS = 30;
    private static final int RESTORE_DURATION = 250;
    private static final int SCALE_DELAY_DURATION = 0;
    private static final int SCALE_DURATION = 250;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "MZScrollBarView";
    private static final int THUMB_THICKNESS_DEFAULT = 2;
    private static final int THUMB_THICKNESS_SCALED = 6;
    private static final int VELOCITY_INCREASE_FACTOR = 2;
    private static final int VELOCITY_UNITS = 1000;
    private static final float epsilon = 1.0E-4f;
    /* access modifiers changed from: private */
    public static boolean isRTL = false;
    private static Method sComputeHorizontalScrollExtentMethod;
    private static Method sComputeHorizontalScrollOffsetMethod;
    private static Method sComputeHorizontalScrollRangeMethod;
    private static Method sComputeVerticalScrollExtentMethod;
    private static Method sComputeVerticalScrollOffsetMethod;
    private static Method sComputeVerticalScrollRangeMethod;
    /* access modifiers changed from: private */
    public static final Interpolator sScaleInterpolator = PathInterpolatorCompat.a(0.4f, FULL_TRANSPARENT, 0.2f, 1.0f);
    private List<OnScrollListener> listeners;
    private MzScrollBarBaseAdapter mAdapter;
    private boolean mFadeEnable;
    boolean mFingerOn;
    private boolean mFitSystemBottomPadding;
    private boolean mFitSystemTopPadding;
    private Handler mHandler;
    private int mHotSpotSize;
    private float mLastMotionX;
    private float mLastMotionY;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private boolean mOperable;
    private int mPointerIndex;
    private final ScaleAction mScaleAction;
    private boolean mScaledDelay;
    private MzScrollBarDrawable mScrollBarDrawable;
    private int mScrollBarDrawableScaledThickness;
    private int mScrollBarDrawableThickness;
    private final ScrollabilityCache mScrollCache;
    private int mScrollState;
    private View mScrollableView;
    private SpringAnimationHelper mSpringAnimation;
    private Drawable mThumbDrawable;
    private int mThumbDrawableTint;
    private Drawable mTrackDrawable;
    private int mTrackDrawableTint;
    private VelocityTracker mVelocityTracker;
    private boolean mVertical;

    public static abstract class Adapter {
        public abstract int getScrollBarVisibleFactor();

        @IntRange
        public abstract int getScrollDistanceByDraggingDelta(int i, int i2, int i3, int i4, int i5);

        @IntRange
        public abstract int getThumbLength(int i, int i2, int i3, int i4, int i5);

        @IntRange
        public abstract int getThumbOffset(int i, int i2, int i3, int i4, int i5, int i6);
    }

    public interface OnScrollListener {
        void onScrolled(MzScrollBarView mzScrollBarView, int i, int i2);

        void onStateChanged(MzScrollBarView mzScrollBarView, int i);
    }

    public static class ScaleAction implements Runnable {
        public static final int NORMAL = 0;
        public static final int SCALED = 2;
        public static final int SCALING = 1;
        private final View host;
        public boolean mRestore;
        private final MzScrollBarDrawable mzScrollBarDrawable;
        private final int normalThickness;
        public ValueAnimator scaleAnimator;
        public long scaleStartTime;
        private final int scaleThickness;
        public int state = 0;

        public ScaleAction(View view, int i, int i2, MzScrollBarDrawable mzScrollBarDrawable2) {
            this.host = view;
            this.normalThickness = i;
            this.scaleThickness = i2;
            this.mzScrollBarDrawable = mzScrollBarDrawable2;
        }

        private void initAnimator() {
            if (this.scaleAnimator == null) {
                this.scaleAnimator = new ValueAnimator();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(int i, ValueAnimator valueAnimator) {
            MzScrollBarDrawable mzScrollBarDrawable2 = this.mzScrollBarDrawable;
            mzScrollBarDrawable2.setBounds(i, mzScrollBarDrawable2.getBounds().top, ((Integer) valueAnimator.getAnimatedValue()).intValue() + i, this.mzScrollBarDrawable.getBounds().bottom);
        }

        public void releaseAnimation() {
            ValueAnimator valueAnimator = this.scaleAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.scaleAnimator.cancel();
            }
        }

        public void restore(int i, int i2) {
            releaseAnimation();
            initAnimator();
            this.scaleAnimator.setIntValues(new int[]{i, i2});
            this.scaleAnimator.setDuration(250);
            this.scaleAnimator.setInterpolator(MzScrollBarView.sScaleInterpolator);
            this.scaleAnimator.start();
            this.state = 1;
            this.mRestore = true;
            this.host.postInvalidate();
        }

        public void run() {
            MzScrollBarDrawable mzScrollBarDrawable2;
            if (AnimationUtils.currentAnimationTimeMillis() >= this.scaleStartTime && this.state == 0) {
                initAnimator();
                this.state = 1;
                this.mRestore = false;
                this.scaleAnimator.setDuration(250);
                this.scaleAnimator.setInterpolator(MzScrollBarView.sScaleInterpolator);
                this.scaleAnimator.setIntValues(new int[]{this.normalThickness, this.scaleThickness});
                if (MzScrollBarView.isRTL && (mzScrollBarDrawable2 = this.mzScrollBarDrawable) != null) {
                    this.scaleAnimator.addUpdateListener(new a(this, mzScrollBarDrawable2.getBounds().left));
                }
                this.scaleAnimator.start();
                this.host.postInvalidate();
            }
        }
    }

    public static class ScrollabilityCache implements Runnable {
        public static final int FADING = 2;
        public static final int OFF = 0;
        public static final int ON = 1;
        private static final float[] OPAQUE = {255.0f};
        private static final float[] TRANSPARENT = {0.0f};
        public long fadeStartTime;
        public View host;
        public float[] interpolatorValues;
        public final android.graphics.Interpolator scrollBarInterpolator = new android.graphics.Interpolator(1, 2);
        public int state = 0;

        public ScrollabilityCache(View view) {
            this.host = view;
        }

        public void run() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis >= this.fadeStartTime && this.state == 1) {
                View view = this.host;
                if ((view instanceof MzScrollBarView) && !((MzScrollBarView) view).mFingerOn) {
                    int i = (int) currentAnimationTimeMillis;
                    android.graphics.Interpolator interpolator = this.scrollBarInterpolator;
                    interpolator.setKeyFrame(0, i, OPAQUE);
                    interpolator.setKeyFrame(1, i + 500, TRANSPARENT);
                    this.state = 2;
                    this.host.invalidate();
                }
            }
        }
    }

    static {
        Class<View> cls = View.class;
        try {
            sComputeVerticalScrollExtentMethod = cls.getDeclaredMethod("computeVerticalScrollExtent", (Class[]) null);
            sComputeVerticalScrollRangeMethod = cls.getDeclaredMethod("computeVerticalScrollRange", (Class[]) null);
            sComputeVerticalScrollOffsetMethod = cls.getDeclaredMethod("computeVerticalScrollOffset", (Class[]) null);
            sComputeHorizontalScrollRangeMethod = cls.getDeclaredMethod("computeHorizontalScrollRange", (Class[]) null);
            sComputeHorizontalScrollExtentMethod = cls.getDeclaredMethod("computeHorizontalScrollExtent", (Class[]) null);
            sComputeHorizontalScrollOffsetMethod = cls.getDeclaredMethod("computeHorizontalScrollOffset", (Class[]) null);
            Method method = sComputeVerticalScrollExtentMethod;
            if (method != null) {
                method.setAccessible(true);
            }
            Method method2 = sComputeVerticalScrollRangeMethod;
            if (method2 != null) {
                method2.setAccessible(true);
            }
            Method method3 = sComputeVerticalScrollOffsetMethod;
            if (method3 != null) {
                method3.setAccessible(true);
            }
            Method method4 = sComputeHorizontalScrollExtentMethod;
            if (method4 != null) {
                method4.setAccessible(true);
            }
            Method method5 = sComputeHorizontalScrollRangeMethod;
            if (method5 != null) {
                method5.setAccessible(true);
            }
            Method method6 = sComputeHorizontalScrollOffsetMethod;
            if (method6 != null) {
                method6.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.e(TAG, "get reflect method has an error!");
        }
    }

    @RequiresApi
    public MzScrollBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void dispatchOverScroll(float f, float f2) {
        SpringAnimationHelper springAnimationHelper = this.mSpringAnimation;
        if (springAnimationHelper != null) {
            springAnimationHelper.dispatchOverScroll(f, f2);
        }
    }

    @RequiresApi
    private int getScrollableViewScrollExtent() {
        Method method = this.mVertical ? sComputeVerticalScrollExtentMethod : sComputeHorizontalScrollExtentMethod;
        View view = this.mScrollableView;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(view, (Object[]) null);
            if (invoke instanceof Integer) {
                return ((Integer) invoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(TAG, "invoke computeVerticalScrollExtent has an error!");
            return 0;
        }
    }

    @RequiresApi
    private int getScrollableViewScrollOffset() {
        Method method = this.mVertical ? sComputeVerticalScrollOffsetMethod : sComputeHorizontalScrollOffsetMethod;
        View view = this.mScrollableView;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(view, (Object[]) null);
            if (invoke instanceof Integer) {
                return ((Integer) invoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(TAG, "invoke computeVerticalScrollOffset has an error!");
            return 0;
        }
    }

    @RequiresApi
    private int getScrollableViewScrollRange() {
        Method method = this.mVertical ? sComputeVerticalScrollRangeMethod : sComputeHorizontalScrollRangeMethod;
        View view = this.mScrollableView;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(view, (Object[]) null);
            if (invoke instanceof Integer) {
                return ((Integer) invoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(TAG, "invoke computeVerticalScrollRange has an error!");
            return 0;
        }
    }

    @RequiresApi
    private void init(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzScrollBarView, i, 0);
        this.mScrollBarDrawableThickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzScrollBarView_scrollBarThickness, (int) ResourceUtils.dp2px(2.0f, context));
        this.mScrollBarDrawableScaledThickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzScrollBarView_scrollBarScaledThickness, (int) ResourceUtils.dp2px(6.0f, context));
        this.mHotSpotSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzScrollBarView_scrollBarHotspot, (int) ResourceUtils.dp2px(30.0f, context));
        this.mFadeEnable = obtainStyledAttributes.getBoolean(R.styleable.MzScrollBarView_scrollBarFadeEnable, true);
        this.mOperable = obtainStyledAttributes.getBoolean(R.styleable.MzScrollBarView_scrollBarOperable, true);
        this.mFitSystemTopPadding = obtainStyledAttributes.getBoolean(R.styleable.MzScrollBarView_fitSystemTopPadding, false);
        this.mFitSystemBottomPadding = obtainStyledAttributes.getBoolean(R.styleable.MzScrollBarView_fitSystemBottomPadding, false);
        if (obtainStyledAttributes.getInt(R.styleable.MzScrollBarView_scrollBarOrientation, 1) == 1) {
            z = true;
        }
        this.mVertical = z;
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(R.styleable.MzScrollBarView_scrollBarThumbDrawable);
        this.mTrackDrawable = obtainStyledAttributes.getDrawable(R.styleable.MzScrollBarView_scrollBarTrackDrawable);
        this.mThumbDrawableTint = obtainStyledAttributes.getColor(R.styleable.MzScrollBarView_scrollBarThumbTint, context.getResources().getColor(R.color.mz_scrollbar_thumb_drawable_color));
        this.mTrackDrawableTint = obtainStyledAttributes.getColor(R.styleable.MzScrollBarView_scrollBarTrackTint, context.getResources().getColor(R.color.mz_scrollbar_track_drawable_color));
        initScrollBarDrawables();
        obtainStyledAttributes.recycle();
    }

    @RequiresApi
    private void initScrollBarDrawables() {
        if (this.mScrollBarDrawable == null) {
            this.mScrollBarDrawable = new MzScrollBarDrawable(this.mVertical, this.mAdapter);
        }
        this.mScrollBarDrawable.setThumbDrawable(this.mThumbDrawable);
        this.mScrollBarDrawable.setTrackDrawable(this.mTrackDrawable);
        this.mScrollBarDrawable.setAlwaysDrawVerticalTrack(false);
        this.mThumbDrawable.mutate().setTint(this.mThumbDrawableTint);
        this.mTrackDrawable.mutate().setTint(this.mTrackDrawableTint);
    }

    private boolean isThumbHotpotTouched(float f, float f2) {
        Drawable thumbDrawable = this.mScrollBarDrawable.getThumbDrawable();
        if (thumbDrawable == null) {
            return false;
        }
        Rect rect = new Rect(thumbDrawable.getBounds());
        if (this.mVertical) {
            rect.left = 0;
            rect.right = getMeasuredWidth();
        } else {
            rect.top = 0;
            rect.bottom = getMeasuredHeight();
        }
        return rect.contains((int) f, (int) f2);
    }

    @RequiresApi
    private void onActionMove(MotionEvent motionEvent, int i) {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        awakenScrollBar(false);
        onPostScaleAction();
        boolean onScrollableViewScrollingVertically = this.mVertical ? onScrollableViewScrollingVertically(motionEvent, i) : onScrollableViewScrollingHorizontally(motionEvent, i);
        boolean z = true;
        if (onScrollableViewScrollingVertically && this.mScrollState != 1) {
            setScrollState(1);
        }
        View view = this.mScrollableView;
        if (view instanceof MzRecyclerView) {
            z = ((MzRecyclerView) view).isOverScrollEnable();
        }
        View view2 = this.mScrollableView;
        if (view2 instanceof MzScrollView) {
            z = ((MzScrollView) view2).isOverScrollEnable();
        }
        View view3 = this.mScrollableView;
        if (view3 instanceof MzNestedScrollView) {
            z = ((MzNestedScrollView) view3).isOverScrollEnable();
        }
        if (!onScrollableViewScrollingVertically && this.mSpringAnimation != null && z) {
            if (this.mVertical) {
                onScrollableViewOverScrollVertically(motionEvent, i);
            } else {
                onScrollableViewOverScrollHorizontally(motionEvent, i);
            }
        }
        this.mLastMotionX = motionEvent.getX(i);
        this.mLastMotionY = motionEvent.getY(i);
    }

    @RequiresApi
    private void onActionUp() {
        this.mScaledDelay = false;
        this.mLastMotionY = FULL_TRANSPARENT;
        this.mLastMotionX = FULL_TRANSPARENT;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mScaleAction);
        }
        this.mScaleAction.releaseAnimation();
        if (this.mVertical) {
            this.mScaleAction.restore(this.mScrollBarDrawable.getBounds().width(), this.mScrollBarDrawableThickness);
        } else {
            this.mScaleAction.restore(this.mScrollBarDrawable.getBounds().height(), this.mScrollBarDrawableThickness);
        }
        if (this.mScrollableView.getTranslationY() == FULL_TRANSPARENT && this.mScrollableView.getTranslationX() == FULL_TRANSPARENT) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
            onScrollableViewFling((int) (this.mVertical ? velocityTracker.getYVelocity(this.mPointerIndex) : velocityTracker.getXVelocity(this.mPointerIndex)));
            return;
        }
        onScrollableViewRestore();
    }

    @RequiresApi
    private void onDrawScrollBar(Canvas canvas) {
        boolean z;
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        int i = scrollabilityCache.state;
        if (i != 0) {
            int i2 = 2;
            if (i == 2) {
                if (scrollabilityCache.interpolatorValues == null) {
                    scrollabilityCache.interpolatorValues = new float[1];
                }
                float[] fArr = scrollabilityCache.interpolatorValues;
                if (scrollabilityCache.scrollBarInterpolator.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    this.mScrollCache.state = 0;
                } else {
                    this.mScrollBarDrawable.mutate().setAlpha(Math.round(fArr[0]));
                }
                z = true;
            } else {
                this.mScrollBarDrawable.mutate().setAlpha(255);
                z = false;
            }
            if (this.mScaleAction.state == 1) {
                this.mScaledDelay = false;
                awakenScrollBar(false);
                Object animatedValue = this.mScaleAction.scaleAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    this.mScrollBarDrawable.setThickness(((Integer) animatedValue).intValue());
                    if (!this.mScaleAction.scaleAnimator.isRunning()) {
                        ScaleAction scaleAction = this.mScaleAction;
                        boolean z2 = scaleAction.mRestore;
                        if (z2) {
                            i2 = 0;
                        }
                        scaleAction.state = i2;
                        if (!z2) {
                            VibrateUtil.performHapticFeedback(this.mScrollableView, VibrateUtil.hasFlymeFeature());
                        }
                    }
                    z = true;
                }
            }
            int scrollableViewScrollExtent = getScrollableViewScrollExtent();
            this.mScrollBarDrawable.setParameters(getScrollableViewScrollRange(), getScrollableViewScrollOffset(), scrollableViewScrollExtent, this.mVertical ? Math.abs((int) this.mScrollableView.getTranslationY()) : (int) Math.abs(this.mScrollableView.getTranslationX()));
            this.mScrollBarDrawable.draw(canvas);
            if (this.mScrollCache.state == 1) {
                dispatchScrollOffset();
            }
            if (z) {
                invalidate();
            }
        }
    }

    private void onPostScaleAction() {
        if (this.mScaleAction.state == 0 && !this.mScaledDelay) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ScaleAction scaleAction = this.mScaleAction;
            scaleAction.scaleStartTime = currentAnimationTimeMillis;
            scaleAction.state = 0;
            this.mHandler.postAtTime(scaleAction, currentAnimationTimeMillis);
            this.mScaledDelay = true;
        }
    }

    @RequiresApi
    private void onScrollableViewFling(int i) {
        boolean z = this.mVertical;
        int i2 = 0;
        int i3 = z ? 0 : i * 2;
        if (z) {
            i2 = i * 2;
        }
        int min = Math.min(this.mMaxFlingVelocity, i3);
        int min2 = Math.min(this.mMaxFlingVelocity, i2);
        if (this.mVertical) {
            if (Math.abs(min2) <= this.mMinFlingVelocity) {
                return;
            }
        } else if (Math.abs(min) <= this.mMinFlingVelocity) {
            return;
        }
        View view = this.mScrollableView;
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(min, min2);
        }
        View view2 = this.mScrollableView;
        if (view2 instanceof ScrollView) {
            ((ScrollView) view2).fling(min2);
        }
        View view3 = this.mScrollableView;
        if (view3 instanceof NestedScrollView) {
            ((NestedScrollView) view3).fling(min2);
        }
        View view4 = this.mScrollableView;
        if (view4 instanceof AbsListView) {
            ((AbsListView) view4).fling(min2);
        }
        if (this.mScrollState != 2) {
            setScrollState(2);
        }
    }

    private void onScrollableViewOverScrollHorizontally(MotionEvent motionEvent, int i) {
        float x = motionEvent.getX(i) - this.mLastMotionX;
        boolean canScrollHorizontally = this.mScrollableView.canScrollHorizontally(-1);
        boolean canScrollHorizontally2 = this.mScrollableView.canScrollHorizontally(1);
        float translationX = this.mScrollableView.getTranslationX();
        if ((!canScrollHorizontally2 && x > FULL_TRANSPARENT) || (!canScrollHorizontally && x < FULL_TRANSPARENT)) {
            this.mScrollableView.setTranslationX(translationX - x);
        }
        if (!canScrollHorizontally2 && x <= FULL_TRANSPARENT) {
            this.mScrollableView.setTranslationX(Math.min(FULL_TRANSPARENT, translationX - x));
        } else if (!canScrollHorizontally && x >= FULL_TRANSPARENT) {
            this.mScrollableView.setTranslationX(Math.max(FULL_TRANSPARENT, translationX - x));
        }
        awakenScrollBar(true);
    }

    private void onScrollableViewOverScrollVertically(MotionEvent motionEvent, int i) {
        float y = motionEvent.getY(i) - this.mLastMotionY;
        boolean canScrollVertically = this.mScrollableView.canScrollVertically(-1);
        boolean canScrollVertically2 = this.mScrollableView.canScrollVertically(1);
        float translationY = this.mScrollableView.getTranslationY();
        if ((!canScrollVertically2 && y > FULL_TRANSPARENT) || (!canScrollVertically && y < FULL_TRANSPARENT)) {
            float f = translationY - y;
            this.mScrollableView.setTranslationY(f);
            dispatchOverScroll(FULL_TRANSPARENT, f);
        }
        if (!canScrollVertically2 && y <= FULL_TRANSPARENT) {
            float min = Math.min(FULL_TRANSPARENT, translationY - y);
            this.mScrollableView.setTranslationY(min);
            dispatchOverScroll(FULL_TRANSPARENT, min);
        } else if (!canScrollVertically && y >= FULL_TRANSPARENT) {
            float max = Math.max(FULL_TRANSPARENT, translationY - y);
            this.mScrollableView.setTranslationY(max);
            dispatchOverScroll(FULL_TRANSPARENT, max);
        }
        awakenScrollBar(true);
    }

    private void onScrollableViewRestore() {
        SpringAnimationHelper springAnimationHelper = this.mSpringAnimation;
        if (springAnimationHelper != null) {
            springAnimationHelper.animateTo();
        }
    }

    @RequiresApi
    private boolean onScrollableViewScrollingHorizontally(MotionEvent motionEvent, int i) {
        float x = motionEvent.getX(i) - this.mLastMotionX;
        if (Math.abs(this.mScrollableView.getTranslationX() - FULL_TRANSPARENT) >= 1.0E-4f) {
            return false;
        }
        boolean canScrollHorizontally = this.mScrollableView.canScrollHorizontally(-1);
        boolean canScrollHorizontally2 = this.mScrollableView.canScrollHorizontally(1);
        if ((!canScrollHorizontally && x < FULL_TRANSPARENT) || (!canScrollHorizontally2 && x > FULL_TRANSPARENT)) {
            return false;
        }
        int width = this.mScrollBarDrawable.getBounds().width();
        int width2 = this.mScrollBarDrawable.getThumbDrawable().getBounds().width();
        int scrollableViewScrollRange = getScrollableViewScrollRange();
        int scrollableViewScrollOffset = getScrollableViewScrollOffset();
        MzScrollBarBaseAdapter mzScrollBarBaseAdapter = this.mAdapter;
        this.mScrollableView.scrollBy(mzScrollBarBaseAdapter.getScrollDistanceByDraggingDelta((int) (((float) this.mScrollBarDrawable.getThumbOffset()) + x), width, width2, getScrollableViewScrollExtent(), scrollableViewScrollRange) - scrollableViewScrollOffset, 0);
        return true;
    }

    @RequiresApi
    private boolean onScrollableViewScrollingVertically(MotionEvent motionEvent, int i) {
        float y = motionEvent.getY(i) - this.mLastMotionY;
        if (Math.abs(this.mScrollableView.getTranslationY() - FULL_TRANSPARENT) >= 1.0E-4f) {
            return false;
        }
        boolean canScrollVertically = this.mScrollableView.canScrollVertically(-1);
        boolean canScrollVertically2 = this.mScrollableView.canScrollVertically(1);
        if ((!canScrollVertically && y < FULL_TRANSPARENT) || (!canScrollVertically2 && y > FULL_TRANSPARENT)) {
            return false;
        }
        int height = this.mScrollBarDrawable.getBounds().height();
        int height2 = this.mScrollBarDrawable.getThumbDrawable().getBounds().height();
        int scrollableViewScrollRange = getScrollableViewScrollRange();
        int scrollDistanceByDraggingDelta = this.mAdapter.getScrollDistanceByDraggingDelta((int) (((float) this.mScrollBarDrawable.getThumbOffset()) + y), height, height2, getScrollableViewScrollExtent(), scrollableViewScrollRange) - getScrollableViewScrollOffset();
        View view = this.mScrollableView;
        if (view instanceof AbsListView) {
            ((ListView) view).scrollListBy(scrollDistanceByDraggingDelta);
        } else {
            view.scrollBy(0, scrollDistanceByDraggingDelta);
        }
        return true;
    }

    private void onSecondPointerUp(MotionEvent motionEvent, int i) {
        if (motionEvent.getPointerId(i) == this.mPointerIndex) {
            int i2 = i == 0 ? 1 : 0;
            this.mPointerIndex = motionEvent.getPointerId(i2);
            this.mLastMotionX = motionEvent.getX(i2);
            this.mLastMotionY = motionEvent.getY(i2);
        }
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        this.listeners.add(onScrollListener);
    }

    public void awakenScrollBar() {
        awakenScrollBar(true);
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.listeners;
        if (list != null) {
            list.clear();
        }
    }

    public void dispatchScrollOffset() {
        int thumbOffset = this.mScrollBarDrawable.getThumbOffset();
        boolean z = this.mVertical;
        int i = z ? 0 : thumbOffset;
        if (!z) {
            thumbOffset = 0;
        }
        List<OnScrollListener> list = this.listeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.listeners.get(size).onScrolled(this, i, thumbOffset);
            }
        }
    }

    public boolean isFitSystemBottomPadding() {
        return this.mFitSystemBottomPadding;
    }

    public boolean isFitSystemTopPadding() {
        return this.mFitSystemTopPadding;
    }

    @RequiresApi
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            Insets a2 = windowInsets.getInsets(WindowInsets.Type.systemBars());
            if (this.mFitSystemTopPadding && a2.top != getPaddingTop()) {
                setPadding(getPaddingLeft(), a2.top, getPaddingRight(), getPaddingBottom());
            }
            if (this.mFitSystemBottomPadding && a2.bottom != getPaddingBottom()) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), a2.bottom);
            }
        }
        return super.onApplyWindowInsets(windowInsets);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mScrollCache);
        }
    }

    @RequiresApi
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        onDrawScrollBar(canvas);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i5 = this.mScrollState == 1 ? this.mScrollBarDrawableScaledThickness : this.mScrollBarDrawableThickness;
        MzScrollBarDrawable mzScrollBarDrawable = this.mScrollBarDrawable;
        if (mzScrollBarDrawable == null) {
            return;
        }
        if (this.mVertical) {
            if (!isRTL) {
                paddingEnd = (measuredWidth - paddingEnd) - i5;
            }
            mzScrollBarDrawable.setBounds(paddingEnd, paddingTop, i5 + paddingEnd, measuredHeight - paddingBottom);
            return;
        }
        int i6 = (measuredHeight - paddingBottom) - i5;
        mzScrollBarDrawable.setBounds(paddingStart, i6, measuredWidth - paddingEnd, i5 + i6);
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int measuredHeight;
        super.onMeasure(i, i2);
        boolean z = this.mVertical;
        if (z) {
            int i5 = this.mHotSpotSize;
            int size = View.MeasureSpec.getSize(i2);
            if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
                size = 0;
                if (getParent() != null && (getParent() instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) getParent();
                    int i6 = 0;
                    while (size < viewGroup.getChildCount()) {
                        View childAt = viewGroup.getChildAt(size);
                        if (childAt != this && (measuredHeight = childAt.getMeasuredHeight()) > i6) {
                            i6 = measuredHeight;
                        }
                        size++;
                    }
                    size = i6;
                }
            }
            setMeasuredDimension(i5, size);
            return;
        }
        if (z) {
            i4 = View.MeasureSpec.getSize(i2);
            i3 = this.mHotSpotSize;
        } else {
            i3 = View.MeasureSpec.getSize(i);
            i4 = this.mHotSpotSize;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
    }

    @RequiresApi
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (motionEvent == null) {
            return false;
        }
        if (this.mScrollCache.state != 1 || !this.mOperable) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    this.mFingerOn = true;
                    if (this.mLastMotionX == FULL_TRANSPARENT && this.mLastMotionY == FULL_TRANSPARENT) {
                        this.mLastMotionX = motionEvent.getX(actionIndex);
                        this.mLastMotionY = motionEvent.getY(actionIndex);
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(this.mPointerIndex);
                    if (findPointerIndex < 0) {
                        Log.w(TAG, "Error processing dragging, pointer index for id" + this.mPointerIndex + "not found");
                        this.mPointerIndex = motionEvent.getPointerId(0);
                        this.mLastMotionX = motionEvent.getX(0);
                        this.mLastMotionY = motionEvent.getY(0);
                    } else {
                        i = findPointerIndex;
                    }
                    onActionMove(motionEvent, i);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.mFingerOn = true;
                        this.mPointerIndex = motionEvent.getPointerId(actionIndex);
                        this.mLastMotionX = motionEvent.getX(actionIndex);
                        this.mLastMotionY = motionEvent.getY(actionIndex);
                    } else if (actionMasked == 6) {
                        this.mFingerOn = true;
                        onSecondPointerUp(motionEvent, actionIndex);
                    }
                }
            }
            this.mFingerOn = false;
            onActionUp();
        } else {
            this.mFingerOn = true;
            this.mPointerIndex = motionEvent.getPointerId(0);
            this.mLastMotionX = motionEvent.getX();
            this.mLastMotionY = motionEvent.getY();
            if (isThumbHotpotTouched(motionEvent.getX(0), motionEvent.getY(0))) {
                awakenScrollBar();
                onPostScaleAction();
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.listeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void setAdapter(@NonNull MzScrollBarBaseAdapter mzScrollBarBaseAdapter) {
        this.mAdapter = mzScrollBarBaseAdapter;
        this.mScrollBarDrawable.setProxy(mzScrollBarBaseAdapter);
    }

    public void setFadeEnable(boolean z) {
        this.mFadeEnable = z;
        awakenScrollBar();
    }

    @RequiresApi
    public void setFitSystemBottomPadding(boolean z) {
        this.mFitSystemBottomPadding = z;
        if (z) {
            requestApplyInsets();
        }
    }

    @RequiresApi
    public void setFitSystemTopPadding(boolean z) {
        this.mFitSystemTopPadding = z;
        if (z) {
            requestApplyInsets();
        }
    }

    public void setOperable(boolean z) {
        this.mOperable = z;
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
        List<OnScrollListener> list = this.listeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.listeners.get(size).onStateChanged(this, i);
            }
        }
    }

    public void setScrollableView(@NonNull View view) {
        this.mScrollableView = view;
        if (view instanceof MzRecyclerView) {
            this.mSpringAnimation = ((MzRecyclerView) view).getSpringAnimationHelper();
        }
        awakenScrollBar();
    }

    @RequiresApi
    public MzScrollBarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzScrollBarViewStyle);
    }

    public void awakenScrollBar(boolean z) {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        if (this.mFadeEnable) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + AssistantConstants.TIMEOUT_VAD_MUTE;
            ScrollabilityCache scrollabilityCache = this.mScrollCache;
            scrollabilityCache.fadeStartTime = currentAnimationTimeMillis;
            scrollabilityCache.state = 1;
            this.mHandler.removeCallbacks(scrollabilityCache);
            this.mHandler.postAtTime(this.mScrollCache, currentAnimationTimeMillis);
        } else {
            this.mScrollCache.state = 1;
        }
        if (z) {
            invalidate();
        }
    }

    @RequiresApi
    public MzScrollBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = true;
        this.mFadeEnable = true;
        this.mOperable = true;
        this.mVertical = true;
        this.mScrollState = 0;
        CommonUtils.disableDarkMode(this);
        this.mAdapter = new MzScrollBarBaseAdapter();
        init(context, attributeSet, i);
        isRTL = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1 ? false : z;
        this.mScrollCache = new ScrollabilityCache(this);
        this.mScaleAction = new ScaleAction(this, this.mScrollBarDrawableThickness, this.mScrollBarDrawableScaledThickness, this.mScrollBarDrawable);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }
}
