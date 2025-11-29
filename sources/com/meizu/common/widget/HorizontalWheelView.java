package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Scroller;
import com.meizu.common.R;
import java.util.List;

public class HorizontalWheelView extends View {
    private static final String INSTANCE_STATE = "instanceState";
    private static final String STATE_SELECTED = "selected";
    private static final String TAG = "HorizontalWheelView";
    private boolean mAllowScroll;
    private boolean mClick;
    private int mClickNumber;
    private float mClickNumberOffset;
    private float mClickOffset;
    private float mDamping;
    private List<String> mData;
    private int mDataSize;
    private float mDensity;
    private int mDownX;
    private int mDrawCount;
    private boolean mIsAccessibilityEnable;
    private boolean mIsFling;
    private boolean mIsSetTotalMove;
    private int mLastX;
    private int mLineColor;
    private float mLineHeight;
    private float mLineMarginBottom;
    private Paint mLinePaint;
    private float mLineStartY;
    private float mLineStopY;
    private float mLineWidth;
    private int mLittleLineColor;
    private float mLittleLineWidth;
    private float mMaxTotalMove;
    private int mMiddle;
    private int mMinVelocity;
    /* access modifiers changed from: private */
    public OnValueChangeListener mOnValueChangeListener;
    private boolean mOnce;
    private boolean mPaintRound;
    private float mScaleDistance;
    private float mScaleTextSize;
    private Scroller mScroller;
    private boolean mScrolling;
    /* access modifiers changed from: private */
    public int mSelected;
    private int mSelectedColor;
    private int mShowNumber;
    private int mTextColor;
    private float mTextMargin;
    private Paint mTextPaint;
    private float mTotalMove;
    private boolean mTouching;
    private Paint mTrianglePaint;
    private Path mTrianglePath;
    private float mTriangleSideLength;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    public interface OnValueChangeListener {
        void onSelectedChange(float f);
    }

    public HorizontalWheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    private float computeDistance(float f) {
        float f2 = this.mScaleDistance;
        return f <= f2 / 2.0f ? -f : f2 - f;
    }

    private void computeTextSizeAndColor(int i, float f) {
        int i2 = this.mSelectedColor;
        int alpha = Color.alpha(i2);
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        float f2 = 1.0f - f;
        this.mLinePaint.setColor(Color.argb((int) ((((float) alpha) * f2) + (((float) Color.alpha(i)) * f)), (int) ((((float) red) * f2) + (((float) Color.red(i)) * f)), (int) ((((float) green) * f2) + (((float) Color.green(i)) * f)), (int) ((((float) blue) * f2) + (((float) Color.blue(i)) * f))));
    }

    private void countVelocityTracker() {
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float xVelocity = this.mVelocityTracker.getXVelocity();
        if (Math.abs(xVelocity) > ((float) this.mMinVelocity)) {
            this.mIsFling = true;
            this.mScroller.fling(0, 0, (int) ((1.0f - this.mDamping) * xVelocity), 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            return;
        }
        fixPos();
    }

    private void drawScaleLine(Canvas canvas) {
        int i;
        int i2;
        canvas.save();
        float f = this.mTotalMove;
        float f2 = this.mScaleDistance;
        float f3 = f % f2;
        int i3 = (int) (f / f2);
        if (i3 != this.mSelected) {
            this.mSelected = i3;
            notifySelectedChange();
            if (this.mClick && this.mSelected == this.mClickNumber) {
                sendAccessibilityEvent();
            }
        }
        float f4 = ((float) (this.mWidth / 2)) - f3;
        for (int i4 = 0; i4 < this.mDrawCount; i4++) {
            float f5 = (float) i4;
            float f6 = f4 + (this.mScaleDistance * f5);
            if (((float) getPaddingRight()) + f6 < ((float) this.mWidth) && (i2 = i3 + i4) <= this.mDataSize) {
                if (i2 % this.mShowNumber == 0) {
                    String text = getText(i2);
                    PointF textPoint = getTextPoint(text, this.mTextPaint, f6);
                    canvas.drawText(text, textPoint.x, textPoint.y, this.mTextPaint);
                    setLinePaint(this.mLineColor, this.mLineWidth, f6);
                    canvas.drawLine(f6, this.mLineStartY, f6, this.mLineStopY, this.mLinePaint);
                } else {
                    setLinePaint(this.mLittleLineColor, this.mLittleLineWidth, f6);
                    float f7 = this.mLineStartY;
                    float f8 = this.mLineHeight;
                    canvas.drawLine(f6, f7 + (f8 / 4.0f), f6, this.mLineStopY - (f8 / 4.0f), this.mLinePaint);
                }
            }
            float f9 = f4 - (f5 * this.mScaleDistance);
            if (f9 > ((float) getPaddingLeft()) && (i = i3 - i4) >= 0) {
                if (i % this.mShowNumber == 0) {
                    String text2 = getText(i);
                    PointF textPoint2 = getTextPoint(text2, this.mTextPaint, f9);
                    canvas.drawText(text2, textPoint2.x, textPoint2.y, this.mTextPaint);
                    setLinePaint(this.mLineColor, this.mLineWidth, f9);
                    canvas.drawLine(f9, this.mLineStartY, f9, this.mLineStopY, this.mLinePaint);
                } else {
                    setLinePaint(this.mLittleLineColor, this.mLittleLineWidth, f9);
                    this.mLinePaint.setStrokeWidth(this.mLittleLineWidth);
                    float f10 = this.mLineStartY;
                    float f11 = this.mLineHeight;
                    canvas.drawLine(f9, f10 + (f11 / 4.0f), f9, this.mLineStopY - (f11 / 4.0f), this.mLinePaint);
                }
            }
        }
        canvas.restore();
    }

    private void drawTriangle(Canvas canvas) {
        canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
    }

    private void fixPos() {
        this.mIsFling = false;
        this.mAllowScroll = true;
        this.mScroller.forceFinished(true);
        float round = (float) Math.round(this.mTotalMove);
        this.mTotalMove = round;
        this.mScroller.startScroll((int) this.mTotalMove, 0, (int) ((float) Math.round(computeDistance(round % this.mScaleDistance))), 0, 1000);
        postInvalidate();
    }

    private void getAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalWheelView, 0, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.HorizontalWheelView_mcScaleDistance) {
                this.mScaleDistance = (float) ((int) obtainStyledAttributes.getDimension(index, this.mScaleDistance));
            } else if (index == R.styleable.HorizontalWheelView_mcTextColor) {
                this.mTextColor = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.HorizontalWheelView_mcTextSize) {
                this.mScaleTextSize = (float) ((int) obtainStyledAttributes.getDimension(index, this.mScaleTextSize));
                this.mMaxTotalMove = ((float) this.mDataSize) * this.mScaleDistance;
            } else if (index == R.styleable.HorizontalWheelView_mcSelectedColor) {
                this.mSelectedColor = obtainStyledAttributes.getColor(index, -65536);
            } else if (index == R.styleable.HorizontalWheelView_mcLineColor) {
                this.mLineColor = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.HorizontalWheelView_mcLineWidth) {
                this.mLineWidth = obtainStyledAttributes.getDimension(index, this.mLineWidth);
            } else if (index == R.styleable.HorizontalWheelView_mcLineHeight) {
                this.mLineHeight = obtainStyledAttributes.getDimension(index, this.mLineHeight);
            } else if (index == R.styleable.HorizontalWheelView_mcLittleLineWidth) {
                this.mLittleLineWidth = obtainStyledAttributes.getDimension(index, this.mLittleLineWidth);
            } else if (index == R.styleable.HorizontalWheelView_mcLittleLineColor) {
                this.mLittleLineColor = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.HorizontalWheelView_mcTriangleSideLength) {
                this.mTriangleSideLength = obtainStyledAttributes.getDimension(index, this.mTriangleSideLength);
            } else if (index == R.styleable.HorizontalWheelView_mcShowNumber) {
                this.mShowNumber = obtainStyledAttributes.getInt(index, this.mShowNumber);
            } else if (index == R.styleable.HorizontalWheelView_mcTextMarginBottom) {
                this.mTextMargin = obtainStyledAttributes.getDimension(index, this.mTextMargin);
            } else if (index == R.styleable.HorizontalWheelView_mcLineMarginBottom) {
                this.mLineMarginBottom = obtainStyledAttributes.getDimension(index, this.mLineMarginBottom);
            } else if (index == R.styleable.HorizontalWheelView_mcDamping) {
                float f = obtainStyledAttributes.getFloat(index, this.mDamping);
                this.mDamping = f;
                if (f > 1.0f) {
                    this.mDamping = 1.0f;
                } else if (f < 0.0f) {
                    this.mDamping = 0.0f;
                }
            } else if (index == R.styleable.HorizontalWheelView_mcPaintRound) {
                this.mPaintRound = obtainStyledAttributes.getBoolean(index, false);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private float getMove(float f) {
        float f2 = this.mTotalMove;
        if (f2 + f < 0.0f) {
            return -f2;
        }
        float f3 = this.mMaxTotalMove;
        return f2 + f > f3 ? f3 - f2 : f;
    }

    private String getText(int i) {
        List<String> list = this.mData;
        return (list == null || list.size() <= 0 || i >= this.mData.size() || i < 0) ? String.valueOf(i) : this.mData.get(i);
    }

    private PointF getTextPoint(String str, Paint paint, float f) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        PointF pointF = new PointF();
        pointF.set(f - ((float) (rect.width() / 2)), (float) (getPaddingTop() + rect.height()));
        return pointF;
    }

    private void init() {
        this.mScroller = new Scroller(getContext());
        float f = (float) ((int) getContext().getResources().getDisplayMetrics().density);
        this.mDensity = f;
        this.mScaleTextSize *= f;
        this.mScaleDistance *= f;
        this.mMinVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        float f2 = this.mLineHeight;
        float f3 = this.mDensity;
        this.mLineHeight = f2 * f3;
        this.mLittleLineWidth *= f3;
        this.mLineWidth *= f3;
        this.mTextMargin *= f3;
        this.mLineMarginBottom *= f3;
        this.mMaxTotalMove = ((float) this.mDataSize) * this.mScaleDistance;
        this.mClickOffset = 3.0f * f3;
        this.mClickNumberOffset = f3 * 15.0f;
    }

    private void initTriangle() {
        this.mMiddle = this.mWidth / 2;
        float f = this.mLineStopY + this.mLineMarginBottom;
        float sin = ((float) ((int) (Math.sin(1.0471975511965976d) * ((double) this.mTriangleSideLength)))) + f;
        this.mTrianglePath.moveTo((float) this.mMiddle, f);
        this.mTrianglePath.lineTo(((float) this.mMiddle) - (this.mTriangleSideLength / 2.0f), sin);
        this.mTrianglePath.lineTo(((float) this.mMiddle) + (this.mTriangleSideLength / 2.0f), sin);
        this.mTrianglePath.close();
    }

    private void notifySelectedChange() {
        if (this.mOnValueChangeListener != null) {
            post(new Runnable() {
                public void run() {
                    HorizontalWheelView.this.mOnValueChangeListener.onSelectedChange((float) HorizontalWheelView.this.mSelected);
                }
            });
        }
    }

    private void sendAccessibilityEvent() {
        if (this.mIsAccessibilityEnable) {
            setContentDescription(String.valueOf(this.mSelected));
            sendAccessibilityEvent(4);
        }
    }

    private void setLinePaint(int i, float f, float f2) {
        this.mLinePaint.setStrokeWidth(f);
        if (Math.abs(f2 - ((float) (this.mWidth / 2))) < this.mScaleDistance) {
            computeTextSizeAndColor(i, Math.abs(f2 - ((float) (this.mWidth / 2))) / this.mScaleDistance);
        } else {
            this.mLinePaint.setColor(i);
        }
    }

    private void setSelectNotDraw(int i) {
        int i2 = this.mDataSize;
        if (i > i2) {
            this.mSelected = i2;
        } else if (i < 0) {
            this.mSelected = 0;
        } else {
            this.mSelected = i;
        }
        this.mTotalMove = ((float) this.mSelected) * this.mScaleDistance;
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            int currX = this.mScroller.getCurrX();
            if (this.mIsFling) {
                float f = (float) (this.mLastX - currX);
                this.mLastX = currX;
                if ((f < 0.0f || this.mTotalMove < this.mMaxTotalMove) && (f > 0.0f || this.mTotalMove > 0.0f)) {
                    this.mTotalMove += getMove(f);
                } else {
                    this.mScroller.forceFinished(true);
                    sendAccessibilityEvent();
                    this.mIsFling = false;
                    return;
                }
            } else {
                this.mTotalMove = (float) currX;
            }
            postInvalidate();
        } else if (this.mIsFling) {
            fixPos();
        } else {
            this.mClickNumber = -1;
            this.mScrolling = false;
            if (!this.mTouching && !this.mClick && !this.mIsSetTotalMove) {
                sendAccessibilityEvent();
            }
            if (this.mIsSetTotalMove) {
                this.mIsSetTotalMove = false;
            }
        }
    }

    public float getScaleDistance() {
        return this.mScaleDistance;
    }

    public float getSelected() {
        return (float) this.mSelected;
    }

    public float getTotalMove() {
        return this.mTotalMove;
    }

    public boolean isAllowScroll() {
        return this.mAllowScroll;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawScaleLine(canvas);
        drawTriangle(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HorizontalWheelView.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        this.mWidth = width;
        if (width != 0 && this.mOnce) {
            this.mTotalMove = ((float) this.mSelected) * this.mScaleDistance;
            initTriangle();
            this.mDrawCount = (((int) (((float) this.mWidth) / this.mScaleDistance)) / 2) + 1;
            this.mOnce = false;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setSelect(bundle.getInt(STATE_SELECTED));
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        int i = this.mClickNumber;
        if (i != -1) {
            bundle.putInt(STATE_SELECTED, i);
        } else {
            bundle.putInt(STATE_SELECTED, this.mSelected);
        }
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r0 != 3) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.mAllowScroll
            if (r0 == 0) goto L_0x00df
            boolean r0 = r6.mScrolling
            if (r0 == 0) goto L_0x000a
            goto L_0x00df
        L_0x000a:
            int r0 = r7.getAction()
            float r1 = r7.getX()
            int r1 = (int) r1
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            if (r2 != 0) goto L_0x001d
            android.view.VelocityTracker r2 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r2
        L_0x001d:
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            r2.addMovement(r7)
            r7 = 0
            r6.mIsFling = r7
            r2 = 1
            if (r0 == 0) goto L_0x00cf
            if (r0 == r2) goto L_0x0068
            r3 = 2
            if (r0 == r3) goto L_0x0032
            r3 = 3
            if (r0 == r3) goto L_0x0068
            goto L_0x00dc
        L_0x0032:
            android.view.ViewParent r7 = r6.getParent()
            if (r7 == 0) goto L_0x003f
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r2)
        L_0x003f:
            int r7 = r6.mLastX
            int r7 = r7 - r1
            float r7 = (float) r7
            r0 = 0
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 < 0) goto L_0x0050
            float r3 = r6.mTotalMove
            float r4 = r6.mMaxTotalMove
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x005a
        L_0x0050:
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x005b
            float r3 = r6.mTotalMove
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x005b
        L_0x005a:
            return r2
        L_0x005b:
            float r7 = r6.getMove(r7)
            float r0 = r6.mTotalMove
            float r0 = r0 + r7
            r6.mTotalMove = r0
            r6.invalidate()
            goto L_0x00dc
        L_0x0068:
            r6.mTouching = r7
            r6.mClick = r7
            int r0 = r6.mDownX
            int r3 = r6.mLastX
            int r0 = r0 - r3
            int r0 = java.lang.Math.abs(r0)
            r3 = 5
            if (r0 >= r3) goto L_0x00c2
            float r0 = r6.mTotalMove
            int r3 = r6.mDownX
            int r4 = r6.mMiddle
            int r3 = r3 - r4
            float r3 = (float) r3
            float r0 = r0 + r3
            float r3 = r6.mClickOffset
            float r4 = -r3
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x00c2
            float r4 = r6.mMaxTotalMove
            float r4 = r4 + r3
            int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x00c2
            float r3 = r6.mScaleDistance
            int r4 = r6.mShowNumber
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r0 / r3
            int r3 = java.lang.Math.round(r3)
            float r4 = (float) r3
            float r5 = r6.mScaleDistance
            float r4 = r4 * r5
            int r5 = r6.mShowNumber
            float r5 = (float) r5
            float r4 = r4 * r5
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r6.mClickNumberOffset
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x00c2
            int r0 = r6.mSelected
            int r4 = r6.mShowNumber
            int r5 = r3 * r4
            if (r0 == r5) goto L_0x00c2
            r6.mClick = r2
            int r3 = r3 * r4
            r6.mClickNumber = r3
            r0 = 500(0x1f4, float:7.0E-43)
            r6.smoothScroll(r3, r0)
            r6.mScrolling = r2
        L_0x00c2:
            boolean r0 = r6.mClick
            if (r0 != 0) goto L_0x00dc
            r6.mLastX = r7
            r6.invalidate()
            r6.countVelocityTracker()
            return r2
        L_0x00cf:
            android.widget.Scroller r0 = r6.mScroller
            r0.forceFinished(r2)
            r6.mLastX = r1
            r6.mDownX = r1
            r6.mTouching = r2
            r6.mClick = r7
        L_0x00dc:
            r6.mLastX = r1
            return r2
        L_0x00df:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.HorizontalWheelView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void scrollBy(float f) {
        this.mTotalMove += getMove(f);
        invalidate();
    }

    public void setAllowScroll(boolean z) {
        this.mAllowScroll = z;
    }

    public void setData(List<String> list, int i) {
        this.mScroller.forceFinished(true);
        this.mData = list;
        int size = list.size();
        this.mDataSize = size;
        this.mMaxTotalMove = ((float) size) * this.mScaleDistance;
        setSelectNotDraw(i);
        invalidate();
    }

    public void setOnValueChangeListener(OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    public void setScaleDistance(float f) {
        this.mScaleDistance = f;
        invalidate();
    }

    public void setSelect(int i) {
        this.mScroller.forceFinished(true);
        setSelectNotDraw(i);
        invalidate();
    }

    public void setSelectedColor(int i) {
        this.mSelectedColor = i;
        invalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTotalMove(float f) {
        this.mScroller.forceFinished(true);
        this.mIsSetTotalMove = true;
        this.mClick = false;
        if (f >= 0.0f || this.mTotalMove == 0.0f) {
            float f2 = this.mMaxTotalMove;
            if (f > f2 && this.mTotalMove != f2) {
                this.mTotalMove = f2;
            } else if (f != this.mTotalMove) {
                this.mTotalMove = f;
            } else {
                return;
            }
        } else {
            this.mTotalMove = 0.0f;
        }
        invalidate();
    }

    public void smoothScroll(int i) {
        smoothScroll(i, 1000);
    }

    public HorizontalWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void smoothScroll(int i, int i2) {
        this.mIsFling = false;
        this.mScroller.forceFinished(true);
        float f = ((float) i) * this.mScaleDistance;
        float f2 = this.mTotalMove;
        this.mScroller.startScroll((int) f2, 0, (int) (f - f2), 0, i2);
        invalidate();
    }

    public HorizontalWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLineHeight = 18.0f;
        this.mSelectedColor = -65536;
        this.mTextColor = -16777216;
        this.mScaleTextSize = 18.0f;
        this.mDataSize = 100;
        this.mOnce = true;
        this.mLineWidth = 2.0f;
        this.mLittleLineWidth = 1.0f;
        this.mSelected = 0;
        this.mScaleDistance = 20.0f;
        this.mTextMargin = 10.0f;
        this.mTriangleSideLength = 10.0f;
        this.mLineColor = -16777216;
        this.mLittleLineColor = -16777216;
        this.mShowNumber = 5;
        this.mTotalMove = 0.0f;
        this.mLineMarginBottom = 5.0f;
        this.mDamping = 0.0f;
        this.mAllowScroll = true;
        this.mClickNumber = -1;
        this.mIsAccessibilityEnable = false;
        this.mTouching = false;
        this.mIsSetTotalMove = false;
        init();
        getAttrs(context, attributeSet);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTextSize(this.mScaleTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds("0", 0, 1, rect);
        float paddingTop = ((float) getPaddingTop()) + this.mTextMargin + ((float) rect.height());
        this.mLineStartY = paddingTop;
        this.mLineStopY = paddingTop + this.mLineHeight;
        Paint paint = new Paint(1);
        this.mLinePaint = paint;
        paint.setColor(this.mLineColor);
        if (this.mPaintRound) {
            this.mLinePaint.setStrokeCap(Paint.Cap.ROUND);
        }
        this.mTriangleSideLength *= this.mDensity;
        this.mTrianglePath = new Path();
        Paint paint2 = new Paint(1);
        this.mTrianglePaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mTrianglePaint.setColor(this.mSelectedColor);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.mIsAccessibilityEnable = accessibilityManager.isEnabled();
        }
        if (this.mIsAccessibilityEnable) {
            setFocusable(true);
        }
        sendAccessibilityEvent();
    }
}
