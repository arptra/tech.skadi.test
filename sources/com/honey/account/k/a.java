package com.honey.account.k;

import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewTransition f3065a;
    public final /* synthetic */ View[] b;

    public /* synthetic */ a(ViewTransition viewTransition, View[] viewArr) {
        this.f3065a = viewTransition;
        this.b = viewArr;
    }

    public final void run() {
        this.f3065a.j(this.b);
    }
}
