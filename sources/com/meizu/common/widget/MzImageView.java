package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.meizu.common.R;
import com.meizu.common.animator.MzPressAnimationBuilder;

public class MzImageView extends ImageView {
    private static final int ANIMATION_DURATION = 200;
    private static final float TO_ALPHA = 0.8f;
    private static final float TO_X_SCALE = 0.9f;
    private static final float TO_Y_SCALE = 0.9f;
    private boolean mAnimationEnabled = true;
    private int mDuration;
    private MzPressAnimationBuilder mMzPressAnimationBuilder;
    private float mToAlpha;
    private float mToXScale;
    private float mToYScale;

    @RequiresApi
    public MzImageView(@NonNull Context context) {
        super(context);
        initParams(context, (AttributeSet) null, 0, 0);
    }

    private void initParams(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzImageView, i, i2);
        this.mAnimationEnabled = obtainStyledAttributes.getBoolean(R.styleable.MzImageView_pressAnimationEnabled, this.mAnimationEnabled);
        this.mDuration = obtainStyledAttributes.getInt(R.styleable.MzImageView_pressAnimationDuration, 200);
        this.mToXScale = obtainStyledAttributes.getFloat(R.styleable.MzImageView_toXScale, 0.9f);
        this.mToYScale = obtainStyledAttributes.getFloat(R.styleable.MzImageView_toYScale, 0.9f);
        this.mToAlpha = obtainStyledAttributes.getFloat(R.styleable.MzImageView_toAlpha, TO_ALPHA);
        obtainStyledAttributes.recycle();
        if (this.mAnimationEnabled) {
            MzPressAnimationBuilder mzPressAnimationBuilder = new MzPressAnimationBuilder(this);
            this.mMzPressAnimationBuilder = mzPressAnimationBuilder;
            mzPressAnimationBuilder.pressAnimationInit();
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    public float getToAlpha() {
        return this.mToAlpha;
    }

    public float getToXScale() {
        return this.mToXScale;
    }

    public float getToYScale() {
        return this.mToYScale;
    }

    public boolean isAnimationEnabled() {
        return this.mAnimationEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && this.mAnimationEnabled) {
                this.mMzPressAnimationBuilder.pressAnimationReverse();
            }
        } else if (this.mAnimationEnabled) {
            this.mMzPressAnimationBuilder.pressAnimationStart();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationEnabled(boolean z) {
        this.mAnimationEnabled = z;
    }

    public void setDuration(int i) {
        MzPressAnimationBuilder mzPressAnimationBuilder;
        if (i != this.mDuration && (mzPressAnimationBuilder = this.mMzPressAnimationBuilder) != null) {
            this.mDuration = i;
            mzPressAnimationBuilder.setDuration(i);
        }
    }

    public void setToAlpha(@FloatRange float f) {
        this.mToAlpha = f;
        MzPressAnimationBuilder mzPressAnimationBuilder = this.mMzPressAnimationBuilder;
        if (mzPressAnimationBuilder != null) {
            mzPressAnimationBuilder.setToAlpha(f);
        }
    }

    public void setToXScale(@FloatRange float f) {
        this.mToXScale = f;
        MzPressAnimationBuilder mzPressAnimationBuilder = this.mMzPressAnimationBuilder;
        if (mzPressAnimationBuilder != null) {
            mzPressAnimationBuilder.setToXScale(f);
        }
    }

    public void setToYScale(@FloatRange float f) {
        this.mToYScale = f;
        MzPressAnimationBuilder mzPressAnimationBuilder = this.mMzPressAnimationBuilder;
        if (mzPressAnimationBuilder != null) {
            mzPressAnimationBuilder.setToYScale(f);
        }
    }

    @RequiresApi
    public MzImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initParams(context, attributeSet, 0, 0);
    }

    @RequiresApi
    public MzImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initParams(context, attributeSet, i, 0);
    }

    @RequiresApi
    public MzImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initParams(context, attributeSet, i, i2);
    }
}
