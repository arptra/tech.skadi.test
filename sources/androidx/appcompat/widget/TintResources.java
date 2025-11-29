package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper {
    public final WeakReference b;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.b = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable a2 = a(i);
        Context context = (Context) this.b.get();
        if (!(a2 == null || context == null)) {
            ResourceManagerInternal.g().w(context, i, a2);
        }
        return a2;
    }
}
