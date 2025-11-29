package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    public final DecorToolbar f183a;
    public final Window.Callback b;
    public final AppCompatDelegateImpl.ActionBarMenuCallback c;
    public boolean d;
    public boolean e;
    public boolean f;
    public ArrayList g = new ArrayList();
    public final Runnable h = new Runnable() {
        public void run() {
            ToolbarActionBar.this.B();
        }
    };
    public final Toolbar.OnMenuItemClickListener i;

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f186a;

        public ActionMenuPresenterCallback() {
        }

        public boolean a(MenuBuilder menuBuilder) {
            ToolbarActionBar.this.b.onMenuOpened(108, menuBuilder);
            return true;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (!this.f186a) {
                this.f186a = true;
                ToolbarActionBar.this.f183a.dismissPopupMenus();
                ToolbarActionBar.this.b.onPanelClosed(108, menuBuilder);
                this.f186a = false;
            }
        }
    }

    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        public MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f183a.isOverflowMenuShowing()) {
                ToolbarActionBar.this.b.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.b.onPreparePanel(0, (View) null, menuBuilder)) {
                ToolbarActionBar.this.b.onMenuOpened(108, menuBuilder);
            }
        }
    }

    public class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        public ToolbarMenuCallback() {
        }

        public boolean a(int i) {
            if (i != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.d) {
                return false;
            }
            toolbarActionBar.f183a.setMenuPrepared();
            ToolbarActionBar.this.d = true;
            return false;
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(ToolbarActionBar.this.f183a.getContext());
            }
            return null;
        }
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        AnonymousClass2 r0 = new Toolbar.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                return ToolbarActionBar.this.b.onMenuItemSelected(0, menuItem);
            }
        };
        this.i = r0;
        Preconditions.h(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f183a = toolbarWidgetWrapper;
        this.b = (Window.Callback) Preconditions.h(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(r0);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.c = new ToolbarMenuCallback();
    }

    public final Menu A() {
        if (!this.e) {
            this.f183a.c(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.e = true;
        }
        return this.f183a.getMenu();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.A()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.MenuBuilder
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = r0
            androidx.appcompat.view.menu.MenuBuilder r1 = (androidx.appcompat.view.menu.MenuBuilder) r1
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            if (r1 == 0) goto L_0x0013
            r1.stopDispatchingItemsChanged()
        L_0x0013:
            r0.clear()     // Catch:{ all -> 0x0028 }
            android.view.Window$Callback r3 = r5.b     // Catch:{ all -> 0x0028 }
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            android.view.Window$Callback r5 = r5.b     // Catch:{ all -> 0x0028 }
            boolean r5 = r5.onPreparePanel(r4, r2, r0)     // Catch:{ all -> 0x0028 }
            if (r5 != 0) goto L_0x002d
            goto L_0x002a
        L_0x0028:
            r5 = move-exception
            goto L_0x0033
        L_0x002a:
            r0.clear()     // Catch:{ all -> 0x0028 }
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.startDispatchingItemsChanged()
        L_0x0032:
            return
        L_0x0033:
            if (r1 == 0) goto L_0x0038
            r1.startDispatchingItemsChanged()
        L_0x0038:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ToolbarActionBar.B():void");
    }

    public void C(int i2, int i3) {
        this.f183a.setDisplayOptions((i2 & i3) | ((~i3) & this.f183a.getDisplayOptions()));
    }

    public boolean a() {
        return this.f183a.hideOverflowMenu();
    }

    public boolean b() {
        if (!this.f183a.hasExpandedActionView()) {
            return false;
        }
        this.f183a.collapseActionView();
        return true;
    }

    public void c(boolean z) {
        if (z != this.f) {
            this.f = z;
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ActionBar.OnMenuVisibilityListener) this.g.get(i2)).onMenuVisibilityChanged(z);
            }
        }
    }

    public int d() {
        return this.f183a.getDisplayOptions();
    }

    public Context e() {
        return this.f183a.getContext();
    }

    public CharSequence f() {
        return this.f183a.getTitle();
    }

    public void g() {
        this.f183a.setVisibility(8);
    }

    public boolean h() {
        this.f183a.getViewGroup().removeCallbacks(this.h);
        ViewCompat.l0(this.f183a.getViewGroup(), this.h);
        return true;
    }

    public void i(Configuration configuration) {
        super.i(configuration);
    }

    public void j() {
        this.f183a.getViewGroup().removeCallbacks(this.h);
    }

    public boolean k(int i2, KeyEvent keyEvent) {
        Menu A = A();
        if (A == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        A.setQwertyMode(z);
        return A.performShortcut(i2, keyEvent, 0);
    }

    public boolean l(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            m();
        }
        return true;
    }

    public boolean m() {
        return this.f183a.showOverflowMenu();
    }

    public void n(Drawable drawable) {
        this.f183a.setBackgroundDrawable(drawable);
    }

    public void o(boolean z) {
    }

    public void p(boolean z) {
        C(z ? 4 : 0, 4);
    }

    public void q(boolean z) {
        C(z ? 2 : 0, 2);
    }

    public void r(boolean z) {
        C(z ? 8 : 0, 8);
    }

    public void s(int i2) {
        this.f183a.setNavigationContentDescription(i2);
    }

    public void t(int i2) {
        this.f183a.setNavigationIcon(i2);
    }

    public void u(Drawable drawable) {
        this.f183a.setNavigationIcon(drawable);
    }

    public void v(boolean z) {
    }

    public void w(boolean z) {
    }

    public void x(CharSequence charSequence) {
        this.f183a.setTitle(charSequence);
    }

    public void y(CharSequence charSequence) {
        this.f183a.setWindowTitle(charSequence);
    }
}
