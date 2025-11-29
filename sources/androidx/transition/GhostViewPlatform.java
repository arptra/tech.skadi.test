package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;

@RequiresApi
class GhostViewPlatform implements GhostView {

    /* renamed from: a  reason: collision with root package name */
    public final View f1853a;

    public void a(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i) {
        this.f1853a.setVisibility(i);
    }
}
