package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f1329a;
    public final /* synthetic */ ViewGroup b;

    public /* synthetic */ h(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
        this.f1329a = transitionEffect;
        this.b = viewGroup;
    }

    public final void run() {
        DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass2.invoke$lambda$2(this.f1329a, this.b);
    }
}
