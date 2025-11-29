package com.honey.account.w8;

import android.content.Context;
import com.upuphone.xr.sapp.utils.BuglyManager;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7642a;

    public /* synthetic */ c(Context context) {
        this.f7642a = context;
    }

    public final void run() {
        BuglyManager.h(this.f7642a);
    }
}
