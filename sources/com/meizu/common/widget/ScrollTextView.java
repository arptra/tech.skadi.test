package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Scroller;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.meizu.common.R;
import com.meizu.common.util.CommonUtils;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScrollTextView extends View {
    private static final float DAMPING_DEFAULT = 0.98f;
    private static final int DEF_VISIBLE_ITEMS = 5;
    private static final int DEF_YSCROLL_END = Integer.MAX_VALUE;
    private static final float FRICTION_SCALAR = 0.98f;
    private static final int SCROLLER_SCROLL = 21000;
    private static final float STIFFNESS_DEFAULT = 30.0f;
    private static final String TAG = "ScrollTextView";
    public static final int VIBRATOR_INTERNAL = 15;
    /* access modifiers changed from: private */
    public static long mLastVibratorTime;
    boolean isCyclic;
    /* access modifiers changed from: private */
    public boolean isScrollingPerformed;
    private boolean isShowMarquee;
    private final List<OnScrollTextViewChangedListener> mChangingListeners;
    private final List<OnScrollTextViewClickedListener> mClickingListeners;
    private Context mContext;
    private int mCurrentItem;
    /* access modifiers changed from: private */
    public float mDamping;
    /* access modifiers changed from: private */
    public IDataAdapter mDataInterface;
    private float mFadingHeight;
    private Matrix mFadingMatrix;
    private Paint mFadingPaint;
    private Shader mFadingShader;
    private int mFirstItem;
    private float mFontMetricsCenterY;
    private boolean mIsDrawFading;
    private float mNormalFontMetricsCenterY;
    private float mNormalItemHeight;
    private int mNormalTextColor;
    private List<Integer> mNormalTextColors;
    private float mNormalTextSize;
    private List<Float> mNormalTextSizes;
    private int mOffsetX;
    private int mOffsetY;
    private boolean mParentRequestDisallowInterceptTouchEvent;
    private VisibleItemsRange mRange;
    private final ScrollingListener mScrollingListener;
    private final List<OnScrollTextViewScrollListener> mScrollingListeners;
    /* access modifiers changed from: private */
    public int mScrollingOffset;
    private float mSelectFontMetricsCenterY;
    private float mSelectItemHeight;
    private int mSelectTextColor;
    private float mSelectTextSize;
    /* access modifiers changed from: private */
    public float mSelectedTextOffset;
    private SoudPoolHelper mSoundPoolHelper;
    /* access modifiers changed from: private */
    public SpringAnimation mSpringAnimation;
    /* access modifiers changed from: private */
    public float mStiffness;
    private final Paint mTextPaint;
    /* access modifiers changed from: private */
    public final Runnable mTextRunnable;
    /* access modifiers changed from: private */
    public ScrollTextViewAdapter mViewAdapter;
    private int mVisibleItems;
    /* access modifiers changed from: private */
    public ScrollTextViewScroller mWheelScroller;

    public class AnimationHandler extends Handler {
        private final WeakReference<ScrollTextViewScroller> mScrollTextViewScroller;

        public AnimationHandler(ScrollTextViewScroller scrollTextViewScroller) {
            this.mScrollTextViewScroller = new WeakReference<>(scrollTextViewScroller);
        }

        public void handleMessage(@NonNull Message message) {
            ScrollTextViewScroller scrollTextViewScroller = this.mScrollTextViewScroller.get();
            if (scrollTextViewScroller != null && !scrollTextViewScroller.mFling) {
                scrollTextViewScroller.scroller.computeScrollOffset();
                int currY = scrollTextViewScroller.scroller.getCurrY();
                int unused = scrollTextViewScroller.lastScrollY = currY;
                scrollTextViewScroller.listener.onScroll(scrollTextViewScroller.lastScrollY - currY);
                if (Math.abs(currY - scrollTextViewScroller.scroller.getFinalY()) < 1) {
                    scrollTextViewScroller.scroller.forceFinished(true);
                }
                if (!scrollTextViewScroller.scroller.isFinished()) {
                    int i = message.what;
                    if (i == 1 || i == 0) {
                        scrollTextViewScroller.animationHandler.sendEmptyMessage(message.what);
                    }
                } else if (message.what == 0) {
                    scrollTextViewScroller.justify();
                } else {
                    scrollTextViewScroller.finishScrolling();
                }
            }
        }
    }

    public interface IDataAdapter {
        String getItemText(int i);

        void onChanged(View view, int i, int i2);
    }

    public interface OnScrollTextViewChangedListener {
        void onChanged(ScrollTextView scrollTextView, int i, int i2);
    }

    public interface OnScrollTextViewClickedListener {
        void onItemClicked(ScrollTextView scrollTextView, int i);
    }

    public interface OnScrollTextViewScrollListener {
        void onScrollingFinished(ScrollTextView scrollTextView);

        void onScrollingStarted(ScrollTextView scrollTextView);
    }

    public class PlaySoundScrollTextViewChangedListener implements OnScrollTextViewChangedListener {
        private PlaySoundScrollTextViewChangedListener() {
        }

        public void onChanged(ScrollTextView scrollTextView, int i, int i2) {
            ScrollTextView.this.playSelectedSound();
        }
    }

    public class ScrollTextViewAdapter {
        public static final int DEFAULT_MAX_VALUE = 9;
        private static final int DEFAULT_MIN_VALUE = 0;
        private int count;
        private int validEnd;
        private int validStart;

        public ScrollTextViewAdapter(ScrollTextView scrollTextView) {
            this(10, 0, 9);
        }

        public String getItemText(int i) {
            if (i < 0 || i >= getItemsCount() || ScrollTextView.this.mDataInterface == null) {
                return null;
            }
            return ScrollTextView.this.mDataInterface.getItemText(i);
        }

        public int getItemsCount() {
            return this.count;
        }

        public int getValidEnd() {
            return this.validEnd;
        }

        public int getValidStart() {
            return this.validStart;
        }

        public void setItemCount(int i) {
            this.count = i;
        }

        public ScrollTextViewAdapter update(int i, int i2, int i3) {
            this.validStart = i2;
            this.validEnd = i3;
            this.count = i;
            return this;
        }

        public ScrollTextViewAdapter(ScrollTextView scrollTextView, int i, int i2) {
            this((i2 - i) + 1, i, i2);
        }

        public ScrollTextViewAdapter(int i, int i2, int i3) {
            this.validStart = 0;
            this.validEnd = 0;
            this.count = 0;
            update(i, i2, i3);
        }
    }

    public class ScrollTextViewScroller {
        public static final int MIN_DELTA_FOR_SCROLLING = 1;
        private static final int SCROLLING_DURATION = 650;
        private static final int SCROLLING_DURATION_EXTEND = 1000;
        private final int MESSAGE_FLING = 2;
        private final int MESSAGE_JUSTIFY = 1;
        private final int MESSAGE_SCROLL = 0;
        /* access modifiers changed from: private */
        public final Handler animationHandler;
        private final Context context;
        private final GestureDetector gestureDetector;
        private final GestureDetector.SimpleOnGestureListener gestureListener;
        private boolean isScrollingPerformed;
        /* access modifiers changed from: private */
        public int lastScrollY;
        private float lastTouchedY;
        /* access modifiers changed from: private */
        public final ScrollingListener listener;
        /* access modifiers changed from: private */
        public boolean mFling;
        /* access modifiers changed from: private */
        public Scroller scroller;

        public ScrollTextViewScroller(Context context2, ScrollingListener scrollingListener) {
            AnonymousClass1 r0 = new GestureDetector.SimpleOnGestureListener() {
                private boolean isOutArray(int i) {
                    return !ScrollTextView.this.isCyclic() && (ScrollTextView.this.getCurrentItem() + (i / ScrollTextView.this.getCurrentItem()) < ScrollTextView.this.getScrollStartItem() || ScrollTextView.this.getCurrentItem() + (i / ScrollTextView.this.getCurrentItem()) > ScrollTextView.this.getScrollEndItem());
                }

                private void startFling(int i, int i2) {
                    ScrollTextView.this.cancelSpringAnimation();
                    if (ScrollTextView.this.mSpringAnimation == null) {
                        SpringAnimation unused = ScrollTextView.this.mSpringAnimation = new SpringAnimation(new FloatValueHolder());
                        ScrollTextView.this.mSpringAnimation.b(new DynamicAnimation.OnAnimationEndListener() {
                            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                                ScrollTextViewScroller.this.finishScrolling();
                            }
                        });
                        ScrollTextView.this.mSpringAnimation.c(new DynamicAnimation.OnAnimationUpdateListener() {
                            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                                ScrollTextViewScroller.this.setNextMessage(2);
                            }
                        });
                    }
                    SpringForce springForce = new SpringForce();
                    springForce.e((float) i2);
                    springForce.f(ScrollTextView.this.mStiffness);
                    springForce.d(ScrollTextView.this.mDamping);
                    ScrollTextView.this.mSpringAnimation.y(springForce);
                    ScrollTextView.this.mSpringAnimation.o((float) i);
                    ScrollTextView.this.mSpringAnimation.q();
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    int unused = ScrollTextViewScroller.this.lastScrollY = 0;
                    int i = (int) (-f2);
                    ScrollTextViewScroller.this.scroller.fling(0, ScrollTextViewScroller.this.lastScrollY, 0, i, 0, 0, ScrollTextView.this.getYScrollStart(), ScrollTextView.this.getYScrollEnd());
                    int finalY = ScrollTextViewScroller.this.scroller.getFinalY();
                    int itemHeight = finalY % ScrollTextView.this.getItemHeight();
                    if (itemHeight != 0) {
                        int itemHeight2 = itemHeight > 0 ? finalY + (ScrollTextView.this.getItemHeight() - itemHeight) : finalY - (ScrollTextView.this.getItemHeight() + itemHeight);
                        finalY = ScrollTextView.this.mScrollingOffset > 0 ? (itemHeight2 + ScrollTextView.this.mScrollingOffset) - ScrollTextView.this.getItemHeight() : itemHeight2 + ScrollTextView.this.getItemHeight() + ScrollTextView.this.mScrollingOffset;
                        if (finalY > ScrollTextView.this.getItemHeight()) {
                            finalY -= ScrollTextView.this.getItemHeight();
                        } else if (finalY < (-ScrollTextView.this.getItemHeight())) {
                            finalY += ScrollTextView.this.getItemHeight();
                        }
                        ScrollTextViewScroller.this.scroller.setFinalY(finalY);
                    }
                    startFling(i, finalY);
                    return true;
                }

                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return true;
                }
            };
            this.gestureListener = r0;
            this.animationHandler = new AnimationHandler(this);
            GestureDetector gestureDetector2 = new GestureDetector(context2, r0);
            this.gestureDetector = gestureDetector2;
            gestureDetector2.setIsLongpressEnabled(false);
            this.scroller = new Scroller(context2, new PathInterpolator(0.3f, 1.56f, 0.3f, 1.0f));
            this.listener = scrollingListener;
            this.context = context2;
        }

        /* access modifiers changed from: private */
        public void clearMessages() {
            this.animationHandler.removeMessages(0);
            this.animationHandler.removeMessages(1);
            this.animationHandler.removeMessages(2);
        }

        /* access modifiers changed from: private */
        public void justify() {
            this.listener.onJustify();
            setNextMessage(1);
        }

        /* access modifiers changed from: private */
        public void setNextMessage(int i) {
            clearMessages();
            this.animationHandler.sendEmptyMessage(i);
        }

        private void startScrolling() {
            if (!this.isScrollingPerformed) {
                this.isScrollingPerformed = true;
                this.listener.onStarted();
            }
        }

        public void finishScrolling() {
            if (this.isScrollingPerformed) {
                this.listener.onFinished();
                this.isScrollingPerformed = false;
            }
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mFling = false;
                this.lastTouchedY = motionEvent.getY();
                this.scroller.forceFinished(true);
                ScrollTextView.this.cancelSpringAnimation();
                clearMessages();
                finishScrolling();
            } else if (action == 2) {
                this.mFling = false;
                int y = (int) (motionEvent.getY() - this.lastTouchedY);
                if (y != 0) {
                    startScrolling();
                    this.listener.onScroll(y);
                    this.lastTouchedY = motionEvent.getY();
                }
            } else if (action == 3) {
                justify();
            }
            if (!this.gestureDetector.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                justify();
            }
            return true;
        }

        public void scroll(int i, int i2) {
            this.scroller.forceFinished(true);
            this.lastScrollY = 0;
            Scroller scroller2 = this.scroller;
            if (i2 == 0) {
                i2 = SCROLLING_DURATION;
            }
            scroller2.startScroll(0, 0, 0, i, i2);
            setNextMessage(0);
            startScrolling();
        }

        public void setInterpolator(Interpolator interpolator) {
            this.scroller.forceFinished(true);
            this.scroller = new Scroller(this.context, interpolator);
        }

        public void stopScrolling() {
            this.scroller.forceFinished(true);
        }
    }

    public interface ScrollingListener {
        void onFinished();

        void onJustify();

        void onScroll(int i);

        void onStarted();
    }

    public static class SoudPoolHelper {
        public Context mContext;
        public boolean mIsFinishedLoad;
        public boolean mIsRelease;
        /* access modifiers changed from: private */
        public Handler mSoundHander;
        /* access modifiers changed from: private */
        public Looper mSoundLooper;
        public SoundPool mSoundPool;
        private Thread mSoundPoolThread;
        public int mVoiceID;

        private SoudPoolHelper() {
            this.mSoundPoolThread = null;
            this.mSoundHander = null;
            this.mSoundLooper = null;
        }

        public void initSoundPool(Context context) {
            this.mContext = context.getApplicationContext();
            this.mIsFinishedLoad = false;
            Thread thread = new Thread(new Runnable() {
                static final /* synthetic */ boolean $assertionsDisabled = false;

                /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                    android.os.Looper.loop();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
                    r5 = r5.this$0.mSoundPool;
                 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0076 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        android.media.SoundPool$Builder r0 = new android.media.SoundPool$Builder
                        r0.<init>()
                        r1 = 1
                        r0.setMaxStreams(r1)
                        android.media.AudioAttributes$Builder r2 = new android.media.AudioAttributes$Builder
                        r2.<init>()
                        r2.setLegacyStreamType(r1)
                        android.media.AudioAttributes r2 = r2.build()
                        r0.setAudioAttributes(r2)
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r2 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this
                        android.media.SoundPool r0 = r0.build()
                        r2.mSoundPool = r0
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r0 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this
                        android.media.SoundPool r0 = r0.mSoundPool
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper$1$1 r2 = new com.meizu.common.widget.ScrollTextView$SoudPoolHelper$1$1
                        r2.<init>()
                        r0.setOnLoadCompleteListener(r2)
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r0 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this     // Catch:{ Exception -> 0x0076 }
                        android.media.SoundPool r2 = r0.mSoundPool     // Catch:{ Exception -> 0x0076 }
                        android.content.Context r3 = r0.mContext     // Catch:{ Exception -> 0x0076 }
                        int r4 = com.meizu.common.R.raw.mc_picker_scrolled     // Catch:{ Exception -> 0x0076 }
                        int r1 = r2.load(r3, r4, r1)     // Catch:{ Exception -> 0x0076 }
                        r0.mVoiceID = r1     // Catch:{ Exception -> 0x0076 }
                        android.os.Looper.prepare()     // Catch:{ Exception -> 0x0076 }
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r0 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this     // Catch:{ Exception -> 0x0076 }
                        monitor-enter(r0)     // Catch:{ Exception -> 0x0076 }
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r1 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this     // Catch:{ all -> 0x004d }
                        boolean r2 = r1.mIsRelease     // Catch:{ all -> 0x004d }
                        if (r2 == 0) goto L_0x004f
                        monitor-exit(r0)     // Catch:{ all -> 0x004d }
                        android.media.SoundPool r5 = r1.mSoundPool
                        r5.release()
                        return
                    L_0x004d:
                        r1 = move-exception
                        goto L_0x0074
                    L_0x004f:
                        android.os.Looper r2 = android.os.Looper.myLooper()     // Catch:{ all -> 0x004d }
                        android.os.Looper unused = r1.mSoundLooper = r2     // Catch:{ all -> 0x004d }
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r1 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this     // Catch:{ all -> 0x004d }
                        android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x004d }
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r3 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this     // Catch:{ all -> 0x004d }
                        android.os.Looper r3 = r3.mSoundLooper     // Catch:{ all -> 0x004d }
                        r2.<init>(r3)     // Catch:{ all -> 0x004d }
                        android.os.Handler unused = r1.mSoundHander = r2     // Catch:{ all -> 0x004d }
                        monitor-exit(r0)     // Catch:{ all -> 0x004d }
                        android.os.Looper.loop()     // Catch:{ Exception -> 0x0076 }
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r5 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this
                        android.media.SoundPool r5 = r5.mSoundPool
                    L_0x006e:
                        r5.release()
                        goto L_0x007e
                    L_0x0072:
                        r0 = move-exception
                        goto L_0x007f
                    L_0x0074:
                        monitor-exit(r0)     // Catch:{ all -> 0x004d }
                        throw r1     // Catch:{ Exception -> 0x0076 }
                    L_0x0076:
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r0 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this     // Catch:{ all -> 0x0072 }
                        r1 = 0
                        r0.mIsFinishedLoad = r1     // Catch:{ all -> 0x0072 }
                        android.media.SoundPool r5 = r0.mSoundPool
                        goto L_0x006e
                    L_0x007e:
                        return
                    L_0x007f:
                        com.meizu.common.widget.ScrollTextView$SoudPoolHelper r5 = com.meizu.common.widget.ScrollTextView.SoudPoolHelper.this
                        android.media.SoundPool r5 = r5.mSoundPool
                        r5.release()
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ScrollTextView.SoudPoolHelper.AnonymousClass1.run():void");
                }
            });
            this.mSoundPoolThread = thread;
            thread.start();
        }

        public void onAttachedToWindow(Context context) {
            if (!this.mIsFinishedLoad) {
                initSoundPool(context);
            }
        }

        public void play() {
            Handler handler = this.mSoundHander;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        SoudPoolHelper soudPoolHelper = SoudPoolHelper.this;
                        if (soudPoolHelper.mIsFinishedLoad) {
                            soudPoolHelper.mSoundPool.play(soudPoolHelper.mVoiceID, 0.5f, 0.5f, 0, 0, 1.0f);
                        }
                    }
                });
            }
        }

        public void release() {
            synchronized (this) {
                try {
                    this.mIsRelease = true;
                    Handler handler = this.mSoundHander;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object) null);
                        if (this.mIsFinishedLoad) {
                            this.mSoundPool.unload(this.mVoiceID);
                        }
                        this.mSoundPool.release();
                        this.mSoundLooper.quit();
                        this.mSoundPoolThread = null;
                        this.mIsFinishedLoad = false;
                        this.mContext = null;
                        this.mSoundHander = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class VisibleItemsRange {
        private int count;
        private int first;

        public VisibleItemsRange() {
            this(0, 0);
        }

        public int getCount() {
            return this.count;
        }

        public int getFirst() {
            return this.first;
        }

        public int getLast() {
            return (getFirst() + getCount()) - 1;
        }

        public VisibleItemsRange update(int i, int i2) {
            this.first = i;
            this.count = i2;
            return this;
        }

        public VisibleItemsRange(int i, int i2) {
            this.first = i;
            this.count = i2;
        }
    }

    public class vibratorScrollTextViewChangedListener implements OnScrollTextViewChangedListener {
        private vibratorScrollTextViewChangedListener() {
        }

        public void onChanged(ScrollTextView scrollTextView, int i, int i2) {
            if ("m2392".equalsIgnoreCase(CommonUtils.getDeviceName())) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ScrollTextView.mLastVibratorTime >= 15) {
                    long unused = ScrollTextView.mLastVibratorTime = currentTimeMillis;
                    ScrollTextView.this.isVibratorIfNeed();
                    return;
                }
                return;
            }
            ScrollTextView.this.isVibratorIfNeed();
        }
    }

    public ScrollTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextPaint = new Paint(1);
        this.mCurrentItem = 0;
        this.mVisibleItems = 5;
        this.mSelectItemHeight = 0.0f;
        this.mNormalItemHeight = 0.0f;
        this.isCyclic = false;
        this.mIsDrawFading = true;
        this.mParentRequestDisallowInterceptTouchEvent = true;
        this.mSelectedTextOffset = 0.0f;
        this.isShowMarquee = true;
        this.mStiffness = STIFFNESS_DEFAULT;
        this.mDamping = 0.98f;
        this.mTextRunnable = new Runnable() {
            public void run() {
                ScrollTextView.this.doSelectedTextScroll();
                ScrollTextView.this.postInvalidate();
            }
        };
        this.mChangingListeners = new LinkedList();
        this.mScrollingListeners = new LinkedList();
        this.mClickingListeners = new LinkedList();
        this.mScrollingListener = new ScrollingListener() {
            public void onFinished() {
                if (ScrollTextView.this.isScrollingPerformed) {
                    ScrollTextView.this.notifyScrollingListenersAboutEnd();
                    boolean unused = ScrollTextView.this.isScrollingPerformed = false;
                }
                int unused2 = ScrollTextView.this.mScrollingOffset = 0;
                ScrollTextView scrollTextView = ScrollTextView.this;
                scrollTextView.removeCallbacks(scrollTextView.mTextRunnable);
                ScrollTextView scrollTextView2 = ScrollTextView.this;
                float unused3 = scrollTextView2.mSelectedTextOffset = ((float) scrollTextView2.getWidth()) / 2.0f;
                ScrollTextView.this.doSelectedTextScroll();
                ScrollTextView.this.invalidate();
            }

            public void onJustify() {
                int i;
                int itemHeight;
                int access$700;
                ScrollTextView scrollTextView = ScrollTextView.this;
                if (scrollTextView.isCyclic || scrollTextView.getCurrentItem() >= ScrollTextView.this.mViewAdapter.getValidStart()) {
                    ScrollTextView scrollTextView2 = ScrollTextView.this;
                    if (!scrollTextView2.isCyclic && scrollTextView2.getCurrentItem() > ScrollTextView.this.mViewAdapter.getValidEnd()) {
                        ScrollTextView scrollTextView3 = ScrollTextView.this;
                        scrollTextView3.scroll(scrollTextView3.mViewAdapter.getValidEnd() - ScrollTextView.this.getCurrentItem(), 0);
                    } else if (Math.abs(ScrollTextView.this.mScrollingOffset) > ScrollTextView.this.getItemHeight() / 2) {
                        if (ScrollTextView.this.mScrollingOffset > 0) {
                            itemHeight = -ScrollTextView.this.getItemHeight();
                            access$700 = ScrollTextView.this.mScrollingOffset;
                        } else if (ScrollTextView.this.mScrollingOffset < 0) {
                            itemHeight = ScrollTextView.this.getItemHeight();
                            access$700 = ScrollTextView.this.mScrollingOffset;
                        } else {
                            i = 0;
                            ScrollTextView.this.mWheelScroller.scroll(i, 0);
                        }
                        i = itemHeight + access$700;
                        ScrollTextView.this.mWheelScroller.scroll(i, 0);
                    } else if (ScrollTextView.this.mScrollingOffset != 0) {
                        ScrollTextView.this.mWheelScroller.scroll(ScrollTextView.this.mScrollingOffset, (Math.abs(ScrollTextView.this.mScrollingOffset) * 650) / (ScrollTextView.this.getItemHeight() / 2));
                    }
                } else {
                    ScrollTextView scrollTextView4 = ScrollTextView.this;
                    scrollTextView4.scroll(scrollTextView4.mViewAdapter.getValidStart() - ScrollTextView.this.getCurrentItem(), 0);
                }
            }

            public void onScroll(int i) {
                ScrollTextView.this.doScroll(i);
                int height = ScrollTextView.this.getHeight();
                if (ScrollTextView.this.mScrollingOffset > height) {
                    int unused = ScrollTextView.this.mScrollingOffset = height;
                    ScrollTextView.this.mWheelScroller.stopScrolling();
                    return;
                }
                int i2 = -height;
                if (ScrollTextView.this.mScrollingOffset < i2) {
                    int unused2 = ScrollTextView.this.mScrollingOffset = i2;
                    ScrollTextView.this.mWheelScroller.stopScrolling();
                }
            }

            public void onStarted() {
                boolean unused = ScrollTextView.this.isScrollingPerformed = true;
                ScrollTextView scrollTextView = ScrollTextView.this;
                scrollTextView.removeCallbacks(scrollTextView.mTextRunnable);
                ScrollTextView.this.notifyScrollingListenersAboutStart();
            }
        };
        initData(context);
    }

    /* access modifiers changed from: private */
    public void cancelSpringAnimation() {
        SpringAnimation springAnimation = this.mSpringAnimation;
        if (springAnimation != null && springAnimation.h()) {
            this.mSpringAnimation.d();
        }
    }

    private void computeFontMetrics() {
        this.mTextPaint.setTextSize(this.mSelectTextSize);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.mSelectFontMetricsCenterY = ((float) (fontMetricsInt.bottom + fontMetricsInt.top)) / 2.0f;
        this.mTextPaint.setTextSize(this.mNormalTextSize);
        Paint.FontMetricsInt fontMetricsInt2 = this.mTextPaint.getFontMetricsInt();
        this.mNormalFontMetricsCenterY = ((float) (fontMetricsInt2.bottom + fontMetricsInt2.top)) / 2.0f;
    }

    private void computeTextSizeAndColor(int i, float f) {
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        int i3 = this.mVisibleItems;
        int i4 = i3 / 2;
        int i5 = this.mSelectTextColor;
        if (i < i4 || i > i4 + 1) {
            this.mFontMetricsCenterY = this.mNormalFontMetricsCenterY;
        } else {
            float f6 = this.mNormalFontMetricsCenterY;
            this.mFontMetricsCenterY = f6 + ((this.mSelectFontMetricsCenterY - f6) * f);
        }
        if (i > i4) {
            i = i3 - i;
        }
        if (i > i4) {
            i = i4;
        }
        if (i < 0) {
            i = 0;
        }
        if (i == 0) {
            i5 = this.mNormalTextColors.get(i).intValue();
            i2 = this.mNormalTextColors.get(i).intValue();
            float floatValue = this.mNormalTextSizes.get(i).floatValue();
            f2 = this.mNormalTextSizes.get(i).floatValue();
            f3 = 0.0f;
            f4 = floatValue;
            f5 = 0.0f;
        } else if (i < i4) {
            i5 = this.mNormalTextColors.get(i).intValue();
            int i6 = i - 1;
            int intValue = this.mNormalTextColors.get(i6).intValue();
            float floatValue2 = this.mNormalTextSizes.get(i).floatValue();
            f3 = 0.0f;
            float floatValue3 = this.mNormalTextSizes.get(i6).floatValue();
            f4 = floatValue2;
            f2 = floatValue3;
            int i7 = intValue;
            f5 = f;
            i2 = i7;
        } else {
            int i8 = i - 1;
            int intValue2 = this.mNormalTextColors.get(i8).intValue();
            f4 = this.mSelectTextSize;
            f2 = this.mNormalTextSizes.get(i8).floatValue();
            f3 = 2.0f;
            int i9 = intValue2;
            f5 = f;
            i2 = i9;
        }
        int alpha = Color.alpha(i5);
        int red = Color.red(i5);
        int green = Color.green(i5);
        int blue = Color.blue(i5);
        int alpha2 = Color.alpha(i2);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        this.mTextPaint.setColor(Color.argb(alpha2 + ((int) (((float) (alpha - alpha2)) * f5)), red2 + ((int) (((float) (red - red2)) * f5)), green2 + ((int) (((float) (green - green2)) * f5)), blue2 + ((int) (((float) (blue - blue2)) * f5))));
        this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mTextPaint.setStrokeWidth(0.0f + ((f3 - 0.0f) * f5));
        this.mTextPaint.setTextSize(f2 + ((f4 - f2) * f5));
    }

    private float configTextView(int i, float f) {
        float f2;
        float itemHeight = (float) getItemHeight();
        int i2 = (int) (this.mSelectItemHeight - this.mNormalItemHeight);
        int i3 = this.mVisibleItems / 2;
        if (i >= i3) {
            if (i == i3) {
                f2 = (float) i2;
            } else {
                if (i == i3 + 1) {
                    itemHeight += ((float) i2) / 2.0f;
                } else if (i == i3 + 2) {
                    f2 = (float) i2;
                    f = 1.0f - f;
                }
                f = 1.0f - f;
            }
            itemHeight += (f2 * f) / 2.0f;
        }
        computeTextSizeAndColor(i, f);
        return itemHeight;
    }

    /* access modifiers changed from: private */
    public void doScroll(int i) {
        if (!isCyclic()) {
            if (this.mCurrentItem == getScrollStartItem()) {
                int i2 = this.mScrollingOffset;
                if (i2 + i > 0) {
                    i = -i2;
                }
                if (i == 0) {
                    return;
                }
            } else if (this.mCurrentItem == getScrollEndItem()) {
                int i3 = this.mScrollingOffset;
                if (i3 + i < 0) {
                    i = -i3;
                }
                if (i == 0) {
                    return;
                }
            }
        }
        int itemsCount = this.mViewAdapter.getItemsCount();
        if (itemsCount == 1) {
            this.mScrollingOffset = 0;
        } else {
            this.mScrollingOffset += i;
        }
        int itemHeight = getItemHeight();
        int i4 = this.mScrollingOffset / itemHeight;
        int i5 = this.mCurrentItem - i4;
        if (this.isCyclic && itemsCount > 0) {
            while (i5 < 0) {
                i5 += itemsCount;
            }
            i5 %= itemsCount;
        } else if (i5 < getScrollStartItem()) {
            i4 = this.mCurrentItem - getScrollStartItem();
            i5 = getScrollStartItem();
        } else if (i5 > getScrollEndItem()) {
            i4 = this.mCurrentItem - getScrollEndItem();
            i5 = getScrollEndItem();
        } else if (i5 != getScrollEndItem()) {
            getScrollStartItem();
        }
        int i6 = this.mScrollingOffset;
        if (i5 != this.mCurrentItem) {
            setCurrentItem(i5, false);
        } else {
            invalidate();
        }
        int i7 = i6 - (i4 * itemHeight);
        this.mScrollingOffset = i7;
        if (i7 > getHeight() && getHeight() != 0) {
            this.mScrollingOffset = (this.mScrollingOffset % getHeight()) + getHeight();
        }
    }

    /* access modifiers changed from: private */
    public void doSelectedTextScroll() {
        if (this.isScrollingPerformed) {
            postInvalidate();
        } else {
            postDelayed(this.mTextRunnable, 10);
        }
    }

    private void drawItems(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = getWidth() / 2;
        float measureText = this.mTextPaint.measureText("AA");
        float itemHeight = (float) (((-(((this.mCurrentItem - this.mFirstItem) * getItemHeight()) + ((((int) this.mSelectItemHeight) - getHeight()) / 2))) + this.mScrollingOffset) - getItemHeight());
        canvas2.translate((float) this.mOffsetX, itemHeight);
        int i = this.mScrollingOffset;
        if (i <= 0) {
            i = getItemHeight() + this.mScrollingOffset;
        }
        float f = 1.0f;
        float itemHeight2 = (((float) i) * 1.0f) / ((float) getItemHeight());
        int i2 = 0;
        while (i2 < this.mRange.getCount()) {
            float configTextView = configTextView(i2, itemHeight2);
            canvas2.translate(0.0f, configTextView);
            itemHeight += configTextView;
            String itemText = getItemText(i2);
            float f2 = (this.mNormalItemHeight / 2.0f) - this.mFontMetricsCenterY;
            if (this.isScrollingPerformed || this.mTextPaint.getTextSize() != this.mSelectTextSize) {
                canvas2.drawText(itemText, (float) width, f2, this.mTextPaint);
            } else {
                float measureText2 = this.mTextPaint.measureText(itemText);
                if (!isShowMarquee() || measureText2 <= ((float) getWidth())) {
                    removeCallbacks(this.mTextRunnable);
                    canvas2.drawText(itemText, (float) width, f2, this.mTextPaint);
                } else {
                    float f3 = this.mSelectedTextOffset - f;
                    this.mSelectedTextOffset = f3;
                    float f4 = (float) width;
                    float width2 = f4 - ((measureText2 - ((float) getWidth())) / 2.0f);
                    if (f3 >= width2 - ((float) getWidth())) {
                        canvas2.drawText(itemText, this.mSelectedTextOffset, f2, this.mTextPaint);
                    }
                    float f5 = this.mSelectedTextOffset;
                    if (f5 <= width2 - measureText && f5 >= ((width2 - measureText2) - ((float) getWidth())) - measureText) {
                        canvas2.drawText(itemText, this.mSelectedTextOffset + measureText2 + measureText, f2, this.mTextPaint);
                    }
                    float f6 = this.mSelectedTextOffset;
                    float f7 = measureText * 2.0f;
                    if (f6 <= (width2 - measureText2) - f7) {
                        canvas2.drawText(itemText, f6 + ((measureText2 + measureText) * 2.0f), f2, this.mTextPaint);
                    }
                    if (this.mSelectedTextOffset <= (-(((measureText2 * 2.0f) - f4) + f7))) {
                        removeCallbacks(this.mTextRunnable);
                    }
                }
            }
            i2++;
            f = 1.0f;
        }
        canvas2.translate(0.0f, -itemHeight);
    }

    private void drawVerticalFading(Canvas canvas) {
        this.mFadingMatrix.setScale(1.0f, this.mFadingHeight);
        this.mFadingShader.setLocalMatrix(this.mFadingMatrix);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), this.mFadingHeight, this.mFadingPaint);
        this.mFadingMatrix.setScale(1.0f, this.mFadingHeight);
        this.mFadingMatrix.postRotate(180.0f);
        this.mFadingMatrix.postTranslate(0.0f, (float) getHeight());
        this.mFadingShader.setLocalMatrix(this.mFadingMatrix);
        canvas.drawRect(0.0f, ((float) getHeight()) - this.mFadingHeight, (float) getWidth(), (float) getHeight(), this.mFadingPaint);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getItemText(int r4) {
        /*
            r3 = this;
            int r0 = r3.mFirstItem
            int r4 = r4 + r0
            com.meizu.common.widget.ScrollTextView$ScrollTextViewAdapter r0 = r3.mViewAdapter
            java.lang.String r0 = r0.getItemText(r4)
            java.lang.String r1 = ""
            if (r4 >= 0) goto L_0x0022
            com.meizu.common.widget.ScrollTextView$ScrollTextViewAdapter r0 = r3.mViewAdapter
            int r0 = r0.getItemsCount()
            int r0 = r0 + r4
            boolean r4 = r3.isCyclic
            if (r4 == 0) goto L_0x0020
            com.meizu.common.widget.ScrollTextView$ScrollTextViewAdapter r3 = r3.mViewAdapter
            java.lang.String r3 = r3.getItemText(r0)
        L_0x001e:
            r0 = r3
            goto L_0x003c
        L_0x0020:
            r0 = r1
            goto L_0x003c
        L_0x0022:
            com.meizu.common.widget.ScrollTextView$ScrollTextViewAdapter r2 = r3.mViewAdapter
            int r2 = r2.getItemsCount()
            if (r4 < r2) goto L_0x003c
            com.meizu.common.widget.ScrollTextView$ScrollTextViewAdapter r0 = r3.mViewAdapter
            int r0 = r0.getItemsCount()
            int r4 = r4 - r0
            boolean r0 = r3.isCyclic
            if (r0 == 0) goto L_0x0020
            com.meizu.common.widget.ScrollTextView$ScrollTextViewAdapter r3 = r3.mViewAdapter
            java.lang.String r3 = r3.getItemText(r4)
            goto L_0x001e
        L_0x003c:
            if (r0 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r1 = r0
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ScrollTextView.getItemText(int):java.lang.String");
    }

    private VisibleItemsRange getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i = this.mCurrentItem;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 2;
            if (getItemHeight() * i3 >= getHeight()) {
                break;
            }
            i--;
            i2 = i3;
        }
        int i4 = this.mScrollingOffset;
        if (i4 != 0) {
            if (i4 > 0) {
                i--;
            }
            int itemHeight = i4 / getItemHeight();
            i -= itemHeight;
            i2 = (int) (((double) (i2 + 1)) + Math.asin((double) itemHeight));
        }
        return this.mRange.update(i, i2);
    }

    /* access modifiers changed from: private */
    public int getScrollEndItem() {
        int itemsCount = this.mViewAdapter.getItemsCount();
        if (this.isCyclic) {
            return 0;
        }
        int i = this.mVisibleItems;
        return itemsCount - 1;
    }

    /* access modifiers changed from: private */
    public int getScrollStartItem() {
        this.mViewAdapter.getItemsCount();
        return 0;
    }

    /* access modifiers changed from: private */
    public int getYScrollEnd() {
        if (this.isCyclic) {
            return Integer.MAX_VALUE;
        }
        return ((int) (((float) (getScrollEndItem() - getCurrentItem())) * this.mNormalItemHeight)) + this.mScrollingOffset;
    }

    /* access modifiers changed from: private */
    public int getYScrollStart() {
        if (this.isCyclic) {
            return -2147483647;
        }
        return ((int) (((float) (getScrollStartItem() - getCurrentItem())) * this.mNormalItemHeight)) + this.mScrollingOffset;
    }

    private void initColor(Context context) {
        this.mSelectTextColor = context.getResources().getColor(R.color.fd_sys_color_on_surface_default);
        int color = context.getResources().getColor(R.color.fd_sys_color_on_surface_variant_default);
        this.mNormalTextColor = color;
        setTextColor(this.mSelectTextColor, color);
    }

    private void initData(Context context) {
        this.mContext = context;
        this.mNormalTextSizes = new ArrayList();
        initLayout(context);
        initColor(context);
        this.mViewAdapter = new ScrollTextViewAdapter(this);
        this.mFadingMatrix = new Matrix();
        this.mFadingShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, context.getResources().getColor(R.color.fd_sys_color_surface_container_lowest_default), Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.mFadingPaint = paint;
        paint.setShader(this.mFadingShader);
        this.mFadingHeight = context.getResources().getDimension(R.dimen.mc_picker_fading_height);
        this.mRange = new VisibleItemsRange();
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        computeFontMetrics();
        this.mSoundPoolHelper = new SoudPoolHelper();
        addChangingListener(new PlaySoundScrollTextViewChangedListener());
        addChangingListener(new vibratorScrollTextViewChangedListener());
        this.mTextPaint.setAntiAlias(true);
    }

    private void initLayout(Context context) {
        this.mWheelScroller = new ScrollTextViewScroller(getContext(), this.mScrollingListener);
        this.mSelectTextSize = context.getResources().getDimension(R.dimen.mc_picker_selected_number_size);
        this.mNormalTextSize = context.getResources().getDimension(R.dimen.mc_picker_normal_number_size);
        this.mSelectItemHeight = context.getResources().getDimension(R.dimen.mc_picker_select_item_height);
        float dimension = context.getResources().getDimension(R.dimen.mc_picker_normal_item_height);
        this.mNormalItemHeight = dimension;
        setTextPreference(this.mSelectTextSize, this.mNormalTextSize, this.mSelectItemHeight, dimension);
    }

    private boolean isValidItemIndex(int i) {
        ScrollTextViewAdapter scrollTextViewAdapter = this.mViewAdapter;
        return scrollTextViewAdapter != null && scrollTextViewAdapter.getItemsCount() > 0 && (this.isCyclic || (i >= 0 && i < this.mViewAdapter.getItemsCount()));
    }

    /* access modifiers changed from: private */
    public void isVibratorIfNeed() {
        if (CommonUtils.hasFlymeFeature()) {
            performHapticFeedback(SCROLLER_SCROLL);
        }
    }

    /* access modifiers changed from: private */
    public void playSelectedSound() {
        SoudPoolHelper soudPoolHelper = this.mSoundPoolHelper;
        if (soudPoolHelper != null) {
            soudPoolHelper.play();
        }
    }

    private boolean rebuildItems() {
        VisibleItemsRange itemsRange = getItemsRange();
        this.mRange = itemsRange;
        if (this.mFirstItem <= itemsRange.getFirst() || this.mFirstItem > this.mRange.getLast()) {
            this.mFirstItem = this.mRange.getFirst();
            return false;
        }
        int i = this.mFirstItem;
        while (true) {
            i--;
            if (i < this.mRange.getFirst()) {
                return false;
            }
            this.mFirstItem = i;
        }
    }

    private void setViewAdapter(ScrollTextViewAdapter scrollTextViewAdapter) {
        this.mViewAdapter = scrollTextViewAdapter;
        invalidate();
    }

    public void addChangingListener(OnScrollTextViewChangedListener onScrollTextViewChangedListener) {
        this.mChangingListeners.add(onScrollTextViewChangedListener);
    }

    public void addClickingListener(OnScrollTextViewClickedListener onScrollTextViewClickedListener) {
        this.mClickingListeners.add(onScrollTextViewClickedListener);
    }

    public void addScrollingListener(OnScrollTextViewScrollListener onScrollTextViewScrollListener) {
        this.mScrollingListeners.add(onScrollTextViewScrollListener);
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public IDataAdapter getIDataAdapter() {
        return this.mDataInterface;
    }

    @RestrictTo
    public int getItemHeight() {
        return (int) this.mNormalItemHeight;
    }

    public int getItemsCount() {
        return this.mViewAdapter.getItemsCount();
    }

    @RestrictTo
    public int getSelectedItemHeight() {
        return (int) this.mSelectItemHeight;
    }

    public ScrollTextViewAdapter getViewAdapter() {
        return this.mViewAdapter;
    }

    public int getVisibleItems() {
        return this.mVisibleItems;
    }

    public boolean isCyclic() {
        return this.isCyclic;
    }

    public boolean isShowMarquee() {
        return this.isShowMarquee;
    }

    public int measureTextWidth(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        this.mTextPaint.setTextSize(this.mSelectTextSize);
        this.mTextPaint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil((double) fArr[i2]);
        }
        return i;
    }

    public void notifyChangingListeners(int i, int i2) {
        for (OnScrollTextViewChangedListener onChanged : this.mChangingListeners) {
            onChanged.onChanged(this, i, i2);
        }
    }

    public void notifyClickListenersAboutClick(int i) {
        setCurrentItem(i, true);
        for (OnScrollTextViewClickedListener onItemClicked : this.mClickingListeners) {
            onItemClicked.onItemClicked(this, i);
        }
    }

    public void notifyScrollingListenersAboutEnd() {
        IDataAdapter iDataAdapter = this.mDataInterface;
        if (iDataAdapter != null) {
            iDataAdapter.onChanged(this, 0, getCurrentItem());
        }
        for (OnScrollTextViewScrollListener onScrollingFinished : this.mScrollingListeners) {
            onScrollingFinished.onScrollingFinished(this);
        }
    }

    public void notifyScrollingListenersAboutStart() {
        for (OnScrollTextViewScrollListener onScrollingStarted : this.mScrollingListeners) {
            onScrollingStarted.onScrollingStarted(this);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SoudPoolHelper soudPoolHelper = this.mSoundPoolHelper;
        if (soudPoolHelper != null) {
            soudPoolHelper.onAttachedToWindow(this.mContext);
        }
        post(new Runnable() {
            public void run() {
                ScrollTextView scrollTextView = ScrollTextView.this;
                float unused = scrollTextView.mSelectedTextOffset = ((float) scrollTextView.getWidth()) / 2.0f;
                ScrollTextView.this.doSelectedTextScroll();
            }
        });
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SoudPoolHelper soudPoolHelper = this.mSoundPoolHelper;
        if (soudPoolHelper != null) {
            soudPoolHelper.release();
        }
        ScrollTextViewScroller scrollTextViewScroller = this.mWheelScroller;
        if (scrollTextViewScroller != null) {
            scrollTextViewScroller.clearMessages();
        }
        removeCallbacks(this.mTextRunnable);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ScrollTextViewAdapter scrollTextViewAdapter = this.mViewAdapter;
        if (scrollTextViewAdapter != null && scrollTextViewAdapter.getItemsCount() > 0) {
            rebuildItems();
            drawItems(canvas);
        }
        if (this.mIsDrawFading) {
            drawVerticalFading(canvas);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ScrollTextView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            setMeasuredDimension(getMeasuredWidthAndState(), (int) ((((float) (this.mVisibleItems - 1)) * this.mNormalItemHeight) + this.mSelectItemHeight));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(this.mParentRequestDisallowInterceptTouchEvent);
            }
        } else if (!this.isScrollingPerformed) {
            int y = ((int) motionEvent.getY()) - (getHeight() / 2);
            int itemHeight = ((int) (y < 0 ? ((float) y) + ((this.mSelectItemHeight / 2.0f) - ((float) getItemHeight())) : ((float) y) - ((this.mSelectItemHeight / 2.0f) - ((float) getItemHeight())))) / getItemHeight();
            if (itemHeight != 0 && isValidItemIndex(this.mCurrentItem + itemHeight)) {
                notifyClickListenersAboutClick(this.mCurrentItem + itemHeight);
            }
        }
        return this.mWheelScroller.onTouchEvent(motionEvent);
    }

    public void refreshCount(int i) {
        refreshData(i, this.mCurrentItem, 0, i - 1);
    }

    public void refreshCountAndCurrent(int i, int i2) {
        refreshData(i, i2, 0, i - 1);
    }

    public void refreshCurrent(int i) {
        refreshData(this.mViewAdapter.getItemsCount(), i, this.mViewAdapter.getValidStart(), this.mViewAdapter.getValidEnd());
    }

    public void refreshData(int i, int i2, int i3, int i4) {
        IDataAdapter iDataAdapter;
        stopScrolling();
        if (i >= 0) {
            setViewAdapter(this.mViewAdapter.update(i, i3, i4));
            int i5 = this.mCurrentItem;
            if (i2 != i5) {
                int max = Math.max(i2, i3);
                this.mCurrentItem = max;
                if (max > i4 || max >= i) {
                    this.mCurrentItem = Math.min(i4, i);
                }
            }
            int i6 = this.mCurrentItem;
            if (!(i5 == i6 || (iDataAdapter = this.mDataInterface) == null)) {
                iDataAdapter.onChanged(this, i5, i6);
            }
            invalidate();
        }
    }

    public void removeChangingListener(OnScrollTextViewChangedListener onScrollTextViewChangedListener) {
        this.mChangingListeners.remove(onScrollTextViewChangedListener);
    }

    public void removeClickingListener(OnScrollTextViewClickedListener onScrollTextViewClickedListener) {
        this.mClickingListeners.remove(onScrollTextViewClickedListener);
    }

    public void removeScrollingListener(OnScrollTextViewScrollListener onScrollTextViewScrollListener) {
        this.mScrollingListeners.remove(onScrollTextViewScrollListener);
    }

    public void scroll(int i, int i2) {
        this.mWheelScroller.scroll((i * getItemHeight()) + this.mScrollingOffset, i2);
    }

    public void setCurrentItem(int i, boolean z) {
        int min;
        ScrollTextViewAdapter scrollTextViewAdapter = this.mViewAdapter;
        if (scrollTextViewAdapter != null && scrollTextViewAdapter.getItemsCount() != 0) {
            int itemsCount = this.mViewAdapter.getItemsCount();
            if (i < 0 || i >= itemsCount) {
                if (this.isCyclic) {
                    while (i < 0) {
                        i += itemsCount;
                    }
                    i %= itemsCount;
                } else {
                    return;
                }
            }
            int i2 = this.mCurrentItem;
            if (i == i2) {
                return;
            }
            if (z) {
                int i3 = i - i2;
                if (this.isCyclic && (min = (itemsCount + Math.min(i, i2)) - Math.max(i, this.mCurrentItem)) < Math.abs(i3)) {
                    i3 = i3 < 0 ? min : -min;
                }
                scroll(i3, 0);
                return;
            }
            this.mScrollingOffset = 0;
            this.mCurrentItem = i;
            notifyChangingListeners(i2, i);
            invalidate();
        }
    }

    public void setCyclic(boolean z) {
        this.isCyclic = z;
        invalidate();
    }

    public void setData(IDataAdapter iDataAdapter, int i, int i2, int i3) {
        setData(iDataAdapter, -1.0f, i, i2, i3, 0, i2 - 1, true);
    }

    public void setFadingHeight(float f) {
        if (this.mFadingHeight != f) {
            this.mFadingHeight = f;
            invalidate();
        }
    }

    public void setFadingShader(Shader shader) {
        this.mFadingShader = shader;
        this.mFadingPaint.setShader(shader);
        invalidate();
    }

    public void setFadingShaderColor(@ColorInt int i) {
        this.mFadingShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, i, Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.mFadingPaint = paint;
        paint.setShader(this.mFadingShader);
    }

    public void setHorizontalOffset(int i) {
        this.mOffsetX = i;
    }

    public void setIDataAdapter(IDataAdapter iDataAdapter) {
        this.mDataInterface = iDataAdapter;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mWheelScroller.setInterpolator(interpolator);
    }

    public void setIsDrawFading(boolean z) {
        this.mIsDrawFading = z;
    }

    public void setItemHeight(float f, float f2) {
        setTextPreference(this.mSelectTextSize, this.mNormalTextSize, f, f2);
    }

    public void setNormalItemHeight(float f) {
        setTextPreference(this.mSelectTextSize, this.mNormalTextSize, this.mSelectItemHeight, f);
    }

    public void setNormalTextColor(@ColorInt int i) {
        if (this.mNormalTextColor != i) {
            setTextColor(this.mSelectTextColor, i);
        }
    }

    public void setNormalTextSize(float f) {
        setTextPreference(this.mSelectTextSize, f, this.mSelectItemHeight, this.mNormalItemHeight);
    }

    public void setParentRequestDisallowInterceptTouchEvent(boolean z) {
        this.mParentRequestDisallowInterceptTouchEvent = z;
    }

    public void setScrollY(int i) {
        int unused = this.mWheelScroller.lastScrollY = i;
        this.mWheelScroller.listener.onScroll(this.mWheelScroller.lastScrollY - i);
    }

    public void setSelectItemHeight(float f) {
        setTextPreference(this.mSelectTextSize, this.mNormalTextSize, f, this.mNormalItemHeight);
    }

    public void setSelectTextColor(@ColorInt int i) {
        if (this.mSelectTextColor != i) {
            setTextColor(i, this.mNormalTextColors);
        }
    }

    public void setSelectTextSize(float f) {
        setTextPreference(f, this.mNormalTextSize, this.mSelectItemHeight, this.mNormalItemHeight);
    }

    public void setShowMarquee(boolean z) {
        this.isShowMarquee = z;
    }

    public void setTextColor(@ColorInt int i, @ColorInt int i2) {
        this.mSelectTextColor = i;
        this.mNormalTextColor = i2;
        this.mNormalTextColors = new ArrayList();
        int i3 = this.mVisibleItems - 1;
        for (int i4 = 0; i4 < i3 / 2; i4++) {
            this.mNormalTextColors.add(Integer.valueOf(this.mNormalTextColor));
        }
        invalidate();
    }

    public void setTextPreference(float f, float f2, float f3, float f4) {
        this.mSelectItemHeight = f3;
        this.mNormalItemHeight = f4;
        this.mSelectTextSize = f;
        this.mNormalTextSize = f2;
        this.mNormalTextSizes = new ArrayList();
        int i = this.mVisibleItems - 1;
        for (int i2 = 0; i2 < i / 2; i2++) {
            this.mNormalTextSizes.add(Float.valueOf(this.mNormalTextSize));
        }
        computeFontMetrics();
        invalidate();
    }

    public void setTextSize(float f, float f2) {
        setTextPreference(f, f2, this.mSelectItemHeight, this.mNormalItemHeight);
    }

    public void setTypeface(Typeface typeface) {
        this.mTextPaint.setTypeface(typeface);
        computeFontMetrics();
        invalidate();
    }

    public void setVisibleItems(int i) {
        this.mVisibleItems = i;
    }

    public void stopScrolling() {
        ScrollTextViewScroller scrollTextViewScroller = this.mWheelScroller;
        if (scrollTextViewScroller != null) {
            scrollTextViewScroller.stopScrolling();
        }
    }

    public void refreshCount(int i, int i2) {
        int i3 = this.mCurrentItem + i2;
        this.mCurrentItem = i3;
        refreshData(i, i3, 0, i - 1);
    }

    public void setData(IDataAdapter iDataAdapter, float f, int i, int i2, int i3, int i4, int i5, boolean z) {
        setIDataAdapter(iDataAdapter);
        this.mVisibleItems = i3;
        this.isCyclic = z;
        if (f == -1.0f) {
            this.mOffsetY = getResources().getDimensionPixelSize(R.dimen.mc_picker_offset_y);
        } else {
            this.mOffsetY = (int) (f * getContext().getResources().getDisplayMetrics().density);
        }
        if (i2 < this.mVisibleItems || i5 + 1 < i2 || i4 > 0) {
            this.isCyclic = false;
        }
        refreshData(i2, i, i4, i5);
    }

    public void setNormalTextSize(List<Float> list) {
        if (list != null) {
            setTextPreference(this.mSelectTextSize, list, this.mSelectItemHeight, this.mNormalItemHeight);
        }
    }

    public void setTextSize(float f, List<Float> list) {
        if (f != this.mSelectTextSize || list != null) {
            setTextPreference(f, list, this.mSelectItemHeight, this.mNormalItemHeight);
        }
    }

    public void setNormalTextColor(List<Integer> list) {
        setTextColor(this.mSelectTextColor, list);
    }

    public void setTextColor(@ColorInt int i, List<Integer> list) {
        this.mSelectTextColor = i;
        if (!(list == null || this.mNormalTextColors == list)) {
            this.mNormalTextColor = list.get(0).intValue();
            this.mNormalTextColors = new ArrayList();
            int i2 = this.mVisibleItems - 1;
            for (int i3 = 0; i3 < i2 / 2; i3++) {
                int size = list.size();
                if (i3 < size) {
                    this.mNormalTextColors.add(list.get(i3));
                } else {
                    this.mNormalTextColors.add(list.get(size - 1));
                }
            }
        }
        invalidate();
    }

    public void setTextPreference(float f, List<Float> list, float f2, float f3) {
        if (this.mSelectItemHeight != f2 || this.mNormalItemHeight != f3 || this.mSelectTextSize != f || list != null) {
            this.mSelectItemHeight = f2;
            this.mSelectTextSize = f;
            this.mNormalItemHeight = f3;
            if (!(list == null || this.mNormalTextSizes == list)) {
                this.mNormalTextSize = list.get(0).floatValue();
                this.mNormalTextSizes = new ArrayList();
                int i = this.mVisibleItems - 1;
                for (int i2 = 0; i2 < i / 2; i2++) {
                    int size = list.size();
                    if (i2 < size) {
                        this.mNormalTextSizes.add(list.get(i2));
                    } else {
                        this.mNormalTextSizes.add(list.get(size - 1));
                    }
                }
            }
            computeFontMetrics();
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollTextView(Context context) {
        super(context);
        this.mTextPaint = new Paint(1);
        this.mCurrentItem = 0;
        this.mVisibleItems = 5;
        this.mSelectItemHeight = 0.0f;
        this.mNormalItemHeight = 0.0f;
        this.isCyclic = false;
        this.mIsDrawFading = true;
        this.mParentRequestDisallowInterceptTouchEvent = true;
        this.mSelectedTextOffset = 0.0f;
        this.isShowMarquee = true;
        this.mStiffness = STIFFNESS_DEFAULT;
        this.mDamping = 0.98f;
        this.mTextRunnable = new Runnable() {
            public void run() {
                ScrollTextView.this.doSelectedTextScroll();
                ScrollTextView.this.postInvalidate();
            }
        };
        this.mChangingListeners = new LinkedList();
        this.mScrollingListeners = new LinkedList();
        this.mClickingListeners = new LinkedList();
        this.mScrollingListener = new ScrollingListener() {
            public void onFinished() {
                if (ScrollTextView.this.isScrollingPerformed) {
                    ScrollTextView.this.notifyScrollingListenersAboutEnd();
                    boolean unused = ScrollTextView.this.isScrollingPerformed = false;
                }
                int unused2 = ScrollTextView.this.mScrollingOffset = 0;
                ScrollTextView scrollTextView = ScrollTextView.this;
                scrollTextView.removeCallbacks(scrollTextView.mTextRunnable);
                ScrollTextView scrollTextView2 = ScrollTextView.this;
                float unused3 = scrollTextView2.mSelectedTextOffset = ((float) scrollTextView2.getWidth()) / 2.0f;
                ScrollTextView.this.doSelectedTextScroll();
                ScrollTextView.this.invalidate();
            }

            public void onJustify() {
                int i;
                int itemHeight;
                int access$700;
                ScrollTextView scrollTextView = ScrollTextView.this;
                if (scrollTextView.isCyclic || scrollTextView.getCurrentItem() >= ScrollTextView.this.mViewAdapter.getValidStart()) {
                    ScrollTextView scrollTextView2 = ScrollTextView.this;
                    if (!scrollTextView2.isCyclic && scrollTextView2.getCurrentItem() > ScrollTextView.this.mViewAdapter.getValidEnd()) {
                        ScrollTextView scrollTextView3 = ScrollTextView.this;
                        scrollTextView3.scroll(scrollTextView3.mViewAdapter.getValidEnd() - ScrollTextView.this.getCurrentItem(), 0);
                    } else if (Math.abs(ScrollTextView.this.mScrollingOffset) > ScrollTextView.this.getItemHeight() / 2) {
                        if (ScrollTextView.this.mScrollingOffset > 0) {
                            itemHeight = -ScrollTextView.this.getItemHeight();
                            access$700 = ScrollTextView.this.mScrollingOffset;
                        } else if (ScrollTextView.this.mScrollingOffset < 0) {
                            itemHeight = ScrollTextView.this.getItemHeight();
                            access$700 = ScrollTextView.this.mScrollingOffset;
                        } else {
                            i = 0;
                            ScrollTextView.this.mWheelScroller.scroll(i, 0);
                        }
                        i = itemHeight + access$700;
                        ScrollTextView.this.mWheelScroller.scroll(i, 0);
                    } else if (ScrollTextView.this.mScrollingOffset != 0) {
                        ScrollTextView.this.mWheelScroller.scroll(ScrollTextView.this.mScrollingOffset, (Math.abs(ScrollTextView.this.mScrollingOffset) * 650) / (ScrollTextView.this.getItemHeight() / 2));
                    }
                } else {
                    ScrollTextView scrollTextView4 = ScrollTextView.this;
                    scrollTextView4.scroll(scrollTextView4.mViewAdapter.getValidStart() - ScrollTextView.this.getCurrentItem(), 0);
                }
            }

            public void onScroll(int i) {
                ScrollTextView.this.doScroll(i);
                int height = ScrollTextView.this.getHeight();
                if (ScrollTextView.this.mScrollingOffset > height) {
                    int unused = ScrollTextView.this.mScrollingOffset = height;
                    ScrollTextView.this.mWheelScroller.stopScrolling();
                    return;
                }
                int i2 = -height;
                if (ScrollTextView.this.mScrollingOffset < i2) {
                    int unused2 = ScrollTextView.this.mScrollingOffset = i2;
                    ScrollTextView.this.mWheelScroller.stopScrolling();
                }
            }

            public void onStarted() {
                boolean unused = ScrollTextView.this.isScrollingPerformed = true;
                ScrollTextView scrollTextView = ScrollTextView.this;
                scrollTextView.removeCallbacks(scrollTextView.mTextRunnable);
                ScrollTextView.this.notifyScrollingListenersAboutStart();
            }
        };
        initData(context);
    }
}
