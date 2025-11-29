package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.animator.MzPressAnimationHelper;
import com.meizu.common.util.GradientDrawableFactory;
import com.meizu.common.widget.LabelLayout;

public class LabelItem extends RelativeLayout {
    private Context mContext;
    private int mIconMarginBottom;
    private int mIconMarginLeft;
    private int mIconMaxHeight;
    private int mIconMaxWidth;
    private LabelLayout.ImagePlayer mImagePlayer;
    private ImageView mImageView;
    private boolean mIsMiniLabel;
    private int mNormalColor;
    private int mPaddingHorizontal;
    private int mPaddingVertical;
    private int mPressColor;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private float mTextSize;
    private TextView mTextView;
    private Typeface mTypeface;

    public LabelItem(Context context, String str, float f, Typeface typeface, int i, int i2, int i3, int i4, int i5, int i6, LabelLayout.ImagePlayer imagePlayer, int i7, int i8, int i9, int i10) {
        this(context, str, f, typeface, i, i2, i3, i4, i5, i6, imagePlayer, i7, i8, i9, i10, false);
    }

    private void init() {
        RelativeLayout.LayoutParams layoutParams;
        TextView textView = new TextView(this.mContext);
        this.mTextView = textView;
        textView.setText(this.mText);
        this.mTextView.setGravity(8388611);
        this.mTextView.setTextSize(0, this.mTextSize);
        this.mTextView.setMaxLines(1);
        this.mTextView.setBackgroundDrawable(GradientDrawableFactory.getStateListDrawable(this.mNormalColor, this.mPressColor, this.mRadius));
        this.mTextView.setTextColor(this.mTextColor);
        this.mTextView.setTypeface(this.mTypeface);
        this.mTextView.setMaxEms(9);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setFallbackLineSpacing(false);
        if (this.mIsMiniLabel) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(13);
            this.mTextView.setGravity(16);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
        }
        addView(this.mTextView, layoutParams);
        if (this.mImagePlayer != null) {
            ImageView imageView = new ImageView(this.mContext);
            this.mImageView = imageView;
            imageView.setMaxWidth(this.mIconMaxWidth);
            this.mImageView.setMaxHeight(this.mIconMaxHeight);
            this.mImageView.setAdjustViewBounds(true);
            this.mImagePlayer.displayImage(this.mContext, this.mImageView);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(12);
            layoutParams2.addRule(11);
            layoutParams2.setMargins(0, 0, this.mIconMarginLeft, this.mIconMarginBottom);
            addView(this.mImageView, layoutParams2);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (this.mImagePlayer == null || this.mImageView.getDrawable() == null) {
            TextView textView = this.mTextView;
            int i5 = this.mPaddingHorizontal;
            int i6 = this.mPaddingVertical;
            textView.setPadding(i5, i6, i5, i6);
            this.mTextView.measure(i, makeMeasureSpec);
            i3 = View.MeasureSpec.makeMeasureSpec(this.mTextView.getMeasuredWidth(), 1073741824);
            i4 = View.MeasureSpec.makeMeasureSpec(this.mTextView.getMeasuredHeight(), 1073741824);
        } else {
            this.mImageView.measure(i, makeMeasureSpec);
            int measuredWidth = (this.mIconMarginLeft * 2) + this.mImageView.getMeasuredWidth();
            TextView textView2 = this.mTextView;
            int i7 = this.mPaddingHorizontal;
            int i8 = this.mPaddingVertical;
            textView2.setPadding(i7, i8, measuredWidth, i8);
            this.mTextView.measure(i, makeMeasureSpec);
            int max = Math.max(this.mIconMarginBottom + this.mImageView.getMeasuredHeight(), this.mTextView.getMeasuredHeight());
            i3 = View.MeasureSpec.makeMeasureSpec(this.mTextView.getMeasuredWidth(), 1073741824);
            i4 = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        }
        super.onMeasure(i3, i4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LabelItem(Context context, String str, float f, Typeface typeface, int i, int i2, int i3, int i4, int i5, int i6, LabelLayout.ImagePlayer imagePlayer, int i7, int i8, int i9, int i10, boolean z) {
        super(context);
        this.mContext = context;
        this.mText = str;
        this.mTextSize = f;
        this.mTypeface = typeface;
        this.mPaddingHorizontal = i;
        this.mPaddingVertical = i2;
        this.mTextColor = i3;
        this.mNormalColor = i4;
        this.mPressColor = i5;
        this.mRadius = i6;
        this.mImagePlayer = imagePlayer;
        this.mIconMaxWidth = i7;
        this.mIconMaxHeight = i8;
        this.mIconMarginLeft = i9;
        this.mIconMarginBottom = i10;
        this.mIsMiniLabel = z;
        init();
        new MzPressAnimationHelper().addTargetView(this, false);
    }
}
