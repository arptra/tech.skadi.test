package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import java.util.ArrayList;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1328a;

    public /* synthetic */ g(ArrayList arrayList) {
        this.f1328a = arrayList;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.r(this.f1328a);
    }
}
