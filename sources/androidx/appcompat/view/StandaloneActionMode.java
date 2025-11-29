package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

@RestrictTo
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    public Context c;
    public ActionBarContextView d;
    public ActionMode.Callback e;
    public WeakReference f;
    public boolean g;
    public boolean h;
    public MenuBuilder i;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.c = context;
        this.d = actionBarContextView;
        this.e = callback;
        MenuBuilder defaultShowAsAction = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.i = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.h = z;
    }

    public void a() {
        if (!this.g) {
            this.g = true;
            this.e.d(this);
        }
    }

    public View b() {
        WeakReference weakReference = this.f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public Menu c() {
        return this.i;
    }

    public MenuInflater d() {
        return new SupportMenuInflater(this.d.getContext());
    }

    public CharSequence e() {
        return this.d.getSubtitle();
    }

    public CharSequence g() {
        return this.d.getTitle();
    }

    public void i() {
        this.e.c(this, this.i);
    }

    public boolean j() {
        return this.d.k();
    }

    public void k(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference(view) : null;
    }

    public void l(int i2) {
        m(this.c.getString(i2));
    }

    public void m(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    public void o(int i2) {
        p(this.c.getString(i2));
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.e.b(this, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        i();
        this.d.g();
    }

    public void p(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    public void q(boolean z) {
        super.q(z);
        this.d.setTitleOptional(z);
    }
}
