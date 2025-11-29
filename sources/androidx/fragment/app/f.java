package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.DefaultSpecialEffectsController;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentTransitionImpl f1327a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Rect c;

    public /* synthetic */ f(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.f1327a = fragmentTransitionImpl;
        this.b = view;
        this.c = rect;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.q(this.f1327a, this.b, this.c);
    }
}
