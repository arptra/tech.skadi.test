package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public class PagerIndicator extends View {
    private static final String TAG = "PagerIndicator";
    private int mCurPosition;
    private float mDistance;
    private float mEnlargeRadius;
    private int mFillColor;
    private int mGravity;
    private int mHighlightColor;
    private float mPageOffset;
    private int mPagerCount;
    private Paint mPaintFill;
    private Paint mPaintStroke;
    private float mRadius;
    private boolean mSnap;
    private int mSnapPage;
    private int mStrokeColor;

    public PagerIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getGradualColor(int i, int i2, float f, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int alpha = Color.alpha(i);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        int alpha2 = Color.alpha(i2);
        if (i3 < 0) {
            i6 = Math.round(((float) red2) - (((float) (red2 - red)) * f));
            i4 = Math.round(((float) green2) - (((float) (green2 - green)) * f));
            i7 = Math.round(((float) blue2) - (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha2) - (((float) (alpha2 - alpha)) * f));
        } else {
            i6 = Math.round(((float) red) + (((float) (red2 - red)) * f));
            i4 = Math.round(((float) green) + (((float) (green2 - green)) * f));
            i7 = Math.round(((float) blue) + (((float) (blue2 - blue)) * f));
            i5 = Math.round(((float) alpha) + (((float) (alpha2 - alpha)) * f));
        }
        return Color.argb(i5, i6, i4, i7);
    }

    private float getGradualRadius(float f, float f2, float f3, int i) {
        return i < 0 ? f2 - ((f2 - f) * f3) : f + ((f2 - f) * f3);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.mPagerCount;
        if (i != 0) {
            int width = getWidth();
            int i2 = this.mCurPosition;
            float f = this.mDistance;
            float f2 = this.mEnlargeRadius;
            int i3 = i - 1;
            float f3 = (((float) width) / 2.0f) - ((((float) i3) * f) / 2.0f);
            this.mPaintFill.setColor(this.mFillColor);
            for (int i4 = 0; i4 < i; i4++) {
                if (!(i2 == i4 || ((i2 == i3 && i4 == 0) || i4 == i2 + 1))) {
                    canvas.drawCircle((((float) i4) * f) + f3, f2, this.mRadius, this.mPaintFill);
                }
            }
            float f4 = (((float) (this.mSnap ? this.mSnapPage : i2)) * f) + f3;
            if (i2 != i3) {
                f3 = f4 + f;
            }
            int gradualColor = getGradualColor(this.mFillColor, this.mHighlightColor, this.mPageOffset, -1);
            float gradualRadius = getGradualRadius(this.mRadius, this.mEnlargeRadius, this.mPageOffset, -1);
            this.mPaintFill.setColor(gradualColor);
            canvas.drawCircle(f4, f2, gradualRadius, this.mPaintFill);
            int gradualColor2 = getGradualColor(this.mFillColor, this.mHighlightColor, this.mPageOffset, 1);
            float gradualRadius2 = getGradualRadius(this.mRadius, this.mEnlargeRadius, this.mPageOffset, 1);
            this.mPaintFill.setColor(gradualColor2);
            canvas.drawCircle(f3, f2, gradualRadius2, this.mPaintFill);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PagerIndicator.class.getName());
    }

    public void onMeasure(int i, int i2) {
        float f = ((float) this.mPagerCount) * this.mDistance;
        float f2 = this.mRadius;
        setMeasuredDimension(View.resolveSizeAndState(((int) (f + (f2 * 2.0f))) + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(((int) Math.max(f2 * 2.0f, this.mEnlargeRadius * 2.0f)) + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void setCirclePosOffset(float f, int i) {
        this.mCurPosition = i;
        this.mPageOffset = f;
        invalidate();
    }

    public void setCirclePosition(int i) {
        this.mCurPosition = i;
        this.mSnapPage = i;
        invalidate();
    }

    public void setPagerCount(int i) {
        if (this.mPagerCount != i) {
            this.mPagerCount = i;
            requestLayout();
        }
    }

    public void setSnap(boolean z) {
        this.mSnap = z;
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_PagerIndicator);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PagerIndicator, i, 0);
        Resources resources = getResources();
        float dimension = resources.getDimension(R.dimen.mc_pager_indicator_radius);
        float dimension2 = resources.getDimension(R.dimen.mc_pager_indicator_enlarge_radius);
        float dimension3 = resources.getDimension(R.dimen.mc_pager_indicator_distance);
        int color = resources.getColor(R.color.mc_pager_indicator_fill_color);
        int color2 = resources.getColor(R.color.mc_pager_indicator_highlight_color);
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.PagerIndicator_mcRadius, dimension);
        this.mEnlargeRadius = obtainStyledAttributes.getDimension(R.styleable.PagerIndicator_mcEnlargeRadius, dimension2);
        this.mDistance = obtainStyledAttributes.getDimension(R.styleable.PagerIndicator_mcDistance, dimension3);
        this.mFillColor = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_mcFillColor, color);
        this.mHighlightColor = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_mcHighlightColor, color2);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_mcStrokeColor, color2);
        this.mGravity = obtainStyledAttributes.getInteger(R.styleable.PagerIndicator_mcGravity, 17);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.mPaintFill = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaintFill.setColor(this.mFillColor);
        Paint paint2 = new Paint(1);
        this.mPaintStroke = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mPaintStroke.setColor(this.mStrokeColor);
    }
}
