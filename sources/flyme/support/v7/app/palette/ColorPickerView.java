package flyme.support.v7.app.palette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.honey.account.ua.b;
import com.honey.account.ua.c;
import com.honey.account.ua.d;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.app.palette.FlymePalettePopupActivity;
import flyme.support.v7.appcompat.R;

public class ColorPickerView extends View implements ColorChangeListener {
    private int centerX;
    private int centerY;
    boolean isTouchDownInGradient = false;
    private FlymePalettePopupActivity.OnColorPickListener mColorPickListener;
    private Paint mDisplayAreaPaint;
    private int mDisplayAreaRadius;
    private int mDisplayColor = -1;
    private Paint mGradientCirclePaint;
    private int mGradientCircleRadius;
    private int[] mGradientColors;
    private float mLight;
    private float mSaturation;
    private Paint mStrokePaint;
    private Paint mTouchPointPaint;
    private int mTouchPointRadius;
    private float mTouchPointX;
    private float mTouchPointY;

    public ColorPickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private int adjustLight(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = this.mSaturation;
        fArr[2] = f;
        return Color.HSVToColor(fArr);
    }

    private int adjustSaturation(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = f;
        fArr[2] = this.mLight;
        return Color.HSVToColor(fArr);
    }

    private PointF calculateTouchPointInGradientCircle(double d) {
        float abs = Math.abs(this.mTouchPointY - ((float) this.centerY));
        double d2 = ((double) this.mGradientCircleRadius) - d;
        double abs2 = (((double) Math.abs(this.mTouchPointX - ((float) this.centerX))) / d) * d2;
        double d3 = d2 * (((double) abs) / d);
        float f = this.mTouchPointY;
        int i = this.centerY;
        int i2 = 1;
        int i3 = f < ((float) i) ? -1 : f > ((float) i) ? 1 : 0;
        float f2 = this.mTouchPointX;
        int i4 = this.centerX;
        if (f2 <= ((float) i4)) {
            i2 = f2 < ((float) i4) ? -1 : 0;
        }
        this.mTouchPointX = (float) (((double) f2) + (abs2 * ((double) i2)));
        this.mTouchPointY = (float) (((double) f) + (d3 * ((double) i3)));
        return new PointF(this.mTouchPointX, this.mTouchPointY);
    }

    private void drawCenterDisplayArea(Canvas canvas) {
        canvas.drawCircle((float) this.centerX, (float) this.centerY, (float) this.mDisplayAreaRadius, this.mDisplayAreaPaint);
    }

    private void drawGradientCircle(Canvas canvas) {
        canvas.drawCircle((float) this.centerX, (float) this.centerY, (float) this.mGradientCircleRadius, this.mGradientCirclePaint);
    }

    private void drawTouchPoint(Canvas canvas) {
        canvas.drawCircle(this.mTouchPointX, this.mTouchPointY, (float) this.mTouchPointRadius, this.mTouchPointPaint);
    }

    private float getAngleForColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[0];
    }

    private int getColorForAngle(float f) {
        return Color.HSVToColor(new float[]{((f % 360.0f) + 360.0f) % 360.0f, 1.0f, 1.0f});
    }

    private int getFullSVColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = 1.0f;
        fArr[2] = 1.0f;
        return Color.HSVToColor(fArr);
    }

    private float getLightForColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[2];
    }

    private float getSaturationForColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[1];
    }

    @SuppressLint({"NewApi"})
    private void init() {
        Paint paint = new Paint(1);
        this.mGradientCirclePaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.mGradientCirclePaint.setStrokeWidth((float) ((int) ResourceUtils.dp2px(40.0f, getContext())));
        Paint paint2 = new Paint(1);
        this.mTouchPointPaint = paint2;
        paint2.setStyle(style);
        this.mTouchPointPaint.setStrokeWidth((float) ((int) ResourceUtils.dp2px(4.0f, getContext())));
        this.mTouchPointPaint.setColor(-1);
        this.mTouchPointRadius = (int) ResourceUtils.dp2px(14.0f, getContext());
        Paint paint3 = new Paint(1);
        this.mStrokePaint = paint3;
        paint3.setStyle(style);
        this.mStrokePaint.setStrokeWidth(ResourceUtils.dp2px(1.0f, getContext()));
        this.mStrokePaint.setColor(ContextCompat.getColor(getContext(), R.color.fd_sys_color_outline_variant_default));
        this.mGradientColors = new int[361];
        for (int i = 0; i < 361; i++) {
            this.mGradientColors[i] = Color.HSVToColor(new float[]{(float) i, 1.0f, 1.0f});
        }
        Paint paint4 = new Paint(1);
        this.mDisplayAreaPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.mDisplayAreaRadius = (int) ResourceUtils.dp2px(45.0f, getContext());
        ColorManager.getInstance().addListener(this);
        this.mSaturation = 1.0f;
        this.mLight = 1.0f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onSizeChanged$0() {
        ColorManager.getInstance().setCurrentColor(this.mDisplayColor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePointByColor$2(int i) {
        float angleForColor = getAngleForColor(i);
        if (angleForColor >= 0.0f) {
            double d = (double) angleForColor;
            this.mTouchPointX = (float) (((double) this.centerX) + (((double) this.mGradientCircleRadius) * Math.cos(Math.toRadians(d))));
            this.mTouchPointY = (float) (((double) this.centerY) + (((double) this.mGradientCircleRadius) * Math.sin(Math.toRadians(d))));
        }
        this.mDisplayColor = getFullSVColor(i);
        this.mDisplayAreaPaint.setColor(i);
        this.mSaturation = getSaturationForColor(i);
        this.mLight = getLightForColor(i);
        invalidate();
        post(new c(i));
    }

    public int getColorForPoint(float f, float f2) {
        float degrees = (float) Math.toDegrees(Math.atan2((double) (f2 - ((float) (getHeight() / 2))), (double) (f - ((float) (getWidth() / 2)))));
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        return Color.HSVToColor(new float[]{degrees, 1.0f, 1.0f});
    }

    public void onColorChanged(int i) {
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGradientCircle(canvas);
        drawTouchPoint(canvas);
        drawCenterDisplayArea(canvas);
        canvas.drawCircle((float) this.centerX, (float) this.centerY, (float) this.mDisplayAreaRadius, this.mStrokePaint);
        this.mColorPickListener.onPaletteChange(this.mDisplayAreaPaint.getColor());
    }

    public void onLightChange(float f) {
        this.mLight = f;
        this.mDisplayAreaPaint.setColor(adjustLight(this.mDisplayColor, f));
        invalidate();
    }

    public void onSaturationChange(float f) {
        this.mSaturation = f;
        this.mDisplayAreaPaint.setColor(adjustSaturation(this.mDisplayColor, f));
        invalidate();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i / 2;
        this.centerX = i5;
        int i6 = i2 / 2;
        this.centerY = i6;
        this.mGradientCircleRadius = (int) (((float) Math.min(i5, i6)) - (this.mGradientCirclePaint.getStrokeWidth() / 2.0f));
        this.mGradientCirclePaint.setShader(new SweepGradient((float) this.centerX, (float) this.centerY, this.mGradientColors, (float[]) null));
        if (this.mDisplayColor == -1) {
            int colorForAngle = getColorForAngle(90.0f);
            this.mDisplayColor = colorForAngle;
            this.mDisplayAreaPaint.setColor(colorForAngle);
            this.mTouchPointX = (float) (((double) this.centerX) + (((double) this.mGradientCircleRadius) * Math.cos(Math.toRadians(90.0d))));
            this.mTouchPointY = (float) (((double) this.centerY) + (((double) this.mGradientCircleRadius) * Math.sin(Math.toRadians(90.0d))));
            post(new b(this));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchPointX = motionEvent.getX();
            this.mTouchPointY = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            double sqrt = Math.sqrt(Math.pow((double) Math.abs(this.mTouchPointX - ((float) this.centerX)), 2.0d) + Math.pow((double) Math.abs(this.mTouchPointY - ((float) this.centerY)), 2.0d));
            boolean z = sqrt >= ((double) (((float) this.centerX) - this.mGradientCirclePaint.getStrokeWidth())) && sqrt <= ((double) this.centerX);
            this.isTouchDownInGradient = z;
            if (z) {
                calculateTouchPointInGradientCircle(sqrt);
                invalidate();
            }
        } else if (action == 2) {
            this.mTouchPointX = motionEvent.getX();
            this.mTouchPointY = motionEvent.getY();
            if (this.isTouchDownInGradient) {
                PointF calculateTouchPointInGradientCircle = calculateTouchPointInGradientCircle(Math.sqrt(Math.pow((double) Math.abs(this.mTouchPointX - ((float) this.centerX)), 2.0d) + Math.pow((double) Math.abs(this.mTouchPointY - ((float) this.centerY)), 2.0d)));
                int colorForPoint = getColorForPoint(calculateTouchPointInGradientCircle.x, calculateTouchPointInGradientCircle.y);
                this.mDisplayColor = colorForPoint;
                int adjustLight = adjustLight(adjustSaturation(colorForPoint, this.mSaturation), this.mLight);
                this.mDisplayAreaPaint.setColor(adjustLight);
                ColorManager.getInstance().setCurrentColor(adjustLight);
                invalidate();
            }
        }
        return true;
    }

    public void setColorPickListener(FlymePalettePopupActivity.OnColorPickListener onColorPickListener) {
        this.mColorPickListener = onColorPickListener;
    }

    public void updatePointByColor(int i) {
        post(new d(this, i));
    }
}
