package com.honey.account.v;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController f3116a;
    public final /* synthetic */ SpecialEffectsController.Operation b;

    public /* synthetic */ a(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation) {
        this.f3116a = defaultSpecialEffectsController;
        this.b = operation;
    }

    public final void run() {
        DefaultSpecialEffectsController.G(this.f3116a, this.b);
    }
}
