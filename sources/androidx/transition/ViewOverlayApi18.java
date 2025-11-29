package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.RequiresApi;

@RequiresApi
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    public final ViewOverlay f1882a;

    public ViewOverlayApi18(View view) {
        this.f1882a = view.getOverlay();
    }

    public void add(Drawable drawable) {
        this.f1882a.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.f1882a.remove(drawable);
    }
}
