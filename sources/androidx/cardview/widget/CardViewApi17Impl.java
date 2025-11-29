package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

@RequiresApi
class CardViewApi17Impl extends CardViewBaseImpl {
    public void n() {
        RoundRectDrawableWithShadow.r = new RoundRectDrawableWithShadow.RoundRectHelper() {
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
