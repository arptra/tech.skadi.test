package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.core.util.Preconditions;

public class FragmentController {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentHostCallback f1273a;

    public FragmentController(FragmentHostCallback fragmentHostCallback) {
        this.f1273a = fragmentHostCallback;
    }

    public static FragmentController b(FragmentHostCallback fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.i(fragmentHostCallback, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentManager g = this.f1273a.g();
        FragmentHostCallback fragmentHostCallback = this.f1273a;
        g.q(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void c() {
        this.f1273a.g().E();
    }

    public boolean d(MenuItem menuItem) {
        return this.f1273a.g().H(menuItem);
    }

    public void e() {
        this.f1273a.g().I();
    }

    public void f() {
        this.f1273a.g().K();
    }

    public void g() {
        this.f1273a.g().T();
    }

    public void h() {
        this.f1273a.g().X();
    }

    public void i() {
        this.f1273a.g().Y();
    }

    public void j() {
        this.f1273a.g().a0();
    }

    public boolean k() {
        return this.f1273a.g().h0(true);
    }

    public FragmentManager l() {
        return this.f1273a.g();
    }

    public void m() {
        this.f1273a.g().l1();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1273a.g().H0().onCreateView(view, str, context, attributeSet);
    }
}
