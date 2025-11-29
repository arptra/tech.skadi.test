package flyme.support.v7.app.palette;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.meizu.common.util.ResourceUtils;

public class ColorGridView extends View {
    private int centerX;
    private int centerY;
    private int[][] colors;
    private final Paint mCenterMarkPaint;
    private int mCenterMarkRadius;
    private final RectF mCenterMarkRect;
    private final Path mCirclePath = new Path();
    private int mCircleRadius;
    private final Paint mGridColorPaint = new Paint(1);
    private int mGridSize;
    private final Paint mStrokePaint;

    public ColorGridView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.mStrokePaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(ResourceUtils.dp2px(4.0f, getContext()));
        paint.setColor(-1711276033);
        this.mCenterMarkRect = new RectF();
        Paint paint2 = new Paint(1);
        this.mCenterMarkPaint = paint2;
        paint2.setStyle(style);
        paint2.setStrokeWidth(ResourceUtils.dp2px(4.0f, getContext()));
        paint2.setColor(-1);
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (this.colors != null) {
            canvas2.clipPath(this.mCirclePath);
            for (int i = 0; i < 7; i++) {
                for (int i2 = 0; i2 < 7; i2++) {
                    this.mGridColorPaint.setColor(this.colors[i][i2]);
                    int i3 = this.mGridSize;
                    int i4 = i2 * i3;
                    int i5 = i * i3;
                    int i6 = i4 + i3;
                    int i7 = i3 + i5;
                    if (i == 3 && i2 == 3) {
                        RectF rectF = this.mCenterMarkRect;
                        int i8 = this.mCenterMarkRadius;
                        rectF.set((float) (i4 - i8), (float) (i5 - i8), (float) (i6 + i8), (float) (i8 + i7));
                    }
                    canvas.drawRect((float) i4, (float) i5, (float) i6, (float) i7, this.mGridColorPaint);
                }
            }
            canvas2.drawCircle((float) this.centerX, (float) this.centerY, (float) this.mCircleRadius, this.mStrokePaint);
            RectF rectF2 = this.mCenterMarkRect;
            int i9 = this.mCenterMarkRadius;
            canvas2.drawRoundRect(rectF2, (float) i9, (float) i9, this.mCenterMarkPaint);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i / 2;
        this.centerX = i5;
        this.centerY = i2 / 2;
        this.mGridSize = i / 7;
        int dp2px = (int) (((float) i5) - ResourceUtils.dp2px(2.0f, getContext()));
        this.mCircleRadius = dp2px;
        this.mCirclePath.addCircle(((float) i) / 2.0f, ((float) i2) / 2.0f, (float) dp2px, Path.Direction.CW);
        this.mCenterMarkRadius = (int) ResourceUtils.dp2px(2.0f, getContext());
    }

    public void setColors(int[][] iArr) {
        this.colors = iArr;
        invalidate();
    }
}
