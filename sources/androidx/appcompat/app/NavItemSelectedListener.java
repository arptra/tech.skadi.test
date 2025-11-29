package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBar.OnNavigationListener f182a;

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        ActionBar.OnNavigationListener onNavigationListener = this.f182a;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i, j);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
