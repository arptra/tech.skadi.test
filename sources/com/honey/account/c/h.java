package com.honey.account.c;

import android.content.IntentSender;
import androidx.activity.ComponentActivity$activityResultRegistry$1;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 f3018a;
    public final /* synthetic */ int b;
    public final /* synthetic */ IntentSender.SendIntentException c;

    public /* synthetic */ h(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i, IntentSender.SendIntentException sendIntentException) {
        this.f3018a = componentActivity$activityResultRegistry$1;
        this.b = i;
        this.c = sendIntentException;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.t(this.f3018a, this.b, this.c);
    }
}
