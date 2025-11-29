package flyme.support.v7.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EmptyDivider extends Drawable {
    private int mDividerHeight;
    private int mDividerWidth;

    public void draw(@NonNull Canvas canvas) {
    }

    public int getIntrinsicHeight() {
        return this.mDividerHeight;
    }

    public int getIntrinsicWidth() {
        return this.mDividerWidth;
    }

    public int getOpacity() {
        return -2;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void setDividerHeight(int i) {
        this.mDividerHeight = i;
    }

    public void setDividerWidth(int i) {
        this.mDividerWidth = i;
    }
}
