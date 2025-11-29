package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f1326a;
    public final /* synthetic */ SpecialEffectsController.Operation b;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect c;

    public /* synthetic */ e(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
        this.f1326a = operation;
        this.b = operation2;
        this.c = transitionEffect;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.p(this.f1326a, this.b, this.c);
    }
}
