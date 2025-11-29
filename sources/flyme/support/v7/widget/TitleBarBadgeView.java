package flyme.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.appcompat.R;

public class TitleBarBadgeView extends View {
    private static int DEFAULT_HEIGHT = 16;
    private static int DEFAULT_WIDTH = 16;
    private int mBadgeColor;
    private String mBadgeNumber;
    /* access modifiers changed from: private */
    public int mBadgeOffset;
    private int mBadgeRadius;
    private int mHeight;
    private boolean mIsShow = false;
    private float mNumberPointWidth;
    private Paint mPaint;
    private Paint mTextPaint;
    private int mWidth;

    public TitleBarBadgeView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private int getMeasure(int i, int i2, int i3) {
        return i2 != 1073741824 ? i3 : i;
    }

    private void init(Context context, AttributeSet attributeSet) {
        initAttributes(context, attributeSet);
        initPaint();
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = getTypedArray(context, attributeSet, R.styleable.TitleBarBadgeView);
        if (typedArray != null) {
            this.mBadgeColor = typedArray.getColor(R.styleable.TitleBarBadgeView_mcTBBadgeColor, getResources().getColor(R.color.mz_tab_view_dot_color));
            this.mBadgeRadius = (int) typedArray.getDimension(R.styleable.TitleBarBadgeView_mcTBBadgeRadius, getResources().getDimension(R.dimen.mz_title_bar_badge_radius));
        }
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mBadgeColor);
        this.mPaint.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.mTextPaint = paint2;
        paint2.setColor(-1);
        this.mTextPaint.setTextSize(ResourceUtils.dp2px(10.0f, getContext()));
        this.mNumberPointWidth = ResourceUtils.dp2px(16.0f, getContext());
    }

    private boolean isShowNumber() {
        return !TextUtils.isEmpty(this.mBadgeNumber);
    }

    public int getBadgeColor() {
        return this.mBadgeColor;
    }

    public int getBadgeRadius() {
        return this.mBadgeRadius;
    }

    public TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public boolean isIsShow() {
        return this.mIsShow;
    }

    public void onDraw(Canvas canvas) {
        if (this.mIsShow) {
            if (!isShowNumber()) {
                canvas.drawCircle((float) (this.mWidth / 2), (float) (getHeight() / 2), (float) this.mBadgeRadius, this.mPaint);
            } else {
                canvas.translate(ResourceUtils.dp2px(10.0f, getContext()), (-ResourceUtils.dp2px(17.0f, getContext())) + ((float) this.mBadgeOffset));
                canvas.drawRoundRect(0.0f, 0.0f, this.mNumberPointWidth, ResourceUtils.dp2px(16.0f, getContext()), ResourceUtils.dp2px(8.0f, getContext()), ResourceUtils.dp2px(8.0f, getContext()), this.mPaint);
                canvas.drawText(String.valueOf(this.mBadgeNumber), ResourceUtils.dp2px(5.0f, getContext()), ResourceUtils.dp2px(12.0f, getContext()), this.mTextPaint);
            }
        }
        super.onDraw(canvas);
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mWidth = getMeasure(size, mode, DEFAULT_WIDTH);
        int measure = getMeasure(size2, mode2, DEFAULT_HEIGHT);
        this.mHeight = measure;
        setMeasuredDimension(this.mWidth, measure);
    }

    public void setBadgeColor(int i) {
        this.mBadgeColor = i;
        invalidate();
    }

    public void setBadgeNumber(int i, final TextView textView) {
        if (i >= 0 && i <= 9) {
            this.mBadgeNumber = String.valueOf(i);
        } else if (i <= 9 || i > 99) {
            this.mBadgeNumber = "99+";
            this.mNumberPointWidth = ResourceUtils.dp2px(29.0f, getContext());
        } else {
            this.mBadgeNumber = String.valueOf(i);
            this.mNumberPointWidth = ResourceUtils.dp2px(23.0f, getContext());
        }
        textView.post(new Runnable() {
            public void run() {
                int unused = TitleBarBadgeView.this.mBadgeOffset = (int) (textView.getTextSize() - ResourceUtils.dp2px(13.0f, TitleBarBadgeView.this.getContext()));
                TitleBarBadgeView.this.invalidate();
            }
        });
    }

    public void setBadgeRadius(int i) {
        this.mBadgeRadius = i;
        invalidate();
    }

    public void setShow(boolean z) {
        this.mIsShow = z;
    }

    public TitleBarBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TitleBarBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
