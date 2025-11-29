package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f1323a;

    public /* synthetic */ b(Ref.ObjectRef objectRef) {
        this.f1323a = objectRef;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.z(this.f1323a);
    }
}
