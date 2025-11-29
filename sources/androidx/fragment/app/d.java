package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f1325a;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect b;

    public /* synthetic */ d(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
        this.f1325a = operation;
        this.b = transitionEffect;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.y(this.f1325a, this.b);
    }
}
