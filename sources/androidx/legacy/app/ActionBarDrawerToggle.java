package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    public static final int[] g = {16843531};

    /* renamed from: a  reason: collision with root package name */
    public final Activity f1336a;
    public final Delegate b;
    public boolean c;
    public SlideDrawable d;
    public final int e;
    public final int f;

    @Deprecated
    public interface Delegate {
        void setActionBarDescription(int i);
    }

    @Deprecated
    public interface DelegateProvider {
    }

    public static class SetIndicatorInfo {
    }

    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1337a;
        public final Rect b;
        public float c;
        public float d;
        public final /* synthetic */ ActionBarDrawerToggle e;

        public float a() {
            return this.c;
        }

        public void b(float f) {
            this.c = f;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            copyBounds(this.b);
            canvas.save();
            int i = 1;
            boolean z = ViewCompat.z(this.e.f1336a.getWindow().getDecorView()) == 1;
            if (z) {
                i = -1;
            }
            float width = (float) this.b.width();
            canvas.translate((-this.d) * width * this.c * ((float) i), 0.0f);
            if (z && !this.f1337a) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    private void a(int i) {
        Delegate delegate = this.b;
        if (delegate != null) {
            delegate.setActionBarDescription(i);
            return;
        }
        ActionBar actionBar = this.f1336a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    public void onDrawerClosed(View view) {
        this.d.b(0.0f);
        if (this.c) {
            a(this.e);
        }
    }

    public void onDrawerOpened(View view) {
        this.d.b(1.0f);
        if (this.c) {
            a(this.f);
        }
    }

    public void onDrawerSlide(View view, float f2) {
        float a2 = this.d.a();
        this.d.b(f2 > 0.5f ? Math.max(a2, Math.max(0.0f, f2 - 0.5f) * 2.0f) : Math.min(a2, f2 * 2.0f));
    }

    public void onDrawerStateChanged(int i) {
    }
}
