package flyme.support.v7.app.palette;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.appcompat.R;

public class ColorSaturationAdjustView extends View implements ColorChangeListener {
    private int centerY;
    private LinearGradient gradient;
    private int[] gradientColors;
    private int mGradientColorEndX;
    private int mGradientColorStartX;
    private int mGradientColorWidth;
    private Paint mGradientPaint;
    private Drawable mLeftSpaceDrawable;
    private int mPadding;
    private Drawable mRightSpaceDrawable;
    private Paint mStrokePaint;
    private Paint mTouchPointPaint;
    private int mTouchPointRadius;
    private float mTouchPointX;

    public ColorSaturationAdjustView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void adjustTouchX(float f) {
        this.mTouchPointX = f;
        int i = this.mGradientColorStartX;
        if (f <= ((float) i)) {
            this.mTouchPointX = (float) i;
        }
        float f2 = this.mTouchPointX;
        int i2 = this.mGradientColorEndX;
        if (f2 >= ((float) i2)) {
            this.mTouchPointX = (float) i2;
        }
    }

    private void createGradient() {
        if (getWidth() > 0) {
            LinearGradient linearGradient = new LinearGradient((float) this.mGradientColorStartX, 0.0f, (float) this.mGradientColorEndX, 0.0f, this.gradientColors, (float[]) null, Shader.TileMode.CLAMP);
            this.gradient = linearGradient;
            this.mGradientPaint.setShader(linearGradient);
        }
    }

    private int[] generateSaturationGradient(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            fArr[1] = 0.003921569f * ((float) i2);
            iArr[i2] = Color.HSVToColor(fArr);
        }
        return iArr;
    }

    private int getColorByS(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = f;
        return Color.HSVToColor(fArr);
    }

    private int getFullSVColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = 1.0f;
        fArr[2] = 1.0f;
        return Color.HSVToColor(fArr);
    }

    private float getSaturationForColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[1];
    }

    private void init() {
        this.gradientColors = generateSaturationGradient(-65536);
        this.mGradientPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mTouchPointPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.mTouchPointPaint.setStrokeWidth((float) ((int) ResourceUtils.dp2px(4.0f, getContext())));
        this.mTouchPointPaint.setColor(-1);
        Paint paint2 = new Paint(1);
        this.mStrokePaint = paint2;
        paint2.setStyle(style);
        this.mStrokePaint.setStrokeWidth(ResourceUtils.dp2px(1.0f, getContext()));
        this.mStrokePaint.setColor(ContextCompat.getColor(getContext(), R.color.fd_sys_color_outline_variant_default));
        this.mTouchPointRadius = (int) ResourceUtils.dp2px(14.0f, getContext());
        int dp2px = (int) ResourceUtils.dp2px(8.0f, getContext());
        this.mPadding = dp2px;
        this.mTouchPointX = (float) (dp2px + this.mTouchPointRadius);
        this.mLeftSpaceDrawable = getContext().getDrawable(R.drawable.color_adjust_view_left_space_bkg);
        this.mRightSpaceDrawable = getContext().getDrawable(R.drawable.color_adjust_view_right_space_bkg);
        ColorManager.getInstance().addListener(this);
    }

    private void setColor(int i) {
        this.gradientColors = generateSaturationGradient(getFullSVColor(i));
        int colorByS = getColorByS(getFullSVColor(i), 0.0f);
        int colorByS2 = getColorByS(getFullSVColor(i), 1.0f);
        this.mLeftSpaceDrawable.setTint(colorByS);
        this.mRightSpaceDrawable.setTint(colorByS2);
        createGradient();
        float saturationForColor = (((float) this.mGradientColorWidth) * getSaturationForColor(i)) + ((float) this.mGradientColorStartX);
        this.mTouchPointX = saturationForColor;
        adjustTouchX(saturationForColor);
        invalidate();
    }

    public void onColorChanged(int i) {
        setColor(i);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect((float) this.mGradientColorStartX, 0.0f, (float) this.mGradientColorEndX, (float) getHeight(), this.mGradientPaint);
        this.mLeftSpaceDrawable.setBounds(0, 0, this.mGradientColorStartX, getHeight());
        this.mLeftSpaceDrawable.draw(canvas);
        this.mRightSpaceDrawable.setBounds(this.mGradientColorEndX, 0, getWidth(), getHeight());
        this.mRightSpaceDrawable.draw(canvas);
        canvas.drawCircle(this.mTouchPointX, (float) this.centerY, (float) this.mTouchPointRadius, this.mTouchPointPaint);
        canvas.drawCircle(this.mTouchPointX, (float) this.centerY, ((float) this.mTouchPointRadius) + (this.mTouchPointPaint.getStrokeWidth() / 2.0f), this.mStrokePaint);
        canvas.drawCircle(this.mTouchPointX, (float) this.centerY, ((float) this.mTouchPointRadius) - (this.mTouchPointPaint.getStrokeWidth() / 2.0f), this.mStrokePaint);
        canvas.drawRoundRect(this.mStrokePaint.getStrokeWidth(), this.mStrokePaint.getStrokeWidth(), ((float) getWidth()) - this.mStrokePaint.getStrokeWidth(), ((float) getHeight()) - this.mStrokePaint.getStrokeWidth(), (float) (getHeight() / 2), (float) (getHeight() / 2), this.mStrokePaint);
    }

    public void onLightChange(float f) {
    }

    public void onSaturationChange(float f) {
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mGradientColorWidth = (int) (((double) getWidth()) * 0.88d);
        this.mGradientColorStartX = (int) (((double) getWidth()) * 0.06d);
        this.mGradientColorEndX = (int) (((double) getWidth()) * 0.94d);
        createGradient();
        this.centerY = i2 / 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        if (r0 != 2) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x000b
            r2 = 2
            if (r0 == r2) goto L_0x0012
            goto L_0x0038
        L_0x000b:
            android.view.ViewParent r0 = r3.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x0012:
            float r4 = r4.getX()
            r3.adjustTouchX(r4)
            float r4 = r3.mTouchPointX
            int r0 = r3.mGradientColorStartX
            float r0 = (float) r0
            float r4 = r4 - r0
            int r0 = r3.mGradientColorWidth
            float r0 = (float) r0
            float r4 = r4 / r0
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r0, r4)
            r0 = 0
            float r4 = java.lang.Math.max(r0, r4)
            flyme.support.v7.app.palette.ColorManager r0 = flyme.support.v7.app.palette.ColorManager.getInstance()
            r0.setCurrentSaturation(r4)
            r3.invalidate()
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.app.palette.ColorSaturationAdjustView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
