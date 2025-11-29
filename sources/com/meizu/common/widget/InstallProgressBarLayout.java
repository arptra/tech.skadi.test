package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.animator.MzPressAnimationHelper;
import java.text.NumberFormat;

public class InstallProgressBarLayout extends LinearLayout {
    private static final float FLOAT_ESPINON = 1.0E-6f;
    private boolean mAutoTextChange = false;
    private float mCanvasScale = 1.0f;
    private float mCenterX;
    private float mCenterY;
    private int mCoverTextColor;
    private float mDensity;
    private int mLayoutHeight;
    private InstallProgressBar mProgressBar;
    private int mProgressColor;
    private InstallProgressBarText mProgressText;
    private TextView mPromotionStatusPriceText;
    private Drawable mShadowDrawable;
    private String mText;
    private String mTextUnit;

    public InstallProgressBarLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private static boolean FloatEquals(float f, float f2) {
        return Math.abs(f - f2) <= FLOAT_ESPINON;
    }

    private void drawShadow(Canvas canvas) {
        if (this.mShadowDrawable != null) {
            canvas.save();
            float f = 1.0f - ((1.0f - this.mCanvasScale) * 6.0f);
            canvas.scale(f, f, this.mCenterX, this.mCenterY);
            int i = this.mLayoutHeight;
            canvas.translate(0.0f, ((this.mCanvasScale - 1.0f) * ((float) i) * 6.0f) + (((float) i) * 0.4f) + this.mDensity);
            this.mShadowDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mc_install_progress_bar_layout, this);
        this.mCoverTextColor = getContext().getResources().getColor(R.color.white);
        this.mDensity = getResources().getDisplayMetrics().density;
        initAttributes(context, attributeSet);
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = getTypedArray(context, attributeSet, R.styleable.InstallProgressBarLayout);
        if (typedArray != null) {
            InstallProgressBar installProgressBar = (InstallProgressBar) findViewById(R.id.round_corner_progress);
            this.mProgressBar = installProgressBar;
            installProgressBar.setRoundRadius((float) typedArray.getDimensionPixelSize(R.styleable.InstallProgressBarLayout_mcBackRoundRadius, getResources().getDimensionPixelSize(R.dimen.default_round_radius)));
            this.mProgressText = (InstallProgressBarText) findViewById(R.id.round_corner_progress_text);
            this.mPromotionStatusPriceText = (TextView) findViewById(R.id.round_corner_promotion_status_price_text);
            this.mAutoTextChange = typedArray.getBoolean(R.styleable.InstallProgressBarLayout_mcAutoTextChange, false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.online_theme_download_install_font_size);
            this.mProgressText.setTextSize((int) typedArray.getDimension(R.styleable.InstallProgressBarLayout_mcTextProgressSize, (float) dimensionPixelOffset));
            int color = typedArray.getColor(R.styleable.InstallProgressBarLayout_mcTextCoverProgressColor, this.mCoverTextColor);
            this.mCoverTextColor = color;
            this.mProgressText.setTextOriginColor(color);
            this.mProgressText.setTextChangeColor(this.mCoverTextColor);
            String string = typedArray.getString(R.styleable.InstallProgressBarLayout_mcProgressText);
            this.mText = string;
            String str = "";
            if (string == null) {
                string = str;
            }
            this.mText = string;
            this.mProgressText.setText(string);
            this.mProgressText.setPadding(0, 0, 0, (int) typedArray.getDimension(R.styleable.InstallProgressBarLayout_mcTextProgressPadding, 10.0f));
            String string2 = typedArray.getString(R.styleable.InstallProgressBarLayout_mcTextProgressUnit);
            this.mTextUnit = string2;
            if (string2 != null) {
                str = string2;
            }
            this.mTextUnit = str;
            int color2 = typedArray.getColor(R.styleable.InstallProgressBarLayout_mcProgressColor, getContext().getResources().getColor(R.color.progress_color_black));
            this.mProgressColor = color2;
            this.mProgressBar.setRoundBtnColor(color2);
            this.mProgressBar.setProgressBackColor(typedArray.getColor(R.styleable.InstallProgressBarLayout_mcProgressBackColor, getContext().getResources().getColor(R.color.progress_normal_color)));
            this.mProgressBar.setMinProgress((int) typedArray.getFloat(R.styleable.InstallProgressBarLayout_mcMinProgress, 0.0f));
            typedArray.recycle();
        }
    }

    private void updateViewUI(float f, boolean z, String str) {
        if (z) {
            this.mProgressBar.setAnimProgress(f);
        } else {
            this.mProgressBar.setProgress(f);
        }
        if (this.mAutoTextChange && str != null) {
            float f2 = f % 1.0f;
            String format = NumberFormat.getInstance().format(FloatEquals(f2, 0.0f) ? (double) f : (double) (f / 100.0f));
            InstallProgressBarText installProgressBarText = this.mProgressText;
            installProgressBarText.setText(str + " " + format + this.mTextUnit);
            FloatEquals(f2, 0.0f);
            float f3 = f / 100.0f;
            if (z) {
                this.mProgressText.setAnimProgress(f3);
            } else {
                this.mProgressText.setProgress(f3);
            }
        }
    }

    public void cancelProgressAnimator() {
        this.mProgressBar.cancelProgressAnimator();
        this.mProgressText.cancelProgressAnimator();
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        float f = this.mCanvasScale;
        canvas.scale(f, f, this.mCenterX, this.mCenterY);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public float getCanvasScale() {
        return this.mCanvasScale;
    }

    public InstallProgressBarText getProgressText() {
        return this.mProgressText;
    }

    public TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mLayoutHeight = i2;
        this.mCenterX = (float) (i / 2);
        this.mCenterY = (float) (i2 / 2);
        Drawable drawable = this.mShadowDrawable;
        if (drawable != null) {
            drawable.setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
            this.mShadowDrawable.setBounds(0, 0, i, this.mLayoutHeight);
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
        }
    }

    public void refreshProgressBar() {
        if (isClickable()) {
            this.mProgressBar.setRoundBtnColor(this.mProgressColor);
        }
    }

    public void resetStatusTextView(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mProgressText.getLayoutParams();
        if (z) {
            layoutParams.width = -2;
        } else {
            layoutParams.width = -1;
        }
        this.mProgressText.setLayoutParams(layoutParams);
    }

    public void resetTextColor() {
        this.mProgressText.resetTextColor();
    }

    public void resetWidth() {
        this.mProgressBar.resetWidth();
    }

    public void setAutoTextChange(boolean z) {
        this.mAutoTextChange = z;
    }

    public void setCanvasScale(float f) {
        this.mCanvasScale = f;
        invalidate();
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.mProgressText.setAlpha(z ? 1.0f : 0.5f);
        this.mProgressBar.setRoundBtnColor(z ? this.mProgressColor : getResources().getColor(R.color.progress_color_black));
    }

    public void setDownloadPatchProgress(float f, boolean z) {
        updateViewUI(f, z, getContext().getString(R.string.mc_downloading_patch_prefix));
    }

    public void setProgress(float f, boolean z) {
        updateViewUI(f, z, getContext().getString(R.string.mc_downloading_prefix));
    }

    public void setPromotionTextViewValue(CharSequence charSequence) {
        this.mPromotionStatusPriceText.setText(charSequence);
    }

    public void setPromotionTextViewVisibility() {
        this.mPromotionStatusPriceText.setVisibility(8);
    }

    public void setTextColor(int i) {
        this.mProgressText.setTextOriginColor(i);
    }

    public void setTextProgress(CharSequence charSequence) {
        this.mProgressText.setText(charSequence.toString());
    }

    public void setTextUnit(String str) {
        this.mTextUnit = str;
    }

    public void setUniformColor(int i) {
        if (isClickable()) {
            this.mProgressColor = i;
            this.mProgressBar.setRoundBtnColor(i);
        }
    }

    public void setUpdateIncrementalProgress(float f, boolean z) {
        updateViewUI(f, z, getContext().getString(R.string.mc_updating_prefix));
    }

    public void useSecondStyle(boolean z) {
        if (!z) {
            new MzPressAnimationHelper().addTargetView(this, false);
        }
        this.mProgressBar.useSecondStyle(z);
    }

    public InstallProgressBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public InstallProgressBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
