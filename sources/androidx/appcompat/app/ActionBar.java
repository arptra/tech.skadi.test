package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ActionBar {

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i, long j);
    }

    @Deprecated
    public static abstract class Tab {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract int d();

        public abstract CharSequence e();

        public abstract void f();
    }

    @Deprecated
    public interface TabListener {
        void a(Tab tab, FragmentTransaction fragmentTransaction);

        void b(Tab tab, FragmentTransaction fragmentTransaction);

        void c(Tab tab, FragmentTransaction fragmentTransaction);
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public void c(boolean z) {
    }

    public abstract int d();

    public Context e() {
        return null;
    }

    public abstract CharSequence f();

    public abstract void g();

    public boolean h() {
        return false;
    }

    public void i(Configuration configuration) {
    }

    public void j() {
    }

    public boolean k(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean l(KeyEvent keyEvent) {
        return false;
    }

    public boolean m() {
        return false;
    }

    public abstract void n(Drawable drawable);

    public void o(boolean z) {
    }

    public abstract void p(boolean z);

    public abstract void q(boolean z);

    public abstract void r(boolean z);

    public void s(int i) {
    }

    public void t(int i) {
    }

    public void u(Drawable drawable) {
    }

    public void v(boolean z) {
    }

    public void w(boolean z) {
    }

    public abstract void x(CharSequence charSequence);

    public void y(CharSequence charSequence) {
    }

    public ActionMode z(ActionMode.Callback callback) {
        return null;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f139a = 8388627;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f139a = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f139a = layoutParams.f139a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
