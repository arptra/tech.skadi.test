package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.RemoteViews;
import com.meizu.common.R;

@RemoteViews.RemoteView
public class ProgressBar extends View {
    private static final int MAX_LEVEL = 10000;
    private AlphaAnimation mAnimation;
    private int mBehavior;
    private int mBreakPoint;
    private Drawable mCurrentDrawable;
    private int mDuration;
    private boolean mHasAnimation;
    private boolean mInDrawing;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private Interpolator mInterpolator;
    private boolean mIsVertical;
    private int mMax;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    private boolean mNoInvalidate;
    private boolean mOnlyIndeterminate;
    private int mProgress;
    private Drawable mProgressDrawable;
    private boolean mRefreshIsPosted;
    /* access modifiers changed from: private */
    public RefreshProgressRunnable mRefreshProgressRunnable;
    Bitmap mSampleTile;
    private int mSecondaryProgress;
    private boolean mShouldStartAnimationDrawable;
    private Transformation mTransformation;
    private long mUiThreadId;

    public class RefreshProgressRunnable implements Runnable {
        private boolean mFromUser;
        private int mId;
        private int mProgress;

        public RefreshProgressRunnable(int i, int i2, boolean z) {
            this.mId = i;
            this.mProgress = i2;
            this.mFromUser = z;
        }

        public void run() {
            ProgressBar.this.doRefreshProgress(this.mId, this.mProgress, this.mFromUser, true);
            RefreshProgressRunnable unused = ProgressBar.this.mRefreshProgressRunnable = this;
        }

        public void setup(int i, int i2, boolean z) {
            this.mId = i;
            this.mProgress = i2;
            this.mFromUser = z;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int progress;
        int secondaryProgress;

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
            parcel.writeInt(this.secondaryProgress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            this.secondaryProgress = parcel.readInt();
        }
    }

    public ProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public synchronized void doRefreshProgress(int i, int i2, boolean z, boolean z2) {
        try {
            int i3 = this.mMax;
            float f = i3 > 0 ? ((float) i2) / ((float) i3) : 0.0f;
            Drawable drawable = this.mCurrentDrawable;
            if (drawable != null) {
                Drawable findDrawableByLayerId = drawable instanceof LayerDrawable ? ((LayerDrawable) drawable).findDrawableByLayerId(i) : null;
                int i4 = (int) (10000.0f * f);
                if (findDrawableByLayerId != null) {
                    drawable = findDrawableByLayerId;
                }
                drawable.setLevel(i4);
            } else {
                invalidate();
            }
            if (z2 && i == 16908301) {
                onProgressRefresh(f, z);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void initProgressBar() {
        this.mMax = 100;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mIndeterminate = false;
        this.mOnlyIndeterminate = false;
        this.mDuration = 4000;
        this.mBehavior = 1;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
    }

    private synchronized void refreshProgress(int i, int i2, boolean z) {
        try {
            if (this.mUiThreadId == Thread.currentThread().getId()) {
                doRefreshProgress(i, i2, z, true);
            } else {
                RefreshProgressRunnable refreshProgressRunnable = this.mRefreshProgressRunnable;
                if (refreshProgressRunnable != null) {
                    this.mRefreshProgressRunnable = null;
                    refreshProgressRunnable.setup(i, i2, z);
                } else {
                    refreshProgressRunnable = new RefreshProgressRunnable(i, i2, z);
                }
                post(refreshProgressRunnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Drawable tileify(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            return drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = tileify(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
        }
        return layerDrawable2;
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable tileify = tileify(animationDrawable.getFrame(i), true);
            tileify.setLevel(10000);
            animationDrawable2.addFrame(tileify, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private void updateDrawableBounds(int i, int i2) {
        int i3;
        int i4;
        int paddingRight = (i - getPaddingRight()) - getPaddingLeft();
        int paddingBottom = (i2 - getPaddingBottom()) - getPaddingTop();
        Drawable drawable = this.mIndeterminateDrawable;
        if (drawable != null) {
            if (this.mOnlyIndeterminate && !(drawable instanceof AnimationDrawable)) {
                float intrinsicWidth = ((float) drawable.getIntrinsicWidth()) / ((float) this.mIndeterminateDrawable.getIntrinsicHeight());
                float f = (float) i;
                float f2 = (float) i2;
                float f3 = f / f2;
                if (intrinsicWidth != f3) {
                    if (f3 > intrinsicWidth) {
                        int i5 = (int) (f2 * intrinsicWidth);
                        i4 = (i - i5) / 2;
                        paddingRight = i4 + i5;
                        i3 = 0;
                    } else {
                        int i6 = (int) (f * (1.0f / intrinsicWidth));
                        i3 = (i2 - i6) / 2;
                        paddingBottom = i3 + i6;
                        i4 = 0;
                    }
                    this.mIndeterminateDrawable.setBounds(i4, i3, paddingRight, paddingBottom);
                }
            }
            i4 = 0;
            i3 = 0;
            this.mIndeterminateDrawable.setBounds(i4, i3, paddingRight, paddingBottom);
        }
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    private void updateDrawableState() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null && drawable.isStateful()) {
            this.mProgressDrawable.setState(drawableState);
        }
        Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            this.mIndeterminateDrawable.setState(drawableState);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    public Drawable getCurrentDrawable() {
        return this.mCurrentDrawable;
    }

    public Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    public Drawable getIndeterminateDrawable() {
        return this.mIndeterminateDrawable;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        return this.mMax;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        return this.mIndeterminate ? 0 : this.mProgress;
    }

    public Drawable getProgressDrawable() {
        return this.mProgressDrawable;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        return this.mIndeterminate ? 0 : this.mSecondaryProgress;
    }

    public final synchronized void incrementProgressBy(int i) {
        setProgress(this.mProgress + i);
    }

    public final synchronized void incrementSecondaryProgressBy(int i) {
        setSecondaryProgress(this.mSecondaryProgress + i);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mInDrawing) {
            return;
        }
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized boolean isIndeterminate() {
        return this.mIndeterminate;
    }

    public boolean isIsVertical() {
        return this.mIsVertical;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIndeterminate) {
            startAnimation();
        }
    }

    public void onDetachedFromWindow() {
        if (this.mIndeterminate) {
            stopAnimation();
        }
        RefreshProgressRunnable refreshProgressRunnable = this.mRefreshProgressRunnable;
        if (refreshProgressRunnable != null) {
            removeCallbacks(refreshProgressRunnable);
        }
        RefreshProgressRunnable refreshProgressRunnable2 = this.mRefreshProgressRunnable;
        if (refreshProgressRunnable2 != null && this.mRefreshIsPosted) {
            removeCallbacks(refreshProgressRunnable2);
        }
        super.onDetachedFromWindow();
    }

    public synchronized void onDraw(Canvas canvas) {
        int width;
        int paddingRight;
        Rect rect;
        Rect rect2;
        try {
            super.onDraw(canvas);
            Drawable drawable = this.mCurrentDrawable;
            if (drawable != null) {
                if (this.mIsVertical) {
                    width = getHeight() - getPaddingTop();
                    paddingRight = getPaddingBottom();
                } else {
                    width = getWidth() - getPaddingLeft();
                    paddingRight = getPaddingRight();
                }
                int i = width - paddingRight;
                int max = getMax() != 0 ? (this.mBreakPoint * i) / getMax() : 0;
                if (this.mIsVertical) {
                    int i2 = i - max;
                    rect2 = new Rect(0, 0, getWidth(), i2);
                    rect = new Rect(0, i2 + 5, getWidth(), i);
                } else {
                    rect2 = new Rect(0, 0, max, getHeight());
                    rect = new Rect(max + 5, 0, i, getHeight());
                }
                canvas.save();
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                long drawingTime = getDrawingTime();
                if (this.mHasAnimation) {
                    this.mAnimation.getTransformation(drawingTime, this.mTransformation);
                    float alpha = this.mTransformation.getAlpha();
                    this.mInDrawing = true;
                    drawable.setLevel((int) (alpha * 10000.0f));
                    this.mInDrawing = false;
                    postInvalidate();
                }
                if (this.mBreakPoint == getMax() || this.mBreakPoint == 0) {
                    drawable.draw(canvas);
                    canvas.restore();
                } else {
                    canvas.clipRect(rect2);
                    drawable.draw(canvas);
                    canvas.restore();
                    canvas.save();
                    canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                    canvas.clipRect(rect);
                    drawable.draw(canvas);
                    canvas.restore();
                }
                if (this.mShouldStartAnimationDrawable && (drawable instanceof Animatable)) {
                    ((Animatable) drawable).start();
                    this.mShouldStartAnimationDrawable = false;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ProgressBar.class.getName());
        accessibilityEvent.setItemCount(this.mMax);
        accessibilityEvent.setCurrentItemIndex(this.mProgress);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ProgressBar.class.getName());
    }

    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        try {
            Drawable drawable = this.mCurrentDrawable;
            if (drawable != null) {
                i3 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, drawable.getIntrinsicWidth()));
                i4 = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, drawable.getIntrinsicHeight()));
            } else {
                i4 = 0;
                i3 = 0;
            }
            updateDrawableState();
            setMeasuredDimension(View.resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onProgressRefresh(float f, boolean z) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
        setSecondaryProgress(savedState.secondaryProgress);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.mProgress;
        savedState.secondaryProgress = this.mSecondaryProgress;
        return savedState;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateDrawableBounds(i, i2);
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (!this.mIndeterminate) {
            return;
        }
        if (i == 8 || i == 4) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }

    public void postInvalidate() {
        if (!this.mNoInvalidate) {
            super.postInvalidate();
        }
    }

    public void setBreakPoint(int i) {
        this.mBreakPoint = i;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z) {
        try {
            if (this.mOnlyIndeterminate) {
                if (!this.mIndeterminate) {
                }
            }
            if (z != this.mIndeterminate) {
                this.mIndeterminate = z;
                if (z) {
                    this.mCurrentDrawable = this.mIndeterminateDrawable;
                    startAnimation();
                } else {
                    this.mCurrentDrawable = this.mProgressDrawable;
                    stopAnimation();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.mIndeterminateDrawable = drawable;
        if (this.mIndeterminate) {
            this.mCurrentDrawable = drawable;
            postInvalidate();
        }
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setIsVertical(boolean z) {
        this.mIsVertical = z;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        try {
            if (i != this.mMax) {
                this.mMax = i;
                postInvalidate();
                if (this.mProgress > i) {
                    this.mProgress = i;
                }
                refreshProgress(16908301, this.mProgress, false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setProgress(int i) {
        setProgress(i, false);
    }

    public void setProgressDrawable(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 == null || drawable == drawable2) {
            z = false;
        } else {
            drawable2.setCallback((Drawable.Callback) null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            int minimumHeight = drawable.getMinimumHeight();
            if (this.mMaxHeight < minimumHeight) {
                this.mMaxHeight = minimumHeight;
                requestLayout();
            }
        }
        this.mProgressDrawable = drawable;
        if (!this.mIndeterminate) {
            this.mCurrentDrawable = drawable;
            postInvalidate();
        }
        if (z) {
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(16908301, this.mProgress, false, false);
            doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
        }
    }

    public void setProgressDrawableResource(int i) {
        Drawable progressDrawable = getProgressDrawable();
        Drawable drawable = getContext().getResources().getDrawable(i);
        drawable.setBounds(progressDrawable.copyBounds());
        setProgressDrawable(drawable);
        if (this.mProgress > 0) {
            incrementProgressBy(-1);
            incrementProgressBy(1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setSecondaryProgress(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.mIndeterminate     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 0
            if (r3 >= 0) goto L_0x000b
            r3 = r0
        L_0x000b:
            int r1 = r2.mMax     // Catch:{ all -> 0x001d }
            if (r3 <= r1) goto L_0x0010
            r3 = r1
        L_0x0010:
            int r1 = r2.mSecondaryProgress     // Catch:{ all -> 0x001d }
            if (r3 == r1) goto L_0x001f
            r2.mSecondaryProgress = r3     // Catch:{ all -> 0x001d }
            r1 = 16908303(0x102000f, float:2.387727E-38)
            r2.refreshProgress(r1, r3, r0)     // Catch:{ all -> 0x001d }
            goto L_0x001f
        L_0x001d:
            r3 = move-exception
            goto L_0x0021
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ProgressBar.setSecondaryProgress(int):void");
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (!this.mIndeterminate) {
                return;
            }
            if (i == 8 || i == 4) {
                stopAnimation();
            } else {
                startAnimation();
            }
        }
    }

    public void startAnimation() {
        if (getVisibility() == 0) {
            if (this.mIndeterminateDrawable instanceof Animatable) {
                this.mShouldStartAnimationDrawable = true;
                this.mAnimation = null;
            } else {
                if (this.mInterpolator == null) {
                    this.mInterpolator = new LinearInterpolator();
                }
                this.mTransformation = new Transformation();
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.mAnimation = alphaAnimation;
                alphaAnimation.setRepeatMode(this.mBehavior);
                this.mAnimation.setRepeatCount(-1);
                this.mAnimation.setDuration((long) this.mDuration);
                this.mAnimation.setInterpolator(this.mInterpolator);
                this.mAnimation.setStartTime(-1);
            }
            postInvalidate();
        }
    }

    public void stopAnimation() {
        this.mAnimation = null;
        this.mTransformation = null;
        Drawable drawable = this.mIndeterminateDrawable;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mProgressDrawable || drawable == this.mIndeterminateDrawable || super.verifyDrawable(drawable);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_ProgressBarStyle);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setProgress(int r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mIndeterminate     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r2 >= 0) goto L_0x000a
            r2 = 0
        L_0x000a:
            int r0 = r1.mMax     // Catch:{ all -> 0x001c }
            if (r2 <= r0) goto L_0x000f
            r2 = r0
        L_0x000f:
            int r0 = r1.mProgress     // Catch:{ all -> 0x001c }
            if (r2 == r0) goto L_0x001e
            r1.mProgress = r2     // Catch:{ all -> 0x001c }
            r0 = 16908301(0x102000d, float:2.3877265E-38)
            r1.refreshProgress(r0, r2, r3)     // Catch:{ all -> 0x001c }
            goto L_0x001e
        L_0x001c:
            r2 = move-exception
            goto L_0x0020
        L_0x001e:
            monitor-exit(r1)
            return
        L_0x0020:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ProgressBar.setProgress(int, boolean):void");
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        boolean z = false;
        this.mBreakPoint = 0;
        this.mIsVertical = false;
        this.mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBar, i, i2);
        this.mNoInvalidate = true;
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ProgressBar_mcProgressDrawable);
        if (drawable != null) {
            setProgressDrawable(tileify(drawable, false));
        }
        this.mDuration = obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcIndeterminateDuration, this.mDuration);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMinWidth, this.mMinWidth);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMaxWidth, this.mMaxWidth);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMinHeight, this.mMinHeight);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMaxHeight, this.mMaxHeight);
        this.mBehavior = obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcIndeterminateBehavior, this.mBehavior);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ProgressBar_mcInterpolator, 17432587);
        if (resourceId > 0) {
            setInterpolator(context, resourceId);
        }
        setMax(obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcMax, this.mMax));
        setProgress(obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcProgress, this.mProgress));
        setSecondaryProgress(obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcSecondaryProgress, this.mSecondaryProgress));
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ProgressBar_mcIndeterminateDrawable);
        if (drawable2 != null) {
            setIndeterminateDrawable(tileifyIndeterminate(drawable2));
        }
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.ProgressBar_mcIndeterminateOnly, this.mOnlyIndeterminate);
        this.mOnlyIndeterminate = z2;
        this.mNoInvalidate = false;
        setIndeterminate((z2 || obtainStyledAttributes.getBoolean(R.styleable.ProgressBar_mcIndeterminate, this.mIndeterminate)) ? true : z);
        obtainStyledAttributes.recycle();
    }
}
