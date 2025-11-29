package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a  reason: collision with root package name */
    public final Delegate f140a;
    public final DrawerLayout b;
    public DrawerArrowDrawable c;
    public boolean d;
    public boolean e;
    public final int f;
    public final int g;
    public View.OnClickListener h;

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$1  reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActionBarDrawerToggle f141a;

        public void onClick(View view) {
            ActionBarDrawerToggle actionBarDrawerToggle = this.f141a;
            if (actionBarDrawerToggle.e) {
                actionBarDrawerToggle.c();
                return;
            }
            View.OnClickListener onClickListener = actionBarDrawerToggle.h;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public interface Delegate {
        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    public interface DelegateProvider {
    }

    public static class FrameworkActionBarDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f142a;

        @RequiresApi
        public static class Api18Impl {
            @DoNotInline
            public static void a(ActionBar actionBar, int i) {
                actionBar.setHomeActionContentDescription(i);
            }

            @DoNotInline
            public static void b(ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        public void setActionBarDescription(int i) {
            ActionBar actionBar = this.f142a.getActionBar();
            if (actionBar != null) {
                Api18Impl.a(actionBar, i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar actionBar = this.f142a.getActionBar();
            if (actionBar != null) {
                Api18Impl.b(actionBar, drawable);
                Api18Impl.a(actionBar, i);
            }
        }
    }

    public static class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        public final Toolbar f143a;
        public final CharSequence b;

        public void setActionBarDescription(int i) {
            if (i == 0) {
                this.f143a.setNavigationContentDescription(this.b);
            } else {
                this.f143a.setNavigationContentDescription(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            this.f143a.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }
    }

    public void a(int i) {
        this.f140a.setActionBarDescription(i);
    }

    public final void b(float f2) {
        if (f2 == 1.0f) {
            this.c.g(true);
        } else if (f2 == 0.0f) {
            this.c.g(false);
        }
        this.c.setProgress(f2);
    }

    public void c() {
        int q = this.b.q(8388611);
        if (this.b.E(8388611) && q != 2) {
            this.b.d(8388611);
        } else if (q != 1) {
            this.b.J(8388611);
        }
    }

    public void onDrawerClosed(View view) {
        b(0.0f);
        if (this.e) {
            a(this.f);
        }
    }

    public void onDrawerOpened(View view) {
        b(1.0f);
        if (this.e) {
            a(this.g);
        }
    }

    public void onDrawerSlide(View view, float f2) {
        if (this.d) {
            b(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            b(0.0f);
        }
    }

    public void onDrawerStateChanged(int i) {
    }
}
