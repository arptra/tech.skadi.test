package flyme.support.v7.view.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.meizu.common.R;
import com.meizu.common.widget.NewMessagePainter;

public class ActionMenuItemIconDrawable extends ActionDrawableWrapper {
    private NewMessagePainter mNewMessagePainter;
    private final Paint mPaint;
    private final int mSpotColor = -65536;
    private int mSpotCount;
    private final float mSpotRadius;
    private boolean mSpotVisible;

    public ActionMenuItemIconDrawable(Context context, Drawable drawable) {
        super(drawable);
        this.mSpotRadius = context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        NewMessagePainter newMessagePainter = new NewMessagePainter(context);
        this.mNewMessagePainter = newMessagePainter;
        newMessagePainter.setShowBorder(true);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.mSpotVisible) {
            Rect bounds = super.getBounds();
            canvas.save();
            int width = this.mNewMessagePainter.getWidth();
            int height = this.mNewMessagePainter.getHeight();
            if (this.mSpotCount > 0) {
                canvas.translate((float) (bounds.right - (width >> 1)), (float) (bounds.top - (height >> 1)));
            } else {
                canvas.translate((float) (bounds.right - width), (float) bounds.top);
            }
            this.mNewMessagePainter.draw(canvas);
            canvas.restore();
        }
    }

    public int getSpotCount() {
        return this.mSpotCount;
    }

    public void measureSpot() {
        this.mNewMessagePainter.measure();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.mNewMessagePainter.setAlpha(i);
    }

    public void setSpotCount(int i) {
        this.mSpotCount = i;
        this.mNewMessagePainter.setNewMessageNum(i);
        if (i <= 0) {
            this.mNewMessagePainter.setCurrentStage(0);
        } else {
            this.mNewMessagePainter.setCurrentStage(1);
        }
    }

    public void setSpotVisible(boolean z) {
        this.mSpotVisible = z;
    }
}
