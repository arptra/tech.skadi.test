package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.meizu.common.R;
import java.util.Locale;

public class InstallProgressBar extends View {
    private static final float FLOAT_ESPINON = 1.0E-6f;
    private int mMaxProgress;
    private int mMinProgress;
    private Bitmap mNormalBitmap;
    private ObjectAnimator mObjectAnimator;
    private float mProgress = -1.0f;
    private StateListDrawable mProgressBgDrawable;
    private Bitmap mProgressBitmap;
    private Paint mProgressPaint;
    private StateListDrawable mProgressSolidDrawable;
    private StateListDrawable mSecondProgressBgDrawable;
    private boolean mUseSecondStyle = false;
    private int mWidth;

    public InstallProgressBar(Context context) {
        super(context);
        init();
    }

    private static boolean FloatEquals(float f, float f2) {
        return Math.abs(f - f2) <= FLOAT_ESPINON;
    }

    private void drawHorizontalProgress(Canvas canvas, boolean z) {
        float measuredWidth = z ? (float) getMeasuredWidth() : (getProgress() / ((float) getMaxProgress())) * ((float) getMeasuredWidth());
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            canvas.drawBitmap(this.mProgressBitmap, ((float) getMeasuredWidth()) - measuredWidth, 0.0f, this.mProgressPaint);
        } else {
            canvas.drawBitmap(this.mProgressBitmap, measuredWidth - ((float) getMeasuredWidth()), 0.0f, this.mProgressPaint);
        }
        canvas.restore();
    }

    private void drawHorizontalProgressBackground(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), (Paint) null, 31);
        canvas.drawBitmap(this.mNormalBitmap, 0.0f, 0.0f, (Paint) null);
    }

    private Bitmap drawableToBitmap(StateListDrawable stateListDrawable, int i, int i2) {
        if (i == 0) {
            i = 1;
        }
        if (i2 == 0) {
            i2 = 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, stateListDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        stateListDrawable.setBounds(0, 0, i, i2);
        stateListDrawable.draw(canvas);
        return createBitmap;
    }

    private Drawable getDrawable(int i) {
        return getResources().getDrawable(i);
    }

    private ObjectAnimator getProgressAnimator(float f) {
        float f2 = this.mProgress;
        if (f < f2) {
            return ObjectAnimator.ofFloat(this, "Progress", new float[]{0.0f, f}).setDuration(500);
        }
        return ObjectAnimator.ofFloat(this, "Progress", new float[]{f2, f}).setDuration(500);
    }

    private void init() {
        this.mMinProgress = 0;
        this.mMaxProgress = 100;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.mProgressBgDrawable = stateListDrawable;
        stateListDrawable.addState(new int[0], getDrawable(R.drawable.mc_round_button_normal));
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.mSecondProgressBgDrawable = stateListDrawable2;
        stateListDrawable2.addState(new int[0], getDrawable(R.drawable.mc_button_normal));
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.mProgressSolidDrawable = stateListDrawable3;
        stateListDrawable3.addState(new int[0], getDrawable(R.drawable.mc_install_progress_bg_normal));
        Paint paint = new Paint();
        this.mProgressPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    }

    public void cancelProgressAnimator() {
        ObjectAnimator objectAnimator = this.mObjectAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mObjectAnimator.cancel();
        }
    }

    public int getMaxProgress() {
        return this.mMaxProgress;
    }

    public int getMinProgress() {
        return this.mMinProgress;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void onDraw(Canvas canvas) {
        drawHorizontalProgressBackground(canvas);
        float f = this.mProgress;
        if (f < ((float) this.mMinProgress) || f > ((float) this.mMaxProgress)) {
            drawHorizontalProgress(canvas, true);
        } else {
            drawHorizontalProgress(canvas, false);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getMeasuredWidth() != this.mWidth) {
            this.mNormalBitmap = null;
            this.mProgressBitmap = null;
        }
        if (this.mNormalBitmap == null) {
            if (this.mUseSecondStyle) {
                this.mNormalBitmap = drawableToBitmap(this.mSecondProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            } else {
                this.mNormalBitmap = drawableToBitmap(this.mProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            }
            this.mWidth = getMeasuredWidth();
        }
        if (this.mProgressBitmap == null) {
            this.mProgressBitmap = drawableToBitmap(this.mProgressSolidDrawable, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void resetWidth() {
        this.mNormalBitmap = null;
        if (!(getMeasuredWidth() == 0 || getMeasuredHeight() == 0)) {
            Bitmap bitmap = this.mNormalBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            if (this.mUseSecondStyle) {
                this.mNormalBitmap = drawableToBitmap(this.mSecondProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            } else {
                this.mNormalBitmap = drawableToBitmap(this.mProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
            }
            Bitmap bitmap2 = this.mProgressBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.mProgressBitmap = drawableToBitmap(this.mProgressSolidDrawable, getMeasuredWidth(), getMeasuredHeight());
        }
        invalidate();
    }

    public synchronized void setAnimProgress(float f) {
        ObjectAnimator progressAnimator = getProgressAnimator(f);
        this.mObjectAnimator = progressAnimator;
        progressAnimator.start();
    }

    public void setMaxProgress(int i) {
        this.mMaxProgress = i;
    }

    public void setMinProgress(int i) {
        this.mMinProgress = i;
    }

    public synchronized void setProgress(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        int i = this.mMaxProgress;
        if (f > ((float) i)) {
            f = (float) i;
        }
        if (!FloatEquals(f, this.mProgress)) {
            this.mProgress = f;
            invalidate();
        }
    }

    public void setProgressBackColor(int i) {
        StateListDrawable stateListDrawable = this.mSecondProgressBgDrawable;
        if (stateListDrawable != null && i != 0) {
            ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i);
            ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.mProgressBgDrawable.getConstantState()).getChild(0)).setColor(i);
            if (!(getMeasuredWidth() == 0 || getMeasuredHeight() == 0)) {
                Bitmap bitmap = this.mNormalBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (this.mUseSecondStyle) {
                    this.mNormalBitmap = drawableToBitmap(this.mSecondProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
                } else {
                    this.mNormalBitmap = drawableToBitmap(this.mProgressBgDrawable, getMeasuredWidth(), getMeasuredHeight());
                }
            }
            invalidate();
        }
    }

    public void setRoundBtnColor(int i) {
        StateListDrawable stateListDrawable = this.mProgressSolidDrawable;
        if (stateListDrawable != null && i != 0) {
            ((GradientDrawable) ((DrawableContainer.DrawableContainerState) stateListDrawable.getConstantState()).getChild(0)).setColor(i);
            if (!(getMeasuredWidth() == 0 || getMeasuredHeight() == 0)) {
                Bitmap bitmap = this.mProgressBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.mProgressBitmap = drawableToBitmap(this.mProgressSolidDrawable, getMeasuredWidth(), getMeasuredHeight());
            }
            invalidate();
        }
    }

    public void setRoundRadius(float f) {
        ((GradientDrawable) ((DrawableContainer.DrawableContainerState) this.mProgressBgDrawable.getConstantState()).getChild(0)).setCornerRadius(TypedValue.applyDimension(0, f, getContext().getResources().getDisplayMetrics()));
    }

    public void useSecondStyle(boolean z) {
        if (this.mUseSecondStyle != z) {
            this.mNormalBitmap = null;
            this.mUseSecondStyle = z;
            requestLayout();
        }
    }

    public InstallProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
