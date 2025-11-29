package flyme.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import flyme.support.v7.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class RecyclerFastScrollLetter extends LinearLayout {
    private static final String CLASS_NAME_FLYME_FEATURE = "flyme.config.FlymeFeature";
    private static final String FIELD_SUPPORT_MOTOR = "SHELL_HAPTICFEEDBACK_MOTOR";
    private static final String FIELD_USE_QCOM_VIBRATE = "USE_QCOM_VIBRATE";
    private static final int OVERLAY_ANIMATION_DURATION = 100;
    private static final int SCROLLER_SCROLL = 20120;
    private static final int TRACK_SNAP_RANGE = 0;
    private static Field mShellHapticFeedBackMotor;
    private static Field mUseQCOMVibrate;
    /* access modifiers changed from: private */
    public float OVERLAY_Y_APPEND;
    private Map<String, String> mBackgroundColorSet;
    private String mCurrentLetter;
    /* access modifiers changed from: private */
    public boolean mIsEnable;
    /* access modifiers changed from: private */
    public View mLetterBar;
    /* access modifiers changed from: private */
    public float mLetterBarBottomY;
    private int mLetterBarHeight;
    private LinearLayout mLetterBarLayout;
    private float mLetterBarPaddingBottom;
    private float mLetterBarPaddingLeft;
    private float mLetterBarPaddingRight;
    private float mLetterBarPaddingTop;
    /* access modifiers changed from: private */
    public float mLetterBarTopY;
    private Drawable mLetterBarTouchDownBkDrawable;
    private Drawable mLetterBarTouchMoveBkDrawable;
    private Drawable mLetterBarTouchUpBkDrawable;
    /* access modifiers changed from: private */
    public MzRecyclerView mMzRecyclerView;
    /* access modifiers changed from: private */
    public ObjectAnimator mObjAnimator;
    private Drawable mOverlayBkDrawable;
    private float mOverlayMaxY;
    private float mOverlayMinY;
    /* access modifiers changed from: private */
    public TextView mOverlayView;
    private final ScrollListener mScrollListener;

    public interface IScrollIndexer {
        String getOverlayText(float f);

        int getScrollPosition(float f);
    }

    public class ScrollListener extends RecyclerView.OnScrollListener {
        private ScrollListener() {
        }

        public void onScrolled(MzRecyclerView mzRecyclerView, int i, int i2) {
            if (RecyclerFastScrollLetter.this.mIsEnable) {
                RecyclerFastScrollLetter.this.mMzRecyclerView.getChildPosition(RecyclerFastScrollLetter.this.mMzRecyclerView.getChildAt(0));
                RecyclerFastScrollLetter.this.mMzRecyclerView.getChildCount();
                RecyclerFastScrollLetter.this.mMzRecyclerView.getAdapter().getItemCount();
            }
        }
    }

    public RecyclerFastScrollLetter(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hasFlymeFeature() {
        /*
            r2 = this;
            r2 = 0
            java.lang.reflect.Field r0 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 == 0) goto L_0x000c
            java.lang.reflect.Field r0 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 != 0) goto L_0x002a
            goto L_0x000c
        L_0x000a:
            r0 = move-exception
            goto L_0x003d
        L_0x000c:
            java.lang.String r0 = "flyme.config.FlymeFeature"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            java.lang.reflect.Field r1 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = "SHELL_HAPTICFEEDBACK_MOTOR"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            mShellHapticFeedBackMotor = r1     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
        L_0x001e:
            java.lang.reflect.Field r1 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r1 != 0) goto L_0x002a
            java.lang.String r1 = "USE_QCOM_VIBRATE"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            mUseQCOMVibrate = r0     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
        L_0x002a:
            java.lang.reflect.Field r0 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            r1 = 0
            boolean r0 = r0.getBoolean(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 != 0) goto L_0x003b
            java.lang.reflect.Field r0 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            boolean r0 = r0.getBoolean(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 == 0) goto L_0x0040
        L_0x003b:
            r2 = 1
            goto L_0x0040
        L_0x003d:
            r0.printStackTrace()
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.RecyclerFastScrollLetter.hasFlymeFeature():boolean");
    }

    private void initPreDrawListener() {
        this.mLetterBar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                RecyclerFastScrollLetter.this.mLetterBar.getViewTreeObserver().removeOnPreDrawListener(this);
                RecyclerFastScrollLetter.this.reCalcLetterBarArgs();
                float access$300 = RecyclerFastScrollLetter.this.mLetterBarTopY - RecyclerFastScrollLetter.this.OVERLAY_Y_APPEND;
                if (access$300 < 0.0f) {
                    access$300 = 0.0f;
                }
                RecyclerFastScrollLetter.this.setOverlayPositionRange(access$300, (RecyclerFastScrollLetter.this.mLetterBarBottomY + RecyclerFastScrollLetter.this.OVERLAY_Y_APPEND) - ((float) RecyclerFastScrollLetter.this.mOverlayView.getMeasuredHeight()));
                return true;
            }
        });
    }

    private void initialise(Context context) {
        setOrientation(0);
        setClipChildren(false);
        LayoutInflater.from(context).inflate(R.layout.layout_recycler_fastscroller, this, true);
        this.mOverlayView = (TextView) findViewById(R.id.fastscroller_overlay);
        this.mLetterBar = findViewById(R.id.fastscroller_letterbar);
        this.mLetterBarLayout = (LinearLayout) findViewById(R.id.fastscroller_letterbar_layout);
        this.mOverlayView.setVisibility(4);
        initPreDrawListener();
        setOverlayBackground(this.mOverlayBkDrawable);
        setLetterBarBackground(this.mLetterBarTouchUpBkDrawable);
        setLetterBarPadding(this.mLetterBarPaddingLeft, this.mLetterBarPaddingTop, this.mLetterBarPaddingRight, this.mLetterBarPaddingBottom);
        setLetterBarTouchDrawable(this.mLetterBarTouchUpBkDrawable, this.mLetterBarTouchDownBkDrawable, this.mLetterBarTouchMoveBkDrawable);
        try {
            if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
                Method declaredMethod = BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", new Class[]{Boolean.TYPE});
                Drawable drawable = this.mOverlayBkDrawable;
                Boolean bool = Boolean.TRUE;
                declaredMethod.invoke(drawable, new Object[]{bool});
                declaredMethod.invoke(this.mLetterBarTouchUpBkDrawable, new Object[]{bool});
                declaredMethod.invoke(this.mLetterBarTouchDownBkDrawable, new Object[]{bool});
                declaredMethod.invoke(this.mLetterBarTouchMoveBkDrawable, new Object[]{bool});
            }
        } catch (Exception unused) {
            Log.e("RecyclerView", "NightMode methods reflected failed!");
        }
    }

    private void isVibratorNeed() {
        if (hasFlymeFeature()) {
            performHapticFeedback(SCROLLER_SCROLL);
        }
    }

    /* access modifiers changed from: private */
    public void reCalcLetterBarArgs() {
        this.mLetterBarTopY = this.mLetterBar.getY();
        int measuredHeight = this.mLetterBar.getMeasuredHeight();
        this.mLetterBarHeight = measuredHeight;
        this.mLetterBarBottomY = this.mLetterBarTopY + ((float) measuredHeight);
    }

    private void setOverlayPosition(float f) {
        float f2 = this.mOverlayMinY;
        float touchLetterBarProportion = getTouchLetterBarProportion(f);
        float f3 = this.mOverlayMaxY;
        float f4 = this.mOverlayMinY;
        this.mOverlayView.setY(getRangeValue(f4, f3, (float) ((int) (f2 + (touchLetterBarProportion * (f3 - f4))))));
        if (this.mBackgroundColorSet != null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            String charSequence = this.mOverlayView.getText().toString();
            if (this.mBackgroundColorSet.containsKey(charSequence)) {
                shapeDrawable.getPaint().setColor(Color.parseColor(this.mBackgroundColorSet.get(charSequence)));
                this.mOverlayView.setBackground(shapeDrawable);
            }
        }
    }

    private void setRecyclerViewPosition(float f) {
        int i;
        if (this.mMzRecyclerView != null) {
            float touchLetterBarProportion = getTouchLetterBarProportion(f);
            RecyclerView.Adapter adapter = this.mMzRecyclerView.getAdapter();
            if (adapter instanceof HeaderAndFooterWrapperAdapter) {
                HeaderAndFooterWrapperAdapter headerAndFooterWrapperAdapter = (HeaderAndFooterWrapperAdapter) adapter;
                i = headerAndFooterWrapperAdapter.getHeadersCount();
                adapter = headerAndFooterWrapperAdapter.getWrappedAdapter();
            } else {
                i = 0;
            }
            IScrollIndexer iScrollIndexer = (IScrollIndexer) adapter;
            String overlayText = iScrollIndexer.getOverlayText(touchLetterBarProportion);
            if (overlayText != null && !this.mCurrentLetter.equals(overlayText)) {
                isVibratorNeed();
                this.mCurrentLetter = overlayText;
            }
            int scrollPosition = iScrollIndexer.getScrollPosition(touchLetterBarProportion);
            if (this.mMzRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                ((GridLayoutManager) this.mMzRecyclerView.getLayoutManager()).scrollToPositionWithOffset(scrollPosition + i, 0);
            }
            if (this.mMzRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                ((LinearLayoutManager) this.mMzRecyclerView.getLayoutManager()).scrollToPositionWithOffset(scrollPosition + i, 0);
            }
            if (this.mMzRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) this.mMzRecyclerView.getLayoutManager()).scrollToPositionWithOffset(scrollPosition + i, 0);
            }
            this.mOverlayView.setText(overlayText);
        }
    }

    public View getLetterBar() {
        return this.mLetterBar;
    }

    public MzRecyclerView getMzRecyclerView() {
        return this.mMzRecyclerView;
    }

    public float getOverlayMaxY() {
        return this.mOverlayMaxY;
    }

    public float getOverlayMinY() {
        return this.mOverlayMinY;
    }

    public float getOverlayX() {
        return this.mOverlayView.getX();
    }

    public float getOverlayY() {
        return this.mOverlayView.getY();
    }

    public float getRangeValue(float f, float f2, float f3) {
        return Math.min(Math.max(f, f3), f2);
    }

    public float getTouchLetterBarProportion(float f) {
        float f2 = this.mLetterBarTopY;
        if (f <= f2) {
            return 0.0f;
        }
        if (f >= this.mLetterBarBottomY) {
            return 1.0f;
        }
        return (f - f2) / ((float) this.mLetterBarHeight);
    }

    public void hideOverlay() {
        ObjectAnimator objectAnimator = this.mObjAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mOverlayView, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
        this.mObjAnimator = duration;
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                RecyclerFastScrollLetter.this.mOverlayView.setVisibility(4);
                ObjectAnimator unused = RecyclerFastScrollLetter.this.mObjAnimator = null;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RecyclerFastScrollLetter.this.mOverlayView.setVisibility(4);
                ObjectAnimator unused = RecyclerFastScrollLetter.this.mObjAnimator = null;
            }
        });
        this.mObjAnimator.start();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        reCalcLetterBarArgs();
        setOverlayPositionRange(this.mLetterBarTopY, this.mLetterBarBottomY);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!this.mIsEnable) {
            return false;
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        if (action != 0) {
            if (action == 1) {
                if (motionEvent.getY() < this.mLetterBarTopY || motionEvent.getY() > this.mLetterBarBottomY) {
                    hideOverlay();
                }
                setLetterBarBackground(this.mLetterBarTouchUpBkDrawable);
            } else if (action != 2) {
                if (action != 3) {
                    return super.onTouchEvent(motionEvent);
                }
            } else if (motionEvent.getY() < this.mLetterBarTopY || motionEvent.getY() > this.mLetterBarBottomY) {
                return false;
            } else {
                setOverlayPosition(y);
                setRecyclerViewPosition(y);
                if (this.mOverlayView.getVisibility() == 4) {
                    showOverlay();
                }
                setLetterBarBackground(this.mLetterBarTouchMoveBkDrawable);
                return true;
            }
            hideOverlay();
            return true;
        } else if (motionEvent.getY() < this.mLetterBarTopY || motionEvent.getY() > this.mLetterBarBottomY) {
            return false;
        } else {
            if (getLayoutDirection() == 1) {
                if (motionEvent.getX() > this.mLetterBarLayout.getX() + ((float) this.mLetterBarLayout.getPaddingLeft()) + ((float) this.mLetterBarLayout.getWidth()) + ((float) this.mLetterBarLayout.getPaddingRight())) {
                    return false;
                }
            } else if (motionEvent.getX() < this.mLetterBarLayout.getX()) {
                return false;
            }
            setOverlayPosition(y);
            setRecyclerViewPosition(y);
            setLetterBarBackground(this.mLetterBarTouchDownBkDrawable);
            ObjectAnimator objectAnimator = this.mObjAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (this.mOverlayView.getVisibility() == 4) {
                showOverlay();
            }
            return true;
        }
    }

    public void setBackgroundColorSet(Map<String, String> map) {
        this.mBackgroundColorSet = map;
    }

    public void setFastScrollerEnabled(boolean z) {
        this.mIsEnable = z;
        setVisibility(z ? 0 : 8);
    }

    @TargetApi(16)
    public void setLetterBarBackground(Drawable drawable) {
        if (drawable != null) {
            View view = this.mLetterBar;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawable);
            } else {
                view.setBackground(drawable);
            }
        }
    }

    public void setLetterBarPadding(float f, float f2, float f3, float f4) {
        this.mLetterBarPaddingLeft = f;
        this.mLetterBarPaddingTop = f2;
        this.mLetterBarPaddingRight = f3;
        this.mLetterBarPaddingBottom = f4;
        this.mLetterBarLayout.setPadding((int) f, (int) f2, (int) f3, (int) f4);
    }

    public void setLetterBarTouchDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.mLetterBarTouchUpBkDrawable = drawable;
        this.mLetterBarTouchDownBkDrawable = drawable2;
        this.mLetterBarTouchMoveBkDrawable = drawable3;
    }

    @TargetApi(16)
    public void setOverlayBackground(Drawable drawable) {
        if (drawable != null) {
            this.mOverlayView.setBackground(drawable);
        }
    }

    public void setOverlayPositionRange(float f, float f2) {
        this.mOverlayMinY = f;
        this.mOverlayMaxY = f2;
    }

    public void setOverlayX(float f) {
        this.mOverlayView.setX(f);
    }

    public void setRecyclerView(MzRecyclerView mzRecyclerView) {
        this.mMzRecyclerView = mzRecyclerView;
        mzRecyclerView.setOnScrollListener(this.mScrollListener);
    }

    public void showOverlay() {
        this.mOverlayView.setVisibility(0);
        ObjectAnimator objectAnimator = this.mObjAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mOverlayView, "alpha", new float[]{0.0f, 1.0f}).setDuration(100);
        this.mObjAnimator = duration;
        duration.start();
    }

    public RecyclerFastScrollLetter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.RecyclerFastScrollLetterStyle);
    }

    public RecyclerFastScrollLetter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsEnable = true;
        this.mOverlayMinY = 0.0f;
        this.mOverlayMaxY = 0.0f;
        this.OVERLAY_Y_APPEND = 80.0f;
        this.mObjAnimator = null;
        this.mLetterBarPaddingLeft = 0.0f;
        this.mLetterBarPaddingTop = 0.0f;
        this.mLetterBarPaddingRight = 0.0f;
        this.mLetterBarPaddingBottom = 0.0f;
        this.mBackgroundColorSet = null;
        this.mScrollListener = new ScrollListener();
        this.mCurrentLetter = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerFastScrollLetter, i, R.style.RecyclerFastScrollLetter);
        this.mLetterBarTouchUpBkDrawable = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcLetterBarTouchUpBkDrawable);
        this.mLetterBarTouchDownBkDrawable = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcLetterBarTouchDownBkDrawable);
        this.mLetterBarTouchMoveBkDrawable = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcLetterBarTouchMoveBkDrawable);
        this.mOverlayBkDrawable = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcOverlayBkDrawable);
        this.mLetterBarPaddingLeft = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingLeft, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_left));
        this.mLetterBarPaddingRight = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingRight, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_right));
        this.mLetterBarPaddingTop = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingTop, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_top));
        this.mLetterBarPaddingBottom = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingBottom, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_bottom));
        obtainStyledAttributes.recycle();
        initialise(context);
    }
}
