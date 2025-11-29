package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo
public class MenuPopupHelper implements MenuHelper {

    /* renamed from: a  reason: collision with root package name */
    public final Context f242a;
    public final MenuBuilder b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public int g;
    public boolean h;
    public MenuPresenter.Callback i;
    public MenuPopup j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l;

    @RequiresApi
    public static class Api17Impl {
        @DoNotInline
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i2) {
        this(context, menuBuilder, view, z, i2, 0);
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.appcompat.view.menu.MenuPopup, androidx.appcompat.view.menu.MenuPresenter] */
    /* JADX WARNING: type inference failed for: r8v1, types: [androidx.appcompat.view.menu.StandardMenuPopup] */
    /* JADX WARNING: type inference failed for: r2v2, types: [androidx.appcompat.view.menu.CascadingMenuPopup] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.appcompat.view.menu.MenuPopup a() {
        /*
            r15 = this;
            android.content.Context r0 = r15.f242a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            androidx.appcompat.view.menu.MenuPopupHelper.Api17Impl.a(r0, r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r15.f242a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R.dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x003d
            androidx.appcompat.view.menu.CascadingMenuPopup r0 = new androidx.appcompat.view.menu.CascadingMenuPopup
            android.content.Context r3 = r15.f242a
            android.view.View r4 = r15.f
            int r5 = r15.d
            int r6 = r15.e
            boolean r7 = r15.c
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x004f
        L_0x003d:
            androidx.appcompat.view.menu.StandardMenuPopup r0 = new androidx.appcompat.view.menu.StandardMenuPopup
            android.content.Context r9 = r15.f242a
            androidx.appcompat.view.menu.MenuBuilder r10 = r15.b
            android.view.View r11 = r15.f
            int r12 = r15.d
            int r13 = r15.e
            boolean r14 = r15.c
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)
        L_0x004f:
            androidx.appcompat.view.menu.MenuBuilder r1 = r15.b
            r0.a(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r15.l
            r0.j(r1)
            android.view.View r1 = r15.f
            r0.e(r1)
            androidx.appcompat.view.menu.MenuPresenter$Callback r1 = r15.i
            r0.setCallback(r1)
            boolean r1 = r15.h
            r0.g(r1)
            int r15 = r15.g
            r0.h(r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuPopupHelper.a():androidx.appcompat.view.menu.MenuPopup");
    }

    public void b() {
        if (d()) {
            this.j.dismiss();
        }
    }

    public MenuPopup c() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean d() {
        MenuPopup menuPopup = this.j;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f = view;
    }

    public void g(boolean z) {
        this.h = z;
        MenuPopup menuPopup = this.j;
        if (menuPopup != null) {
            menuPopup.g(z);
        }
    }

    public void h(int i2) {
        this.g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void j(MenuPresenter.Callback callback) {
        this.i = callback;
        MenuPopup menuPopup = this.j;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i2, int i3, boolean z, boolean z2) {
        MenuPopup c2 = c();
        c2.k(z2);
        if (z) {
            if ((GravityCompat.b(this.g, ViewCompat.z(this.f)) & 7) == 5) {
                i2 -= this.f.getWidth();
            }
            c2.i(i2);
            c2.l(i3);
            int i4 = (int) ((this.f242a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.f(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        c2.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i2, int i3) {
        this.g = 8388611;
        this.l = new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MenuPopupHelper.this.e();
            }
        };
        this.f242a = context;
        this.b = menuBuilder;
        this.f = view;
        this.c = z;
        this.d = i2;
        this.e = i3;
    }
}
