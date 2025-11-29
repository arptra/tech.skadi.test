package com.meizu.common.notice;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.honey.account.s2.a;
import com.honey.account.s2.b;
import com.honey.account.s2.c;
import com.meizu.common.R;
import com.meizu.common.notice.NoticeView;
import com.meizu.common.util.ResourceUtils;

@TargetApi(26)
@RestrictTo
public class NoticePresenter {
    private static final float DAMPING = 0.8f;
    private static final float DRAG_RANGE = 800.0f;
    private static final long DURATION_TIMEOUT = 7000;
    private static final int NOTIFY_LOOP = 1;
    private static final float STIFFNESS = 200.0f;
    private static final String TAG = "NoticePresenter";
    private static final String WINDOW_TITLE = "Notice";
    private int mDesiredWidth;
    private int mDragLimit;
    private Handler mHandler;
    private boolean mHasInit;
    private SpringAnimation mHideAnim;
    Runnable mHideRunnable;
    private boolean mIsShowing;
    private final NoticeView.OnDragCallback mListener;
    private int mMaxWidthLimit;
    private NoticeParams mNoticeParams;
    private WindowManager.LayoutParams mParams;
    private NoticeQueue mQueue;
    private Resources mResources;
    private SpringAnimation mShowAnim;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final NoticePresenter holder = new NoticePresenter();

        private Holder() {
        }
    }

    public static class NoticeParams {
        Context context;
        Drawable drawable;
        int duration;
        boolean dynamic = true;
        int gravity;
        boolean hasCustomView;
        String notice;
        int noticeColor = 0;
        int noticeTextSize;
        int tipColor = 0;
        int tipTextSize;
        String tips;
        ViewGroup view;
        int yOffset;

        public NoticeParams(Context context2) {
            this.context = context2;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class WeakHandler extends Handler {
        private WeakHandler() {
        }

        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                NoticePresenter.this.notifyShow();
            }
        }
    }

    private void addNoticeView() {
        if (this.mWindowManager != null) {
            NoticeParams noticeParams = this.mNoticeParams;
            ViewGroup viewGroup = noticeParams.view;
            if (!(viewGroup == null || noticeParams.hasCustomView || viewGroup.getParent() == null)) {
                this.mWindowManager.removeView(this.mNoticeParams.view);
            }
            this.mIsShowing = true;
            try {
                this.mWindowManager.addView(this.mNoticeParams.view, this.mParams);
            } catch (WindowManager.BadTokenException unused) {
                Log.w(TAG, "Error while attempting to show notice");
                this.mIsShowing = false;
            }
        }
    }

    private void adjustLayoutParams(WindowManager.LayoutParams layoutParams, int i) {
        int absoluteGravity = Gravity.getAbsoluteGravity(i, this.mResources.getConfiguration().getLayoutDirection());
        layoutParams.gravity = absoluteGravity;
        if ((absoluteGravity & 7) == 7) {
            layoutParams.horizontalWeight = 1.0f;
        }
        if ((absoluteGravity & 112) == 112) {
            layoutParams.verticalWeight = 1.0f;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            layoutParams.layoutInDisplayCutoutMode = 3;
        }
        int i2 = this.mDesiredWidth;
        int i3 = this.mMaxWidthLimit;
        if (i2 > i3) {
            this.mParams.width = i3;
        }
    }

    private void cancelHideAnim() {
        if (isHideAnimRunning()) {
            this.mHideAnim.d();
        }
    }

    private void cancelShowAnim() {
        if (isShowAnimRunning()) {
            this.mShowAnim.d();
        }
    }

    private WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.type = 2038;
        layoutParams.flags = 776;
        layoutParams.gravity = 48;
        layoutParams.y = -1000;
        layoutParams.setTitle(WINDOW_TITLE);
        return layoutParams;
    }

    public static NoticePresenter get() {
        return Holder.holder;
    }

    private SpringForce getSpringForce() {
        return new SpringForce().d(DAMPING).f(STIFFNESS);
    }

    /* access modifiers changed from: private */
    public void handleDrag(int i, int i2) {
        if (isHideAnimRunning() || isShowAnimRunning()) {
            Log.w(TAG, "Notice is hiding or showing now, do not respond the drag.");
        } else {
            handleStickyDrag(i, i2);
        }
    }

    private void handleHideAnimation(float f) {
        cancelShowAnim();
        SpringForce springForce = getSpringForce();
        springForce.e((float) (-this.mNoticeParams.view.getHeight()));
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        this.mHideAnim = springAnimation;
        springAnimation.n((float) this.mParams.y);
        this.mHideAnim.o(f);
        this.mHideAnim.l(1.0f);
        this.mHideAnim.c(new a(this));
        this.mHideAnim.b(new b(this));
        this.mHideAnim.y(springForce);
        this.mHideAnim.q();
    }

    /* access modifiers changed from: private */
    public void handleSettling(float f) {
        if (!this.mNoticeParams.dynamic) {
            handleStickySettling(f);
            return;
        }
        cancelHideAnim();
        cancelShowAnim();
        int i = this.mParams.y;
        int i2 = this.mDragLimit;
        if (i <= i2 / 2) {
            if (f >= 0.0f) {
                f = 0.0f;
            }
            handleHideAnimation(f);
        } else if (f >= 0.0f) {
            handleShowAnimation(i, i2, 0.0f);
        } else if (f <= -200.0f) {
            handleHideAnimation(f);
        } else {
            handleShowAnimation(i, i2, 0.0f);
        }
    }

    private void handleShowAnimation(int i, int i2, float f) {
        cancelHideAnim();
        SpringForce springForce = getSpringForce();
        springForce.e((float) i2);
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        this.mShowAnim = springAnimation;
        if (i == 0) {
            i = -this.mNoticeParams.view.getHeight();
        }
        springAnimation.n((float) i);
        this.mShowAnim.o(f);
        this.mShowAnim.l(1.0f);
        this.mShowAnim.c(new c(this));
        this.mShowAnim.y(springForce);
        this.mShowAnim.q();
    }

    private void handleStickyDrag(int i, int i2) {
        WindowManager.LayoutParams layoutParams = this.mParams;
        int i3 = layoutParams.y;
        layoutParams.y = i3 + ((int) ((((float) i) * (1.0f - Math.min(1.0f, Math.abs(((float) i2) / DRAG_RANGE)))) + 0.5f));
        this.mWindowManager.updateViewLayout(this.mNoticeParams.view, layoutParams);
    }

    private void handleStickySettling(float f) {
        SpringAnimation springAnimation = this.mHideAnim;
        if (springAnimation != null && springAnimation.h()) {
            Log.w(TAG, "Notice is hiding now, do not respond the settling.");
        } else if (!isShowing()) {
            Log.w(TAG, "Notice is not visible, do not respond the settling.");
        } else {
            int i = this.mParams.y;
            int i2 = this.mNoticeParams.yOffset + this.mStatusBarHeight;
            if (i >= i2) {
                f = 0.0f;
            }
            handleShowAnimation(i, i2, f);
        }
    }

    private boolean isHideAnimRunning() {
        SpringAnimation springAnimation = this.mHideAnim;
        return springAnimation != null && springAnimation.h();
    }

    private boolean isShowAnimRunning() {
        SpringAnimation springAnimation = this.mShowAnim;
        return springAnimation != null && springAnimation.h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleHideAnimation$1(DynamicAnimation dynamicAnimation, float f, float f2) {
        updateParams((int) f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleHideAnimation$2(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        ViewGroup viewGroup = this.mNoticeParams.view;
        if (!(viewGroup == null || viewGroup.getParent() == null)) {
            this.mWindowManager.removeViewImmediate(this.mNoticeParams.view);
        }
        this.mIsShowing = false;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mHideRunnable);
            this.mHandler.sendEmptyMessage(1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleShowAnimation$0(DynamicAnimation dynamicAnimation, float f, float f2) {
        updateParams((int) f);
    }

    /* access modifiers changed from: private */
    public void notifyShow() {
        if (this.mIsShowing) {
            Log.w(TAG, "isShowing now, so do not show again.");
            return;
        }
        NoticeParams take = this.mQueue.take();
        if (take != null) {
            showInternal(take);
        }
    }

    private void setupView(NoticeView noticeView) {
        noticeView.setDesc(this.mNoticeParams.notice).setTips(this.mNoticeParams.tips).setIcon(this.mNoticeParams.drawable);
        int i = this.mNoticeParams.noticeTextSize;
        if (i != 0) {
            noticeView.setNoticeTextSize(i);
        }
        int i2 = this.mNoticeParams.tipTextSize;
        if (i2 != 0) {
            noticeView.setTipTextSize(i2);
        }
        int i3 = this.mNoticeParams.noticeColor;
        if (i3 != 0) {
            noticeView.setNoticeTextColor(i3);
        }
        int i4 = this.mNoticeParams.tipColor;
        if (i4 != 0) {
            noticeView.setTipTextColor(i4);
        }
        TextView textView = noticeView.mDescView;
        if (textView != null) {
            this.mDesiredWidth = (int) (textView.getPaint().measureText(noticeView.mDescView.getText().toString()) + ((float) (this.mResources.getDimensionPixelSize(R.dimen.mz_notice_padding_horizontal) * 2)) + ((float) this.mResources.getDimensionPixelSize(R.dimen.mz_notice_icon_size)) + ((float) this.mResources.getDimensionPixelSize(R.dimen.mz_notice_text_margin_icon)));
        }
    }

    private void showInternal(NoticeParams noticeParams) {
        Handler handler;
        NoticeView noticeView = new NoticeView(noticeParams.context);
        if (noticeParams.hasCustomView) {
            noticeView.removeAllViews();
            noticeView.setContainer(noticeParams.view);
        } else {
            noticeView.inflate();
        }
        noticeParams.view = noticeView;
        this.mNoticeParams = noticeParams;
        this.mDragLimit = noticeParams.yOffset + this.mStatusBarHeight;
        noticeView.setOnDragListener(this.mListener);
        if (!noticeParams.hasCustomView) {
            setupView(noticeView);
        } else {
            this.mDesiredWidth = 0;
        }
        WindowManager.LayoutParams createLayoutParams = createLayoutParams();
        this.mParams = createLayoutParams;
        adjustLayoutParams(createLayoutParams, noticeParams.gravity);
        addNoticeView();
        handleShowAnimation(0, noticeParams.yOffset + this.mStatusBarHeight, 0.0f);
        if (noticeParams.duration == 0 && (handler = this.mHandler) != null) {
            handler.postDelayed(this.mHideRunnable, DURATION_TIMEOUT);
        }
    }

    private void updateParams(int i) {
        WindowManager.LayoutParams layoutParams = this.mParams;
        if (layoutParams != null) {
            layoutParams.y = i;
            this.mWindowManager.updateViewLayout(this.mNoticeParams.view, layoutParams);
        }
    }

    public void hide() {
        NoticeParams noticeParams;
        if (this.mWindowManager == null || (noticeParams = this.mNoticeParams) == null || noticeParams.view == null) {
            Log.w(TAG, "windowManager is null or view is null.");
        } else if (!isShowing()) {
            Log.w(TAG, "has no notice to hide");
        } else {
            handleHideAnimation(0.0f);
        }
    }

    public void init(Context context) {
        if (!this.mHasInit) {
            this.mWindowManager = (WindowManager) context.getSystemService(WindowManager.class);
            this.mHandler = new WeakHandler();
            Resources resources = context.getResources();
            this.mResources = resources;
            this.mMaxWidthLimit = (resources.getConfiguration().orientation == 1 ? this.mResources.getDisplayMetrics().widthPixels : this.mResources.getDisplayMetrics().heightPixels) - (this.mResources.getDimensionPixelSize(R.dimen.mz_notice_container_margin_horizontal) * 2);
            this.mStatusBarHeight = ResourceUtils.getStatusBarHeight(context);
            this.mQueue = new NoticeQueue();
            this.mHasInit = true;
        }
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void show(NoticeParams noticeParams) {
        if (!noticeParams.hasCustomView || noticeParams.view != null) {
            boolean isEmpty = this.mQueue.isEmpty();
            this.mQueue.add(noticeParams);
            if (isEmpty) {
                notifyShow();
                return;
            }
            return;
        }
        Log.w(TAG, "Empty view no need to show.");
    }

    private NoticePresenter() {
        this.mListener = new NoticeView.OnDragCallback() {
            public void onDrag(int i, int i2) {
                NoticePresenter.this.handleDrag(i, i2);
            }

            public void onSettling(float f) {
                NoticePresenter.this.handleSettling(f);
            }
        };
        this.mHideRunnable = new Runnable() {
            public void run() {
                NoticePresenter.this.hide();
            }
        };
    }
}
