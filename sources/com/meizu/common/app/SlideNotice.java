package com.meizu.common.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.meizu.common.R;
import com.meizu.common.app.SlideNoticeManager;
import com.meizu.common.interpolator.PathInterpolatorCompat;
import com.meizu.common.util.NavigationBarUtils;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.util.ScreenUtil;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class SlideNotice {
    /* access modifiers changed from: private */
    public static final Interpolator HIDE_INTERPOLATOR = new PathInterpolatorCompat(0.33f, 0.061f, 0.24f, 1.0f);
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static final int NOTICE_CLICK = 0;
    public static final int NOTICE_TYPE_FAILURE = 0;
    public static final int NOTICE_TYPE_SUCCESS = 1;
    public static final int SHOW_ANIMATION_DURATION = 320;
    /* access modifiers changed from: private */
    public static final Interpolator SHOW_INTERPOLATOR = new PathInterpolatorCompat(0.2f, 0.46f, 0.1f, 1.0f);
    public static final int SLIDE_TYPE_FROM_BOTTOM = 2;
    public static final int SLIDE_TYPE_FROM_TOP = 1;
    private static final String TAG = "SlideNotice";
    private static SlideNoticeManager mService;
    /* access modifiers changed from: private */
    public static Field sMeizuFlag;
    /* access modifiers changed from: private */
    public boolean isAutoAdaptNavigationBar;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mDuration;
    private SlideViewController mSlideViewController;
    private Toast mToast;

    public static final class NoticeHandler extends Handler {
        private WeakReference<SlideNotice> mNotice;

        public NoticeHandler(SlideNotice slideNotice) {
            this.mNotice = new WeakReference<>(slideNotice);
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                ((OnClickNoticeListener) message.obj).onClick(this.mNotice.get());
            }
        }
    }

    public interface OnClickNoticeListener {
        void onClick(SlideNotice slideNotice);
    }

    public static final class SlideContainerView extends FrameLayout {
        public SlideContainerView(Context context) {
            super(context);
        }
    }

    public class SlideViewController implements SlideNoticeManager.NoticeCallBack {
        private static final int SLIDE_STATE_TYPE_HIDDEN = 3;
        private static final int SLIDE_STATE_TYPE_HIDING = 1;
        private static final int SLIDE_STATE_TYPE_SHOWING = 0;
        private static final int SLIDE_STATE_TYPE_SHOWN = 2;
        private boolean isBelowDefaultActionBar;
        private boolean isSlideAnim = false;
        private boolean isSupportedImmersedStatusBar;
        private int mActionBarHeight;
        /* access modifiers changed from: private */
        public WeakReference<View> mAnchor;
        private final View.OnClickListener mContentClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Message obtain = SlideViewController.this.mNoticeClickMsg != null ? Message.obtain(SlideViewController.this.mNoticeClickMsg) : null;
                if (obtain != null) {
                    obtain.sendToTarget();
                }
            }
        };
        /* access modifiers changed from: private */
        public ViewPropertyAnimator mCurAnimator;
        private FrameLayout mCustom;
        private View mCustomView;
        int mGravity = 80;
        private boolean mHasCustom;
        private boolean mIsOverlaidByStatusBar = false;
        private boolean mIsOverlaidByStatusBarSet;
        private int mLeft;
        private int mNoticeBgColor;
        /* access modifiers changed from: private */
        public Message mNoticeClickMsg;
        private Handler mNoticeHandler;
        private int mNoticeHeight;
        private LinearLayout mNoticePanel;
        private TextView mNoticeView;
        private int mNoticeWidth;
        private OnClickNoticeListener mOnClickNoticeListener;
        private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
        private WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        /* access modifiers changed from: private */
        public View mSlideContent;
        private SlideContainerView mSlideDecorView;
        int mSlideFromType = -1;
        int mSlideState = 3;
        private SlidingHideListener mSlidingHideListener;
        /* access modifiers changed from: private */
        public SlidingShowListener mSlidingShowListener;
        private int mStatusBarHeight;
        private WindowManager mWManager;
        int mYOffset;
        private boolean showing;
        private CharSequence text;

        public class SlidingHideListener extends AnimatorListenerAdapter {
            private SlidingHideListener() {
            }

            public void onAnimationEnd(Animator animator) {
                SlideViewController.this.destroy();
            }

            public void onAnimationStart(Animator animator) {
                SlideViewController.this.mSlideState = 1;
            }
        }

        public class SlidingShowListener extends AnimatorListenerAdapter {
            private boolean mIsCanceled;

            private SlidingShowListener() {
            }

            public void onAnimationCancel(Animator animator) {
                this.mIsCanceled = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.mIsCanceled) {
                    SlideViewController.this.mSlideState = 2;
                }
            }

            public void onAnimationStart(Animator animator) {
                SlideViewController.this.mSlideState = 0;
            }
        }

        public SlideViewController(SlideNotice slideNotice) {
            this.mNoticeHandler = new NoticeHandler(slideNotice);
            init();
        }

        /* access modifiers changed from: private */
        public void destroy() {
            SlideContainerView slideContainerView = this.mSlideDecorView;
            if (!(slideContainerView == null || slideContainerView.getParent() == null)) {
                this.mWManager.removeView(this.mSlideDecorView);
            }
            unregisterForScrollChanged();
            this.mOnScrollChangedListener = null;
            this.showing = false;
            this.mSlideState = 3;
        }

        /* access modifiers changed from: private */
        public int[] findPositionByAnchor(View view, int i) {
            int[] iArr = new int[2];
            int height = view.getHeight();
            view.getLocationInWindow(iArr);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int navigationBarHeight = ScreenUtil.getNavigationBarHeight(SlideNotice.this.mContext);
            int actualScreenHeight = ScreenUtil.getActualScreenHeight(this.mWManager);
            int i2 = rect.bottom;
            if (i2 == actualScreenHeight) {
                navigationBarHeight = 0;
            }
            return i == 1 ? new int[]{iArr[0], iArr[1] + height + navigationBarHeight} : new int[]{iArr[0], (i2 - iArr[1]) + navigationBarHeight};
        }

        private int getActionBarHeight(Context context) {
            TypedValue typedValue = new TypedValue();
            return context.getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()) : AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW;
        }

        private void handleHide() {
            if (this.showing) {
                if (this.isSlideAnim) {
                    ViewPropertyAnimator viewPropertyAnimator = this.mCurAnimator;
                    if (viewPropertyAnimator != null) {
                        viewPropertyAnimator.cancel();
                    }
                    if (this.mSlideState == 3) {
                        destroy();
                        return;
                    }
                    int measuredHeight = this.mSlideContent.getMeasuredHeight();
                    if (this.mSlideFromType == 1) {
                        measuredHeight = -measuredHeight;
                    }
                    ViewPropertyAnimator translationY = this.mSlideContent.animate().translationY((float) measuredHeight);
                    translationY.setDuration(320);
                    translationY.setInterpolator(SlideNotice.HIDE_INTERPOLATOR);
                    translationY.setListener(this.mSlidingHideListener);
                    translationY.start();
                    this.mCurAnimator = translationY;
                    return;
                }
                this.mSlideState = 1;
                destroy();
            }
        }

        private void handleShow() {
            if (!this.showing) {
                prepareNotice(this.mParams);
                setupPosition();
                setupView();
                invokeNotice();
                if (this.isSlideAnim) {
                    this.mSlideContent.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        public boolean onPreDraw() {
                            SlideViewController.this.mSlideContent.getViewTreeObserver().removeOnPreDrawListener(this);
                            int measuredHeight = SlideViewController.this.mSlideContent.getMeasuredHeight();
                            SlideViewController slideViewController = SlideViewController.this;
                            if (slideViewController.mSlideFromType == 1) {
                                measuredHeight = -measuredHeight;
                            }
                            slideViewController.mSlideContent.setTranslationY((float) measuredHeight);
                            ViewPropertyAnimator translationY = SlideViewController.this.mSlideContent.animate().translationY(0.0f);
                            translationY.setDuration(320);
                            translationY.setListener(SlideViewController.this.mSlidingShowListener);
                            translationY.setInterpolator(SlideNotice.SHOW_INTERPOLATOR);
                            translationY.start();
                            ViewPropertyAnimator unused = SlideViewController.this.mCurAnimator = translationY;
                            return false;
                        }
                    });
                } else {
                    this.mSlideState = 2;
                }
                this.showing = true;
                trySendAccessibilityEvent();
            }
        }

        private void init() throws RuntimeException {
            View inflate = LayoutInflater.from(SlideNotice.this.mContext).inflate(R.layout.mc_slide_notice_content, (ViewGroup) null);
            this.mSlideContent = inflate;
            this.mNoticeView = (TextView) inflate.findViewById(R.id.noticeView);
            this.mNoticePanel = (LinearLayout) this.mSlideContent.findViewById(R.id.noticePanel);
            this.mCustom = (FrameLayout) this.mSlideContent.findViewById(R.id.custom);
            this.mSlideContent.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            this.mStatusBarHeight = ResourceUtils.getStatusBarHeight(SlideNotice.this.mContext);
            this.mActionBarHeight = getActionBarHeight(SlideNotice.this.mContext);
            this.mSlidingHideListener = new SlidingHideListener();
            this.mSlidingShowListener = new SlidingShowListener();
            Context applicationContext = SlideNotice.this.mContext.getApplicationContext();
            if (applicationContext != null) {
                this.mWManager = (WindowManager) applicationContext.getSystemService("window");
            } else {
                this.mWManager = (WindowManager) SlideNotice.this.mContext.getSystemService("window");
            }
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.height = -2;
            layoutParams.width = -1;
            layoutParams.format = -3;
            layoutParams.setTitle("SlideNotice:" + Integer.toHexString(hashCode()));
            this.mParams.flags = 40;
            if (!(SlideNotice.this.mContext instanceof Activity)) {
                this.mActionBarHeight = SlideNotice.this.mContext.getResources().getDimensionPixelSize(R.dimen.mz_action_bar_default_height);
            }
        }

        private void invokeNotice() {
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.x = this.mLeft;
            layoutParams.y = this.mYOffset;
            if (SlideNotice.this.mContext != null) {
                this.mParams.packageName = SlideNotice.this.mContext.getPackageName();
            }
            this.mWManager.addView(this.mSlideDecorView, this.mParams);
        }

        private void prepareNotice(WindowManager.LayoutParams layoutParams) {
            Window window;
            if (SlideNotice.this.mContext instanceof Activity) {
                window = ((Activity) SlideNotice.this.mContext).getWindow();
                IBinder windowToken = window.getDecorView().getWindowToken();
                if (windowToken != null) {
                    layoutParams.token = windowToken;
                    layoutParams.type = 1000;
                } else {
                    layoutParams.type = MSG.MSG_PREPARING_HINT_WAITING;
                }
            } else {
                layoutParams.type = MSG.MSG_PREPARING_HINT_WAITING;
                window = null;
            }
            if (!this.isSlideAnim) {
                layoutParams.windowAnimations = R.style.Animation_Flyme_Snackbar;
            }
            boolean transStatusBar = setTransStatusBar(this.mParams, window);
            this.isSupportedImmersedStatusBar = transStatusBar;
            if (!transStatusBar) {
                this.mStatusBarHeight = 0;
            }
            int i = this.mNoticeWidth;
            if (i > 0) {
                layoutParams.width = i;
            }
            int i2 = this.mGravity;
            layoutParams.gravity = i2;
            if (this.mSlideFromType != -1) {
                return;
            }
            if ((i2 & 112) == 48) {
                this.mSlideFromType = 1;
            } else if ((i2 & 112) == 80) {
                this.mSlideFromType = 2;
            }
        }

        private boolean setTransStatusBar(WindowManager.LayoutParams layoutParams, Window window) {
            if (window != null) {
                return true;
            }
            try {
                layoutParams.flags |= CaptureType.CAPTURE_TYPE_ICCOA;
                return true;
            } catch (Exception e) {
                Log.e(SlideNotice.TAG, "Can't set the status bar to be transparent, Caused by:" + e.getMessage());
                return false;
            }
        }

        private void setWindowInsetsListener() {
            View childAt;
            if (SlideNotice.this.mContext instanceof Activity) {
                View decorView = ((Activity) SlideNotice.this.mContext).getWindow().getDecorView();
                if ((decorView instanceof ViewGroup) && (childAt = ((ViewGroup) decorView).getChildAt(0)) != null) {
                    childAt.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
                            if (r0.mYOffset == 0) goto L_0x0022;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public android.view.WindowInsets onApplyWindowInsets(android.view.View r5, android.view.WindowInsets r6) {
                            /*
                                r4 = this;
                                com.meizu.common.app.SlideNotice$SlideViewController r5 = com.meizu.common.app.SlideNotice.SlideViewController.this
                                com.meizu.common.app.SlideNotice r5 = com.meizu.common.app.SlideNotice.this
                                android.content.Context r5 = r5.mContext
                                int r5 = com.meizu.common.util.NavigationBarUtils.getBottomNavigationBarWidth((android.content.Context) r5)
                                com.meizu.common.app.SlideNotice$SlideViewController r0 = com.meizu.common.app.SlideNotice.SlideViewController.this
                                com.meizu.common.app.SlideNotice r0 = com.meizu.common.app.SlideNotice.this
                                boolean r0 = r0.isAutoAdaptNavigationBar
                                if (r0 != 0) goto L_0x0022
                                com.meizu.common.app.SlideNotice$SlideViewController r0 = com.meizu.common.app.SlideNotice.SlideViewController.this
                                int r1 = r0.mGravity
                                r2 = 80
                                if (r1 != r2) goto L_0x005e
                                int r0 = r0.mYOffset
                                if (r0 != 0) goto L_0x005e
                            L_0x0022:
                                r0 = 2
                                int[] r0 = new int[r0]
                                r1 = 1
                                if (r5 <= 0) goto L_0x003e
                                com.meizu.common.app.SlideNotice$SlideViewController r2 = com.meizu.common.app.SlideNotice.SlideViewController.this
                                com.meizu.common.app.SlideNotice r2 = com.meizu.common.app.SlideNotice.this
                                android.content.Context r2 = r2.mContext
                                android.content.res.Resources r2 = r2.getResources()
                                int r3 = com.meizu.common.R.dimen.mc_content_toast_content_margin_bottom_navigationBar
                                int r2 = r2.getDimensionPixelSize(r3)
                                int r5 = r5 + r2
                                r0[r1] = r5
                                goto L_0x0052
                            L_0x003e:
                                com.meizu.common.app.SlideNotice$SlideViewController r5 = com.meizu.common.app.SlideNotice.SlideViewController.this
                                com.meizu.common.app.SlideNotice r5 = com.meizu.common.app.SlideNotice.this
                                android.content.Context r5 = r5.mContext
                                android.content.res.Resources r5 = r5.getResources()
                                int r2 = com.meizu.common.R.dimen.mc_content_toast_content_margin_bottom_default
                                int r5 = r5.getDimensionPixelSize(r2)
                                r0[r1] = r5
                            L_0x0052:
                                com.meizu.common.app.SlideNotice$SlideViewController r5 = com.meizu.common.app.SlideNotice.SlideViewController.this
                                r5.update(r0)
                                com.meizu.common.app.SlideNotice$SlideViewController r4 = com.meizu.common.app.SlideNotice.SlideViewController.this
                                com.meizu.common.app.SlideNotice r4 = com.meizu.common.app.SlideNotice.this
                                boolean unused = r4.isAutoAdaptNavigationBar = r1
                            L_0x005e:
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.app.SlideNotice.SlideViewController.AnonymousClass4.onApplyWindowInsets(android.view.View, android.view.WindowInsets):android.view.WindowInsets");
                        }
                    });
                }
            }
        }

        private void setupContent() {
            this.mNoticeView.setVisibility(8);
            if (!this.mIsOverlaidByStatusBarSet && this.mSlideFromType == 1 && this.mYOffset < this.mStatusBarHeight && this.isSupportedImmersedStatusBar) {
                this.mIsOverlaidByStatusBar = true;
            }
            if (this.mIsOverlaidByStatusBar) {
                TextView textView = (TextView) this.mSlideContent.findViewById(R.id.noticeView_no_title_bar);
                this.mNoticeView = textView;
                ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = this.mStatusBarHeight;
            } else {
                ((LinearLayout.LayoutParams) this.mNoticeView.getLayoutParams()).topMargin = 0;
                this.mNoticeView = (TextView) this.mSlideContent.findViewById(R.id.noticeView);
            }
            if (this.mNoticeHeight > 0) {
                this.mNoticePanel.getLayoutParams().height = this.mNoticeHeight;
            }
            this.mNoticeView.setText(this.text);
            this.mNoticeView.setVisibility(0);
            this.mNoticePanel.setBackgroundColor(this.mNoticeBgColor);
            this.mNoticePanel.setVisibility(0);
        }

        private boolean setupCustom() {
            View view = this.mCustomView;
            if (view != null) {
                ViewParent parent = view.getParent();
                FrameLayout frameLayout = this.mCustom;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.mCustomView);
                }
                this.mCustom.removeAllViews();
                this.mCustom.addView(this.mCustomView);
                ViewGroup.LayoutParams layoutParams = this.mCustomView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.mCustom.setVisibility(0);
                return true;
            }
            this.mCustom.setVisibility(8);
            return false;
        }

        private void setupPosition() {
            WeakReference<View> weakReference = this.mAnchor;
            if (weakReference != null) {
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && view.getParent() != null) {
                    this.mYOffset = findPositionByAnchor(view, this.mSlideFromType)[1];
                }
            } else if (this.isBelowDefaultActionBar && this.mYOffset == 0) {
                this.mYOffset = this.mActionBarHeight + this.mStatusBarHeight;
            } else if (this.mGravity != 80 || this.mYOffset != 0) {
            } else {
                if (NavigationBarUtils.getBottomNavigationBarWidth(SlideNotice.this.mContext) > 0 && this.mYOffset == 0) {
                    boolean unused = SlideNotice.this.isAutoAdaptNavigationBar = true;
                    this.mYOffset = NavigationBarUtils.getBottomNavigationBarWidth(SlideNotice.this.mContext);
                } else if (NavigationBarUtils.getBottomNavigationBarWidth(SlideNotice.this.mContext) <= 0 && this.mYOffset == 0) {
                    boolean unused2 = SlideNotice.this.isAutoAdaptNavigationBar = true;
                    this.mYOffset = 0;
                }
            }
        }

        private void setupView() {
            if (this.mSlideDecorView == null) {
                SlideContainerView slideContainerView = new SlideContainerView(SlideNotice.this.mContext);
                this.mSlideDecorView = slideContainerView;
                slideContainerView.addView(this.mSlideContent);
            }
            boolean z = setupCustom();
            this.mHasCustom = z;
            if (!z) {
                setupContent();
            } else {
                this.mNoticePanel.setVisibility(8);
            }
            if (this.mOnClickNoticeListener != null) {
                this.mSlideContent.setOnClickListener(this.mContentClickListener);
                this.mNoticeClickMsg = this.mNoticeHandler.obtainMessage(0, this.mOnClickNoticeListener);
            }
            this.mSlideContent.setVisibility(0);
        }

        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager = (AccessibilityManager) SlideNotice.this.mContext.getSystemService("accessibility");
            if (accessibilityManager.isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(64);
                obtain.setClassName(getClass().getName());
                obtain.setPackageName(this.mSlideDecorView.getContext().getPackageName());
                this.mSlideDecorView.dispatchPopulateAccessibilityEvent(obtain);
                accessibilityManager.sendAccessibilityEvent(obtain);
            }
        }

        private void unregisterForScrollChanged() {
            WeakReference<View> weakReference = this.mAnchor;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
            }
            this.mAnchor = null;
        }

        /* access modifiers changed from: private */
        public void update(int[] iArr) {
            SlideContainerView slideContainerView;
            if (this.showing && (slideContainerView = this.mSlideDecorView) != null && slideContainerView.getParent() != null) {
                int i = iArr[1];
                this.mYOffset = i;
                WindowManager.LayoutParams layoutParams = this.mParams;
                layoutParams.y = i;
                this.mWManager.updateViewLayout(this.mSlideDecorView, layoutParams);
            }
        }

        public CharSequence getText() {
            return this.text;
        }

        public int getTop() {
            return this.mYOffset;
        }

        public void hide() {
            handleHide();
        }

        public boolean isShowing() {
            return this.showing;
        }

        public void resetTop() {
            if (this.isBelowDefaultActionBar) {
                this.mYOffset = this.mActionBarHeight + this.mStatusBarHeight;
            } else {
                this.mYOffset = 0;
            }
        }

        public void setAnchor(View view) {
            if (view != null) {
                unregisterForScrollChanged();
                this.mAnchor = new WeakReference<>(view);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    if (this.mOnScrollChangedListener == null) {
                        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
                            public void onScrollChanged() {
                                View view = SlideViewController.this.mAnchor != null ? (View) SlideViewController.this.mAnchor.get() : null;
                                if (view != null && view.getParent() != null && SlideViewController.this.mSlideContent != null) {
                                    SlideViewController slideViewController = SlideViewController.this;
                                    SlideViewController.this.update(slideViewController.findPositionByAnchor(view, slideViewController.mSlideFromType));
                                }
                            }
                        };
                    }
                    viewTreeObserver.addOnScrollChangedListener(this.mOnScrollChangedListener);
                }
            }
        }

        public void setBelowDefaultActionBar(boolean z) {
            this.isBelowDefaultActionBar = z;
            if (z) {
                this.mGravity = 48;
            }
        }

        public void setCustomView(View view) {
            this.mCustomView = view;
        }

        public void setIsOverlaidByStatusBar(boolean z) {
            this.mIsOverlaidByStatusBar = z;
            if (z) {
                this.mGravity = 48;
            }
            this.mIsOverlaidByStatusBarSet = true;
        }

        public void setLeft(int i) {
            this.mLeft = i;
        }

        public void setNoticeBgColor(int i) {
            this.mNoticeBgColor = i;
        }

        public void setNoticeHeight(int i) {
            this.mNoticeHeight = i;
        }

        public void setNoticeWidth(int i) {
            this.mNoticeWidth = i;
        }

        public void setOnClickNoticeListener(OnClickNoticeListener onClickNoticeListener) {
            this.mOnClickNoticeListener = onClickNoticeListener;
        }

        public void setSlideAnimEnable(boolean z) {
            this.isSlideAnim = z;
        }

        public void setText(CharSequence charSequence) {
            this.text = charSequence;
            TextView textView = this.mNoticeView;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }

        public void show() {
            handleShow();
            setWindowInsetsListener();
        }
    }

    public SlideNotice(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mSlideViewController = new SlideViewController(this);
            return;
        }
        throw new IllegalArgumentException("context can not be null!");
    }

    private static SlideNoticeManager getManager() {
        SlideNoticeManager slideNoticeManager = mService;
        if (slideNoticeManager != null) {
            return slideNoticeManager;
        }
        SlideNoticeManager slideNoticeManager2 = new SlideNoticeManager();
        mService = slideNoticeManager2;
        return slideNoticeManager2;
    }

    public static SlideNotice makeNotice(Context context, CharSequence charSequence) {
        return makeNotice(context, charSequence, 1, 0);
    }

    public static SlideNotice makeSlideNotice(Context context, CharSequence charSequence) {
        return makeSlideNotice(context, charSequence, 1, 0);
    }

    public void cancel() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.cancel();
        }
    }

    public void cancelNotice() {
        this.mSlideViewController.hide();
        getManager().cancelNotice((SlideNoticeManager.NoticeCallBack) this.mSlideViewController);
    }

    public void cancelWithoutAnim() {
        this.mSlideViewController.destroy();
        getManager().cancelNotice((SlideNoticeManager.NoticeCallBack) this.mSlideViewController);
    }

    public void finish() {
        cancel();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public boolean isShowing() {
        return this.mSlideViewController.isShowing();
    }

    public void resetSlideFrom() {
        this.mSlideViewController.resetTop();
    }

    public void setActionBarToTop(boolean z) {
        this.mSlideViewController.setBelowDefaultActionBar(z);
    }

    public void setAnchorView(View view) {
        this.mSlideViewController.setAnchor(view);
    }

    public void setBeginColor(int i) {
        setNoticeBackgroundColor(i);
    }

    public void setBelowDefaultActionBar(boolean z) {
        this.mSlideViewController.setBelowDefaultActionBar(z);
    }

    public void setCustomView(View view) {
        this.mSlideViewController.setCustomView(view);
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Toast toast = this.mToast;
        if (toast != null) {
            toast.setDuration(i);
        }
    }

    public void setEndColor(int i) {
        setNoticeBackgroundColor(i);
    }

    public void setGravity(int i) {
        this.mSlideViewController.mGravity = i;
    }

    public void setHeight(int i) {
        this.mSlideViewController.setNoticeHeight(i);
    }

    public void setIsOverlaidByStatusBar(boolean z) {
        this.mSlideViewController.setIsOverlaidByStatusBar(z);
    }

    public void setLeft(int i) {
        this.mSlideViewController.setLeft(i);
    }

    public void setNoTitleBarStyle(boolean z) {
        this.mSlideViewController.setIsOverlaidByStatusBar(z);
    }

    public void setNoticeBackgroundColor(int i) {
        this.mSlideViewController.setNoticeBgColor(i);
    }

    public void setNoticeType(int i) {
        if (!this.mSlideViewController.isShowing()) {
            if (i != 0) {
                setBeginColor(this.mContext.getResources().getColor(R.color.mc_slide_notice_success_begin_color));
                setEndColor(this.mContext.getResources().getColor(R.color.mc_slide_notice_success_end_color));
                return;
            }
            setBeginColor(this.mContext.getResources().getColor(R.color.mc_slide_notice_failure_begin_color));
            setEndColor(this.mContext.getResources().getColor(R.color.mc_slide_notice_failure_end_color));
        }
    }

    public void setOnClickNoticeListener(OnClickNoticeListener onClickNoticeListener) {
        this.mSlideViewController.setOnClickNoticeListener(onClickNoticeListener);
    }

    public void setSlideAnimEnable(boolean z) {
        this.mSlideViewController.setSlideAnimEnable(z);
    }

    public void setSlideType(int i) {
        this.mSlideViewController.mSlideFromType = i;
    }

    public void setText(CharSequence charSequence) {
        this.mSlideViewController.setText(charSequence);
        Toast toast = this.mToast;
        if (toast != null) {
            toast.setText(charSequence);
        }
    }

    public void setTop(int i) {
        setYOffset(i);
    }

    public void setWidth(int i) {
        this.mSlideViewController.setNoticeWidth(i);
    }

    public void setYOffset(int i) {
        this.mSlideViewController.mYOffset = i;
    }

    public void show(boolean z) {
    }

    public void showAndFinish(long j) {
    }

    public void showNotice() {
        getManager().enqueueNotice(this.mSlideViewController.getText(), this.mSlideViewController, this.mDuration);
    }

    public void slideToCancel() {
        cancelNotice();
    }

    public void slideToShow() {
        showNotice();
    }

    public static SlideNotice makeNotice(Context context, CharSequence charSequence, int i) {
        return makeNotice(context, charSequence, 0, 0);
    }

    public static SlideNotice makeSlideNotice(Context context, CharSequence charSequence, int i) {
        SlideNotice slideNotice = new SlideNotice(context);
        slideNotice.setText(charSequence);
        slideNotice.setNoticeType(i);
        return slideNotice;
    }

    public void show() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.show();
        }
    }

    public void slideToShow(boolean z) {
        showNotice(z);
    }

    public static SlideNotice makeNotice(Context context, CharSequence charSequence, int i, int i2) {
        return new SlideNotice(context, charSequence, i2);
    }

    public void showNotice(boolean z) {
        if (z) {
            this.mSlideViewController.show();
        } else {
            showNotice();
        }
    }

    public SlideNotice(Context context, CharSequence charSequence, int i) {
        this(context);
        this.mToast = Toast.makeText(context, charSequence, i);
    }

    public static SlideNotice makeSlideNotice(Context context, CharSequence charSequence, int i, int i2) {
        SlideNotice slideNotice = new SlideNotice(context);
        slideNotice.setText(charSequence);
        slideNotice.setNoticeType(i);
        slideNotice.mDuration = i2;
        return slideNotice;
    }
}
