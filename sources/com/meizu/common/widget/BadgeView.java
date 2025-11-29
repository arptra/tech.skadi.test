package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import com.meizu.common.R;

public class BadgeView extends TextView {
    private static final int MAXCOUNT = 999;
    private final int ONENUMWIDTH = 28;
    private final float SPACE = 4.5f;
    private final int TWONUMWIDTH = 50;
    private int mBadgeColor;
    private FrameLayout mBadgeContainer;
    private Paint mBgPaint;
    private Stage mCurrentStage;
    private Drawable mDrawable;
    private int mHideNumRadius;
    private boolean mIsHide = true;
    private ViewGroup mParentContainer;
    private int mParentHeight;
    private int mParentWidth;
    private int mRadius;
    private int mTextColor;
    private int mTextSize;
    private int mTwoNumWidth;
    private int mWidth;

    public enum Stage {
        SHOWNUM,
        HIDENUM
    }

    public BadgeView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private float dp2px(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private int getPxSize(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    private int getTextWidth(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mCurrentStage = Stage.SHOWNUM;
        this.mDrawable = getResources().getDrawable(R.drawable.mc_badge_view);
        initAttributes(context, attributeSet);
        initPaint();
        setGravity(17);
        setTextColor(this.mTextColor);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize((float) this.mTextSize);
        setHide(true);
        setBadgeNum(0);
        initParentLayout();
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = getTypedArray(context, attributeSet, R.styleable.BadgeView);
        if (typedArray != null) {
            this.mTextColor = typedArray.getColor(R.styleable.BadgeView_mcBadgeTextColor, -1);
            this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.BadgeView_mcBadgeTextSize, 10);
            this.mRadius = (int) typedArray.getDimension(R.styleable.BadgeView_mcBadgeRadius, getResources().getDimension(R.dimen.mc_badge_view_radius_show_count));
            this.mHideNumRadius = (int) typedArray.getDimension(R.styleable.BadgeView_mcBadgeRadius, getResources().getDimension(R.dimen.mc_badge_view_radius));
            this.mBadgeColor = typedArray.getResourceId(R.styleable.BadgeView_mcBadgeColor, -65536);
            typedArray.recycle();
        }
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mBgPaint = paint;
        paint.setColor(this.mBadgeColor);
        this.mBgPaint.setAntiAlias(true);
        this.mBgPaint.setTypeface(Typeface.create("SFPRO-medium", 0));
    }

    private void initParentLayout() {
        this.mParentWidth = (int) getResources().getDimension(R.dimen.mc_badge_view_layout_params_width);
        this.mParentHeight = (int) getResources().getDimension(R.dimen.mc_badge_view_layout_params_height);
        this.mTwoNumWidth = (int) getResources().getDimension(R.dimen.mc_badge_view_two_num_width);
        if (!(getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            setLayoutParams(new FrameLayout.LayoutParams(this.mParentWidth, this.mParentHeight, 53));
        }
    }

    public int getBadgeGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getBadgeMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getBadgeNum() {
        if (getText() == null) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(getText().toString()));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public Stage getState() {
        return this.mCurrentStage;
    }

    public TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public boolean isHide() {
        return this.mIsHide;
    }

    public void onDraw(Canvas canvas) {
        if (this.mDrawable != null) {
            if (this.mCurrentStage == Stage.SHOWNUM) {
                this.mWidth = getTextWidth(getPaint(), (String) getText());
                int min = Math.min(getWidth(), Math.max(this.mDrawable.getIntrinsicWidth(), this.mWidth + ((int) (getResources().getDimension(R.dimen.mc_badge_view_space) * 2.0f))));
                this.mDrawable.setBounds((getWidth() - min) / 2, (getHeight() / 2) - (this.mDrawable.getIntrinsicHeight() / 2), getWidth() - ((getWidth() - min) / 2), (getHeight() / 2) + (this.mDrawable.getIntrinsicHeight() / 2));
                this.mDrawable.draw(canvas);
            } else {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.mHideNumRadius, this.mBgPaint);
            }
        }
        super.onDraw(canvas);
    }

    public void setBackground(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void setBackgroundColor(int i) {
        this.mBgPaint.setColor(i);
    }

    public void setBackgroundResource(int i) {
        this.mDrawable = getResources().getDrawable(i);
    }

    public void setBadgeGravity(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
    }

    public void setBadgeMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = (int) dp2px((float) i);
        layoutParams.topMargin = (int) dp2px((float) i2);
        layoutParams.rightMargin = (int) dp2px((float) i3);
        layoutParams.bottomMargin = (int) dp2px((float) i4);
        setLayoutParams(layoutParams);
    }

    public void setBadgeNum(int i) {
        if (this.mCurrentStage == Stage.SHOWNUM) {
            if (i >= 999) {
                i = 999;
            }
            setText(String.valueOf(i));
            return;
        }
        setText((CharSequence) null);
    }

    public void setBadgeRadius(int i) {
        int dp2px = (int) dp2px((float) i);
        Stage stage = this.mCurrentStage;
        if (stage == Stage.SHOWNUM) {
            this.mRadius = dp2px;
        } else if (stage == Stage.HIDENUM) {
            this.mHideNumRadius = dp2px;
        }
    }

    public void setHide(boolean z) {
        this.mIsHide = z;
        if (this.mCurrentStage == Stage.SHOWNUM) {
            setText(getText());
        } else {
            setText((CharSequence) null);
        }
    }

    public void setState(Stage stage) {
        this.mCurrentStage = stage;
    }

    public void setTargetView(View view) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view != null) {
            if (view.getParent() instanceof FrameLayout) {
                ((FrameLayout) view.getParent()).addView(this);
            } else if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                this.mParentContainer = viewGroup;
                int indexOfChild = viewGroup.indexOfChild(view);
                this.mParentContainer.removeView(view);
                this.mBadgeContainer = new FrameLayout(getContext());
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                this.mBadgeContainer.setLayoutParams(layoutParams);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.mParentContainer.addView(this.mBadgeContainer, indexOfChild, layoutParams);
                this.mBadgeContainer.addView(view);
                this.mBadgeContainer.addView(this);
            } else if (view.getParent() == null) {
                Log.e(getClass().getSimpleName(), "ParentView cannot be empty");
            }
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!isHide() || (charSequence != null && !charSequence.toString().equalsIgnoreCase("0"))) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        super.setText(charSequence, bufferType);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public void setTargetView(TabWidget tabWidget, int i) {
        setTargetView(tabWidget.getChildTabViewAt(i));
    }
}
