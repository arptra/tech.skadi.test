package flyme.support.v7.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

public class ScrollAnimateUtil {
    /* access modifiers changed from: private */
    public float mCurrentSpeed = 0.0f;
    /* access modifiers changed from: private */
    public float mCurrentTouchPosition;
    private int mDuration = 380;
    private WeakHashMap<RecyclerView.ViewHolder, Integer> mHolders = new WeakHashMap<>();
    private Interpolator mInterpolator = new DecelerateInterpolator();
    /* access modifiers changed from: private */
    public float mLastTouchPosition;
    /* access modifiers changed from: private */
    public float mMoveLength;
    private boolean mNoSlideInFromTop = false;
    private float mOffsetRatio = 1.0f;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public ScrollItemManager mScrollItemManager;
    /* access modifiers changed from: private */
    public int mScrollState = 0;
    /* access modifiers changed from: private */
    public VelocityTracker mVelocityTracker;

    public class ScrollItemManager {
        private float mCurrentOffset;
        private TimeInterpolator mPathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.33f, 1.0f);
        private ArrayList<ScrollItem> mScrollItemCache = new ArrayList<>();
        /* access modifiers changed from: private */
        public HashMap<View, ScrollItem> mScrollItemHashMap = new HashMap<>();
        /* access modifiers changed from: private */
        public float mScrollProportion;
        private int mSensitivity = 10;
        private ValueAnimator mSmoothBackAnimator;
        /* access modifiers changed from: private */
        public float mSmoothBackProportion = 0.0f;

        public ScrollItemManager() {
        }

        public void addScrollItem(View view, RecyclerView.ViewHolder viewHolder) {
            addScrollItem(view, viewHolder, 1.0f);
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

        public ScrollItem getScrollItem(View view) {
            return this.mScrollItemHashMap.get(view);
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

        public int getScrollItemSize() {
            return this.mScrollItemHashMap.size();
        }

        public void removeScrollItem(View view) {
            this.mScrollItemHashMap.remove(view);
        }

        public void setSensitivity(int i) {
            this.mSensitivity = i;
        }

        public void startSmoothBackToOriginalPosition(int i) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.mSmoothBackAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    for (ScrollItem scrollItem : ScrollItemManager.this.mScrollItemHashMap.values()) {
                        scrollItem.translateItemY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ScrollItemManager.this.mScrollProportion * scrollItem.getMaxThreshold());
                    }
                }
            });
            this.mSmoothBackAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    float unused = ScrollItemManager.this.mSmoothBackProportion = ((Float) ((ValueAnimator) animator).getAnimatedValue()).floatValue();
                    for (ScrollItem scrollItem : ScrollItemManager.this.mScrollItemHashMap.values()) {
                        scrollItem.setOffsetBeforeSmoothBack(scrollItem.getCurrentOffset());
                    }
                }

                public void onAnimationStart(Animator animator) {
                    float unused = ScrollItemManager.this.mSmoothBackProportion = 0.0f;
                    for (ScrollItem scrollItem : ScrollItemManager.this.mScrollItemHashMap.values()) {
                        scrollItem.setOffsetBeforeSmoothBack(scrollItem.getCurrentOffset());
                    }
                }
            });
            this.mSmoothBackAnimator.setDuration((long) (i + 500));
            this.mSmoothBackAnimator.setInterpolator(this.mPathInterpolator);
            this.mSmoothBackAnimator.start();
        }

        public void translateItemY(float f) {
            for (ScrollItem next : this.mScrollItemHashMap.values()) {
                if ((this.mSmoothBackProportion * next.getOffsetBeforeSmoothBack()) + ((next.getScrollOffsetRatio() * f) / ((float) this.mSensitivity)) > next.getMaxThreshold()) {
                    this.mCurrentOffset = next.getMaxThreshold();
                    this.mScrollProportion = 1.0f;
                } else if ((this.mSmoothBackProportion * next.getOffsetBeforeSmoothBack()) + ((next.getScrollOffsetRatio() * f) / ((float) this.mSensitivity)) < next.getMinThreshold()) {
                    this.mCurrentOffset = next.getMinThreshold();
                    this.mScrollProportion = -1.0f;
                } else {
                    float offsetBeforeSmoothBack = (this.mSmoothBackProportion * next.getOffsetBeforeSmoothBack()) + (next.getScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                    this.mCurrentOffset = offsetBeforeSmoothBack;
                    this.mScrollProportion = offsetBeforeSmoothBack / next.getMaxThreshold();
                }
                next.translateItemY(this.mCurrentOffset);
            }
        }

        public void addScrollItem(View view, RecyclerView.ViewHolder viewHolder, float f) {
            if (this.mScrollItemCache.size() > 0) {
                ScrollItem scrollItemFromCache = getScrollItemFromCache();
                scrollItemFromCache.setTranslateView(view);
                scrollItemFromCache.setViewHolder(viewHolder);
                scrollItemFromCache.setScrollOffsetRatio(f);
                this.mScrollItemHashMap.put(view, scrollItemFromCache);
                return;
            }
            ScrollItem scrollItem = new ScrollItem();
            scrollItem.setTranslateView(view);
            scrollItem.setViewHolder(viewHolder);
            scrollItem.setScrollOffsetRatio(f);
            this.mScrollItemHashMap.put(view, scrollItem);
        }
    }

    public ScrollAnimateUtil(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        this.mScrollItemManager = new ScrollItemManager();
        this.mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                float unused = ScrollAnimateUtil.this.mCurrentTouchPosition = motionEvent.getY();
                if (ScrollAnimateUtil.this.mVelocityTracker == null) {
                    VelocityTracker unused2 = ScrollAnimateUtil.this.mVelocityTracker = VelocityTracker.obtain();
                }
                ScrollAnimateUtil.this.mVelocityTracker.addMovement(motionEvent);
                int action = motionEvent.getAction();
                if (action == 0) {
                    ScrollAnimateUtil scrollAnimateUtil = ScrollAnimateUtil.this;
                    float unused3 = scrollAnimateUtil.mLastTouchPosition = scrollAnimateUtil.mCurrentTouchPosition;
                    float unused4 = ScrollAnimateUtil.this.mMoveLength = 0.0f;
                    ScrollAnimateUtil.this.mScrollItemManager.cancleSmoothBackToOriginalPosition();
                } else if (action == 1) {
                    ScrollAnimateUtil.this.mVelocityTracker.computeCurrentVelocity(1000, 8000.0f);
                    ScrollAnimateUtil.this.mScrollItemManager.startSmoothBackToOriginalPosition((int) (Math.abs(ScrollAnimateUtil.this.mVelocityTracker.getYVelocity()) / 15.0f));
                    if (ScrollAnimateUtil.this.mVelocityTracker != null) {
                        ScrollAnimateUtil.this.mVelocityTracker.clear();
                    }
                } else if (action == 2) {
                    if (ScrollAnimateUtil.this.mRecyclerView.canScrollVertically(1) && ScrollAnimateUtil.this.mLastTouchPosition - ScrollAnimateUtil.this.mCurrentTouchPosition > 15.0f) {
                        ScrollAnimateUtil scrollAnimateUtil2 = ScrollAnimateUtil.this;
                        ScrollAnimateUtil.access$316(scrollAnimateUtil2, scrollAnimateUtil2.mLastTouchPosition - ScrollAnimateUtil.this.mCurrentTouchPosition);
                    } else if (ScrollAnimateUtil.this.mRecyclerView.canScrollVertically(-1) && ScrollAnimateUtil.this.mLastTouchPosition - ScrollAnimateUtil.this.mCurrentTouchPosition < -15.0f) {
                        ScrollAnimateUtil scrollAnimateUtil3 = ScrollAnimateUtil.this;
                        ScrollAnimateUtil.access$316(scrollAnimateUtil3, scrollAnimateUtil3.mLastTouchPosition - ScrollAnimateUtil.this.mCurrentTouchPosition);
                    }
                    ScrollAnimateUtil.this.mScrollItemManager.translateItemY(ScrollAnimateUtil.this.mMoveLength);
                }
                ScrollAnimateUtil scrollAnimateUtil4 = ScrollAnimateUtil.this;
                float unused5 = scrollAnimateUtil4.mLastTouchPosition = scrollAnimateUtil4.mCurrentTouchPosition;
                return false;
            }

            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }
        });
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                int unused = ScrollAnimateUtil.this.mScrollState = i;
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                float unused = ScrollAnimateUtil.this.mCurrentSpeed = (float) i2;
            }
        });
    }

    public static /* synthetic */ float access$316(ScrollAnimateUtil scrollAnimateUtil, float f) {
        float f2 = scrollAnimateUtil.mMoveLength + f;
        scrollAnimateUtil.mMoveLength = f2;
        return f2;
    }

    private void clear(View view) {
        ViewCompat.y0(view, 1.0f);
        ViewCompat.U0(view, 1.0f);
        ViewCompat.T0(view, 1.0f);
        ViewCompat.Z0(view, 0.0f);
        ViewCompat.Y0(view, 0.0f);
        ViewCompat.Q0(view, 0.0f);
        ViewCompat.S0(view, 0.0f);
        ViewCompat.R0(view, 0.0f);
        view.setPivotY((float) (view.getMeasuredHeight() / 2));
        ViewCompat.O0(view, (float) (view.getMeasuredWidth() / 2));
        ViewCompat.e(view).j((Interpolator) null);
    }

    public void addAnimateView(View view, RecyclerView.ViewHolder viewHolder) {
        if (view != null) {
            this.mScrollItemManager.addScrollItem(view, viewHolder);
        }
    }

    public Animator getAnimators(View view) {
        if (this.mCurrentSpeed > 0.0f) {
            return ObjectAnimator.ofFloat(view, "translationY", new float[]{((float) view.getHeight()) * this.mOffsetRatio, 0.0f});
        } else if (this.mNoSlideInFromTop) {
            return null;
        } else {
            return ObjectAnimator.ofFloat(view, "translationY", new float[]{((float) (-view.getHeight())) * this.mOffsetRatio, 0.0f});
        }
    }

    public void noSlideInFromTop() {
        this.mNoSlideInFromTop = true;
    }

    public void recycleScrollItem(RecyclerView.ViewHolder viewHolder) {
        Iterator<ScrollItem> it = this.mScrollItemManager.getScrollItemHashMap().values().iterator();
        while (it.hasNext()) {
            ScrollItem next = it.next();
            if (viewHolder.equals(next.getViewHolder())) {
                next.translateItemY(0.0f);
                next.reset();
                this.mScrollItemManager.addScrollItemToCache(next);
                it.remove();
            }
        }
    }

    public void runSlideInAnimate(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        if (Integer.valueOf(i).equals(this.mHolders.get(viewHolder)) || !((i2 = this.mScrollState) == 1 || i2 == 2)) {
            clear(viewHolder.itemView);
            return;
        }
        Animator animators = getAnimators(viewHolder.itemView);
        if (animators != null) {
            animators.setDuration((long) this.mDuration).start();
            animators.setInterpolator(this.mInterpolator);
            this.mHolders.put(viewHolder, Integer.valueOf(i));
        }
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setSensitivity(int i) {
        this.mScrollItemManager.setSensitivity(i);
    }

    public void setSlideInInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setSlideInOffsetRatio(float f) {
        this.mOffsetRatio = f;
    }

    public void addAnimateView(View view, RecyclerView.ViewHolder viewHolder, float f) {
        if (view != null) {
            this.mScrollItemManager.addScrollItem(view, viewHolder, f);
        }
    }

    public class ScrollItem {
        public float DEFAULTMAXOFFSETVALUE;
        public float DEFAULTMINOFFSETVALUE;
        private float mCurrentOffset;
        private float mMaxThreshold;
        private float mMinThreshold;
        private float mOffsetBeforeSmoothBack;
        private float mOriginalTransilationY;
        private float mScrollOffsetRatio;
        private View mTranslateView;
        private RecyclerView.ViewHolder mViewHolder;

        public ScrollItem() {
            this.mScrollOffsetRatio = 1.0f;
            this.DEFAULTMAXOFFSETVALUE = 50.0f;
            this.DEFAULTMINOFFSETVALUE = -50.0f;
            this.mMaxThreshold = 50.0f;
            this.mMinThreshold = -50.0f;
        }

        public float getCurrentOffset() {
            return this.mCurrentOffset;
        }

        public float getMaxThreshold() {
            return this.mMaxThreshold;
        }

        public float getMinThreshold() {
            return this.mMinThreshold;
        }

        public float getOffsetBeforeSmoothBack() {
            return this.mOffsetBeforeSmoothBack;
        }

        public float getScrollOffsetRatio() {
            return this.mScrollOffsetRatio;
        }

        public View getTranslateView() {
            return this.mTranslateView;
        }

        public RecyclerView.ViewHolder getViewHolder() {
            return this.mViewHolder;
        }

        public void reset() {
            this.mTranslateView = null;
            this.mViewHolder = null;
            this.mScrollOffsetRatio = 1.0f;
            this.mMaxThreshold = this.DEFAULTMAXOFFSETVALUE;
            this.mMinThreshold = this.DEFAULTMINOFFSETVALUE;
            this.mCurrentOffset = 0.0f;
        }

        public void setOffsetBeforeSmoothBack(float f) {
            this.mOffsetBeforeSmoothBack = f;
        }

        public void setScrollOffsetRatio(float f) {
            this.mScrollOffsetRatio = f;
            this.mMaxThreshold = this.DEFAULTMAXOFFSETVALUE * f;
            this.mMinThreshold = this.DEFAULTMINOFFSETVALUE * f;
        }

        public void setTranslateView(View view) {
            this.mTranslateView = view;
            this.mOriginalTransilationY = view.getTranslationY();
        }

        public void setViewHolder(RecyclerView.ViewHolder viewHolder) {
            this.mViewHolder = viewHolder;
        }

        public void translateItemY(float f) {
            View view = this.mTranslateView;
            if (view != null) {
                this.mCurrentOffset = f;
                view.setTranslationY(this.mOriginalTransilationY + f);
            }
        }

        public ScrollItem(View view, RecyclerView.ViewHolder viewHolder, float f) {
            this.DEFAULTMAXOFFSETVALUE = 50.0f;
            this.DEFAULTMINOFFSETVALUE = -50.0f;
            this.mTranslateView = view;
            this.mViewHolder = viewHolder;
            this.mScrollOffsetRatio = f;
            this.mMaxThreshold = 50.0f * f;
            this.mMinThreshold = -50.0f * f;
            this.mOriginalTransilationY = view.getTranslationY();
        }
    }
}
