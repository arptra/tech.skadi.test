package com.honey.account.c;

import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.result.contract.ActivityResultContract;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 f3017a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ActivityResultContract.SynchronousResult c;

    public /* synthetic */ g(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i, ActivityResultContract.SynchronousResult synchronousResult) {
        this.f3017a = componentActivity$activityResultRegistry$1;
        this.b = i;
        this.c = synchronousResult;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.s(this.f3017a, this.b, this.c);
    }
}
