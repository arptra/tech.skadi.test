package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    public static Method h;

    public WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        g();
    }

    public boolean c() {
        return false;
    }

    public final void g() {
        if (h == null) {
            try {
                h = Drawable.class.getDeclaredMethod("isProjected", (Class[]) null);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    public Rect getDirtyBounds() {
        return this.f.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f;
        if (drawable == null || (method = h) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            return false;
        }
    }

    public void setHotspot(float f, float f2) {
        this.f.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (c()) {
            super.setTint(i);
        } else {
            this.f.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f.setTintMode(mode);
        }
    }
}
