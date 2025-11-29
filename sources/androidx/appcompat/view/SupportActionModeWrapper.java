package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f212a;
    public final ActionMode b;

    @RestrictTo
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f213a;
        public final Context b;
        public final ArrayList c = new ArrayList();
        public final SimpleArrayMap d = new SimpleArrayMap();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.f213a = callback;
        }

        public boolean a(ActionMode actionMode, Menu menu) {
            return this.f213a.onCreateActionMode(e(actionMode), f(menu));
        }

        public boolean b(ActionMode actionMode, MenuItem menuItem) {
            return this.f213a.onActionItemClicked(e(actionMode), new MenuItemWrapperICS(this.b, (SupportMenuItem) menuItem));
        }

        public boolean c(ActionMode actionMode, Menu menu) {
            return this.f213a.onPrepareActionMode(e(actionMode), f(menu));
        }

        public void d(ActionMode actionMode) {
            this.f213a.onDestroyActionMode(e(actionMode));
        }

        public android.view.ActionMode e(ActionMode actionMode) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) this.c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.b, actionMode);
            this.c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = (Menu) this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.b, (SupportMenu) menu);
            this.d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f212a = context;
        this.b = actionMode;
    }

    public void finish() {
        this.b.a();
    }

    public View getCustomView() {
        return this.b.b();
    }

    public Menu getMenu() {
        return new MenuWrapperICS(this.f212a, (SupportMenu) this.b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.b.d();
    }

    public CharSequence getSubtitle() {
        return this.b.e();
    }

    public Object getTag() {
        return this.b.f();
    }

    public CharSequence getTitle() {
        return this.b.g();
    }

    public boolean getTitleOptionalHint() {
        return this.b.h();
    }

    public void invalidate() {
        this.b.i();
    }

    public boolean isTitleOptional() {
        return this.b.j();
    }

    public void setCustomView(View view) {
        this.b.k(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.m(charSequence);
    }

    public void setTag(Object obj) {
        this.b.n(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.p(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.b.q(z);
    }

    public void setSubtitle(int i) {
        this.b.l(i);
    }

    public void setTitle(int i) {
        this.b.o(i);
    }
}
