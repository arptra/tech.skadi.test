package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.SeekBar;

public class SkipPosSeekBar extends SeekBar {
    private ValueAnimator mAnimator;
    private float mInitialTouchX;
    private Interpolator mInterpolator;
    private boolean mIsDrag;
    /* access modifiers changed from: private */
    public float mOffset;
    /* access modifiers changed from: private */
    public int mProcess;
    private int mScaledTouchSlop;
    /* access modifiers changed from: private */
    public OnSkipAnimationListener mSkipAnimationListener;
    protected int rate;
    protected int realMax;
    protected int realProgress;

    public interface OnSkipAnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public class SkipPosSeekBarChangeListenerWrapper implements SeekBar.OnSeekBarChangeListener {
        private SeekBar.OnSeekBarChangeListener listener;

        public SkipPosSeekBarChangeListenerWrapper(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
            this.listener = onSeekBarChangeListener;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            SkipPosSeekBar skipPosSeekBar = SkipPosSeekBar.this;
            int i2 = skipPosSeekBar.rate;
            if (i2 != 0) {
                skipPosSeekBar.realProgress = (i / i2) + (i % i2 > i2 / 2 ? 1 : 0);
            } else {
                skipPosSeekBar.realProgress = i;
            }
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.listener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(seekBar, i, z);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.listener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStartTrackingTouch(seekBar);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            SkipPosSeekBar skipPosSeekBar = SkipPosSeekBar.this;
            if (skipPosSeekBar.rate != 0) {
                int progress = skipPosSeekBar.getProgress();
                SkipPosSeekBar skipPosSeekBar2 = SkipPosSeekBar.this;
                int i = skipPosSeekBar2.rate;
                if (progress % i != 0) {
                    skipPosSeekBar2.setSkipProgress((progress + (progress % i > i / 2 ? i - (progress % i) : (-progress) % i)) / i);
                }
            }
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.listener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(seekBar);
            }
        }
    }

    public SkipPosSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        this.mInterpolator = new PathInterpolator(0.2f, 0.31f, 0.34f, 1.0f);
        setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void startAnimation(final int i, final float f, final float f2, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mAnimator = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f = f2;
                float f2 = f;
                if (f > f2) {
                    int unused = SkipPosSeekBar.this.mProcess = i + ((int) ((floatValue * (f - f2)) / SkipPosSeekBar.this.mOffset));
                } else {
                    int unused2 = SkipPosSeekBar.this.mProcess = i - ((int) ((floatValue * (f2 - f)) / SkipPosSeekBar.this.mOffset));
                }
                SkipPosSeekBar skipPosSeekBar = SkipPosSeekBar.this;
                skipPosSeekBar.setProgress(skipPosSeekBar.mProcess);
            }
        });
        this.mAnimator.setInterpolator(this.mInterpolator);
        this.mAnimator.setDuration((long) i2);
        this.mAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (SkipPosSeekBar.this.mSkipAnimationListener != null) {
                    SkipPosSeekBar.this.mSkipAnimationListener.onAnimationEnd();
                }
                super.onAnimationEnd(animator);
            }

            public void onAnimationStart(Animator animator) {
                if (SkipPosSeekBar.this.mSkipAnimationListener != null) {
                    SkipPosSeekBar.this.mSkipAnimationListener.onAnimationStart();
                }
                super.onAnimationStart(animator);
            }
        });
        this.mAnimator.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trackTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            int r0 = java.lang.Math.round(r0)
            float r7 = r7.getY()
            java.lang.Math.round(r7)
            int r7 = r6.getWidth()
            int r1 = r6.getPaddingLeft()
            int r1 = r7 - r1
            int r2 = r6.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r6.getLayoutDirection()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r5 = 1
            if (r2 != r5) goto L_0x0044
            int r2 = r6.getPaddingRight()
            int r7 = r7 - r2
            if (r0 <= r7) goto L_0x0031
        L_0x002f:
            r3 = r4
            goto L_0x005a
        L_0x0031:
            int r7 = r6.getPaddingLeft()
            if (r0 >= r7) goto L_0x0038
            goto L_0x005a
        L_0x0038:
            int r7 = r1 - r0
            int r0 = r6.getPaddingLeft()
            int r7 = r7 + r0
            float r7 = (float) r7
        L_0x0040:
            float r0 = (float) r1
            float r3 = r7 / r0
            goto L_0x005a
        L_0x0044:
            int r2 = r6.getPaddingLeft()
            if (r0 >= r2) goto L_0x004b
            goto L_0x002f
        L_0x004b:
            int r2 = r6.getPaddingRight()
            int r7 = r7 - r2
            if (r0 <= r7) goto L_0x0053
            goto L_0x005a
        L_0x0053:
            int r7 = r6.getPaddingLeft()
            int r0 = r0 - r7
            float r7 = (float) r0
            goto L_0x0040
        L_0x005a:
            int r7 = r6.getMax()
            int r0 = r6.getMin()
            int r7 = r7 - r0
            float r0 = (float) r7
            float r3 = r3 * r0
            float r4 = r4 + r3
            if (r7 == 0) goto L_0x0069
            r5 = r7
        L_0x0069:
            float r7 = (float) r5
            float r4 = r4 / r7
            r6.setSkipProgress((float) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.SkipPosSeekBar.trackTouchEvent(android.view.MotionEvent):void");
    }

    public int getRealProgress() {
        return this.realProgress;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SkipPosSeekBar.class.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.realProgress;
        this.realProgress = i;
        setProgress(i);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState((Parcelable) (View.BaseSavedState) super.onSaveInstanceState());
        savedState.realProgress = this.realProgress;
        return savedState;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (getProgressDrawable() != null) {
            this.mOffset = (float) (getProgressDrawable().getBounds().width() / this.realMax);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mInitialTouchX = x;
        } else if (action == 1) {
            if (!this.mIsDrag) {
                trackTouchEvent(motionEvent);
            }
            this.mIsDrag = false;
        } else if (action != 2) {
            if (action == 3 && this.mIsDrag) {
                this.mIsDrag = false;
            }
        } else if (Math.abs(motionEvent.getX() - this.mInitialTouchX) > ((float) this.mScaledTouchSlop)) {
            this.mIsDrag = true;
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setAntiAlias(boolean z) {
        if (z) {
            if (this.rate != 20) {
                this.rate = 20;
                setMax(getMax());
                setProgress(getProgress());
            }
        } else if (this.rate != 0) {
            this.rate = 0;
            setProgress(getProgress() / 20);
            setMax(getMax() / 20);
        }
    }

    public synchronized void setMax(int i) {
        int i2 = this.rate;
        if (i2 == 0) {
            i2 = 1;
        }
        super.setMax(i2 * i);
        this.realMax = i;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        super.setOnSeekBarChangeListener(new SkipPosSeekBarChangeListenerWrapper(onSeekBarChangeListener));
    }

    public synchronized void setProgress(int i) {
        int i2 = this.rate;
        if (i2 == 0) {
            i2 = 1;
        }
        super.setProgress(i2 * i);
        this.realProgress = i;
    }

    public void setSkipAnimationListener(OnSkipAnimationListener onSkipAnimationListener) {
        this.mSkipAnimationListener = onSkipAnimationListener;
    }

    public void setSkipPosMax(int i) {
        if (this.realMax != i) {
            setMax(i);
            setProgress(Math.round((((float) getRealProgress()) / ((float) this.realMax)) * ((float) this.realMax)));
            if (getProgressDrawable() != null) {
                this.mOffset = ((float) getProgressDrawable().getBounds().width()) / ((float) this.realMax);
            }
        }
    }

    public void setSkipProgress(int i) {
        float paddingLeft = ((float) getPaddingLeft()) + (((float) i) * this.mOffset);
        float paddingLeft2 = ((float) getPaddingLeft()) + (((float) getRealProgress()) * this.mOffset);
        int realProgress2 = getRealProgress();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        startAnimation(realProgress2, paddingLeft2, paddingLeft, (int) (Math.abs(paddingLeft - paddingLeft2) * 0.44444445f));
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
        int realProgress;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.realProgress = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.realProgress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SkipPosSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipPosSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProcess = 0;
        this.mIsDrag = false;
        init();
    }

    public void setSkipProgress(float f) {
        setSkipProgress(Math.round(f * ((float) this.realMax)));
    }
}
