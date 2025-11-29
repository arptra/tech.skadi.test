package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1377a;
    public final ClassesInfoCache.CallbackInfo b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1377a = obj;
        this.b = ClassesInfoCache.c.c(obj.getClass());
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.b.a(lifecycleOwner, event, this.f1377a);
    }
}
