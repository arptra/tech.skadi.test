package com.honey.account.l7;

import android.content.Context;
import com.upuphone.runasone.host.api.InitApplication;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InitApplication f4931a;
    public final /* synthetic */ Context b;

    public /* synthetic */ a(InitApplication initApplication, Context context) {
        this.f4931a = initApplication;
        this.b = context;
    }

    public final void run() {
        this.f4931a.initLowPriority(this.b);
    }
}
