package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;

public class NewMessagePainter {
    private static final int MAX_COUNT = 999;
    public static final int SHOW_DOT = 0;
    public static final int SHOW_NUMBER = 1;
    private Paint mBgPaint;
    private int mBorderColor;
    private int mBorderWidth;
    private Rect mBounds;
    private Context mContext;
    private int mCurrentStage = 0;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private int mHeight;
    private int mHideNumRadius;
    private int mNewMessageColor;
    private RectF mRectF;
    private boolean mShowBorder = false;
    private int mSpace;
    private int mTextColor;
    private String mTextContent;
    private TextPaint mTextPaint;
    private float mTextSize;
    private int mViewMaxHeight;
    private int mViewMaxWidth;
    private int mWidth;

    public NewMessagePainter(Context context) {
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        this.mViewMaxWidth = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_width);
        this.mViewMaxHeight = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_height);
        initAttributes(context);
        intPaint();
        initTextPaint();
        initBorder();
    }

    private void initAttributes(Context context) {
        Resources resources = context.getResources();
        this.mTextColor = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.mTextSize = 10.0f;
        this.mHideNumRadius = resources.getDimensionPixelSize(R.dimen.fd_sys_radius_corner_smooth_extra_mini);
        int identifierByAttrId = ResourceUtils.getIdentifierByAttrId(R.attr.colorError, context);
        if (identifierByAttrId == 0) {
            identifierByAttrId = R.color.fd_sys_color_error_default;
        }
        this.mNewMessageColor = context.getResources().getColor(identifierByAttrId);
        this.mBorderColor = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.mBorderWidth = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_border_width);
        this.mSpace = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_space_large);
    }

    private void initBorder() {
        this.mRectF = new RectF();
    }

    private void initTextPaint() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.mBounds = new Rect();
    }

    private void intPaint() {
        Paint paint = new Paint();
        this.mBgPaint = paint;
        paint.setAntiAlias(true);
        this.mBgPaint.setColor(this.mNewMessageColor);
        this.mBgPaint.setStyle(Paint.Style.FILL);
    }

    private void setRectF(float f, float f2, float f3, float f4) {
        RectF rectF = this.mRectF;
        rectF.left = f;
        rectF.top = f2;
        rectF.right = f3;
        rectF.bottom = f4;
    }

    public void draw(Canvas canvas) {
        if (this.mShowBorder && this.mBorderWidth > 0) {
            this.mBgPaint.setColor(this.mBorderColor);
            if (this.mCurrentStage == 1) {
                int i = this.mHeight;
                float f = (float) i;
                float f2 = (float) (i >> 1);
                setRectF(0.0f, 0.0f, (float) this.mWidth, f);
                canvas.drawRoundRect(this.mRectF, f2, f2, this.mBgPaint);
            } else {
                canvas.drawCircle((float) (this.mWidth / 2), (float) (this.mHeight / 2), (float) (this.mHideNumRadius + this.mBorderWidth), this.mBgPaint);
            }
        }
        this.mBgPaint.setColor(this.mNewMessageColor);
        if (this.mCurrentStage == 1) {
            int i2 = this.mBorderWidth;
            setRectF((float) i2, (float) i2, (float) (this.mWidth - i2), (float) (this.mHeight - i2));
            float f3 = (float) (this.mDrawableHeight >> 1);
            canvas.drawRoundRect(this.mRectF, f3, f3, this.mBgPaint);
            String str = this.mTextContent;
            if (str == null) {
                return;
            }
            if (this.mShowBorder) {
                canvas.drawText(str, (float) (this.mWidth / 2), (float) (((this.mHeight - this.mBorderWidth) - ((this.mDrawableHeight - this.mBounds.height()) / 2)) - 1), this.mTextPaint);
            } else {
                canvas.drawText(str, (float) (this.mWidth / 2), (float) ((this.mHeight - ((this.mDrawableHeight - this.mBounds.height()) / 2)) - 1), this.mTextPaint);
            }
        } else {
            canvas.drawCircle((float) (this.mWidth / 2), (float) (this.mHeight / 2), (float) this.mHideNumRadius, this.mBgPaint);
        }
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Integer getNewMessageNum() {
        String str = this.mTextContent;
        if (str == null) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public int getState() {
        return this.mCurrentStage;
    }

    public String getTextContent() {
        return this.mTextContent;
    }

    public int getViewMaxHeight() {
        return this.mViewMaxHeight;
    }

    public int getViewMaxWidth() {
        return this.mViewMaxWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void measure() {
        int i;
        int i2;
        if (this.mCurrentStage != 1 || this.mTextContent == null) {
            i2 = (this.mShowBorder ? this.mHideNumRadius + this.mBorderWidth : this.mHideNumRadius) * 2;
            i = i2;
        } else {
            this.mTextPaint.setTextSize(ResourceUtils.sp2px(this.mTextSize, this.mContext));
            this.mTextPaint.setColor(this.mTextColor);
            TextPaint textPaint = this.mTextPaint;
            String str = this.mTextContent;
            textPaint.getTextBounds(str, 0, str.length(), this.mBounds);
            this.mDrawableWidth = this.mBounds.width() + (this.mSpace * 2);
            i2 = (int) ResourceUtils.dp2px(18.0f, this.mContext);
            this.mDrawableHeight = i2;
            if (this.mDrawableWidth < i2) {
                this.mDrawableWidth = i2;
            }
            if (this.mShowBorder) {
                int i3 = this.mDrawableWidth;
                int i4 = this.mBorderWidth;
                i = i3 + (i4 * 2);
                i2 += i4 * 2;
            } else {
                i = this.mDrawableWidth;
            }
        }
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void setAlpha(int i) {
        this.mBgPaint.setAlpha(i);
        this.mTextPaint.setAlpha(i);
    }

    public void setBackgroundColor(int i) {
        this.mBgPaint.setColor(i);
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
    }

    public void setCurrentStage(int i) {
        this.mCurrentStage = i;
    }

    public void setNewMessageNum(int i) {
        this.mCurrentStage = 1;
        if (i >= 999) {
            i = 999;
        } else if (i <= 0) {
            i = 0;
        }
        setText(String.valueOf(i));
    }

    public void setNewMessageSpace(int i) {
        this.mSpace = i;
    }

    public void setShowBorder(boolean z) {
        this.mShowBorder = z;
    }

    public void setText(String str) {
        this.mTextContent = str;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
    }

    public void setViewMaxSize(int i, int i2) {
        this.mViewMaxWidth = i;
        this.mViewMaxHeight = i2;
    }
}
