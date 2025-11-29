package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.RequiresApi;

@RequiresApi
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroupOverlay f1879a;

    public ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.f1879a = viewGroup.getOverlay();
    }

    public void add(Drawable drawable) {
        this.f1879a.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.f1879a.remove(drawable);
    }

    public void add(View view) {
        this.f1879a.add(view);
    }

    public void remove(View view) {
        this.f1879a.remove(view);
    }
}
