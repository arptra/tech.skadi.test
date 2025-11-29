package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController f1332a;
    public final /* synthetic */ SpecialEffectsController.FragmentStateManagerOperation b;

    public /* synthetic */ k(SpecialEffectsController specialEffectsController, SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation) {
        this.f1332a = specialEffectsController;
        this.b = fragmentStateManagerOperation;
    }

    public final void run() {
        SpecialEffectsController.i(this.f1332a, this.b);
    }
}
