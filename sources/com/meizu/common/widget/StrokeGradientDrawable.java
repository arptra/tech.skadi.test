package com.meizu.common.widget;

import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;

class StrokeGradientDrawable {
    private int mAlpha;
    private int mColor;
    private GradientDrawable mGradientDrawable;
    private int mHeight;
    private int mPaddingLeft;
    private int mPaddingRight;
    private float mRadius;
    private int mStrokeColor;
    private int mStrokeWidth;
    private int mWidth;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.mGradientDrawable = gradientDrawable;
    }

    public float getAlpha() {
        return (float) this.mAlpha;
    }

    public int getColor() {
        return this.mColor;
    }

    public GradientDrawable getGradientDrawable() {
        return this.mGradientDrawable;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            this.mGradientDrawable.setAlpha(i);
        }
    }

    public void setColor(int i) {
        this.mColor = i;
        this.mGradientDrawable.setColor(i);
        this.mGradientDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }

    public void setCornerRadius(float f) {
        this.mRadius = f;
        this.mGradientDrawable.setCornerRadius(f);
    }

    public void setHeight(int i) {
        this.mHeight = i;
        this.mGradientDrawable.setSize(this.mWidth, i);
    }

    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        this.mGradientDrawable.setStroke(getStrokeWidth(), i);
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
        this.mGradientDrawable.setStroke(i, getStrokeColor());
    }

    public void setWidth(int i) {
        this.mWidth = i;
        this.mGradientDrawable.setSize(i, this.mHeight);
    }
}
