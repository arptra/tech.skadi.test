package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController f1331a;
    public final /* synthetic */ SpecialEffectsController.FragmentStateManagerOperation b;

    public /* synthetic */ j(SpecialEffectsController specialEffectsController, SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation) {
        this.f1331a = specialEffectsController;
        this.b = fragmentStateManagerOperation;
    }

    public final void run() {
        SpecialEffectsController.h(this.f1331a, this.b);
    }
}
