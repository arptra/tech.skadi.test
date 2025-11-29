package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class FlymeListView extends ListView {
    public static final float DEFAULTDOWNOFFSETVALUE = 50.0f;
    public static final float DEFAULTUPOFFSETVALUE = -50.0f;
    /* access modifiers changed from: private */
    public static float INVALUE_VALUE = Float.MAX_VALUE;
    public static final int OFFSET_DOWN = 1;
    public static final int OFFSET_NO = 3;
    public static final int OFFSET_UP = 2;
    private float mCurrentTouchPosition;
    private boolean mEnableParallax = false;
    private float mLastTouchPosition;
    private float mMoveLength = INVALUE_VALUE;
    /* access modifiers changed from: private */
    public ParallaxAnimationListener mParallaxAnimationListener;
    private ScrollItemManager mScrollItemManager;
    private HashSet<View> mViewHolderHashSet;

    public interface ParallaxAnimationListener {
        public static final int ANIMATE_STATE_END = 3;
        public static final int ANIMATE_STATE_RUNING = 2;
        public static final int ANIMATE_STATE_START = 1;

        void onAddViewHolderWhenAnimation(View view);

        void onAnimationStateChange(int i, HashSet hashSet);

        void onRecycleViewHolderWhenAnimation(View view);

        void onRunning(int i, HashSet hashSet);
    }

    public class ScrollItemManager {
        private int mBaseDuration = 500;
        private TimeInterpolator mInterpolator = new LinearInterpolator();
        /* access modifiers changed from: private */
        public boolean mIsParallaxAnimationComplete = true;
        /* access modifiers changed from: private */
        public int mOffsetState = 3;
        private ArrayList<ScrollItem> mScrollItemCache = new ArrayList<>();
        /* access modifiers changed from: private */
        public HashMap<View, ScrollItem> mScrollItemHashMap = new HashMap<>();
        private float mScrollProportion = 0.0f;
        private int mSensitivity = 5;
        private int mSmoothBackAnimationDuration;
        private ValueAnimator mSmoothBackAnimator;

        public ScrollItemManager() {
        }

        private float calculateOffset(ScrollItem scrollItem, float f) {
            float downThreshold;
            float upScrollOffsetRatio;
            float f2 = 0.0f;
            int i = (scrollItem.getCurrentOffset() > 0.0f ? 1 : (scrollItem.getCurrentOffset() == 0.0f ? 0 : -1));
            if (i == 0) {
                if (f > 0.0f) {
                    if (scrollItem.getDownThreshold() == 0.0f) {
                        return 0.0f;
                    }
                    float offsetAfterSmoothBack = scrollItem.getOffsetAfterSmoothBack();
                    if (offsetAfterSmoothBack < 0.0f) {
                        offsetAfterSmoothBack *= Math.abs(scrollItem.getDownThreshold() / scrollItem.getUpThreshold());
                    }
                    upScrollOffsetRatio = offsetAfterSmoothBack + (scrollItem.getDownScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                    if (upScrollOffsetRatio > scrollItem.getDownThreshold()) {
                        downThreshold = scrollItem.getDownThreshold();
                    }
                } else if (scrollItem.getUpThreshold() == 0.0f) {
                    return 0.0f;
                } else {
                    float offsetAfterSmoothBack2 = scrollItem.getOffsetAfterSmoothBack();
                    if (offsetAfterSmoothBack2 > 0.0f) {
                        offsetAfterSmoothBack2 *= Math.abs(scrollItem.getUpThreshold() / scrollItem.getDownThreshold());
                    }
                    upScrollOffsetRatio = offsetAfterSmoothBack2 + (scrollItem.getUpScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                    if (upScrollOffsetRatio < scrollItem.getUpThreshold()) {
                        downThreshold = scrollItem.getUpThreshold();
                    }
                }
                return upScrollOffsetRatio;
            } else if (i > 0) {
                if (scrollItem.getDownThreshold() == 0.0f) {
                    return 0.0f;
                }
                float offsetAfterSmoothBack3 = scrollItem.getOffsetAfterSmoothBack();
                if (offsetAfterSmoothBack3 < 0.0f) {
                    offsetAfterSmoothBack3 *= Math.abs(scrollItem.getDownThreshold() / scrollItem.getUpThreshold());
                }
                float downScrollOffsetRatio = offsetAfterSmoothBack3 + (scrollItem.getDownScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                if (downScrollOffsetRatio >= 0.0f) {
                    f2 = downScrollOffsetRatio;
                }
                if (f2 <= scrollItem.getDownThreshold()) {
                    return f2;
                }
                downThreshold = scrollItem.getDownThreshold();
            } else if (scrollItem.getUpThreshold() == 0.0f) {
                return 0.0f;
            } else {
                float offsetAfterSmoothBack4 = scrollItem.getOffsetAfterSmoothBack();
                if (offsetAfterSmoothBack4 > 0.0f) {
                    offsetAfterSmoothBack4 *= Math.abs(scrollItem.getUpThreshold() / scrollItem.getDownThreshold());
                }
                float upScrollOffsetRatio2 = offsetAfterSmoothBack4 + (scrollItem.getUpScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                if (upScrollOffsetRatio2 <= 0.0f) {
                    f2 = upScrollOffsetRatio2;
                }
                return f2 < scrollItem.getUpThreshold() ? scrollItem.getUpThreshold() : f2;
            }
            return downThreshold;
        }

        public void addScrollItem(View view, View view2) {
            addScrollItem(view, view2, 1.0f, 1.0f);
        }

        public void addScrollItemToCache(ScrollItem scrollItem) {
            this.mScrollItemCache.add(scrollItem);
        }

        public void cancleSmoothBackToOriginalPosition() {
            ValueAnimator valueAnimator = this.mSmoothBackAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mSmoothBackAnimator.cancel();
            }
        }

        public ScrollItem getScrollItemFromCache() {
            if (this.mScrollItemCache.size() <= 0) {
                return null;
            }
            ArrayList<ScrollItem> arrayList = this.mScrollItemCache;
            ScrollItem scrollItem = arrayList.get(arrayList.size() - 1);
            this.mScrollItemCache.remove(scrollItem);
            return scrollItem;
        }

        public HashMap<View, ScrollItem> getScrollItemHashMap() {
            return this.mScrollItemHashMap;
        }

        public boolean isParallaxAnimationComplete() {
            return this.mIsParallaxAnimationComplete;
        }

        public void resetOriginalTransilationY() {
            for (ScrollItem originalTransilationY : this.mScrollItemHashMap.values()) {
                originalTransilationY.setOriginalTransilationY(FlymeListView.INVALUE_VALUE);
            }
        }

        public void setBaseDuration(int i) {
            this.mBaseDuration = i;
        }

        public void setParallaxAnimationComplete(boolean z) {
            this.mIsParallaxAnimationComplete = z;
        }

        public void setSensitivity(int i) {
            this.mSensitivity = i;
        }

        public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
            this.mInterpolator = timeInterpolator;
        }

        public void startSmoothBackToOriginalPosition() {
            if (this.mOffsetState == 3) {
                resetOriginalTransilationY();
                this.mIsParallaxAnimationComplete = true;
                if (FlymeListView.this.mParallaxAnimationListener != null) {
                    FlymeListView.this.mParallaxAnimationListener.onAnimationStateChange(3, FlymeListView.this.getViewHoldSet());
                    return;
                }
                return;
            }
            this.mSmoothBackAnimationDuration = (int) (((float) this.mBaseDuration) * this.mScrollProportion);
            for (ScrollItem next : this.mScrollItemHashMap.values()) {
                next.setOffsetBeforeSmoothBack(next.getCurrentOffset());
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.mSmoothBackAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    for (ScrollItem scrollItem : ScrollItemManager.this.mScrollItemHashMap.values()) {
                        scrollItem.translateItemY(((Float) valueAnimator.getAnimatedValue()).floatValue() * scrollItem.getOffsetBeforeSmoothBack());
                    }
                }
            });
            this.mSmoothBackAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = ScrollItemManager.this.mIsParallaxAnimationComplete = true;
                    for (ScrollItem scrollItem : ScrollItemManager.this.mScrollItemHashMap.values()) {
                        scrollItem.setOffsetAfterSmoothBack(scrollItem.getCurrentOffset());
                        if (scrollItem.getCurrentOffset() != 0.0f) {
                            boolean unused2 = ScrollItemManager.this.mIsParallaxAnimationComplete = false;
                        } else {
                            scrollItem.setOriginalTransilationY(FlymeListView.INVALUE_VALUE);
                        }
                    }
                    if (ScrollItemManager.this.mIsParallaxAnimationComplete) {
                        int unused3 = ScrollItemManager.this.mOffsetState = 3;
                    }
                    if (ScrollItemManager.this.mIsParallaxAnimationComplete && FlymeListView.this.mParallaxAnimationListener != null) {
                        FlymeListView.this.mParallaxAnimationListener.onAnimationStateChange(3, FlymeListView.this.getViewHoldSet());
                    }
                }
            });
            this.mSmoothBackAnimator.setDuration((long) this.mSmoothBackAnimationDuration);
            this.mSmoothBackAnimator.setInterpolator(this.mInterpolator);
            this.mSmoothBackAnimator.start();
        }

        public void translateItemY(float f) {
            if (f != 0.0f || this.mOffsetState != 3) {
                this.mOffsetState = 3;
                this.mScrollProportion = 0.0f;
                for (ScrollItem next : this.mScrollItemHashMap.values()) {
                    float calculateOffset = calculateOffset(next, f);
                    if (calculateOffset > 0.0f) {
                        this.mOffsetState = 1;
                        this.mScrollProportion = Math.abs(calculateOffset / next.getDownThreshold());
                    } else if (calculateOffset < 0.0f) {
                        this.mOffsetState = 2;
                        this.mScrollProportion = Math.abs(calculateOffset / next.getUpThreshold());
                    }
                    next.translateItemY(calculateOffset);
                }
            }
        }

        public void addScrollItem(View view, View view2, float f, float f2) {
            if (this.mScrollItemCache.size() > 0) {
                ScrollItem scrollItemFromCache = getScrollItemFromCache();
                scrollItemFromCache.setTranslateView(view);
                scrollItemFromCache.setScrollOffsetRatio(f, f2);
                scrollItemFromCache.setViewHolder(view2);
                this.mScrollItemHashMap.put(view, scrollItemFromCache);
                return;
            }
            ScrollItem scrollItem = new ScrollItem();
            scrollItem.setTranslateView(view);
            scrollItem.setScrollOffsetRatio(f, f2);
            scrollItem.setViewHolder(view2);
            this.mScrollItemHashMap.put(view, scrollItem);
        }
    }

    public FlymeListView(Context context) {
        super(context);
    }

    public void addAnimateView(View view, View view2) {
        addAnimateView(view, view2, -50.0f, 50.0f);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mEnableParallax) {
            this.mCurrentTouchPosition = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mLastTouchPosition = this.mCurrentTouchPosition;
                this.mMoveLength = 0.0f;
                this.mScrollItemManager.cancleSmoothBackToOriginalPosition();
                if (this.mScrollItemManager.isParallaxAnimationComplete()) {
                    this.mScrollItemManager.setParallaxAnimationComplete(false);
                    ParallaxAnimationListener parallaxAnimationListener = this.mParallaxAnimationListener;
                    if (parallaxAnimationListener != null) {
                        parallaxAnimationListener.onAnimationStateChange(1, getViewHoldSet());
                    }
                }
            } else if (action != 1) {
                if (action == 2 && this.mMoveLength != INVALUE_VALUE) {
                    if (canScrollVertically(1)) {
                        float f = this.mLastTouchPosition;
                        float f2 = this.mCurrentTouchPosition;
                        if (f - f2 > 15.0f) {
                            this.mMoveLength += f - f2;
                            this.mScrollItemManager.translateItemY(this.mMoveLength);
                        }
                    }
                    if (canScrollVertically(-1)) {
                        float f3 = this.mLastTouchPosition;
                        float f4 = this.mCurrentTouchPosition;
                        if (f3 - f4 < -15.0f) {
                            this.mMoveLength += f3 - f4;
                        }
                    }
                    this.mScrollItemManager.translateItemY(this.mMoveLength);
                }
            } else if (this.mMoveLength != INVALUE_VALUE) {
                this.mScrollItemManager.startSmoothBackToOriginalPosition();
            }
            this.mLastTouchPosition = this.mCurrentTouchPosition;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public HashSet getViewHoldSet() {
        return this.mViewHolderHashSet;
    }

    public void recycleScrollItem(View view) {
        ScrollItemManager scrollItemManager;
        ParallaxAnimationListener parallaxAnimationListener;
        if (this.mEnableParallax && (scrollItemManager = this.mScrollItemManager) != null) {
            Iterator<ScrollItem> it = scrollItemManager.getScrollItemHashMap().values().iterator();
            while (it.hasNext()) {
                ScrollItem next = it.next();
                if (view.equals(next.getViewHolder())) {
                    next.translateItemY(0.0f);
                    next.setOriginalTransilationY(INVALUE_VALUE);
                    next.reset();
                    this.mScrollItemManager.addScrollItemToCache(next);
                    it.remove();
                }
            }
            if (this.mViewHolderHashSet.contains(view)) {
                this.mViewHolderHashSet.remove(view);
                if (!this.mScrollItemManager.isParallaxAnimationComplete() && (parallaxAnimationListener = this.mParallaxAnimationListener) != null) {
                    parallaxAnimationListener.onRecycleViewHolderWhenAnimation(view);
                }
            }
        }
    }

    public void setBaseDuration(int i) {
        ScrollItemManager scrollItemManager = this.mScrollItemManager;
        if (scrollItemManager != null) {
            scrollItemManager.setBaseDuration(i);
        }
    }

    public void setEnableParallax(boolean z) {
        if (z) {
            if (this.mScrollItemManager == null) {
                this.mScrollItemManager = new ScrollItemManager();
            }
            if (this.mViewHolderHashSet == null) {
                this.mViewHolderHashSet = new HashSet<>();
            }
        }
        this.mEnableParallax = z;
    }

    public void setParallaxAnimationListener(ParallaxAnimationListener parallaxAnimationListener) {
        this.mParallaxAnimationListener = parallaxAnimationListener;
    }

    public void setScrollSensitivity(int i) {
        ScrollItemManager scrollItemManager = this.mScrollItemManager;
        if (scrollItemManager != null) {
            scrollItemManager.setSensitivity(i);
        }
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        ScrollItemManager scrollItemManager;
        if (timeInterpolator != null && (scrollItemManager = this.mScrollItemManager) != null) {
            scrollItemManager.setSmoothBackInterpolator(timeInterpolator);
        }
    }

    public void synchronousListenerState() {
        ParallaxAnimationListener parallaxAnimationListener;
        if (this.mEnableParallax && !this.mScrollItemManager.isParallaxAnimationComplete() && (parallaxAnimationListener = this.mParallaxAnimationListener) != null) {
            parallaxAnimationListener.onRunning(2, getViewHoldSet());
        }
    }

    public void addAnimateView(View view, View view2, float f, float f2) {
        ParallaxAnimationListener parallaxAnimationListener;
        if (view != null && this.mScrollItemManager != null) {
            if (!this.mViewHolderHashSet.contains(view2)) {
                this.mViewHolderHashSet.add(view2);
                if (!this.mScrollItemManager.isParallaxAnimationComplete() && (parallaxAnimationListener = this.mParallaxAnimationListener) != null) {
                    parallaxAnimationListener.onAddViewHolderWhenAnimation(view2);
                }
            }
            this.mScrollItemManager.addScrollItem(view, view2, f2 / 50.0f, f / -50.0f);
        }
    }

    public FlymeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public class ScrollItem {
        private float mCurrentOffset;
        private float mDownScrollOffsetRatio = 1.0f;
        private float mDownThreshold = 50.0f;
        private float mEffectLength = FlymeListView.INVALUE_VALUE;
        private float mOffsetAfterSmoothBack;
        private float mOffsetBeforeSmoothBack;
        private float mOriginalTransilationY = FlymeListView.INVALUE_VALUE;
        private View mTranslateView;
        private float mUpScrollOffsetRatio = 1.0f;
        private float mUpThreshold = -50.0f;
        private View mViewHolder;

        public ScrollItem() {
        }

        public float getCurrentOffset() {
            return this.mCurrentOffset;
        }

        public float getDownScrollOffsetRatio() {
            return this.mDownScrollOffsetRatio;
        }

        public float getDownThreshold() {
            return this.mDownThreshold;
        }

        public float getOffsetAfterSmoothBack() {
            return this.mOffsetAfterSmoothBack;
        }

        public float getOffsetBeforeSmoothBack() {
            return this.mOffsetBeforeSmoothBack;
        }

        public View getTranslateView() {
            return this.mTranslateView;
        }

        public float getUpScrollOffsetRatio() {
            return this.mUpScrollOffsetRatio;
        }

        public float getUpThreshold() {
            return this.mUpThreshold;
        }

        public View getViewHolder() {
            return this.mViewHolder;
        }

        public void reset() {
            this.mTranslateView = null;
            this.mViewHolder = null;
            this.mUpScrollOffsetRatio = 1.0f;
            this.mDownScrollOffsetRatio = 1.0f;
            this.mDownThreshold = 50.0f;
            this.mUpThreshold = -50.0f;
            this.mOriginalTransilationY = FlymeListView.INVALUE_VALUE;
            this.mCurrentOffset = 0.0f;
        }

        public void setOffsetAfterSmoothBack(float f) {
            this.mOffsetAfterSmoothBack = f;
        }

        public void setOffsetBeforeSmoothBack(float f) {
            this.mOffsetBeforeSmoothBack = f;
        }

        public void setOriginalTransilationY(float f) {
            this.mOriginalTransilationY = f;
        }

        public void setScrollOffsetRatio(float f, float f2) {
            this.mUpScrollOffsetRatio = f2;
            this.mDownScrollOffsetRatio = f;
            this.mDownThreshold = f * 50.0f;
            this.mUpThreshold = f2 * -50.0f;
        }

        public void setTranslateView(View view) {
            this.mTranslateView = view;
        }

        public void setViewHolder(View view) {
            this.mViewHolder = view;
        }

        public void translateItemY(float f) {
            if (this.mTranslateView != null) {
                if (this.mOriginalTransilationY == FlymeListView.INVALUE_VALUE) {
                    this.mOriginalTransilationY = this.mTranslateView.getTranslationY();
                }
                this.mCurrentOffset = f;
                this.mTranslateView.setTranslationY(this.mOriginalTransilationY + f);
            }
        }

        public ScrollItem(View view, float f, float f2) {
            this.mTranslateView = view;
            this.mDownScrollOffsetRatio = f;
            this.mUpScrollOffsetRatio = f2;
            this.mDownThreshold = f * 50.0f;
            this.mUpThreshold = f2 * -50.0f;
        }
    }

    public FlymeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
