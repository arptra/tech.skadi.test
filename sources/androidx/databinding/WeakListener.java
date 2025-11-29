package androidx.databinding;

import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo
class WeakListener<T> extends WeakReference<ViewDataBinding> {

    /* renamed from: a  reason: collision with root package name */
    public final ObservableReference f986a;
    public final int b;
    public Object c;

    public ViewDataBinding a() {
        ViewDataBinding viewDataBinding = (ViewDataBinding) get();
        if (viewDataBinding == null) {
            c();
        }
        return viewDataBinding;
    }

    public Object b() {
        return this.c;
    }

    public boolean c() {
        boolean z;
        Object obj = this.c;
        if (obj != null) {
            this.f986a.b(obj);
            z = true;
        } else {
            z = false;
        }
        this.c = null;
        return z;
    }
}
