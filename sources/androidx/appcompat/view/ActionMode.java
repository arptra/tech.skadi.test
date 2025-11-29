package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public Object f210a;
    public boolean b;

    public interface Callback {
        boolean a(ActionMode actionMode, Menu menu);

        boolean b(ActionMode actionMode, MenuItem menuItem);

        boolean c(ActionMode actionMode, Menu menu);

        void d(ActionMode actionMode);
    }

    public abstract void a();

    public abstract View b();

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.f210a;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.b;
    }

    public abstract void i();

    public boolean j() {
        return false;
    }

    public abstract void k(View view);

    public abstract void l(int i);

    public abstract void m(CharSequence charSequence);

    public void n(Object obj) {
        this.f210a = obj;
    }

    public abstract void o(int i);

    public abstract void p(CharSequence charSequence);

    public void q(boolean z) {
        this.b = z;
    }
}
