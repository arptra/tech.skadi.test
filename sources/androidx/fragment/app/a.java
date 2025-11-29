package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1322a;
    public final /* synthetic */ View b;
    public final /* synthetic */ DefaultSpecialEffectsController.AnimationEffect c;

    public /* synthetic */ a(ViewGroup viewGroup, View view, DefaultSpecialEffectsController.AnimationEffect animationEffect) {
        this.f1322a = viewGroup;
        this.b = view;
        this.c = animationEffect;
    }

    public final void run() {
        DefaultSpecialEffectsController$AnimationEffect$onCommit$1.b(this.f1322a, this.b, this.c);
    }
}
