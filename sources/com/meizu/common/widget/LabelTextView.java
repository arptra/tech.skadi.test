package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.meizu.common.R;

public class LabelTextView extends TextView {
    private int mBackgroundColor;
    private GradientDrawable mBackgroundDrawable;
    private int mCornorRadius;
    private Drawable mImage;

    public LabelTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void generateBackgroundDrawable() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = new GradientDrawable();
        }
        this.mBackgroundDrawable.setColor(this.mBackgroundColor);
        this.mBackgroundDrawable.setCornerRadius((float) this.mCornorRadius);
        setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getCornorRadius() {
        return this.mCornorRadius;
    }

    public Drawable getImage() {
        return this.mImage;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        generateBackgroundDrawable();
    }

    public void setCornorRadius(int i) {
        this.mCornorRadius = i;
        generateBackgroundDrawable();
    }

    public void setImage(Drawable drawable) {
        if (drawable != null) {
            this.mImage = drawable;
            setText("");
            setBackgroundDrawable(drawable);
        }
    }

    public LabelTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_LabelTextViewStyle);
    }

    public LabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LabelTextView, i, 0);
        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.LabelTextView_mcBackgroundColor, context.getResources().getColor(R.color.mc_label_text_view_default_background_color));
        this.mImage = obtainStyledAttributes.getDrawable(R.styleable.LabelTextView_mcImage);
        this.mCornorRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelTextView_mcCornorRadius, context.getResources().getDimensionPixelOffset(R.dimen.mc_label_text_view_cornor_radius));
        obtainStyledAttributes.recycle();
        generateBackgroundDrawable();
        setImage(this.mImage);
    }
}
