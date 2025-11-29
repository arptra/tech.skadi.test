package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;

class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBarContainer f249a;

    @RequiresApi
    public static class Api21Impl {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f249a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f249a;
        if (actionBarContainer.h) {
            Drawable drawable = actionBarContainer.g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f249a;
        Drawable drawable3 = actionBarContainer2.f;
        if (drawable3 != null && actionBarContainer2.i) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f249a;
        if (!actionBarContainer.h) {
            Drawable drawable = actionBarContainer.e;
            if (drawable != null) {
                Api21Impl.a(drawable, outline);
            }
        } else if (actionBarContainer.g != null) {
            Api21Impl.a(actionBarContainer.e, outline);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
