package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f1324a;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect b;

    public /* synthetic */ c(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
        this.f1324a = operation;
        this.b = transitionEffect;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.A(this.f1324a, this.b);
    }
}
